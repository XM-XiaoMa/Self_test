package com.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.widget.R;
import com.view.widget.TopBar1;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TopBar1 topBar1 = findViewById(R.id.top_bar);
//        topBar1.setTopBarClickListener(new TopBar1.TopBarClickListener() {
//            @Override
//            public void leftClick() {
//                Toast.makeText(CustomActivity.this, "left_btn", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void rightClick() {
//                Toast.makeText(CustomActivity.this, "right_btn", Toast.LENGTH_LONG).show();
//            }
//        });
    }
}
