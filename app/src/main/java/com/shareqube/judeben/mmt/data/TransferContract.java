package com.shareqube.judeben.mmt.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.BaseColumns;


public class TransferContract {


    public static final String CONTENT_AUTHORITY = "com.shareqube.moviesapp.data" ;

    public  static  final Uri  BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY) ;


    // path

    public static final String ALL_USERS_PATH = "users" ;
    public static final String ACCOUNT_PATH = "account" ;
    public static final String TRANSACTION_PATH = "transaction";

    public static final class Users implements BaseColumns{

        public static final  Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(ALL_USERS_PATH).build() ;

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + ALL_USERS_PATH ;

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY  + "/" + ALL_USERS_PATH ;

        public static final String TABLE_NAME = "users";


        // table column name
        public static final String COLUMN_USER_ID = "user_id" ;
        public static final String COLUMN_USERNAME = " username" ;
        public static  final String COLUMN_FIRSTNAME = "firstname" ;
        public static final String COLUMN_LASTNAME= "lastname" ;
        public static final String COLUMN_EMAIL =  "email" ;
        public static final String COLUMN_PHONENUMBER = "phone_number" ;
        public static final String COLUMN_PASSWORD = "password" ;
        public static final String COLUMN_ACC_ACTIVE = "account_active" ;

        public static final Uri getAllUsersUri(long id){

            return ContentUris.withAppendedId(CONTENT_URI , id) ;
        }

        public static Integer getIDFromUri(Uri uri) {
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

    }

    public static final class Accounts implements  BaseColumns{


        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(ACCOUNT_PATH).build() ;

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + ACCOUNT_PATH ;

        public  static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + ACCOUNT_PATH ;

        public static final String TABLE_NAME = "account" ;


        // fovorite movies column name
        public static final String COLUMN_ID = "account_id" ;
        public static final String COLUMN_USER_ID = " user_id" ;
        public static  final String COLUMN_ACCOUNT_NAME = "account_name" ;
        public static final String COLUMN_ACCOUNT_TYPE= "account_type" ;
        public static final String COLUMN_STATUS =  "account_status" ;
        public static final String COLUMN_ACCOUNT_NUMBER = "account_number" ;
        public static final String COLUMN_BANK_NAME = "bank_name" ;




        public static final Uri getAccountUri(Long id){

            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


    }

    public static final class Transaction implements  BaseColumns{


        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TRANSACTION_PATH).build() ;

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TRANSACTION_PATH ;

        public  static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TRANSACTION_PATH ;

        public static final String TABLE_NAME = "transaction" ;


        // fovorite movies column name
        public static final String COLUMN_ID = "tran_id" ;
        public static final String COLUMN_ACCOUNT_ID = " account_id" ;
        public static  final String COLUMN_USER_ID = "user_id" ;
        public static final String COLUMN_AMOUNT= "amount" ;
        public static final String COLUMN_FEE =  "process_fee" ;
        public static final String COLUMN_DATE = "date" ;
        public static final String COLUMN_TRANS_STATUS = "status" ;




        public static final Uri getAccountUri(Long id){

            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


    }
}
