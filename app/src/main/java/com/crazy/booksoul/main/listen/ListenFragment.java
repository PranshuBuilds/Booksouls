package com.crazy.booksoul.main.listen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.crazy.booksoul.R;
import com.crazy.booksoul.main.ViewAdapterListen;
import com.crazy.booksoul.main.home.ArticleAdapter;
import com.crazy.booksoul.main.home.article;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import static com.crazy.booksoul.main.home.article.CATEGORY;
import static com.crazy.booksoul.main.home.article.CURATED;
import static com.crazy.booksoul.main.home.article.UPDATED;

public class ListenFragment extends Fragment {

    RecyclerView curated, updated ,categories;
    static TabLayout tabLayout;
    static ViewPager viewPager;
    private RecyclerView.Adapter curatedAdapter, updatedAdapter,catAdapter, podmAdapter;
    ViewAdapterListen viewPagerAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_listen, container, false);

        viewPagerAdapter = new ViewAdapterListen(getChildFragmentManager(),getContext());

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<article> curated_list = new ArrayList<>();
        final ArrayList<article> updated_list = new ArrayList<>();
        final ArrayList<article> carogary_list = new ArrayList<>();

        curated=view.findViewById(R.id.CuratedRecyc);
        categories=view.findViewById(R.id.CategoryRecyc);
        updated=view.findViewById(R.id.UpdatedRecyc);

//        curated just for u
        curated_list.add(new article(CURATED, "Well you dont", "https://picsum.photos/id/103/200/300","Ep 01 ft. Tall guy",20));
        curated_list.add(new article(CURATED, "I know that", "https://picsum.photos/id/78/200/300","Ep 01 ft. Tall guy",50));
        curated_list.add(new article(CURATED, "You are what I know what you are", "https://picsum.photos/id/913/200/300","Ep 01 ft. Tall guy",30));
        curated_list.add(new article(CURATED, "Get what you are from the better one always", "https://picsum.photos/id/208/200/300","Ep 01 ft. Tall guy",70));
        curated_list.add(new article(CURATED, "Getting things dome by tommorow", "https://picsum.photos/id/151/200/300","Ep 01 ft. Tall guy",0));

        curated.setHasFixedSize(true);
        curatedAdapter = new ArticleAdapter(curated_list, new ArticleAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {

            }
        }, getActivity());
        StaggeredGridLayoutManager staggeredGridLayoutManager5 = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        curated.setLayoutManager(staggeredGridLayoutManager5);
        curated.setAdapter(curatedAdapter);

//

        carogary_list.add(new article(CATEGORY, "Art & History"));
        carogary_list.add(new article(CATEGORY, "Lifestyle"));
        carogary_list.add(new article(CATEGORY, "Fashion"));
        carogary_list.add(new article(CATEGORY, "Traditional"));
        carogary_list.add(new article(CATEGORY, "Enterpeniors"));

//        Categories
        categories.setHasFixedSize(true);
        catAdapter = new ArticleAdapter(carogary_list, new ArticleAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {

            }
        }, getActivity());
        StaggeredGridLayoutManager staggeredGridLayoutManager1 = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        categories.setLayoutManager(staggeredGridLayoutManager1);
        categories.setAdapter(catAdapter);

//
//        updated just for you
//
        updated_list.add(new article(UPDATED, "Get what you are from the better one always", "https://picsum.photos/id/293/200/300","Ep 01 ft. Tall guy",70));
        updated_list.add(new article(UPDATED, "Getting things dome by tommorow", "https://picsum.photos/id/77/200/300","Ep 01 ft. Tall guy",0));
        updated_list.add(new article(UPDATED, "You are what I know what you are", "https://picsum.photos/id/393/200/300","Ep 01 ft. Tall guy",30));
        updated_list.add(new article(UPDATED, "I know that", "https://picsum.photos/id/292/200/300","Ep 01 ft. Tall guy",50));
        updated_list.add(new article(UPDATED, "Well you dont", "https://picsum.photos/id/153/200/300","Ep 01 ft. Tall guy",20));

        updated.setHasFixedSize(true);
        updatedAdapter = new ArticleAdapter(updated_list, new ArticleAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {

            }
        }, getActivity());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        updated.setLayoutManager(staggeredGridLayoutManager);
        updated.setAdapter(updatedAdapter);
    }
}