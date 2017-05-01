/*
 * Copyright (c) 2016 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.cheesefinder;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class CheeseActivity extends BaseSearchActivity {

    private Disposable mDisposable;

    /**
     * Creates an Observable used to 'listen' events on the search button (clicks) and triggers
     * a search that notifies results to the subscribed emitter.
     */
    private Observable<String> createButtonClickObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> e) throws Exception {
                mSearchButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        e.onNext(mQueryEditText.getText().toString());
                    }
                });

                e.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        mSearchButton.setOnClickListener(null);
                    }
                });
            }
        });
    }


    private Observable<String> createTextChangeObservable() {
        Observable<String> textChangedObserbable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> e) throws Exception {
                final TextWatcher textWatcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        e.onNext(s.toString());
                    }
                };
                mQueryEditText.addTextChangedListener(textWatcher);

                e.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        mQueryEditText.removeTextChangedListener(textWatcher);
                    }
                });
            }
        });
        return textChangedObserbable
                // filter is an operator. Filters the items emission based on the boolean
                // returned by Predicate.test(T)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.length() >= 2;
                    }
                })
                // debounce is another operator. Waits for a specified amount of time after
                // each item emission for another item. If no item happens to be emitted
                // during this wait, the last item is finally emitted
                .debounce(1000, TimeUnit.MILLISECONDS);
    }


    @Override
    protected void onStart() {
        super.onStart();

        Observable<String> buttonClickStream = createButtonClickObservable();
        Observable<String> textChangeStream = createTextChangeObservable();

        Observable<String> observable = Observable.merge(buttonClickStream, textChangeStream);
        mDisposable = observable
                // Notify on UI thread - observeOn can be called endless times
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        showProgressBar();
                    }
                })
                // ask the observable to execute the work in the I/O thread.
                .observeOn(Schedulers.io())
                .map(new Function<String, List<String>>() {

                    @Override
                    public List<String> apply(String s) throws Exception {
                        return mCheeseSearchEngine.search(s);
                    }
                })
                // events will be notified in the Main Application Thread.
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        hideProgressBar();
                        showResult(strings);
                    }
                });
    }

    @Override
    protected void onStop() {
        if(!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
        super.onStop();
    }
}
