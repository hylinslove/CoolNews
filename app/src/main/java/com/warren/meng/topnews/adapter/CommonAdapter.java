package com.warren.meng.topnews.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.warren.meng.topnews.R;
import com.warren.meng.topnews.modle.bean.BeanMain;

import java.util.List;

/**
 * Created by meng on 2016/11/8.
 */

public class CommonAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context ;
    private List<T> list;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;
    private ViewDataBinding binding;

    public CommonAdapter(Context context, List<T> list, int layoutId, int variableId) {
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
        this.variableId = variableId;
        inflater = LayoutInflater.from(context);
    }

    public void insertData(List<BeanMain.ResultBean.DataBean> list){
        this.list = (List<T>) list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return list==null?0:list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        binding = DataBindingUtil.inflate(inflater,layoutId,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(binding.getRoot());

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        binding = DataBindingUtil.getBinding(((MyViewHolder)holder).getView());
        binding.setVariable(variableId,list.get(position));

    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        private View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
        public View getView(){
            return view;
        }
    }
}
