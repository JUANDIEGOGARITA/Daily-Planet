package com.jd.dailyplanet.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class News implements Serializable {

  @PrimaryKey
  @NonNull
  private String id;
  @ColumnInfo(name = "sectionId")
  private String sectionId;
  @ColumnInfo(name = "sectionName")
  private String sectionName;
  @ColumnInfo(name = "webTitle")
  private String webTitle;
  @ColumnInfo(name = "webUrl")
  private String webUrl;
  @ColumnInfo(name = "thumbnail")
  private String thumbnail;
  @ColumnInfo(name = "summary")
  private String summary;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }
}
