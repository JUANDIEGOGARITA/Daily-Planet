package com.jd.dailyplanet.viewmodel;

import androidx.lifecycle.ViewModel;

import com.jd.dailyplanet.repository.NewsDetailsRepository;

public class NewsDetailsViewModel extends ViewModel {

  private NewsDetailsRepository newsDetailsRepository;

  public NewsDetailsViewModel(NewsDetailsRepository newsDetailsRepository) {
    this.newsDetailsRepository = newsDetailsRepository;
  }

}
