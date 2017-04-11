package com.example.y1247.mineral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class HtmlActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

        webView = (WebView) findViewById(R.id.wv_Html_Test);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/Html_1/test2.html");

    }
}
