package vers1;

import java.util.ArrayList;

public class Aeroport {

    //atributes

    private String lieu;
    private int capacite;
    private ArrayList<Avion> avions;
    private ArrayList<Billet> billets;
    private ArrayList<Destination> destinations;

    //constr
    public Aeroport(String lieu, int capacite) {
        this.lieu = lieu;
        this.capacite = capacite;
    }

    //getters/setters
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getCapacite() {
        return capacite;
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public ArrayList<Avion> getAvions() {
        return avions;
    }

    public void setAvions(ArrayList<Avion> avions) {
        this.avions = avions;
    }

    public ArrayList<Billet> getBillets() {
        return billets;
    }

    public void setBillets(ArrayList<Billet> billets) {
        this.billets = billets;
    }

    //methods
    public void AddToAvions(Avion avion){
        this.avions.add(avion);
    }

    public void addToDestinations(Destination destination){
        this.destinations.add(destination);
    }

    public void showDispoAvions(){
        for (Avion avion : avions){
            System.out.println(avion.toString());
        }
    }

    public Billet editBillet(){
        return null;
    }

    public void ShowNbPlaceByAvion(){
        for(Avion avion : avions){
            System.out.println(avion.getNbPlaces());
        }
    }

//    public static Billet generateBillet() {
//        return new Billet()
//    }
}
