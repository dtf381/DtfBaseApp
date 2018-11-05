package com.cgw.demo_module.mode.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cgw.demo_module.R;
import com.cgw.demo_module.mode.entitys.LogisticsBean;

import java.util.ArrayList;

/**
 * 纵向时光轴适配器
 */

public class TimeAxisAdapter extends RecyclerView.Adapter<TimeAxisAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<LogisticsBean> mDatas;

    public TimeAxisAdapter(Context context, ArrayList<LogisticsBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_time, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LogisticsBean data = mDatas.get(position);
//        holder.tv_date.setText(data.getDate());
        holder.tv_time.setText(data.getTime());
        holder.tv_title.setText(data.getTitle());
        holder.tv_content.setText(data.getContent());
        if (position == mDatas.size() - 1) {
            holder.viewLine.setVisibility(View.GONE);
        } else {
            holder.viewLine.setVisibility(View.VISIBLE);
        }

        if (position == 0) {
            //最上面的一条颜色是橙色,其他的是灰色了
//            holder.tv_date.setTextColor(mContext.getResources().getColor(R.color.orange));
            holder.tv_time.setTextColor(mContext.getResources().getColor(R.color.orange));
            holder.tv_title.setTextColor(mContext.getResources().getColor(R.color.orange));
            holder.tv_content.setTextColor(mContext.getResources().getColor(R.color.orange));
            holder.llRight.setVisibility(View.INVISIBLE);
        } else {
            holder.llRight.setVisibility(View.VISIBLE);
        }

        //控制图片的显示
//        if (data.getState() == 1) {
//            //1完成
//            holder.iv_state.setImageResource(R.mipmap.ok_orange);
//        } else {
//            if (TextUtils.isEmpty(data.getTitle())) {
//                holder.iv_state.setImageResource(R.mipmap.dot);
//            } else {
//                if (position == 0) {
//                    holder.iv_state.setImageResource(R.mipmap.arrow_orange);
//                } else {
//                    holder.iv_state.setImageResource(R.mipmap.arrow_gray);
//                }
//            }
//        }

        //控制日期字体大小的显示
        if (TextUtils.isEmpty(data.getTitle())) {
            holder.tv_title.setVisibility(View.GONE);
//            holder.tv_date.setTextSize(10);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_time;
        TextView tv_title;
        TextView tv_content;
        LinearLayout llRight;
        View viewLine;

        public MyViewHolder(View itemView) {
            super(itemView);
//            tv_date = itemView.findViewById(R.id.tv_date);
            tv_time = itemView.findViewById(R.id.tv_time);
//            iv_state = itemView.findViewById(R.id.iv_state);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);
            llRight = itemView.findViewById(R.id.ll_right);
            viewLine = itemView.findViewById(R.id.viewLine);
        }
    }

}