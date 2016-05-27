package com.app.peris.artup.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.peris.artup.Models.Card;
import com.app.peris.artup.Models.Team;
import com.app.peris.artup.R;

import java.util.ArrayList;

/**
 * Created by Paul on 25/05/2016.
 */
public class GuessersRecyclerAdapter extends RecyclerView.Adapter<GuessersRecyclerAdapter.MyViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<Card> data;
    Team team;

    public GuessersRecyclerAdapter(Context context, ArrayList<Card> data, Team team) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.team = team;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        //contains the appearance of the layout
        View view = inflater.inflate(R.layout.listitem_guessers, parent, false);

        MyViewHolder holder = new MyViewHolder(view, context, data.get(position));

        return holder;
    }


    //method is called for each row
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        myViewHolder.cardTV.setText(data.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /*#-#-#-#-#-*/

    class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        Context context;
        TextView cardTV, playerTV;
        Card card;

        public MyViewHolder(View itemView, Context context, Card card){
            super(itemView);
            this.context = context;
            itemView.setOnClickListener(this);
            this.card = card;
            cardTV = (TextView)itemView.findViewById(R.id.card_guessers_item);
            playerTV = (TextView)itemView.findViewById(R.id.player_guessers_item);
            playerTV.setText(team.getPlayer(card.getPlayer()).getName());
        }

        @Override
        public void onClick(View v) {
            card.playerIncrement();
            if(card.getPlayer() == team.getCurrentPlayerPosition())card.playerIncrement();
            if(card.getPlayer() >= team.getPlayersSize()){card.playerReset();}
            if(card.getPlayer() == team.getCurrentPlayerPosition())card.playerIncrement();
            playerTV.setText(team.getPlayer(card.getPlayer()).getName());
        }
    }

}
