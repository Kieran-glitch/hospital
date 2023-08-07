package com.example.hospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String dbname= "patient.db";
    public static final String tablename="patient";
    public static final String c1="id";
    public static final String c2="name";
    public static final String c3="doctor";
    public static final String c4="ward";


    public DatabaseHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +tablename+"(  id INTEGER primary key autoincrement,name text,doctor text,ward integer )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+tablename);
        onCreate(db);

    }
    public boolean insertData(String Name,String Doctor,int Ward){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(c2,Name);
        c.put(c3,Doctor);
        c.put(c4,Ward);
        long r=sqLiteDatabase.insert(tablename,null,c);
        if(r== -1){
            return false;
        }else{
            return true;
        }
    }
}