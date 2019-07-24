package com.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.event_bus.entity.MessageEvent;
import com.event_bus.util.EventBusUtil;
import com.example.widget.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class EventBusFirstActivity extends AppCompatActivity {

    private TextView show_tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_first);
        show_tv1 = findViewById(R.id.show_tv1);
        show_tv1.setText("改变前");
//        EventBus.getDefault().register(this);
        EventBusUtil.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
        EventBusUtil.getInstance().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent) {
        // 4. 事件处理
        show_tv1.setText(messageEvent.getMessage());
    }


    public void goToEventBusSecond(View view) {
        Intent intent = new Intent(EventBusFirstActivity.this, EventBusSecondActivity.class);
        startActivity(intent);
    }

}
