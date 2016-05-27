package com.app.peris.artup.Models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Paul on 23/05/2016.
 */
public class Category {
    private String name;
    private ArrayList<String> allCards;
    private ArrayList<String> usedCards;

    public Category(int id, String name){
        this.name = name;
        allCards = new ArrayList<>();
        usedCards = new ArrayList<>();
        initCards(id);
    }

    private void initCards(int id) {
        //TODO Databse call to get cards with corresponding category id

        for (int i = 1; i <= 10; i++){
            String card = name + " card " + i;
            allCards.add(card);
        }
    }

    public String getCard(){
        Random r = new Random();
        boolean found = false;
        String card = "";
        if(allCards.size() == usedCards.size())usedCards = new ArrayList<>();
        while(!found){
            card = allCards.get(r.nextInt(allCards.size()));
            boolean repeated = false;
            for (String usedCard:usedCards) {
                if(card.equals(usedCard))repeated=true;
            }
            if(!repeated)found=true;
        }
        usedCards.add(card);
        return card;
    }

    public String getName(){return name;}
}
