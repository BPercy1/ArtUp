package com.app.peris.artup.Models;

import com.app.peris.artup.Activities.GameActivity;

import java.util.ArrayList;

/**
 * Created by Paul on 23/05/2016.
 */
public class Team {
    private String name;
    private ArrayList<Player> players;
    private int currentArticulator;
    private int totalScore;
    private int roundScore;

    public Team(String name){
        this.name = name;
        players = new ArrayList<>();
        currentArticulator = 0;
        totalScore = 0;
        roundScore = 0;
    }

    public void addPlayer(Player player){players.add(player);}

    public void roundReset(){
        roundScore = 0;
        for (Player player:players) {
            player.roundReset();
        }
    }

    public void addPoints(int points){
        roundScore = getRoundScore() + points;
        totalScore = getTotalScore() + points;
    }

    public void nextPlayer(){
        currentArticulator = getCurrentArticulator() + 1;
        if(getCurrentArticulator() >= players.size())currentArticulator=0;
    }

    public boolean checkWin(){
        if(getTotalScore() >= GameActivity.getPointsToWin())return true;
        else return false;
    }

    public int getPlayersSize(){return players.size();}

    public int getCurrentPlayerPosition(){return currentArticulator;}

    public Player getCurrentPlayer(){return players.get(getCurrentArticulator());}

    public Player getPlayer(int position){return players.get(position);}

    public String getName() {
        return name;
    }

    public int getCurrentArticulator() {
        return currentArticulator;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getRoundScore() {
        return roundScore;
    }
}
