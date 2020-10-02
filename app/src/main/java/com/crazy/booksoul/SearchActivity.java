package com.crazy.booksoul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.crazy.booksoul.main.home.ArticleAdapter;
import com.crazy.booksoul.main.home.article;

import java.util.ArrayList;

import static com.crazy.booksoul.main.home.article.ARTICLE;
import static com.crazy.booksoul.main.home.article.INTERESTING_ARTICLE;
import static com.crazy.booksoul.main.home.article.PODCAST;
import static com.crazy.booksoul.main.home.article.PUBLISHER;

public class SearchActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recycler;
    private RecyclerView.Adapter searchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recycler=findViewById(R.id.recyclerSearch);
        toolbar=findViewById(R.id.toolbarSearch);
        setSupportActionBar(toolbar);
        setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        final ArrayList<article> search = new ArrayList<>();

        search.add(new article(ARTICLE, "Get up early","https://picsum.photos/id/276/200/300",3, 0,"Art"));
        search.add(new article(ARTICLE, "Get up early","https://picsum.photos/id/176/200/300",3, 0,"Science"));
        search.add(new article(ARTICLE, "Get up early","https://picsum.photos/id/376/200/300",3, 0,"Culture"));
        search.add(new article(INTERESTING_ARTICLE, "Get up early", "https://picsum.photos/id/266/200/300", "Poule Colo ",54));
        search.add(new article(INTERESTING_ARTICLE, "To be better", "https://picsum.photos/id/182/200/300", "Tikka Masala",64));
        search.add(new article(PODCAST, "Once you are what I know what you are only", "https://picsum.photos/id/723/300", "Lelo Barn",66));
        search.add(new article(PODCAST, "Get up you are what I know what you are early", "https://picsum.photos/id/296/200/300", "Wad Fadd",56));
        search.add(new article(PODCAST, "you are what I know what you are", "https://picsum.photos/id/67/200/300", "Yarn Defer ",45));
        search.add(new article(PODCAST, "To be better", "https://picsum.photos/id/571/200/300", "Chillo Pie",70));
         search.add(new article(PUBLISHER, "you are what I know what you are", "https://picsum.photos/id/677/200/300", "njfena ",0));
        search.add(new article(PUBLISHER, "To be better", "https://picsum.photos/id/571/200/300", "njfena ehf",0));


        searchAdapter = new ArticleAdapter(search, new ArticleAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {

            }
        },this);
        StaggeredGridLayoutManager staggeredGridLayoutManager6 = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(staggeredGridLayoutManager6);

        recycler.setAdapter(searchAdapter);
    }
}