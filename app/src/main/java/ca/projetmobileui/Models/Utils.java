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
        if (!email.matches("[a-z-A-Z-0-9-_ ]{1,50}[@][a-z-A-Z-._ ]{1,50}[.][a-z]{1,10}+")) {
            return false;
        } else {
            return true;
        }
    }

  /*  public static boolean checkRegexDate(String pays) {
        if (!pays.matches("[a-z-A-Z]+")) {
            return false;
        } else {
            return true;
        }
    }*/

    public static boolean checkRegexPassword(String description) {
        if (!description.matches("[a-z-A-Z0-9:@_-]+")) {
            return false;
        } else {
            return true;
        }
    }
}
