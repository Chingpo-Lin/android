package com.example.mydemo.frag.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mydemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsDetailFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    private final String TAG = "Detail fragment";

//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
    private TextView newsDetailTextView;

    public NewsDetailFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment NewsDetailFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static NewsDetailFragment newInstance(String param1, String param2) {
//        NewsDetailFragment fragment = new NewsDetailFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
////    public static NewsDetailFragment newInstance(int position) {
////        NewsDetailFragment fragment = new NewsDetailFragment();
////        Bundle args = new Bundle();
////        args.putInt("position", position);
////        fragment.setArguments(args);
////        return fragment;
////    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        newsDetailTextView = view.findViewById(R.id.news_detail_text);

        updateContent(getArguments().getInt("position"));

        Log.d(TAG, "CREATE fragment: " + R.id.news_detail_text);
        return view;

    }

    public void updateContent(int position) {

        List<String> newsList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            newsList.add("news detail " + i);
        }
        // 这里假设有一个名为 newsList 的数据源，根据位置获取对应的新闻内容
        String newsContent = newsList.get(position);

        // 更新新闻详情的显示
        newsDetailTextView.setText(newsContent);
    }
}