package com.example.kasun.ui_input_ex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        CompoundButton.OnCheckedChangeListener occl = new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if(checkBox.isChecked()){
                    Toast.makeText(Main3Activity.this, "You Are Married", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main3Activity.this, "You Are Un-Married", Toast.LENGTH_SHORT).show();
                }
            }
        };
        checkBox.setOnCheckedChangeListener(occl);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        android.widget.RadioGroup.OnCheckedChangeListener awroccl = new android.widget.RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if(checkedId == R.id.radioButton){
                    Toast.makeText(Main3Activity.this, "MALE", Toast.LENGTH_SHORT).show();
                }else if(checkedId == R.id.radioButton2){
                    Toast.makeText(Main3Activity.this, "FEMALE", Toast.LENGTH_SHORT).show();
                }
            }
        };
        radioGroup.setOnCheckedChangeListener(awroccl);

    }

    public void next(View v){
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        if(checkBox.isChecked()){
            Toast.makeText(this, "You Are Married", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "You Are Un-Married", Toast.LENGTH_SHORT).show();
        }

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);

        if(rb1.isChecked()){
            Toast.makeText(this, "MALE", Toast.LENGTH_SHORT).show();
        }else if(rb2.isChecked()){
            Toast.makeText(this, "FEMALE", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
        startActivity(intent);

    }

}
