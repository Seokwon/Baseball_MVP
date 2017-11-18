package com.sw.baseball.baseball;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sw.baseball.R;
import com.sw.baseball.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private MainPresenter mPresenter;
    private ActivityMainBinding mRootBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRootBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mPresenter = new MainPresenter(this, this);

        mPresenter.random();

        mRootBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.result();
            }
        });

        mRootBinding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.init();

            }
        });
    }

    @Override
    public String getInputText() {
        return mRootBinding.edInput.getText().toString();
    }


    @Override
    public void printResult(int mainResultOk, String resultText) {
        if (mainResultOk == MainPresenter.MAIN_RESULT_OK) {
            mRootBinding.tvView.setText(resultText);
        } else {
            Toast.makeText(this, "오류", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void layoutAddView(TextView v) {
        mRootBinding.linear.addView(v);
    }

    @Override
    public void setInit() {
        mRootBinding.edInput.setText("");
        mRootBinding.tvView.setText("0S0B");
        mRootBinding.linear.removeAllViews();
    }


}
