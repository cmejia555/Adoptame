package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.clases.UserSQLite;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginButton;
    private TextView signupTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username_et);
        password = findViewById(R.id.login_password_et);
        loginButton = findViewById(R.id.login_bt);
        signupTextView = findViewById(R.id.login_signup_tv);

        final SharedPreferences preferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        username.setText(preferences.getString("username","not user"));
        password.setText(preferences.getString("password", "not pass"));

        UserSQLite userdb = new UserSQLite(getApplicationContext(), "DBUsers.db", null, 1);
        final SQLiteDatabase db = userdb.getWritableDatabase();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( username.getText().length() != 0 && password.getText().length() != 0 ) {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();

                    String[] col = new String[] {"username", "password"};
                    String[] args = new String[] {user, pass};
                    Cursor c = db.query("UserDataTable", null, "username=? AND password=?",
                            args,null, null, null);

                    if( c.moveToFirst() ) {
                        Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                        intent.putExtra("USER", username.getText().toString());

                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("username", username.getText().toString());
                        editor.putString("password",password.getText().toString());
                        editor.apply();

                        c.close();
                        db.close();
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                username.setText("");
                password.setText("");
                startActivity(intent);
            }
        });
    }
}
