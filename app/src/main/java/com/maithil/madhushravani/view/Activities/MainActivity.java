package com.maithil.madhushravani.view.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Layout;
import android.transition.Explode;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.view.dashboard.dashboard;
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
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
// set an exit transition
        getWindow().setExitTransition(new Explode());

        findViewbyid();
        setToolBar();
        loadFragment(new dashboard());
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
                    .setCustomAnimations(R.animator.slide_in_bottom,R.animator.slide_out_bottom,R.animator.slide_in_top,R.animator.slide_out_top)
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
                fragment = new dashboard();
                break;

            case R.id.navigation_explore:
                fragment = new Explore();
                break;

            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;
//            case R.id.navigation_write:
//                fragment = new PostFragment();
//                break;
        }
        return loadFragment(fragment);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.toolbar_contextual, menu);
//        return true;
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String btnName = null;
//        switch(itemId) {
//            case R.id.menu_settings:
//                btnName = "Settings";
//                break;
//            case R.id.menu_compass:
//                btnName = "Compass";
//                break;
//            case R.id.menu_help:
//                btnName = "Help";
//                break;
//        }
//        Snackbar.make(layout, "Button " + btnName, Snackbar.LENGTH_SHORT).show();
        return true;
    }
    private void setToolBar() {
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        tb.setLogo(R.drawable.logo_text);
//                ActionBar ab = getSupportActionBar();
//        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
//        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
