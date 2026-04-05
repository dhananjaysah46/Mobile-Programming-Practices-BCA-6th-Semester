package com.example.apilogics;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    // Declaring UI components
    TextView txt;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //

        // Initializing UI components by their IDs
        txt = findViewById(R.id.txtResult);
        btn = findViewById(R.id.btnFetch);

        // Setting up the click listener to trigger data fetching
        btn.setOnClickListener(v -> fetchData());
    }

    private void fetchData() {
        // The API endpoint URL
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        // Initialize the Volley RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);

        // Formulating the StringRequest
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                response -> {
                    // Success callback: update text view with the response
                    txt.setText(response);
                },
                error -> {
                    // Error callback: update text view with error message
                    txt.setText("Error fetching data");
                }
        );

        // Add the request to the RequestQueue to execute it
        queue.add(request);
    }
}