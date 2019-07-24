package com.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mbc on 19-5-31
 * Description: 项目比例图 - 圆形
 */
public class CircleView1 extends View {

    private int length;
    private int circleXY;
    private float radius;
    private RectF arcRectF;
    private int sweepAngle = 260;


    public CircleView1(Context context) {
        super(context);
    }

    public CircleView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        length = getMeasuredWidth();
        circleXY = length / 2;
        radius = (float) (length * 0.5 / 2);
        // 指定园的外接矩形
        arcRectF = new RectF(
                (float) (length * 0.1),
                (float) (length * 0.1),
                (float) (length * 0.9),
                (float) (length * 0.9)
        );

        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.GREEN);
        Paint arcPaint = new Paint();
        arcPaint.setColor(Color.GREEN);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(10);
        Paint textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(12);
        textPaint.setTextAlign(Paint.Align.CENTER);
        // 绘制文字，指定好文字的其实绘制位置
        // 绘制圆
        canvas.drawCircle(circleXY, circleXY, radius, circlePaint);
        // 绘制弧线
        canvas.drawArc(arcRectF, 270, sweepAngle, false, arcPaint);
        // 绘制文字

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float distance = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;
        float baseline = arcRectF.centerY() + distance;
        canvas.drawText("70%", arcRectF.centerX(), baseline, textPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    public void setSweepAngle(int sweepAngle) {
        if (sweepAngle != 0) {

            this.sweepAngle = sweepAngle;
        } else {
            this.sweepAngle = 25;
        }
        this.invalidate();
    }
}
