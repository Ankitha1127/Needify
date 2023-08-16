package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    SQLiteDatabase db1,db2;
    private ArrayList<model1> dataholder1,dataholder2;
    private RecyclerView recyclerView1,recyclerView2;
    private LinearLayoutManager linearLayoutManager;
    private myadapter1 adapter1,adapter2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        db1 = new DonateSQL(this).getWritableDatabase();
        //db2 = new ReceiveSQL(this).getWritableDatabase();

        dataholder1 = new ArrayList<>();
        recyclerView1 = findViewById(R.id.recycler_view);

        setupRecyclerView();

        Cursor cursor1 = db1.rawQuery("SELECT * FROM receiver", null);
        //Cursor cursor2 = db2.rawQuery("SELECT * FROM receiver", null);

        for (int i = 0; i < cursor1.getCount(); i++) {
            cursor1.moveToNext();
            String s = "";
            String id = cursor1.getString(0);
            String name = cursor1.getString(1);
            String date = cursor1.getString(2);
            String location = cursor1.getString(3);
            String phno = cursor1.getString(4);
            String type = cursor1.getString(5);
            Log.d("phone:",phno);



            dataholder1.add(new model1(id, name,date, location, phno.toString(),type));
            adapter1 = new myadapter1(dataholder1,this);
            adapter1.notifyDataSetChanged();
        }
       // dataholder2 = new ArrayList<>();
       // recyclerView2 = findViewById(R.id.recycler_view);

        //setupRecyclerView();
        //Cursor cursor2 = db2.rawQuery("SELECT * FROM receiver", null);
        //for (int i = 0; i < cursor1.getCount(); i++) {
          //  cursor2.moveToNext();
            //String s = "";
            //String id = cursor2.getString(0);
            //String name = cursor2.getString(1);
            //String location = cursor2.getString(3);
            //String phno = cursor2.getString(4);
            //String date = cursor2.getString(6);
            //String type = cursor2.getString(7);
            //Log.d("phone:",phno);



            //dataholder2.add(new model1(id, name, date, location, phno.toString(),type));
            //adapter2 = new myadapter1(dataholder1,this);
           // adapter2.notifyDataSetChanged();
        //}
    }

    private void setupRecyclerView ()
    {

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager);
        adapter1 = new myadapter1(dataholder1, this);
        recyclerView1.setAdapter(adapter1);
    }
}