package classes;

public class Room {
    //Create attributes
    private String name;
    private String hotelref;
    int guestsInARoom;

    //Default Constructors
    public Room(){
        name = "none";
        guestsInARoom = 0;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    //Getters
    public String getName(){
        return name;
    }

    //Setters
    public void setGuestsInARoom(int number){
        this.guestsInARoom = number;
    }

    //Getters
    public int getGuestsInARoom(){
        return guestsInARoom;
    }
}