package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class covidinfo extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covidinfo);
        findViewById(R.id.info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(covidinfo.this, Info1.class));
            }
        });
    }

    public void Check(View view) {
        Intent i=new Intent(covidinfo.this,
                checkactivity.class);
        startActivity(i);
    }



    public void Contact(View view) {
        Intent i=new Intent(covidinfo.this, Contact.class);
        startActivity(i);
    }
}