package com.jd.dailyplanet.repository;

import com.jd.dailyplanet.rest.client.RetrofitClient;
import com.jd.dailyplanet.rest.client.TheGuardianService;
import com.jd.dailyplanet.rest.model.Response;

import io.reactivex.Observable;

public class NewsDetailsRepository {

  private final TheGuardianService theGuardianService;

  public NewsDetailsRepository() {
    this.theGuardianService = RetrofitClient.getRetrofitInstance().create(TheGuardianService.class);
  }

  public Observable<Response> getNewsDetails(String newsId) {
    return theGuardianService.getNewsDetails(newsId);
  }
}