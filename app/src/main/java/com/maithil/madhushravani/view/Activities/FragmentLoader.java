package com.maithil.madhushravani.view.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.Window;

import com.maithil.madhushravani.R;
import com.maithil.madhushravani.view.explore.AripanFragment;
import com.maithil.madhushravani.view.explore.Day1Fragment;
import com.maithil.madhushravani.view.explore.Day2_14;
import com.maithil.madhushravani.view.explore.PictureRead;
import com.maithil.madhushravani.view.explore.poojaFragment;

public class FragmentLoader extends AppCompatActivity {
    private static final String TAG = "FragmentLoader";
    Bundle b;
    Day2_14 f = new Day2_14();
    AripanFragment f1 = new AripanFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        getWindow().setEnterTransition(new Explode());
        setContentView(R.layout.activity_fragment_loader);




        String value = getIntent().getExtras().getString("FragName");
        Log.d(TAG, "onCreate: "+ value);

        switch (value){


            case "biniPicture":
                getSupportFragmentManager()
                        .beginTransaction()
//                        .setCustomAnimations(R.animator.slide_in_top,R.animator.slide_out_top)
                        .replace(R.id.fragment_container, new PictureRead())
                        .commit();
                break;
            case "aripan":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "aripan");
                f1.setArguments(b);
                loadFragmentImage(f1);
                break;
            case "fulLodhi":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "fulLodhi");
                f1.setArguments(b);
                loadFragmentImage(f1);
                break;
            case "gauri":
                            b = new Bundle();
                            b.putString("UNIQUE_KEY", "gauri");
                            f1.setArguments(b);
                            loadFragmentImage(f1);
                            break;
            case "bishar":
                            b = new Bundle();
                            b.putString("UNIQUE_KEY", "bishar");
                            f1.setArguments(b);
                            loadFragmentImage(f1);
                break;
           case "others":
                            b = new Bundle();
                            b.putString("UNIQUE_KEY", "others");
                            f1.setArguments(b);
                            loadFragmentImage(f1);
                break;
            case "pooja":
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_in_top,R.animator.slide_out_top)
                        .replace(R.id.fragment_container, new poojaFragment())
                        .commit();
                break;
            case "day1":
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_in_top,R.animator.slide_out_top)
                        .replace(R.id.fragment_container, new Day1Fragment())
                        .commit();
                break;

            case "day2":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "2");
                f.setArguments(b);
                loadFragment(f);
                break;

            case "day3":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "3");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day4":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "4");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day5":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "5");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day6":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "6");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day7":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "7");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day8":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "8");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day9":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "9");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day10":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "10");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day11":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "11");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day12":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "12");
                f.setArguments(b);
                loadFragment(f);
                break;
            case "day13":
                b = new Bundle();
                b.putString("UNIQUE_KEY", "13");
                f.setArguments(b);
                loadFragment(f);
                break;
        }
    }


    public void loadFragment(Fragment frag) {
        getSupportFragmentManager()
                .beginTransaction()
//                .setCustomAnimations(R.animator.slide_in_top,R.animator.slide_out_top)
                .replace(R.id.fragment_container, frag)
                .commit();

    }
    public void loadFragmentImage(Fragment frag) {
        getSupportFragmentManager()
                .beginTransaction()
//                        .setCustomAnimations(R.animator.slide_in_top,R.animator.slide_out_top)
                .replace(R.id.fragment_container, frag)
                .commit();

    }
}
