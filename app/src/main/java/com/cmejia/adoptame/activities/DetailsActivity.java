package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cmejia.adoptame.R;

public class DetailsActivity extends AppCompatActivity {

    private TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detail = findViewById(R.id.detail_tv);
        detail.setText(getIntent().getStringExtra("NAME"));
    }
}
