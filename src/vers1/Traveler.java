package vers1;

import java.util.Random;

public class Traveler {

    //atributes
    private String nom;
    private String prenom;
    private int age;
    private Billet billet;
    private  boolean embarque = false;
    private boolean passSanitaire;
    private Aeroport airport;

    // construct
    public Traveler(String nom, String prenom, int age, Aeroport airport) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.passSanitaire = new Random().nextBoolean();
        this.airport= airport;
    }

    //getters/setters


    public Aeroport getAirport() {
        return airport;
    }

    public void setAirport(Aeroport airport) {
        this.airport = airport;
    }

    public boolean getEmbarque() {
        return embarque;
    }

    public void setEmbarque(boolean embarque) {
        this.embarque = embarque;
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

    public void buyBillet(Destination destination){
        if (this.billet != null){
            System.out.println(this.prenom + " already has a ticket");
        }else{
            this.billet= new Billet(destination, this);
            Avion avion = this.billet.getDestination().getAvion();
            int index = new Random().nextInt(avion.getNbPLaceDispo().size());
            this.billet.setPlace((int) avion.getNbPLaceDispo().get(index));
            avion.nbPLaceDispo.remove(index);
            System.out.println(this.prenom + " bought a ticket");
            this.airport.getBillets().add(this.billet);
        }
    }

    public void deleteTravel(String reason){
        this.billet.getAvion().getNbPLaceDispo().add(this.billet.getPlace());
        this.airport.getBillets().remove(this.billet);
        this.billet = null;
        System.out.println(this.nom + " Billet reemboursee car " + reason);
    }

    public void goToPlane(){
        if (this.billet == null){
            System.out.println(this.getNom() + " does not have a ticket");
            return;
        }

        if (!this.passSanitaire){
            System.out.println(this.nom + " is dirty!! NO FLY TO " + this.billet.getDestination().getNom().toUpperCase());
            deleteTravel("Strong with the SICKNESS");
            return;
        }

        if(this.embarque){
            System.out.println(this.prenom + " est deja dans " + this.getBillet().getDestination().getAvion().getModele());

        }else{
            this.getBillet().getDestination().getAvion().addTraveler(this);
            this.embarque=true;
            System.out.println(this.prenom + " embarque " + this.getBillet().getDestination().getAvion().getModele());
        }
    }
}
