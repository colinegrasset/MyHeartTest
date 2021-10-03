package com.example.myhearttest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyHeart extends AppCompatActivity {

    public static final String TAG = "MyHeart"; // Identifiant pour les messages de log

    // Attributs réponse question 1
    private RadioGroup radioGroupQ1;
    private RadioButton radioYesQ1;
    private RadioButton radioNoQ1;

    // Attributs réponse question 2
    private RadioGroup radioGroupQ2;
    private RadioButton radioYesQ2;
    private RadioButton radioNoQ2;

    // Attributs réponse question 3
    private RadioGroup radioGroupQ3;
    private RadioButton radioYesQ3;
    private RadioButton radioNoQ3;

    // Attributs réponse question 4
    private RadioGroup radioGroupQ4;
    private  RadioButton radioYesQ4;
    private RadioButton radioNoQ4;


    private Switch switchQ5; // Switch réponse question 5
    private Spinner spinnerQ6; // Spinner réponse question 5
    private Personne person; // Objet personne dans lequel sont stockées les informations saisies par l'utilisateur

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Création de l'activité
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myheart);

        // Création de l'objet personne et récupération des données de l'activité précédente
        person = new Personne();
        processIntentData();

        // Association des attributs de la classe aux widgets de l'activité
        radioGroupQ1 = (RadioGroup) findViewById(R.id.mhRadioGroupQ1);
        radioYesQ1 = (RadioButton) findViewById(R.id.mhYradioButtonQ1);
        radioNoQ1 = (RadioButton) findViewById(R.id.mhNradioButtonQ1);

        radioGroupQ2 = (RadioGroup) findViewById(R.id.mhradioGroupQ2);
        radioYesQ2 = (RadioButton) findViewById(R.id.mhyradioButtonQ2);
        radioNoQ2 = (RadioButton) findViewById(R.id.mhnradioButtonQ2);

        radioGroupQ3 = (RadioGroup) findViewById(R.id.mhradioGroupQ3);
        radioYesQ3 = (RadioButton) findViewById(R.id.mhyradioButtonQ3);
        radioNoQ3 = (RadioButton) findViewById(R.id.mhnradioButtonQ3);

        radioGroupQ4 = (RadioGroup) findViewById(R.id.mhradioGroupQ4);
        radioYesQ4 = (RadioButton) findViewById(R.id.mhyradioButtonQ4);
        radioNoQ4 = (RadioButton) findViewById(R.id.mhnradioButtonQ4);

        switchQ5 = (Switch) findViewById(R.id.mhSwitchQ5);
        spinnerQ6 = (Spinner) findViewById(R.id.mhspinnerQ6);

        Log.d(MyHeart.TAG, "creation activite MyHeart");
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
                Log.d(IAm.TAG, "No Person found after transfer from IAm");
            }
        }
        else {
            Log.d(IAm.TAG, "Error when transferring from IAm");
        }
    }

    /**
     * Méthode qui permet d'enregistrer les réponses saisies par l'utilisateur dans l'objet personne
     */
    private void GetResponse() {

        if ((radioGroupQ1.getCheckedRadioButtonId() == -1) |
                (radioGroupQ2.getCheckedRadioButtonId() == -1) |
                (radioGroupQ3.getCheckedRadioButtonId() == -1) |
                (radioGroupQ4.getCheckedRadioButtonId() == -1) |
                (spinnerQ6.getSelectedItem().toString().equals("Select your BMI category")) |
                (spinnerQ6.getSelectedItem().toString().equals("Selectionner votre catégorie IMC"))) {
            Toast.makeText(this, R.string.error_next_step, Toast.LENGTH_LONG).show();
        } else {
            if (radioYesQ1.isChecked()) {
                person.setCoeur(true);
            } else if (radioYesQ2.isChecked()) {
                person.setCoeur(false);
            }

            if (radioYesQ2.isChecked()) {
                person.setCholesterol(true);
            } else if (radioYesQ2.isChecked()) {
                person.setCholesterol(false);
            }

            if (radioYesQ3.isChecked()) {
                person.setDiabetique(true);
            } else if (radioYesQ3.isChecked()) {
                person.setDiabetique(false);
            }

            if (radioYesQ4.isChecked()) {
                person.setTension(true);
            } else if (radioYesQ4.isChecked()) {
                person.setTension(false);
            }

            if (switchQ5.isChecked()) {
                person.setFamillePbCoeur(true);
            } else {
                person.setFamillePbCoeur(true);
            }
            person.setIMC(spinnerQ6.getSelectedItem().toString());
        }
    }

    /**
     * Méthode qui permet le retour à l'activité précédente
     * @param view
     */
    public void previousStep(View view) {
        Log.d("myHeartPreviousStep", "bouton previous step");
        GetResponse();
            Intent intentIam;
            intentIam = new Intent(this, IAm.class);
            intentIam.putExtra("inputpersonne", this.person);
            startActivity(intentIam);
        onBackPressed();
    }

    /**
     * Méthode qui permet le passage à l'activité suivante
     * @param view
     */
    public void nextStep(View view) {
    Log.d("myHeartNextStep", "bouton next step");
    //Ajouter la vérification du remplissage de toutes les réponses
        GetResponse();
        Intent intentMyHeartMonito;
        intentMyHeartMonito = new Intent(this, MyHeartMonito.class);
        intentMyHeartMonito.putExtra("inputpersonne", this.person);
        startActivity(intentMyHeartMonito);
    }
}
