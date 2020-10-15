package com.crazy.booksoul.preference;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.crazy.booksoul.MainActivity;
import com.crazy.booksoul.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static android.content.Context.MODE_PRIVATE;
import static com.crazy.booksoul.preference.LanguageActivity.seekBar;
import static com.crazy.booksoul.preference.PreferenceFragment.nonDuplicateString;

public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    Toolbar toolbar;
    TextView Register;
    Button explore;
    CallbackManager callbackManager;
    LoginButton loginButton;

    public static final String MY_PREFERENCES = "my_preferences";
    private static final String RUN = "run";
    public LoginFragment() {
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        explore=view.findViewById(R.id.explore);
        loginButton=view.findViewById(R.id.fblogin_button);
        Register=view.findViewById(R.id.register);
        final NavController navController= Navigation.findNavController(view);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_loginFragment2_to_signUpFragment);
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getContext(),
                        android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(new Intent(getActivity(), MainActivity.class),bundle);
            }
        });
        FacebookSdk.sdkInitialize(FacebookSdk.getApplicationContext());
        callbackManager= CallbackManager.Factory.create();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {


                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }

                });
            }
        }
        );

    }
    private void handleFacebookToken(AccessToken accessToken){
//        FacebookSdk.getA
    }
}