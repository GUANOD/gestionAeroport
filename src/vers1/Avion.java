package vers1;

import java.util.ArrayList;

abstract class Avion {

    public Avion(){};

    //atributes
    protected String modele;
    protected int nbPlaces;
    protected int distanceMax;
    protected boolean vol_sol = false;
    protected ArrayList<Traveler> travellers;



    protected Avion(String modele, int nbPlaces, int distanceMax) {
        this.modele = modele;
        this.nbPlaces = nbPlaces;
        this.distanceMax = distanceMax;
    }

    //getters/setters

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


    public boolean isVol_sol() {
        return vol_sol;
    }


    public void setVol_sol(boolean vol_sol) {
        this.vol_sol = vol_sol;
    }


    public ArrayList<Traveler> getTravellers() {
        return travellers;
    }

    public void setTravellers(ArrayList<Traveler> travellers) {
        this.travellers = travellers;
    }

    //methods

    public void addTraveler(Traveler traveler){
        travellers.add(traveler);
    };

    public void fly(){
        if(this.vol_sol){
            this.vol_sol=false;
            System.out.println("##### " + this.modele + " has landed #####");
            for (Traveler traveler : travellers){
                System.out.println(traveler.getNom() + " " + traveler.getPrenom() + " age " + traveler.getAge()+ " has arrived at " + traveler.getBillet().getDestination());
            }
        }else{
            this.vol_sol= true;
            System.out.println(this.modele + " prends vol");
        }
    };

    public void  showTravelerList(){
        System.out.println("##### Passengers in " +this.modele+ " #####");
        for (Traveler traveler : travellers){
            System.out.println(traveler.getNom() + " " + traveler.getPrenom() + " age " + traveler.getAge());
        }
    };
}
