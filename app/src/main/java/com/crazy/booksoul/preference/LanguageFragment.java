package com.crazy.booksoul.preference;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crazy.booksoul.MainActivity;
import com.crazy.booksoul.R;

import java.util.Locale;

import static androidx.core.app.ActivityCompat.recreate;
import static androidx.core.content.ContextCompat.getDrawable;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class LanguageFragment extends Fragment {

    Button explore;
    RelativeLayout english,hindi;


    public LanguageFragment() {
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
        return inflater.inflate(R.layout.fragment_language, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController= Navigation.findNavController(view);
        explore=view.findViewById(R.id.explore);
        english=view.findViewById(R.id.english);
        hindi=view.findViewById(R.id.hindi);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(getContext(), MainActivity.class));
                LanguageActivity.seekBar.setProgress((int) 2);

                navController.navigate(R.id.action_languageFragment_to_preferenceFragment);
            }

        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                recreate();
                setAppLocale("en");
                LanguageActivity.seekBar.setProgress((int) 1);

                english.setBackground(getDrawable(getContext(),R.drawable.filled_border2));
                hindi.setBackground(getDrawable(getContext(),R.color.Articles));
                Toast toast = Toast.makeText(getContext(),R.string.toast_language, Toast.LENGTH_SHORT);
                View v = toast.getView();
                english.setElevation(10);
                hindi.setElevation(5);
                explore.setEnabled(true);
//                recreate(getActivity());
//                explore.setEnabled(true);

                setAppLocale("en");
//Gets the actual oval background of the Toast then sets the colour filter
                v.getBackground().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
//Gets the TextView from the Toast so it can be editted
                TextView text = v.findViewById(android.R.id.message);
                text.setTextColor(Color.YELLOW);

                toast.show();

                setAppLocale("en");
            }

        });
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAppLocale("hi");
                LanguageActivity.seekBar.setProgress((int) 1);

                hindi.setBackground(getDrawable(getContext(),R.drawable.filled_border2));
                english.setBackground(getDrawable(getContext(),R.color.Articles));
                english.setElevation(5);
                hindi.setElevation(10);
                explore.setEnabled(true);

//                recreate(getActivity());
//                explore.setEnabled(true);

                setAppLocale("hi");
                //COLORED TOAST
                Toast toast = Toast.makeText(getContext(),R.string.toast_language, Toast.LENGTH_SHORT);
                View v = toast.getView();
//Gets the actual oval background of the Toast then sets the colour filter
                v.getBackground().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
//Gets the TextView from the Toast so it can be editted
                TextView text = v.findViewById(android.R.id.message);
                text.setTextColor(Color.YELLOW);
                toast.show();


                setAppLocale("hi");
            }

        });
    }

    //LANGUAGE CHANGE FOR THE APP USING:  LOCALE APP RESOURCE

    protected void setAppLocale(String LocaleCode){
        Resources resources=getResources();
        DisplayMetrics displayMetrics=resources.getDisplayMetrics();
        Configuration configuration=resources.getConfiguration();
        configuration.setLocale(new Locale(LocaleCode.toLowerCase()));
        resources.updateConfiguration(configuration,displayMetrics);
    }
}