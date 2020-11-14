package com.example.kasun.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashSet;
import java.util.Set;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void save(View v){

        EditText editText1 = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);
        SharedPreferences.Editor profileEditor = profile.edit();

        Set<String> notes = profile.getStringSet("notes", new HashSet<String>());
        notes.add(editText1.getText().toString() + "#" + editText2.getText().toString());
        profileEditor.remove("notes");
        profileEditor.putStringSet("notes", notes);

        profileEditor.commit();

    }

}
