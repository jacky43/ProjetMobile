package ca.projetmobileui.Models;

public class Client {

    private String firstName;
    private String lastName;
    private String adress;
    private String phoneNumber;
    private String dateCourse;
    private double price;

    public Client(String firstName, String lastName, String adress, String phoneNumber, String dateCourse, double price) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.dateCourse = dateCourse;
        this.price = price;
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

    public void setDateCourse(String dateCourse) {
        this.dateCourse = dateCourse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
