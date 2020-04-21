package com.jd.dailyplanet.rest;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

import static com.jd.dailyplanet.rest.Status.ERROR;
import static com.jd.dailyplanet.rest.Status.LOADING;
import static com.jd.dailyplanet.rest.Status.SUCCESS;

public class Response {

  public final Status status;

  @Nullable
  public final String data;

  @Nullable
  public final Throwable error;

  private Response(Status status, @Nullable String data, @Nullable Throwable error) {
    this.status = status;
    this.data = data;
    this.error = error;
  }

  public static Response loading() {
    return new Response(LOADING, null, null);
  }

  public static Response success(@NonNull String data) {
    return new Response(SUCCESS, data, null);
  }

  public static Response error(@NonNull Throwable error) {
    return new Response(ERROR, null, error);
  }
}