package com.example.y1247.mineral.third;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.y1247.mineral.R;

public class TextActivity extends AppCompatActivity {

    public final static String EXTRA_TITLE = "title";
    public final static String EXTRA_CONTENT = "content";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        String content = getIntent().getStringExtra(EXTRA_CONTENT);

        getSupportActionBar().setTitle(title);

        TextView textView = (TextView) findViewById(R.id.tv_content);
        textView.setText(Html.fromHtml(content));
    }
}
