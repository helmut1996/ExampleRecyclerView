package com.helcode.examplerecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {
  // EN EL CONSTRUCTOR SE AGREGA EL NOMBRE DE LA BS Y LA VERCION DE LA TABLA QUE SE ESTA CREANDO
    public BDHelper( Context context) {
        super(context,"UsersBD.db",null,1);
    }


    // AQUI SE CREAN LAS TABLAS
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create TABLE Usersdetails(name TEXT PRIMARY KEY,lastname TEXT)");
    }

    // SE VALIDA SI LA TRABLA EXISTE SI EXISTE SE ELIMINA
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Usersdetails");
    }


    // ESTA ES LA FUNCION PARA INSERTAR REGISTROS EN LA TABLA
    public Boolean inserdata(String name,String lastname){
        SQLiteDatabase BD= this.getWritableDatabase();

        ContentValues  contentValues=  new ContentValues();
        contentValues.put("name",name);
        contentValues.put("lastname",lastname);

        long result = BD.insert("Usersdetails",null,contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
        }

    }

    // ESTA ES PARA MOSTRAS LOS DATOS DE LA TABLA
    public Cursor getdata(){
        SQLiteDatabase BD =  this.getWritableDatabase();
       Cursor cursor= BD.rawQuery ("select * from Usersdetails",null );
        return cursor;
    }
}


