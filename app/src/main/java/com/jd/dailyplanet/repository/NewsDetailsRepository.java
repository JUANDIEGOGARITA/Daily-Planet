package com.jd.dailyplanet.repository;

import android.content.Context;

import com.jd.dailyplanet.db.NewsDataBase;
import com.jd.dailyplanet.db.entity.News;
import com.jd.dailyplanet.rest.client.RetrofitClient;
import com.jd.dailyplanet.rest.client.TheGuardianService;
import com.jd.dailyplanet.rest.model.response.news_details.DetailsResponse;
import com.jd.dailyplanet.util.AppExecutors;

import io.reactivex.Observable;

public class NewsDetailsRepository {

  private final TheGuardianService theGuardianService;
  private final NewsDataBase newsDataBase;

  public NewsDetailsRepository(Context context) {
    this.theGuardianService = RetrofitClient.getRetrofitInstance().create(TheGuardianService.class);
    this.newsDataBase = NewsDataBase.getDatabase(context);
  }

  public Observable<DetailsResponse> getNewsDetails(String newsId) {
    return theGuardianService.getNewsDetails(newsId, "body", "thumbnail");
  }

  public void readLater(News news) {
    AppExecutors.getInstance().diskIO().execute(() ->
      newsDataBase.daoAccess().insetNews(news));
  }
}