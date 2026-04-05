package com.example.question2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context c;
    String[] data;

    GridAdapter(Context c, String[] d){
        this.c = c;
        data = d;
    }

    public int getCount(){ return data.length; }
    public Object getItem(int i){ return data[i]; }
    public long getItemId(int i){ return i; }

    public View getView(int i, View v, ViewGroup p){
        TextView t = new TextView(c);
        t.setText(data[i]);
        t.setPadding(20,20,20,20);
        return t;
    }
}
