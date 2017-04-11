package com.example.y1247.mineral.video;

import com.example.y1247.mineral.datas.Mineral;

/**
 * Created by y1247 on 2017/4/4.
 */

public class VideoPresenter implements VideoContract.Presenter {
    private Mineral mineral;

    private final VideoContract.View videoView;

    public VideoPresenter(Mineral mineral, VideoContract.View videoView) {
        this.mineral = mineral;
        this.videoView = videoView;

        videoView.setPresenter(this);
    }

    @Override
    public void start() {
        videoView.showVideo(mineral.getVideo_storage());
    }
}
