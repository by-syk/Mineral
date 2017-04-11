package com.example.y1247.mineral.minerals;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.y1247.mineral.untils.ActivityUtils;
import com.example.y1247.mineral.R;
import com.example.y1247.mineral.datas.MineralsRepository;

public class MineralsAct extends AppCompatActivity {

    private TextView mTextMessage;

    private MineralsFrag fragment;

    private MineralsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fragment = (MineralsFrag) getFragmentManager().findFragmentById(R.id.content);
        if(fragment==null){
            fragment = new MineralsFrag().newInstance();
            ActivityUtils.addFragmentToActivity(
                    getFragmentManager(),fragment,R.id.content
            );
        }

        MineralsRepository repository = MineralsRepository.getInstance(this);
        presenter = new MineralsPresenter(fragment,repository);
    }


}
