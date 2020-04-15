
package com.jd.dailyplanet.rest.model.response.news_list;

import com.jd.dailyplanet.rest.model.response.common.News;
import com.squareup.moshi.Json;

import java.util.List;

public class ListResponse {

  @Json(name = "response")
  private Response response;

  public List<News> getNews() {
    return response.getNews();
  }
}