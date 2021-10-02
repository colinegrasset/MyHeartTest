package com.example.myhearttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class TestResult extends AppCompatActivity {

    private String url;
    private Personne person;
    private int P1Q1;
    private Genre P1Q2;

    private boolean P2Q1;
    private boolean P2Q2;
    private boolean P2Q3;
    private boolean P2Q4;
    private boolean P2Q5;
    private String P2Q6;

    private boolean P3Q1;
    private boolean P3Q2;
    private boolean P3Q3;

    private boolean P4Q1;
    private boolean P4Q2;
    private boolean P4Q3;
    private boolean P4Q4;
    private boolean P4Q5;
    private boolean P4Q6;
    private boolean P4Q7;
    private boolean P4Q8;
    private boolean P4Q9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        url ="https://fedecardio.org/je-me-teste/";

        //recuperation des données personnes
        P1Q1 = person.getAge();
        P1Q2 = person.getGenre();

        P2Q1 = person.getCoeur();
        P2Q2 = person.getCholesterol();
        P2Q3 = person.getDiabetique();
        P2Q4 = person.getTension();
        P2Q5 = person.getFamillePbCoeur();
        P2Q6 = person.getIMC();

        P3Q1 = person.getRiskCardio();
        P3Q2 = person.getCoeurTest();
        P3Q3 = person.getCardiologue();

        P4Q1 = person.getCakeSweet();
        P4Q2 = person.getMeat();
        P4Q3 = person.getFruitsVege();
        P4Q4 = person.getStarchy();
        P4Q5 = person.getLegumes();
        P4Q6 = person.getBreakfast();
        P4Q7 = person.getLunch();
        P4Q8 = person.getDiner();
        P4Q9 = person.getSnacking();

        //calcul score page Iam qui va influencer en bonus ou malus sur les autres scores
        //if(P1Q1 == "male"){}


        //Calcul score page myHeart
        //calcul score page mheartmonitoring
        //calcul score page habitdiet


    }

    public void goToSite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    //ToDo Calculer les scores des 3 activités
    //ToDo en fonction du score mettre couleur spécifique a la zone texte
    //ToDo insérer le bon texte et modifier couleur au textView des 3 conseils.

}