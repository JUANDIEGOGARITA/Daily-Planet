package com.jd.dailyplanet.rest.client;

import com.jd.dailyplanet.db.entity.News;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonDataException;

import org.json.JSONException;
import org.json.JSONObject;

public class NewsAdapter {
  @FromJson
  News fromJson(String news) {
    try {
      if (news.isEmpty()) throw new JsonDataException("Unknown card: " + news);

      JSONObject newsJson = new JSONObject(news);
      String sectionId = newsJson.optString("sectionId");

      return new News();
    }
    catch (JSONException e) {
      e.printStackTrace();
      return null;
    }
  }
}
