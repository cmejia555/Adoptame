package com.cmejia.adoptame.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.adapters.ListViewAdapter;
import com.cmejia.adoptame.clases.Pet;
import com.cmejia.adoptame.clases.PetSQLite;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListViewAdapter adapter;

    private ListView listView;
    private Toolbar toolbar;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.list_view);
        toolbar = findViewById(R.id.toolbar);
        floatingActionButton = findViewById(R.id.floatingButton);

        setSupportActionBar(toolbar);

        List<Pet> pets = new ArrayList<>();
        //fillPetList(pets);

        final PetSQLite petdb = new PetSQLite(getApplicationContext(), "DBPet.db", null, 1);
        SQLiteDatabase db = petdb.getWritableDatabase();
        Cursor c = db.query("PetDataTable", null, null,
                null,null, null, null);
        if ( c.moveToFirst() ) {
            do {
                String name= c.getString(0);
                String age = c.getString(1);
                String image = c.getString(2);
                //String file = getApplicationContext().getFilesDir().getPath();
                int id = getResources().getIdentifier(image, "drawable", getPackageName());
                pets.add(new Pet(name, age, getResources().getDrawable(id)));
            } while(c.moveToNext());
            c.close();
        }

        setupListViewAdapter(pets);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(getApplicationContext(), TabsActivity.class);
                nextActivity.putExtra("NAME", ((Pet)adapterView.getItemAtPosition(i)).getName());
                startActivity(nextActivity);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
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
        this.adapter = new ListViewAdapter(getApplicationContext(), pets);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.action_search:
                // implementar una busqueda
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
