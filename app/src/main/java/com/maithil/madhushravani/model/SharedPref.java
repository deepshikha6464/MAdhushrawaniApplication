package com.maithil.madhushravani.model;

import android.content.Context;
import android.content.SharedPreferences;

public  class SharedPref  {
   public SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    //shared pref mode
    int PRIVATE_MODE = 0;

    //key name
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    // Email address (make variable public to access from outside)
    public static final String IMAGE_URL = "image_url";
    private static final String IS_LOGIN = "isLoggedIn";

    //pooja samagri
    private static final String spc1 = "SPC1_COLOR";
    private static final String spc2 = "SPC1_COLOR";
    private static final String spc3 = "SPC1_COLOR";
    private static final String spc4 = "SPC1_COLOR";
    private static final String spc5 = "SPC1_COLOR";
    private static final String spc6 = "SPC1_COLOR";
    private static final String spc7 = "SPC1_COLOR";
    private static final String spc8 = "SPC1_COLOR";
    private static final String spc9 = "SPC1_COLOR";
    private static final String spc10 = "SPC1_COLOR";
    private static final String spc11 = "SPC1_COLOR";
    private static final String spc12 = "SPC1_COLOR";
    private static final String spc13 = "SPC1_COLOR";
    private static final String spc14 = "SPC1_COLOR";
    private static final String spc15 = "SPC1_COLOR";
    private static final String spc16 = "SPC1_COLOR";
    private static final String spc17 = "SPC1_COLOR";
    private static final String spc18 = "SPC1_COLOR";
    private static final String spc19 = "SPC1_COLOR";
    private static final String spc20 = "SPC1_COLOR";
    private static final String spc21 = "SPC1_COLOR";
    private static final String spc22 = "SPC1_COLOR";
    private static final String spc23 = "SPC1_COLOR";
    private static final String spc24 = "SPC1_COLOR";
    private static final String spc25 = "SPC1_COLOR";
    private static final String spc26 = "SPC1_COLOR";
    private static final String spc27 = "SPC1_COLOR";
    private static final String spc28 = "SPC1_COLOR";
    private static final String spc29 = "SPC1_COLOR";
    private static final String spc30 = "SPC1_COLOR";
    private static final String spc31 = "SPC1_COLOR";
    private static final String spc32 = "SPC1_COLOR";
    private static final String spc33 = "SPC1_COLOR";
    private static final String spc34 = "SPC1_COLOR";
    private static final String spc35 = "SPC1_COLOR";
    private static final String spc36 = "SPC1_COLOR";
    private static final String spc37 = "SPC1_COLOR";
    private static final String spc38 = "SPC1_COLOR";
    private static final String spc39 = "SPC1_COLOR";
    private static final String spc40 = "SPC1_COLOR";
    private static final String spc41 = "SPC1_COLOR";
    private static final String spc42= "SPC1_COLOR";
    private static final String spc43 = "SPC1_COLOR";
    private static final String spc44 = "SPC1_COLOR";


    public SharedPref (Context context) {
        this.context = context;
        pref = context.getSharedPreferences(KEY_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String name,String email, String url, Boolean login)
    {
        editor.putBoolean(IS_LOGIN,login);
        editor.putString(KEY_NAME ,name);
        editor.putString(KEY_EMAIL ,email);
        editor.putString(IMAGE_URL ,url);

        //commit changes

        editor.commit();
    }

    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

    }

    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

}
