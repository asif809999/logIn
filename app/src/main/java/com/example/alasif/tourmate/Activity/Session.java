package com.example.alasif.tourmate.Activity;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by AL ASIF on 8/31/2016.
 */
public class Session {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public Session( Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("TourMate", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLoggedin(boolean loggedin){
        editor.putBoolean("loggedInMode", loggedin);
        editor.commit();
    }

    public boolean loggedin(){
        return sharedPreferences.getBoolean("loggedInMode", false); // interesting
    }
}
