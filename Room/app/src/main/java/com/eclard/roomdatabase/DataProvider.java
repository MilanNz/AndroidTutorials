package com.eclard.roomdatabase;

import com.eclard.roomdatabase.database.entity.News;

import java.util.List;

/**
 * Created by Milan on 4/13/19.
 */
public interface DataProvider {
    List<News> getAllNews();
    News getNewsById(int id);
    void deleteNews(News news);
}
