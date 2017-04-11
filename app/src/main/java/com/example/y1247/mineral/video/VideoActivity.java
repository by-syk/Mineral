package com.example.y1247.mineral.video;

import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.y1247.mineral.R;
import com.example.y1247.mineral.datas.Mineral;
import com.example.y1247.mineral.untils.ActivityUtils;

public class VideoActivity extends AppCompatActivity {

    public static final String EXTRA_MINERAL = "MINERAL";

    VideoPresenter presenter;

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Mineral mineral = getIntent().getParcelableExtra(EXTRA_MINERAL);

        mineral.setType(Mineral.VIDEO);

        ActionBar actionBar = getSupportActionBar();

        if(mineral.getType() == Mineral.VIDEO){
            fragment = VideoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getFragmentManager(),fragment,R.id.fl_videoFrag
            );
        }else {
            fragment = HtmlFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getFragmentManager(),fragment,R.id.fl_videoFrag
            );
        }

        actionBar.setTitle(mineral.getName());

        new VideoPresenter(mineral, (VideoContract.View) fragment);
    }
}
