package com.sersh.notis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class LIST extends Fragment {
    View inflaterView;
    ListView lvData;
    BD db;
    SimpleCursorAdapter scAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflaterView = inflater.inflate(R.layout.fragment_list, container, false);

//        // формируем столбцы сопоставления
//        // String[] from = new String[] { DB.COLUMN_IMG, DB.COLUMN_TXT };
//        String[] from = new String[] {"name","time","expirationTime"};
//        int[] to = new int[] {  R.id.tvText1, R.id.tvText2, R.id.tvText3 };
//
//        // создаем адаптер и настраиваем список
//        scAdapter = new SimpleCursorAdapter(this, R.layout.item, null, from, to, 0);
//        lvData = (ListView) inflaterView.findViewById(R.id.lvData);
//        lvData.setAdapter(scAdapter);
//        // создаем лоадер для чтения данных
//        getSupportLoaderManager().initLoader(0, null, this);



        return inflaterView;
    }



//    @Override
//    public Loader<Cursor> onCreateLoader(int id, Bundle bndl) {
//        return new MyCursorLoader(this, db);
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
//        scAdapter.swapCursor(cursor);
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> loader) {
//    }
//
//    static class MyCursorLoader extends CursorLoader {
//
//        BD db;
//
//        public MyCursorLoader(Context context, BD db) {
//            super(context);
//            this.db = db;
//        }
//
//        @Override
//        public Cursor loadInBackground() {
//            Cursor cursor = db.getAllData();
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return cursor;
//        }



}
