package com.jd.dailyplanet.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.jd.dailyplanet.repository.NewsDetailsRepository;
import com.jd.dailyplanet.repository.NewsListRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

  private NewsListRepository newsListRepository;
  private NewsDetailsRepository newsDetailsRepository;

  public ViewModelFactory(NewsListRepository newsListRepository) {
    this.newsListRepository = newsListRepository;
  }

  public ViewModelFactory(NewsDetailsRepository newsDetailsRepository) {
    this.newsDetailsRepository = newsDetailsRepository;
  }

  public <T extends ViewModel> T create(Class<T> modelClass) {
    if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
      return (T) new NewsListViewModel(newsListRepository);
    }
    else if (modelClass.isAssignableFrom(NewsDetailsViewModel.class)) {
      return (T) new NewsDetailsViewModel(newsDetailsRepository);
    }
    throw new IllegalArgumentException("Unknown ViewModel class");
  }
}