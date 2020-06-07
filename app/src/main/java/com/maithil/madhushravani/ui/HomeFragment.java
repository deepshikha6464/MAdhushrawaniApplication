package com.maithil.madhushravani.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.gtomato.android.ui.transformer.FlatMerryGoRoundTransformer;
import com.gtomato.android.ui.widget.CarouselView;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.utils.MyDataAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements  View.OnClickListener {
    private static final String TAG = "HomeFragment";

    public CarouselView carousel;
    TextView pooja, history,step1des;
    LinearLayout step2dec,step3dec;
    ImageView d1,u1,d2,u2,d3,u3,d4,u4, aripan;
    MaterialCardView day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13;

    //vars
    List<Integer> daysNumber = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        findViewbyid(view);
        ListOfDays();
//        CarouselSettings(view);



//        carousel.setOnScrollListener(new CarouselView.OnScrollListener() {
//            @Override
//            public void onScrollEnd(CarouselView carouselView) {
//                super.onScrollEnd(carouselView);
//            }
//        });

        return view;
    }
    private void findViewbyid(View view){
        history = view.findViewById(R.id.history);
        pooja = view.findViewById(R.id.pooja);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyClicked();
            }
        });

        pooja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new poojaFragment())
                        .commit();
            }
        });

        d1=view.findViewById(R.id.down);  d1.setOnClickListener(this);
        d2=view.findViewById(R.id.down2);d2.setOnClickListener(this);
        d3=view.findViewById(R.id.down3);d3.setOnClickListener(this);
        d4=view.findViewById(R.id.down4);d4.setOnClickListener(this);

        u1 = view.findViewById(R.id.up_arrow); u1.setOnClickListener(this);
        u2 = view.findViewById(R.id.up_arrow2);u2.setOnClickListener(this);
        u3 = view.findViewById(R.id.up_arrow3);u3.setOnClickListener(this);
        u4 = view.findViewById(R.id.up_arrow4);u4.setOnClickListener(this);

        step1des = view.findViewById(R.id.step1dec);
        step2dec = view.findViewById(R.id.step2dec);
        step3dec = view.findViewById(R.id.step3dec);
        aripan = view.findViewById(R.id.aripan);

        day1 = view.findViewById(R.id.day1); day1.setOnClickListener(this);
        day2 = view.findViewById(R.id.day2); day2.setOnClickListener(this);
        day3 = view.findViewById(R.id.day3); day3.setOnClickListener(this);
        day4 = view.findViewById(R.id.day4); day4.setOnClickListener(this);
        day5 = view.findViewById(R.id.day5); day5.setOnClickListener(this);
        day6 = view.findViewById(R.id.day6); day6.setOnClickListener(this);
        day7 = view.findViewById(R.id.day7); day7.setOnClickListener(this);
        day8 = view.findViewById(R.id.day8); day8.setOnClickListener(this);
        day9 = view.findViewById(R.id.day9); day9.setOnClickListener(this);
        day10 = view.findViewById(R.id.day10); day10.setOnClickListener(this);
        day11 = view.findViewById(R.id.day11); day11.setOnClickListener(this);
        day12 = view.findViewById(R.id.day12); day12.setOnClickListener(this);
        day13 = view.findViewById(R.id.day13); day13.setOnClickListener(this);

    }

    @Override  //card expand clicks
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
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
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Day1Fragment())
                        .commit();

        }

    }

    private void historyClicked(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());

        View view1 = getLayoutInflater().inflate(R.layout.history, null);

        bottomSheetDialog.setContentView(view1);

        bottomSheetDialog.show();
    }

//    private void CarouselSettings(View v){
//        carousel = v.findViewById(R.id.carousel);
//        carousel.setInfinite(true);
//        carousel.setExtraVisibleChilds(6);
////        carousel.smoothScrollToPosition(carousel.getAdapter().getItemCount() - 1);
//        carousel.setHorizontalScrollBarEnabled(true);
//        carousel.setScrollingAlignToViews(true);
//        carousel.setElevation(20);
//        carousel.bringToFront();
//
//        carousel.setTransformer(new FlatMerryGoRoundTransformer() {
//
//            @Override
//            public void transform(View view, float position) {
//                super.transform(view, position);
//                float alpha;
//                if (-2 <= position && position <= 0) {
//                    alpha = (float) ((2 + position) / 2.0);
//                } else if (0 < position && position <= 2) {
//                    alpha = (float) ((2 - position) / 2.0);
//                } else {
//                    alpha = 0;
//                }
//                view.setAlpha(alpha);
//            }
//        });
//        carousel.setAdapter(new MyDataAdapter(daysNumber));
//    }
    public  void ListOfDays(){
        daysNumber.add(1);
        daysNumber.add(2);
        daysNumber.add(3);
        daysNumber.add(4);
        daysNumber.add(5);
        daysNumber.add(6);
        daysNumber.add(7);
        daysNumber.add(8);
        daysNumber.add(9);
        daysNumber.add(10);
        daysNumber.add(11);
        daysNumber.add(12);
        daysNumber.add(13);
        daysNumber.add(14);
        daysNumber.add(15);
    }
    }