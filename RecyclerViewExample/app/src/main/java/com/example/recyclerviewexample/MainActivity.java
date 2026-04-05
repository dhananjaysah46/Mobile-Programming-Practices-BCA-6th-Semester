package com.example.recyclerviewexample;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        RecyclerView r = findViewById(R.id.recycler);

        String[] data = {"One","Two","Three","Four","Five"};

        r.setLayoutManager(new LinearLayoutManager(this));
        r.setAdapter(new MyAdapter(data));
    }
}