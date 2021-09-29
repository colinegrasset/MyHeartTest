package com.example.myhearttest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class myHeart extends AppCompatActivity {

    private RadioGroup radioGroupQ1;
    private RadioGroup radioGroupQ2;
    private RadioGroup radioGroupQ3;
    private RadioGroup radioGroupQ4;
    private RadioGroup radioGroupQ5;
    private Spinner spinnerQ6;
    private Personne person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myheart);
        person = new Personne();
        processIntentData();
        radioGroupQ1 = (RadioGroup) findViewById(R.id.mhRadioGroupQ1);
        radioGroupQ2 = (RadioGroup) findViewById(R.id.mhradioGroupQ2);
        radioGroupQ3 = (RadioGroup) findViewById(R.id.mhradioGroupQ3);
        radioGroupQ4 = (RadioGroup) findViewById(R.id.mhradioGroupQ4);
        radioGroupQ5 = (RadioGroup) findViewById(R.id.mhradioGroupQ5);
        spinnerQ6 = (Spinner) findViewById(R.id.spinnerQ6);
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


        if ((radioGroupQ1.getCheckedRadioButtonId() == -1)){
            Toast.makeText(this,R.string.error_next_step, Toast.LENGTH_LONG).show();
        }else{
            //Todo Modifier le getCheckedButtonId par un ISChecked() sur les radioButton
            String coeur = ((RadioButton)findViewById(radioGroupQ1.getCheckedRadioButtonId())).getText().toString();
            if (coeur.equals("Yes") | coeur.equals("Oui")){
                person.setCoeur(true);
            }else if(coeur.equals("No") | coeur.equals("Non")){
                person.setCoeur(false);
            }
            Intent intentMyHeartMonito;
            intentMyHeartMonito = new Intent(this, MyHeartMonito.class);
            intentMyHeartMonito.putExtra("inputpersonne", this.person);
            startActivity(intentMyHeartMonito);
        }
    }
}