package com.maithil.madhushravani.ui;


import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.maithil.madhushravani.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureRead extends Fragment  {
    private static final String TAG = "PictureRead";

ImageView biniImg;
FrameLayout frame;
int[] myImageList = new int[]{R.drawable.bini_1, R.drawable.bini2, R.drawable.bini3, R.drawable.bini4, R.drawable.bini5};
int i = 0;

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

        //swipe code
        frame.setOnTouchListener(new View.OnTouchListener() {

            int downX, upX;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    downX = (int) event.getX();
//                    Log.i("event.getX()", " downX " + downX);
//                    return true;
//                }
//
//                else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    upX = (int) event.getX();
//                    Log.i("event.getX()", " upX " + upX);
//                    if (upX - downX > 100) {
//
//                        // swipe right
//
//                    }
//
//                    else if (downX - upX > -100) {

                        // swipe left
                if(i>4){
                    i=0;
                    biniImg.setImageResource(myImageList[i]);

                }else{
                        biniImg.setImageResource(myImageList[i]);
                        i++;
                    }
                    return true;
//
//                }
//                return false;
            }
        });
        return view;
    }


}
