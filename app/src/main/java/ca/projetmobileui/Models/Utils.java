package ca.projetmobileui.Models;

public class Utils {
    public static boolean checkRegexFirstName(String nom) {
        if (!nom.matches("[a-z-A-Z-]{1,21}+")) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean checkRegexLastName(String nom) {
        if (!nom.matches("[a-z-A-Z-]{1,21}+")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkRegexEmail(String email) {
        if (!email.matches("[a-z-A-Z-0-9-_]{1,50}[@][a-z-A-Z-._ ]{1,50}[.][a-z]{1,10}+")) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean checkRegexDate(String pays) {
        if (!pays.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}+")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkRegexDateHeure(String pays) {
        if (!pays.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}[ ][0-9]{2}[:][0-9]{2}+")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkRegexPassword(String description) {
        if (!description.matches("[a-z-A-Z0-9:@_-]+")) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean checkRegexAdress(String nom) {
        if (!nom.matches("[a-z-A-Z-\\d ]{1,50}+")) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean checkRegexPhoneNumber(String nom) {
        if (!nom.matches("[0-9]{3}[-][0-9]{3}[-][0-9]{4}+")) {
            return false;
        } else {
            return true;
        }
    }
}
