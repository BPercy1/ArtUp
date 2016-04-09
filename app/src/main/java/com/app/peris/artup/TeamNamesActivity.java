package com.app.peris.artup;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.w3c.dom.NodeList;

/**
 * Created by bethanycharlotteelizabethgracepercival on 08/04/2016.
 */
public class TeamNamesActivity extends Activity implements View.OnClickListener{

    LinearLayout mTeamNamesLL, mInsertLL;
    EditText team;
    int mNoOfTeams;
    View[] abc;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teamnameslayout);
        setUp();
    }

    public void setUp(){
        mTeamNamesLL = (LinearLayout) findViewById(R.id.teamNameLL);
        mInsertLL = (LinearLayout) findViewById(R.id.insertTeamNamesLL);
        team = (EditText) findViewById(R.id.teamNameET);
        SharedPreferences prefs = this.getSharedPreferences(
                "com.app.peris.artup", Context.MODE_PRIVATE);
        mNoOfTeams = Integer.parseInt(prefs.getString("Teams", "2"));

        LinearLayout myRoot = (LinearLayout) findViewById(R.id.my_root);
        LinearLayout a = new LinearLayout(this);
        a.setOrientation(LinearLayout.VERTICAL);
        abc = new View[mNoOfTeams];
        for (int i = 1; i<= mNoOfTeams;i++){
            //String LLName = "teamname"+i;
            //View LLName = getLayoutInflater().inflate(R.layout.teamnameslayout, null);
            abc[i] = getLayoutInflater().inflate(R.layout.teamnameslayout, null);
            a.addView(abc[i]);
        }
        myRoot.addView(a);
    }

    public void next(){
        NodeList list = findViewById(R.id.insertTeamNamesLL).getElementsByTagName("staff");
        team = (EditText) findViewById(R.id.teamNameET);
        String name1 = team.getText().toString();
        team = (EditText) findViewById(R.id.teamNameET);
        String name2 = team.getText().toString();
        for (int i = 1; i<= abc.length;i++){
            abc[i]
        }
    }

    @Override
    public void onClick(View v) {

    }
}
