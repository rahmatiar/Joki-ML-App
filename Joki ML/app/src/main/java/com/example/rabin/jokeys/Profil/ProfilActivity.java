package com.example.rabin.jokeys.Profil;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rabin.jokeys.R;
import com.example.rabin.jokeys.Utills.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by rabin on 18/12/2017.
 */

public class ProfilActivity extends AppCompatActivity{
    private static final String TAG = "ProfilActivity";
    private static final int ACTIVITY_NUM = 2;

    private Context mContext = ProfilActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_profil);
        Log.d(TAG, "onCreate: started");
        setupBottomNavigationView();

        final Button btInfoGame = (Button) findViewById(R.id.btInfoGame);
        btInfoGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(ProfilActivity.this, InfoGameActivity.class);
                ProfilActivity.this.startActivity(registerIntent);
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

    //coba

}
