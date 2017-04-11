package com.example.y1247.mineral.mineral;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.y1247.mineral.R;
import com.example.y1247.mineral.datas.Mineral;
import com.example.y1247.mineral.datas.MineralVideo;
import com.example.y1247.mineral.untils.DividerItemDecoration;
import com.example.y1247.mineral.video.VideoActivity;

import java.util.List;

/**
 * Created by y1247 on 2017/3/26.
 */

public class MineralFragment extends Fragment implements MineralContract.View {

    private MineralContract.Presenter mPresenter;
    private RecyclerView recyclerView;
    private MineralAdapter adapter;


    public MineralFragment(){

    }

    public static MineralFragment newInstance(){
        return new MineralFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mineralvideo_frag,container,false);

        recyclerView = (RecyclerView) root.findViewById(R.id.rv_Videos);

        adapter = new MineralAdapter(getActivity());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST)
        );


        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.filter_menu,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public void setPresenter(MineralContract.Presenter presenter) {
        this.mPresenter = presenter;
    }


    @Override
    public void showVideoList(List<Mineral> ls) {
        adapter.setList(ls);
    }

    @Override
    public void openVideoUi(Mineral video) {
        Intent intent = new Intent(getActivity(), VideoActivity.class);
        intent.putExtra(VideoActivity.EXTRA_MINERAL,video);
        getActivity().startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.filter1:
                mPresenter.changeFilter(1);
                break;
            case R.id.filter2:
                mPresenter.changeFilter(2);
                break;
            case R.id.filter3:
                mPresenter.changeFilter(3);
                break;
        }
        return false;
    }

    class MineralAdapter extends RecyclerView.Adapter<MineralAdapter.MyHolder>{
        List<Mineral> ls;
        Context context;


        public MineralAdapter(Context context) {
            this.context = context;
        }

        public void setList(List<Mineral> ls){
            this.ls = ls;
            this.notifyDataSetChanged();
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, final int position) {
            holder.imageView.setBackgroundResource(ls.get(position).getPicUrl());
            holder.tv_name.setText(ls.get(position).getName());
            holder.ll_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.openVideoDetil(ls.get(position));
                }
            });

        }

        @Override
        public int getItemCount() {
            int size = 0;
            if(ls!=null)
                size = ls.size();
            return size;
        }

        class MyHolder extends RecyclerView.ViewHolder{

            LinearLayout ll_item;
            ImageView imageView;
            TextView tv_name;
            public MyHolder(View itemView) {
                super(itemView);
                ll_item = (LinearLayout) itemView.findViewById(R.id.ll_videos);
                tv_name = (TextView) itemView.findViewById(R.id.tv_name);
                imageView = (ImageView) itemView.findViewById(R.id.iv_Pic);
            }
        }
    }
}
