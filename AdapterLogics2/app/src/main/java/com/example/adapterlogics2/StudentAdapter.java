package com.example.adapterlogics2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    Context context;
    List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.row_student, parent, false);
        }

        TextView name = convertView.findViewById(R.id.tvName);
        TextView roll = convertView.findViewById(R.id.tvRoll);

        Student s = students.get(position);
        name.setText(s.name);
        roll.setText(String.valueOf(s.roll));

        return convertView;
    }
}

