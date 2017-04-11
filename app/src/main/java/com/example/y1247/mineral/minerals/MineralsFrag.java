package com.example.y1247.mineral.minerals;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.y1247.mineral.R;
import com.example.y1247.mineral.datas.Mineral;
import com.example.y1247.mineral.mineral.MineralActivity;
import com.example.y1247.mineral.second.SecondActivity;
import com.example.y1247.mineral.untils.DividerItemDecoration;
import com.example.y1247.mineral.untils.TabAdapter;

import java.util.List;

/**
 * Created by y1247 on 2017/3/25.
 */

public class MineralsFrag extends Fragment implements MineralsContract.View,View.OnClickListener{

    MineralsContract.Presenter presenter;

    LinearLayout ll_Pcharacter;
    LinearLayout ll_Ncharacter;


    public MineralsFrag(){

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mineral_frag,container,false);

        presenter.setData(MineralsType.UNIAXIAL);

        ll_Pcharacter = (LinearLayout) root.findViewById(R.id.ll_one);
        ll_Ncharacter = (LinearLayout) root.findViewById(R.id.ll_two);

//        ll_Ncharacter.setBackgroundResource(R.drawable.back2);
//        ll_Pcharacter.setBackgroundResource(R.drawable.back1);

        ll_Ncharacter.setOnClickListener(this);
        ll_Pcharacter.setOnClickListener(this);
        return root;

    }



    public static MineralsFrag newInstance(){
        return new MineralsFrag();
    }


    @Override
    public void setPresenter(MineralsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void changeData(List<Mineral> ls) {

    }

    @Override
    public void openMineralsUi(int flag) {
        Intent intent = new Intent(getActivity(), SecondActivity.class);
        intent.putExtra(SecondActivity.FLAG,flag);
        Log.i("DSF", "openMineralsUi: " + flag);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_one:
                presenter.openMineralsDetal(1);
                break;
            case R.id.ll_two:
                presenter.openMineralsDetal(2);
                break;
        }
    }



}
