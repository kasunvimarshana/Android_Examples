package com.example.kasun.note_ex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KASUN on 8/20/2016.
 */
public class NoteHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "dbnotes";
    public static final String NOTES_CREATE = "CREATE TABLE notes (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, note TEXT)";

    public NoteHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NOTES_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
