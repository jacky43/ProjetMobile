package ca.projetmobileui.Models;

public class User {
    private String firstName;
    private String lastName;
    private String bornDate;
    private String email;
    private String passWord;

    public User(String firstName, String lastName, String dateBorn, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornDate = dateBorn;
        this.email = email;
        this.passWord = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateBorn() {
        return bornDate;
    }

    public void setDateBorn(String dateBorn) {
        this.bornDate = dateBorn;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }
}
