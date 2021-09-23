package com.example.myhearttest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class myHeart extends AppCompatActivity {

    private Personne person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myheart);
        processIntentData();
        person = new Personne();
        Log.d("myHeartOnCreate", "page myHeart");
    }

    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
            // intent may store different data. To get the one matching the Person class,
            // we need the key "FromActivity1ToActivity2" which was used for transfer
            // No need to calls "new()" for allocating memory to transferredPerson
            Personne transferredPerson = intent.getParcelableExtra("inputpersonne");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            } else {
                Log.d(IAm.TAG, "No Person found after transfer from MainActivity");
            }
        }
        else {
            Log.d(IAm.TAG, "Error when transferring from MainActivity");
        }
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