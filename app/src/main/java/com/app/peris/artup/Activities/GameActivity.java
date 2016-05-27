package com.app.peris.artup.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.peris.artup.Adapters.GuessersRecyclerAdapter;
import com.app.peris.artup.Fragments.BeginFragment;
import com.app.peris.artup.Fragments.CardFragment;
import com.app.peris.artup.Fragments.CategoryFragment;
import com.app.peris.artup.Fragments.GuessersFragment;
import com.app.peris.artup.Fragments.OnFragmentInteractionListener;
import com.app.peris.artup.Fragments.PrepareFragment;
import com.app.peris.artup.Fragments.RecapFragment;
import com.app.peris.artup.Models.Card;
import com.app.peris.artup.Models.Category;
import com.app.peris.artup.Models.Player;
import com.app.peris.artup.Models.Team;
import com.app.peris.artup.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private ArrayList<Team> teams;
    private ArrayList<Category> categories;
    private Category currentCategory;
    private GuessersRecyclerAdapter adapter;
    private static int pointsToWin, currentTeam;
    private ArrayList<Card> playerCards;
    private CardFragment cardFragment;
    private String currentCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        pointsToWin = 10;
        currentTeam = 0;
        teams = new ArrayList<>();
        categories = new ArrayList<>();
        playerCards = new ArrayList<>();

        int count = 1;
        for(int x = 1; x < 4; x++){
            Team team = new Team("Team " + x);
            for(int y = 1; y < 4; y++){
                Player player = new Player("Player " + count);
                team.addPlayer(player);
                count++;
            }
            teams.add(team);
        }

        for(int x = 1; x <= 4; x++){
            Category category = new Category(x, "Category " + x);
            categories.add(category);
        }

        BeginFragment fragment = new BeginFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.game_fragment_holder, fragment).commit();
    }

    public static int getPointsToWin(){return pointsToWin;}

    public void nextRound(View view){
        for (Team team:teams) {
            team.roundReset();
        }
        currentTeam=0;
        prepareFragment(null);
    }

    public Team getTeam(){return teams.get(currentTeam);}

    public Category getNewCategory(){
        Random r = new Random();
        currentCategory = categories.get(r.nextInt(categories.size()));
        return currentCategory;
    }

    private void nextTeam(){currentTeam++;}

    public void prepareFragment(View view){nextFragment(new PrepareFragment());}

    public void categoryFragment(View view){nextFragment(new CategoryFragment());}

    public void cardFragment(View view){
        cardFragment = new CardFragment();
        currentCard = currentCategory.getCard();
        nextFragment(cardFragment);
    }

    public String getCurrentCard(){return currentCard;}

    public void guessersFragment(View view){nextFragment(new GuessersFragment());}

    public void correct(View view){
        addPlayerCard(currentCard);
        currentCard = currentCategory.getCard();
        cardFragment.setCardText(currentCard);
    }

    public void pass(View view){
        cardFragment.hideButton();
        currentCard = currentCategory.getCard();
        cardFragment.setCardText(currentCard);
    }

    public void recapFragment(){nextFragment(new RecapFragment());}

    public ArrayList<Team> getOrderedTeams(){
        ArrayList<Team> orderedTeams = new ArrayList<>();
        for (Team team:teams){orderedTeams.add(team);}
        Collections.sort(orderedTeams, new Comparator<Team>() {
            @Override
            public int compare(Team team1, Team team2)
            {
                return (team2.getTotalScore() - team1.getTotalScore());
            }
        });
        return orderedTeams;
    }

    private void nextFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.game_fragment_holder, fragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public GuessersRecyclerAdapter getAdapter(){
        adapter = new GuessersRecyclerAdapter(this,playerCards,getTeam());
        return adapter;
    }

    public void addPlayerCard(String card){playerCards.add(new Card(card, getTeam().getCurrentPlayerPosition()));}

    public void finishPlayerRound(View view){
        Team team = getTeam();
        team.addPoints(playerCards.size());
        team.getPlayer(team.getCurrentPlayerPosition()).addArticulations(playerCards.size());
        for (Card card:playerCards) {
            team.getPlayer(card.getPlayer()).addGuesses(1);
        }
        team.nextPlayer();
        nextTeam();
        playerCards = new ArrayList<>();
        if(team.checkWin()) Log.d("abc_def","WINNER WINNER CHIKEN DINNER");//TODO open winner fragment
        else if(currentTeam >= teams.size())recapFragment();
        else prepareFragment(null);
    }
}
