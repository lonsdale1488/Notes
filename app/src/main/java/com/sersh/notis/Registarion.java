package com.sersh.notis;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.concurrent.TimeUnit;

public class Registarion extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    static String nameST;
    static Integer timeST, expirationTimeST;

    BD db;
    ListView lvData;
    SimpleCursorAdapter scAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.registarion);
        showADD();
        db = new BD(this);
        db.open();


        // формируем столбцы сопоставления

        String[] from = new String[] {"name","time","expirationTime"};
        int[] to = new int[] { R.id.tvText1, R.id.tvText2, R.id.tvText3 };

        // создаем адаптер и настраиваем список
        scAdapter = new SimpleCursorAdapter(this, R.layout.item, null, from, to, 0);
        lvData = (ListView) findViewById(R.id.lvData);
        lvData.setAdapter(scAdapter);
        // создаем лоадер для чтения данных
        getSupportLoaderManager().initLoader(0, null, this);

    }

    public void WachFragmet(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().
                replace(R.id.fragment_cont, fragment).
                addToBackStack(null).
                commit();
    }

    public void showADD()
    {

        WachFragmet(new AddRemuvView());
    }

    public void showFormd()
    {
        WachFragmet(new Forms());
    }





    public void addBD()
    {
        db.addBD(nameST, timeST, expirationTimeST);

        // создаем объект для данных
//        ContentValues cv = new ContentValues();
//        // подключаемся к БД
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        cv.put("name", nameST);
//        cv.put("time", timeST);
//        cv.put("expirationTime", expirationTimeST);
//        long rowID = db.insert("mytable", null, cv);
//        Log.d(LOG_TAG, "row inserted, ID = " + rowID);
//        dbHelper.close();
    }
    public void viewW ()
  {


  //    db.viewBD();
// SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//
//        Log.d(LOG_TAG, "--- Rows in mytable: ---");
//        // делаем запрос всех данных из таблицы mytable, получаем Cursor
//        Cursor c = db.query("mytable", null, null, null, null, null, null);
//
//        // ставим позицию курсора на первую строку выборки
//        // если в выборке нет строк, вернется false
//        if (c.moveToFirst()) {
//
//            // определяем номера столбцов по имени в выборке
//            int idColIndex = c.getColumnIndex("id");
//            int nameColIndex = c.getColumnIndex("name");
//            int timeColIndex = c.getColumnIndex("time");
//            int expirationTimeColIndex = c.getColumnIndex("expirationTime");
//
//
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
//        dbHelper.close();
        showADD();
    }
public void Remove()
{  db.RemoveBD();
//    SQLiteDatabase db = dbHelper.getWritableDatabase();
//    db.delete("mytable", null, null);
}

//    class DBHelper extends SQLiteOpenHelper {
//
//        public DBHelper(Context context) {
//            // конструктор суперкласса
//            super(context, "myDB", null, 1);
//        }
//
//        public void onCreate(SQLiteDatabase db) {
//            // создаем таблицу с полями
//            db.execSQL("create table mytable ("
//                    + "id integer primary key autoincrement,"
//                    + "name text,"
//                    + "time integer,"
//                    + "expirationTime integer" + ");");
//        }
//
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//        }
//    }




    //  adapter
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bndl) {
        return new MyCursorLoader(this, db);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        scAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    static class MyCursorLoader extends CursorLoader {

        BD db;

        public MyCursorLoader(Context context, BD db) {
            super(context);
            this.db = db;
        }

        @Override
        public Cursor loadInBackground() {
            Cursor cursor = db.getAllData();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return cursor;
        }

    }




}
