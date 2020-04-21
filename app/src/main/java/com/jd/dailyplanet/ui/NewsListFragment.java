package com.jd.dailyplanet.ui;

import android.app.SearchManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jd.dailyplanet.R;
import com.jd.dailyplanet.repository.NewsListRepository;
import com.jd.dailyplanet.rest.model.response.common.News;
import com.jd.dailyplanet.ui.adapter.FilterType;
import com.jd.dailyplanet.ui.adapter.NewsAdapter;
import com.jd.dailyplanet.ui.adapter.NewsCategory;
import com.jd.dailyplanet.viewmodel.NewsListViewModel;
import com.jd.dailyplanet.viewmodel.ViewModelFactory;

import java.util.ArrayList;

public class NewsListFragment extends Fragment implements NewsAdapter.ItemClickListener {

  private NewsListViewModel newsListViewModel;
  private RecyclerView newsListView;
  private NewsAdapter newsAdapter;

  public NewsListFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
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
    newsAdapter = new NewsAdapter(new ArrayList<>());
    newsListView = view.findViewById(R.id.newsList);
    newsListView.setAdapter(newsAdapter);
    newsListViewModel = new ViewModelProvider(this,
      new ViewModelFactory(new NewsListRepository(getContext())))
      .get(NewsListViewModel.class);
    //   view.findViewById(R.id.newsListScreen).setOnClickListener(v -> goToNewsDetailsFragment(view));

    newsListViewModel.fetchNewsList();

    newsListViewModel.getResponse().observe(getActivity(), response -> {
      newsAdapter.updateNewsList(response.getNews());

      ((NewsAdapter) newsListView.getAdapter()).setClickListener(this);
      newsListView.setLayoutManager(new LinearLayoutManager(getActivity()));

      RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
      newsListView.setLayoutManager(mLayoutManager);
      newsListView.setItemAnimator(new DefaultItemAnimator());

    });
  }

  @Override
  public void onItemClick(News news) {
    Bundle bundle = new Bundle();
    bundle.putString("newsId", news.getId());
    Navigation.findNavController(this.requireView()).navigate(R.id.action_newsListFragment_to_newsDetailsFragment, bundle);
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.list, menu);
    SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
    searchView.setMaxWidth(Integer.MAX_VALUE);
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        newsAdapter.filterBy(FilterType.QUERY, newText);
        return false;
      }
    });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.sports:
        newsAdapter.filterBy(FilterType.CATEGORY, NewsCategory.SPORT);
        return true;
      case R.id.search:
        return true;
      default:
        break;
    }

    return false;
  }
}