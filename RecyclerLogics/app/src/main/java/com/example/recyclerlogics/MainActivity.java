package com.example.recyclerlogics;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        list.add("Android");
        list.add("Java");
        list.add("Recycler View");
        list.add("Example");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}