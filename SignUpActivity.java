package com.example.jimothy.androiduiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jimothy.androiduiapp.model.dao.PersistenceUser;
import com.example.jimothy.androiduiapp.model.entity.User;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        Button btnLogin = (Button) findViewById(R.id.btnSignUp);
        if(btnLogin != null){
            btnLogin.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                createAccount();
                                            }
                                        }

            );
        }

    }

    private void createAccount(){

        String firstName = "";
        String lastName = "";
        String email = "user@server.com";
        String password = "password";
        String username = "username";
        String phone = "2678256132";

        EditText evFirstName = (EditText) findViewById(R.id.editFirstName);
        if(evFirstName != null){
           firstName =  evFirstName.getText().toString();
        }

        EditText evLastName = (EditText) findViewById(R.id.editLastName);
        if(evLastName != null){
            lastName =  evLastName.getText().toString();
        }

        EditText evEmail = (EditText) findViewById(R.id.editEmail);
        if(evEmail != null){
            email =  evEmail.getText().toString();
        }

        EditText evPassword = (EditText) findViewById(R.id.editPassword);
        if(evPassword != null){
            password =  evPassword.getText().toString();
        }

        EditText evUsername = (EditText) findViewById(R.id.editUsername);
        if(evUsername != null){
            username =  evUsername.getText().toString();
        }

        EditText evPhone = (EditText) findViewById(R.id.editPhone);
        if(evPhone != null){
            phone =  evPhone.getText().toString();
        }



        User newUser = new User(firstName, lastName, email, password, username, phone);

        PersistenceUser persistenceUser = new PersistenceUser(this);

        persistenceUser.insert(newUser);




    }

}
