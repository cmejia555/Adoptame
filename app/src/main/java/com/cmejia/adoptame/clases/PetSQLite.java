package com.cmejia.adoptame.clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PetSQLite extends SQLiteOpenHelper {

    private String createTableSQL = "CREATE TABLE PetDataTable (name TEXT, year TEXT, image TEXT)";

    public PetSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PetDataTable");
        sqLiteDatabase.execSQL(createTableSQL);
    }
}
