package com.alyndroid.architecturepatternstutorialshomework.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , getDiv {
    Button mPlus_btn, mMul_btn, mDiv_btn;
    TextView  mTPlus, mTMul, mTDiv;
    int sum ;
   DataBase dataBase ;
   MulViewModel mulViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniView();
        //mvc
        getDataSum();
        mvvm();
        mvp();

    }

    private void mvp()
    {
        //mvp
        dataBase=new DataBase(this);

    }

    private void mvvm()
    {
        //mvvm
        mulViewModel= ViewModelProviders.of(this ).get(MulViewModel.class);
        mulViewModel.mutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTMul.setText(String.valueOf(integer));
            }
        });

    }

    private void iniView() {
        mPlus_btn = findViewById(R.id.plus_button);
        mPlus_btn.setOnClickListener(this);
        mMul_btn = findViewById(R.id.mul_button);
        mMul_btn.setOnClickListener(this);
        mDiv_btn = findViewById(R.id.div_button);
        mDiv_btn.setOnClickListener(this);
        mTPlus=findViewById(R.id.plus_result_textView);
        mTMul=findViewById(R.id.mul_result_textView);
        mTDiv=findViewById(R.id.div_result_textView);








    }



  //  start mvc
    private void getDataSum()
    {
        DataBase dataBase = new DataBase(this);
        int FirstNum = dataBase.getNumbers().getFirstNum();
        int SecondNum = dataBase.getNumbers().getSecondNum();
        sum = FirstNum + SecondNum;
    }


        @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus_button:
                mTPlus.setText(String.valueOf(sum));
                break;

            case R.id.div_button:
                        dataBase.getDiv();
                break;
            case R.id.mul_button:
                mulViewModel.getMul();
                break;


        }
    }


    @Override
    public void ongetDiv(int sum) {
        mTDiv.setText(String.valueOf(sum));
    }
}
