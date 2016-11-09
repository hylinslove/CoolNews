package com.warren.meng.topnews.view.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.android.databinding.library.baseAdapters.BR;
import com.warren.meng.topnews.R;
import com.warren.meng.topnews.adapter.CommonAdapter;
import com.warren.meng.topnews.modle.RetrofitUtil;
import com.warren.meng.topnews.modle.bean.BeanMain;
import com.warren.meng.topnews.view.IMain;
import com.warren.meng.topnews.view.activity.NewsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meng on 2016/11/8.
 */

public class NewsFragment extends Fragment implements IMain {

    private View view;
    private Context context;

    private RecyclerView recyclerView;
    private List<BeanMain.ResultBean.DataBean> list = new ArrayList<>();
    private CommonAdapter<BeanMain.ResultBean.DataBean> adapter;

    public static NewsFragment getFragment(String value) {
        Bundle bundle = new Bundle();
        NewsFragment fragment = new NewsFragment();
        bundle.putString("type", value);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, null);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_news);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        RetrofitUtil.getNewsData(getArguments().getString("type", "toutiao"), this);
        adapter = new CommonAdapter<>(context,
                list,
                R.layout.item_layout,
                BR.item_data,
                this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void toNews(String url) {
        Intent intent = new Intent(getActivity(), NewsActivity.class);
        intent.putExtra("url", url);
        getActivity().startActivity(intent);
    }

    @Override
    public void dataGot(BeanMain.ResultBean bean) {
        adapter.insertData(bean.getData());

    }

    @Override
    public void dataGotFailure() {

    }
}
