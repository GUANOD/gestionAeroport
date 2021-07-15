package vers1;

import java.util.ArrayList;

public class Main {
    public static <integer> void main(String[] args){

        //create aeroport
        Aeroport AeroLourdes = new Aeroport("Lourdes", 20);

        //add avions
        AeroLourdes.AddToAvions(new AvionGL("Airbus A380", 853, 15000));
        AeroLourdes.AddToAvions(new AvionLI("Embraer 175", 78, 4074 ));
        AeroLourdes.AddToAvions(new AvionGL("Embraer 200", 400, 10000 ));
        AeroLourdes.AddToAvions(new AvionLI("Airbus A2", 50, 3500));

        //create destinations
        AeroLourdes.addToDestinations( new Destination("Maldives", 1999.58, 2000 ));
        AeroLourdes.addToDestinations( new Destination("Greece", 2190.00, 530 ));
        AeroLourdes.addToDestinations( new Destination("Tarbes", 100, 30));
        AeroLourdes.addToDestinations( new Destination("NY", 239.59, 5320));

        // add avion to destinations
        AeroLourdes.getDestinations().get(0).setAvions(AeroLourdes.getAvions().get(0));
        AeroLourdes.getDestinations().get(1).setAvions(AeroLourdes.getAvions().get(1));
        AeroLourdes.getDestinations().get(2).setAvions(AeroLourdes.getAvions().get(3));
        AeroLourdes.getDestinations().get(3).setAvions(AeroLourdes.getAvions().get(2));

        // create passengers
        AeroLourdes.getTravelers().add(new Traveler("Alba", "Jessica", 40));
        AeroLourdes.getTravelers().add(new Traveler("Portman", "Natalie", 40));
        AeroLourdes.getTravelers().add(new Traveler("Ratajkowski", "Emily", 30));
        AeroLourdes.getTravelers().add(new Traveler("Paradis", "Vanessa", 30));
        AeroLourdes.getTravelers().add(new Traveler("Itre", "Mayte", 60));
        AeroLourdes.getTravelers().add(new Traveler("Bardot", "Brigitte", 30));
        AeroLourdes.getTravelers().add(new Traveler("Macron", "Brigitte", 70));
        AeroLourdes.getTravelers().add(new Traveler("B", "Cardi", 43));
        AeroLourdes.getTravelers().add(new Traveler("Lavigne", "Avril", 16));

        //test remplir avion

//        ArrayList <Traveler> group = new ArrayList<>();
//
//        for(int i =0; i<77; i++){
//            group.add(new Traveler("Alba", "Jessica", 40));
//        }

//        psngr1.buyBillet(AeroLourdes.getDestinations().get(1));
//
//        System.out.println("avant: " + psngr1.getBillet().getDestination().getAvion().getNbPLaceDispo().size());
//
//        for (Traveler pass: group){
//            pass.buyBillet(AeroLourdes.getDestinations().get(1));
//            System.out.println("places dispo apres : " +pass.getBillet().getDestination().getAvion().getNbPLaceDispo().size());
//            System.out.println("place du pass : "+ pass.getBillet().getPlace());
//        }


//        buy tickets
       AeroLourdes.getTravelers().get(0).buyBillet(AeroLourdes.getDestinations().get(0));
       AeroLourdes.getTravelers().get(1).buyBillet(AeroLourdes.getDestinations().get(1));
       AeroLourdes.getTravelers().get(2).buyBillet(AeroLourdes.getDestinations().get(3));
       AeroLourdes.getTravelers().get(3).buyBillet(AeroLourdes.getDestinations().get(2));
       AeroLourdes.getTravelers().get(4).buyBillet(AeroLourdes.getDestinations().get(3));
       AeroLourdes.getTravelers().get(5).buyBillet(AeroLourdes.getDestinations().get(1));
       AeroLourdes.getTravelers().get(6).buyBillet(AeroLourdes.getDestinations().get(0));
       AeroLourdes.getTravelers().get(7).buyBillet(AeroLourdes.getDestinations().get(2));
       AeroLourdes.getTravelers().get(8).buyBillet(AeroLourdes.getDestinations().get(3));

        // show destination, plane, and ticket price for each passenger

        for (Traveler pass : AeroLourdes.getTravelers()){
            System.out.println(pass.getNom()
                    + " achete un billet vers " + pass.getBillet().getDestination().getNom()
                    + " dans un " + pass.getBillet().getDestination().getAvion().getModele()
                    + " assise a la place " + pass.getBillet().getPlace()
                    + " pour un prix de " + pass.getBillet().getPrix());
        }

        //delete 1 ticket

        AeroLourdes.getTravelers().get(2).deleteTravel("Annulation");

        // jump too plane

        for (Traveler pass : AeroLourdes.getTravelers()){
            pass.goToPlane();
        }
//
        //show travellers

        for (Avion avion : AeroLourdes.getAvions()){
            avion.showTravelerList();
        }

        // fly

        for(Avion avion :AeroLourdes.getAvions()){
            avion.fly();
        }

        for(Avion avion :AeroLourdes.getAvions()){
            avion.fly();
        }

        // land

        for(Avion avion :AeroLourdes.getAvions()){
            avion.land();
        }

    }
}
