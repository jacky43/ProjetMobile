package ca.projetmobileui.Models;

public class User {
    private String firstName;
    private String lastName;
    private String dateBorn;
    private String email;
    private String password;

    public User(String firstName, String lastName, String dateBorn, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBorn = dateBorn;
        this.email = email;
        this.password = password;
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
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
