package com.example.myhearttest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyHeartMonito extends AppCompatActivity {

    private static final String TAG = "MyHeartMonito";
    private RadioGroup radioGroupQ1;
    private RadioGroup radioGroupQ2;
    private RadioGroup radioGroupQ3;
    private RadioButton buttonQ1Yes;
    private RadioButton buttonQ1No;
    private RadioButton buttonQ2Yes;
    private RadioButton buttonQ2No;
    private RadioButton buttonQ3Yes;
    private RadioButton buttonQ3No;
    private Personne person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myheartmonito);
        person = new Personne();
        processIntentData();
        radioGroupQ1 = findViewById(R.id.MHMRadioGroupQ1);
        radioGroupQ2 = findViewById(R.id.MHMRadioGroupQ2);
        radioGroupQ3 = findViewById(R.id.MHMRadioGroupQ3);
        buttonQ1Yes = findViewById(R.id.MHMradioButtonQ1Yes);
        buttonQ1No = findViewById(R.id.MHMradioButtonQ1No);
        buttonQ2Yes = findViewById(R.id.MHMradioButtonQ1Yes);
        buttonQ2No = findViewById(R.id.MHMradioButtonQ1No);
        buttonQ3Yes = findViewById(R.id.MHMradioButtonQ1Yes);
        buttonQ3No = findViewById(R.id.MHMradioButtonQ1No);
        Log.d("myHeartOnCreate", "page myHeartMonito");
    }

    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            // intent may store different data. To get the one matching the Person class,
            // we need the key "FromActivity1ToActivity2" which was used for transfer
            // No need to calls "new()" for allocating memory to transferredPerson
            Personne transferredPerson = intent.getParcelableExtra("inputpersonne");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            } else {
                Log.d(MyHeartMonito.TAG, "No Person found after transfer from MainActivity");
            }
        } else {
            Log.d(MyHeartMonito.TAG, "Error when transferring from MainActivity");
        }
    }

    public void previousStep(View view) {
        Log.d("MyHeartMonitoPreviousStep", "bouton previous step");
        onBackPressed();
    }

    public void finishTest(View view) {
        Log.d("myHeartMonitoFinishTest", "bouton finish test");
        //Ajouter la vérification du remplissage de toutes les réponses
        if ((radioGroupQ1.getCheckedRadioButtonId() == -1) | (radioGroupQ2.getCheckedRadioButtonId() == -1) | (radioGroupQ3.getCheckedRadioButtonId() == -1)) {
            Toast.makeText(this, R.string.error_next_step, Toast.LENGTH_LONG).show();
        } else {
            if (buttonQ1Yes.isChecked()) {
                person.setRiskCardio(true);
            } else if (buttonQ1No.isChecked()) {
                person.setRiskCardio(false);
            }
            if (buttonQ2Yes.isChecked()) {
                person.setCoeurTest(true);
            } else if (buttonQ2No.isChecked()) {
                person.setCoeurTest(false);
            }
            if (buttonQ3Yes.isChecked()) {
                person.setCardiologue(true);
            } else if (buttonQ3No.isChecked()) {
                person.setCardiologue(false);
            }
        }
    }
}