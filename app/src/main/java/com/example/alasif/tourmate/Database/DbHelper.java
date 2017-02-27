package com.example.alasif.tourmate.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "tourmate.db";
    public static final int DB_VERSION = 6;
    public static final String USER_TABLE = "users";
    public static final String COLUMN_USER_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";

    public static final String CREATE_TABLE_USER = "CREATE TABLE "
            + USER_TABLE + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASS + " TEXT);";

    // Create columns of Event table
    public static final String EVENT_TABLE = "events";
    public static final String COLUMN_EVENT_ID = "id";
    public static final String COLUMN_START_FROM = "event_start_from";
    public static final String COLUMN_EVENT_LOCATION = "event_location_name";
    public static final String COLUMN_EVENT_START_DATE = "start_date";
    public static final String COLUMN_EVENT_END_DATE = "end_date";
    public static final String COLUMN_USER_ID_FOREIGNKEY = "user_id_foreign_key";

    // Add query to create Event table
    public static final String CREATE_EVENT_TABLE = "CREATE TABLE "
            + EVENT_TABLE + "("
            + COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_START_FROM + " TEXT,"
            + COLUMN_EVENT_LOCATION + " TEXT,"
            + COLUMN_EVENT_START_DATE + " TEXT,"
            + COLUMN_EVENT_END_DATE + " TEXT,"
            + COLUMN_USER_ID_FOREIGNKEY + " INTEGER);";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(CREATE_EVENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ USER_TABLE);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ EVENT_TABLE);
        onCreate(sqLiteDatabase);
    }

}
