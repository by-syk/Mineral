package com.example.y1247.mineral.mineral;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.y1247.mineral.R;
import com.example.y1247.mineral.datas.MineralsRepository;
import com.example.y1247.mineral.untils.ActivityUtils;

public class MineralActivity extends AppCompatActivity {

    public static final String EXTRA_MINERAL_FLAG = "MINERAL_ID";
    public static final String EXTRA_MINERAL_PORN = "MINERAL_NAME";
    public static final String EXTRA_MINERAL_TITLE = "MINERAL_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mineral);

        int flag = getIntent().getIntExtra(EXTRA_MINERAL_FLAG,0);
        int PORN = getIntent().getIntExtra(EXTRA_MINERAL_PORN,0);
        String mineralName = getIntent().getStringExtra(EXTRA_MINERAL_TITLE);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle(mineralName);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);


        MineralFragment mineralFragment = MineralFragment.newInstance();

        new MineralPresenter(flag,PORN,mineralFragment,MineralsRepository.getInstance(this));

        ActivityUtils.addFragmentToActivity(
                getFragmentManager(),
                mineralFragment,
                R.id.mineral_content);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}
