package com.example.kasun.orm_tool;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by KASUN on 8/27/2016.
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "dbmycustomers";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, Customer.class);//model 1kata adala table 1ka auto generate wenawa
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        /*try{
            TableUtils.dropTable(connectionSource, Customer.class, true);//(true = data makanawa, false = data thiyagannawa)
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }
}
