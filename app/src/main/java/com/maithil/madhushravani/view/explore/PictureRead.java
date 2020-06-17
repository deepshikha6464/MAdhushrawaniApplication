package com.maithil.madhushravani.view.explore;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maithil.madhushravani.R;

import static com.maithil.madhushravani.model.SharedPref.IMAGE_URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureRead extends Fragment  implements View.OnClickListener {
    private static final String TAG = "PictureRead";

ImageView biniImg,left,right;
RelativeLayout frame;
int[] myImageList = new int[]{R.drawable.bini2, R.drawable.bini3, R.drawable.bini4,R.drawable.bini5};
int[] myImageListReverse = new int[]{R.drawable.bini5, R.drawable.bini4, R.drawable.bini3,R.drawable.bini2, R.drawable.bini_1};
int i = 0;

    LinearLayout toolbar, fragToolbar,mainToolBar;
    TextView tooltext ;

    ImageView back;


    public PictureRead() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_picture_read, container, false);
        biniImg = view.findViewById(R.id.imageView);
        frame = view.findViewById(R.id.frame);
        setToolbarDAYS(view);
        tooltext.setText("Read Bini from Book");
          left = view.findViewById(R.id.nextLeft); left.setOnClickListener(this);
          right = view.findViewById(R.id.nextRight); right.setOnClickListener(this);
          left.setVisibility(View.GONE);
        //swipe code
//        frame.setOnTouchListener(new View.OnTouchListener() {
//
//            int downX, upX;
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
////                if (event.getAction() == MotionEvent.ACTION_DOWN) {
////                    downX = (int) event.getX();
////                    Log.i("event.getX()", " downX " + downX);
////                    return true;
////                }
////
////                else if (event.getAction() == MotionEvent.ACTION_UP) {
////                    upX = (int) event.getX();
////                    Log.i("event.getX()", " upX " + upX);
////                    if (upX - downX > 100) {
////
////                        // swipe right
////
////                    }
////
////                    else if (downX - upX > -100) {
//
//                        // swipe left
//                if(i>4){
//                    i=0;
//                    biniImg.setImageResource(myImageList[i]);
//
//                }else{
//                        biniImg.setImageResource(myImageList[i]);
//                        i++;
//                    }
//                    return true;
////
////                }
////                return false;
//            }
//        });
        return view;
    }

    public void setToolbarDAYS(View view){
        //toolbar
        toolbar = view.findViewById(R.id.toolbar);
        fragToolbar = view.findViewById(R.id.fragToolbar);
        mainToolBar = view.findViewById(R.id.mainToolBar);
        tooltext = view.findViewById(R.id.toolText);
        back = view.findViewById(R.id.back); back.setOnClickListener(this);
        fragToolbar.setVisibility(View.VISIBLE);
        mainToolBar.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.nextRight:
                if(i<=3){
//                    Glide.with(this)
//                            .load(myImageList[i])
//                            .into(biniImg);
                    biniImg.setImageResource(myImageList[i]);
                    i++;}
                else{
                    right.setVisibility(View.GONE);
                    left.setVisibility(View.VISIBLE);
                    i= 0;
                }
                break;

            case R.id.nextLeft:
                if(i<=3){
//                    Glide.with(this)
//                            .load(myImageListReverse[i])
//                            .into(biniImg);
                    biniImg.setImageResource(myImageList[i]);

                    i++;
                }
                else{
                    right.setVisibility(View.VISIBLE);
                    left.setVisibility(View.GONE);
                    i=0;
                }
        }

    }
}
