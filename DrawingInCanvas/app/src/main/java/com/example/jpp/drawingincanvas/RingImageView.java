package com.example.jpp.drawingincanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Custom view that draws an image centered and a ring around it.
 */
public class RingImageView extends View {

    private Paint mRingPaint;
    private int mCenterX;
    private int mCenterY;
    private int mRadius;
    private float mStrokeWidth;

    public RingImageView(Context context) {
        super(context);
        init();
    }

    public RingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }



    private void init() {
        mStrokeWidth = 4;
        mRingPaint = new Paint();
        mRingPaint.setColor(Color.WHITE);
        mRingPaint.setStrokeWidth(mStrokeWidth);
        mRingPaint.setStyle(Paint.Style.STROKE);
        mRingPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (w == oldw && h == oldh) {
            return;
        }

        mCenterX = w / 2;
        mCenterY = h / 2;
        mRadius = (int) ((w / 2) - mStrokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(mCenterX, mCenterY, mRadius, mRingPaint);
    }
}
