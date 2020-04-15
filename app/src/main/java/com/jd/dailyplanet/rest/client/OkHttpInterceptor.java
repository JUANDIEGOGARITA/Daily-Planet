package com.jd.dailyplanet.rest.client;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpInterceptor implements Interceptor {

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request originalRequest = chain.request();
    String token = "9e24dfce-11a6-4d54-9a50-c9d4f5a98022";
      Request newRequest = originalRequest.newBuilder()
      .header("api-key", token)
      .build();

    return chain.proceed(newRequest);
  }
}
