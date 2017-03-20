package com.example.alasif.tourmate.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alasif.tourmate.Adapters.ShowEventDetailsRecyclerViewAdapter;
import com.example.alasif.tourmate.Database.EventDatabaseSource;
import com.example.alasif.tourmate.Model.EventModel;
import com.example.alasif.tourmate.Model.RegisterModel;
import com.example.alasif.tourmate.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ShowEventDetailsRecyclerViewAdapter showEventDetailsRecyclerViewAdapter;
    TextView loggedinTv;
    Button logoutBtn;
    Session session;
    FloatingActionButton addNewEventsFaBtn;
    int currentLoggedInUserId;
    ArrayList<EventModel>eventModels2;
    EventDatabaseSource eventDatabaseSource;
   // private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewEventsFaBtn = (FloatingActionButton) findViewById(R.id.eventAddButton);
        loggedinTv = (TextView) findViewById(R.id.loggedInTextView);
        logoutBtn = (Button) findViewById(R.id.logoutButton);
        recyclerView = (RecyclerView) findViewById(R.id.eventsRecyclerView);


        eventDatabaseSource = new EventDatabaseSource(this);
        currentLoggedInUserId =getIntent().getIntExtra("userId",0); //get userId from LoginActivity
        eventModels2 = new ArrayList<>();
        eventModels2 = eventDatabaseSource.getAllEvents(String.valueOf(currentLoggedInUserId));
        showEventDetailsRecyclerViewAdapter = new ShowEventDetailsRecyclerViewAdapter(this,eventModels2);
        recyclerView.setAdapter(showEventDetailsRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Log.v(TAG, "dataSize" + showEventDetailsRecyclerViewAdapter.getItemCount());

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
        nextIntent.putExtra("userId", currentLoggedInUserId);
        startActivity(nextIntent);
    }
}
