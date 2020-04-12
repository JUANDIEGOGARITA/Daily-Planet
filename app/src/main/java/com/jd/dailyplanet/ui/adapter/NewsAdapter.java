package com.jd.dailyplanet.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jd.dailyplanet.R;
import com.jd.dailyplanet.rest.model.Result;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

  private List<Result> mNews;
  private ItemClickListener mClickListener;

  public NewsAdapter(List<Result> moviePosterList) {
    this.mNews = moviePosterList;
  }

  public void updateMovieList(List<Result> newsList) {
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
    Result result = mNews.get(position);
    holder.bind(result);
  }

  @Override
  public int getItemCount() {
    return mNews.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView newsTitle;
    Result news;

    ViewHolder(View itemView) {
      super(itemView);
      newsTitle = itemView.findViewById(R.id.news_title_tv);
      itemView.setOnClickListener(this);
    }

    void bind(Result result) {
      this.news = result;
      this.newsTitle.setText(result.getWebTitle());
      //   Picasso.with(itemView.getContext()).load(NetworkUtils.buildPosterUrl(movie.getPosterUrl())).into(moviePoster);
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
    void onItemClick(Result news);
  }
}