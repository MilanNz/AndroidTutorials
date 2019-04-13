package com.eclard.roomdatabase;

import android.content.Context;

import com.eclard.roomdatabase.database.NewsDatabase;
import com.eclard.roomdatabase.database.entity.News;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.test.runner.AndroidJUnit4;

/**
 * Created by Milan on 4/13/19.
 */
@RunWith(AndroidJUnit4.class)
public class NewsDatabaseTest {
    private DataProvider dataProvider;

    @Before
    public void prepereDatabase() {
        Context context = ApplicationProvider.getApplicationContext();
        // For testing we can use in memory database.
        NewsDatabase newsDatabase = NewsDatabase.getInstance(context, true);
        dataProvider = new DatabaseProvider(newsDatabase);
    }

    @Test
    public void testNewsDatabaseSelect() {
        List<News> newsList = dataProvider.getAllNews();
        Assert.assertTrue(newsList.isEmpty());
    }
}

