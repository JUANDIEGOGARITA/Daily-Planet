package com.jd.dailyplanet.rest.model.request;

public enum Section {
  WORLD("world"),
  SPORT("sport"),
  USA("us-news"),
  BUSINESS("business"),
  SCIENCE("science"),
  CULTURE("culture"),
  LIFESTYLE("lifeandstyle"),
  POLITICS("politics"),
  ENV("environment");

  public final String section;

  Section(String sectionId) {
    this.section = sectionId;
  }
}
