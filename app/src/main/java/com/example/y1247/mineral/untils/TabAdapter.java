package com.example.y1247.mineral.untils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by y1247 on 2017/3/30.
 */

public class TabAdapter extends FragmentPagerAdapter {

    private List<Fragment> list_fragment;                         //fragment列表


    public TabAdapter(FragmentManager fm, List<Fragment> list_fragment) {
        super(fm);
        this.list_fragment = list_fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "正";
            case 1:
                return "负";
        }
        return super.getPageTitle(position);
    }
}
