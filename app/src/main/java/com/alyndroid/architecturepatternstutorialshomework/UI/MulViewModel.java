package com.alyndroid.architecturepatternstutorialshomework.UI;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

public class MulViewModel extends ViewModel {
    DataBase dataBase =new DataBase();
    MutableLiveData<Integer> mutableLiveData=new MutableLiveData<Integer>() ;

    public void getMul()
    {
        int first=dataBase.getNumbers().getFirstNum();
        int second=dataBase.getNumbers().getSecondNum();
        int mul =first * second ;
        mutableLiveData.setValue(mul);

    }
}
