package com.maithil.madhushravani.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.gtomato.android.ui.transformer.FlatMerryGoRoundTransformer;
import com.gtomato.android.ui.widget.CarouselView;
import com.maithil.madhushravani.utils.MyDataAdapter;
import com.maithil.madhushravani.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener ,BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    //ui

    FrameLayout fragContainer;

    BottomNavigationView bottomNavigationView;


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

        loadFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



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
                fragment = new HomeFragment();
                break;

            case R.id.navigation_explore:
                fragment = new ExploreFragment();
                break;

            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }


}
