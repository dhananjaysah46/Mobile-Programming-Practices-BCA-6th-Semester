package com.example.question6;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        TextView t = findViewById(R.id.tvData);

        // Network operations cannot run on the Main Thread.
        // We use a new Thread to perform the network call.
        new Thread(() -> {
            try {
                // Fetching from a sample REST API
                URL u = new URL("https://jsonplaceholder.typicode.com/posts/1");
                BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));

                StringBuilder l = new StringBuilder();
                String s;
                while ((s = br.readLine()) != null) {
                    l.append(s);
                }

                // Switch back to the UI Thread to update the TextView
                runOnUiThread(() -> t.setText(l.toString()));

            } catch (Exception e) {
                runOnUiThread(() -> t.setText("Error: " + e.getMessage()));
            }
        }).start();
    }
}