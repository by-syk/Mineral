package com.example.y1247.mineral.datas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.y1247.mineral.R;

/**
 * Created by y1247 on 2017/4/2.
 */

public class MineralDbHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "MINERAL.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String INTEGER_TYPE = " INTEGER";

    private static final String BOOLEAN_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MineralPersistenceContract.MineralEntry.TABLE_NAME + " (" +
                    MineralPersistenceContract.MineralEntry._ID + TEXT_TYPE + " PRIMARY KEY," +
                    MineralPersistenceContract.MineralEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    MineralPersistenceContract.MineralEntry.COLUMN_NAME_NAME+ TEXT_TYPE + COMMA_SEP +
                    MineralPersistenceContract.MineralEntry.COLUMN_NAME_IMGID+ INTEGER_TYPE + COMMA_SEP +
                    MineralPersistenceContract.MineralEntry.COLUMN_NAME_TYPENUM + INTEGER_TYPE + COMMA_SEP +
                    MineralPersistenceContract.MineralEntry.COLUMN_NAME_VIDEOTYPE + INTEGER_TYPE + COMMA_SEP +
                    MineralPersistenceContract.MineralEntry.COLUMN_NAME_VIDEOWAY + TEXT_TYPE +
                    " )";

    private static final String INSTERT =
            "Insert into   " + MineralPersistenceContract.MineralEntry.TABLE_NAME +
                    " VALUES (1,'id','nameaaaaaaaaaaaaa', " + String.valueOf(R.drawable.fangjieshi) +
                    ",121,1,'asdfeaf')";
    private static final String INSTERT2 =
            "Insert into  " + MineralPersistenceContract.MineralEntry.TABLE_NAME +
                    " VALUES (2,'id','name', " + String.valueOf(R.drawable.fangjieshi) +
                    ",122,1,'asdfeaf')";
    private static final String INSTERT3 =
            "Insert into " + MineralPersistenceContract.MineralEntry.TABLE_NAME +
                    " VALUES (3,'id','name', " + String.valueOf(R.drawable.fangjieshi) +
                    ",123,1,'asdfeaf')";
    private static final String INSTERT4 =
            "Insert into  " + MineralPersistenceContract.MineralEntry.TABLE_NAME +
                    " VALUES (4,'id','name', " + String.valueOf(R.drawable.fangjieshi) +
                    ",113,1,'asdfeaf')";

    public MineralDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("AAA", "onCreate: " + INSTERT);
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(INSTERT);
        db.execSQL(INSTERT2);
        db.execSQL(INSTERT4);
        db.execSQL(INSTERT3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
