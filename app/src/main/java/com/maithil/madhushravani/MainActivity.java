package com.maithil.madhushravani;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.gtomato.android.ui.transformer.CoverFlowViewTransformer;
import com.gtomato.android.ui.transformer.FlatMerryGoRoundTransformer;
import com.gtomato.android.ui.widget.CarouselView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //ui
    public CarouselView carousel;
    TextView pooja, history;
    //vars
    List<Integer> daysNumber = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ListOfDays();
        findViewbyid();
        CarouselSettings();


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
    private void findViewbyid(){
        history = findViewById(R.id.history);
        pooja = findViewById(R.id.pooja);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyClicked();
            }
        });
        }
    private void historyClicked(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);

        View view1 = getLayoutInflater().inflate(R.layout.history, null);

        bottomSheetDialog.setContentView(view1);

        bottomSheetDialog.show();
    }
}
