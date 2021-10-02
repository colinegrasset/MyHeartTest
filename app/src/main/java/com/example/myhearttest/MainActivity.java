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
    private EditText userName; // Champ de saisie du nom de l'utilisateur
    private Personne person; // Objet personne dans lequel sont stockées les informations saisies par l'utilisateur

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person = new Personne();
        userName = findViewById(R.id.editTextYourName);

        Log.d(MainActivity.TAG, "Creation activite de depart du test");
    }

    /**
     * Méthode pour le démarrage du test
     * @param view
     */
    public void startTest(View view) {
        if(userName.getText().toString().equals("")){
            Log.d(MainActivity.TAG, "Aucun nom saisi");
        }else{
            Log.d(MainActivity.TAG, "Nom saisi : " + userName.getText().toString());
        }

        // Affichage d'un toast dans le cas où le nom de l'utilisateur n'est pas saisi
        if (userName.getText().toString().equals("")){
            Toast.makeText(this,R.string.error_enter_name, Toast.LENGTH_LONG).show();
        }else{
            //Ajout du nom saisi dans l'objet personne
            person.setName(userName.getText().toString());

            // Sauvegarde de l'objet personne et création de la nouvelle activité
            Intent intentIAm;
            intentIAm = new Intent(this, IAm.class);
            intentIAm.putExtra("inputpersonne", this.person);
            startActivity(intentIAm);
        }
    }

    // Todo Commenter tout le code
}
