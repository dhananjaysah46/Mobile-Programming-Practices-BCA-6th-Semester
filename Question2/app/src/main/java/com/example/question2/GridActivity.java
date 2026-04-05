package com.example.question2;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class GridActivity extends AppCompatActivity {
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_grid);

        GridView g = findViewById(R.id.grid);
        String[] c = {"Nepal","India","China","Pakistan","Bhutan"};
        g.setAdapter(new GridAdapter(this, c));
    }
}
