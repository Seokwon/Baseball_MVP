package com.sw.baseball.baseball;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jungseokwon on 2017. 11. 17..
 */

public class MainPresenter {

    public static final int MAIN_RESULT_OK = 1;

    private IMainActivity mView;
    private Context mContext;

    private int baseball[];
    private int result[];

    private int countB = 0;
    private int countS = 0;
    private int res;

    public MainPresenter(IMainActivity mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;

        baseball = new int[3];
        result = new int[3];
    }


    public void result() {

        countB = 0;
        countS = 0;

        String input = mView.getInputText();

        res = Integer.parseInt(String.valueOf(input));


        for (int i = result.length - 1; i >= 0; i--) {

            if (i == 0) {
                result[i] = res;
                break;
            }

            result[i] = res % 10;
            res = res / 10;
        }


        for (int i = 0; i < baseball.length; i++) {

            for (int j = 0; j < result.length; j++) {
                if (baseball[i] == result[j]) {

                    if (i == j) {
                        countS++;
                    } else {
                        countB++;
                    }
                }
            }
        }

        mView.layoutAddView(list());

        Log.i("Result", "Result  : " + result[0] + " " + result[1] + " " + result[2] + "  테스트");

        String resultText;
        if (countS == 3) {
            resultText = countS + "S" + countB + "B" + "성공";
        } else {
            resultText = countS + "S" + countB + "B";
        }

        mView.printResult(MAIN_RESULT_OK, resultText);

    }

    private TextView list(){

        TextView v = new TextView(mContext);

        v.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        v.setText("" + result[0] + result[1] + result[2] + "   " + countS + "S" + countB + "B");

        return v;
    }

    public void random() {
        for (int i = 0; i < baseball.length; i++) {
            baseball[i] = (int) (Math.random() * 9) + 1;

            for (int j = i - 1; j >= 0; j--) {
                if (baseball[i] == baseball[j]) {
                    i--;
                    break;
                }
            }
        }
        Log.i("Random", "random : " + baseball[0] + " " + baseball[1] + " " + baseball[2] + " ");
    }

    public void init() {
        random();
        mView.setInit();
    }
}
