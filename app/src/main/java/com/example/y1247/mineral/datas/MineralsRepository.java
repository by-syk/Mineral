package com.example.y1247.mineral.datas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.y1247.mineral.minerals.MineralsType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by y1247 on 2017/3/25.
 */

public class MineralsRepository implements DataSource{

    private MineralDbHelper mineralDbHelper;

    private static MineralsRepository INSTANCE;

    private MineralsRepository(Context context) {
        mineralDbHelper = new MineralDbHelper(context);
    }

    public static MineralsRepository getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new MineralsRepository(context);
        }
        return INSTANCE;
    }

    public List<Mineral> getAllMineralsByType(MineralsType type){

        return null;
    }

    public Mineral getMineral(String id){
        return new Mineral("loadResult",id);
    }

    public List<MineralVideo> getVide(String id){
        MineralVideo video = new MineralVideo("loadResult",id,"url");
        List<MineralVideo> ls = new ArrayList<MineralVideo>();
        ls.add(video);
        ls.add(video);
        return ls;
    }

    public List<Mineral> getMinerals(int flag1,int flag2,int type){
        SQLiteDatabase db = mineralDbHelper.getReadableDatabase();

        int selectThings = getSelection(flag1,flag2,type);

        String[] projection = {
                MineralPersistenceContract.MineralEntry.COLUMN_NAME_NAME,
                MineralPersistenceContract.MineralEntry.COLUMN_NAME_VIDEOWAY,
                MineralPersistenceContract.MineralEntry.COLUMN_NAME_VIDEOTYPE,
                MineralPersistenceContract.MineralEntry.COLUMN_NAME_TYPENUM,
                MineralPersistenceContract.MineralEntry.COLUMN_NAME_IMGID
        };

        String selection_type0 = MineralPersistenceContract.MineralEntry.COLUMN_NAME_TYPENUM + " > ? and "
                + MineralPersistenceContract.MineralEntry.COLUMN_NAME_TYPENUM + " < ?";
        String selection_type = MineralPersistenceContract.MineralEntry.COLUMN_NAME_TYPENUM + " = ?;  ";

        int x = getSelection(flag1,flag2,type);

        Cursor c = null;

        if(type==0) {
            c = db.query(
                    MineralPersistenceContract.MineralEntry.TABLE_NAME,
                    projection,
                    selection_type0,
                    new String[]{String.valueOf(x),String.valueOf(x+10)}, null, null, null
//                null,null,null,null,null,null
            );
        }else{
            c = db.query(
                    MineralPersistenceContract.MineralEntry.TABLE_NAME,
                    projection,
                    selection_type,
                    new String[]{String.valueOf(x)}, null, null, null
//                null,null,null,null,null,null
            );
        }

//        Cursor c = db.rawQuery("select * from mineral where typenum = 111;",null);

        Log.i("DSF", "getMinerals111: "+ c.getCount());

        List<Mineral> ls = new ArrayList<>();

        if(c != null && c.getCount()>0){
            while (c.moveToNext()){
                String name = c.getString(c.getColumnIndexOrThrow(MineralPersistenceContract.MineralEntry.COLUMN_NAME_NAME));
                String itemId = c.getString(c.getColumnIndexOrThrow(MineralPersistenceContract.MineralEntry.COLUMN_NAME_TYPENUM));
                int picUrk = c.getInt(c.getColumnIndexOrThrow(MineralPersistenceContract.MineralEntry.COLUMN_NAME_IMGID));
                String video_storage = c.getString(c.getColumnIndexOrThrow(MineralPersistenceContract.MineralEntry.COLUMN_NAME_VIDEOWAY));
                int type_1 = c.getInt(c.getColumnIndexOrThrow(MineralPersistenceContract.MineralEntry.COLUMN_NAME_VIDEOTYPE));
                Mineral mineral = new Mineral(name,itemId,picUrk,video_storage,type_1);
                ls.add(mineral);
            }
        }
        if (c != null) {
            c.close();
        }
        db.close();
        Log.i("DSF", "getMinerals: " + String.valueOf(ls.size()));
        return ls;
    }

    private int getSelection(int flag1, int flag2,int type) {
        int id = flag1*100 + flag2*10 +type;
        Log.i("DSF", "getSelection: "+ id);
        return id;
    }
}
