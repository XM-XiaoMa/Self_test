package com.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mbc on 19-5-31
 * Description:
 * 1. 实现ScrollView效果
 * 2. 上下滑动具有粘性效果
 * 3. 子View向上滑动大于一定距离，松开手指自动向上滑动，显示下个子View
 * 4. 子View向上滑动小于一定距离，松开手指自动滑动到开始的位置
 * <p>
 * -》放置好子View
 * -》设置子View高度
 * -》遍历子View的onLayout方法
 */
public class CustomScrollView extends ViewGroup {

    private int childCount;
    private float lastY;
    private int screenHeight;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 测量子View
        childCount = getChildCount();
        for (int i = 0; i < childCount; ++i) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // 设置ViewGroup的高度
        screenHeight = getMeasuredHeight();
        MarginLayoutParams mip = (MarginLayoutParams) getLayoutParams();
        mip.height = screenHeight * childCount;
        setLayoutParams(mip);
        // 遍历子View，调用子View的onLayout方法，将宽高参数传入
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() != View.GONE) {
                childView.layout(l, i * screenHeight, r, (i + 1) * screenHeight);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float dy = lastY - event.getY();
                scrollBy(0, (int) dy);
                if (getScrollY() < 0) {
                    dy = 0;
                }
                if (getScrollY() > getHeight() - screenHeight) {
                    dy = 0;
                }
                scrollBy(0, (int) dy);
                break;
            case MotionEvent.ACTION_UP:
                lastY = event.getY();
                break;
        }
//        return super.onTouchEvent(event);
        return true;
    }
}
