package com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.widget.R;
import com.retrofit.RetrofitActivity;
import com.view.EventBusFirstActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eventBusFirst(View view) {
        Intent intent = new Intent(MainActivity.this, EventBusFirstActivity.class);
        startActivity(intent);
    }

    public void retrofit(View view) {
        Intent intent = new Intent(MainActivity.this, RetrofitActivity.class);
        startActivity(intent);
    }
}
