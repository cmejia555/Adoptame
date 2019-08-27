package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.adapters.ListViewAdapter;
import com.cmejia.adoptame.clases.Pet;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private TextView userTv;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        userTv = findViewById(R.id.list_user_tv);
        listView = findViewById(R.id.list_view);

        Intent intent = getIntent();
        String user = intent.getStringExtra("USER");
        userTv.setText(user);

        List<Pet> data = new ArrayList<>();
        data.add(new Pet("toby", "4", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("pelu", "5", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("olivia", "8", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("locky", "0,3", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("toby", "4", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("pelu", "5", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("olivia", "8", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("locky", "0,3", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("toby", "4", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("pelu", "5", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("olivia", "8", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("locky", "0,3", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("toby", "4", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("pelu", "5", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("olivia", "8", getResources().getDrawable(R.drawable.ic_launcher_background)));
        data.add(new Pet("locky", "0,3", getResources().getDrawable(R.drawable.ic_launcher_background)));

        listView.setAdapter(new ListViewAdapter(getApplicationContext(), data));
    }
}
