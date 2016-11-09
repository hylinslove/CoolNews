package com.warren.meng.topnews.adapter;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.warren.meng.topnews.modle.bean.BeanMain;
import com.warren.meng.topnews.view.Fragment.NewsFragment;

import java.util.List;

/**
 * Created by meng on 2016/11/8.
 */

public class CommonAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private Activity activity;
    private List<T> list;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;
    private ViewDataBinding binding;
    private NewsFragment fragment;

    public CommonAdapter(Context context, List<T> list, int layoutId, int variableId, NewsFragment fragment) {
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.fragment = fragment;
        inflater = LayoutInflater.from(context);
    }

    public void insertData(List<BeanMain.ResultBean.DataBean> list) {
        this.list = (List<T>) list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return list == null ? 0 : list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(binding.getRoot());

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        binding = DataBindingUtil.getBinding(((MyViewHolder) holder).getView());
        binding.setVariable(variableId, list.get(position));
        binding.setVariable(BR.news_fragment, fragment);

    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }

        public View getView() {
            return view;
        }
    }
}
