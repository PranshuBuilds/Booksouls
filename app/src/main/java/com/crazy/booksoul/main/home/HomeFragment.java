package com.crazy.booksoul.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.crazy.booksoul.R;
import com.crazy.booksoul.main.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {


    static TabLayout tabLayout;
    static ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout =  root.findViewById(R.id.tabs);
        viewPager =  root.findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),getContext());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

//        tabLayout.setElevation(10);


        return root;
    }

}