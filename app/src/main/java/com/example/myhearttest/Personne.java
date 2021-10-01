package com.example.myhearttest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Class storing data fetched through activities.
 * Must implement Parcelable to be used with Intents.
 * https://developer.android.com/reference/android/os/Parcelable#java
 */
public class Personne implements Parcelable {
    private String name;
    private Genre genre;
    private int age;
    private Boolean breakfast;
    private Boolean lunch;
    private Boolean diner;
    private Boolean snacking;
    private Boolean meat;
    private Boolean fruitsVege;
    private Boolean starchy;
    private Boolean legumes;
    private Boolean cakeSweet;
    private Boolean coeur;
    private Boolean cholesterol;
    private Boolean diabetique;
    private Boolean tension;
    private Boolean famillePbCoeur;
    private String IMC;
    private Boolean riskCardio;
    private Boolean coeurTest;
    private Boolean cardiologue;
    public static final String DEFAULT_NAME = "UNDEFINED";

    /**
     * Constructor. All members get default values
     */
    public Personne() {
        this.setName(Personne.DEFAULT_NAME);
        this.setGenre(Genre.UNDEFINED);
        this.setAge(0);
        this.setBreakfast(false);
        this.setLunch(false);
        this.setDiner(false);
        this.setSnacking(false);
        this.setMeat(false);
        this.setFruitsVege(false);
        this.setStarchy(false);
        this.setLegumes(false);
        this.setCakeSweet(false);
        this.setCoeur(false);
        this.setCholesterol(false);
        this.setDiabetique(false);
        this.setTension(false);
        this.setFamillePbCoeur(false);
        this.setIMC(Personne.DEFAULT_NAME);
        this.setRiskCardio(false);
        this.setCoeurTest(false);
        this.setCardiologue(false);
    }
    /**
     * @return the description of this class as a String
     */
    @NonNull
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("\t Name: " + this.getName() + "\n");
        sBuilder.append("\t Genre: ").append(this.getGenre()).append("\n");
        sBuilder.append("\t Age: ").append(this.getAge()).append("\n");
        sBuilder.append("\t Heart Problem: ").append(this.getCoeur()).append("\n");
        sBuilder.append("\t Cholesterol: ").append(this.getCholesterol()).append("\n");
        sBuilder.append("\t Diabetique: ").append(this.getDiabetique()).append("\n");
        sBuilder.append("\t Tension: ").append(this.getTension()).append("\n");
        sBuilder.append("\t Family Heart Problems: ").append(this.getFamillePbCoeur()).append("\n");
        sBuilder.append("\t IMC: ").append(this.getIMC()).append("\n");
        sBuilder.append("\t Risk cardio: ").append(this.getRiskCardio()).append("\n");
        sBuilder.append("\t Heart CheckUp: ").append(this.getCoeurTest()).append("\n");
        sBuilder.append("\t Rdv Cardiologue: ").append(this.getCardiologue()).append("\n");
        sBuilder.append("\t Take Breakfast: ").append(this.getBreakfast()).append("\n");
        sBuilder.append("\t Take Lunch: ").append(this.getLunch()).append("\n");
        sBuilder.append("\t Take Diner: ").append(this.getDiner()).append("\n");
        sBuilder.append("\t Take Snacking: ").append(this.getSnacking()).append("\n");
        sBuilder.append("\t Take Meat: ").append(this.getMeat()).append("\n");
        sBuilder.append("\t Take Fruits and vegetables: ").append(this.getFruitsVege()).append("\n");
        sBuilder.append("\t Take Starchy: ").append(this.getStarchy()).append("\n");
        sBuilder.append("\t Take Legumes: ").append(this.getLegumes()).append("\n");
        sBuilder.append("\t Take Cakes and sweet: ").append(this.getCakeSweet()).append("\n");
        return sBuilder.toString();
    }
    /**
     * Display this instance's contents
     */
    public void print() {
        System.out.println("Person's attributes: ");
        System.out.print(this);
        System.out.println();
    }

    /*
        * Getters / Setters
    */
    public String getName() { return this.name; }
    public void setName(String aName) { this.name = aName; }
    public Genre getGenre() { return this.genre; }
    public void setGenre(Genre aGenre) { this.genre = aGenre; }
    public int getAge() { return this.age; }
    public void setAge(int anAge) { this.age = anAge; }
    public Boolean getBreakfast() { return this.breakfast; }
    public void setBreakfast(Boolean aCardiacCheckUp) { this.breakfast = aCardiacCheckUp; }
    public Boolean getCoeur() { return coeur; }
    public void setCoeur(Boolean coeur) { this.coeur = coeur; }
    public Boolean getCholesterol() {
        return cholesterol;
    }
    public void setCholesterol(Boolean cholesterol) {
        this.cholesterol = cholesterol;
    }
    public Boolean getDiabetique() {
        return diabetique;
    }
    public void setDiabetique(Boolean diabetique) {
        this.diabetique = diabetique;
    }
    public Boolean getTension() {
        return tension;
    }
    public void setTension(Boolean tension) {
        this.tension = tension;
    }
    public Boolean getFamillePbCoeur() {
        return famillePbCoeur;
    }
    public void setFamillePbCoeur(Boolean famillePbCoeur) {
        this.famillePbCoeur = famillePbCoeur;
    }
    public String getIMC() {
        return IMC;
    }
    public void setIMC(String IMC) {
        this.IMC = IMC;
    }
    public Boolean getRiskCardio() {
        return riskCardio;
    }
    public void setRiskCardio(Boolean riskCardio) {
        this.riskCardio = riskCardio;
    }
    public Boolean getCoeurTest() {
        return coeurTest;
    }
    public void setCoeurTest(Boolean coeurTest) {
        this.coeurTest = coeurTest;
    }
    public Boolean getCardiologue() {
        return cardiologue;
    }
    public void setCardiologue(Boolean cardiologue) {
        this.cardiologue = cardiologue;
    }
    public Boolean getLunch() {
        return lunch;
    }
    public void setLunch(Boolean lunch) { this.lunch = lunch; }
    public Boolean getDiner() {
        return diner;
    }
    public Boolean getSnacking() {
        return snacking;
    }
    public Boolean getMeat() {
        return meat;
    }
    public Boolean getFruitsVege() {
        return fruitsVege;
    }
    public Boolean getStarchy() {
        return starchy;
    }
    public Boolean getLegumes() {
        return legumes;
    }
    public Boolean getCakeSweet() {
        return cakeSweet;
    }
    public void setDiner(Boolean diner) {
        this.diner = diner;
    }
    public void setSnacking(Boolean snacking) {
        this.snacking = snacking;
    }
    public void setMeat(Boolean meat) {
        this.meat = meat;
    }
    public void setFruitsVege(Boolean fruitsVege) {
        this.fruitsVege = fruitsVege;
    }
    public void setStarchy(Boolean starchy) {
        this.starchy = starchy;
    }
    public void setLegumes(Boolean legumes) {
        this.legumes = legumes;
    }
    public void setCakeSweet(Boolean cakeSweet) {
        this.cakeSweet = cakeSweet;
    }

    @Override // Parcelable method
    public int describeContents() { return 0;}

    @Override // Parcelable method
    public void writeToParcel(Parcel dest, int flags) {
    // Both reading and writing orderings must match (see Person(Parcel in) method)
        dest.writeString(this.getName());
        dest.writeInt(this.getGenre().ordinal());
        dest.writeInt(this.getAge());
    // dest.writeBoolean() requires API 29
    // If the error "current min is set to <Number lesser than 29>"
    // => Edit Gradle scripts -> build.gradle (Module: YourApp.app)
    // ==> change "minSdK <Number lesser than 29>" to "minSdk 29"
    // (this SDK must be installed)
        dest.writeBoolean(this.getBreakfast());
        dest.writeBoolean(this.getCoeur());
        dest.writeBoolean(this.getCholesterol());
        dest.writeBoolean(this.getDiabetique());
        dest.writeBoolean(this.getTension());
        dest.writeBoolean(this.getFamillePbCoeur());
        dest.writeString(this.getIMC());
        dest.writeBoolean(this.getRiskCardio());
        dest.writeBoolean(this.getCoeurTest());
        dest.writeBoolean(this.getCardiologue());
        dest.writeBoolean(this.getBreakfast());
        dest.writeBoolean(this.getLunch());
        dest.writeBoolean(this.getDiner());
        dest.writeBoolean(this.getSnacking());
        dest.writeBoolean(this.getMeat());
        dest.writeBoolean(this.getFruitsVege());
        dest.writeBoolean(this.getStarchy());
        dest.writeBoolean(this.getLegumes());
        dest.writeBoolean(this.getCakeSweet());
    }
    /**
     * https://developer.android.com/reference/android/os/Parcelable#java */
    public static final Parcelable.Creator<Personne> CREATOR
            = new Parcelable.Creator<Personne>() {
        public Personne createFromParcel(Parcel in) {
            return new Personne(in);
        }
        public Personne[] newArray(int size) {
            return new Personne[size];
        }
    };
    /**
     * https://developer.android.com/reference/android/os/Parcelable#java
     */
    private Personne(Parcel in) {
// Both reading and writing orderings must match (see writeToParcel method)
        this.setName(in.readString());
        this.setGenre(Genre.values()[in.readInt()]);
        this.setAge(in.readInt());
        this.setBreakfast(in.readBoolean());
        this.setCoeur(in.readBoolean());
        this.setCholesterol(in.readBoolean());
        this.setDiabetique(in.readBoolean());
        this.setTension(in.readBoolean());
        this.setFamillePbCoeur(in.readBoolean());
        this.setIMC(in.readString());
        this.setRiskCardio(in.readBoolean());
        this.setCoeurTest(in.readBoolean());
        this.setCardiologue(in.readBoolean());
        this.setBreakfast(in.readBoolean());
        this.setLunch(in.readBoolean());
        this.setDiner(in.readBoolean());
        this.setSnacking(in.readBoolean());
        this.setMeat(in.readBoolean());
        this.setFruitsVege(in.readBoolean());
        this.setStarchy(in.readBoolean());
        this.setLegumes(in.readBoolean());
        this.setCakeSweet(in.readBoolean());
    }


}

