package com.example.y1247.mineral.video;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.example.y1247.mineral.R;

/**
 * Created by y1247 on 2017/4/4.
 */

public class VideoFragment extends Fragment implements VideoContract.View {

    VideoContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.video_frag,container,false);
        VideoView vv = (VideoView)root.findViewById(R.id.vv_Mineral);
        String uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.bxa;
        vv.setVideoURI(Uri.parse(uri));
        vv.start();
        return root;
    }

    public VideoFragment(){

    }

    public static VideoFragment newInstance(){
        return new VideoFragment();
    }


    @Override
    public void setPresenter(VideoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showVideo(String uri) {

    }
}
