package com.jd.dailyplanet.ui.adapter;

public enum NewsCategory {
  WORLD("world"),
  SPORT("sport"),
  USA("us-news"),
  BUSINESS("business"),
  SCIENCE("science"),
  CULTURE("culture"),
  LIFESTYLE("lifeandstyle"),
  POLITICS("politics"),
  ENV("environment");

  public final String category;

  NewsCategory(String category) {
    this.category = category;
  }

}
