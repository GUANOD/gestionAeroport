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
    }

    //getters/setters

    public double getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
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

    //methods

//    public void addDestination(String destination){
//        this.destination = destination;
//    }

//    public void addPassager(){
//        ugh??
//    }

//    public void addPrice(){
//        uuuuggggggh???
//    }

}
