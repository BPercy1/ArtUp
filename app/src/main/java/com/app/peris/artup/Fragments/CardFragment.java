package com.app.peris.artup.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.MainThread;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.peris.artup.Activities.GameActivity;
import com.app.peris.artup.Models.Category;
import com.app.peris.artup.R;

public class CardFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private TextView timerTV, cardTV;
    private Button correctB, passB;
    private GameActivity activity;

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        setup(view);
        return view;
    }

    private void setup(View view) {
        activity = ((GameActivity)getActivity());
        timerTV = (TextView)view.findViewById(R.id.timer_card);
        cardTV = (TextView)view.findViewById(R.id.card_card);
        correctB = (Button)view.findViewById(R.id.correct_card);
        passB = (Button)view.findViewById(R.id.pass_card);

        setCardText(((GameActivity)getActivity()).getCurrentCard());

        timerTV.setText("30");
        CountDownTimer timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {timerTV.setText(String.valueOf(millisUntilFinished / 1000));}

            @Override
            public void onFinish() {
                activity.guessersFragment(null);
            }
        };
        timer.start();
    }

    public void setCardText(String card){cardTV.setText(card);}

    public void hideButton(){passB.setVisibility(View.GONE);}

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
