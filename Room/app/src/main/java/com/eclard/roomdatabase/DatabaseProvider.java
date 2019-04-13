package com.eclard.roomdatabase;

import androidx.annotation.Nullable;

import com.eclard.roomdatabase.database.NewsDatabase;
import com.eclard.roomdatabase.database.entity.News;

import java.util.Collections;
import java.util.List;

/**
 * Created by Milan on 4/13/19.
 */
public class DatabaseProvider implements DataProvider {
    private NewsDatabase newsDatabase;
    private boolean mocked = false;

    // Let's say we don't have internet connection
    // and we want to use data from database.
    private boolean internetConnection = false;

    public DatabaseProvider(NewsDatabase newsDatabase) {
        this.newsDatabase = newsDatabase;

        if (!mocked) {
            saveNewsIntoDatabaseCashe();
        }
    }

    @Override
    public List<News> getAllNews() {
        if (!internetConnection) {
            return newsDatabase.newsDao().loadAllNews();
        }

        return Collections.emptyList();
    }

    @Nullable
    @Override
    public News getNewsById(int id) {
        if (!internetConnection) {
            newsDatabase.newsDao().loadNewsById(id);
        }

        return null;
    }

    @Override
    public void deleteNews(News news) {
        newsDatabase.newsDao().delete(news);
    }


    // In this example we mock news, but in real life they will
    // be download from internet (REST API).
    private void saveNewsIntoDatabaseCashe() {
        News[] newsArray = new News[3];

        News news1 = new News();
        news1.setTitle("What is Lorem Ipsum?");
        news1.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry");
        news1.setBody("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");

        // Add news
        newsArray[0] = news1;

        News news2 = new News();
        news2.setTitle("Why do we use it?");
        news2.setDescription("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.");
        news2.setBody("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.");

        // Add news
        newsArray[1] = news2;

        News news3 = new News();
        news3.setTitle("Where does it come from?");
        news3.setDescription("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.");
        news3.setBody("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.");

        // Add news
        newsArray[2] = news3;

        // Save list of news
        newsDatabase.newsDao().insertAll(newsArray);
    }
}
