package com.maithil.madhushravani.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.app.Fragment.*;


import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.gtomato.android.ui.transformer.FlatMerryGoRoundTransformer;
import com.gtomato.android.ui.widget.CarouselView;
import com.maithil.madhushravani.utils.MyDataAdapter;
import com.maithil.madhushravani.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity /*implements MyDataAdapter.ItemClickListener, View.OnClickListener */{
    private static final String TAG = "MainActivity";

    //ui
    public CarouselView carousel;
    TextView pooja, history;
    RelativeLayout relativeLayout;
    LinearLayout fragContainer;
    //vars
    List<Integer> daysNumber = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
// set an exit transition
        getWindow().setExitTransition(new Explode());
        ListOfDays();
        findViewbyid();
        CarouselSettings();
        carousel.setOnItemSelectedListener(new CarouselView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(CarouselView carouselView, int position, int adapterPosition, RecyclerView.Adapter adapter) {
//                lblSelectedIndex.setText("Selected Position " + position);
//                daysClicked();
                Log.d(TAG, "onItemSelected: "+position);
                carouselView.setOnItemClickListener( new CarouselView.OnItemClickListener(){
                    @Override
                    public void onItemClick(RecyclerView.Adapter adapter, View view, int i, int i1) {
                        daysClicked();
                    }

                });
            }

            @Override
            public void onItemDeselected(CarouselView carouselView, int position, int adapterPosition, RecyclerView.Adapter adapter) {
                Log.d(TAG, "onItemDeselected: ");
            }

        });


//        carousel.setOnScrollListener(new CarouselView.OnScrollListener() {
//            @Override
//            public void onScrollEnd(CarouselView carouselView) {
//                super.onScrollEnd(carouselView);
//            }
//        });


    }
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

    private void CarouselSettings(){
        carousel = findViewById(R.id.carousel);
       carousel.setInfinite(true);
        carousel.setExtraVisibleChilds(6);
//        carousel.smoothScrollToPosition(carousel.getAdapter().getItemCount() - 1);
       carousel.setHorizontalScrollBarEnabled(true);
        carousel.setScrollingAlignToViews(true);
        carousel.setElevation(20);
      carousel.bringToFront();

      carousel.setTransformer(new FlatMerryGoRoundTransformer() {

            @Override
            public void transform(View view, float position) {
                super.transform(view, position);
                float alpha;
                if (-2 <= position && position <= 0) {
                    alpha = (float) ((2 + position) / 2.0);
                } else if (0 < position && position <= 2) {
                    alpha = (float) ((2 - position) / 2.0);
                } else {
                    alpha = 0;
                }
                view.setAlpha(alpha);
            }
        });
        carousel.setAdapter(new MyDataAdapter(daysNumber));
    }
    private void findViewbyid(){
        history = findViewById(R.id.history);
        pooja = findViewById(R.id.pooja);
        relativeLayout = findViewById(R.id.relative_layout);
        fragContainer = findViewById(R.id.fragContainer);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyClicked();
            }
        });
        pooja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poojaClicked();
            }
        });
        }
    private void historyClicked(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);

        View view1 = getLayoutInflater().inflate(R.layout.history, null);

        bottomSheetDialog.setContentView(view1);

        bottomSheetDialog.show();
    }
    private void poojaClicked(){
      Intent i = new Intent(this,PoojaActivity.class);
      startActivity(i,  ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }

    private void daysClicked(){
        Intent i = new Intent(this,DaysActivity.class);
        startActivity(i,  ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }

//    @Override
//    public void onClick(View view) {
//        Log.d(TAG, "onClick: "+view);
//        daysClicked();
//    }
//
//    @Override
//    public void onItemClick(View view, int position) {
//        Log.d(TAG, "onItemClick: "+position);
//        daysClicked();
//    }
}
