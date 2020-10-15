package com.crazy.booksoul;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.NestedScrollView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.crazy.booksoul.main.home.ArticleAdapter;
import com.crazy.booksoul.main.home.article;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static com.crazy.booksoul.main.ViewPagerAdapter.str;
import static com.crazy.booksoul.main.home.article.ARTICLE;
import static com.crazy.booksoul.main.home.article.INTERESTING_ARTICLE;
import static com.crazy.booksoul.main.home.article.PUBLISHER;

public class ShowActivity extends AppCompatActivity {

    WebView content ;
    ProgressDialog progressDialog;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    static int id;
    LinearLayout linearLayout;
    int time, type;
    static int timepercent;
    TextView title,topic;
    private static int minnow;
    String urlimg,tm,ttl;
    AppBarLayout appBarLayout;
    article article;
    private static final long START_TIME_IN_MILLIS = 60000;
    private long mTimeLeftInMillis;
    RecyclerView recycler;
    private RecyclerView.Adapter aramAdapter, intmAdapter,QuiAdapter, pubAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final int NUM_COLUMNS = 1;
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent i = getIntent();
        id = i.getIntExtra("pos", 0);
        time = i.getIntExtra("time", 0);
        type = i.getIntExtra("type", 0);
        urlimg = i.getStringExtra("url");
        ttl=i.getStringExtra("title");
        tm = i.getStringExtra("time");

        Log.d("ggggggggggggggg", urlimg);

        final CardView cardView=findViewById(R.id.cardoptions);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        linearLayout=findViewById(R.id.llshow);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.collapsebar);

        title =  findViewById(R.id.title);
        topic =  findViewById(R.id.topic);
        topic.setText(i.getStringExtra("topic"));
        title.setText(i.getStringExtra("title"));

        init();

        toolbar.setTitleTextAppearance(this, R.style.RobotoBoldTextAppearance);
        initCollapsingToolbar();
        ImageView img=findViewById(R.id.imageShow);
        if(urlimg.equals("n"))
            img.setVisibility(View.GONE);
        Glide.with(this)
                .load(urlimg)
                .into(img);

        //seting palette color with glide
        Glide.with(this).asBitmap()
                .load(urlimg)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {

                        // Extract color
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(@Nullable Palette p) {

                                int mutedLight3 = p.getMutedColor(getResources().getColor(android.R.color.holo_blue_dark));
//                                int mutedLight4 = p.getLightVibrantColor(getResources().getColor(android.R.color.darker_gray));
//                                int mutedLight5 = p.getVibrantColor(getResources().getColor(android.R.color.darker_gray));
//                                int mutedLight6 = p.getDarkVibrantColor(getResources().getColor(android.R.color.darker_gray));

                                linearLayout.setBackgroundColor(mutedLight3);

                            }
                        });
                    }
                });

        ArrayList<article> articles = new ArrayList<>();
        final ArrayList<article> intarticle = new ArrayList<>();
        ArrayList<article> publish = new ArrayList<>();


        recycler = findViewById(R.id.recycshow);
        switch (type) {
            case ARTICLE:

                ////for articleforyou recycler view

                articles.add(new article(ARTICLE, "you are what I know what you are", "https://picsum.photos/id/12/200/300", 3, 40, "ENTERPANIOR"));
                articles.add(new article(ARTICLE, "Change the world as you wish", "https://picsum.photos/id/59/200/300", 5, 50, "MOTIVATION"));
                articles.add(new article(ARTICLE, "Be wise and be brave", "https://picsum.photos/id/76/200/300", 4, 75, "SPORTS"));

                recycler.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(this);
                aramAdapter = new ArticleAdapter(articles, new ArticleAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {

                    }
                }, this);
                StaggeredGridLayoutManager staggeredGridLayoutManager1 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                recycler.setLayoutManager(staggeredGridLayoutManager1);
                recycler.setAdapter(aramAdapter);


                break;
            case INTERESTING_ARTICLE:
                Log.e("str", str);

                //for intresting articles
//
                intarticle.add(new article(INTERESTING_ARTICLE, "Get up early", "https://picsum.photos/id/256/200/300", "wad awdiuhasiudn ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 40));
                intarticle.add(new article(INTERESTING_ARTICLE, "To be better", "https://picsum.photos/id/533/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 90));

                intarticle.add(new article(INTERESTING_ARTICLE, "be better", "https://picsum.photos/id/132/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 44));

                intmAdapter = new ArticleAdapter(intarticle, new ArticleAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {


                    }
                }, this);
                StaggeredGridLayoutManager staggeredGridLayoutManager2 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                recycler.setAdapter(intmAdapter);
                recycler.setLayoutManager(staggeredGridLayoutManager2);
                break;
            case PUBLISHER:

                publish.add(new article(PUBLISHER, "you are what I know what you are", "https://picsum.photos/id/12/200/300", "DD ALL", 40));
                publish.add(new article(PUBLISHER, "Change the world as you wish", "https://picsum.photos/id/59/200/300",  "POP ALL", 30));
                publish.add(new article(PUBLISHER, "Be wise and be brave", "https://picsum.photos/id/76/200/300",  "GET IT DONE", 40));

                recycler.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(this);
                pubAdapter = new ArticleAdapter(publish, new ArticleAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {

                    }
                }, this);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                recycler.setLayoutManager(staggeredGridLayoutManager3);
                recycler.setAdapter(pubAdapter);


                break;
            default:

        }
        nestedScrollView = findViewById(R.id.nested);
//        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//                if (scrollY>scrollX){
//                    cardView.setVisibility(View.GONE);
//                    Toast.makeText(ShowActivity.this, "Scrolling Down", Toast.LENGTH_SHORT).show();
//                } else {
//                    cardView.setVisibility(View.VISIBLE);
//                    cardView.bringToFront();
//                    Toast.makeText(ShowActivity.this, "Scrolling Up", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        String start = new SimpleDateFormat("HH:mm:ss").format(new Date());
        Log.e("time", start);
//        13:43:39

        Log.e("type", String.valueOf(type));
        Log.e("id", String.valueOf(id));
        Log.e("time", String.valueOf(time));

//         article.getProgressBar();
        mTimeLeftInMillis = START_TIME_IN_MILLIS * time;
        startTimer();

    }


    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;

            }
        }.start();
        mTimerRunning = true;

    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;

    }

    private void resetTimer() {

        mTimeLeftInMillis = START_TIME_IN_MILLIS * time;
        updateCountDownText();

    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timepercent = (int) ((START_TIME_IN_MILLIS - mTimeLeftInMillis) / 100);
//        mTextViewCountDown.setText(timeLeftFormatted);
    }

    public static int id() {

        return id;
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collape);
        collapsingToolbar.setTitle(" ");

        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(ttl);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private void init(){
        content = (WebView)findViewById(R.id.content);
        content.loadUrl("file:///android_asset/aa.html");
        content.requestFocus();

        progressDialog = new ProgressDialog(ShowActivity.this);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();

        content.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.show_menu, menu);
        Drawable drawable = menu.findItem(R.id.listen).getIcon();

        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, ContextCompat.getColor(this,R.color.Inspire));
        menu.findItem(R.id.listen).setIcon(drawable);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.loginFragment:
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(this,
                        android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(new Intent(this, LoginActivity.class),bundle);
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                return true;

            case R.id.action_search:
                // Some other methods
                Bundle b = ActivityOptionsCompat.makeCustomAnimation(this,
                        android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(new Intent(this, SearchActivity.class),b);
                return true;
            case R.id.Setting:
                // Some other methods
                Bundle b1 = ActivityOptionsCompat.makeCustomAnimation(this,
                        android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(new Intent(this, SettingsActivity.class),b1);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}