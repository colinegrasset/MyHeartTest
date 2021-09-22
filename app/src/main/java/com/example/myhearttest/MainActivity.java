package com.example.myhearttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MainActivity"; // Identifiant pour les messages de log
    private EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.editTextYourName);
        Log.d("MainActivityOnCreate", "Test1");
    }

    protected void startTest(android.view.View v){
        Log.d("MainActivityStartTest", "Test2");
        //f ((userName.getText().toString() == "Your name") | (userName.getText().toString() == "")){
            Intent intent;
            intent = new Intent(this, IAm.class);
            intent.putExtra("inputusername", userName.getText().toString());
            startActivity(intent);
        //}else{
        //    Toast.makeText(this,R.string.error_enter_name, Toast.LENGTH_LONG).show();
        //}
    }
}