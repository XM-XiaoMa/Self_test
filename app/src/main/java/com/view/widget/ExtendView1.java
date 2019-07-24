package com.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by mbc on 19-5-30
 * 描述： 1.框框绘制 2. 渐变渲染
 */
public class ExtendView1 extends android.support.v7.widget.AppCompatTextView {

    private int viewWidth;
    private Matrix gradientMatrix;
    private int translate;
    private LinearGradient linearGradient;

    public ExtendView1(Context context) {
        super(context);
    }

    public ExtendView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 回调该方法进行控件测量
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 绘制工作：层层往上
        // 系统绘制前，实现自定义绘制流程
        Paint paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.YELLOW);


        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint2);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint1);

        canvas.save();
//        canvas.translate(10, 0);
        super.onDraw(canvas);
        // 系统绘制后，实现自定义绘制流程
        if (gradientMatrix != null) {
            translate += viewWidth / 5;
            if (translate > 2 * viewWidth) {
                translate = -viewWidth;
            }
            gradientMatrix.setTranslate(translate, 0);
            linearGradient.setLocalMatrix(gradientMatrix);
            postInvalidateDelayed(100);
        }
        canvas.restore();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        // 回调该方法确定控件显示的位置
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // 从XML组件加载组件后的回调
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 组件大小改变时回调
        if (viewWidth == 0) {
            viewWidth = getMeasuredWidth();
            Paint paint = getPaint();
            linearGradient = new LinearGradient(0, 0, viewWidth, 0, new int[]{Color.RED, Color.WHITE
                    , Color.RED}, null, Shader.TileMode.CLAMP);
            // 获取绘制TextView的paint , 并设置一个新的渲染器属性
            paint.setShader(linearGradient);
            gradientMatrix = new Matrix();
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
        // 触摸事件的回调
    }
}
