package com.maithil.madhushravani.view.profile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.model.SharedPref;

import static com.maithil.madhushravani.model.SharedPref.IMAGE_URL;
import static com.maithil.madhushravani.model.SharedPref.KEY_NAME;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private static final String TAG = "ProfileFragment";

    ImageView profilePic;
    TextView DisplayName;

 SharedPref sp;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_profile2, container, false);
       sp = new SharedPref(getContext());
       findViewById(v);
       setUserDetail();
    return v;
    }

   private void setUserDetail(){
        DisplayName.setText(sp.pref.getString(KEY_NAME,"Hello User"));
       Glide.with(this)
               .load(sp.pref.getString(IMAGE_URL, ""))
//               .apply(RequestOptions.circleCropTransform())
               .into(profilePic);
   }

   private void findViewById(View view){
        profilePic = view.findViewById(R.id.userImg);
        DisplayName = view.findViewById(R.id.und);
   }
}
