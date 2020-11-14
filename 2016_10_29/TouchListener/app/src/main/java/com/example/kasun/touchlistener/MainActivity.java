package com.example.kasun.touchlistener;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    CircleView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new TouchView(this));
        tv =new CircleView(this);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayout);
        rl.addView(tv);
    }

    public void red(View v){
        tv.setPaintColor(Color.RED);
    }
    public void green(View v){
        tv.setPaintColor(Color.GREEN);
    }
    public void blue(View v){
        tv.setPaintColor(Color.BLUE);
    }

}
