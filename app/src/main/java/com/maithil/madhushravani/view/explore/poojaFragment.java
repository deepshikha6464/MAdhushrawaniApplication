package com.maithil.madhushravani.view.explore;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.model.SharedPref;

import java.util.ArrayList;

import static com.maithil.madhushravani.R.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class poojaFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "poojaFragment";

    //ui
    LinearLayout toolbar, fragToolbar,mainToolBar;
TextView tooltext;
ImageView back;
MaterialCardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44;
int cc1 = 0 ,cc2 = 0 ,cc3 = 0 ,cc4 = 0 ,cc5 = 0 ,cc6 = 0 ,cc7 = 0 ,cc8 = 0 ,cc9= 0 ,cc10= 0 ,cc11= 0 ,cc12= 0 ,cc13= 0 ,cc14= 0 ,cc15= 0 ,cc16= 0 ,cc17= 0 ,cc18= 0 ,cc19= 0 ,cc20= 0 ,cc21= 0 ,cc22= 0 ,cc23,cc24= 0 ,cc25= 0 ,cc26= 0 ,cc27= 0 ,cc28= 0 ,cc29= 0 ,cc30= 0 ,cc31= 0 ,cc32= 0 ,cc33= 0 ,cc34= 0 ,cc35= 0 ,cc36= 0 ,cc37= 0 ,cc38= 0 ,cc39= 0 ,cc40= 0 ,cc41= 0 ,cc42= 0 ,cc43= 0 ,cc44= 0 ;
    GridView grid;

//    data
SharedPref sp;

    public poojaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =  inflater.inflate(R.layout.fragment_pooja2, container, false);
       findViewByID(v);
       sp = new SharedPref(getContext());
       setCardStatus();




       return v;
    }

    private void findViewByID(View v) {
        toolbar = v.findViewById(id.toolbar);
        fragToolbar = v.findViewById(id.fragToolbar);
        mainToolBar = v.findViewById(id.mainToolBar);
        tooltext = v.findViewById(id.toolText);
        back = v.findViewById(id.back); back.setOnClickListener(this);

//        toolbar
        fragToolbar.setVisibility(View.VISIBLE);
        mainToolBar.setVisibility(View.GONE);
        tooltext.setText(getString(string.poojaSamagri));


        c1 = v.findViewById(id.ps1); c1.setOnClickListener(this);
        c2 = v.findViewById(id.ps2); c2.setOnClickListener(this);
        c3 = v.findViewById(id.ps3); c3.setOnClickListener(this);
        c4 = v.findViewById(id.ps4); c4.setOnClickListener(this);
        c5 = v.findViewById(id.ps5); c5.setOnClickListener(this);
        c6 = v.findViewById(id.ps6); c6.setOnClickListener(this);
        c7 = v.findViewById(id.ps7); c7.setOnClickListener(this);
        c8 = v.findViewById(id.ps8); c8.setOnClickListener(this);
        c9 = v.findViewById(id.ps9); c9.setOnClickListener(this);
        c10 = v.findViewById(id.ps10); c10.setOnClickListener(this);
        c11 = v.findViewById(id.ps11); c11.setOnClickListener(this);
        c12 = v.findViewById(id.ps12); c12.setOnClickListener(this);
        c13 = v.findViewById(id.ps13); c13.setOnClickListener(this);
        c14 = v.findViewById(id.ps14); c14.setOnClickListener(this);
        c15 = v.findViewById(id.ps15); c15.setOnClickListener(this);
        c16 = v.findViewById(id.ps16); c16.setOnClickListener(this);
        c17 = v.findViewById(id.ps17); c17.setOnClickListener(this);
        c18 = v.findViewById(id.ps18); c18.setOnClickListener(this);
        c19 = v.findViewById(id.ps19); c19.setOnClickListener(this);
        c20 = v.findViewById(id.ps20); c20.setOnClickListener(this);
        c21 = v.findViewById(id.ps21); c21.setOnClickListener(this);
        c22 = v.findViewById(id.ps22); c22.setOnClickListener(this);
        c23= v.findViewById(id.ps23); c23.setOnClickListener(this);
        c24= v.findViewById(id.ps24); c24.setOnClickListener(this);
        c25= v.findViewById(id.ps25); c25.setOnClickListener(this);
        c26= v.findViewById(id.ps26); c26.setOnClickListener(this);
        c27= v.findViewById(id.ps27); c27.setOnClickListener(this);
        c28= v.findViewById(id.ps28); c28.setOnClickListener(this);
        c29= v.findViewById(id.ps29); c29.setOnClickListener(this);
        c30= v.findViewById(id.ps30); c30.setOnClickListener(this);
        c31= v.findViewById(id.ps31); c31.setOnClickListener(this);
        c32= v.findViewById(id.ps32); c32.setOnClickListener(this);
        c33= v.findViewById(id.ps33); c33.setOnClickListener(this);
        c34= v.findViewById(id.ps34); c34.setOnClickListener(this);
        c35= v.findViewById(id.ps35); c35.setOnClickListener(this);
        c36= v.findViewById(id.ps36); c36.setOnClickListener(this);
        c37= v.findViewById(id.ps37); c37.setOnClickListener(this);
        c38= v.findViewById(id.ps38); c38.setOnClickListener(this);
        c39= v.findViewById(id.ps39); c39.setOnClickListener(this);
        c40= v.findViewById(id.ps40); c40.setOnClickListener(this);
        c41= v.findViewById(id.ps41); c41.setOnClickListener(this);
        c42 = v.findViewById(id.ps42); c42.setOnClickListener(this);
        c43= v.findViewById(id.ps43); c43.setOnClickListener(this);
        c44= v.findViewById(id.ps44); c44.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
//        back button

        switch(id){
            case R.id.ps1:
                if(cc1 == 0){
                    c1.setBackgroundColor(getResources().getColor(color.greenColor));
                    sp.pref.edit().putInt("SPC1_COLOR",1).apply();
                      cc1=1;
                }
               else {
                    c1.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                    sp.pref.edit().putInt("SPC1_COLOR",0).apply();
                    cc1 = 0;
                }
                Log.d(TAG, "onClick: "+ c1.getBackground());
                break;
        case R.id.ps2:
            if(cc2 == 0){
                c2.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC2_COLOR",1).apply();

                cc2=1;
            }
            else {
                c2.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC2_COLOR",0).apply();

                cc2 = 0;
            }
            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps3:
            if(cc3 == 0){
                c3.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC3_COLOR",1).apply();

                cc3=1;
            }
            else {
                c3.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC3_COLOR",0).apply();

                cc3 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps4:
            if(cc4 == 0){
                c4.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC4_COLOR",1).apply();

                cc4=1;
            }
            else {
                c4.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC4_COLOR",0).apply();

                cc4 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps5:
            if(cc5 == 0){
                c5.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC5_COLOR",1).apply();

                cc5=1;
            }
            else {
                c5.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC5_COLOR",0).apply();

                cc5 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps6:
            if(cc6 == 0){
                c6.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC6_COLOR",1).apply();

                cc6=1;
            }
            else {
                c6.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC6_COLOR",0).apply();

                cc6 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps7:
            if(cc7 == 0){
                c7.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC7_COLOR",1).apply();

                cc7=1;
            }
            else {
                c7.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC7_COLOR",0).apply();

                cc7 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps8:
            if(cc8 == 0){
                c8.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC8_COLOR",1).apply();

                cc8=1;
            }
            else {
                c8.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC8_COLOR",0).apply();

                cc8 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps9:
            if(cc9 == 0){
                c9.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC9_COLOR",1).apply();

                cc9=1;
            }
            else {
                c9.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC9_COLOR",0).apply();

                cc9 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps10:
            if(cc10 == 0){
                c10.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC10_COLOR",1).apply();

                cc10=1;
            }
            else {
                c10.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC10_COLOR",0).apply();

                cc10 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps11:
            if(cc11 == 0){
                c11.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC11_COLOR",1).apply();

                cc11=1;
            }
            else {
                c11.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC11_COLOR",0).apply();

                cc11 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps12:
            if(cc12 == 0){
                c12.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC12_COLOR",1).apply();

                cc12=1;
            }
            else {
                c12.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC12_COLOR",0).apply();

                cc12 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps13:
            if(cc13 == 0){
                c13.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC13_COLOR",1).apply();

                cc13=1;
            }
            else {
                c13.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC13_COLOR",0).apply();

                cc13 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps14:
            if(cc14 == 0){
                c14.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC14_COLOR",1).apply();

                cc14=1;
            }
            else {
                c14.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC14_COLOR",0).apply();

                cc14 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps15:
            if(cc15 == 0){
                c15.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC15_COLOR",1).apply();

                cc15=1;
            }
            else {
                c15.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC15_COLOR",0).apply();

                cc15 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps16:
            if(cc16 == 0){
                c16.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC16_COLOR",1).apply();

                cc16=1;
            }
            else {
                c16.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC16_COLOR",0).apply();

                cc16 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps17:
            if(cc17 == 0){
                c17.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC17_COLOR",1).apply();

                cc17=1;
            }
            else {
                c17.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC17_COLOR",0).apply();

                cc17 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps18:
            if(cc18 == 0){
                c18.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC18_COLOR",1).apply();

                cc18=1;
            }
            else {
                c18.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC18_COLOR",0).apply();

                cc18 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps19:
            if(cc19 == 0){
                c19.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC19_COLOR",1).apply();

                cc19=1;
            }
            else {
                c19.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC19_COLOR",0).apply();

                cc19 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps20:
            if(cc20 == 0){
                c20.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC20_COLOR",1).apply();

                cc20=1;
            }
            else {
                c20.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC20_COLOR",0).apply();

                cc20 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps21:
            if(cc21 == 0){
                c21.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC21_COLOR",1).apply();

                cc21=1;
            }
            else {
                c21.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC21_COLOR",0).apply();

                cc21 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps22:
            if(cc22 == 0){
                c22.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC22_COLOR",1).apply();
                cc22=1;
            }
            else {
                c22.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC22_COLOR",0).apply();

                cc22 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps23:
            if(cc23 == 0){
                c23.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC23_COLOR",1).apply();

                cc23=1;
            }
            else {
                c23.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC23_COLOR",0).apply();

                cc23 = 0;
            }
            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps24:
            if(cc24 == 0){
                c24.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC24_COLOR",1).apply();

                cc24=1;
            }
            else {
                c24.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC24_COLOR",0).apply();

                cc24 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps25:
            if(cc25 == 0){
                c25.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC25_COLOR",1).apply();

                cc25=1;
            }
            else {
                c25.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC25_COLOR",0).apply();

                cc25 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps26:
            if(cc26 == 0){
                c26.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC26_COLOR",1).apply();

                cc26=1;
            }
            else {
                c26.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC26_COLOR",0).apply();

                cc26 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps27:
            if(cc27 == 0){
                c27.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC27_COLOR",1).apply();

                cc27=1;
            }
            else {
                c27.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC27_COLOR",0).apply();

                cc27 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps28:
            if(cc28 == 0){
                c28.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC28_COLOR",1).apply();

                cc28=1;
            }
            else {
                c28.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC28_COLOR",0).apply();

                cc28 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps29:
            if(cc29 == 0){
                c29.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC29_COLOR",1).apply();

                cc29=1;
            }
            else {
                c29.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC29_COLOR",0).apply();

                cc29 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps30:
            if(cc30 == 0){
                c30.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC30_COLOR",1).apply();

                cc30=1;
            }
            else {
                c30.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC30_COLOR",0).apply();

                cc30 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps31:
            if(cc31 == 0){
                c31.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC31_COLOR",1).apply();

                cc31=1;
            }
            else {
                c31.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC31_COLOR",0).apply();

                cc31 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps32:
            if(cc32 == 0){
                c32.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC32_COLOR",1).apply();

                cc32=1;
            }
            else {
                c32.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC32_COLOR",0).apply();

                cc32 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps33:
            if(cc33 == 0){
                c33.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC33_COLOR",1).apply();

                cc33=1;
            }
            else {
                c33.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC33_COLOR",0).apply();

                cc33 = 0;
            }
            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps34:
            if(cc34 == 0){
                c34.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC34_COLOR",1).apply();

                cc34=1;
            }
            else {
                c34.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC34_COLOR",0).apply();

                cc34 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps35:
            if(cc35 == 0){
                c35.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC35_COLOR",1).apply();

                cc35=1;
            }
            else {
                c35.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC35_COLOR",0).apply();

                cc35 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps36:
            if(cc36 == 0){
                c36.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC36_COLOR",1).apply();

                cc36=1;
            }
            else {
                c36.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC36_COLOR",0).apply();

//                cc36 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps37:
            if(cc37 == 0){
                c37.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC37_COLOR",1).apply();

                cc37=1;
            }
            else {
                c37.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC37_COLOR",0).apply();

                cc37 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps38:
            if(cc38 == 0){
                c38.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC38_COLOR",1).apply();

                cc38=1;
            }
            else {
                c38.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC38_COLOR",0).apply();

                cc38 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps39:
            if(cc39 == 0){
                c39.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC39_COLOR",1).apply();

                cc39=1;
            }
            else {
                c39.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC39_COLOR",0).apply();

                cc39 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps40:
            if(cc40 == 0){
                c40.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC40_COLOR",1).apply();

                cc40=1;
            }
            else {
                c40.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC40_COLOR",0).apply();

                cc40 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps41:
            if(cc41 == 0){
                c41.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC41_COLOR",1).apply();

                cc41=1;
            }
            else {
                c41.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC41_COLOR",0).apply();

                cc41 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps42:
            if(cc42 == 0){
                c42.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC42_COLOR",1).apply();

                cc42=1;
            }
            else {
                c42.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC42_COLOR",0).apply();

                cc42 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps43:
            if(cc43 == 0){
                c43.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC43_COLOR",1).apply();

                cc43=1;
            }
            else {
                c43.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC43_COLOR",0).apply();

                cc43 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;
case R.id.ps44:
            if(cc44 == 0){
                c44.setBackgroundColor(getResources().getColor(color.greenColor));
                sp.pref.edit().putInt("SPC44_COLOR",1).apply();

                cc44=1;
            }
            else {
                c44.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));
                sp.pref.edit().putInt("SPC44_COLOR",0).apply();

                cc44 = 0;
            }
//            Log.d(TAG, "onClick: "+ c1.getBackground());
            break;


        }

    }

    public void setCardStatus(){
        if(sp.pref.getInt("SPC1_COLOR",0) == 0){
            c1.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c1.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC2_COLOR",0) == 0){
            c2.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c2.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC3_COLOR",0) == 0){
            c3.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c3.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC4_COLOR",0) == 0){
            c4.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c4.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC5_COLOR",0) == 0){
            c5.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c5.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC6_COLOR",0) == 0){
            c6.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c6.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC7_COLOR",0) == 0){
            c7.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c7.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC8_COLOR",0) == 0){
            c8.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c8.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC9_COLOR",0) == 0){
            c9.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c9.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC10_COLOR",0) == 0){
            c10.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c10.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC11_COLOR",0) == 0){
            c11.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c11.setBackgroundColor(getResources().getColor(color.greenColor));

        }

     if(sp.pref.getInt("SPC12_COLOR",0) == 0){
            c12.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c12.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC13_COLOR",0) == 0){
            c13.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c13.setBackgroundColor(getResources().getColor(color.greenColor));

        }

     if(sp.pref.getInt("SPC14_COLOR",0) == 0){
            c14.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c14.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC15_COLOR",0) == 0){
            c15.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c15.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC16_COLOR",0) == 0){
            c16.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c16.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC17_COLOR",0) == 0){
            c17.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c17.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC18_COLOR",0) == 0){
            c18.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c18.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC19_COLOR",0) == 0){
            c19.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c19.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC20_COLOR",0) == 0){
            c20.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c20.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC21_COLOR",0) == 0){
            c21.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c21.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC22_COLOR",0) == 0){
            c22.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c22.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC23_COLOR",0) == 0){
            c23.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c23.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC24_COLOR",0) == 0){
            c24.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c24.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC25_COLOR",0) == 0){
            c25.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c25.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC27_COLOR",0) == 0){
            c27.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c27.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC28_COLOR",0) == 0){
            c28.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c28.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC29_COLOR",0) == 0){
            c29.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c29.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC30_COLOR",0) == 0){
            c30.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c30.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC31_COLOR",0) == 0){
            c31.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c31.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC32_COLOR",0) == 0){
            c32.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c32.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC33_COLOR",0) == 0){
            c33.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c33.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC34_COLOR",0) == 0){
            c34.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c34.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC35_COLOR",0) == 0){
            c35.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c35.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC36_COLOR",0) == 0){
            c36.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c36.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC37_COLOR",0) == 0){
            c37.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c37.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC40_COLOR",0) == 0){
            c40.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c40.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC41_COLOR",0) == 0){
            c41.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c41.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC42_COLOR",0) == 0){
            c42.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c42.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC43_COLOR",0) == 0){
            c43.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c43.setBackgroundColor(getResources().getColor(color.greenColor));

        }
     if(sp.pref.getInt("SPC44_COLOR",0) == 0){
            c44.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c44.setBackgroundColor(getResources().getColor(color.greenColor));

        }


        if(sp.pref.getInt("SPC39_COLOR",0) == 0){
            c39.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c39.setBackgroundColor(getResources().getColor(color.greenColor));

        }
        if(sp.pref.getInt("SPC26_COLOR",0) == 0){
            c26.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c26.setBackgroundColor(getResources().getColor(color.greenColor));

        }

        if(sp.pref.getInt("SPC38_COLOR",0) == 0){
            c38.setBackgroundColor(getResources().getColor(color.colorPrimaryDark));

        }else{
            c38.setBackgroundColor(getResources().getColor(color.greenColor));

        }

    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().onBackPressed();

    }
}
