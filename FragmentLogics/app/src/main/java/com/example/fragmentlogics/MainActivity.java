package com.example.fragmentlogics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selectFragment(View view){
        Fragment fr;
        if(view == findViewById(R.id.button1)){
            fr = new FragmentOne();
        } else{
            fr = new FragmentTwo();
        }
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_section, fr);
        fragmentTransaction.commit();
    }
}