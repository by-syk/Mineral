package com.example.y1247.mineral.video;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.y1247.mineral.R;

/**
 * Created by y1247 on 2017/4/4.
 */

public class HtmlFragment extends Fragment implements VideoContract.View {

    private static HtmlFragment INSTANCE;

    private static WebView wv_Html;

    private VideoContract.Presenter presenter;

    public HtmlFragment(){

    }

    public static HtmlFragment newInstance(){
        return new HtmlFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.html_frag,container,false);
        wv_Html = (WebView) root.findViewById(R.id.wv_html);

        wv_Html.getSettings().setJavaScriptEnabled(true);
        wv_Html.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

//        wv_Html.loadUrl("file:///android_asset/Html_1/test2.html");
        presenter.start();

        return root;
    }

    @Override
    public void setPresenter(VideoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showVideo(String uri) {
        wv_Html.getSettings().setJavaScriptEnabled(true);
        wv_Html.loadUrl("file:///android_asset/Html_1/test2.html");
    }
}
