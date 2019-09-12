package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.fragments.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_settings);

        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
