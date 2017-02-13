package com.example.alasif.tourmate.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alasif.tourmate.R;

public class MainActivity extends AppCompatActivity {

    TextView loggedinTv;
    Button logoutBtn;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }                                                                  // End of login part
}
