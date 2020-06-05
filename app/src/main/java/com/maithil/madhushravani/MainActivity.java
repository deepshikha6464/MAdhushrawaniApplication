package com.maithil.madhushravani;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.gtomato.android.ui.transformer.CoverFlowViewTransformer;
import com.gtomato.android.ui.transformer.FlatMerryGoRoundTransformer;
import com.gtomato.android.ui.widget.CarouselView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //ui
    public CarouselView carousel;
    //vars
    List<Integer> daysNumber = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ListOfDays();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            CarouselSettings();
//        }


//        carousel.setOnItemSelectedListener(new CarouselView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(CarouselView carouselView, int position, int adapterPosition, RecyclerView.Adapter adapter) {
//                //lblSelectedIndex.setText("Selected Position " + position);
//            }
//
//            @Override
//            public void onItemDeselected(CarouselView carouselView, int position, int adapterPosition, RecyclerView.Adapter adapter) {
//
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

//        FlatMerryGoRoundTransformer transformer = new FlatMerryGoRoundTransformer();
//        transformer.setNumPies(6);
//        transformer.getViewPerspective();
//        transformer.getHorizontalViewPort();
//
//        carousel.setTransformer(transformer);

        carousel.setInfinite(true);
        carousel.setExtraVisibleChilds(6);
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
}
