package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText name1,password1;
    Button signup;
    ImageView image1;
    TextView notreg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name1=findViewById(R.id.username);
        password1=findViewById(R.id.password1);
        signup=findViewById(R.id.signup);
        image1=findViewById(R.id.image);
        notreg=findViewById(R.id.notreg);
        ConstraintLayout cl=findViewById(R.id.cl);
        cl.setBackground((ContextCompat.getDrawable(getApplicationContext(),R.drawable.background)));
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name1.getText().toString().equals("admin") && password1.getText().toString().equals("admin"))
                {
                    Intent i = new Intent(getApplicationContext(),Dashboard.class);
                    startActivity(i);
                }
               else
                {
                    Toast.makeText(Login.this, "Wrong credentials!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        notreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(), Register.class);
                startActivity(i1);
            }
        });
    }
}