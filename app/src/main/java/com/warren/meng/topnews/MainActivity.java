package com.warren.meng.topnews;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import com.warren.meng.topnews.adapter.MyViewPagerAdapter;

import com.warren.meng.topnews.databinding.ActivityMainBinding;
import com.warren.meng.topnews.util.Constant;
import com.warren.meng.topnews.view.Fragment.NewsFragment;


import net.yanzm.mth.MaterialTabHost;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  {

    private ActivityMainBinding binding;
    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        initFragment();
        initViewPager();
        initTabHost();

    }

    private void initFragment() {
        for(String type: Constant.types){

            NewsFragment fragment = NewsFragment.getFragment(type);
            fragmentList.add(fragment);
        }

    }

    private void initTabHost() {
        for(int i = 0;i<Constant.typesCN.length;i++){
            binding.tabHostMain.addTab(Constant.typesCN[i]);
        }
        binding.tabHostMain.setOnTabChangeListener(new MaterialTabHost.OnTabChangeListener() {
            @Override
            public void onTabSelected(int i) {
                binding.viewPagerMain.setCurrentItem(i);
            }
        });

    }

    private void initViewPager() {
        binding.viewPagerMain.setOffscreenPageLimit(fragmentList.size() - 1);
        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        binding.viewPagerMain.setAdapter(viewPagerAdapter);
        binding.viewPagerMain.addOnPageChangeListener(binding.tabHostMain);
    }

}
