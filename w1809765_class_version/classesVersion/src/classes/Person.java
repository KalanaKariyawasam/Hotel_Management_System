package classes;

public class Person{
    //Create attributes
    String firstName, surname, cardNUmber;

    //Default Constructors
    public Person(){
        firstName = "---";
        surname = "---";
        cardNUmber = "-";
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    //Setters
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //Getters
    public String getSurname() {
        return surname;
    }

    //Setters
    public void setCardNUmber(String cardNUmber) {
        this.cardNUmber = cardNUmber;
    }

    //Getters
    public String getCardNUmber() {
        return cardNUmber;
    }
}