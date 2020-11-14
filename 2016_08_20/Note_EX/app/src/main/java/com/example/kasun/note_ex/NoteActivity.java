package com.example.kasun.note_ex;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

    }

    public void save(View v){

        NoteHelper helper = new NoteHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        EditText et1 = (EditText) findViewById(R.id.editText);
        EditText et2 = (EditText) findViewById(R.id.editText2);

        String name = et1.getText().toString();
        String note = et2.getText().toString();

        String sql = "INSERT INTO notes (name, note) VALUES ('"+name+"','"+note+"')";

        db.execSQL(sql);
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        db.close();

    }

}
