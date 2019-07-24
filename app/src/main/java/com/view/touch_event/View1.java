package com.view.touch_event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mbc on 19-6-1
 * Description:
 */
public class View1 extends View {
    public View1(Context context) {
        super(context);
    }

    public View1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("xiaoma", "View1 dispatchTouchEvent == " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("xiaoma", "View1 onTouchEvent == " + event.getAction());
        return super.onTouchEvent(event);
//        return true;
    }
}
