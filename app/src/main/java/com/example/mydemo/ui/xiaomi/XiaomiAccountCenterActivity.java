package com.example.mydemo.ui.xiaomi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mydemo.R;
import com.example.mydemo.adaptor.AccountAdapter;
import com.example.mydemo.adaptor.AccountHelperAdapter;
import com.example.mydemo.entity.AccountItem;
import com.example.mydemo.frag.fragment.AccountSafetyFragment;
import com.example.mydemo.frag.fragment.FrequentQuestionFragment;
import com.example.mydemo.frag.fragment.LoginFragment;
import com.example.mydemo.frag.fragment.ModifyInfoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class XiaomiAccountCenterActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AccountHelperAdapter accountHelperAdapter;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaomi_account_center);

        // 获取 Toolbar 实例
        Toolbar toolbar = findViewById(R.id.toolbar);

        // 设置 Toolbar 为 ActionBar
        setSupportActionBar(toolbar);

        // 显示返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        spinner = findViewById(R.id.spinner);

        // 准备数据源，这里使用一个简单的字符串数组作为示例
        String[] items = {"简体中文", "繁体中文", "English"};

        // 创建适配器并设置数据源
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        // 设置下拉框的样式
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 将适配器设置给 Spinner
        spinner.setAdapter(arrayAdapter);

        recyclerView = findViewById(R.id.recyclerView);

        List<AccountItem> dataList = new ArrayList<>();
        dataList.add(new AccountItem(R.drawable.baseline_key_24, "重置密码"));
        dataList.add(new AccountItem(R.drawable.baseline_smartphone_24, "账号申诉"));
        dataList.add(new AccountItem(R.drawable.baseline_clear_24, "冻结账号"));
        dataList.add(new AccountItem(R.drawable.baseline_check_24, "解冻账号"));
        dataList.add(new AccountItem(R.drawable.baseline_lock_open_24, "解封账号"));
        dataList.add(new AccountItem(R.drawable.baseline_delete_24, "注销账号"));

        // Create and set the adapter
        AccountAdapter adapter = new AccountAdapter(dataList);
        recyclerView.setAdapter(adapter);

        // Set the layout manager
        int spanCount = 3; // Number of items per row
        GridLayoutManager layoutManager = new GridLayoutManager(this, spanCount);
        recyclerView.setLayoutManager(layoutManager);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        accountHelperAdapter = new AccountHelperAdapter(getSupportFragmentManager());
        accountHelperAdapter.addFragment(new FrequentQuestionFragment(), "常见问题");
        accountHelperAdapter.addFragment(new LoginFragment(), "登录");
        accountHelperAdapter.addFragment(new ModifyInfoFragment(), "修改信息");
        accountHelperAdapter.addFragment(new AccountSafetyFragment(), "账号安全");

        viewPager.setAdapter(accountHelperAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // 处理返回按钮点击事件，例如关闭当前活动
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}