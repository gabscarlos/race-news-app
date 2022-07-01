package me.dio.racenews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import me.dio.racenews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class RaceNewsDb extends RoomDatabase {
    public abstract NewsDao newsDao();
}
