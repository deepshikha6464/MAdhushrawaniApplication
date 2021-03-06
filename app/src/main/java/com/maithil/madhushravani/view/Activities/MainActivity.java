package com.maithil.madhushravani.view.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.transition.Explode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.view.dashboard.dashboard;
import com.maithil.madhushravani.view.explore.Day1Fragment;
import com.maithil.madhushravani.view.explore.Explore;
import com.maithil.madhushravani.view.post.PostFragment;
import com.maithil.madhushravani.view.profile.ProfileFragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener ,BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    //ui

    FrameLayout fragContainer;
    BottomNavigationView bottomNavigationView;
GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        setContentView(R.layout.activity_main);

        findViewbyid();
        loadFragment(new Explore());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setScrollbarFadingEnabled(true);
getCurrentToken();
// Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-9640227971551003~6929517738");

    }


    private void findViewbyid(){
         fragContainer = findViewById(R.id.fragment_container);
          bottomNavigationView = findViewById(R.id.bottom_navigation);

    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
//                    .setCustomAnimations(R.animator.slide_in_top,R.animator.slide_out_top)
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
//
        return false;
    }
  @Override
    public void onClick(View view) {


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                fragment = new Explore();
                break;

            case R.id.navigation_explore:
                fragment = new dashboard();
                break;

            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;
            case R.id.lang:
                Log.d(TAG, "lan button: ");
                languageChange();
                restartActivity();
                break;
        }
        return loadFragment(fragment);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        return true;
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if(bottomNavigationView.getSelectedItemId() == R.id.navigation_home){

            Fragment f = this.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if(f instanceof Day1Fragment) {
                // do something with f
                Log.d(TAG, "onBackPressed: ");
                getSupportFragmentManager().beginTransaction().remove(f).commit();

            }
            finishAffinity();

        }else{
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }
    }

    public void getCurrentToken(){

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

//                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
//                        Log.d(TAG, msg);
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    private  void languageChange(){
        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale("hi");
        res.updateConfiguration(conf, dm);

        Toast.makeText(this, "Language Changed ", Toast.LENGTH_SHORT).show();
    }
}
