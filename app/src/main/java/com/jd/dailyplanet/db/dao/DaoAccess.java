package com.jd.dailyplanet.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.jd.dailyplanet.db.entity.News;

import java.util.List;

@Dao
public interface DaoAccess {

  @Insert
  Long insetNews(News news);

  @Query("SELECT * FROM News ORDER BY id desc")
  LiveData<List<News>> fetchNews();


  @Query("SELECT * FROM News WHERE id =:newsId")
  LiveData<News> getNews(int newsId);


  @Delete
  void deleteNews(News news);

}
