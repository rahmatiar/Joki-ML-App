package com.example.rabin.jokeys.Game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rabin.jokeys.R;
import com.example.rabin.jokeys.Utills.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by rabin on 18/12/2017.
 */

public class GameActivity extends AppCompatActivity{
    private static final String TAG = "GameActivity";
    private static final int ACTIVITY_NUM = 1;

    private Context mContext = GameActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.d(TAG, "onCreate: started");
        setupBottomNavigationView();

        final Button btTampilML = (Button) findViewById(R.id.btTampilML);

        //button Mobile Legends
        btTampilML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MLIntent = new Intent(GameActivity.this, MobileLegendsActivity.class);
                GameActivity.this.startActivity(MLIntent);
            }
        });
    }
    /**
     * Bottom NaVIGATION view setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
