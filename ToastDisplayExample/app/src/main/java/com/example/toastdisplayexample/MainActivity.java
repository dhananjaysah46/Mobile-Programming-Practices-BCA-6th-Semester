package com.example.toastdisplayexample;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        e = findViewById(R.id.edit);
    }

    public void show(View v){
        String text = e.getText().toString();

        if(text.isEmpty()){
            Toast.makeText(this, "Enter something", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}