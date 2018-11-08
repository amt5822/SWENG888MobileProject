package com.example.jimothy.androiduiapp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jimothy.androiduiapp.model.entity.User;

import java.util.ArrayList;


public class PersistenceUser implements IPersistence{

    public DatabaseAccess databaseAccess;

    public PersistenceUser(Context context){
        this.databaseAccess = new DatabaseAccess(context);
    }

    @Override
    public void insert(Object o) {


        User user = (User) o;

        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();

        // The ContentValues object create a map of values, where the columns are the keys
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserTable.COLUMN_NAME_FIRST_NAME, user.getFirstName());
        contentValues.put(UserTable.COLUMN_NAME_LAST_NAME, user.getLastName());
        contentValues.put(UserTable.COLUMN_NAME_EMAIL, user.getEmail());
        contentValues.put(UserTable.COLUMN_NAME_PASSWORD, user.getPassword());
        contentValues.put(UserTable.COLUMN_NAME_USERNAME, user.getUsername());
        contentValues.put(UserTable.COLUMN_NAME_PHONE, user.getPhone());

        // Insert the ContentValues into the Movie table.
        sqLiteDatabase.insert(UserTable.TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();
    }

    @Override
    public void delete(Object o) {

        User user = (User) o;

        // Define which column will be the parameter for deleting the record.
        String selection = UserTable.COLUMN_NAME_EMAIL + "LIKE ? ";

        // Arguments must be identidied in the placehold order
        String [] selectionArgs = { user.getEmail().trim() };

        // Get database instance
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();
        sqLiteDatabase.delete(UserTable.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public void edit(Object o) {
        // TODO for the students to practice
    }

    @Override
    public ArrayList getDataFromDB() {

        // Create ArrayList of movies
        ArrayList<User> users = null;

        // Instatiate the database.
        SQLiteDatabase sqLiteDatabase = databaseAccess.getWritableDatabase();

        // Gather all the records found for the USER table.
        Cursor cursor = sqLiteDatabase.rawQuery(UserTable.select(), null);

        // It will iterate since the first record gathered from the database.
        cursor.moveToFirst();

        // Check if there exist other records in the cursor
        users = new ArrayList<>();

        if(cursor != null && cursor.moveToFirst()){

            do {
                String firstName = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_FIRST_NAME));
                String lastName = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_LAST_NAME));
                String email = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_EMAIL));
                String password = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_PASSWORD));
                String username = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_USERNAME));
                String phone = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_PHONE));

                // Convert to Movie object.
                User user = new User(firstName, lastName, email, password, username, phone);
                users.add(user);

            } while (cursor.moveToNext()) ;
        }

        return users;
    }
}
