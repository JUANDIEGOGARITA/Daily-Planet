package com.jd.dailyplanet.rest.model.response.news_list;

import com.jd.dailyplanet.rest.model.response.common.News;
import com.squareup.moshi.Json;

import java.util.List;

public class Response {

  @Json(name = "status")
  private String status;
  @Json(name = "pageSize")
  private Integer pageSize;
  @Json(name = "currentPage")
  private Integer currentPage;
  @Json(name = "results")
  private List<News> news = null;

  List<News> getNews() {
    return news;
  }

  public String getStatus() {
    return status;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public Integer getCurrentPage() {
    return currentPage;
  }
}