package com.maithil.madhushravani.view.explore;


import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.gtomato.android.ui.widget.CarouselView;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.view.Activities.FragmentLoader;
import com.maithil.madhushravani.view.Activities.LoginActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.maithil.madhushravani.model.SharedPref.IMAGE_URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class Explore extends Fragment implements  View.OnClickListener {
    private static final String TAG = "Explore";

    ImageView langIV,back;
    TextView history, step1des;
    LinearLayout step2dec, step3dec;
    ImageView d1, u1, d2, u2, d3, u3, d4, u4, aripan, pooja;
    MaterialCardView day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13;
    //vars
    List<Integer> daysNumber = new ArrayList<>();
    Bundle b;
    Day2_14 f = new Day2_14();

    public Explore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.explore, container, false);
        findViewbyid(view);
        Glide.with(this)
                .load(R.drawable.aripan)
                .into(aripan);
        return view;
    }

    private void findViewbyid(View view) {
        history = view.findViewById(R.id.history);
        pooja = view.findViewById(R.id.pooja);
        langIV = view.findViewById(R.id.lang); langIV.setOnClickListener(this);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyClicked();
            }
        });

        pooja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), FragmentLoader.class);
                i.putExtra("FragName","pooja");
                startActivity(i);

            }
        });

        d1 = view.findViewById(R.id.down);        d1.setOnClickListener(this);
        d2 = view.findViewById(R.id.down2);        d2.setOnClickListener(this);
        d3 = view.findViewById(R.id.down3);
        d3.setOnClickListener(this);
        d4 = view.findViewById(R.id.down4);
        d4.setOnClickListener(this);

        u1 = view.findViewById(R.id.up_arrow);
        u1.setOnClickListener(this);
        u2 = view.findViewById(R.id.up_arrow2);
        u2.setOnClickListener(this);
        u3 = view.findViewById(R.id.up_arrow3);
        u3.setOnClickListener(this);
        u4 = view.findViewById(R.id.up_arrow4);
        u4.setOnClickListener(this);

        step1des = view.findViewById(R.id.step1dec);
        step2dec = view.findViewById(R.id.step2dec);
        step3dec = view.findViewById(R.id.step3dec);
        aripan = view.findViewById(R.id.aripan);

        day1 = view.findViewById(R.id.day1);
        day1.setOnClickListener(this);
        day2 = view.findViewById(R.id.day2);
        day2.setOnClickListener(this);
        day3 = view.findViewById(R.id.day3);
        day3.setOnClickListener(this);
        day4 = view.findViewById(R.id.day4);
        day4.setOnClickListener(this);
        day5 = view.findViewById(R.id.day5);
        day5.setOnClickListener(this);
        day6 = view.findViewById(R.id.day6);
        day6.setOnClickListener(this);
        day7 = view.findViewById(R.id.day7);
        day7.setOnClickListener(this);
        day8 = view.findViewById(R.id.day8);
        day8.setOnClickListener(this);
        day9 = view.findViewById(R.id.day9);
        day9.setOnClickListener(this);
        day10 = view.findViewById(R.id.day10);
        day10.setOnClickListener(this);
        day11 = view.findViewById(R.id.day11);
        day11.setOnClickListener(this);
        day12 = view.findViewById(R.id.day12);
        day12.setOnClickListener(this);
        day13 = view.findViewById(R.id.day13);
        day13.setOnClickListener(this);

    }

    @Override  //card expand clicks
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), FragmentLoader.class);

        int id = view.getId();
        switch (id) {

            case  R.id.lang:
                Log.d(TAG, "onClick: language");
                languageChange();
                break;

            case R.id.down:
                u1.setVisibility(View.VISIBLE);
                step1des.setVisibility(View.VISIBLE);
                d1.setVisibility(View.GONE);
                break;

            case R.id.up_arrow:
                u1.setVisibility(View.GONE);
                step1des.setVisibility(View.GONE);
                d1.setVisibility(View.VISIBLE);
                break;

            case R.id.down2:
                d2.setVisibility(View.GONE);
                u2.setVisibility(View.VISIBLE);
                step2dec.setVisibility(View.VISIBLE);
                break;

            case R.id.up_arrow2:
                d2.setVisibility(View.VISIBLE);
                u2.setVisibility(View.GONE);
                step2dec.setVisibility(View.GONE);
                break;

            case R.id.down3:
                d3.setVisibility(View.GONE);
                u3.setVisibility(View.VISIBLE);
                step3dec.setVisibility(View.VISIBLE);
                break;

            case R.id.up_arrow3:
                d3.setVisibility(View.VISIBLE);
                u3.setVisibility(View.GONE);
                step3dec.setVisibility(View.GONE);
                break;

            case R.id.down4:
                d4.setVisibility(View.GONE);
                u4.setVisibility(View.VISIBLE);
                aripan.setVisibility(View.VISIBLE);
                break;

            case R.id.up_arrow4:
                d4.setVisibility(View.VISIBLE);
                u4.setVisibility(View.GONE);
                aripan.setVisibility(View.GONE);
                break;

            case R.id.day1:
                intent.putExtra("FragName","day1");

                break;
            case R.id.day2:
                intent.putExtra("FragName","day2");
                break;
            case R.id.day3:
                intent.putExtra("FragName","day3");

                break;
            case R.id.day4:
                intent.putExtra("FragName","day4");

                break;
            case R.id.day5:
                intent.putExtra("FragName","day5");

                break;
            case R.id.day6:
                intent.putExtra("FragName","day6");

                break;
            case R.id.day7:
                intent.putExtra("FragName","day7");

                break;
            case R.id.day8:
                intent.putExtra("FragName","day8");

                break;
            case R.id.day9:
                intent.putExtra("FragName","day9");

                break;
            case R.id.day10:
                intent.putExtra("FragName","day10");

                break;
            case R.id.day11:
                intent.putExtra("FragName","day11");

                break;
            case R.id.day12:
                intent.putExtra("FragName","day12");

                break;
            case R.id.day13:
                intent.putExtra("FragName","day13");

                break;

        }
        startActivity(intent);

    }

    public void loadFragment(Fragment frag) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
//                .setCustomAnimations(R.animator.slide_in_bottom,R.animator.slide_out_bottom,R.animator.slide_in_top,R.animator.slide_out_top)
                .replace(R.id.fragment_container_explore, frag)
                .commit();

    }

    private void historyClicked() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());

        View view1 = getLayoutInflater().inflate(R.layout.history, null);

        bottomSheetDialog.setContentView(view1);

        bottomSheetDialog.show();
    }

    private  void languageChange(){
        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale("hi");
        res.updateConfiguration(conf, dm);

        Toast.makeText(getContext(), "Language Changed ", Toast.LENGTH_SHORT).show();
    }
}