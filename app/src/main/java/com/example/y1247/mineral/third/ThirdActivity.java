package com.example.y1247.mineral.third;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.y1247.mineral.R;
import com.example.y1247.mineral.datas.Word;
import com.example.y1247.mineral.mineral.MineralActivity;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    int flag1;
    int flag2;

    private static String ONEONE = "11";
    private static String ONE2 = "12";
    private static String TWOONE = "21";
    private static String TWO2 = "22";

    private static String CHECKONEONE = "111";
    private static String CHECKONE2 = "112";
    private static String CHECKTWOONE = "121";
    private static String CHECKTWO2 = "122";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);

        flag1 = getIntent().getIntExtra(MineralActivity.EXTRA_MINERAL_FLAG,1);
        flag2 = getIntent().getIntExtra(MineralActivity.EXTRA_MINERAL_PORN,1);


        TextView tv_1 = (TextView) findViewById(R.id.tv_third_intro);
        TextView tv_2 = (TextView) findViewById(R.id.tv_check_way);
        TextView tv_3 = (TextView) findViewById(R.id.tv_list);

        tv_1.setOnClickListener(this);
        tv_2.setOnClickListener(this);
        tv_3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.tv_third_intro:
                intent = new Intent(this, TextActivity.class);
                intent.putExtra(TextActivity.EXTRA_TITLE,"简介");
                intent.putExtra(TextActivity.EXTRA_CONTENT,getCurrentIntro());
                break;
            case R.id.tv_check_way:
                intent = new Intent(this, TextActivity.class);
                intent.putExtra(TextActivity.EXTRA_TITLE,"鉴定方法");
                intent.putExtra(TextActivity.EXTRA_CONTENT,getCurrentCheck());

                break;
            case R.id.tv_list:
                intent = new Intent(this, MineralActivity.class);
                intent.putExtra(MineralActivity.EXTRA_MINERAL_FLAG,flag1);
                intent.putExtra(MineralActivity.EXTRA_MINERAL_PORN,flag2);
                break;
        }
        startActivity(intent);
    }

    String getCurrentIntro(){
        int x = flag1*10 + flag2;
        switch (x){
            case 11:
                return Word.oneRight;
            case 12:
                return Word.oneBack;
            case 21:
                return Word.twoFront;
            case 22:
                return Word.twoBack;
        }
        return null;
    }

    String getCurrentCheck(){
        int x = flag1*10 + flag2;
        switch (x){
            case 11:
                return Word.oneightCheck;
            case 12:
                return Word.oneBackCheck;
            case 21:
                return Word.twoFrontCheck;
            case 22:
                return Word.twoBackCheck;
        }
        return null;
    }
}
