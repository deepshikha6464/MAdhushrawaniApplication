package com.maithil.madhushravani.view.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Layout;
import android.transition.Explode;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.view.dashboard.dashboard;
import com.maithil.madhushravani.view.explore.Day1Fragment;
import com.maithil.madhushravani.view.explore.Explore;
import com.maithil.madhushravani.view.post.PostFragment;
import com.maithil.madhushravani.view.profile.ProfileFragment;

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
//


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
}
