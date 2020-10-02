package com.crazy.booksoul;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.crazy.booksoul.preference.LanguageActivity;
import com.crazy.booksoul.preference.LoginFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import static com.crazy.booksoul.preference.PreferenceFragment.nonDuplicateString;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
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
    }
