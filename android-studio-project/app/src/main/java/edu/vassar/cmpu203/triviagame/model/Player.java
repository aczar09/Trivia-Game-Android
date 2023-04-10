package edu.vassar.cmpu203.triviagame.model;

public class Player {
    String name;
    int wins = 0;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "Player 1";
    }


}