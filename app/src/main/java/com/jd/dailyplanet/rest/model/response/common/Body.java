package com.jd.dailyplanet.rest.model.response.common;

import com.squareup.moshi.Json;

public class Body {
  @Json(name = "bodyTextSummary")
  private String bodyTextSummary;

  public String getBodyTextSummary() {
    return bodyTextSummary;
  }
}
