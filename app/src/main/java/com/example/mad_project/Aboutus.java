package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Aboutus extends AppCompatActivity {
    CardView gmail,instagram,facebook,twitter;
    ImageView image1,image2,image3;
    TextView about,am,an,bh,dev;
    Button back;
    TextView gmail1,instagram1,twitter1,facebook1;
    ImageView gmail2,instagram2,twitter2,facebook2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        back=findViewById(R.id.back);
        dev=findViewById(R.id.dev);
        about=findViewById(R.id.about);
        gmail=findViewById(R.id.gmail);
        facebook=findViewById(R.id.facebook);
        instagram=findViewById(R.id.instagram);
        twitter=findViewById(R.id.twitter);
        ConstraintLayout cl=findViewById(R.id.cl);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        am=findViewById(R.id.amrutha);
        an=findViewById(R.id.ankitha);
        bh=findViewById(R.id.bhavna);
        facebook2=findViewById(R.id.face);
        twitter2=findViewById(R.id.twit);
        instagram2=findViewById(R.id.insta);
        gmail2=findViewById(R.id.gm);
        facebook1=findViewById(R.id.book);
        twitter1=findViewById(R.id.ter);
        instagram1=findViewById(R.id.gram);
        gmail1=findViewById(R.id.ail);

        cl.setBackground((ContextCompat.getDrawable(getApplicationContext(),R.drawable.background)));

        gmail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link=new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("http://www.gmail.com"));
                startActivity(link);
            }
        });
        instagram1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link=new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("http://www.instagram.com"));
                startActivity(link);
            }
        });
        facebook1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link=new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("http://www.facebook.com"));
                startActivity(link);
            }
        });
        twitter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link=new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("http://www.twitter.com"));
                startActivity(link);
            }
        });
        gmail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link=new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("http://www.gmail.com"));
                startActivity(link);
            }
        });
        instagram2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link=new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("http://www.instagram.com"));
                startActivity(link);
            }
        });
        facebook2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link=new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("http://www.facebook.com"));
                startActivity(link);
            }
        });
        twitter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link=new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("http://www.twitter.com"));
                startActivity(link);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Dashboard.class);
                startActivity(i);
            }
        });

    }
}