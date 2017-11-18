package com.sw.baseball.baseball;

import android.widget.TextView;

/**
 * Created by jungseokwon on 2017. 11. 17..
 */

public interface IMainActivity {

    String getInputText();

    void printResult(int mainResultOk, String resultText);

    void layoutAddView(TextView v);

    void setInit();
}
