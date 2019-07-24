package com.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.widget.R;

/**
 * Created by mbc on 19-5-30
 */
public class TopBar1 extends RelativeLayout {

    private Button leftBtn;
    private Button rightBtn;
    private TopBarClickListener topBarClickListener;

    public TopBar1(Context context) {
        super(context);
    }

    public TopBar1(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 自定义属性集
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar1);
        String titleText = typedArray.getString(R.styleable.TopBar1_title);
        String leftText = typedArray.getString(R.styleable.TopBar1_leftText);
        String rightText = typedArray.getString(R.styleable.TopBar1_rightText);
        float titleTextDimension = typedArray.getDimension(R.styleable.TopBar1_titleTextSize, 10);
        float leftTextDimension = typedArray.getDimension(R.styleable.TopBar1_leftTextSize, 10);
        float rightTextDimension = typedArray.getDimension(R.styleable.TopBar1_rightTextSize, 10);
        int titleTextColor = typedArray.getColor(R.styleable.TopBar1_titleTextColor, 0);
        int leftTextColor = typedArray.getColor(R.styleable.TopBar1_leftTextColor, 0);
        int rightTextColor = typedArray.getColor(R.styleable.TopBar1_rightTextColor, 0);
        Drawable leftDrawable = typedArray.getDrawable(R.styleable.TopBar1_leftBackground);
        Drawable rightDrawable = typedArray.getDrawable(R.styleable.TopBar1_rightBackground);
        // 资源回收
        typedArray.recycle();

        TextView titleTv = new TextView(context);
        leftBtn = new Button(context);
        rightBtn = new Button(context);

        titleTv.setText(titleText);
        titleTv.setTextColor(titleTextColor);
        titleTv.setTextSize(titleTextDimension);
        titleTv.setGravity(Gravity.CENTER);

        leftBtn.setText(leftText);
        leftBtn.setTextColor(leftTextColor);
        leftBtn.setBackgroundDrawable(leftDrawable);
        leftBtn.setTextSize(leftTextDimension);

        rightBtn.setText(rightText);
        rightBtn.setTextColor(rightTextColor);
        rightBtn.setBackgroundDrawable(rightDrawable);
        rightBtn.setTextSize(rightTextDimension);

        LayoutParams titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(titleTv, titleParams);

        LayoutParams leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(leftBtn, leftParams);

        LayoutParams rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightBtn, rightParams);

        leftBtn.setOnClickListener(clickListener);
        rightBtn.setOnClickListener(clickListener);
    }

    OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (leftBtn == v) {
                topBarClickListener.leftClick();
            } else if (rightBtn == v) {
                topBarClickListener.rightClick();
            }
        }
    };

    public interface TopBarClickListener {
        void leftClick();

        void rightClick();
    }

    public void setTopBarClickListener(TopBarClickListener listener) {
        topBarClickListener = listener;
    }
}
