package com.example.junqi.cool.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

 /**
 * Created by user on 2016/8/30.
 */
public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
               String sql="create table student(id integer primary key autoincrement," +
                       "num integer(5),"+"name varchar(3))";
              sqLiteDatabase.execSQL(sql);
              String sql1="create table menu(json integer(5),"+"date varchar(100)," +
                "page integer(10) primary key)";
        sqLiteDatabase.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql1="create table menu(json integer(5),"+"date varchar(3)," +
                "page integer(2)primary key)";
         sqLiteDatabase.execSQL(sql1);
    }
}
