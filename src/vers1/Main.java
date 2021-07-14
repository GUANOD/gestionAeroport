package vers1;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Aeroport> airports = new ArrayList<>();

        airports.add(firstAirport());

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
                default -> System.out.println("###### Please choose a valid option ##### \n");
            }
        }

//        //create aeroport
//        Aeroport AeroLourdes = new Aeroport("Lourdes", 20);
//
//        //add avions
//        AeroLourdes.AddToAvions(new AvionGL("Airbus A380", 853, 15000));
//        AeroLourdes.AddToAvions(new AvionLI("Embraer 175", 78, 4074 ));
//        AeroLourdes.AddToAvions(new AvionGL("Embraer 200", 400, 10000 ));
//        AeroLourdes.AddToAvions(new AvionLI("Airbus A2", 50, 3500));
//
//        //create destinations
//        AeroLourdes.addToDestinations( new Destination("Maldives", 1999.58, 2000 ));
//        AeroLourdes.addToDestinations( new Destination("Greece", 2190.00, 530 ));
//        AeroLourdes.addToDestinations( new Destination("Tarbes", 100, 30));
//        AeroLourdes.addToDestinations( new Destination("NY", 2319.59, 5320));
//
//        // add avion to destinations
//        AeroLourdes.getDestinations().get(0).setAvions(AeroLourdes.getAvions().get(0));
//        AeroLourdes.getDestinations().get(1).setAvions(AeroLourdes.getAvions().get(1));
//        AeroLourdes.getDestinations().get(2).setAvions(AeroLourdes.getAvions().get(3));
//        AeroLourdes.getDestinations().get(3).setAvions(AeroLourdes.getAvions().get(2));
//
//        // create passengers
//        AeroLourdes.getTravelers().add(new Traveler("Alba", "Jessica", 40));
//        AeroLourdes.getTravelers().add(new Traveler("Portman", "Natalie", 40));
//        AeroLourdes.getTravelers().add(new Traveler("Ratajkowski", "Emily", 30));
//        AeroLourdes.getTravelers().add(new Traveler("Paradis", "Vanessa", 30));
//        AeroLourdes.getTravelers().add(new Traveler("Itre", "Mayte", 60));
//        AeroLourdes.getTravelers().add(new Traveler("Bardot", "Brigitte", 30));
//        AeroLourdes.getTravelers().add(new Traveler("Macron", "Brigitte", 70));
//        AeroLourdes.getTravelers().add(new Traveler("B", "Cardi", 43));
//        AeroLourdes.getTravelers().add(new Traveler("Lavigne", "Avril", 16));
//
//        //test remplir avion
//
////        ArrayList <Traveler> group = new ArrayList<>();
////
////        for(int i =0; i<77; i++){
////            group.add(new Traveler("Alba", "Jessica", 40));
////        }
//
////        psngr1.buyBillet(AeroLourdes.getDestinations().get(1));
////
////        System.out.println("avant: " + psngr1.getBillet().getDestination().getAvion().getNbPLaceDispo().size());
////
////        for (Traveler pass: group){
////            pass.buyBillet(AeroLourdes.getDestinations().get(1));
////            System.out.println("places dispo apres : " +pass.getBillet().getDestination().getAvion().getNbPLaceDispo().size());
////            System.out.println("place du pass : "+ pass.getBillet().getPlace());
////        }
//
//
////        buy tickets
//       AeroLourdes.getTravelers().get(0).buyBillet(AeroLourdes.getDestinations().get(0));
//       AeroLourdes.getTravelers().get(1).buyBillet(AeroLourdes.getDestinations().get(1));
//       AeroLourdes.getTravelers().get(2).buyBillet(AeroLourdes.getDestinations().get(3));
//       AeroLourdes.getTravelers().get(3).buyBillet(AeroLourdes.getDestinations().get(2));
//       AeroLourdes.getTravelers().get(4).buyBillet(AeroLourdes.getDestinations().get(3));
//       AeroLourdes.getTravelers().get(5).buyBillet(AeroLourdes.getDestinations().get(1));
//       AeroLourdes.getTravelers().get(6).buyBillet(AeroLourdes.getDestinations().get(0));
//       AeroLourdes.getTravelers().get(7).buyBillet(AeroLourdes.getDestinations().get(2));
//       AeroLourdes.getTravelers().get(8).buyBillet(AeroLourdes.getDestinations().get(3));
//
//        // show destination, plane, and ticket price for each passenger
//
//        for (Traveler pass : AeroLourdes.getTravelers()){
//            System.out.println(pass.getNom()
//                    + " achete un billet vers " + pass.getBillet().getDestination().getNom()
//                    + " dans un " + pass.getBillet().getDestination().getAvion().getModele()
//                    + " assise a la place " + pass.getBillet().getPlace()
//                    + " pour un prix de " + pass.getBillet().getPrix());
//        }
//
//        //delete 1 ticket
//
//        AeroLourdes.getTravelers().get(2).deleteTravel("Annulation");
//
//        // jump too plane
//
//        for (Traveler pass : AeroLourdes.getTravelers()){
//            pass.goToPlane();
//        }
////
//        //show travellers
//
//        for (Avion avion : AeroLourdes.getAvions()){
//            avion.showTravelerList();
//        }
//
//        // fly
//
//        for(Avion avion :AeroLourdes.getAvions()){
//            avion.fly();
//        }
//
//        for(Avion avion :AeroLourdes.getAvions()){
//            avion.fly();
//        }
//
//        for(Avion avion :AeroLourdes.getAvions()){
//            avion.land();
//        }
    }

//    public static Scanner scan(String output, ){
//        System.out.println(output);
//        Scanner scanner = new Scanner(System.in);
//        scanner.next
//    }

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
        System.out.println("What do you want to do today?");
        System.out.println("Create-airport");
        System.out.println("Create-plane");
        System.out.println("Create-destination");
        System.out.println("Create-passenger");
        System.out.println("Show-airports");
        if (checkPlane(airports)) {
            System.out.println("Show-planes");
        }
        if (checkDestinations(airports)) {
            System.out.println("Show-destinations");
        }
        if (checkPassengers(airports)) {
            System.out.println("Show-passengers");
            System.out.println("Buy-ticket");
        }
        if(checkPlane(airports) && checkDestinations(airports)){
            System.out.println("Link-planes");
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
                        (avion.getDestination()==null? " with no destination yet" : " destination " + avion.getDestination().getNom()) );
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
            airports.get(index).getTravelers().add(new Traveler(lastName, name, age));
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
            System.out.println("Ticket to" + airports.get(index).getDestinations().get(destinationIndex).getNom() +
                    " for " + airports.get(index).getTravelers().get(passengerIndex).getNom()+ " successfully bought");
        }catch(Exception ticket){
            System.out.println("Error buying ticket");
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