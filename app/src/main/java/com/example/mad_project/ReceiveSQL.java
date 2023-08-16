package com.example.mad_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReceiveSQL extends SQLiteOpenHelper
{
    public static String DB_name = "donationDB";
    public ReceiveSQL(Context context)
    {
        super(context,DB_name,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table receiver (id integer primary key autoincrement,name,date ,location,phone,type)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int i,int i1) {
        db.execSQL("DROP TABLE IF EXISTS receiver");
        onCreate(db);
    }
}
