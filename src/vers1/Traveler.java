package vers1;

import javax.print.attribute.standard.Destination;
import java.util.Random;

public class Traveler {

    //atributes
    private String nom;
    private String prenom;
    private int age;
    private Billet billet;
    private  boolean embarque = false;
    private Avion avion;

    // construct
    public Traveler(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    //getters/setters

    public boolean isEmbarque() {
        return embarque;
    }

    public void setEmbarque(boolean embarque) {
        this.embarque = embarque;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    //methods

    public void buyBillet(String destination, double prix){
        if (this.billet != null){
            System.out.println(this.prenom + " already has a ticket");
        }else{
            this.billet= new Billet((float)prix, destination, this);

            System.out.println(this.prenom + " bought a ticket");
        }
    }

    public void deleteTravel(){
        this.billet = null;
        System.out.println("Billet reemboursee");
    }

    public void goToPlane(Avion avion){
        if(this.embarque){
            System.out.println(this.prenom + " est deja dans " + this.avion.getModele());
        }else{
            avion.addTraveler(this);
            this.embarque=true;
            this.avion=avion;
            System.out.println(this.prenom + " embarque " + this.avion.getModele());
        }
    }
}
