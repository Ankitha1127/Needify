package com.example.mad_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CustomerSQL extends SQLiteOpenHelper
{
    public static String DB_NAME = "donationDB";
    public CustomerSQL(Context context) {
        super(context, DB_NAME, null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table user ( username primary key,email, phone,password )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }


}
