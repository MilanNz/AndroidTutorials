package com.eclard.roomdatabase.database;

import com.eclard.roomdatabase.database.entity.News;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by Milan on 4/13/19.
 */
@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    List<News> loadAllNews();

    @Query("SELECT * FROM news WHERE id = :id")
    News loadNewsById(int id);

    @Insert
    void insertAll(News... news);

    @Delete
    void delete(News news);
}
