package vers1;

public class Billet {

    //atributes
    private float prix;
    private String destination;
    private Traveler traveler;

    //construct

    public Billet(float prix, String destination, Traveler traveler) {
        this.prix = prix;
        this.destination = destination;
        this.traveler = traveler;
    }

    //getters/setters

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
