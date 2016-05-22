package com.app.peris.artup;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.app.peris.artup.R;

/**
 * Created by bethanycharlotteelizabethgracepercival on 06/04/2016.
 */
public class SetupActivity extends Activity {

    Switch mPassesSw;
    Spinner mPassesS, mTeamS, mTimeS, mPointsS;
    EditText mTimeET;
    Button mNext;
    String mTimeUnit, mPasses, mTeams, mTime, mPoints;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setuplayout);
        //setUp();
    }

//    public void setUp(){
//        mPassesSw = (Switch) findViewById(R.id.passesSw);
//        if (mPassesSw != null) {
//            mPassesSw.setOnCheckedChangeListener(this);
//        }
//
//        mPassesS = (Spinner) findViewById(R.id.numberS);
//        mTeamS = (Spinner) findViewById(R.id.teamsS);
//        mTimeS = (Spinner) findViewById(R.id.timeS);
//        mPointsS = (Spinner) findViewById(R.id.pointsS);
//        mTimeET = (EditText) findViewById(R.id.timeET);
//        mNext = (Button) findViewById(R.id.nextB);
//        mNext.setOnClickListener(this);
//    }
//
//    public void next(View view){
//        mPasses = mPassesS.getSelectedItem().toString();
//        mTeams = mTeamS.getSelectedItem().toString();
//        mTime = mTimeET.getText().toString();
//        mPoints = mPointsS.getSelectedItem().toString();
//        mTimeUnit = mTimeS.getSelectedItem().toString();
//
//        if (mTime.matches("^[0-9]$")){
//            SharedPreferences prefs = this.getSharedPreferences(
//                    "com.app.peris.artup", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = prefs.edit();
//            editor.putString("Passes", String.valueOf(mPasses));
//            editor.putString("Teams", String.valueOf(mTeams));
//            editor.putString("Time", String.valueOf(mTime));
//            editor.putString("Points", String.valueOf(mPoints));
//            editor.putString("TimeUnit", String.valueOf(mTimeUnit));
//            editor.putBoolean("Saved", true);
//            editor.commit();
//        }else{
//            mTimeET.setError("Invalid Time");
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        Toast.makeText(this, "The Switch is " + (isChecked ? "on" : "off"),
//                Toast.LENGTH_SHORT).show();
//        if(isChecked) {
//            mPassesS.getSelectedView().setEnabled(true);
//            mPassesS.setEnabled(true);
//        } else {
//            mPassesS.getSelectedView().setEnabled(false);
//            mPassesS.setEnabled(false);
//        }
//    }
}
