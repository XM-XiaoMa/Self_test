package com.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.event_bus.entity.MessageEvent;
import com.event_bus.util.EventBusUtil;
import com.example.widget.R;

import org.greenrobot.eventbus.EventBus;


public class EventBusSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_second);
    }

    public void changeFirstEventBusTvShow(View view) {
//        EventBus.getDefault().post(new MessageEvent("改变后"));
        EventBusUtil.getInstance().post(new MessageEvent("改变后"));
        EventBusSecondActivity.this.finish();
    }
}
