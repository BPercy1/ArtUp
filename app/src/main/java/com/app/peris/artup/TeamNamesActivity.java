package com.app.peris.artup;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by bethanycharlotteelizabethgracepercival on 08/04/2016.
 */
public class TeamNamesActivity extends Activity implements View.OnClickListener{

    LinearLayout mTeamNamesLL, mInsertLL;
    int mNoOfTeams;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teamnameslayout);
        setUp();
    }

    public void setUp(){
        mTeamNamesLL = (LinearLayout) findViewById(R.id.teamNameLL);
        mInsertLL = (LinearLayout) findViewById(R.id.insertTeamNamesLL);
        SharedPreferences prefs = this.getSharedPreferences(
                "com.app.peris.artup", Context.MODE_PRIVATE);
        mNoOfTeams = Integer.parseInt(prefs.getString("Teams", "2"));
        for (int i = 1; i<= mNoOfTeams;i++){
            mInsertLL.addView(mTeamNamesLL);
        }

    }

    public void next(){
        for (int i = 1; i<= mNoOfTeams;i++){
            //get values then go to next LL
        }
    }

    @Override
    public void onClick(View v) {

    }
}
