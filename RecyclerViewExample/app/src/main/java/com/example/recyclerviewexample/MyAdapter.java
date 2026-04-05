package com.example.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {
    String[] data;

    MyAdapter(String[] d){ data = d; }

    static class VH extends RecyclerView.ViewHolder {
        TextView t;
        VH(View v){
            super(v);
            t = v.findViewById(android.R.id.text1);
        }
    }

    public VH onCreateViewHolder(ViewGroup p, int v){
        return new VH(LayoutInflater.from(p.getContext())
                .inflate(android.R.layout.simple_list_item_1,p,false));
    }

    public void onBindViewHolder(VH h, int i){
        h.t.setText(data[i]);
    }

    public int getItemCount(){ return data.length; }
}