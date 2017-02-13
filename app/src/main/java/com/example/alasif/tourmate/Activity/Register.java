package com.example.alasif.tourmate.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.alasif.tourmate.Database.RegisterDatabaseSource;
import com.example.alasif.tourmate.Model.RegisterModel;
import com.example.alasif.tourmate.R;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private EditText emailEt,passwordEt;
    private Button registerBtn;
    private RegisterModel registerModel;
    private RegisterDatabaseSource registerDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEt = (EditText) findViewById(R.id.emailEditText);
        passwordEt = (EditText) findViewById(R.id.passwordEditText);
        registerBtn = (Button) findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.registerButton:
                register();
                break;
            case R.id.loginButton:
                startActivity(new Intent(Register.this,Login.class));
                break;
            default:
                break;
        }
    }

    private void register(){
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        registerModel = new RegisterModel(email, password);
        registerDatabaseSource = new RegisterDatabaseSource(this);

        if(registerModel.getEmail().isEmpty() && registerModel.getPassword().isEmpty()){
            displayToast("username/password is empty");
        }
        else {
            registerDatabaseSource.addUser(registerModel); // call addUser method
            displayToast("user registered");
            finish();
        }
    }
    private void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
