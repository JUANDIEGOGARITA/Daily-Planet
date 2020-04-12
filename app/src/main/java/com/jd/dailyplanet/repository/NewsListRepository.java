package com.jd.dailyplanet.repository;

import com.jd.dailyplanet.rest.client.RetrofitClient;
import com.jd.dailyplanet.rest.client.TheGuardianService;
import com.jd.dailyplanet.rest.model.Response;

import io.reactivex.Observable;

public class NewsListRepository {

  private final TheGuardianService theGuardianService;

  public NewsListRepository() {
    this.theGuardianService = RetrofitClient.getRetrofitInstance().create(TheGuardianService.class);
  }

  public Observable<Response> getNewsList(String fromDate, String toDate) {
    return theGuardianService.getNewsList(fromDate, toDate);
  }
}