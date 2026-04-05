package com.example.question2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_listview);

        ListView lv = findViewById(R.id.list);
        String[] c = {"Nepal","India","China","Pakistan","Bhutan", "Bangladesh"};
        lv.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, c));
    }
}