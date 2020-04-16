package com.jd.dailyplanet.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jd.dailyplanet.db.dao.DaoAccess;
import com.jd.dailyplanet.db.entity.News;

@Database(entities = {News.class}, version = 1, exportSchema = false)
public abstract class NewsDataBase extends RoomDatabase {
  private static final String DB_NAME = "db_news";

  public abstract DaoAccess daoAccess();

  //SINGLETON
  private static NewsDataBase INSTANCE;

  public static NewsDataBase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (NewsDataBase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
            NewsDataBase.class, DB_NAME)
            .build();
        }
      }
    }
    return INSTANCE;
  }
}
