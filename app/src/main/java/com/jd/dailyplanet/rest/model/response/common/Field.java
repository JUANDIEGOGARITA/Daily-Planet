package com.jd.dailyplanet.rest.model.response.common;

import com.squareup.moshi.Json;

public class Field {
  @Json(name = "thumbnail")
  private String thumbnail;

  String getThumbnail() {
    return thumbnail;
  }
}