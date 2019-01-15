package ru.evgenyhodz.models;

/**
 * Class to simplify message printing.
 */
public class Message {
    /**
     * Show some message.
     */
    public void impossibleMove() {
        System.out.println("That figure can't move like that!");
    }

    /**
     * Show some message.
     */
    public void ourSoldiers() {
        System.out.println("Our soldiers are already here!");
    }

    /**
     * Show some message.
     */
    public void noSuchPosition() {
        System.out.println("No such position on the desk!");
    }

    /**
     * Show some message.
     */
    public void error() {
        System.out.println("You didn't choose a figure.");
    }

}
