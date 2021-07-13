package vers1;

import java.util.ArrayList;

abstract class Avion<integer> {

    public Avion(){}

    //atributes
    protected String modele;
    protected int nbPlaces;
    protected int distanceMax;
    protected boolean vol_sol = false;
    protected ArrayList<Traveler> travelers;
    protected ArrayList<Integer> nbPLaceDispo;
    protected Destination destination;


    protected Avion(String modele, int nbPlaces, int distanceMax) {
        this.modele = modele;
        this.nbPlaces = nbPlaces;
        this.distanceMax = distanceMax;
        this.travelers = new ArrayList<>();
        populatePlaceDispo();
    }

    //getters/setters

    public boolean setVol_sol() {
        return vol_sol;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public ArrayList<Integer> getNbPLaceDispo() {
        return nbPLaceDispo;
    }

    public void setNbPLaceDispo(ArrayList<Integer> nbPLaceDispo) {
        this.nbPLaceDispo = nbPLaceDispo;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }


    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }


    public int getDistanceMax() {
        return distanceMax;
    }


    public void setDistanceMax(int distanceMax) {
        this.distanceMax = distanceMax;
    }


    public boolean getVol_sol() {
        return vol_sol;
    }

    public ArrayList<Traveler> getTravelers() {
        return travelers;
    }

    public void setTravelers(ArrayList<Traveler> travelers) {
        this.travelers = travelers;
    }

    //methods

    private void populatePlaceDispo(){
        this.nbPLaceDispo = new ArrayList<>();
        for (int i = 0; i < this.nbPlaces; i++){
            nbPLaceDispo.add(i+1);
        }
    }

    public void addTraveler(Traveler traveler){
        travelers.add(traveler);
    }

    public void fly() {  //TODO:
        if (this.vol_sol) {
            System.out.println(this.modele + " is already on road to " + this.destination.getNom());
        } else {
            System.out.println(this.modele + " All systems okay");
            this.vol_sol = true;
            System.out.println(this.modele + " Took off to " + this.destination.getNom() + " with " + this.travelers.size() + " passengers.");
        }
    }

    public void land(){
        if (!this.vol_sol){
            System.out.println(this.modele + " is landed with " + this.travelers.size() + " passengers waiting.");
        } else{
            this.vol_sol=false;
            System.out.println(this.modele + " has landed");
            for (Traveler traveler : this.travelers){
                traveler.setEmbarque(false);
                traveler.setBillet(null);
                System.out.println(traveler.getPrenom() + " " + traveler.getNom() + " got out of " + this.modele + " at "+ this.destination.getNom());
            }
            this.travelers = new ArrayList<>();
            populatePlaceDispo();
        }
    }

    public void  showTravelerList(){
        System.out.println("##### Passengers in " +this.modele+ " #####");
        for (Traveler traveler : travelers){
            System.out.println(traveler.getNom() + " " + traveler.getPrenom() + " age " + traveler.getAge());
        }
    }
}
