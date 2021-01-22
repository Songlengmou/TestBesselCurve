package com.anningtex.testbesselcurve.one;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anningtex.testbesselcurve.R;

/**
 * @author Song
 */
public class OneActivity extends AppCompatActivity {
    private RelativeLayout rlMain;
    private ImageView ivCar;
    private TextView tvAdd;
    private int[] addView = new int[2];
    private int[] shopView = new int[2];
    private int[] parentView = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initView();
    }

    private void initView() {
        rlMain = findViewById(R.id.rlMain);
        ivCar = findViewById(R.id.ivCar);
        tvAdd = findViewById(R.id.tvAdd);

        tvAdd.setOnClickListener(v -> {
            tvAdd.getLocationInWindow(addView);
            rlMain.getLocationInWindow(parentView);
            ivCar.getLocationInWindow(shopView);

            final PointF startF = new PointF(addView[0] - parentView[0], addView[1] - parentView[1]);
            final PointF endF = new PointF(shopView[0] - parentView[0], shopView[1] - parentView[1]);
            final PointF controllerF = new PointF(endF.x, startF.y);
            final ImageView imageView = new ImageView(OneActivity.this);
            imageView.setImageResource(R.mipmap.shop_car);
            imageView.setScaleX(0);
            imageView.setScaleY(0);
            rlMain.addView(imageView);
            imageView.setX(startF.x);
            imageView.setY(startF.y);

            ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluate(controllerF), startF, endF);
            valueAnimator.addUpdateListener(animation -> {
                PointF pointF = (PointF) animation.getAnimatedValue();
                imageView.setX(pointF.x);
                imageView.setY(pointF.y);
                imageView.setScaleY(animation.getAnimatedFraction());
                imageView.setScaleX(animation.getAnimatedFraction());
            });
            valueAnimator.setDuration(1000);
            valueAnimator.setTarget(imageView);
            valueAnimator.start();
        });
    }
}