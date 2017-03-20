package com.example.alasif.tourmate.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alasif.tourmate.Model.EventModel;

import java.util.ArrayList;

/**
 * Created by asif on 2/23/17.
 */

public class EventDatabaseSource {

    DbHelper dbHelper;
    EventModel eventModel;
    SQLiteDatabase sqLiteDatabase;

    public EventDatabaseSource(Context context) {
        dbHelper = new DbHelper(context);
    }


    //NewEvent newEvent = new NewEvent();

    // write the database
    public void open(){
        sqLiteDatabase=dbHelper.getWritableDatabase();
    }

    // read from database
    public void read(){
        sqLiteDatabase = dbHelper.getReadableDatabase();
    }

    // close the database
    public void close(){
        sqLiteDatabase.close();
    }

    /**
     * add new events
     * @param eventModel pass data inside the database
     * @return insertion status
     */
    public boolean addEvent(EventModel eventModel){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DbHelper.COLUMN_START_FROM,eventModel.getEventStartFrom());
        contentValues.put(DbHelper.COLUMN_EVENT_LOCATION,eventModel.getEventLocationName());
        contentValues.put(DbHelper.COLUMN_EVENT_START_DATE,eventModel.getEventStartDate());
        contentValues.put(DbHelper.COLUMN_EVENT_END_DATE,eventModel.getEventEndDate());
        contentValues.put(DbHelper.COLUMN_USER_ID_FOREIGNKEY,eventModel.getLoggedInUserId());
        long inserted=sqLiteDatabase.insert(DbHelper.EVENT_TABLE,null,contentValues);
        this.close();
        if(inserted>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * get all the event information which were created previously
     * @param loggedUserId get user id of current user
     * @return eventModels
     */

    public ArrayList<EventModel> getAllEvents(String loggedUserId){

        String currentLoggedInUserId = loggedUserId;
        ArrayList<EventModel> eventModels = new ArrayList<>();
        this.read();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+DbHelper.EVENT_TABLE
                +" where "+DbHelper.COLUMN_USER_ID_FOREIGNKEY+"='"+currentLoggedInUserId+"'",null);
        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){

                //int id = cursor.getInt(cursor.getColumnIndex(DbHelper.COLUMN_EVENT_ID));
                String eventStartFrom = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_START_FROM));
                String eventLocation = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_EVENT_LOCATION));
                String eventStartDate = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_EVENT_START_DATE));
                String eventEndDate = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_EVENT_END_DATE));
                eventModel = new EventModel(eventStartFrom,eventLocation, eventStartDate, eventEndDate);
                cursor.moveToNext();
                eventModels.add(eventModel);
            }
        }
        cursor.close();
        this.close();
        return eventModels;
    }
}
