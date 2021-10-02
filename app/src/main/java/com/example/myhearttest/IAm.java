package com.example.myhearttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class IAm extends AppCompatActivity {

    public static final String TAG = "IAm"; // Identifiant pour les messages de log

    // RadioGroup et RadioButton réponse question 1
    private RadioGroup radioGroupQ1;
    private RadioButton buttonQ1Man;
    private RadioButton buttonQ1Woman;

    private EditText ageQ2; // Champ de saisie de l'age (question2)
    private Personne person; // Objet personne dans lequel sont stockées les informations saisies par l'utilisateur

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Création de l'activité
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iam);

        // Création de l'objet personne et récupération des données de l'activité précédente
        person = new Personne();
        processIntentData();

        // Association des attributs de la classe aux widgets de l'activité
        ageQ2 = (EditText) findViewById(R.id.MHMEditTextNumberQ2);
        buttonQ1Man = (RadioButton) findViewById(R.id.MHMradioButtonQ1Yes);
        buttonQ1Woman = (RadioButton) findViewById(R.id.MHMradioButtonQ1No);
        radioGroupQ1 = (RadioGroup) findViewById(R.id.MHMRadioGroupQ1);

        Log.d(IAm.TAG, "Creation activite IAm");
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

    /**
     * Méthode qui permet le retour à l'activité précédente
     * @param view
     */
    public void previousStep(View view) {
        Log.d(IAm.TAG, "bouton previous step");
        onBackPressed();
    }

    /**
     * Méthode qui permet le passage à l'activité suivante
     * @param view
     */
    public void nextStep(View view) {
        Log.d(IAm.TAG, "bouton next step");

        // Affichage d'un toast dans le cas où tous les résultats ne sont pas saisis
        if ((ageQ2.getText().toString().equals("")) | (radioGroupQ1.getCheckedRadioButtonId() == -1)){
            Toast.makeText(this,R.string.error_next_step, Toast.LENGTH_LONG).show();
        }else{
            // Modification du genre dans l'objet personne selon le radioButton coché
            if (buttonQ1Man.isChecked()){
                person.setGenre(Genre.MAN);
            }else if(buttonQ1Woman.isChecked()){
                person.setGenre(Genre.WOMAN);
            }
            // Modification de l'âge dans l'objet personne selon l'âge saisi
            person.setAge(Integer.parseInt(ageQ2.getText().toString()));

            // Sauvegarde de l'objet personne et création de l'activité suivante
            Intent intentMyHeart;
            intentMyHeart = new Intent(this, MyHeart.class);
            intentMyHeart.putExtra("inputpersonne", this.person);
            startActivity(intentMyHeart);
        }
    }
}