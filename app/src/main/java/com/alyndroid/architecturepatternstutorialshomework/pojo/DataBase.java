package com.alyndroid.architecturepatternstutorialshomework.pojo;

import com.alyndroid.architecturepatternstutorialshomework.UI.getDiv;

public class DataBase {
    getDiv getDiv ;

    public DataBase(com.alyndroid.architecturepatternstutorialshomework.UI.getDiv getDiv) {
        this.getDiv = getDiv;
    }

    public DataBase() {
    }

    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }

    public void getDiv()
    {
        int first =getNumbers().getFirstNum();
        int second =getNumbers().getSecondNum() ;
        int div= first/ second ;
        getDiv.ongetDiv(div);
    }

}
