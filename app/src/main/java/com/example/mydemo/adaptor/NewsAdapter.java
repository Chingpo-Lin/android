package com.example.mydemo.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mydemo.R;

import java.util.List;

import entity.News;

public class NewsAdapter extends BaseAdapter {

    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.list_item_news, parent, false);
        }

        // 获取当前位置的新闻对象
        News news = (News) getItem(position);

        // 更新新闻项的显示
        TextView titleTextView = view.findViewById(R.id.news_title);
        TextView descriptionTextView = view.findViewById(R.id.news_description);

        titleTextView.setText(news.getTitle());
        descriptionTextView.setText(news.getDescription());

        return view;
    }
}
