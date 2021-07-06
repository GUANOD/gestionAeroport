package vers1;

public class Billet {

    //atributes
    private double prix;
    private Destination destination;
    private Traveler traveler;
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
