package com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] users = {
            "Suresh Dasari",
            "Trishika Dasari",
            "Rohini Alavala",
            "Praveen Kumar"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                users
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(
                getApplicationContext(),
                "Selected User: " + users[position],
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // No action needed
    }
}
