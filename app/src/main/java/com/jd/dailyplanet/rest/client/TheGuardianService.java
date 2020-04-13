package com.jd.dailyplanet.rest.client;

import com.jd.dailyplanet.rest.model.request.Section;
import com.jd.dailyplanet.rest.model.response.news_details.DetailsResponse;
import com.jd.dailyplanet.rest.model.response.news_list.ListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface TheGuardianService {

  @GET("search")
  Observable<ListResponse> getNewsList(@Query("page-size") int size, @Query("show-fields") String thumbnail);

  @GET("search")
  Observable<ListResponse> getNewsListBy(@Query("page-size") int size, @Query("show-fields") String thumbnail, @Query("section") String sectionId);

  @GET("search")
  Observable<ListResponse> search(@Query("page-size") int size, @Query("show-fields") String thumbnail, @Query("q") String query);

  @GET
  Observable<DetailsResponse> getNewsDetails(@Url String newsId, @Query("show-blocks") String body, @Query("show-fields") String thumbnail);
}