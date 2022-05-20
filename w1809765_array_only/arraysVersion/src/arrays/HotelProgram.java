package arrays;

//import libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class HotelProgram{
    //Create Arrays & Variables
    private static Scanner input = new Scanner(System.in);
    private static String roomName;
    private static int roomNum = 0;
    private static int payerNum = 0;
    private static String[] hotel = new String[9];
    private static String[] noOfGuests = new String[9];
    private static String[] fName = new String[9];
    private static String[] surname = new String[9];
    private static String[] cardNo = new String[9];
    public static void main(String[] args) {
        //Create local variables
        String selection = "";
        initialise(); //Initialise the Procedure
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
                        storeData(hotel);
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
                    System.out.print("Enter number of guests including with you : ");
                    noOfGuests[roomNum] = input.next();
                    hotel[roomNum] = roomName;
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
        //Display outputs
        System.out.println();
        for (int x = 1; x < 9; x++) {
            System.out.println("Room " + x + " occupied by " + hotel[x] + ".");
        }
    }

    //Create display empty rooms method
    private static void emptyRooms() {
        //Display outputs
        System.out.println();
        for (int x = 1; x < 9; x++) {
            if (hotel[x].equals("none")) System.out.println("Room " + x + " is empty.");
        }
        System.out.println("-----------------");
    }

    //Create delete rooms method
    private static void deleteRooms() {
        //Get inputs
        System.out.print("\nEnter Room Number to Delete(1-8) : ");
        roomNum = input.nextInt();
        hotel[roomNum] = ("none");
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
            if(roomName.equals(hotel[x])){
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
    private static void storeData(String[] hotel) {
        try {
            //Store data into a file
            FileWriter store = new FileWriter("HotelData.txt");
            for (int i = 1 ; i < hotel.length; i ++) {
                store.write("Room " + i + " occupied by " + hotel[i] + ".\n");
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
                hotel[x] = data;
                System.out.println(hotel[x]);
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
    private static void alphabeticalOrderByName(String[] hotel) {
        System.out.println();
        int a = 0;
        String temp;
        String[] hotelref;
        hotelref = hotel.clone();
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
                if(hotelref[i].equals(hotel[j])){
                    a = j;
                }
            }
            if(!hotelref[i].equals("none")){
                System.out.println("Room " + a + " occupied by " + hotelref[i] + ".");
            }
        }
        System.out.println("\nAlphabetically ordered..");
    }

    //Create number of guests method
    private static void noOfGuests() {
        //Display outputs
        System.out.println();
        for(int x = 1; x < 9; x++){
            System.out.println("There are " + noOfGuests[x] + " in room "+ x +".");
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
                fName[payerNum] = input.next();
                System.out.print("Enter surname : ");
                surname[payerNum] = input.next();
                System.out.print("Enter card number : ");
                cardNo[payerNum] = input.next();
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
            System.out.println("Room " + x + " : " + "First Name : " + fName[x] + "  Surname : " + surname[x] + "  Card Number : " + cardNo[x]);
        }
    }

    //Initialise method
    private static void initialise() {
        for (int x = 1; x < 9; x++ ) {
            //Create default status
            hotel[x] = "none";
            noOfGuests[x] = "no one";
            fName[x] = "---";
            surname[x] = "---";
            cardNo[x] = "-";
        }
        System.out.println( "\nInitialise ");
    }
}
