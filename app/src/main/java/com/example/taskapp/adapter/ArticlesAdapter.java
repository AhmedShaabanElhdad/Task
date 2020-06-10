package com.example.taskapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;
import com.example.taskapp.network.model.Results;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesHolder> {

    private List<Results> articles;
    private Context mContext;

    public ArticlesAdapter(List<Results> articles, Context context) {
        mContext = context;
        this.articles = articles;
    }

    @Override
    public ArticlesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.car_item, parent, false);
        return new ArticlesHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticlesHolder holder, int position) {
        holder.bind(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void setArticles(List<Results> articles) {
        int startIndex = articles.size();
        this.articles.addAll(articles);
        notifyItemRangeInserted(startIndex, articles.size());
    }
}
