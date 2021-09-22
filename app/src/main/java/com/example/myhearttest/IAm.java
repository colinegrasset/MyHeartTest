package com.example.myhearttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class IAm extends AppCompatActivity {

    private RadioButton buttonQ1Man;
    private RadioButton buttonQ1Woman;
    private EditText ageQ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iam);
        ageQ2 = (EditText) findViewById(R.id.MHMEditTextNumberQ2);
        buttonQ1Man = (RadioButton) findViewById(R.id.MHMradioButtonQ1Yes);
        buttonQ1Woman = (RadioButton) findViewById(R.id.MHMradioButtonQ1No);
        Log.d("IAmOnCreate", "page IAm");
    }

    public void previousStep(View view) {
        Log.d("IAmPreviousStep", "bouton previous step");
        onBackPressed();
    }

    public void nextStep(View view) {
        Log.d("IAmNextStep", "bouton next step");
        if (ageQ2.getText().toString().equals("")){
            Toast.makeText(this,R.string.error_next_step, Toast.LENGTH_LONG).show();
        }else{
            Intent intent;
            intent = new Intent(this, myHeart.class);
            intent.putExtra("inputage", ageQ2.getText().toString());
            startActivity(intent);
        }
    }
}