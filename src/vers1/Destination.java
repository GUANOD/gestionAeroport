package vers1;

import java.util.ArrayList;

public class Destination {

    String nom;
    int prix ;
    ArrayList<Avion> avions;
    int distance;

    //construc
    public Destination(String nom, int prix, int distance) {
        this.nom = nom;
        this.prix = prix;
        this.distance = distance;
    }

    //getters/setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }


    public ArrayList<Avion> getAvions() {
        return avions;
    }

    public void setAvions(ArrayList<Avion> avions) {
        this.avions = avions;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
