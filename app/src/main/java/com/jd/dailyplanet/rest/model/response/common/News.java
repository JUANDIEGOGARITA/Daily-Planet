
package com.jd.dailyplanet.rest.model.response.common;

import com.squareup.moshi.Json;

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
    if (field != null && field.getThumbnail() != null){
      return field.getThumbnail();
    }
    return null;
  }

  public String getBodySummary() {
    if (blocks.getBody() != null &&
      !blocks.getBody().isEmpty() &&
      blocks.getBody().get(0) != null &&
      blocks.getBody().get(0).getBodyTextSummary() != null &&
      !blocks.getBody().get(0).getBodyTextSummary().isEmpty()) {
      return blocks.getBody().get(0).getBodyTextSummary();
    }
    else {
      return "";
    }
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