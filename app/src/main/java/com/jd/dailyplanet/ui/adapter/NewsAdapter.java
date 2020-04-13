package com.jd.dailyplanet.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jd.dailyplanet.R;
import com.jd.dailyplanet.rest.model.response.common.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

  private List<News> mNews;
  private ItemClickListener mClickListener;

  public NewsAdapter(List<News> newsList) {
    this.mNews = newsList;
  }

  public void updateNewsList(List<News> newsList) {
    mNews = newsList;
    notifyDataSetChanged();
  }

  @Override
  @NonNull
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.news_item_list, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    News news = mNews.get(position);
    holder.bind(news);
  }

  @Override
  public int getItemCount() {
    return mNews.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView newsTitle;
    News news;

    ViewHolder(View itemView) {
      super(itemView);
      newsTitle = itemView.findViewById(R.id.news_title_tv);
      itemView.setOnClickListener(this);
    }

    void bind(News news) {
      this.news = news;
      this.newsTitle.setText(news.getWebTitle());
      //    Picasso.with(itemView.getContext()).load(NetworkUtils.buildPosterUrl(news.getThumbnail())).into(newsThumbnail);
    }

    @Override
    public void onClick(View view) {
      if (mClickListener != null) mClickListener.onItemClick(news);
    }
  }

  public void setClickListener(ItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }

  public interface ItemClickListener {
    void onItemClick(News news);
  }
}