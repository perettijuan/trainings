package com.example.jpp.drawingincanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.graphics.drawable.VectorDrawableCompat;
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

    private VectorDrawableCompat mImage;
    private float mImageX;
    private float mImageY;

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


    private void init() {
        mStrokeWidth = 2;
        mRingPaint = new Paint();
        mRingPaint.setColor(Color.WHITE);
        mRingPaint.setStrokeWidth(mStrokeWidth);
        mRingPaint.setStyle(Paint.Style.STROKE);
        mRingPaint.setAntiAlias(true);

        mImage = VectorDrawableCompat.create(getResources(), R.drawable.ic_globe, null);
        mImage.setTint(Color.WHITE);
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

        /*
         * The VectorDrawable represented by mImage can be pictured as a square
         * with the half height of the total custom view and the half width
         * of the total width of the custom view.
         */
        Rect imageSquare = new Rect(0, 0, w / 2, h / 2);
        mImage.setBounds(imageSquare);

        /*
         * To draw the VectorDrawable centered inside the circle, we need to translate
         * the canvas to a given position that represents the xStart and yStart coordinate
         * of the rectangle.
         */
        mImageX = mCenterX - (imageSquare.width() / 2);
        mImageY = mCenterY - (imageSquare.height() / 2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // draw the circle
        canvas.drawCircle(mCenterX, mCenterY, mRadius, mRingPaint);
        // draw the image
        canvas.translate(mImageX, mImageY);
        mImage.draw(canvas);
    }
}
