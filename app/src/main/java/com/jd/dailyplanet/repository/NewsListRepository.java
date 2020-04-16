package com.jd.dailyplanet.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.jd.dailyplanet.db.NewsDataBase;
import com.jd.dailyplanet.db.entity.News;
import com.jd.dailyplanet.rest.client.RetrofitClient;
import com.jd.dailyplanet.rest.client.TheGuardianService;
import com.jd.dailyplanet.rest.model.request.Section;
import com.jd.dailyplanet.rest.model.response.news_list.ListResponse;
import com.jd.dailyplanet.util.AppExecutors;

import java.util.List;

import io.reactivex.Observable;

public class NewsListRepository {
  private static final String THUMBNAIL = "thumbnail";

  private final TheGuardianService theGuardianService;
  private final NewsDataBase newsDataBase;
  private LiveData<List<News>> readLaterNews;

  public NewsListRepository(Context context) {
    this.theGuardianService = RetrofitClient.getRetrofitInstance().create(TheGuardianService.class);
    this.newsDataBase = NewsDataBase.getDatabase(context);
  }

  public Observable<ListResponse> getNewsList() {
    return theGuardianService.getNewsList(50, THUMBNAIL);
  }

  public Observable<ListResponse> getNewsListBy(Section sectionId) {
    return theGuardianService.getNewsListBy(20, THUMBNAIL, sectionId.section);
  }

  public Observable<ListResponse> search(String query) {
    return theGuardianService.search(20, THUMBNAIL, query);
  }

  public void getReadLaterNews() {
    AppExecutors.getInstance().diskIO().execute(() ->
      readLaterNews = newsDataBase.daoAccess().fetchNews());
  }

}