package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity {
    EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et1 = findViewById(R.id.Rusername);
        et2 = findViewById(R.id.Rpassword);
        et3 = findViewById(R.id.Rconfirmpassword);
    }

    public void submit(View view) {
        String Rdata = et1.getText().toString();
        String Rpasswrd = et2.getText().toString();
        String RCpasswrd = et3.getText().toString();
        if(Rdata.isEmpty() && Rpasswrd.isEmpty()){
            Toast.makeText(this, "Enter Username and Password", Toast.LENGTH_SHORT).show();
        }
        else if(Rdata.isEmpty()){
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        }
        else if(Rpasswrd.isEmpty()){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else if (RCpasswrd.isEmpty()){
            Toast.makeText(this, "Please Confirm Password", Toast.LENGTH_SHORT).show();
        }
        else if (Rpasswrd.equals(RCpasswrd)) {
            Intent i = new Intent(Register.this, MainActivity.class);
            Toast.makeText(this, "Registration successfull", Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Password feilds are not same", Toast.LENGTH_SHORT).show();
        }
    }
}
