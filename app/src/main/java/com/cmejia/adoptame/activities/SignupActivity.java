package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.clases.UserSQLite;

public class SignupActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.signup_username_et);
        password = findViewById(R.id.signup_password_et);
        signupButton = findViewById(R.id.signup_bt);

        UserSQLite userdb = new UserSQLite(getApplicationContext(), "DBUsers.db", null, 1);
        final SQLiteDatabase db = userdb.getWritableDatabase();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( username.getText().length() != 0 && password.getText().length() !=0 ) {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();

                    String[] col = new String[] {"username"};
                    String[] args = new String[] {user};
                    Cursor c = db.query("UserDataTable", null, "username=?",
                            args,null, null, null);

                    if( !c.moveToFirst() ) {
                        ContentValues register = new ContentValues();
                        register.put("username", user);
                        register.put("password", pass);
                        db.insert("UserDataTable", null, register);
                        c.close();
                        db.close();
                        finish();
                    }
                }
            }
        });
    }
}
