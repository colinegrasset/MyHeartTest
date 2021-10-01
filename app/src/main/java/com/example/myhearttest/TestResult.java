package com.example.myhearttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class TestResult extends AppCompatActivity {

    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        url ="https://fedecardio.org/je-me-teste/";
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