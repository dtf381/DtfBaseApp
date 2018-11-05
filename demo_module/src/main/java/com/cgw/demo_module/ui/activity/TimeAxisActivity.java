package com.cgw.demo_module.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cgw.demo_module.R;
import com.cgw.demo_module.mode.adapter.TimeAxisAdapter;
import com.cgw.demo_module.mode.entitys.LogisticsBean;

import java.util.ArrayList;

/**
 * 时光轴App
 */
public class TimeAxisActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_axis);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                //解决ScrollView里存在多个RecyclerView时滑动卡顿的问题
                //如果你的RecyclerView是水平滑动的话可以重写canScrollHorizontally方法
                return true;   //设置false 就是禁止RecyclerView滑动
            }
        };

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
//解决数据加载完成后, 没有停留在顶部的问题
        recyclerView.setFocusable(false);

        //模拟数据集
        ArrayList<LogisticsBean> logisticsBeans = new ArrayList<>();
        logisticsBeans.add(new LogisticsBean("2018.07.12", 0, "", ""));
        logisticsBeans.add(new LogisticsBean("08:00", 0, "关于近期身体状况的随访", "系统推送"));
        logisticsBeans.add(new LogisticsBean("09:00", 0, "血压", "实时记录血压：130/90mmHg"));
        logisticsBeans.add(new LogisticsBean("09:30", 0, "血糖", "实时记录早餐后血糖：10.12mmol/L"));
        logisticsBeans.add(new LogisticsBean("11:00", 0, "自我管理评估", "内科王伟医生推送"));
        logisticsBeans.add(new LogisticsBean("11:02", 0, "脉搏", "实时记录脉搏：80次/分"));
        logisticsBeans.add(new LogisticsBean("16:00", 0, "体温", "实时记录体温：36.7°C"));
        logisticsBeans.add(new LogisticsBean("16:30", 0, "综合评估", "患者重新评估"));
        logisticsBeans.add(new LogisticsBean("18:30", 0, "糖尿病并发症的学习", "系统推送"));

        TimeAxisAdapter adapter = new TimeAxisAdapter(this, logisticsBeans);
        recyclerView.setAdapter(adapter);
    }
}