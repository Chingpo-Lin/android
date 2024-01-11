package com.example.mydemo.frag.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mydemo.R;
import com.example.mydemo.adaptor.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

import entity.News;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private final String TAG = "news fragment";

    private ListView listView;
    private List<News> newsList;
    private NewsAdapter newsAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnNewsItemSelectedListener {
        void onNewsItemSelected(int position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        // 初始化新闻列表数据
        newsList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            newsList.add(new News("News Title " + i, "Description " + i));
        }

        // 初始化ListView和NewsAdapter
        listView = view.findViewById(R.id.news_list_view);
        newsAdapter = new NewsAdapter(requireContext(), newsList);

        // 设置ListView的适配器
        listView.setAdapter(newsAdapter);

        // 设置ListView的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 创建 NewsDetailFragment，并设置参数
                NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
                Bundle args = new Bundle();
                args.putInt("position", position);
                newsDetailFragment.setArguments(args);

                // 获取FragmentManager并开始事务
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // 替换当前的NewsListFragment为NewsDetailFragment
                fragmentTransaction.replace(R.id.fragment_container, newsDetailFragment);

                // 将事务加入返回栈，以便用户可以通过返回键返回到NewsListFragment
                fragmentTransaction.addToBackStack(null);

                // 提交事务
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}