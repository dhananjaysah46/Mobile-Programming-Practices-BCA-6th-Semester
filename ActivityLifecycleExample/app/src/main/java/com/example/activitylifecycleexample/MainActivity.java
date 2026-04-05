package com.example.activitylifecycleexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(getApplicationContext(), "onCreate Called", Toast.LENGTH_SHORT);
        toast.show();
    }
    protected void onStart(){
        super.onStart();
        Toast toast = Toast.makeText(getApplicationContext(), "onStart called", Toast.LENGTH_LONG);
        toast.show();
    }
    protected void onRestart() {
        Toast toast = Toast.makeText(getApplicationContext(), "onRestart called", Toast.LENGTH_LONG);
        toast.show();
    }
    protected void onPause(){
        super.onPause();
        Toast toast = Toast.makeText(getApplicationContext(), "onPause Called", Toast.LENGTH_LONG);
        toast.show();
    }

    protected void onResume() {

        super.onResume();
        Toast toast = Toast.makeText(getApplicationContext(), "onResume Called", Toast.LENGTH_LONG);
        toast.show();}

    protected void onStop() {

        super.onStop();

        Toast toast = Toast.makeText(getApplicationContext(), "onStop Called", Toast.LENGTH_LONG);
        toast.show();
    }

    protected void onDestroy() {

        super.onDestroy();

        Toast toast = Toast.makeText(getApplicationContext(), "onDestroy Called", Toast.LENGTH_LONG);
        toast.show();
    }
}