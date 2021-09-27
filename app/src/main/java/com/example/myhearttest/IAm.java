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
        person = new Personne();
        processIntentData();
        ageQ2 = (EditText) findViewById(R.id.MHMEditTextNumberQ2);
        buttonQ1Man = (RadioButton) findViewById(R.id.MHMradioButtonQ1Yes);
        buttonQ1Woman = (RadioButton) findViewById(R.id.MHMradioButtonQ1No);
        radioGroupQ1 = (RadioGroup) findViewById(R.id.IAmRadioGroupQ1);
        Log.d("IAmOnCreate", "page IAm");
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
        Log.d("IAmNextStepName", person.getName());
        if ((ageQ2.getText().toString().equals("")) | (radioGroupQ1.getCheckedRadioButtonId() == -1)){
            Toast.makeText(this,R.string.error_next_step, Toast.LENGTH_LONG).show();
        }else{
            //Todo Modifier le getCheckedRadioButtonId() par un isChecked()
            String Sexe = ((RadioButton)findViewById(radioGroupQ1.getCheckedRadioButtonId())).getText().toString();
            if (Sexe.equals("A man") | Sexe.equals("Un homme")){
                person.setGenre(Genre.MAN);
            }else if(Sexe.equals("A woman") | Sexe.equals("Une femme")){
                person.setGenre(Genre.WOMAN);
            }
            person.setAge(Integer.parseInt(ageQ2.getText().toString()));
            Intent intentMyHeart;
            intentMyHeart = new Intent(this, myHeart.class);
            intentMyHeart.putExtra("inputpersonne", this.person);
            startActivity(intentMyHeart);
        }
    }
}