package com.example.martoo.poultry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DatabaseHelper6 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Batch.db";
    public static final String TABLE_NAME = "batchDet_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "BATCH";
    public static final String COL_3 = "ENTRY";
    public static final String COL_4 = "RELEASED";
    public static final String COL_5 = "ORIGIN";
    public static final String COL_6 = "TOTAL";
    public static final String COL_7 = "WEIGHT";
    public static final String COL_8 = "ROOM";
    public DatabaseHelper6(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,BATCH TEXT,ENTRY TEXT,RELEASED TEXT,ORIGIN TEXT,TOTAL TEXT,WEIGHT TEXT,ROOM TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertDat(String batch,String entry,String released,String  origin,String total,String weight,String room) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,batch);
        contentValues.put(COL_3,entry);
        contentValues.put(COL_4,released);
        contentValues.put(COL_5,origin);
        contentValues.put(COL_6,total);
        contentValues.put(COL_7,weight);
        contentValues.put(COL_8,room);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateDataa(String id,String batch,String entry,String released,String  origin,String total,String weight,String room) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,batch);
        contentValues.put(COL_3,entry);
        contentValues.put(COL_4,released);
        contentValues.put(COL_5,origin);
        contentValues.put(COL_6,total);
        contentValues.put(COL_7,weight);
        contentValues.put(COL_8,room);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteDataa (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}