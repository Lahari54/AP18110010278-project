package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Info1 extends AppCompatActivity {

    RecyclerView rv;
    String covidURL = "https://api.covid19api.com/dayone/country/IN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        rv = findViewById(R.id.recycler);


        mytask task = new mytask();
        task.execute();
    }

    public class mytask extends AsyncTask<Void, Void, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {

            try
            {
                URL u = new URL(covidURL);
                HttpsURLConnection connection = (HttpsURLConnection) u.openConnection();
                InputStream is = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = "";
                StringBuilder builder = new StringBuilder();
                while((line = reader.readLine())!=null)
                {
                    builder.append(line);
                }

                return builder.toString();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if(s==null)
            {
                Toast.makeText(Info1.this, "Please Check Your Internet Connection", Toast.LENGTH_LONG).show();
            } else{
                try
                {
                    JSONArray countryJSONArray = new JSONArray(s);
                    List<Covidcases> myCov = new ArrayList<>();
                    for(int k = countryJSONArray.length()-1; k>=0; k--)
                    {
                        JSONObject eachDate = countryJSONArray.getJSONObject(k);
                        String temp = eachDate.optString("Date");
                        String date = "";
                        for(int i = 0; i<temp.length(); i++)
                        {
                            if(temp.charAt(i)=='T')
                            {
                                break;
                            }
                            else
                            {
                                date+=temp.charAt(i);
                            }
                        }
                        String active = eachDate.optString("Active");
                        String recovered = eachDate.optString("Recovered");
                        String death = eachDate.optString("Deaths");
                        Covidcases cov = new Covidcases(date,active, recovered,death);
                        myCov.add(cov);
                    }

                    rv.setLayoutManager(new LinearLayoutManager(Info1.this));
                    MyAdapter adapter = new MyAdapter(Info1.this,myCov);
                    rv.setAdapter(adapter);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

}
