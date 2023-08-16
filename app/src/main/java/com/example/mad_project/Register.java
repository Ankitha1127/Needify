package com.example.mad_project;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText username, email, phone, password,cpassword;
    Button register;
    final String SHARED_PREFS="shared_prefs";
    final String EMAIL_KEY="email_key";
    final String PASSWORD_KEY="password_key";
    final String PHONE_KEY="phone_key";
    final String USER_KEY="user_key";

    ImageView image;
    TextView alreg;
    SQLiteDatabase db;
    SharedPreferences sharedPreferences;
    String username1,email1,phone1,password11;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ConstraintLayout cl = findViewById(R.id.cl);

        username = findViewById(R.id.name);
        alreg=findViewById(R.id.alreg);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        //cpassword=findViewById(R.id.cpassword);
        image = findViewById(R.id.registerimage);
        register = findViewById(R.id.register);

        db = new DonateSQL(this).getWritableDatabase();
        sharedPreferences =getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        cl.setBackground((ContextCompat.getDrawable(getApplicationContext(), R.drawable.background)));
        username1=sharedPreferences.getString("USER_KEY",null);
        email1=sharedPreferences.getString("EMAIL_KEY",null);
        phone1=sharedPreferences.getString("PHONE_KEY",null);
        password11=sharedPreferences.getString("PASSWORD_KEY",null);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inpName, inpEmail, inpPhone, inpPassword,inpCP;
                inpName = username.getText().toString();
                inpEmail = email.getText().toString();
                inpPhone = phone.getText().toString();
                inpPassword = password.getText().toString();



                if (inpName.equals("") || inpEmail.equals("") || inpPhone.equals("") || inpPassword.equals("")) {

                    Toast.makeText(getApplicationContext(), "Enter all 4 fields",
                            Toast.LENGTH_SHORT).show();
                }

                else {
                    ContentValues values = new ContentValues();
                    values.put("username", inpName);
                    values.put("email", inpEmail);
                    values.put("phone", inpPhone);
                    values.put("password", inpPassword);
                    db.insert("user", null, values);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString(USER_KEY,inpName);
                    editor.putString(EMAIL_KEY,inpEmail);
                    editor.putString(PHONE_KEY,inpPhone);
                    editor.putString(PASSWORD_KEY,inpPassword);
                    editor.commit();
                    editor.apply();

                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(intent);
                }
            }
        });

        alreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });


    }
}