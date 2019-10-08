package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.adapters.ListViewAdapter;
import com.cmejia.adoptame.clases.Pet;
import com.cmejia.adoptame.clases.UserSQLite;

public class AddActivity extends AppCompatActivity {

    private EditText name;
    private EditText age;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.username_et);
        age = findViewById(R.id.age_et);
        addButton = findViewById(R.id.add_bt);

        UserSQLite userdb = new UserSQLite(getApplicationContext(), "DBPet.db", null, 1);
        final SQLiteDatabase db = userdb.getWritableDatabase();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( name.getText().length() != 0 && age.getText().length() != 0 ) {
                    String namePet = name.getText().toString();
                    String agePet = age.getText().toString();

                    ContentValues register = new ContentValues();
                    register.put("name", namePet);
                    register.put("year", agePet);
                    register.put("image", "libros");
                    db.insert("PetDataTable", null, register);
                    db.close();
                    int id = getResources().getIdentifier("dog", "drawable", getPackageName());
                    ListViewAdapter.addItem(new Pet(namePet, agePet, getResources().getDrawable(id)));
                    finish();
                }
            }
        });

    }
}
