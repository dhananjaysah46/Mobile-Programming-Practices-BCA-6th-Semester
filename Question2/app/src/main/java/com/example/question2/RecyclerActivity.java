package com.example.question2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerActivity extends AppCompatActivity {
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_recyclerview);

        RecyclerView r=findViewById(R.id.recycler);
        r.setLayoutManager(new LinearLayoutManager(this));
        r.setAdapter(new CountryAdapter(new String[]{"Nepal","India","China"}));
    }
}
