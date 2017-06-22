package com.example.awidcha.technicaltask.constant;

import android.provider.BaseColumns;

/**
 * Created by Awidcha on 23/6/2560.
 */

public class User {
    //Database
    public static final String DATABASE_NAME = "devahoy_friends.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "friend";

    public class Column {
        public static final String Employee_ID = BaseColumns._ID;
        public static final String FULL_NAME = "full_name";
        public static final String NICK_NAME = "nick_name";
        public static final String ADDRESS = "address";
        public static final String PHONE = "phone";
        public static final String PHOTO = "photo";
        public static final String QUALIFICATION = "qualification";
        public static final String EXPERIENCE = "experience";
        public static final String EMAIL_ID = "email_id";
        public static final String DOB = "dob";
        public static final String ANNIVERSARY = "anniversary";
        public static final String FACEBOOK = "facebook";
        public static final String LINKED_IN = "linked_in";
        public static final String CURRENT_LOC = "current_loc";

    }
}
