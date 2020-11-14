package com.example.kasun.note_ex;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        Intent intent = getIntent();
        String name = (String)intent.getExtras().get("name");

        NoteHelper helper = new NoteHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        String sql = "SELECT * FROM notes WHERE name = '"+name+"'";
        Cursor cursor = db.rawQuery(sql, null);

        cursor.moveToFirst();
        if(cursor.isAfterLast() == false){
            String noteId = cursor.getString(0);
            String noteName = cursor.getString(1);
            String note = cursor.getString(2);

            TextView tv1 = (TextView) findViewById(R.id.textView);
            TextView tv2 = (TextView) findViewById(R.id.textView2);
            TextView tv3 = (TextView) findViewById(R.id.textView3);

            tv1.setText(noteId);
            tv2.setText(noteName);
            tv3.setText(note);

        }

    }
}
