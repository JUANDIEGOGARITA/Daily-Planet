
package com.jd.dailyplanet.rest.model;

import com.squareup.moshi.Json;

public class Result {

  @Json(name = "id")
  private String id;
  @Json(name = "type")
  private String type;
  @Json(name = "sectionId")
  private String sectionId;
  @Json(name = "sectionName")
  private String sectionName;
  @Json(name = "webPublicationDate")
  private String webPublicationDate;
  @Json(name = "webTitle")
  private String webTitle;
  @Json(name = "webUrl")
  private String webUrl;
  @Json(name = "apiUrl")
  private String apiUrl;
  @Json(name = "isHosted")
  private Boolean isHosted;
  @Json(name = "pillarId")
  private String pillarId;
  @Json(name = "pillarName")
  private String pillarName;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSectionId() {
    return sectionId;
  }

  public void setSectionId(String sectionId) {
    this.sectionId = sectionId;
  }

  public String getSectionName() {
    return sectionName;
  }

  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  public String getWebPublicationDate() {
    return webPublicationDate;
  }

  public void setWebPublicationDate(String webPublicationDate) {
    this.webPublicationDate = webPublicationDate;
  }

  public String getWebTitle() {
    return webTitle;
  }

  public void setWebTitle(String webTitle) {
    this.webTitle = webTitle;
  }

  public String getWebUrl() {
    return webUrl;
  }

  public void setWebUrl(String webUrl) {
    this.webUrl = webUrl;
  }

  public String getApiUrl() {
    return apiUrl;
  }

  public void setApiUrl(String apiUrl) {
    this.apiUrl = apiUrl;
  }

  public Boolean getIsHosted() {
    return isHosted;
  }

  public void setIsHosted(Boolean isHosted) {
    this.isHosted = isHosted;
  }

  public String getPillarId() {
    return pillarId;
  }

  public void setPillarId(String pillarId) {
    this.pillarId = pillarId;
  }

  public String getPillarName() {
    return pillarName;
  }

  public void setPillarName(String pillarName) {
    this.pillarName = pillarName;
  }

}
