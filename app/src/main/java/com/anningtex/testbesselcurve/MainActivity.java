package com.anningtex.testbesselcurve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.testbesselcurve.one.OneActivity;
import com.anningtex.testbesselcurve.two.TwoActivity;

/**
 * @author Song
 * desc:贝塞尔曲线
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnOne, mBtnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnOne = findViewById(R.id.btn_one);
        mBtnTwo = findViewById(R.id.btn_two);
        mBtnOne.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                startActivity(new Intent(MainActivity.this, OneActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
                break;
            default:
                break;
        }
    }
}