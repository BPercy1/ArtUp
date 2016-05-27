package com.app.peris.artup.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.peris.artup.Activities.GameActivity;
import com.app.peris.artup.Models.Player;
import com.app.peris.artup.Models.Team;
import com.app.peris.artup.R;

public class PrepareFragment extends Fragment {

    private TextView teamName, playerName, teamScore, playerGuesses, playerArtics, playerTotal;
    private Team team;
    private Player player;
    private GameActivity activity;
    private OnFragmentInteractionListener mListener;

    public PrepareFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void outputText() {
        teamName.setText(team.getName());
        playerName.setText(player.getName());
        teamScore.setText(String.valueOf(team.getTotalScore()));
        playerGuesses.setText(String.valueOf(player.getTotalGuesses()));
        playerArtics.setText(String.valueOf(player.getTotalArticulations()));
        playerTotal.setText(String.valueOf(player.getTotalGuesses() + player.getTotalArticulations()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prepare, container, false);
        activity = (GameActivity)getActivity();
        team = activity.getTeam();
        player = team.getCurrentPlayer();
        setViews(view);
        outputText();
        return view;
    }

    private void setViews(View parent) {
        teamName = (TextView)parent.findViewById(R.id.team_name_prepare);
        playerName = (TextView)parent.findViewById(R.id.player_name_prepare);
        teamScore = (TextView)parent.findViewById(R.id.team_score_prepare);
        playerGuesses = (TextView)parent.findViewById(R.id.player_guesses_prepare);
        playerArtics = (TextView)parent.findViewById(R.id.player_artics_prepare);
        playerTotal = (TextView)parent.findViewById(R.id.player_total_prepare);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
