package com.example.jimothy.androiduiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.jimothy.androiduiapp.model.entity.User;

public class LoginSuccessActivity extends AppCompatActivity {

    private String BUNDLE_NAME = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        User user = getIntent().getParcelableExtra(BUNDLE_NAME);

    }
}
