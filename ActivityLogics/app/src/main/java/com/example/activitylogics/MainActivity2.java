package com.example.activitylogics;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private Button previousButton;
    private Button nextButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.prev_button);

    }
}