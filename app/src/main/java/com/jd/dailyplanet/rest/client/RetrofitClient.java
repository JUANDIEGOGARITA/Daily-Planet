package com.jd.dailyplanet.rest.client;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitClient {

  private static Retrofit retrofit;
  private static final String BASE_URL = "https://content.guardianapis.com/";

  public static Retrofit getRetrofitInstance() {
    if (retrofit == null) {

      OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new OkHttpInterceptor()).build();
      retrofit = new retrofit2.Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build();
    }
    return retrofit;
  }
}