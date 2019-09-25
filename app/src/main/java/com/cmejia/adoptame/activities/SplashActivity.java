package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.clases.PetSQLite;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        final PetSQLite petdb = new PetSQLite(getApplicationContext(), "DBPet.db", null, 1);
        final SQLiteDatabase db = petdb.getWritableDatabase();

        Cursor c = db.query("PetDataTable", null, null,
                null,null, null, null);

        if( !c.moveToFirst() ) {
            ContentValues register = new ContentValues();
            register.put("name", "Toby");
            register.put("year", "4");
            register.put("image", "control_moderno");
            db.insert("PetDataTable", null, register);

            register.put("name", "Olivia");
            register.put("year", "7");
            register.put("image", "control_moderno");
            db.insert("PetDataTable", null, register);

            register.put("name", "Pelu");
            register.put("year", "5");
            register.put("image", "control_moderno");
            db.insert("PetDataTable", null, register);

            register.put("name", "Toby");
            register.put("year", "4");
            register.put("image", "libros");
            db.insert("PetDataTable", null, register);

            register.put("name", "Olivia");
            register.put("year", "7");
            register.put("image", "libros");
            db.insert("PetDataTable", null, register);

            register.put("name", "Pelu");
            register.put("year", "5");
            register.put("image", "libros");
            db.insert("PetDataTable", null, register);

            register.put("name", "Toby");
            register.put("year", "4");
            register.put("image", "libros");
            db.insert("PetDataTable", null, register);

            register.put("name", "Olivia");
            register.put("year", "7");
            register.put("image", "libros");
            db.insert("PetDataTable", null, register);

            register.put("name", "Pelu");
            register.put("year", "5");
            register.put("image", "control_moderno");
            db.insert("PetDataTable", null, register);

            register.put("name", "Toby");
            register.put("year", "4");
            register.put("image", "control_moderno");
            db.insert("PetDataTable", null, register);

            register.put("name", "Olivia");
            register.put("year", "7");
            register.put("image", "libros");
            db.insert("PetDataTable", null, register);

            register.put("name", "Pelu");
            register.put("year", "5");
            register.put("image", "control_moderno");
            db.insert("PetDataTable", null, register);

            c.close();
            db.close();
        }
        Intent intent =  new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();

    }
}
