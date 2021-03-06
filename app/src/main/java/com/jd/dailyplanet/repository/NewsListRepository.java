package com.jd.dailyplanet.repository;

import com.jd.dailyplanet.rest.client.RetrofitClient;
import com.jd.dailyplanet.rest.client.TheGuardianService;
import com.jd.dailyplanet.rest.model.request.Section;
import com.jd.dailyplanet.rest.model.response.news_list.ListResponse;

import io.reactivex.Observable;

public class NewsListRepository {

  private final TheGuardianService theGuardianService;
  private static final String THUMBNAIL = "thumbnail";

  public NewsListRepository() {
    this.theGuardianService = RetrofitClient.getRetrofitInstance().create(TheGuardianService.class);
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

}