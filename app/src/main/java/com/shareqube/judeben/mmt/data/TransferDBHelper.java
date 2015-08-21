package com.shareqube.judeben.mmt.data;

import android.database.sqlite.SQLiteDatabase;
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

import com.shareqube.judeben.mmt.data.TransferContract.Accounts;
import com.shareqube.judeben.mmt.data.TransferContract.Users ;
import com.shareqube.judeben.mmt.data.TransferContract.Transaction ;




public class TransferDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "moneytransfer.db" ;


    public  TransferDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        final String SQL_CREATE_ACCOUNT = " CREATE TABLE "  + Accounts.TABLE_NAME + " ( " +
                TransferContract.Accounts._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                Accounts.COLUMN_ID + " TEXT NOT NULL , " +
                Accounts.COLUMN_USER_ID  + " TEXT NOT NULL , "+
                Accounts.COLUMN_ACCOUNT_NAME + " TEXT NOT NULL ,"  +
                Accounts.COLUMN_ACCOUNT_TYPE + " TEXT NOT NULL , " +
                Accounts.COLUMN_STATUS  + " TEXT NOT NULL ," +
                Accounts.COLUMN_ACCOUNT_NUMBER + " REAL NOT NULL ," +
               Accounts.COLUMN_BANK_NAME + " TEXT ," +

                " ) ;" ;




        final String SQL_CREATE_TRANSACTION = " CREATE TABLE " + Transaction.TABLE_NAME + " ( " +
                Transaction._ID + " INTEGER PRIMARY KEY  AUTOINCREMENT , " +
                Transaction.COLUMN_ACCOUNT_ID   + " TEXT NOT NULL , " +
                Transaction.COLUMN_ID  + " TEXT NOT NULL , "+
                Transaction.COLUMN_USER_ID + " TEXT NOT NULL ,"  +
                Transaction.COLUMN_AMOUNT + " TEXT NOT NULL , " +
                Transaction.COLUMN_FEE  + " TEXT NOT NULL ," +
               Transaction.COLUMN_DATE + " REAL NOT NULL ," +
                Transaction.COLUMN_TRANS_STATUS+ " TEXT ," +

                " ) ;" ;


        final String SQL_CREATE_USERS = " CREATE TABLE " + Users.TABLE_NAME + " ( " +
                Users._ID + " INTEGER PRIMARY KEY  AUTOINCREMENT , " +
                Users.COLUMN_FIRSTNAME   + " TEXT NOT NULL , " +
                Users.COLUMN_LASTNAME  + " TEXT NOT NULL , "+
                Users.COLUMN_EMAIL + " TEXT NOT NULL ,"  +
                Users.COLUMN_PASSWORD + " TEXT NOT NULL , " +
                Users.COLUMN_USER_ID  + " TEXT NOT NULL ," +
                Users.COLUMN_PHONENUMBER + " REAL NOT NULL ," +
                Users.COLUMN_USERNAME+ " TEXT ," +
                Users.COLUMN_ACC_ACTIVE +  " TEXT " +
                " ) ;" ;

        db.execSQL(SQL_CREATE_ACCOUNT);
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_TRANSACTION);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Accounts.TABLE_NAME);

        db.execSQL("DROP TABLE IF EXISTS " + Users.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Transaction.TABLE_NAME);

        onCreate(db);
    }


}
