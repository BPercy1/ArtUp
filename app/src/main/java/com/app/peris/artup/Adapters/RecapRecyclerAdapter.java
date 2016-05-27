package com.app.peris.artup.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.peris.artup.Models.Team;
import com.app.peris.artup.R;

import java.util.ArrayList;

/**
 * Created by Paul on 25/05/2016.
 */
public class RecapRecyclerAdapter extends RecyclerView.Adapter<RecapRecyclerAdapter.MyViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<Team> data;

    public RecapRecyclerAdapter(Context context, ArrayList<Team> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        //contains the appearance of the layout
        View view = inflater.inflate(R.layout.listitem_recap, parent, false);

        MyViewHolder holder = new MyViewHolder(view, context);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Team team = data.get(position);
        myViewHolder.teamTV.setText(team.getName());
        myViewHolder.totalTV.setText(String.valueOf(team.getTotalScore()));
        myViewHolder.roundTV.setText(String.valueOf(team.getRoundScore()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView teamTV, totalTV, roundTV;

        public MyViewHolder(View itemView, Context context){
            super(itemView);
            this.context = context;
            teamTV = (TextView)itemView.findViewById(R.id.team_recap_item);
            totalTV = (TextView)itemView.findViewById(R.id.total_recap_item);
            roundTV = (TextView)itemView.findViewById(R.id.round_recap_item);
        }
    }

}
