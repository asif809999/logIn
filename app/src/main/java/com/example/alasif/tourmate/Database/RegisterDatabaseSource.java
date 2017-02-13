package com.example.alasif.tourmate.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.alasif.tourmate.Model.RegisterModel;


public class RegisterDatabaseSource {
    DbHelper dbHelper;
    SQLiteDatabase database;
//    RegisterModel registerModel;

    public RegisterDatabaseSource(Context context) {
       dbHelper = new DbHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public void addUser(RegisterModel registerModel){
        this.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.COLUMN_EMAIL,registerModel.getEmail());
        contentValues.put(dbHelper.COLUMN_PASS,registerModel.getPassword());

        long inserted = database.insert(dbHelper.USER_TABLE, null, contentValues);
        this.close();

    }

    public boolean getUser(String email, String password){

        String selectQuery =  "select * from " + DbHelper.USER_TABLE + " where " +
                DbHelper.COLUMN_EMAIL + " = " + "'"+email+"'" + " and " + DbHelper.COLUMN_PASS + " = " + "'"+password+"'";
        this.open();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            return true;
        }
        cursor.close();
        this.close();
        return false;
    }
}
