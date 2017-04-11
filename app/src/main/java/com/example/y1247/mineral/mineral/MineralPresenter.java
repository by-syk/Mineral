package com.example.y1247.mineral.mineral;

import com.example.y1247.mineral.datas.Mineral;
import com.example.y1247.mineral.datas.MineralVideo;
import com.example.y1247.mineral.datas.MineralsRepository;

import java.util.List;

/**
 * Created by y1247 on 2017/3/26.
 */

public class MineralPresenter implements MineralContract.Presenter {
    List<Mineral> ls;
    private MineralContract.View view;
    private MineralsRepository repository;
    int flag1;
    int flag2;

    public MineralPresenter(int flag1,int flag2, MineralContract.View view, MineralsRepository repository) {
        ls = repository.getMinerals(flag1,flag2,0);
        this.view = view;
        this.repository = repository;
        this.flag1 = flag1;
        this.flag2 = flag2;
        view.setPresenter(this);
    }

    @Override
    public void start() {
//        loadMineral();
        view.showVideoList(ls);
    }

    @Override
    public void openVideoDetil(Mineral video) {
        view.openVideoUi(video);
    }

    @Override
    public void getVideoList() {
        view.showVideoList(ls);
    }

    @Override
    public void changeFilter(int flag) {
        view.showVideoList( repository.getMinerals(flag1,flag2,flag));
    }

    void loadMineral(){


    }
}
