package com.crazy.booksoul.preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.crazy.booksoul.MainActivity;
import com.crazy.booksoul.R;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
Button explore,english,hindi;
static SeekBar seekBar;
static TextView lang,pref,done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        seekBar=findViewById(R.id.prefr_seek);
        lang=findViewById(R.id.lang);
        pref=findViewById(R.id.pref);
        done=findViewById(R.id.done);

//        getWindow().setBackgroundDrawableResource(R.drawable.gb_both_blue);
        seekBar.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


    }
//    //LANGUAGE CHANGE FOR THE APP USING LOCALE APP RESOURCE
//
//    protected void setAppLocale(String LocaleCode){
//        Resources resources=getResources();
//        DisplayMetrics displayMetrics=resources.getDisplayMetrics();
//        Configuration configuration=resources.getConfiguration();
//        configuration.setLocale(new Locale(LocaleCode.toLowerCase()));
//        resources.updateConfiguration(configuration,displayMetrics);
//    }


}