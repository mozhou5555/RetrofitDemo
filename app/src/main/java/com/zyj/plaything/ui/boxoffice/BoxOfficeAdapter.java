package com.zyj.plaything.ui.boxoffice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyj.plaything.R;
import com.zyj.plaything.pojo.BoxOffice;

import java.util.ArrayList;
import java.util.List;

public class BoxOfficeAdapter extends RecyclerView.Adapter {
    public List<BoxOffice> mList = new ArrayList<>();
    public Context context;

    public BoxOfficeAdapter(Context context) {
        this.context = context;
    }

    /**
     * 主体
     */
    public class MyViewHolder extends ViewHolder {
        private TextView tvName;
        private TextView tvRid;
        private TextView tvWk;
        private TextView tvWboxoffice;
        private TextView tvTboxoffice;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.adapter_box_office_tv_name);
            tvRid = (TextView) itemView.findViewById(R.id.adapter_box_office_tv_rid);
            tvWk = (TextView) itemView.findViewById(R.id.adapter_box_office_tv_wk);
            tvWboxoffice = (TextView) itemView.findViewById(R.id.adapter_box_office_tv_wboxoffice);
            tvTboxoffice = (TextView) itemView.findViewById(R.id.adapter_box_office_tv_tboxoffice);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_box_office, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.tvName.setText(mList.get(position).getName());
        viewHolder.tvRid.setText("NO." + mList.get(position).getRid());
        viewHolder.tvWk.setText("榜单周数:" + mList.get(position).getWk());
        viewHolder.tvWboxoffice.setText("周末票房:" + mList.get(position).getWboxoffice());
        viewHolder.tvTboxoffice.setText("累计票房:" + mList.get(position).getTboxoffice());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
