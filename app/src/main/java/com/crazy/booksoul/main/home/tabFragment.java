package com.crazy.booksoul.main.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crazy.booksoul.R;
import com.crazy.booksoul.main.read.CustomAdapter;
import com.crazy.booksoul.main.wishlist.WishlistFragment;
import com.smarteist.autoimageslider.SliderView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;
import static com.crazy.booksoul.preference.LoginFragment.MY_PREFERENCES;
import static com.crazy.booksoul.preference.PreferenceFragment.nonDuplicateString;
import static com.crazy.booksoul.main.ViewPagerAdapter.str;
import static com.crazy.booksoul.main.home.article.ARTICLE;
import static com.crazy.booksoul.main.home.article.CATEGORY;
import static com.crazy.booksoul.main.home.article.INTERESTING_ARTICLE;
import static com.crazy.booksoul.main.home.article.PODCAST;
import static com.crazy.booksoul.main.home.article.PUBLISHER;
import static com.crazy.booksoul.main.home.article.QUICKS;
import static com.crazy.booksoul.main.wishlist.WishlistFragment.articlesw;
import static com.crazy.booksoul.main.wishlist.WishlistFragment.intarticlew;
import static com.crazy.booksoul.main.wishlist.WishlistFragment.podcastw;
import static com.crazy.booksoul.main.wishlist.WishlistFragment.publisherw;
import static com.crazy.booksoul.main.wishlist.WishlistFragment.quicksw;

public class tabFragment extends Fragment implements ArticleAdapter.OnItemClicked {

    TextView catagory;
    CardView card;
    RecyclerView recycler, catagories, recyclerStart;
    private RecyclerView.Adapter aramAdapter, intmAdapter, QuiAdapter, IntStart, podmAdapter, PodStart, catmAdapter, catiAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final int NUM_COLUMNS = 1;
    SliderView sliderView;
    String nds;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    public tabFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = new Bundle();
        nds = nds + nonDuplicateString;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("my_preferences", MODE_PRIVATE);
        String text = sharedPreferences.getString(MY_PREFERENCES, "");
//        sliderView = view.findViewById(R.id.slider);
//        SliderAdapter adapter = new SliderAdapter(getActivity());
        final ArrayList<article> publish = new ArrayList<>();
        final ArrayList<article> podStart = new ArrayList<>();
        final ArrayList<article> intStart = new ArrayList<>();

        final ArrayList<article> articles = new ArrayList<>();
        final ArrayList<article> intarticle = new ArrayList<>();
        final ArrayList<article> podcast = new ArrayList<>();
        final ArrayList<article> quicks = new ArrayList<>();
        final ArrayList<article> quickStart = new ArrayList<>();

        final ArrayList<article> caregory_list = new ArrayList<>();

        recycler = view.findViewById(R.id.recycler);
        recyclerStart = view.findViewById(R.id.recyclerStart);
        recycler.setNestedScrollingEnabled(false);
        catagories = view.findViewById(R.id.CategoryRecyclerview);
        catagory = view.findViewById(R.id.textcatagory);
        card = view.findViewById(R.id.cardquick);
//        sliderView.setSliderAdapter(adapter);
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.YELLOW);
//        sliderView.setIndicatorUnselectedColor(Color.WHITE);
//        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
//        sliderView.startAutoCycle();
////for swipe view
//        adapter.addItem(new SliderItem("https://picsum.photos/id/57/300/400", "i know what you are"));
//        adapter.addItem(new SliderItem("https://picsum.photos/id/54/500/500", "stay in touch"));
//        adapter.addItem(new SliderItem("https://picsum.photos/id/78/500/500", "Motivated is like giving best to you"));
//        adapter.addItem(new SliderItem("https://picsum.photos/id/91/500/500", "im all ablove tofay just as you"));
//        adapter.addItem(new SliderItem("https://picsum.photos/id/71/500/500", "get sarted with everything you see"));
        String check = getArguments().getString("title");
        caregory_list.add(new article(CATEGORY, "Art & History"));
        caregory_list.add(new article(CATEGORY, "Lifestyle"));
        caregory_list.add(new article(CATEGORY, "Fashion"));
        caregory_list.add(new article(CATEGORY, "Traditional"));
        caregory_list.add(new article(CATEGORY, "Enterpeniors"));

        if (check == null) {

//intersting articles
            Log.e("str", str);

            //for intresting articles
//        example.add(new article("https://picsum.photos/id/73/200/300","you are what I know what you are"));
//
            intarticle.add(new article(INTERESTING_ARTICLE, "Get up early", "https://picsum.photos/id/256/200/300", "wad awdiuhasiudn ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 40));
            intarticle.add(new article(INTERESTING_ARTICLE, "To be better", "https://picsum.photos/id/132/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 44));
            intarticle.add(new article(INTERESTING_ARTICLE, "Once only", "https://picsum.photos/id/823/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 23));
            intarticle.add(new article(INTERESTING_ARTICLE, "Get up early", "https://picsum.photos/id/26/200/300", "wad awdiuhasiudn ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 45));
            intarticle.add(new article(INTERESTING_ARTICLE, "you are what I know what you are", "https://picsum.photos/id/627/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 76));
            intarticle.add(new article(INTERESTING_ARTICLE, "To be better", "https://picsum.photos/id/53/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 90));

            aramAdapter = new ArticleAdapter(intarticle, new ArticleAdapter.OnItemClicked() {
                @Override
                public void onItemClick(int position) {

                }
            }, getActivity());
            StaggeredGridLayoutManager staggeredGridLayoutManager2 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
            recycler.setAdapter(aramAdapter);
            recycler.setLayoutManager(staggeredGridLayoutManager2);
////
        } else {

            switch (check) {
                case "Article":
                    catagory.setVisibility(View.GONE);
                    catagories.setVisibility(View.GONE);
                    recyclerStart.setVisibility(View.GONE);
                    card.setVisibility(View.GONE);
                    ////for articleforyou recycler view
                    Log.e("str", str);
                    Log.e("i", check);
                    String currentDateandTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
                    Log.e("time", currentDateandTime);

                    articles.add(new article(ARTICLE, "you are what I know what you are", "https://picsum.photos/id/102/200/300", 3, 50, "ENTERPANIOR"));
                    articles.add(new article(ARTICLE, "Change the world as you wish", "https://picsum.photos/id/59/200/300", 5, 60, "MOTIVATION"));
                    articles.add(new article(ARTICLE, "Be wise and be brave", "https://picsum.photos/id/76/200/300", 4, 70, "SPORTS"));
                    articles.add(new article(ARTICLE, "You are important", "https://picsum.photos/id/73/200/300", 9, 0, "ENTERPANIOR"));
                    articles.add(new article(ARTICLE, "you are what I know what you are", "https://picsum.photos/id/4/200/300", 13, 0, "ENTERPANIOR"));
                    articles.add(new article(ARTICLE, "you are what I know what you are", "https://picsum.photos/id/516/200/300", 2, 0, "ENTERPANIOR"));
                    articles.add(new article(ARTICLE, "you are what I know what you are", "https://picsum.photos/id/98/200/300", 8, 0, "ENTERPANIOR"));
                    articles.add(new article(ARTICLE, "you are what I know what you are", "https://picsum.photos/id/982/200/300", 6, 0, "ENTERPANIOR"));

                    recycler.setHasFixedSize(true);
                    mLayoutManager = new LinearLayoutManager(getContext());
                    aramAdapter = new ArticleAdapter(articles, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {
                            articlesw.add(articles.get(position));
                            Bundle bundle = new Bundle();
                            bundle.putInt("type", articles.get(position).getViewtype());
                            bundle.putString("title", articles.get(position).getTitle());
                            bundle.putString("imageurl", articles.get(position).getImageUrl());
                            bundle.putInt("discription", articles.get(position).getDiscription());
                            bundle.putInt("progress", articles.get(position).getProgressBar());
                            bundle.putString("topic", articles.get(position).getTopic());

                            WishlistFragment fragmentObject = new WishlistFragment();
                            fragmentObject.setArguments(bundle);
////                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//////                        transaction.replace(R.id.nav_host_fragment, fragmentObject);
////                        transaction.commit();

                        }
                    }, getActivity());

                    Log.d("TAGggggggggggggggggg", text);
                    StaggeredGridLayoutManager staggeredGridLayoutManager1 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                    recycler.setLayoutManager(staggeredGridLayoutManager1);
                    recycler.setAdapter(aramAdapter);


                    break;
                case "Inspire Me":
//                intrestingArticles = view.findViewById(R.id.recycler);
//intersting articles
                    Log.e("str", str);
                    Log.e("i", check);
//                catagory.setVisibility(View.GONE);
//                catagories.setVisibility(View.GONE);
//                recyclerStart.setVisibility(View.GONE);
                    card.setVisibility(View.GONE);

                    //for intresting articles
//        example.add(new article("https://picsum.photos/id/73/200/300","you are what I know what you are"));
//
                    intarticle.add(new article(INTERESTING_ARTICLE, "Get up early", "https://picsum.photos/id/256/200/300", "wad awdiuhasiudn ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 40));
                    intarticle.add(new article(INTERESTING_ARTICLE, "To be better", "https://picsum.photos/id/533/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 90));

                    intarticle.add(new article(INTERESTING_ARTICLE, "be better", "https://picsum.photos/id/132/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 44));
                    intarticle.add(new article(INTERESTING_ARTICLE, "Once only", "https://picsum.photos/id/823/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 23));
                    intarticle.add(new article(INTERESTING_ARTICLE, "Get up early", "https://picsum.photos/id/26/200/300", "wad awdiuhasiudn ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 45));
                    intarticle.add(new article(INTERESTING_ARTICLE, "you are what I know what you are", "https://picsum.photos/id/627/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 76));
                    intarticle.add(new article(INTERESTING_ARTICLE, "To be better", "https://picsum.photos/id/53/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 90));
                    intarticle.add(new article(INTERESTING_ARTICLE, "Get up early", "https://picsum.photos/id/236/200/300", "wad awdiuhasiudn ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 0));
                    intarticle.add(new article(INTERESTING_ARTICLE, "To be better", "https://picsum.photos/id/122/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 0));
                    intarticle.add(new article(INTERESTING_ARTICLE, "Once only", "https://picsum.photos/id/873/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 0));
                    intarticle.add(new article(INTERESTING_ARTICLE, "Get up early", "https://picsum.photos/id/126/200/300", "wad awdiuhasiudn ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 0));
                    intarticle.add(new article(INTERESTING_ARTICLE, "you are what I know what you are", "https://picsum.photos/id/227/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 0));
                    intarticle.add(new article(INTERESTING_ARTICLE, "To be better", "https://picsum.photos/id/523/200/300", "njfena ehf heiuhf ehf iehf iehf eiuf ie what I know what you are", 0));

                    intmAdapter = new ArticleAdapter(intarticle, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {
                            intarticlew.add(intarticle.get(position));

                        }
                    }, getActivity());
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                    recycler.setAdapter(intmAdapter);
                    recycler.setLayoutManager(staggeredGridLayoutManager2);

                    intStart.add(new article(INTERESTING_ARTICLE, "Get Set and Go", "https://picsum.photos/id/453/200/300", "take a min to listen the best" +
                            "", 0));

//        Categories
                    catagories.setHasFixedSize(true);
                    catiAdapter = new ArticleAdapter(caregory_list, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {

                        }
                    }, getActivity());
                    StaggeredGridLayoutManager staggered2 = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
                    catagories.setLayoutManager(staggered2);
                    catagories.setAdapter(catiAdapter);

//                Start recyclerview
                    recyclerStart.setHasFixedSize(true);

                    IntStart = new ArticleAdapter(intStart, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {
                            podcastw.add(podStart.get(position));
                        }
                    }, getActivity());
                    StaggeredGridLayoutManager staggered3 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                    recyclerStart.setLayoutManager(staggered3);
                    recyclerStart.setAdapter(IntStart);


////interface
                    break;
                case "Podcasts":
                    Log.e("i", check);
                    card.setVisibility(View.GONE);


//                podcasts = view.findViewById(R.id.recycler);
// podcast
                    podcast.add(new article(PODCAST, "To be better know all you wanna know", "https://picsum.photos/id/856/200/300", "10 min listen ", 45));
                    podcast.add(new article(PODCAST, "Get Set and Go", "https://picsum.photos/id/813/200/300", "30 min listen ", 60));
                    podcast.add(new article(PODCAST, "Better know all you wanna know", "https://picsum.photos/id/556/200/300", "10 min listen ", 30));
                    podcast.add(new article(PODCAST, "All you wanna know", "https://picsum.photos/id/216/200/300", "20 min listen ", 45));
                    podcast.add(new article(PODCAST, "To be better know all you wanna know", "https://picsum.photos/id/276/200/300", "10 min listen", 34));

                    podcast.add(new article(PODCAST, "To be better know all you wanna know", "https://picsum.photos/id/876/200/300", "10 min listen ", 45));
                    podcast.add(new article(PODCAST, "Get Set and Go", "https://picsum.photos/id/816/200/300", "30 min listen ", 0));
                    podcast.add(new article(PODCAST, "Better know all you wanna know", "https://picsum.photos/id/576/200/300", "10 min listen ", 0));
                    podcast.add(new article(PODCAST, "All you wanna know", "https://picsum.photos/id/116/200/300", "20 min listen ", 0));
                    podcast.add(new article(PODCAST, "To be better know all you wanna know", "https://picsum.photos/id/176/200/300", "10 min listen", 0));

                    podStart.add(new article(PODCAST, "Get Set and Go", "https://picsum.photos/id/826/200/300", "30 min listen ", 0));

                    recycler.setHasFixedSize(true);

                    podmAdapter = new ArticleAdapter(podcast, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {
                            podcastw.add(podcast.get(position));
                        }
                    }, getActivity());
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                    recycler.setLayoutManager(staggeredGridLayoutManager3);
                    recycler.setAdapter(podmAdapter);

//        Categories
                    catagories.setHasFixedSize(true);
                    catmAdapter = new ArticleAdapter(caregory_list, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {

                        }
                    }, getActivity());
                    StaggeredGridLayoutManager staggered1 = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
                    catagories.setLayoutManager(staggered1);
                    catagories.setAdapter(catmAdapter);

//                Start recyclerview
                    recyclerStart.setHasFixedSize(true);

                    PodStart = new ArticleAdapter(podStart, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {
                            podcastw.add(podStart.get(position));
                        }
                    }, getActivity());
                    StaggeredGridLayoutManager staggered4 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                    recyclerStart.setLayoutManager(staggered4);
                    recyclerStart.setAdapter(PodStart);


                    break;
                case "Quicks":
                    Log.e("i", check);
                    Log.e("i2", check);

                    quicks.add(new article(QUICKS, "Get up early", "https://picsum.photos/id/266/200/300", "Poule Colo ", 54));
                    quicks.add(new article(QUICKS, "To be better", "https://picsum.photos/id/182/200/300", "Tikka Masala", 64));
                    quicks.add(new article(QUICKS, "Once only", "https://picsum.photos/id/723/300", "Lelo Barn", 66));
                    quicks.add(new article(QUICKS, "Get up early", "https://picsum.photos/id/296/200/300", "Wad Fadd", 56));
                    quicks.add(new article(QUICKS, "you are what I know what you are", "https://picsum.photos/id/67/200/300", "Yarn Defer ", 45));
                    quicks.add(new article(QUICKS, "To be better", "https://picsum.photos/id/571/200/300", "Chillo Pie", 70));
                    quicks.add(new article(QUICKS, "Get up early", "https://picsum.photos/id/276/200/300", "wad awdiuhasiudn ", 54));
                    quicks.add(new article(QUICKS, "To be better", "https://picsum.photos/id/172/200/300", "njfena ehf", 0));
                    quicks.add(new article(QUICKS, "Once only", "https://picsum.photos/id/773/300", "njfena ehf heiuhf", 0));
                    quicks.add(new article(QUICKS, "Get up early", "https://picsum.photos/id/276/200/300", "wad awdiuhasiudn", 0));
                    quicks.add(new article(QUICKS, "you are what I know what you are", "https://picsum.photos/id/677/200/300", "njfena ", 0));
                    quicks.add(new article(QUICKS, "To be better", "https://picsum.photos/id/571/200/300", "njfena ehf", 0));


                    QuiAdapter = new ArticleAdapter(quicks, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {
                            quicksw.add(quicks.get(position));
                        }
                    }, getActivity());
                    StaggeredGridLayoutManager staggeredGridLayoutManager6 = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
                    recycler.setLayoutManager(staggeredGridLayoutManager6);

                    recycler.setAdapter(QuiAdapter);

//        Categories
                    catagories.setHasFixedSize(true);
                    catmAdapter = new ArticleAdapter(caregory_list, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {

                        }
                    }, getActivity());
                    StaggeredGridLayoutManager staggered = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
                    catagories.setLayoutManager(staggered);
                    catagories.setAdapter(catmAdapter);

//

                    recyclerStart.setVisibility(View.GONE);
                    break;
                case "Publishers":
                    catagory.setVisibility(View.GONE);
                    catagories.setVisibility(View.GONE);
                    recyclerStart.setVisibility(View.GONE);
                    card.setVisibility(View.GONE);

                    publish.add(new article(PUBLISHER, "Get what you are from the better one always", "https://picsum.photos/id/23/200/300", "Dan Troy", 70));
                    publish.add(new article(PUBLISHER, "You are what I know what you are", "https://picsum.photos/id/133/200/300", "Lawboy Troy", 30));
                    publish.add(new article(PUBLISHER, "I know that", "https://picsum.photos/id/143/200/300", "Sikk D", 50));
                    publish.add(new article(PUBLISHER, "Well you dont", "https://picsum.photos/id/153/200/300", "Broo Y", 20));
                    publish.add(new article(PUBLISHER, "getting things dome by tommorow", "https://picsum.photos/id/163/200/300", "Dan Troy", 0));
                    publish.add(new article(PUBLISHER, "I know what you are", "https://picsum.photos/id/173/200/300", "Troy", 0));
                    publish.add(new article(PUBLISHER, "Are what I know what you are", "https://picsum.photos/id/183/200/300", "DAN TROY", 0));
                    publish.add(new article(PUBLISHER, "you najenfkjnefknsjkf are", "https://picsum.photos/id/193/200/300", "DAN TROY", 0));
                    publish.add(new article(PUBLISHER, "you are what I know what you are", "https://picsum.photos/id/13/200/300", "DAN TROY", 0));

                    recycler.setHasFixedSize(true);
                    mLayoutManager = new LinearLayoutManager(getContext());
                    aramAdapter = new ArticleAdapter(publish, new ArticleAdapter.OnItemClicked() {
                        @Override
                        public void onItemClick(int position) {
                            publisherw.add(publish.get(position));
                        }
                    }, getActivity());
                    StaggeredGridLayoutManager staggeredGridLayoutManager5 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                    recycler.setLayoutManager(staggeredGridLayoutManager5);
                    recycler.setAdapter(aramAdapter);


                    break;
                default:
                    Log.e("i", check);

                    return;

            }
        }

// podcasts

    }

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String TEXT = "ahhsaushhuuashu";
    private static final String KEY = "myKey";

    public static void saveData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY, TEXT);
        editor.apply();
    }

    public static String loadData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String text = sharedPreferences.getString(KEY, "");
        return text;
    }

    @Override
    public void onItemClick(int position) {

    }
}