package com.example.kasun.broadcastreceiver_ex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View v){
        Intent intent = new Intent();
        intent.setAction("com.im.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    public void start(View v){
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

}
