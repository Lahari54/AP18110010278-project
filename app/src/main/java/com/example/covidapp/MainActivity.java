package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et,et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.email);
        et1=findViewById(R.id.et2);

    }

    public void submit(View view){
        String data = et.getText().toString();
        String data1 = et1.getText().toString();

        if(data.isEmpty()&&data1.isEmpty()){
            Toast.makeText(this,"Please Enter Data",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i=new Intent(MainActivity.this, covidinfo.class);
            startActivity(i);
        }
    }
    public void register(View view){
        Intent i=new Intent(MainActivity.this, Register.class);
        startActivity(i);
    }
}
