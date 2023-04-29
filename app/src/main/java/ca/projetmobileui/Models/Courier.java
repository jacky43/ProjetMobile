package ca.projetmobileui.Models;

public class Courier {

    private String firstName;
    private String lastName;
    private String adress;
    private String phoneNumber;
    private String dateCourse;

    public Courier(String firstName, String lastName, String adress, String phoneNumber, String dateCourse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.dateCourse = dateCourse;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateCourse() {
        return dateCourse;
    }

    public void setDateHeure(String dateHeure) {
        this.dateCourse = dateHeure;
    }
}
