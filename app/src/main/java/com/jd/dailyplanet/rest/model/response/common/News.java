
package com.jd.dailyplanet.rest.model.response.common;

import com.squareup.moshi.Json;

import java.util.List;

public class News {

  @Json(name = "id")
  private String id;
  @Json(name = "sectionId")
  private String sectionId;
  @Json(name = "sectionName")
  private String sectionName;
  @Json(name = "webTitle")
  private String webTitle;
  @Json(name = "webUrl")
  private String webUrl;
  @Json(name = "fields")
  private Field field;
  @Json(name = "blocks")
  private Blocks blocks;

  public String getThumbnail() {
    return field.getThumbnail();
  }

  public List<Body> getBodySummary() {
    return blocks.getBody();
  }

  public String getId() {
    return id;
  }

  public String getSectionId() {
    return sectionId;
  }

  public String getSectionName() {
    return sectionName;
  }

  public String getWebTitle() {
    return webTitle;
  }

  public String getWebUrl() {
    return webUrl;
  }
}