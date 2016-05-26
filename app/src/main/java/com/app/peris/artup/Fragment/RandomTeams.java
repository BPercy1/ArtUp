package com.app.peris.artup.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.peris.artup.R;

/**
 * Created by bethanycharlotteelizabethgracepercival on 25/05/2016.
 */

public class RandomTeams extends Fragment {

    public RandomTeams() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.randomteamslayout, container, false);
    }

}