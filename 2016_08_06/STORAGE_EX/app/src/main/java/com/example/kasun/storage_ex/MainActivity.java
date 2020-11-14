package com.example.kasun.storage_ex;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);

        String name = profile.getString("name", "Guest");
        EditText etName = (EditText) findViewById(R.id.editText);
        TextView tvName = (TextView) findViewById(R.id.textView);
        etName.setText(name);
        tvName.setText("WELCOME "+name);

    }

    @Override
    public void onResume(){

        try{
            String FILENAME = "hello_file";
            FileInputStream fis = openFileInput(FILENAME);
            byte[] chars = new byte[fis.available()];
            fis.read(chars);
            fis.close();

            String string = new String(chars);
            EditText et = (EditText) findViewById(R.id.editText2);
            et.setText(string);
        }catch(Exception e){}

        super.onResume();
    }

    public void save(View v){

        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);
        SharedPreferences.Editor profileEditor = profile.edit();
        EditText etName = (EditText) findViewById(R.id.editText);

        profileEditor.putString("name", etName.getText().toString());

        profileEditor.commit();

    }

    public void save2(View v){
        try{
            String FILENAME = "hello_file";
            EditText et = (EditText) findViewById(R.id.editText2);
            String string = et.getText().toString();
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
            Toast.makeText(MainActivity.this, "SAVED", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
