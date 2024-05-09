package com.velasquez.todoenuno.OpenHelperSQLite;

//Importar el paquete de SQLite

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


/**
 * Clase que conectara a SQLite
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * @Deprecated sqLiteDatabase Eliminar
     */
    @Override
    public void onCreate(SQLiteDatabase BaseDatabase) {
        BaseDatabase.execSQL("CREATE TABLE Articulos(codigo int PRIMARY KEY, descripcion text, precio real)");
    }//Fin onCreate

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}//Fin AdminSQLiteOpenHelper
