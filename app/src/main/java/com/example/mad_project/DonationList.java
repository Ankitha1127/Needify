package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DonationList extends AppCompatActivity implements  ItemClick
{
    SQLiteDatabase db;
    private ArrayList<model> dataholder;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private myadapter adapter;

    private FloatingActionButton fbtn;

    Button recv;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_list);

       /* recv=findViewById(R.id.recv);

        recv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Receive.class);
                startActivity(intent);
            }
        });*/

        db = new DonateSQL(this).getWritableDatabase();
        dataholder = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);

        fbtn = findViewById(R.id.floatingActionButton);

        setupRecyclerView();

        Cursor cursor = db.rawQuery("SELECT * FROM donation", null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            String s = "";
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String location = cursor.getString(3);
            String phno = cursor.getString(4);
            String date = cursor.getString(6);


            dataholder.add(new model(id, name, date,location, phno));
            adapter = new myadapter(dataholder, this);
            adapter.notifyDataSetChanged();
        }
    }

    private void setupRecyclerView ()
    {

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new myadapter(dataholder, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onclick(model e) {
        String id=e.id;

       // db.execSQL("delete from Items where name='" +expense.id+"'");
        //db.close();
        Intent intent = new Intent(getApplicationContext(),Receive.class);
        startActivity(intent);
    }
}