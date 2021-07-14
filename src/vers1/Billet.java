package vers1;

public class Billet {

    //atributes
    private double prix;
    private Destination destination;
    private Traveler traveler;
    //jai rajoute l'avion ici au lieu de le rajouter dans traveller car il me parait plus logique
    private Avion avion;
    private int place;

    //construct

    public Billet(Destination destination, Traveler traveler) {
        this.prix = destination.getPrix();
        this.destination = destination;
        this.traveler = traveler;
        this.avion = destination.getAvion();
    }

    //getters/setters

    public double getPrix() {
        return prix;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
        this.prix=destination.getPrix();
    }

    public Destination getDestination() {
        return destination;
    }


    public Traveler getTraveler() {
        return traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }

}
