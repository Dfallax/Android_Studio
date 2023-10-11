package com.example.test.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseAux extends SQLiteOpenHelper {
private static final String DB_NAME = "Juego_Topo";
private static final int DB_VERSION = 1;


    public DataBaseAux(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users "+
                "(id integer primary key autoincrement," +
                "name varchar(25) not null ," +
                "email varchar(25) not null )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
