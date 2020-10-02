package com.crazy.booksoul.preference;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.crazy.booksoul.MainActivity;
import com.crazy.booksoul.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class PreferenceFragment extends Fragment {
    public static String str = " ";
    public static String nonDuplicateString;

    Button next;
    RecyclerView prefrence;
    private RecyclerView.Adapter mAdapter, getmAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final int NUM_COLUMNS = 4;

    public PreferenceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preference, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        next = view.findViewById(R.id.pref_next);
        prefrence = view.findViewById(R.id.pref_recycler);
        next.setEnabled(true);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str.split("\\w+").length >= 5) {
                    Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(),
                            android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                    startActivity(new Intent(getActivity(), MainActivity.class),bundle);
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    getActivity().getSharedPreferences("run", MODE_PRIVATE).edit()
                            .putBoolean("isFirstRun", false).commit();
                    getActivity().getSharedPreferences("my_preferences",MODE_PRIVATE).edit().putString("MYLABEL", nonDuplicateString).apply();

                } else
                    Toast.makeText(getContext(), "Please select five preferences", Toast.LENGTH_SHORT).show();

                String[] words = str.split("\\W+");
                StringBuilder stringBuilder = new StringBuilder();
                Set<String> wordsHashSet = new HashSet<>();

                for (String word : words) {
                    // Check for duplicates
                    if (wordsHashSet.contains(word.toLowerCase())) continue;

                    wordsHashSet.add(word.toLowerCase());
                    stringBuilder.append(word).append(" ");
                }
                 nonDuplicateString = stringBuilder.toString().trim();
//                Toast.makeText(getContext(), Integer.toString(nonDuplicateString.split("\\w+").length) , Toast.LENGTH_SHORT).show();

            }
        });
        ArrayList<prefrence> exampleList = new ArrayList<>();
        //for articleforyou recycler view
        exampleList.add(new prefrence("Entrepreneur", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Science", R.drawable.english_icon));
        exampleList.add(new prefrence("Relationship", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Creativity", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Travelling", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Art & History", R.drawable.english_icon));
        exampleList.add(new prefrence("Modern Science", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Spiritual", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Architecture", R.drawable.hindi_icon));
        exampleList.add(new prefrence("School", R.drawable.english_icon));
        exampleList.add(new prefrence("Modern Science", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Architecture", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Entrepreneur", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Travelling", R.drawable.english_icon));
        exampleList.add(new prefrence("Relationship", R.drawable.hindi_icon));
        exampleList.add(new prefrence("Creativity", R.drawable.hindi_icon));


        prefrence.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new PrefrenceAdapter(exampleList, getActivity());
        StaggeredGridLayoutManager staggeredGridLayoutManager1 = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.HORIZONTAL);
        prefrence.setLayoutManager(staggeredGridLayoutManager1);
        prefrence.setAdapter(mAdapter);


    }

}