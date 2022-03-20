package model;

public class IllegalDigits extends Exception {

    public IllegalDigits(String message) {
        super(message + ", ID must contain 9 digits ");
    }

}
