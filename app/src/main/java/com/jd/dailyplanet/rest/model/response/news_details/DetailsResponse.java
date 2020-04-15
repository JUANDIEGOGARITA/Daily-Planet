package com.jd.dailyplanet.rest.model.response.news_details;

import com.squareup.moshi.Json;

public class DetailsResponse {

  @Json(name = "response")
  private Response response;

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }
}