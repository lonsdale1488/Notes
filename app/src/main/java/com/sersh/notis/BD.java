package com.sersh.notis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BD  {
    final String LOG_TAG = "myLogs";
    private static final String DB_NAME = "mydb";
    private static final int DB_VERSION = 1;
    private final Context mCtx;
    private SQLiteDatabase DB;
    private DBHelper DBHelper;

    public BD(Context ctx) {
        mCtx = ctx;
    }


        DBHelper = new

    DBHelper(mCtx, DB_NAME,null,DB_VERSION) {

    }

    DB = DBHelper.getWritableDatabase();
    }
    public void addBD (String nameBD,Integer timeBD,Integer expirationTimeBD  )
    {    // создаем объект для данных
        ContentValues cv = new ContentValues();
        // подключаемся к БД
        DB = DBHelper.getWritableDatabase();
        cv.put("name", nameBD);
        cv.put("time", timeBD);
        cv.put("expirationTime", expirationTimeBD);
        long rowID = DB.insert("mytable", null, cv);
        Log.d(LOG_TAG, "row inserted, ID = " + rowID);
        DBHelper.close();

        public void open() {
    }
//    public void viewBD ()
//    { DB = DBHelper.getWritableDatabase();
//        Log.d(LOG_TAG, "--- Rows in mytable: ---");
//        // делаем запрос всех данных из таблицы mytable, получаем Cursor
//        Cursor c = DB.query("mytable", null, null, null, null, null, null);
//        // ставим позицию курсора на первую строку выборки
//        // если в выборке нет строк, вернется false
//        if (c.moveToFirst()) {
//            // определяем номера столбцов по имени в выборке
//            int idColIndex = c.getColumnIndex("id");
//            int nameColIndex = c.getColumnIndex("name");
//            int timeColIndex = c.getColumnIndex("time");
//            int expirationTimeColIndex = c.getColumnIndex("expirationTime");
//            do {
//                // получаем значения по номерам столбцов и пишем все в лог
//                Log.d(LOG_TAG,
//                        "ID = " + c.getInt(idColIndex) +
//                                ", name = " + c.getString(nameColIndex) +
//                                ", time = " + c.getString(timeColIndex)+
//                                ", expirationTime = " + c.getString(expirationTimeColIndex)
//                )
//                ;
//                // переход на следующую строку
//                // а если следующей нет (текущая - последняя), то false - выходим из цикла
//            } while (c.moveToNext());
//        } else
//            Log.d(LOG_TAG, "0 rows");
//        c.close();
//        DBHelper.close();
//    }

    public Cursor getAllData() {
        return DB.query("mytable", null, null, null, null, null, null);
    }


    public void RemoveBD()
    {SQLiteDatabase DB = DBHelper.getWritableDatabase();
        DB.delete("mytable", null, null);
    }








    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }
//        }
//            super(context, "myDВВ", null, 1);

        public void onCreate(SQLiteDatabase db) {
            // создаем таблицу с полями
            db.execSQL("create table mytable ("
                    + " _id integer primary key autoincrement,"
                    + "name text,"
                    + "time integer,"
                    + "expirationTime integer" + ");");
            ContentValues cv = new ContentValues();
            for (int i = 1; i < 5; i++) {
                cv.put("id", "0");
                cv.put("name", "sometext ");
                cv.put("time", "sometext ");
                cv.put("expirationTime", "sometext ");
            }
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}
