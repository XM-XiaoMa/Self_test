package com.view.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mbc on 19-5-31
 * Description:
 */
public class MusicView1 extends View {

    public MusicView1(Context context) {
        super(context);
    }

    public MusicView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * onDraw onLayout内部不应创建对象，对象应该提前创建好，下面高亮就是这个原因
         */
        Paint rectPaint = new Paint();
        rectPaint.setColor(Color.GREEN);
        float holeWidth = getMeasuredWidth();
        float rectWidth = 10;
        float offset = 2;
        float rectHeight = 100;
        LinearGradient linearGradient = new LinearGradient(0, 0, rectWidth, rectHeight, Color.YELLOW, Color.BLUE, Shader.TileMode.CLAMP);
        rectPaint.setShader(linearGradient);
        int rectCount = 10;
        for (int i = 0; i < rectCount; i++) {
            float currentHeight = (float) (rectHeight * Math.random());
            canvas.drawRect(
                    (rectWidth * i + offset),
                    currentHeight,
                    (float) (rectWidth * (i + 1)),
                    rectHeight,
                    rectPaint
            );
        }
        postInvalidateDelayed(300);
    }
}
