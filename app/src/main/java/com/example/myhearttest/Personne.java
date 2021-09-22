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
    //variables ecrit par le prof

    private String name;
    //private Genre genre;
    private int age;
    private Boolean cardiacCheckUp;
    public static final String DEFAULT_NAME = "UNDEFINED";
//nos variables personnalisée
    private String prenom;
    private Boolean sexe; //homme=false et femme=true;
   // private Integer age;
    private boolean coeur;
    private boolean cholesterol;
    private boolean diabetique;
    private boolean tension;
    private boolean famillePbCoeur;
    private boolean IMC;
    private boolean riskCardio;
    private boolean coeurTest;
    private boolean cardiologue;
    /**
     * Constructor. All members get default values
     */
   // public Person() {
       // this.setName(Person.DEFAULT_NAME);
     //   this.setGenre(Genre.UNDEFINED);
      //  this.setAge(0);
       // this.setCardiacCheckUp(false);
  //  }
    /**
     * @return the description of this class as a String
     */
    /*
    @NonNull
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("\t Name: " + this.getName() + "\n");
        sBuilder.append("\t Genre: ").append(this.getGenre()).append("\n");
        sBuilder.append("\t Age: ").append(this.getAge()).append("\n");
        sBuilder.append("\t Cardiac Checkup: ").append(this.getCardiacCheckUp()).append("\n");
        return sBuilder.toString();
    }

    private String getName() {
    }

    private char[] getGenre() {
    }

    private char[] getAge() {
    }

    private char[] getCardiacCheckUp() {
    }*/

    protected Personne(Parcel in) {
        name = in.readString();
        age = in.readInt();
        byte tmpCardiacCheckUp = in.readByte();
        cardiacCheckUp = tmpCardiacCheckUp == 0 ? null : tmpCardiacCheckUp == 1;
        prenom = in.readString();
        byte tmpSexe = in.readByte();
        sexe = tmpSexe == 0 ? null : tmpSexe == 1;
       /* if (in.readByte() == 0) {
            age = null;
        } else {
            age = in.readInt();
        }*/
        coeur = in.readByte() != 0;
        cholesterol = in.readByte() != 0;
        diabetique = in.readByte() != 0;
        tension = in.readByte() != 0;
        famillePbCoeur = in.readByte() != 0;
        IMC = in.readByte() != 0;
        riskCardio = in.readByte() != 0;
        coeurTest = in.readByte() != 0;
        cardiologue = in.readByte() != 0;
    }

    public static final Creator<Personne> CREATOR = new Creator<Personne>() {
        @Override
        public Personne createFromParcel(Parcel in) {
            return new Personne(in);
        }

        @Override
        public Personne[] newArray(int size) {
            return new Personne[size];
        }
    };

    /**
     * Display this instance's contents
     */
    public void print() {
        System.out.println("Person's attributes: ");
        System.out.print(this);
        System.out.println();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeByte((byte) (cardiacCheckUp == null ? 0 : cardiacCheckUp ? 1 : 2));
        dest.writeString(prenom);
        dest.writeByte((byte) (sexe == null ? 0 : sexe ? 1 : 2));
       /* if (age == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(age);
        }*/
        dest.writeByte((byte) (coeur ? 1 : 0));
        dest.writeByte((byte) (cholesterol ? 1 : 0));
        dest.writeByte((byte) (diabetique ? 1 : 0));
        dest.writeByte((byte) (tension ? 1 : 0));
        dest.writeByte((byte) (famillePbCoeur ? 1 : 0));
        dest.writeByte((byte) (IMC ? 1 : 0));
        dest.writeByte((byte) (riskCardio ? 1 : 0));
        dest.writeByte((byte) (coeurTest ? 1 : 0));
        dest.writeByte((byte) (cardiologue ? 1 : 0));
    }
}

