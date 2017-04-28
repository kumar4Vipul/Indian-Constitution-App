package com.appbusters.robinpc.constitutionofindia.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.appbusters.robinpc.constitutionofindia.model.Data;

import java.util.ArrayList;
import java.util.List;


public class MyDBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SavedItems.db";
    private static final String TABLE_NAME = "SAVED_ITEMS";
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_DESCRIPTION = "DESCRIPTION";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME + " TEXT PRIMARY KEY, " + COLUMN_DESCRIPTION + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //CRUD OPERATIONS
    //CREATE
    public Boolean insertItem(String NAME, String DESCRIPTION){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME + " ", NAME);
        contentValues.put(COLUMN_DESCRIPTION + " ", DESCRIPTION);
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return true;
    }
    //READ
    private Cursor getItem(String NAME){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME +
                " WHERE " + COLUMN_NAME + "=\'" + NAME + "\'", null);                            //
        return cursor;
    }
//    //UPDATE
//    public boolean updateItem(Integer ID, String NAME, String DESCRIPTION) {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_NAME, NAME);
//        contentValues.put(COLUMN_DESCRIPTION, DESCRIPTION);
//        sqLiteDatabase.update(TABLE_NAME, contentValues, COLUMN_NAME + " = ? ", new String[] { NAME } );        //
//        return true;
//    }
    //DELETE
    public void deleteItem(String NAME) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,
                COLUMN_NAME + "= ? ",
                new String[] {NAME});
//        sqLiteDatabase.rawQuery("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " = \'" + NAME + "\' ", null);

    }



    public boolean checkIfSaved(String NAME){
        Cursor cursor = getItem(NAME);
        return cursor.getColumnIndex(NAME) == -1;
    }


    /*
    public ArrayList<String> getAllTwisters() {
        ArrayList<String> array_list = new ArrayList<>();

        //hp = new HashMap();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor res =  sqLiteDatabase.rawQuery( "SELECT * FROM " + TABLE_NAME + " ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
    */

    public List<Data> getAllItems() {
        List<Data> data = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor res =  sqLiteDatabase.rawQuery( "SELECT * FROM " + TABLE_NAME + " ", null );
        if(res!=null){

            res.moveToFirst();

            while(!res.isAfterLast()){
                data.add(new Data(res.getString(res.getColumnIndex(COLUMN_NAME)),res.getString(res.getColumnIndex(COLUMN_NAME)),res.getString(res.getColumnIndex(COLUMN_DESCRIPTION))));        //
                res.moveToNext();

            }
        }

        return data;
    }

    public int numberOfRows(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(sqLiteDatabase, TABLE_NAME);
        return numRows;
    };
}