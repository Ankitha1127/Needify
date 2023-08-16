package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Receive extends AppCompatActivity {
    SQLiteDatabase db;
    EditText name,phone,loc;
    DatePicker date;
    Button collect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        ConstraintLayout cl=findViewById(R.id.cl);
        collect=findViewById(R.id.collect);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phno);
        date=findViewById(R.id.datePicker);
        loc=findViewById(R.id.hlocation);

        //cl.setBackground(ContextCompat.getDrawable(getApplicationContext(),R. drawable.background));
        db = new DonateSQL(this).getWritableDatabase();

        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name1, phno1, date1, location1, time1;
                String type = "Receiver";

                name1 = name.getText().toString();
                phno1 = phone.getText().toString();
                date1=date.getDayOfMonth()+"/"+date.getMonth()+"/"+date.getYear();
                location1 = loc.getText().toString();

                if (name1.equals("") || phno1.equals("") || date1.equals("") || location1.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter all the 4 fields", Toast.LENGTH_SHORT).show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put("name", name1);
                    values.put("phone", phno1);
                    values.put("date", date1);
                    values.put("location", location1);
                    values.put("type",type);



                    float res=db.insert("receiver", null, values);

                    if(res==-1)
                    {
                        Toast.makeText(getApplicationContext(), "Receive request failed!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Successfully sent collect request", Toast.LENGTH_SHORT).show();
                    }

                }

                Intent i=new Intent(Receive.this,Dashboard.class);
                startActivity(i);
            }
        });
    }
}