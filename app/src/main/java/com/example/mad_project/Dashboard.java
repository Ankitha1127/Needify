package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    CardView donate, receive, logout, about, contact, history;
    LinearLayout ll;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        donate = findViewById(R.id.cardDonate);
        receive = findViewById(R.id.cardReceive);
        logout = findViewById(R.id.cardLogout);

        history = findViewById(R.id.cardHistory);
        about = findViewById(R.id.cardAboutus);

        //ll.setBackgroundColor(Color.rgb(173,216,230));



        donate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Donate.class);
                startActivity(intent);
            }
        });

        receive.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DonationList.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Aboutus.class);
                startActivity(intent);
            }
        });

        history.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),History.class);
                startActivity(intent);
            }
        });

       /* contact.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Contact.class);
                startActivity(intent);
            }
        });*/

        logout.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this,Landingpage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Logged out Successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }
}