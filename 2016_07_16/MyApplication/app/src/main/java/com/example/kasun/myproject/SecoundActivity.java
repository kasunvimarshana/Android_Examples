package com.example.kasun.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);

        Intent intent = getIntent(); // 4.fourth method meya bavitha wanne meme activity eka open karapu intent eka labaganimataya

        String name = (String) intent.getExtras().get("name");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(name);

    }
}
