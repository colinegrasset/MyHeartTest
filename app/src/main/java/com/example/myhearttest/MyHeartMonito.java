package com.example.myhearttest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MyHeartMonito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myheartmonito);
    }

    public void previousStep(View view) {
        Log.d("MyHeartMonitoPreviousStep", "bouton previous step");
        onBackPressed();
    }
}