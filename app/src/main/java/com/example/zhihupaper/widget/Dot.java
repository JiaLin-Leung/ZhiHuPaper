package com.example.zhihupaper.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.zhihupaper.R;

/**
 * Created by xubinhong on 2018/1/12.
 */

public class Dot extends View {
    public Dot(Context context) {
        super(context);
        mPaint.setColor(getResources().getColor(R.color.colorGray));
    }

    public Dot(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(getResources().getColor(R.color.colorGray));
    }

    public Dot(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setColor(getResources().getColor(R.color.colorGray));
    }

    public Dot(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mPaint.setColor(getResources().getColor(R.color.colorGray));
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(width / 2, height / 2, radius, mPaint);
    }

    public void setChecked(boolean checked) {
        if (checked) {
            mPaint.setColor(getResources().getColor(R.color.colorWhite));
        } else {
            mPaint.setColor(getResources().getColor(R.color.colorGray));
        }
        invalidate();
    }
}
