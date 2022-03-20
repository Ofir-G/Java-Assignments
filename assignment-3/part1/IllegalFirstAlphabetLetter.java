package model;

public class IllegalFirstAlphabetLetter extends Exception {

    public IllegalFirstAlphabetLetter(String message) {
        super(message + ", illegal first letter: the name must strat with Big or Small alphabet letter");
    }

}
