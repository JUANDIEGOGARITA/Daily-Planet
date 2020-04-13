package com.jd.dailyplanet.rest.model.response.news_details;

import com.jd.dailyplanet.rest.model.response.common.News;
import com.squareup.moshi.Json;

public class Response {

  @Json(name = "status")
  private String status;
  @Json(name = "userTier")
  private String userTier;
  @Json(name = "total")
  private Integer total;
  @Json(name = "content")
  private News news;

  public News getNews() {
    return news;
  }
}