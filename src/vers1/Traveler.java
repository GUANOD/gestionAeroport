package vers1;

import java.util.Random;

public class Traveler {

    //tools
    private Random random = new Random();

    //atributes
    private String nom;
    private String prenom;
    private int age;
    private Billet billet;
    private  boolean embarque = false;

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

                int index = random.nextInt(avion.getNbPLaceDispo().size());
                this.billet.setPlace((int) avion.getNbPLaceDispo().get(index));
                avion.nbPLaceDispo.remove(index);

            System.out.println(this.prenom + " bought a ticket");
        }
    }

    public void deleteTravel(){
        this.billet = null;
        System.out.println("Billet reemboursee");
    }

    public void goToPlane(){
        if(this.embarque){
            System.out.println(this.prenom + " est deja dans " + this.getBillet().getDestination().getAvion().getModele());
        }else{
            this.getBillet().getDestination().getAvion().addTraveler(this);
            this.embarque=true;
            System.out.println(this.prenom + " embarque " + this.getBillet().getDestination().getAvion().getModele());
        }
    }
}
