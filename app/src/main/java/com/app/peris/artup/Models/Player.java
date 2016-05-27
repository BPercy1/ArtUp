package com.app.peris.artup.Models;

/**
 * Created by Paul on 23/05/2016.
 */
public class Player {
    private String name;
    private int totalGuesses;
    private int totalArticulations;
    private int roundGuesses;
    private int roundArticulations;

    public Player(String name){
        this.name = name;
        totalGuesses = 0;
        totalArticulations = 0;
        roundGuesses = 0;
        roundArticulations = 0;
    }

    public void roundReset(){
        roundArticulations = 0;
        totalGuesses = 0;
    }

    public void addArticulations(int articulations){
        roundArticulations = getRoundArticulations() + articulations;
        totalArticulations = getTotalArticulations() + articulations;
    }

    public void addGuesses(int guesses){
        roundGuesses = getRoundGuesses() + guesses;
        totalGuesses = getTotalGuesses() + guesses;
    }

    public String getName() {
        return name;
    }

    public int getTotalGuesses() {
        return totalGuesses;
    }

    public int getTotalArticulations() {
        return totalArticulations;
    }

    public int getRoundGuesses() {
        return roundGuesses;
    }

    public int getRoundArticulations() {
        return roundArticulations;
    }
}
