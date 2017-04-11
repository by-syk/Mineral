package com.example.y1247.mineral.second;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.y1247.mineral.R;
import com.example.y1247.mineral.datas.Word;
import com.example.y1247.mineral.mineral.MineralActivity;
import com.example.y1247.mineral.third.ThirdActivity;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String FLAG = "FLAG";

    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        TextView textView = (TextView) findViewById(R.id.tv_intro);
        Button bt_1 = (Button) findViewById(R.id.bt_right);
        Button bt_2 = (Button) findViewById(R.id.bt_back);

        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);

        this.flag = getIntent().getIntExtra(FLAG,1);

        if(flag == 1)
            textView.setText(Html.fromHtml(Word.oneIntroduce));
        else  textView.setText(Html.fromHtml(Word.twoIntroduce));

    }

    @Override
    public void onClick(View v) {
        int flag2 = 1;
        switch (v.getId()){
            case R.id.bt_right:
                flag2 = 1;
                break;
            case R.id.bt_back:
                flag2 = 2;
                break;
        }

        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra(MineralActivity.EXTRA_MINERAL_FLAG,flag);
        intent.putExtra(MineralActivity.EXTRA_MINERAL_PORN,flag2);
        startActivity(intent);

    }
}
