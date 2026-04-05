package com.example.adapterlogics;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView l;
    String t[] = {"Algorithms", "DS", "Languages", "CS", "WT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = findViewById(R.id.list);

        ArrayAdapter<String> arr =
                new ArrayAdapter<>(this, R.layout.spinner_dropitem, t);

        l.setAdapter(arr);
    }
}
