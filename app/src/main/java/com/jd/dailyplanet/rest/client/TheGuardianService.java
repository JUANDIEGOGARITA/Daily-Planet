package com.jd.dailyplanet.rest.client;

import com.jd.dailyplanet.rest.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheGuardianService {

  @GET("search")
  Observable<Response> getNewsList(@Query("fromDate") String fromDate, @Query("toDate") String toDate);

  @GET("{newsId}}?show-blocks=body:latest")
  Observable<Response> getNewsDetails(@Path("newsId") String newsId);
}