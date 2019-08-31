package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        userTv.setText(getIntent().getStringExtra("USER"));

        List<Pet> pets = new ArrayList<>();
        fillPetList(pets);
        setupListViewAdapter(pets);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(getApplicationContext(), DetailsActivity.class);
                nextActivity.putExtra("NAME", ((Pet)adapterView.getItemAtPosition(i)).getName());
                startActivity(nextActivity);
            }
        });

    }


    private void fillPetList(List<Pet> list) {
        list.add(new Pet("toby", "4", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("pelu", "5", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("olivia", "8", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("locky", "0,3", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("toby", "4", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("pelu", "5", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("olivia", "8", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("locky", "0,3", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("toby", "4", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("pelu", "5", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("olivia", "8", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("locky", "0,3", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("toby", "4", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("pelu", "5", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("olivia", "8", getResources().getDrawable(R.mipmap.ic_launcher)));
        list.add(new Pet("locky", "0,3", getResources().getDrawable(R.mipmap.ic_launcher)));
    }

    private void setupListViewAdapter(List<Pet> pets) {
        listView.setAdapter(new ListViewAdapter(getApplicationContext(), pets));
    }
}
