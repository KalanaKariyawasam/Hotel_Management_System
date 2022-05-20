package classes;

//import libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class HotelProgram{
    //Create Objects
    private static Room[] hotel = new Room[9];
    private static Room[] noOfGuests = new Room[9];
    private static Person[] fName = new Person[9];
    private static Person[] surname = new Person[9];
    private static Person[] cardNo = new Person[9];
    private static Scanner input = new Scanner(System.in);
    private static String roomName;
    private static String firstName;
    private static String lastName;
    private static String cardNum;
    private static int roomNum = 0;
    private static int payerNum = 0;
    private static int guests = 0;
    public static void main(String[] args) {
        //Create local variables
        String selection = "";

        for(int i = 1; i < 9; i++){
            hotel[i] = new Room();
        }

        for(int i = 1; i < 9; i++){
            noOfGuests[i] = new Room();
        }

        for(int i = 1; i < 9; i++){
            fName[i] = new Person();
        }

        for(int i = 1; i < 9; i++){
            surname[i] = new Person();
        }

        for(int i = 1; i < 9; i++){
            cardNo[i] = new Person();
        }

        initialise(); //Initialise the procedure
        //Create menu
        while (true) {
            System.out.println("\n------------- H O T E L - M E N U -------------");
            System.out.println("A: Book A New Room.");
            System.out.println("V: View All Rooms.");
            System.out.println("E: Display Empty Rooms.");
            System.out.println("D: Delete Customer from Room.");
            System.out.println("F: Find Room from Customer Name.");
            System.out.println("S: Store Program Data into File.");
            System.out.println("L: Load Program Data from File.");
            System.out.println("O: View Guests Ordered Alphabetically by Name.");
            System.out.println("G: View Number of Guests in a Room.");
            System.out.println("P: Pay for Rooms.");
            System.out.println("I: Payer Information.");
            System.out.println("X: Exit.");
            System.out.println("-----------------------------------------------");
            System.out.print("\nEnter your option : ");
            selection = input.next();
            selection = selection.toUpperCase();
            if(selection.equals("X")){
                System.out.println("\n...Thank You, Come Again!...");
                System.out.println("\n-----------------------------------------------");
                break;
            }
            else{
                switch(selection) {
                    case "A":
                        System.out.println("Add Customer");
                        System.out.println("-----------------------------------------------");
                        addCustomer();
                        break;
                    case "V":
                        System.out.println("View Rooms");
                        System.out.println("-----------------------------------------------");
                        viewRooms();
                        break;
                    case "E":
                        System.out.println("Display Empty Rooms");
                        System.out.println("-----------------");
                        emptyRooms();
                        break;
                    case "D":
                        System.out.println("Delete Rooms");
                        System.out.println("-----------------------------------------------");
                        deleteRooms();
                        break;
                    case "F":
                        System.out.println("Find Room from Customer Name");
                        System.out.println("-----------------------------------------------");
                        findRooms();
                        break;
                    case "S":
                        System.out.println("Store Program Data into File");
                        System.out.println("-----------------------------------------------");
                        storeData();
                        break;
                    case "L":
                        System.out.println("Load Program Data from File");
                        System.out.println("-----------------------------------------------");
                        loadData();
                        break;
                    case "O":
                        System.out.println("View Guests Ordered Alphabetically by Name");
                        System.out.println("-----------------------------------------------");
                        alphabeticalOrderByName(hotel);
                        break;
                    case "G":
                        System.out.println("Number of Guests in a Room");
                        System.out.println("-----------------------------------------------");
                        noOfGuests();
                        break;
                    case "P":
                        System.out.println("Pay for Rooms");
                        System.out.println("-----------------------------------------------");
                        payForRooms();
                        break;
                    case "I":
                        System.out.println("Payer Information");
                        System.out.println("-----------------------------------------------");
                        payerInfo();
                        break;
                    default:
                        System.out.println("Invalid Input..");
                }
            }
        }
    }

    //Create add Customer method
    private static void addCustomer() {
        //Get inputs
        while ( roomNum < 9 ) {
            try {
                System.out.print("\nEnter room number (1-8) or 9 to stop : ");
                roomNum = input.nextInt();
                if(roomNum >= 9){
                    roomNum = 0;
                    break;
                }
                else{
                    System.out.print("\nEnter name for room " + roomNum + " : ");
                    roomName = input.next();
                    hotel[roomNum].setName(roomName);
                    System.out.print("Enter number of guests including with you : ");
                    guests = input.nextInt();
                    noOfGuests[roomNum].setGuestsInARoom(guests);
                }
            }
            catch (Exception e){
                System.out.println("Invalid input..");
                System.out.println("-----------------------------------------------");
            }
            System.out.print("Do you want to occupy an another room? (y/n) : " );
            String choice = input.next();
            choice = choice.toLowerCase();
            if(choice.equals("y")) {
                continue;
            }
            else if(choice.equals("n")){
                break;
            }
            else{
                System.out.println("Invalid Input..");
            }
        }
    }

    //Create view rooms method
    private static void viewRooms() {
        System.out.println();
        for (int x = 1; x < 9; x++) {
            System.out.println("Room " + x + " occupied by " + hotel[x].getName() + ".");
        }
    }

    //Create display empty rooms method
    private static void emptyRooms() {
        //Display outputs
        for (int x = 1; x < 9; x++) {
            if (hotel[x].getName().equals("none")) System.out.println("Room " + x + " is empty.");
        }
        System.out.println("-----------------");
    }

    //Create delete rooms method
    private static void deleteRooms() {
        //Get inputs
        System.out.print("\nEnter Room Number to Delete(1-8) : ");
        roomNum = input.nextInt();
        hotel[roomNum].setName("none");
        //Display outputs
        System.out.println("\nBooking Deleted..");
    }

    //Create find rooms method
    private static void findRooms() {
        //Get inputs
        System.out.print("\nEnter Customer Name to Find Room : ");
        roomName = input.next();
        int x = 1;
        //Display outputs
        for(; x < 9; x++){
            if(roomName.equals(hotel[x].getName())){
                System.out.println("\nThe room is " + x);
                break;
            }
        }
        if(x == 9){
            System.out.println("\nThere are no rooms under that name..");
        }
    }

    //I referred w3schools and got this part and edited.
    //Create store data method
    private static void storeData() {
        try {
            //Store data into a file
            FileWriter store = new FileWriter("HotelData.txt");
            for (int i = 1 ; i < hotel.length; i ++) {
                store.write("Room " + i + " occupied by " + hotel[i].getName() + ".\n");
            }
            store.close();
            System.out.println("\nSuccessfully stored..");
        }
        catch(Exception e) {
            System.out.println("invalid");
        }
    }

    //I referred w3schools and got this part and edited.
    //Create load data method
    private static void loadData() {
        try {
            int x = 1;
            File read = new File("HotelData.txt");
            Scanner myReader = new Scanner(read);
            System.out.println();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                hotel[x].setName(data);
                System.out.println(hotel[x].getName());
            }
            myReader.close();
            System.out.println("\nLoaded Successfully..");
        }
        catch (FileNotFoundException e) {
            System.out.println("\nAn error occurred while loading..");
            e.printStackTrace();
        }
    }

    //I got this part from stackoverflow and edited.
    private static void alphabeticalOrderByName(Room[] hotel) {
        System.out.println();
        int a = 0;
        String temp;
        String[] hotelref = new String[9];

        for(int i = 1; i < hotel.length; i++){
            hotelref[i] = (hotel[i].getName());
        }
        for(int i = 1; i < hotelref.length-1; i++){
            for(int j = i+1; j < hotelref.length; j++){
                if(hotelref[i].compareTo(hotelref[j]) > 0) {
                    temp = hotelref[i];
                    hotelref[i] = hotelref[j];
                    hotelref[j] = temp;
                }
            }
        }
        for(int i = 1; i < hotelref.length; i++){
            for(int j = 1; j < hotel.length; j++){
                if(hotelref[i].equals(hotel[j].getName())){
                    a = j;
                }
            }
            if(!hotelref[i].equals("none")){
                System.out.println("Room " + a + " occupied by " + hotelref[i] + ".");
            }
        }
    }

    //Create number of guests method
    private static void noOfGuests() {
        //Display outputs
        System.out.println();
        for(int x = 1; x < 9; x++){
            System.out.println("There are " + noOfGuests[x].getGuestsInARoom() + " in room "+ x +".");
        }
    }

    //Create pay for room method
    private static void payForRooms() {
        while(payerNum < 9){
            //Get inputs
            try {
                System.out.print("\nEnter room number : ");
                payerNum = input.nextInt();
                System.out.print("Enter first name : ");
                firstName = input.next();
                fName[payerNum].setFirstName(firstName);
                System.out.print("Enter surname : ");
                lastName = input.next();
                surname[payerNum].setSurname(lastName);
                System.out.print("Enter card number : ");
                cardNum = input.next();
                cardNo[payerNum].setCardNUmber(cardNum);
            }
            catch (Exception e){
                System.out.println("Invalid input..");
            }
            System.out.print("\nDo you want to pay another room? (y/n) : " );
            String choice = input.next();
            choice = choice.toLowerCase();
            if(choice.equals("y")) {
                continue;
            }
            else if(choice.equals("n")){
                break;
            }
            else {
                System.out.println("Invalid Input..");
            }
        }
    }

    //Create payer info method
    private static void payerInfo() {
        //Display Outputs
        System.out.println();
        for (int x = 1; x < 9; x++) {
            System.out.println("Room " + x + " : " + "First Name : " + fName[x].getFirstName() + "  Surname : " + surname[x].getSurname() + "  Card Number : " + cardNo[x].getCardNUmber());
        }
    }

    //Initialise method
    private static void initialise() {
        for (int x = 1; x < 9; x++ ) {
            //Create default status
            hotel[x].setName("none");
            noOfGuests[x].setName("no one");
            fName[x].setFirstName("---");
            surname[x].setSurname("---");
            cardNo[x].setCardNUmber("-");
        }
        System.out.println( "\nInitialise ");
    }
}

