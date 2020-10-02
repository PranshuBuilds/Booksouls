package com.crazy.booksoul.main;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.crazy.booksoul.R;
import com.crazy.booksoul.main.home.tabFragment;

/**
 * Created by Priyabrat on 21-08-2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public static String str;
    Context context;
    public ViewPagerAdapter(FragmentManager fm ,Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        tabFragment fragment = new tabFragment();

        switch (position) {
            case 0:

                Bundle homeBundle = new Bundle();
                homeBundle.putString("title","Article");
// Your Key must same when you get your values in Fragment Home
                fragment.setArguments(homeBundle);
                return fragment;
            case 1:
                Bundle b1 = new Bundle();
                b1.putString("title","Inspire Me");
// Your Key must same when you get your values in Fragment Home
                fragment.setArguments(b1);
                return fragment;
            case 2:
                Bundle b2 = new Bundle();
                b2.putString("title","Podcasts");
// Your Key must same when you get your values in Fragment Home
                fragment.setArguments(b2);
                return fragment;
            case 3:
                Bundle b3 = new Bundle();
                b3.putString("title","Quicks");
// Your Key must same when you get your values in Fragment Home
                fragment.setArguments(b3);
                return fragment;
            case 4:
                Bundle b4 = new Bundle();
                b4.putString("title","Publishers");
// Your Key must same when you get your values in Fragment Home
                fragment.setArguments(b4);
                return fragment;


                default:
                    Bundle bd = new Bundle();
                    bd.putString("title","none");
// Your Key must same when you get your values in Fragment Home
                    fragment.setArguments(bd);
                    return  fragment;
        }

 //All tabs
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        str="string";
        String settitle1 = context.getResources().getString(R.string.tab_article);
        String settitle2 = context.getResources().getString(R.string.tab_inspire);
        String settitle3 = context.getResources().getString(R.string.home_podcasts);
        String settitle4 = context.getResources().getString(R.string.tab_quicks);
        String settitle5 = context.getResources().getString(R.string.tab_publishers);


        String tabtitles[] = new String[] { settitle1, settitle2 ,settitle3, settitle4,settitle5};

        return tabtitles[position];

    }
}
