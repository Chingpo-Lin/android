package com.example.mydemo.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydemo.R;

import java.util.List;

// MyAdapter.java
public class FrequentQuestionAdapter extends RecyclerView.Adapter<FrequentQuestionAdapter.ViewHolder> {

    private List<String> data;

    // 构造函数，用于接收数据
    public FrequentQuestionAdapter(List<String> data) {
        this.data = data;
    }

    // 创建 ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_frequent_question, parent, false);
        return new ViewHolder(view);
    }

    // 绑定数据到 ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = data.get(position);
        holder.textView.setText(item);
    }

    // 返回数据项数量
    @Override
    public int getItemCount() {
        return data.size();
    }

    // ViewHolder 类
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}

