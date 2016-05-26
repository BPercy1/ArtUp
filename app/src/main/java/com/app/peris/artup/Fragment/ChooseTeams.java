package com.app.peris.artup.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;


import com.app.peris.artup.Adapter.ExpandableAdapter;
import com.app.peris.artup.R;

import java.util.ArrayList;

/**
 * Created by Beth on 09/05/2016.
 */
public class ChooseTeams extends Fragment {

    ExpandableAdapter expandableadapter;
    ExpandableListView expandableListView;
    ArrayList<String> headers;
    ArrayList<Integer> layouts;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.chooseteamslayout, null);
        prepareLayouts();
        prepareExpandableListView();
        return inflater.inflate(R.layout.chooseteamslayout, container, false);
    }



    public void prepareExpandableListView(){
        expandableListView=(ExpandableListView)rootView.findViewById(R.id.teamelv);
        expandableadapter=new ExpandableAdapter(getActivity(),headers, layouts);
             expandableListView.setAdapter(expandableadapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(), headers.get(groupPosition), Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(), headers.get(groupPosition), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void prepareLayouts() {
        headers=new ArrayList<String>();
        layouts = new ArrayList<Integer>();
        //adding headers
        headers.add("Team 1");
        headers.add("Team 2");
        //contain header and header items
        layouts.add(R.layout.teamlistviewitemlayout);
        layouts.add(R.layout.teamlistviewitemlayout);
    }

}