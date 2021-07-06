package vers1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        //create aeroport
        Aeroport AeroLourdes = new Aeroport("Lourdes", 20);

        //add avions
        AeroLourdes.AddToAvions(new AvionGL("Airbus A380", 853, 15000));
        AeroLourdes.AddToAvions(new AvionLI("Embraer 175", 78, 4074 ));

        //create destinations
        AeroLourdes.addToDestinations( new Destination());

        // create passengers
        Traveler psngr1 = new Traveler("Alba", "Jessica", 40);
        Traveler psngr2 = new Traveler("Portman", "Natalie", 40);
        Traveler psngr3 = new Traveler("Ratajkowski", "Emily", 30);

        //buy tickets

        psngr1.buyBillet("Lourdes", 2000);
        psngr2.buyBillet("Greece", 2190.99);
        psngr3.buyBillet("Maldives", 1999.58);

        // test limits
        psngr1.buyBillet("Maldives", 2000);
        psngr2.buyBillet("Greece", 2190.99);
        psngr3.buyBillet("Maldives", 1999.58);

        // jump too plane

        psngr1.goToPlane(AeroLourdes.getAvions().get(0));
        psngr2.goToPlane(AeroLourdes.getAvions().get(1));
        psngr3.goToPlane(AeroLourdes.getAvions().get(0));

        //test
        psngr1.goToPlane(AeroLourdes.getAvions().get(0));
        psngr2.goToPlane(AeroLourdes.getAvions().get(1));
        psngr3.goToPlane(AeroLourdes.getAvions().get(0));

        //show travellers

        for (Avion avion : AeroLourdes.getAvions()){
            avion.showTravelerList();
        }

        // launch planes
        AeroLourdes.getAvions().get(0).fly();
        AeroLourdes.getAvions().get(1).fly();

        //land planes
        AeroLourdes.getAvions().get(0).fly();
        AeroLourdes.getAvions().get(1).fly();
    }
}
