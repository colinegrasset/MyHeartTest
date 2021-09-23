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

    public static final String TAG = "IAm";

    private RadioButton buttonQ1Man;
    private RadioButton buttonQ1Woman;
    private EditText ageQ2;
    private RadioGroup radioGroupQ1;
    private Personne person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iam);
        processIntentData();
        ageQ2 = (EditText) findViewById(R.id.MHMEditTextNumberQ2);
        buttonQ1Man = (RadioButton) findViewById(R.id.MHMradioButtonQ1Yes);
        buttonQ1Woman = (RadioButton) findViewById(R.id.MHMradioButtonQ1No);
        radioGroupQ1 = (RadioGroup) findViewById(R.id.MHMRadioGroupQ1);
        Log.d("IAmOnCreate", "page IAm");
        person = new Personne();

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
        Log.d("IAmPreviousStep", "bouton previous step");
        onBackPressed();
    }

    public void nextStep(View view) {
        Log.d("IAmNextStep", "bouton next step");
        if ((ageQ2.getText().toString().equals("")) | (radioGroupQ1.getCheckedRadioButtonId() == -1)){
            Toast.makeText(this,R.string.error_next_step, Toast.LENGTH_LONG).show();
        }else{
            Intent intent;
            intent = new Intent(this, myHeart.class);
            intent.putExtra("inputage", ageQ2.getText().toString());
            startActivity(intent);
        }
    }
}