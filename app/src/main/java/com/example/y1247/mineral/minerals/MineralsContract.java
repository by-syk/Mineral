package com.example.y1247.mineral.minerals;

import android.database.Cursor;

import com.example.y1247.mineral.BasePresenter;
import com.example.y1247.mineral.BaseView;
import com.example.y1247.mineral.datas.Mineral;

import java.util.List;

/**
 * Created by y1247 on 2017/3/25.
 */

public class MineralsContract {
    public interface Presenter extends BasePresenter{
        void setData(MineralsType type);

        void openMineralsDetal(int flag);


    }
    public interface View extends BaseView<Presenter>{

        void changeData(List<Mineral> ls);

        void openMineralsUi(int flag);
    }
}
