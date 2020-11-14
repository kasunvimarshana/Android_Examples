package com.example.kasun.ui_input_ex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.btn1);
        View.OnClickListener ocl = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        };
        btn1.setOnClickListener(ocl);
    }

    public void exit(View v){
        finish();
    }
    public void imgBtn(View v){
        Toast.makeText(MainActivity.this, "IMG BTN", Toast.LENGTH_SHORT).show();
    }
    public void toggle(View v){
        ToggleButton tb = (ToggleButton) v;
        if(tb.isChecked()){
            Toast.makeText(this, "WIFI IS ON", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "WIFI IS OFF", Toast.LENGTH_SHORT).show();
        }
    }
    public void next(View v){
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);
    }

}
