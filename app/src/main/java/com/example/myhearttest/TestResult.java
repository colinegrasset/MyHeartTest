package com.example.myhearttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class TestResult extends AppCompatActivity {

    private String url;
    private Personne person;

    private TextView genre;
    private TextView age;

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

    private int BonusMalus;
    private int ScoreActi1;
    private int ScoreActi2;
    private int ScoreActi3;

    private String Color1;
    private String Color2;
    private String Color3;

    private static final String TestResult = "src/main/res/layout/activity_test_result.xml";
    private static final String TestResultLand = "src/main/res/layout-land/activity_test_result.xml";
    private XPath xPath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        url ="https://fedecardio.org/je-me-teste/";
        person = new Personne();
        processIntentData();

        genre = findViewById(R.id.textViewGenderInput);
        age = findViewById(R.id.textViewAgeInput);

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

        afficheResultats();

        //calcul score page Iam qui va influencer en bonus ou malus sur les autres scores
        // Plus le score avoisine zéro meilleure est la santé de la personne
        if(P1Q2.toString().equals("MAN")) {
            if (P1Q1 > 50) {
                BonusMalus = +1;
            }else{
                BonusMalus = -1;
            }
        }else if (P1Q2.toString().equals("WOMAN")) {
            if (P1Q1 > 60) {
                BonusMalus = +1;
            }else{
                BonusMalus = -1;
            }

        }else{
            if (P1Q1 > 50) {
                BonusMalus = +1;
            }else{
                BonusMalus = -1;
            }
        }
        Log.d("Bonus ou malus de la personne:",String.valueOf(BonusMalus));

        //Calcul score page myHeart

        // si c'est vrai alors +1 sinon +0
        if(P2Q1){
            ScoreActi1 = 1;
        }else{
            ScoreActi1 = 0;
        }

        if(P2Q2){
            ScoreActi1 = ScoreActi1 + 1;
        }
        if(P2Q3){
            ScoreActi1 = ScoreActi1 + 1;
        }
        if(P2Q4){
            ScoreActi1 = ScoreActi1 + 1;
        }
        if(P2Q5){
            ScoreActi1 = ScoreActi1 + 1;
        }
        if(P2Q6.equals("Poids_normal")){
            ScoreActi1 = ScoreActi1 - 1;
        }
        ScoreActi1 = ScoreActi1 + BonusMalus;
        Log.d("Score de l'acti myHeart:",String.valueOf(ScoreActi1));

        //calcul score page mheartmonitoring
        if(P3Q1){
            ScoreActi2 = 1;
        }else{
            ScoreActi2 = 0;
        }

        if(P3Q2){
            ScoreActi2 = ScoreActi2 + 1;
        }
        if(P3Q3) {
            ScoreActi2 = ScoreActi2 + 1;
        }
        ScoreActi2 = ScoreActi2 + BonusMalus;
        Log.d("Score de l'acti myHeartMonitoring:",String.valueOf(ScoreActi2));

        //calcul score page habitdiet
        if(P4Q1){
            ScoreActi3 = 1;
        }else{
            ScoreActi3 = 0;
        }

        if(P4Q2){
            ScoreActi3 = ScoreActi3 + 1;
        }
        if(P4Q3) {
            ScoreActi3 = ScoreActi3 + 1;
        }
        if(P4Q4) {
            ScoreActi3 = ScoreActi3 + 1;
        }
        if(P4Q5) {
            ScoreActi3 = ScoreActi3 + 1;
        }
        if(P4Q6) {
            ScoreActi3 = ScoreActi3 + 1;
        }
        if(P4Q7) {
            ScoreActi3 = ScoreActi3 + 1;
        }
        if(P4Q8) {
            ScoreActi3 = ScoreActi3 + 1;
        }
        if(P4Q9) {
            ScoreActi3 = ScoreActi3 + 1;
        }
        ScoreActi3 = ScoreActi3 + BonusMalus;
        Log.d("Score de l'acti myHabitDiet:",String.valueOf(ScoreActi3));

        // Détermination de la couleur des 3 fonds des EditText affichage conseil

                // les id des textview que je dois modifier:
                // myHeartAdvice
                //myHeartMonitoringAdvice
                //myHabitDietAdvice2
                // c'est ce parametre que je dois changer :   android:background="#DCDCDC"
                // couleur verte: #7CD181
                // couleur rouge: #DF6F6F*

        if(ScoreActi1>=2){
            Color1 = "#DF6F6F*";
        }else {
            Color1 = "#7CD181";
        }
        if(ScoreActi2>=2){
            Color2 = "#DF6F6F*";
        }else {
            Color2 = "#7CD181";
        }
        if(ScoreActi3>=2){
            Color3 = "#DF6F6F*";
        }else {
            Color3 = "#7CD181";
        }

        // je charge mon fichier activité testresult
        try {
            File data = new File(TestResult);
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            Document doc = ((DocumentBuilder) b).parse(new File(TestResult));
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        //Je modifie les couleurs de mon fichier
        xPath = XPathFactory.newInstance().newXPath();
        Node BackGroundColor1 = null;
        Node BackGroundColor2 = null;
        Node BackGroundColor3 = null;
        try {
            BackGroundColor1 =
                    (Node) xPath.compile("/ScrollView/LinearLayout/" +
                            "androidx.constraintlayout.widget.ConstraintLayout/" +
                            "@+id/myHeartAdvice/background").evaluate(
                                    TestResult, XPathConstants.NODE);

            BackGroundColor2 =
                    (Node) xPath.compile("/ScrollView/LinearLayout/" +
                            "androidx.constraintlayout.widget.ConstraintLayout/" +
                            "@+id/myHeartMonitoringAdvice/background").evaluate(
                            TestResult, XPathConstants.NODE);

            BackGroundColor3 =
                    (Node) xPath.compile("/ScrollView/LinearLayout/" +
                            "androidx.constraintlayout.widget.ConstraintLayout/" +
                            "@+id/myHabitDietAdvice2/background").evaluate(
                            TestResult, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        BackGroundColor1.setTextContent(Color1);
        BackGroundColor2.setTextContent(Color2);
        BackGroundColor3.setTextContent(Color3);

        // Appliquer les changement dans le fichier test result
        Transformer tf = null;
        try {
            tf = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty(OutputKeys.METHOD, "xml");
        tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource domSource1 = new DOMSource(BackGroundColor1);
        DOMSource domSource2 = new DOMSource(BackGroundColor2);
        DOMSource domSource3 = new DOMSource(BackGroundColor3);
        StreamResult sr = new StreamResult(new File(TestResult));
        try {
            tf.transform(domSource1, sr);
            tf.transform(domSource2, sr);
            tf.transform(domSource3, sr);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

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
                Log.d(MyHabitDiet.TAG, "No Person found after transfer from MyH");
            }
        }
        else {
            Log.d(MyHabitDiet.TAG, "Error when transferring from MyHeartMonito");
        }
    }

    public void afficheResultats(){
        genre.setText(P1Q2.toString());
        age.setText(Integer.toString(P1Q1));
    }

    public void goToSite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void quitTest(View view) {
        finishAffinity();
    }

    //ToDo Calculer les scores des 3 activités
    //ToDo en fonction du score mettre couleur spécifique a la zone texte
    //ToDo insérer le bon texte et modifier couleur au textView des 3 conseils.

}