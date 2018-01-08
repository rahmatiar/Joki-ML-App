package com.example.rabin.jokeys.Utills;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.rabin.jokeys.BerandaActivity;
import com.example.rabin.jokeys.Game.GameActivity;
import com.example.rabin.jokeys.Profil.ProfilActivity;
import com.example.rabin.jokeys.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by rabin on 18/12/2017.
 */

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
        
    }

    public static void enableNavigation(final Context context,BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_discovery:
                        Intent intent1 = new Intent(context, BerandaActivity.class);//ACTIVITY_NUM = 3
                        context.startActivity(intent1);
                        break;
                    case R.id.ic_game:
                        Intent intent2 = new Intent(context, GameActivity.class);//ACTIVITY_NUM = 2
                        context.startActivity(intent2);
                        break;


                    case R.id.ic_profil:
                        Intent intent3 = new Intent(context, ProfilActivity.class);//ACTIVITY_NUM = 4
                        context.startActivity(intent3);
                        break;

                }

                return false;
            }
        });
    }
}
