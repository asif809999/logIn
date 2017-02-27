package com.example.alasif.tourmate.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alasif.tourmate.Database.EventDatabaseSource;
import com.example.alasif.tourmate.Model.EventModel;
import com.example.alasif.tourmate.Model.RegisterModel;
import com.example.alasif.tourmate.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView loggedinTv;
    Button logoutBtn;
    Session session;
    FloatingActionButton addNewEventsFaBtn;
    int currentLoggedInUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentLoggedInUserId =getIntent().getIntExtra("userId", 0); //get userId from LoginActivity
        addNewEventsFaBtn = (FloatingActionButton) findViewById(R.id.eventAddButton);
        loggedinTv = (TextView) findViewById(R.id.loggedInTextView);
        logoutBtn = (Button) findViewById(R.id.logoutButton);
        session = new Session(this);

        if(!session.loggedin()){
            logout();
        }
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this,Login.class));
    } // End of login part

    /**
     * add new eventButton
     * @param view
     */
    public void addNewEvent(View view) {
        // go to AddEvents Activity
        Intent nextIntent = new Intent(MainActivity.this, AddEvents.class);
        nextIntent.putExtra("loggedinUserId", currentLoggedInUserId);
        startActivity(nextIntent);
    }
}
