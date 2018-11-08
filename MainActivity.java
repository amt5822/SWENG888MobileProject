package com.example.jimothy.androiduiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.jimothy.androiduiapp.model.dao.PersistenceUser;
import com.example.jimothy.androiduiapp.model.entity.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private String BUNDLE_NAME = "USER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        if(btnLogin != null){
            btnLogin.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                attemptLogin();
                                            }
                                        }

            );
        }


    }



    private void attemptLogin(){

        PersistenceUser persistenceUser = new PersistenceUser(this);
// use the email to get the matching user
        ArrayList<User> users = persistenceUser.getDataFromDB();

        String email = "";
        String password = "";

        EditText evEmail = (EditText) findViewById(R.id.editLoginEmail);
        if(evEmail != null){
            email =  evEmail.getText().toString();
        }

        EditText evPassword = (EditText) findViewById(R.id.editLoginPassword);
        if(evPassword != null){
            password =  evPassword.getText().toString();
        }

        User currentUser = null;

        currentUser = findUser(users, email);

        if(currentUser != null && currentUser.getPassword() == password){
            // if pw match
            // open activity
            Intent intent = new Intent(MainActivity.this, LoginSuccessActivity.class);
            intent.putExtra(BUNDLE_NAME, currentUser);
            startActivity(intent);


        } else {

                Toast.makeText(getApplicationContext(), "User Successfully Created.", Toast.LENGTH_LONG).show();

            }

        }
               // then verify that pw matches
        // else toast wrong



        // if success serialize

    private User findUser(ArrayList<User> users, String email){
        User user = null;
        for(User u: users){
            if(u.getEmail() == email){
                user = u;
                return user;
            }

        }
        return user;
    }


}
