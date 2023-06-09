package com.example.mycontactlist;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


    public class ContactDBHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "mycontacts.db";
        private static final int DATABASE_VERSION = 2;

        private static final String CREATE_TABLE_CONTACT =
                "create table contact(_id integer primary key autoincrement, "
                + "contactname text not null, " + "address text, number text, "
                + "city text, state text, zipcode text, "
                + "cellnumber text, "
                + "email text, birthday text, contactphoto blob);";
        public ContactDBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //Log.w(ContactDBHelper.class.getName(),
          //      "Upgrading database from version " + oldVersion + " to "
            //            + newVersion + ", which will destroy all old data");
            //db.execSQL("DROP TABLE IF EXISTS contact");
            //onCreate(db);
        try {
            db.execSQL("ALTER TABLE contact ADD COLUMN contactphoto blob");
        }
        catch (Exception e){
            //kekw
        }
    }
}