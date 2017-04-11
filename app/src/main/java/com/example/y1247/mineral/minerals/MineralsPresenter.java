package com.example.y1247.mineral.minerals;

import com.example.y1247.mineral.datas.Mineral;
import com.example.y1247.mineral.datas.MineralsRepository;

import java.util.List;

/**
 * Created by y1247 on 2017/3/25.
 */

public class MineralsPresenter implements MineralsContract.Presenter {

    private MineralsContract.View mineralsView;

    private MineralsRepository repository;

    public MineralsPresenter(MineralsContract.View mineralsView, MineralsRepository repository) {
        this.mineralsView = mineralsView;
        this.repository = repository;
        mineralsView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void setData(MineralsType type) {
        List<Mineral> ls = repository.getAllMineralsByType(type);
        mineralsView.changeData(ls);
    }

    @Override
    public void openMineralsDetal(int flag) {
        mineralsView.openMineralsUi(flag);
    }
}
