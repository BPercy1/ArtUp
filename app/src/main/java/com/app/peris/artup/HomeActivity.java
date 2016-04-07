package com.app.peris.artup;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by bethanycharlotteelizabethgracepercival on 04/04/2016.
 */
public class HomeActivity extends Activity{

LinearLayout mPlay, mStats, mSettings, mStore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homelayout);
        setUp();
    }

    public void setUp(){
        mPlay = (LinearLayout) findViewById(R.id.playLL);
        mStats = (LinearLayout) findViewById(R.id.statsLL);
        mSettings = (LinearLayout) findViewById(R.id.settingsLL);
        mStore = (LinearLayout) findViewById(R.id.storeLL);
    }

    public void play(View view){
        SharedPreferences prefs = this.getSharedPreferences(
                "com.app.peris.artup", Context.MODE_PRIVATE);
        if (prefs.getBoolean("Saved", false)){
            //startActivity(Intent I(this, SetupActivity.class));
        }else{
            //find out where they're up to and then get shared prefs
        }

    }

    public void stats(View view){
        //startActivity(Intent I(this, PlayLayout.class));
    }

    public void settings(View view){
        //startActivity(Intent I(this, PlayLayout.class));
    }

    public void store(View view){
        //startActivity(Intent I(this, PlayLayout.class));
    }
}
