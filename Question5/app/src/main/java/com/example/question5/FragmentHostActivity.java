package com.example.question5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentHostActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_host);

        // Check if savedInstanceState is null to prevent overlapping fragments on screen rotation
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new FirstFragment())
                    .commit();
        }
    }
}