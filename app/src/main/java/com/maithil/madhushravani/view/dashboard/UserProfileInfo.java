package com.maithil.madhushravani.view.dashboard;


import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.transition.Explode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.model.PostsList;
import com.maithil.madhushravani.model.SharedPref;
import com.maithil.madhushravani.model.UserData;
import com.maithil.madhushravani.model.UserDetail;
import com.maithil.madhushravani.view.profile.ProfileAdapter;

import static com.maithil.madhushravani.model.SharedPref.IMAGE_URL;
import static com.maithil.madhushravani.model.SharedPref.KEY_NAME;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileInfo extends DialogFragment {
    private static final String TAG = "UserProfileInfo";
    TextView dob,dom,place,occ,name;
    ImageView img;

    FirebaseStorage storage;
    StorageReference storageReference;
    private static FirebaseUser currentUser;
    private FirebaseDatabase database;
    private DatabaseReference dbRefUserdetail, dbRef;

UserData userData;
SharedPref sp;
String data;
UserDetail ud;
    public UserProfileInfo() {
        // Required empty public constructor



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_user_profile_info, container, false);
       dob = v.findViewById(R.id.TextViewDB1);
       dom = v.findViewById(R.id.textViewMD1);
       name = v.findViewById(R.id.und1);
       place = v.findViewById(R.id.textViewPlace1);
       occ = v.findViewById(R.id.textViewOccupation);
       img = v.findViewById(R.id.userImg);
sp = new SharedPref(getContext());
       firebaseStorageReference();

       return v;
    }

    public void firebaseStorageReference() {
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        userData = new UserData();
        database = FirebaseDatabase.getInstance();
//        reference for saving posts
        Bundle b = getArguments();
        if(b!= null) {
            data = b.getString("USER_PROFILE");
        }
        dbRef = database.getReference("/UserPosts/UserProfileInfo/"+data);

        dbRef.addValueEventListener(changeListener);
    }

    ValueEventListener changeListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot ds) {

//            for (DataSnapshot ds : ds1.getChildren()) {
                UserDetail post = new UserDetail();
            if(ds.child("name").exists()) {
                post.setName(ds.child("name").getValue().toString());
            }
            if(ds.child("dob").exists()){
                post.setDob(ds.child("dob").getValue().toString());}
            if(ds.child("dom").exists()){
                post.setDom(ds.child("dom").getValue().toString());}
            if(ds.child("occupation").exists()){
                post.setOcc(ds.child("occupation").getValue().toString());}
            if(ds.child("place").exists()){
                post.setPlace(ds.child("place").getValue().toString());}
            if(ds.child("profileImage").exists()){
                post.setImg(ds.child("profileImage").getValue().toString());}
//                      ud = post;
//            }
                      setUSerInfo(post);

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
//            notifyUser("Database error: " + databaseError.toException());
            Log.d(TAG, "onCancelled: " + databaseError);
        }


    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
return   super.onCreateDialog(savedInstanceState);

    }

    public void setUSerInfo(UserDetail userDetail){
        dob.setText(userDetail.getDob());
        dom.setText(userDetail.getDom());
        name.setText(userDetail.getName());
        place.setText(userDetail.getPlace());
        occ.setText(userDetail.getOcc());

        Glide.with(this)
                .load(userDetail.getImg())
//               .apply(RequestOptions.circleCropTransform())
                .into(img);
    }
}
