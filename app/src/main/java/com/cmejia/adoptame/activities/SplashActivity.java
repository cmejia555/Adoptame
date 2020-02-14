package com.cmejia.adoptame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.cmejia.adoptame.R;
import com.cmejia.adoptame.clases.PetSQLite;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_SCREEN_DELAY = 2000;
    private ProgressBar pBar;
    private ProgressBarAsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pBar = findViewById(R.id.progress_bar);

        final PetSQLite petdb = new PetSQLite(getApplicationContext(), "DBPet.db", null, 1);
        final SQLiteDatabase db = petdb.getWritableDatabase();

        Cursor c = db.query("PetDataTable", null, null,
                null,null, null, null);

        if( !c.moveToFirst() ) {
            ContentValues register = new ContentValues();
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

            c.close();
            db.close();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        asyncTask = new ProgressBarAsyncTask();
        asyncTask.execute();
    }

    public class ProgressBarAsyncTask extends AsyncTask<Void, Integer, Boolean> {

        public ProgressBarAsyncTask() { }

        private void tareaLarga() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pBar.setProgress(0);
            pBar.setMax(100);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            for(int i = 1; i <= 10; i++) {
                tareaLarga();
                publishProgress(i*10);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int progress = values[0];
            pBar.setProgress(progress);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Intent intent =  new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
            super.onCancelled(aBoolean);
        }
    }
}
