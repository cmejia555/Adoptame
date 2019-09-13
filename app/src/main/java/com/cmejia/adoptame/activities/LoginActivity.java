package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cmejia.adoptame.R;

public class LoginActivity extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.login_name_et);
        password = findViewById(R.id.login_password_et);
        loginButton = findViewById(R.id.login_bt);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                intent.putExtra("USER", user.getText().toString());
                startActivity(intent);
            }
        });

    }
}
