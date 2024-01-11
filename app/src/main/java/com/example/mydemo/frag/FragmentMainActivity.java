package com.example.mydemo.frag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.mydemo.R;
import com.example.mydemo.frag.fragment.NewsDetailFragment;
import com.example.mydemo.frag.fragment.NewsFragment;

import entity.News;

public class FragmentMainActivity extends AppCompatActivity implements NewsFragment.OnNewsItemSelectedListener {

    private final String TAG = "Fragment Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment_main_600);

        if (getResources().getBoolean(R.bool.isTablet)) {
            Log.d(TAG, "PAD screen");
            setContentView(R.layout.activity_fragment_main_600);
        } else {
            Log.d(TAG, "phone screen");
            setContentView(R.layout.activity_fragment_main);
        }

        // 使用 FragmentManager 开始事务
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 创建并添加 MyFragment
        NewsFragment myFragment = new NewsFragment();
        fragmentTransaction.add(R.id.fragment_container, myFragment);

        // 提交事务
        fragmentTransaction.commit();

    }

    @Override
    public void onNewsItemSelected(int position) {

        // 处理新闻列表项被选中的事件
        if (findViewById(R.id.fragment_container) != null) {
            // 在单页模式下，替换Fragment为新闻详情Fragment
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, NewsDetailFragment.newInstance(position))
//                    .addToBackStack(null)
//                    .commit();

        } else {
            // 在双页模式下，更新新闻详情Fragment的内容
            NewsDetailFragment fragment = (NewsDetailFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragment_detail);
            if (fragment != null) {
                fragment.updateContent(position);
            }
        }
    }
}