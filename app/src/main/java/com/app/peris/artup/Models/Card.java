package com.app.peris.artup.Models;

import com.app.peris.artup.Activities.GameActivity;

/**
 * Created by Paul on 25/05/2016.
 */
public class Card {

    private String text;
    private int player;

    public Card(String text, int playerPosition){
        this.text = text;
        if (playerPosition == 0) player = 1;
        else player = 0;
    }

    public int getPlayer() {
        return player;
    }

    public void playerIncrement() {
        this.player++;
    }

    public void playerReset() {
        this.player = 0;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
