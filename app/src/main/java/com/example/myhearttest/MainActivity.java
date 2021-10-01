package com.example.myhearttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MainActivity"; // Identifiant pour les messages de log
    private EditText userName;
    private Personne person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person = new Personne();
        userName = findViewById(R.id.editTextYourName);
        Log.d("MainActivityOnCreate", "Test1");
    }

    public void startTest(View view) {
        Log.d("MainActivityStartTest", userName.getText().toString());

        if (userName.getText().toString().equals("")){
            Toast.makeText(this,R.string.error_enter_name, Toast.LENGTH_LONG).show();
        }else{
            person.setName(userName.getText().toString());
            Log.d("MainActivityStartTestAjoutNamePerson", person.getName());
            Intent intentIAm;
            intentIAm = new Intent(this, IAm.class);
            intentIAm.putExtra("inputpersonne", this.person);
            startActivity(intentIAm);
        }
    }

    // Todo Commenter tout le code
}
