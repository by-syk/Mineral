package com.example.y1247.mineral.mineral;

import com.example.y1247.mineral.BasePresenter;
import com.example.y1247.mineral.BaseView;
import com.example.y1247.mineral.datas.Mineral;
import com.example.y1247.mineral.datas.MineralVideo;

import java.util.List;

/**
 * Created by y1247 on 2017/3/26.
 */

public class MineralContract {
    interface Presenter extends BasePresenter{
        void openVideoDetil(Mineral video);

        void getVideoList();

        void changeFilter(int flag);
    }
    interface View extends BaseView<Presenter>{

        void showVideoList(List<Mineral> ls);

        void openVideoUi(Mineral video);
    }

}
