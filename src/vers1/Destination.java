package vers1;

import java.util.ArrayList;

public class Destination {

    String nom;
    double prix ;
    Avion avion;
    int distance;

    //construc
    public Destination(String nom, double prix, int distance) {
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }


    public Avion getAvion() {
        return avion;
    }

    public void setAvions(ArrayList<Avion> avions) {
        this.avion = avion;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
