package com.app.peris.artup.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.peris.artup.Activities.GameActivity;
import com.app.peris.artup.Adapters.GuessersRecyclerAdapter;
import com.app.peris.artup.R;

public class GuessersFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public GuessersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guessers, container, false);
        GameActivity activity = ((GameActivity)getActivity());
        RecyclerView list = (RecyclerView)view.findViewById(R.id.list_guessers);
        list.setLayoutManager(new LinearLayoutManager(activity));
        list.setAdapter(activity.getAdapter());
        return view;
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
