package com.ray.test.testingsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private String createTab;
    private String tableName = "tablename";

    public MyHelper(Context context, String db_name, SQLiteDatabase.CursorFactory factory, int db_version) {
        super(context, db_name, factory, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        createTab = "create table "+ tableName +" (_id integer primary key AUTOINCREMENT, row1 text, row2 text)";
        createTab = "create table "+ tableName +
                " (_id integer primary key AUTOINCREMENT, row1 text, row2 text, row3 text)";
        db.execSQL(createTab);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion == 1 && newVersion == 2){
            //Adding a row3
            String sql = "alter table "+ tableName +" add row3 text";
            db.execSQL(sql);
        }
    }
}
