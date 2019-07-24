package com.view.touch_event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by mbc on 19-6-1
 * Description:
 */
public class ViewGroup1 extends LinearLayout {


    public ViewGroup1(Context context) {
        super(context);
    }

    public ViewGroup1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroup1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("xiaoma", "ViewGroup1 dispatchTouchEvent == " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("xiaoma", "ViewGroup1 onInterceptTouchEvent == " + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("xiaoma", "ViewGroup1 onTouchEvent == " + event.getAction());
        return super.onTouchEvent(event);
    }
}
