package com.example.covidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context myCt;
    List<Covidcases> myList;
    public MyAdapter(Context ct, List<Covidcases> covidlist) {
        myCt=ct;
        myList=covidlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(myCt).inflate(R.layout.myitem,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Covidcases c=myList.get(position);
        holder.t1.setText(c.getDate());
        holder.t2.setText(c.getActive());
        holder.t3.setText(c.getRecovered());
        holder.t4.setText(c.getDeaths());

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.date);
            t2=itemView.findViewById(R.id.active);
            t3=itemView.findViewById(R.id.recover);
            t4=itemView.findViewById(R.id.death);


        }
    }
}
