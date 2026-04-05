package com.example.adapterlogics2;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    StudentAdapter adapter;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Initialize list
        students = new ArrayList<>();
        students.add(new Student("Ram", "101"));
        students.add(new Student("Shyam", "102"));
        students.add(new Student("Hari", "103"));

        // Set adapter
        adapter = new StudentAdapter(this, students);
        listView.setAdapter(adapter);
    }
}
