package com.example.jpp.constraintlayoutexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }


    public void onBasicExamplesSelected(View view) {
        startActivity(new Intent(this, BasicExamplesActivity.class));
    }


    public void onAnimationsExamplesSelected(View view) {
        startActivity(new Intent(this, AnimationsActivity.class));
    }


}
