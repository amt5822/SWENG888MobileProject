package com.example.jimothy.androiduiapp.model.dao;

public class UserTable {

    /** Defining the Table Content **/
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_FIRST_NAME = "firstName";
    public static final String COLUMN_NAME_LAST_NAME = "lastName";
    public static final String COLUMN_NAME_EMAIL = "email";
    public static final String COLUMN_NAME_PASSWORD = "password";
    public static final String COLUMN_NAME_USERNAME = "username";
    public static final String COLUMN_NAME_PHONE = "phone";

    public static String create(){
        return new String ( "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME_FIRST_NAME + " TEXT," +
                COLUMN_NAME_LAST_NAME  + " TEXT," +
                COLUMN_NAME_EMAIL + " TEXT," +
                COLUMN_NAME_PASSWORD + " TEXT," +
                COLUMN_NAME_USERNAME + " TEXT," +
                COLUMN_NAME_PHONE + " TEXT)" );
    }

    public static String select(){
        return new String("SELECT * FROM "+TABLE_NAME);

    }

    public static final String delete(){
        return "DROP TABLE IF EXISTS " +TABLE_NAME;
    }
}
