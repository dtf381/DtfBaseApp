package com.cgw.demo_module.ui.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cgw.base_module.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 項目自定义控件1
 * 身高体重尺子效果：
 * https://github.com/ZBJDSBJ/ScaleRuler
 * Android表格控件
 * https://blog.csdn.net/xyx2999/article/details/79799888
 * 纵向轨迹（纵向时光轴）
 * https://blog.csdn.net/fu908323236/article/details/79032414
 * dongtengfei on 2018/11/5 11:41
 */
public class DemoActivity1 extends ListActivity {

    ArrayAdapter<String> arrayAdapter;
    List<String> names = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        names.add("身高体重尺子效果");
        names.add("纵向时光轴");
        names.add("Android表格控件");
        names.add("Android表格控件1");
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0://身高体重尺子效果
                ToastUtils.showToast(DemoActivity1.this, "0");
                startActivity(new Intent(DemoActivity1.this, MainActivity1.class));
                break;
            case 1://纵向时光轴
                ToastUtils.showToast(DemoActivity1.this, "1");
                startActivity(new Intent(DemoActivity1.this, TimeAxisActivity.class));
                break;
            case 2://Android表格控件
                ToastUtils.showToast(DemoActivity1.this, "2");
                startActivity(new Intent(DemoActivity1.this, BMIMainActivity.class));
                break;
            case 3://Android表格控件2
                ToastUtils.showToast(DemoActivity1.this, "3");
                startActivity(new Intent(DemoActivity1.this, TabView.class));
                break;
            default:
                break;

        }

    }
}
