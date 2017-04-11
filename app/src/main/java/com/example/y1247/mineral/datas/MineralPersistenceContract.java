package com.example.y1247.mineral.datas;

import android.provider.BaseColumns;

/**
 * Created by y1247 on 2017/4/2.
 */

public final class MineralPersistenceContract {

    private MineralPersistenceContract(){
    }

    public static abstract class MineralEntry implements BaseColumns{
        public static final String TABLE_NAME = "mineral";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_IMGID = "imgid";
        public static final String COLUMN_NAME_TYPENUM = "typenum";
        public static final String COLUMN_NAME_VIDEOWAY = "videoway";
        public static final String COLUMN_NAME_VIDEOTYPE = "videotype";
    }
}
