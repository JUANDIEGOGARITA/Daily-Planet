package com.jd.dailyplanet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jd.dailyplanet.R;
import com.jd.dailyplanet.repository.NewsListRepository;
import com.jd.dailyplanet.rest.model.request.Section;
import com.jd.dailyplanet.rest.model.response.common.News;
import com.jd.dailyplanet.ui.adapter.NewsAdapter;
import com.jd.dailyplanet.viewmodel.NewsListViewModel;
import com.jd.dailyplanet.viewmodel.ViewModelFactory;

public class NewsListFragment extends Fragment implements NewsAdapter.ItemClickListener {

  private NewsListViewModel newsListViewModel;
  private RecyclerView newsListView;

  public NewsListFragment() {
    // Required empty public constructor
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_news_list, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    newsListViewModel = new ViewModelProvider(this,
      new ViewModelFactory(new NewsListRepository()))
      .get(NewsListViewModel.class);
    newsListView = view.findViewById(R.id.newsList);
    //   view.findViewById(R.id.newsListScreen).setOnClickListener(v -> goToNewsDetailsFragment(view));

    newsListViewModel.search("barcelona");

    newsListViewModel.getResponse().observe(getActivity(), response -> {
      newsListView.setAdapter(new NewsAdapter(response.getNews()));
      ((NewsAdapter) newsListView.getAdapter()).setClickListener(this);
      newsListView.setLayoutManager(new LinearLayoutManager(getActivity()));
    });
  }

  @Override
  public void onItemClick(News news) {
    Bundle bundle = new Bundle();
    bundle.putString("newsId", news.getId());
    Navigation.findNavController(this.requireView()).navigate(R.id.action_newsListFragment_to_newsDetailsFragment, bundle);
  }
}