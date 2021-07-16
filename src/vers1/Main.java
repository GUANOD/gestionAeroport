package vers1;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        ArrayList<Aeroport> airports = new ArrayList<>();

        airports.add(firstAirport());

        // add avions
        airports.get(0).AddToAvions(new AvionGL("Airbus A380", 853, 15000));
        airports.get(0).AddToAvions(new AvionLI("Embraer 175", 78, 4074 ));
        airports.get(0).AddToAvions(new AvionGL("Embraer 200", 400, 10000 ));
        airports.get(0).AddToAvions(new AvionLI("Airbus A2", 50, 3500));

        //create destinations
        airports.get(0).addToDestinations( new Destination("Maldives", 1999.58, 2000 ));
        airports.get(0).addToDestinations( new Destination("Greece", 2190.00, 530 ));
        airports.get(0).addToDestinations( new Destination("Tarbes", 100, 30));
        airports.get(0).addToDestinations( new Destination("NY", 2319.59, 5320));

        // create passengers
        airports.get(0).getTravelers().add(new Traveler("Alba", "Jessica", 40, airports.get(0)));
        airports.get(0).getTravelers().add(new Traveler("Portman", "Natalie", 40, airports.get(0)));
        airports.get(0).getTravelers().add(new Traveler("Ratajkowski", "Emily", 30, airports.get(0)));
        airports.get(0).getTravelers().add(new Traveler("Paradis", "Vanessa", 30, airports.get(0)));
        airports.get(0).getTravelers().add(new Traveler("Itre", "Mayte", 60, airports.get(0)));
        airports.get(0).getTravelers().add(new Traveler("Bardot", "Brigitte", 30, airports.get(0)));
        airports.get(0).getTravelers().add(new Traveler("Macron", "Brigitte", 70, airports.get(0)));
        airports.get(0).getTravelers().add(new Traveler("B", "Cardi", 43, airports.get(0)));
        airports.get(0).getTravelers().add(new Traveler("Lavigne", "Avril", 16, airports.get(0)));

        // add planes to detination
        airports.get(0).getDestinations().get(0).setAvions(airports.get(0).getAvions().get(0));
        airports.get(0).getDestinations().get(1).setAvions(airports.get(0).getAvions().get(1));
        airports.get(0).getDestinations().get(2).setAvions(airports.get(0).getAvions().get(3));
        airports.get(0).getDestinations().get(3).setAvions(airports.get(0).getAvions().get(2));

        //buy tickets

        airports.get(0).getTravelers().get(0).buyBillet(airports.get(0).getDestinations().get(0));
        airports.get(0).getTravelers().get(1).buyBillet(airports.get(0).getDestinations().get(1));
        airports.get(0).getTravelers().get(2).buyBillet(airports.get(0).getDestinations().get(3));
        airports.get(0).getTravelers().get(3).buyBillet(airports.get(0).getDestinations().get(2));
        airports.get(0).getTravelers().get(4).buyBillet(airports.get(0).getDestinations().get(3));
        airports.get(0).getTravelers().get(5).buyBillet(airports.get(0).getDestinations().get(1));
        airports.get(0).getTravelers().get(6).buyBillet(airports.get(0).getDestinations().get(0));
        airports.get(0).getTravelers().get(7).buyBillet(airports.get(0).getDestinations().get(2));
        airports.get(0).getTravelers().get(8).buyBillet(airports.get(0).getDestinations().get(3));

        while (true) {
            String choice = chooseTodo(airports);
            switch (choice.toLowerCase()) {
                case "create-airport" -> createAirport(airports);
                case "create-plane" -> createPlane(airports);
                case "create-destination" -> createDestination(airports);
                case "create-passenger" -> createTraveller(airports);
                case "show-destinations" -> showDestinations(airports);
                case "show-airports" -> showAirports(airports);
                case "show-planes" -> showPlanes(airports);
                case "show-passengers" -> showTravellers(airports);
                case "buy-ticket" -> buyTicket(airports);
                case "link-planes" -> planesToDestination(airports);
                case "send-to-plane" -> goToPlane(airports);
                case "fly-plane" -> flyPlane(airports);
                case "show-boarded-passengers" -> showPassengersinPlane(airports);
                case "land-plane" -> landPlane(airports);
                case "show-tickets" -> showTickets(airports);
                case "edit-tickets" -> editTicket(airports);
                default -> System.out.println("###### Please choose a valid option ##### \n");
            }
        }
    }

    public static Aeroport firstAirport() {
        System.out.println("Welcome to your airport manager!");
        System.out.println("Let's create your first airport.");
        System.out.println("\n");
        System.out.println("Enter the site of your first airport: ");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        System.out.println("Enter the total plane capacity of the airport: ");
        int capacite = scanner.nextInt();
        System.out.println("Congrats you just created " + lieu + " airport!");
        System.out.println("\n");
        return new Aeroport(lieu, capacite);
    }

    public static String chooseTodo(ArrayList<Aeroport> airports) {
        ArrayList<String> menu = new ArrayList<>();
        menu.add("What do you want to do today?");
        menu.add("Create-airport");
        menu.add("Create-plane");
        menu.add("Create-destination");
        menu.add("Create-passenger");
        menu.add("Show-airports");
        if (checkPlane(airports)) {
            menu.add("Show-planes");
        }else{
            menu.remove("Show-planes");
        }
        if (checkDestinations(airports)) {
            menu.add("Show-destinations");
        }else{
            menu.remove("Show-destinations");
        }
        if (checkPassengers(airports)) {
            menu.add("Show-passengers");
            menu.add("Buy-ticket");
        }else{
            menu.remove("Show-passengers");
            menu.remove("Buy-ticket");
        }
        if (checkPlane(airports) && checkDestinations(airports)) {
            menu.add("Link-planes");
        }else{
            menu.remove("Link-planes");
        }
        if (checkTickets(airports)){
            menu.add("Show-tickets");
            menu.add("Send-to-plane");
            menu.add("Edit-tickets");
        }else{
            menu.remove("Send-to-plane");
            menu.remove("Show-tickets");
            menu.remove("Edit-tickets");
        }
        if (checkPassengersInPlane(airports)){
            menu.add("Fly-plane");
            menu.add("Show-boarded-passengers");
        }else{
            menu.remove("Fly-plane");
            menu.remove("Show-boarded-passengers");
        }
        if(checkFlyingPlanes(airports)){
            menu.add("Land-plane");
        }else{
            menu.remove("Land-plane");
        }

        for ( String option : menu){
            System.out.println(option);
        }
        System.out.println("\n");

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    // checkers
    public static boolean checkPassengers(ArrayList<Aeroport> airports) {
        for (Aeroport airport : airports) {
            if (airport.getTravelers().size() != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPlane(ArrayList<Aeroport> airports) {
        for (Aeroport airport : airports) {
            if (airport.getAvions().size() != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDestinations(ArrayList<Aeroport> airports) {
        for (Aeroport airport : airports) {
            if (airport.getDestinations().size() != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkTickets(ArrayList<Aeroport> airports){
        for(Aeroport airport : airports){
            if(airport.getBillets().size() != 0){
                return true;
            }
        }
        return false;
    }

    public static boolean checkPassengersInPlane(ArrayList<Aeroport> airports){
        for (Aeroport airport : airports){
            for(Avion avion : airport.getAvions()){
                if (avion.getTravelers().size() != 0){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkFlyingPlanes(ArrayList<Aeroport> airports){
        for (Aeroport airport : airports){
            for (Avion avion : airport.getAvions()){
                if (avion.getVol_sol()){
                    return true;
                }
            }
        }
        return false;
    }

    //airports

    public static void createAirport(ArrayList<Aeroport> airports) {
        System.out.println("Enter the site of your airport: ");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        System.out.println("Enter the total plane capacity of the airport: ");
        int capacity = scanner.nextInt();
        System.out.println("Congrats you just created " + lieu + " airport!");
        System.out.println("\n");
        airports.add(new Aeroport(lieu, capacity));
    }

    public static void showAirports(ArrayList<Aeroport> airports) {
        for (Aeroport airport : airports) {
            System.out.println("#####" + airport.getLieu() + "'s airport#####");
            System.out.println("Capacity: " + airport.getCapacite());
            System.out.println("Current passengers registered: " + airport.getTravelers().size());
            System.out.println("Number of planes: " + airport.getAvions().size());
            System.out.println("Number of destinations: " + airport.getDestinations().size());
            System.out.println("\n");
        }
    }

    //planes

    public static void createPlane(ArrayList<Aeroport> airports) {
        System.out.println("Enter the site of the airport you want to put your plane: ");
        Scanner scanner = new Scanner(System.in);
        String aeroport = scanner.next();
        int index = searchAirport(airports, aeroport);
        if (index == -1) {
            System.out.println("Airport not found");
            System.out.println("\n");
            return;
        }
        if (airports.get(index).getCapacite() == airports.get(index).getAvions().size()) {
            System.out.println("Airport is at full capacity.");
            System.out.println("\n");
            return;
        }
        System.out.println("Enter the type of your plane: ");
        String type = scanner.next();
        if (!type.equalsIgnoreCase("aviongl") && !type.equalsIgnoreCase("avionli")) {
            System.out.println("Plane type not allowed");
            System.out.println("\n");
            return;
        }
        System.out.println("Enter the model of your plane: ");
        String modele = scanner.next();
        System.out.println("Enter the capacity of your plane: ");
        int nbPlaces = scanner.nextInt();
        System.out.println("Enter the max distance of your plane: ");
        int distanceMax = scanner.nextInt();
        if (type.equalsIgnoreCase("aviongl")) {
            airports.get(index).AddToAvions(new AvionGL(modele, nbPlaces, distanceMax));
        } else if (type.equalsIgnoreCase("avionli")) {
            airports.get(index).AddToAvions(new AvionLI(modele, nbPlaces, distanceMax));
        } else {
            System.out.println("Error creating plane, pls try again");
            System.out.println("\n");
            return;
        }
        System.out.println("Congrats you just created " + modele + " " + type + " at " + aeroport + "!");
        System.out.println("\n");
    }

    public static void showPlanes(ArrayList<Aeroport> airports) {
        for (Aeroport airport : airports) {
            System.out.println("Planes in " + airport.getLieu() + " airport");
            for (Avion avion : airport.getAvions()) {
                System.out.println(avion.getModele() +
                        (avion.getDestination()==null? " with no destination yet" : " destination " + avion.getDestination().getNom())+
                        (avion.getVol_sol()? "currently on the air": ""));
            }
            System.out.println("\n");
        }
    }

    //destinations

    public static void createDestination(ArrayList<Aeroport> airports) {
        System.out.println("Enter the site of the airport where you want to add your destination");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        int index = searchAirport(airports, lieu);
        if (index == -1) {
            System.out.println("Airport not found!");
            System.out.println("\n");
            return;
        }
        System.out.println("Enter the destination name: ");
        String name = scanner.next();
        System.out.println("Enter the destination price: ");
        double prix = scanner.nextDouble();
        System.out.println("Enter the destination distance: ");
        int distance = scanner.nextInt();
        try {
            airports.get(index).addToDestinations(new Destination(name, prix, distance));
            System.out.println("Destination " + name + " at " + airports.get(index).getLieu() + " successfully created");
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Error creating destination ");
            System.out.println("\n");
        }
    }

    public static void showDestinations(ArrayList<Aeroport> airports) {
        for (Aeroport airport : airports) {
            System.out.println("#####Destinations available in " + airport.getLieu() + " airport#####");
            for (Destination destination : airport.getDestinations()) {
                System.out.println(destination.getNom());
                System.out.println("Price: " + destination.getPrix());
            }
            System.out.println("\n");
        }
    }

    // Travellers
    public static void createTraveller(ArrayList<Aeroport> airports) {
        System.out.println("Enter the site of the airport where you want to register your passenger");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        int index = searchAirport(airports, lieu);
        if (index == -1) {
            System.out.println("Airport not found!");
            System.out.println("\n");
            return;
        }
        String name;
        String lastName;
        int age;
        try {
            System.out.println("Enter the passenger name: ");
            name = scanner.next();
            System.out.println("Enter the passenger last name: ");
            lastName = scanner.next();
            System.out.println("Enter the passenger age: ");
            age = scanner.nextInt();
        } catch (Exception info) {
            System.out.println("Invalid informations");
            System.out.println("\n");
            return;
        }
        try {
            airports.get(index).getTravelers().add(new Traveler(lastName, name, age, airports.get(index)));
            System.out.println("Passenger " + name + " at " + airports.get(index).getLieu() + " successfully registered");
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Error registering passenger");
            System.out.println("\n");
        }
    }

    public static void showTravellers(ArrayList<Aeroport> airports) {
        for (Aeroport airport : airports) {
            System.out.println("#####Passengers registered in " + airport.getLieu() + " airport#####");
            for (Traveler passenger : airport.getTravelers()) {
                System.out.println(passenger.getPrenom() + " " + passenger.getNom() + " aged " + passenger.getAge());
                if (passenger.getBillet() != null) {
                    System.out.println("Ticket to " + passenger.getBillet().getDestination().getNom());
                    System.out.println("\n");
                } else {
                    System.out.println("Currently does not own a ticket");
                    System.out.println("\n");
                }
            }
        }
    }

//actions

    // buyTickets

    public static void buyTicket(ArrayList<Aeroport> airports) {
        System.out.println("At which airport is your passenger registered?");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        int index = searchAirport(airports, lieu);
        if (index == -1){
            System.out.println("Airport not found ");
            return;
        }
        if (airports.get(index).getDestinations().size() == 0){
            System.out.println("Airport has no destinations available");
            return;
        }
        System.out.println("Choose your passenger");
        for (int i =0; i < airports.get(index).getTravelers().size(); i++){
            System.out.println(i+ ": "+ airports.get(index).getTravelers().get(i).getNom()
                    + " " + airports.get(index).getTravelers().get(i).getPrenom());
        }
        int passengerIndex = scanner.nextInt();
        System.out.println("Choose your destination");
        for (int i =0; i < airports.get(index).getDestinations().size(); i++){
            System.out.println(i+ ": "+ airports.get(index).getDestinations().get(i).getNom());
        }
        int destinationIndex = scanner.nextInt();

        if(airports.get(index).getDestinations().get(destinationIndex).getAvion() == null){
            System.out.println("Destination has no planes available.");
            return;
        }
        try{
            airports.get(index).getTravelers().get(passengerIndex).buyBillet(airports.get(index).getDestinations().get(destinationIndex));
        }catch(Exception ticket){
            System.out.println("Error buying ticket");
        }

    }

    //show tickets

    public static void showTickets(ArrayList<Aeroport> airports){
        for(Aeroport airport: airports){
            if(airport.getBillets().size()!=0){
                System.out.println("##### Valid tickets in " + airport.getLieu()+" ######" );
                for(Billet billet : airport.getBillets()){
                    System.out.println("Ticket to "+ billet.getDestination().getNom()+ " for "+
                            billet.getTraveler().getNom() + " "+ billet.getTraveler().getPrenom()+
                            " in "+ billet.getAvion().getModele()+ " seated at seat "+ billet.getPlace() );
                }
            }else{
                System.out.println("No valid tickets in " + airport.getLieu() + " at the moment.");
            }
        }
    }

    // add planes to destination

    public static void planesToDestination(ArrayList<Aeroport> airports){
        System.out.println("Choose your airport site: ");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        int index= searchAirport(airports, lieu);
        if (index == -1){
            System.out.println("Airport not found ");
            return;
        }
        if(airports.get(index).getAvions().size()==0){
            System.out.println("No planes in this airport, pls add planes.");
            return;
        }
        if(airports.get(index).getDestinations().size()==0){
            System.out.println("No destinations in this airport, pls add destinations.");
            return;
        }
        System.out.println("Which airplane would you like to attribute?");
        int iteration =0;
        for (Avion avion : airports.get(index).getAvions()){
            System.out.println(iteration + ": "+ avion.getModele());
            iteration++;
        }
        int planeIndex = scanner.nextInt();
        if (airports.get(index).getAvions().get(planeIndex).getDestination() != null){
            System.out.println("Plane is already linked to a destination");
            System.out.println("\n");
            return;
        }
        System.out.println("Which destination would you like to attribute?");
        int iterate =0;
        for (Destination destination : airports.get(index).getDestinations()){
            System.out.println(iterate + ": "+destination.getNom());
            iterate++;
        }
        int destinationIndex = scanner.nextInt();

        try{
            airports.get(index).getDestinations().get(destinationIndex).setAvions(airports.get(index).getAvions().get(planeIndex));
            System.out.println(airports.get(index).getAvions().get(planeIndex).getModele() + " successfully attributed to destination");
        }catch (Exception info){
            System.out.println("Error attributing plane");
        }
    }

    //send to plane

    public static void goToPlane(ArrayList<Aeroport> airports){
        System.out.println("Please choose your airport site");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        int index = searchAirport(airports, lieu);
        if (index == -1){
            System.out.println("Airport not found");
            return;
        }
        System.out.println("Please choose your passenger");
        int iterate =0;
        for (Traveler passenger :airports.get(index).getTravelers()){
            System.out.println(iterate + ": " + passenger.getNom() + " " + passenger.getPrenom());
            iterate++;
        }
        System.out.println(airports.get(index).getTravelers().size()+ ":  All passengers");
        int passengerIndex = scanner.nextInt();
        if (passengerIndex == airports.get(index).getTravelers().size() ){
            for(Traveler passenger : airports.get(index).getTravelers()){
                passenger.goToPlane();
            }
        }else {
            try {
                airports.get(index).getTravelers().get(passengerIndex).goToPlane();
            } catch (Exception plane) {
                System.out.println("Cant send passenger to plane");
            }
        }
    }

    //fly

    public static void flyPlane(ArrayList<Aeroport> airports){
        System.out.println("Please choose your airport site");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        int index = searchAirport(airports, lieu);
        if (index == -1){
            System.out.println("Airport not found");
            return;
        }
        System.out.println("Choose the plane you wish to take off");
        int iterate =0;
        for (Avion avion : airports.get(index).getAvions()){
            if (avion.getTravelers().size()!= 0 && avion.getDestination() != null){
                System.out.println(iterate + ": " + avion.getModele());
            }
            iterate++;
        }
        System.out.println(airports.get(index).getAvions().size()+ ": All planes");
        int planeIndex = scanner.nextInt();
        if (planeIndex == airports.get(index).getAvions().size()){
            for(Avion avion :airports.get(index).getAvions()){
                if(avion.getTravelers().size()!= 0 && avion.getDestination() != null){
                    avion.fly();
                }
            }
            return;
        }
        try {
            airports.get(index).getAvions().get(planeIndex).fly();
        }catch(Exception takeof){
            System.out.println("Plane " + planeIndex + " does not exist" );
        }
    }

    // land

    public static void landPlane(ArrayList<Aeroport> airports){
        System.out.println("Please choose your airport site");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        int index = searchAirport(airports, lieu);
        if (index == -1){
            System.out.println("Airport not found");
            return;
        }
        System.out.println("Choose the plane you want to land");
        int iterate =0;
        for (Avion avion : airports.get(index).getAvions()){
            if (avion.getVol_sol()){
                System.out.println(iterate + ": " + avion.getModele());
            }
            iterate++;
        }
        System.out.println(airports.get(index).getAvions().size()+ ": All planes");
        int planeIndex = scanner.nextInt();
        if (planeIndex == airports.get(index).getAvions().size()){
            for(Avion avion :airports.get(index).getAvions()){
                if(avion.getVol_sol()){
                    avion.land();
                }
            }
            return;
        }
        try {
            airports.get(index).getAvions().get(planeIndex).land();
        }catch(Exception takeof){
            System.out.println("Plane " + planeIndex + " does not exist" );
        }

    }

    public static void showPassengersinPlane(ArrayList<Aeroport> airports){
        System.out.println("Please choose your airport site");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        int index = searchAirport(airports, lieu);
        if (index == -1){
            System.out.println("Airport not found");
            return;
        }
        for(Avion avion : airports.get(index).getAvions()){
            if (avion.getTravelers().size()!= 0){
                avion.showTravelerList();
            }
        }
    }

    public static void editTicket(ArrayList<Aeroport> airports) {
        System.out.println("Please choose your airport site");
        Scanner scanner = new Scanner(System.in);
        String lieu = scanner.next();
        int index = searchAirport(airports, lieu);
        if (index == -1) {
            System.out.println("Airport not found");
            return;
        }
        System.out.println("Which ticket would you like to edit?");
        int iterate =0;
        for (Billet billet : airports.get(index).getBillets()) {
            System.out.println(iterate+ ": " + billet.getTraveler().getNom() + "'s ticket to " + billet.getDestination().getNom());
            iterate++;
        }
        int billetIndex = scanner.nextInt();
        System.out.println("What would you like to change?");
        int run = 1;
        while (run != 0) {
            run = edit(airports.get(index).getBillets().get(billetIndex));
        }
    }

    public static int edit(Billet billet){
        System.out.println("1 : Destination");
        System.out.println("2 : Price");
        System.out.println("3 : Delete");
        System.out.println("4: Cancel");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice > 4 || choice < 1){
            System.out.println("Please select valid option");
            System.out.println("\n");
            edit(billet);
        }
        switch (choice) {
            case 1 -> {
                System.out.println("Enter the new destination:");
                String destination = scanner.next();
                for (Destination dest : billet.getTraveler().getAirport().getDestinations()) {
                    if (dest.getNom().equalsIgnoreCase(destination)) {
                        billet.setDestination(dest);
                        System.out.println("Destination successfully changed ");
                        return 1;
                    }
                }
                System.out.println("Unable to find destination");
                return 1;
            }
            case 2 -> {
                System.out.println("Enter the new price:");
                billet.setPrix(scanner.nextDouble());
                System.out.println("Price suiccessfully changed");
                return 1;
            }
            case 3 -> {
                System.out.println("Are you sure you want to delete ticket?");
                System.out.println("Y/N");
                String sure = scanner.next();
                if (sure.equalsIgnoreCase("Y")) {
                    billet.getTraveler().deleteTravel("Deleted");
                    return 0;
                } else if (sure.equalsIgnoreCase("N")) {
                    System.out.println("Deletion canceled");
                    return 1;
                } else {
                    System.out.println("Could not understand choice. Deletion canceled");
                    return 1;
                }
            }
            case 4 -> {
                System.out.println("Edit cancelled");
                return 0;
            }
            default -> {
                System.out.println("No changes made.");
                return 1;
            }
        }
    }

    public static int searchAirport(ArrayList<Aeroport> airports, String lieu) {
        int index = -1;
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getLieu().equalsIgnoreCase(lieu)) {
                index = i;
                break;
            }
        }
        return index;
    }

}