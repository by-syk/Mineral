package com.example.y1247.mineral.video;

import com.example.y1247.mineral.BasePresenter;
import com.example.y1247.mineral.BaseView;
import com.example.y1247.mineral.datas.Mineral;
import com.example.y1247.mineral.datas.MineralVideo;
import com.example.y1247.mineral.mineral.MineralContract;

import java.util.List;

/**
 * Created by y1247 on 2017/4/4.
 */

public class VideoContract {
    interface Presenter extends BasePresenter {

    }
    interface View extends BaseView<Presenter> {
        void showVideo(String uri);
    }
}
