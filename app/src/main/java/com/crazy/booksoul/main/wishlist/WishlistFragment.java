package com.crazy.booksoul.main.wishlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.crazy.booksoul.R;
import com.crazy.booksoul.main.home.ArticleAdapter;
import com.crazy.booksoul.main.home.article;

import java.util.ArrayList;


public class WishlistFragment extends Fragment {

    RecyclerView article, podcasts, quick, publishers, inspire;
    ImageView imageNon;
    TextView t1,t2,t3,t4,t5,textnon;
    private RecyclerView.Adapter mAdapter, getmAdapter, podmAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final int NUM_COLUMNS = 1;
    public static ArrayList<article> articlesw = new ArrayList<>();
    public static ArrayList<article> intarticlew = new ArrayList<>();
    public static ArrayList<article> podcastw = new ArrayList<>();
    public static ArrayList<article> quicksw = new ArrayList<>();
    public static ArrayList<article> publisherw = new ArrayList<>();

    LinearLayout linearLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_saved, container, false);

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        article = view.findViewById(R.id.ArticleRecyc);
        podcasts = view.findViewById(R.id.PodcastRecyc);
        quick = view.findViewById(R.id.QuicksRecyc);
        publishers = view.findViewById(R.id.PublisherRecyc);
        inspire = view.findViewById(R.id.InspireRecyc);

        imageNon = view.findViewById(R.id.image_nonsaved);
        textnon = view.findViewById(R.id.text_nonsaved);

        linearLayout=view.findViewById(R.id.linearw);
        t1=view.findViewById(R.id.tecta);
        t2=view.findViewById(R.id.tecti);
        t3=view.findViewById(R.id.tectp);
        t4=view.findViewById(R.id.tectq);
        t5=view.findViewById(R.id.tectpub);






//recieving Bundle

//        Intent intent = getActivity().getIntent();
//        int viewtype = getArguments().getInt("type");
//        String TiTle = getArguments().getString("title");
//        int Progress = getArguments().getInt("progress");
//        String topic = getArguments().getString("topic");
//        int time = getArguments().getInt("discription");
//        String IMGurl = getArguments().getString("imageurl");

//        bundle.putString("title", articles.get(position).getTitle());
//        bundle.putString("imageurl", articles.get(position).getImageUrl());
//        bundle.putInt("discription", articles.get(position).getDiscription());
//        bundle.putInt("progress",articles.get(position).getProgressBar());
//        bundle.putString("topic", articles.get(position).getTopic());
//        selected.add((article) args.getSerializable("type"));

//        switch (viewtype) {
//            case ARTICLE:
//                articlesw.add(new article(viewtype, TiTle, IMGurl, time, Progress, topic));
//                break;
//            case INTERESTING_ARTICLE:
//                intarticlew.add(new article(viewtype, TiTle, IMGurl, time, Progress, topic));
//                break;
//            case PODCAST:
//                podcastw.add(new article(viewtype, TiTle, IMGurl, time, Progress, topic));
//                break;
//            case QUICKS:
//                quicksw.add(new article(viewtype, TiTle, IMGurl, time, Progress, topic));
//                break;
//            case PUBLISHER:
//                publisherw.add(new article(viewtype, TiTle, IMGurl, time, Progress, topic));
//                break;
//        }

        if ((articlesw.size() != 0) || (intarticlew.size() != 0) ||  (podcastw.size() != 0) || (quicksw.size() != 0)|| (publisherw.size() != 0)) {
            imageNon.setVisibility(View.INVISIBLE);
            textnon.setVisibility(View.INVISIBLE);

            linearLayout.setVisibility(View.VISIBLE);

            if(articlesw.size() != 0) {
//            Articles adding
                t1.setVisibility(View.VISIBLE);
                article.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(getContext());
                mAdapter = new ArticleAdapter(articlesw, new ArticleAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {

                    }
                }, getActivity());
                StaggeredGridLayoutManager staggeredGridLayoutManager1 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                article.setLayoutManager(staggeredGridLayoutManager1);
                article.setAdapter(mAdapter);
            }
            if(intarticlew.size() != 0) {
//           Inspire adding
                t2.setVisibility(View.VISIBLE);

                getmAdapter = new ArticleAdapter(intarticlew, new ArticleAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {

                    }
                }, getActivity());
                StaggeredGridLayoutManager staggeredGridLayoutManager2 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                inspire.setAdapter(getmAdapter);
                inspire.setLayoutManager(staggeredGridLayoutManager2);
            }
            if(podcastw.size() != 0) {
//            Podcasts adding
                t3.setVisibility(View.VISIBLE);

                podcasts.setHasFixedSize(true);

                podmAdapter = new ArticleAdapter(podcastw, new ArticleAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {

                    }
                }, getActivity());
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                podcasts.setLayoutManager(staggeredGridLayoutManager3);
                podcasts.setAdapter(podmAdapter);
            }
            if(quicksw.size() != 0) {
//            Quicks
                t4.setVisibility(View.VISIBLE);

                quick.setHasFixedSize(true);

                getmAdapter = new ArticleAdapter(quicksw, new ArticleAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {

                    }
                }, getActivity());
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
                quick.setLayoutManager(staggeredGridLayoutManager4);

                quick.setAdapter(getmAdapter);
            }
            if(publisherw.size() != 0) {
//            Publisher
                t5.setVisibility(View.VISIBLE);

                publishers.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(getContext());
                mAdapter = new ArticleAdapter(publisherw, new ArticleAdapter.OnItemClicked() {
                    @Override
                    public void onItemClick(int position) {

                    }
                }, getActivity());
                StaggeredGridLayoutManager staggeredGridLayoutManager5 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
                publishers.setLayoutManager(staggeredGridLayoutManager5);
                publishers.setAdapter(mAdapter);
            }
        }

    }

}