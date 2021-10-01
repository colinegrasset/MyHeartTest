package com.example.myhearttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class myHabitDiet extends AppCompatActivity {

    public static final String TAG = "myHabitDiet";

    private ChipGroup chipGroupQ2;
    private Chip chipQ2Breakfast;
    private Chip chipQ2Lunch;
    private Chip chipQ2Diner;
    private Chip chipQ2Snacking;
    private CheckBox checkBoxQ1Meat;
    private CheckBox checkBoxQ1FruitsVege;
    private CheckBox checkBoxQ1Starchy;
    private CheckBox checkBoxQ1Legumes;
    private CheckBox checkBoxQ1CakesSweet;
    private Personne person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_habit_diet);
        person = new Personne();
        processIntentData();
        chipGroupQ2 = findViewById(R.id.ChipGroupQ2);
        chipQ2Breakfast = findViewById(R.id.chip1Breakfast);
        chipQ2Lunch = findViewById(R.id.chipLunch);
        chipQ2Diner = findViewById(R.id.chipDiner);
        chipQ2Snacking = findViewById(R.id.chipSnacking);
        checkBoxQ1Meat = findViewById(R.id.checkBoxMeat);
        checkBoxQ1FruitsVege = findViewById(R.id.checkBoxFruitVege);
        checkBoxQ1Starchy = findViewById(R.id.checkBoxStarchy);
        checkBoxQ1Legumes = findViewById(R.id.checkBoxLegumes);
        checkBoxQ1CakesSweet = findViewById(R.id.checkBoxCakesSweet);
        Log.d("myHabitDietOnCreate", "page  my habit diet");
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
                Log.d(myHabitDiet.TAG, "No Person found after transfer from MainActivity");
            }
        }
        else {
            Log.d(myHabitDiet.TAG, "Error when transferring from MainActivity");
        }
    }

    public void previousStep(View view) {
        Log.d("myHabitDietPreviousStep", "bouton previous step");
        onBackPressed();
    }

    public void finishTest(View view) {
        Log.d("IAmNextStep", "bouton next step");
        Log.d("IAmNextStepName", person.getName());
        if (((checkBoxQ1CakesSweet.isChecked() == false) & (checkBoxQ1Meat.isChecked() == false) & (checkBoxQ1Legumes.isChecked() == false) & (checkBoxQ1FruitsVege.isChecked() == false) & (checkBoxQ1Starchy.isChecked() == false)) | ((chipQ2Breakfast.isChecked() == false)&(chipQ2Lunch.isChecked() == false)&(chipQ2Diner.isChecked() == false)&(chipQ2Snacking.isChecked() == false))){
            Toast.makeText(this,R.string.error_next_step, Toast.LENGTH_LONG).show();
        }else{
            if(checkBoxQ1CakesSweet.isChecked()){
                person.setCakeSweet(true);
            }
            if(checkBoxQ1Meat.isChecked()){
                person.setMeat(true);
            }
            if(checkBoxQ1FruitsVege.isChecked()){
                person.setFruitsVege(true);
            }
            if(checkBoxQ1Starchy.isChecked()){
                person.setStarchy(true);
            }
            if(checkBoxQ1Legumes.isChecked()){
                person.setLegumes(true);
            }
            if(chipQ2Breakfast.isChecked()){
                person.setBreakfast(true);
            }
            if(chipQ2Lunch.isChecked()){
                person.setLunch(true);
            }
            if(chipQ2Diner.isChecked()){
                person.setDiner(true);
            }
            if(chipQ2Snacking.isChecked()){
                person.setSnacking(true);
            }
            Intent intentMyHeart;
            intentMyHeart = new Intent(this, TestResult.class);
            intentMyHeart.putExtra("inputpersonne", this.person);
            startActivity(intentMyHeart);
        }
    }
}