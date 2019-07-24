package com.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.widget.R;

/**
 * Created by mbc on 19-6-1
 * Description:
 */
public class TouchEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
           事件拦截日志 - 默认
         * 2019-06-01 10:55:23.865 7157-7157/com.example.customview D/xiaoma: ViewGroup1 dispatchTouchEvent == 0
         * 2019-06-01 10:55:23.865 7157-7157/com.example.customview D/xiaoma: ViewGroup1 onInterceptTouchEvent == 0
         * 2019-06-01 10:55:23.865 7157-7157/com.example.customview D/xiaoma: ViewFroup2 dispatchTouchEvent == 0
         * 2019-06-01 10:55:23.865 7157-7157/com.example.customview D/xiaoma: ViewFroup2 onInterceptTouchEvent == 0
         * 2019-06-01 10:55:23.865 7157-7157/com.example.customview D/xiaoma: View1 dispatchTouchEvent == 0
         * 2019-06-01 10:55:23.865 7157-7157/com.example.customview D/xiaoma: View1 onTouchEvent == 0
         * 2019-06-01 10:55:23.865 7157-7157/com.example.customview D/xiaoma: ViewFroup2 onTouchEvent == 0
         * 2019-06-01 10:55:23.865 7157-7157/com.example.customview D/xiaoma: ViewGroup1 onTouchEvent == 0

           事件拦截日志 - ViewGroup1 onInterceptTouchEvent返回true
         *2019-06-01 11:01:58.257 7157-7157/com.example.customview D/xiaoma: ViewGroup1 dispatchTouchEvent == 0
         *2019-06-01 11:01:58.257 7157-7157/com.example.customview D/xiaoma: ViewGroup1 onInterceptTouchEvent == 0
         *2019-06-01 11:01:58.257 7157-7157/com.example.customview D/xiaoma: ViewGroup1 onTouchEvent == 0
         *
           事件拦截日志 - View1 TouchEvent 返回 true
         *2019-06-01 11:07:50.730 7519-7519/com.example.customview D/xiaoma: ViewGroup1 dispatchTouchEvent == 0
         *2019-06-01 11:07:50.730 7519-7519/com.example.customview D/xiaoma: ViewGroup1 onInterceptTouchEvent == 0
         *2019-06-01 11:07:50.730 7519-7519/com.example.customview D/xiaoma: ViewFroup2 dispatchTouchEvent == 0
         *2019-06-01 11:07:50.730 7519-7519/com.example.customview D/xiaoma: ViewFroup2 onInterceptTouchEvent == 0
         *2019-06-01 11:07:50.730 7519-7519/com.example.customview D/xiaoma: View1 dispatchTouchEvent == 0
         *2019-06-01 11:07:50.730 7519-7519/com.example.customview D/xiaoma: View1 onTouchEvent == 0
         *2019-06-01 11:07:50.892 7519-7519/com.example.customview D/xiaoma: ViewGroup1 dispatchTouchEvent == 1
         *2019-06-01 11:07:50.892 7519-7519/com.example.customview D/xiaoma: ViewGroup1 onInterceptTouchEvent == 1
         *2019-06-01 11:07:50.892 7519-7519/com.example.customview D/xiaoma: ViewFroup2 dispatchTouchEvent == 1
         *2019-06-01 11:07:50.892 7519-7519/com.example.customview D/xiaoma: ViewFroup2 onInterceptTouchEvent == 1
         *2019-06-01 11:07:50.892 7519-7519/com.example.customview D/xiaoma: View1 dispatchTouchEvent == 1
         *2019-06-01 11:07:50.892 7519-7519/com.example.customview D/xiaoma: View1 onTouchEvent == 1
         *
         *
         *
         *

         */
        setContentView(R.layout.activity_touch_event);
    }
}
