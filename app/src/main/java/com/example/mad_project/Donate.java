package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.IInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Donate extends AppCompatActivity {
    EditText name,food,location,phone;
    ConstraintLayout cl1;
    Button donate;
    DatePicker date;
    SQLiteDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        db=new DonateSQL(this).getWritableDatabase();

        name=findViewById(R.id.donatename);
        food=findViewById(R.id.donatefood);
        location=findViewById(R.id.donatelocation);
        phone=findViewById(R.id.donatephone);
        donate=findViewById(R.id.donatebutton);
        date=findViewById(R.id.datePicker1);

        //cl1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.background));

        donate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String iname = name.getText().toString();
                String ifood= food.getText().toString();
                String ilocation= location.getText().toString();
                String iphone= phone.getText().toString();
                String date1=date.getDayOfMonth()+"/"+date.getMonth()+"/"+date.getYear();
                String availability="true";
                String type="Donator";


                if(TextUtils.isEmpty(iname))
                {
                    name.setError("Name is Required.");
                    return;
                }

                if(TextUtils.isEmpty(ifood))
                {
                    food.setError("Required.");
                    return;
                }

                if(iphone.length() < 10)
                {
                    phone.setError("Phone Number Must be >=10 Characters");
                    return;
                }
                else
                {
                    ContentValues values = new ContentValues();
                    values.put("name", iname);
                    values.put("food", ifood);
                    values.put("location", ilocation);
                    values.put("phone", iphone);
                    values.put("availability",availability);
                    values.put("date",date1);
                    values.put("type",type);

                    float res=db.insert("donation", null, values) ;
                    if(res!=-1)
                    {
                        Toast.makeText(getApplicationContext(), "Donation Added", Toast.LENGTH_SHORT).show();
                    }
                }

                Intent i=new Intent(Donate.this,Dashboard.class);
                startActivity(i);
            }
        });
    }
}