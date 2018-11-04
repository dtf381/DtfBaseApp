package com.cgw.demo_module.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.cgw.base_module.base.BaseActivity;
import com.cgw.base_module.utils.ToastUtils;
import com.cgw.demo_module.R;
import com.cgw.demo_module.ui.widget.DecimalScaleRulerView;
import com.cgw.demo_module.ui.widget.ScaleRulerView;
import com.cgw.demo_module.utils.DrawUtil;

/**
 * @Author: DongTengFei
 * @CreateDate: 2018/11/4 0004 下午 18:57
 */
public class MainActivity extends BaseActivity {
    ScaleRulerView mHeightWheelView;
    TextView mHeightValue;
    ScaleRulerView mWeightWheelView;
    TextView mWeightValue;
    DecimalScaleRulerView mWeightRulerView;
    TextView mWeightValueTwo;

    private float mHeight = 170;
    private float mMaxHeight = 220;
    private float mMinHeight = 100;


    private float mWeight = 60.0f;
    private float mMaxWeight = 200;
    private float mMinWeight = 25;

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mHeightWheelView = findViewById(R.id.scaleWheelView_height);
        mHeightValue = findViewById(R.id.tv_user_height_value);
        mWeightWheelView = findViewById(R.id.scaleWheelView_weight);
        mWeightValue = findViewById(R.id.tv_user_weight_value);
        mWeightRulerView = findViewById(R.id.ruler_weight);
        mWeightValueTwo = findViewById(R.id.tv_user_weight_value_two);

        mHeightValue.setText((int) mHeight + "");
        mWeightValue.setText(mWeight + "");
        mWeightValueTwo.setText(mWeight + "kg");

        findViewById(R.id.btn_choose_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(MainActivity.this, "选择身高： " + mHeight + " 体重： " + mWeight);
            }
        });

        mHeightWheelView.initViewParam(mHeight, mMaxHeight, mMinHeight);
        mHeightWheelView.setValueChangeListener(new ScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                mHeightValue.setText((int) value + "");
                mHeight = value;
            }
        });

        mWeightWheelView.initViewParam(mWeight, mMaxWeight, mMinWeight);
        mWeightWheelView.setValueChangeListener(new ScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                mWeightValue.setText(value + "");

                mWeight = value;
            }
        });


        mWeightRulerView.setParam(DrawUtil.dip2px(10), DrawUtil.dip2px(32), DrawUtil.dip2px(24),
                DrawUtil.dip2px(14), DrawUtil.dip2px(9), DrawUtil.dip2px(12));
        mWeightRulerView.initViewParam(mWeight, 20.0f, 200.0f, 1);
        mWeightRulerView.setValueChangeListener(new DecimalScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                mWeightValueTwo.setText(value + "kg");

                mWeight = value;
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
