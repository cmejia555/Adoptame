package com.cmejia.adoptame.clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserSQLite extends SQLiteOpenHelper {

    private String createTableSQL = "CREATE TABLE UserDataTable (username TEXT, password TEXT)";

    public UserSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS UserDataTable"); //Se elimina la versión anterior de la tabla
        sqLiteDatabase.execSQL(createTableSQL); //Se crea la NUEVA versión de la tabla (SE DEBERIA IMPORTAR LA TABLA ANTERIOR Y ACTUALIZARLA)
    }
}
