package com.example.alertdialogexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", (d,i) ->
                        Toast.makeText(this,"Yes Clicked",Toast.LENGTH_SHORT).show())
                .setNegativeButton("No", (d,i) ->
                        Toast.makeText(this,"No Clicked",Toast.LENGTH_SHORT).show())
                .show();
    }
}