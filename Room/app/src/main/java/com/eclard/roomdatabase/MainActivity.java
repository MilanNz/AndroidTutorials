package com.eclard.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.eclard.roomdatabase.database.NewsDatabase;
import com.eclard.roomdatabase.database.entity.News;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseProvider provider;

    private TextView newsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // I will show news in textView, but regularly we would use RecyclerView.
        newsTextView = findViewById(R.id.news_textview);

        provider = new DatabaseProvider(NewsDatabase
                .getInstance(getApplicationContext()));
    }

    private void previewNewsInTextView(List<News> newsList) {
        StringBuilder newsSb = new StringBuilder();
        for (News news : newsList) {
            newsSb.append(news.getTitle());
            newsSb.append("\n");
            newsSb.append(news.getDescription());
            newsSb.append("\n");
            newsSb.append("\n");
        }

        newsTextView.setText(newsSb.toString());
    }

    private void deleteFirstNews(List<News> newsList) {
        if (!newsList.isEmpty()) {
            provider.deleteNews(newsList.get(0));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete_news) {
            // remove the first newst from list.
            deleteFirstNews(provider.getAllNews());
            previewNewsInTextView(provider.getAllNews());

        } else if (item.getItemId() == R.id.get_news) {
            // get all news.
            previewNewsInTextView(provider.getAllNews());
        }

        return super.onOptionsItemSelected(item);
    }
}
