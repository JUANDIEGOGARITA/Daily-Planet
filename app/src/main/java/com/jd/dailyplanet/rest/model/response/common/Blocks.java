package com.jd.dailyplanet.rest.model.response.common;

import com.squareup.moshi.Json;

import java.util.List;

public class Blocks {
  @Json(name = "body")
  private List<Body> body = null;

  public List<Body> getBody() {
    return body;
  }
}
