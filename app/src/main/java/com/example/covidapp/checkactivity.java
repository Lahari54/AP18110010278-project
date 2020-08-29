package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class checkactivity extends AppCompatActivity {

    RadioGroup radioGroup,radioGroup1,radioGroup2;
    RadioButton rb,rb2,rb3,rb4,rb5,rb6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkactivity);
        radioGroup=findViewById(R.id.rg);
        radioGroup1=findViewById(R.id.rg1);
        radioGroup2=findViewById(R.id.rg2);
        rb=findViewById(R.id.b1);
        rb2=findViewById(R.id.b2);
        rb3=findViewById(R.id.b3);
        rb4=findViewById(R.id.b4);
        rb5=findViewById(R.id.b5);
        rb6=findViewById(R.id.b6);
    }


    public void submit(View view) {
        String data=rb.getText().toString();
        String data1=rb2.getText().toString();
        String data2=rb3.getText().toString();
        String data3=rb4.getText().toString();
        String data4=rb5.getText().toString();
        String data5=rb6.getText().toString();

         if (rb.getText().toString().equals("yes") || rb3.getText().toString().equals("yes") || rb5.getText().toString().equals("yes")){
             Toast.makeText(this, "Go for checkup!", Toast.LENGTH_SHORT).show();
         }

        else if (rb2.getText().toString().equals("no") || rb4.getText().toString().equals("no") || rb6.getText().toString().equals("no")){
            Toast.makeText(this, "safe", Toast.LENGTH_SHORT).show();
        }

    }
}