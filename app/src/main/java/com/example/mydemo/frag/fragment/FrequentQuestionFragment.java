package com.example.mydemo.frag.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mydemo.R;
import com.example.mydemo.adaptor.FrequentQuestionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FrequentQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrequentQuestionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private final String TAG = "frequent question fragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private FrequentQuestionAdapter adapter;

    public FrequentQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FrequentQuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FrequentQuestionFragment newInstance(String param1, String param2) {
        FrequentQuestionFragment fragment = new FrequentQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view = inflater.inflate(R.layout.fragment_frequent_question, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        // 添加示例数据（可以根据需要修改）
        List<String> data = new ArrayList<>();
        data.add("忘记账号了，该如何找回？");
        data.add("忘记密码了，该如何重置？");
        data.add("手机停用了，该如何换绑？");
        data.add("申诉不通过，你又该如何是好？");


        // 初始化 Adapter
        adapter = new FrequentQuestionAdapter(data);
        // 设置 Adapter
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}