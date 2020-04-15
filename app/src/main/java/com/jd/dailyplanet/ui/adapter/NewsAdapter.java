package com.jd.dailyplanet.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jd.dailyplanet.R;
import com.jd.dailyplanet.rest.model.response.common.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> implements Filterable {

  private List<News> filteredNewsList;
  private List<News> newsList;
  private FilterType currentFilterType;

  private ItemClickListener mClickListener;

  public NewsAdapter(List<News> newsList) {
    this.filteredNewsList = newsList;
    this.newsList = new ArrayList<>(filteredNewsList);
  }

  public void updateNewsList(List<News> newsList) {
    filteredNewsList = newsList;
    this.newsList = new ArrayList<>(filteredNewsList);
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
    News news = filteredNewsList.get(position);
    holder.bind(news);
  }

  @Override
  public int getItemCount() {
    return filteredNewsList.size();
  }

  public void filterBy(FilterType filterType, NewsCategory category) {
    filterBy(filterType, category.category);
  }

  public void filterBy(FilterType filterType, String query) {
    currentFilterType = filterType;
    getFilter().filter(query);
  }

  @Override
  public Filter getFilter() {
    switch (currentFilterType) {
      case QUERY:
        return queryFilter;
      case CATEGORY:
      default:
        return categoryFilter;
    }
  }

  private Filter queryFilter = new Filter() {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
      List<News> filteredList = new ArrayList<>();
      if (constraint == null || constraint.length() == 0) {
        filteredList.addAll(newsList);
      }
      else {
        String filterPattern = constraint.toString().toLowerCase().trim();
        for (News news : newsList) {
          if (news.getWebTitle().toLowerCase().trim().contains(filterPattern)) {
            filteredList.add(news);
          }
        }
      }
      FilterResults results = new FilterResults();
      results.values = filteredList;
      return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
      filteredNewsList.clear();
      filteredNewsList.addAll((ArrayList<News>) results.values);
      notifyDataSetChanged();
    }
  };

  private Filter categoryFilter = new Filter() {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
      List<News> filteredList = new ArrayList<>();
      if (constraint == null || constraint.length() == 0) {
        filteredList.addAll(newsList);
      }
      else {
        String filterPattern = constraint.toString().toLowerCase().trim();
        for (News news : newsList) {
          if (news.getSectionId().equals(filterPattern)) {
            filteredList.add(news);
          }
        }
      }
      FilterResults results = new FilterResults();
      results.values = filteredList;
      return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
      filteredNewsList.clear();
      filteredNewsList.addAll((ArrayList<News>) results.values);
      notifyDataSetChanged();
    }
  };

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView newsTitle;
    ImageView thumbnail;
    News news;

    ViewHolder(View itemView) {
      super(itemView);
      newsTitle = itemView.findViewById(R.id.news_title_tv);
      thumbnail = itemView.findViewById(R.id.thumbnail);
      itemView.setOnClickListener(this);
    }

    void bind(News news) {
      this.news = news;
      this.newsTitle.setText(news.getWebTitle());
      if (news.getThumbnail() != null) {
        Picasso.get().load(news.getThumbnail()).into(thumbnail);
      }
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