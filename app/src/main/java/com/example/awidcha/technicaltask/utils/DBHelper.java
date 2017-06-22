package com.example.awidcha.technicaltask.utils;

/**
 * Created by Awidcha on 23/6/2560.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.awidcha.technicaltask.constant.User;
import com.example.awidcha.technicaltask.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();

    private SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, User.DATABASE_NAME, null, User.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_FRIEND_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                User.TABLE,
                User.Column.Employee_ID,
                User.Column.FULL_NAME,
                User.Column.NICK_NAME,
                User.Column.ADDRESS,
                User.Column.PHONE,
                User.Column.PHOTO,
                User.Column.QUALIFICATION,
                User.Column.EXPERIENCE,
                User.Column.EMAIL_ID,
                User.Column.DOB,
                User.Column.ANNIVERSARY,
                User.Column.FACEBOOK,
                User.Column.LINKED_IN,
                User.Column.CURRENT_LOC
        );

        Log.i(TAG, CREATE_FRIEND_TABLE);

        // create friend table
        db.execSQL(CREATE_FRIEND_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS " + User.TABLE;

        db.execSQL(DROP_FRIEND_TABLE);

        Log.i(TAG, "Upgrade Database from " + oldVersion + " to " + newVersion);

        onCreate(db);
    }

    public List<UserModel> getAllUser() {

        String QUERY_ALL_FRIEND = "SELECT * FROM " + User.TABLE;

        List<UserModel> userModels = new ArrayList<>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(QUERY_ALL_FRIEND, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            UserModel userModel = new UserModel();
            userModel.setId((int) cursor.getLong(0));
            userModel.setFullName(cursor.getString(1));
//            userModel.setLastName(cursor.getString(2));
//            friend.setEmail(cursor.getString(3));
//            friend.setDescription(cursor.getString(4));

            userModels.add(userModel);

            cursor.moveToNext();
        }

        sqLiteDatabase.close();


        return userModels;
    }

    public List<UserModel> getTest(){
        return new ArrayList<>();
    }

    public void addUser(UserModel user) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put(User.Column.ID, friend.getId());
        values.put(User.Column.FULL_NAME, user.getFullName());
//        values.put(User.Column.LAST_NAME, friend.getLastName());
//        values.put(User.Column.TEL, friend.getTel());
//        values.put(User.Column.EMAIL, friend.getEmail());
//        values.put(User.Column.DESCRIPTION, friend.getDescription());

        sqLiteDatabase.insert(User.TABLE, null, values);

        sqLiteDatabase.close();
    }

}