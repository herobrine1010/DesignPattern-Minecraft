package design.concretes;

import design.patterns.Entity;


public class Player extends Entity {
    private static Player instance = new Player();

    public Inventory inventory = new Inventory();

    private Player() { }

    public static Player getInstance() {
        return instance;
    }

    private static class Inventory {

    }
}
