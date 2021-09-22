package com.example.myhearttest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class myHeart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myheart);
    }

    public void previousStep(View view) {
        Log.d("myHeartPreviousStep", "bouton previous step");
        onBackPressed();
    }

    public void nextStep(View view) {
        Log.d("myHeartNextStep", "bouton next step");
        //Ajouter la vérification du remplissage de toutes les réponses
        //if (ageQ2.getText().toString().equals("")){
        //    Toast.makeText(this,R.string.error_next_step, Toast.LENGTH_LONG).show();
        //}else{
            Intent intent;
            intent = new Intent(this, MyHeartMonito.class);
        //    intent.putExtra("inputage", ageQ2.getText().toString());
            startActivity(intent);
        //}
    }
}