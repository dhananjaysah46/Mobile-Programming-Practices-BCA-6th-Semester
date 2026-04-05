package com.example.question5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    public View onCreateView(LayoutInflater i, ViewGroup c, Bundle b){
        return i.inflate(R.layout.fragment_first,c,false);
    }
}
