package com.maithil.madhushravani.view.profile;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
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
import com.maithil.madhushravani.view.dashboard.PostsAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.maithil.madhushravani.model.SharedPref.IMAGE_URL;
import static com.maithil.madhushravani.model.SharedPref.KEY_NAME;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "ProfileFragment";

    //    ui
    ImageView profilePic;
    TextView DisplayName,add,save;
    RecyclerView rv;
    TextView dob, dom, place;
    EditText editTextPlace;
    //    data
    SharedPref sp;
    List<PostsList> pl;
    ProfileAdapter adapter;
    private int mYear, mMonth, mDay, mHour, mMinute, flag;
    UserData userData;
    int add_save =0;

    //    firebase
//Firebase
    FirebaseStorage storage;
    StorageReference storageReference;
    private static FirebaseUser currentUser;
    private FirebaseDatabase database;
    private DatabaseReference dbRefUserdetail, dbRef;

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

        recyclerView(v);
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseStorageReference();

        return v;
    }

    public void recyclerView(View v) {
        rv = v.findViewById(R.id.recyclerViewprofile);
        rv.setHasFixedSize(true);
//         RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        rv.setLayoutManager(linearLayoutManager);
//         rv.setLayoutManager(mLayoutManager);
        pl = new ArrayList<>();


    }

    public void firebaseStorageReference() {
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        userData = new UserData();
        database = FirebaseDatabase.getInstance();
//        reference for saving posts
        dbRefUserdetail = database.getReference("/UserPosts");
        dbRef = database.getReference("/UserPosts/user-posts");

        dbRef.addValueEventListener(changeListener);
    }

    ValueEventListener changeListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                for (DataSnapshot ds : datasnapshot.getChildren()) {
//                    for (DataSnapshot ds : ds1.getChildren()) {
                    PostsList post = new PostsList();
                    post.setName(ds.child("name").getValue().toString());
                    post.setText(ds.child("Text").getValue().toString());
                    post.setImg(ds.child("profileImage").getValue().toString());
                    post.setPostImg(ds.child("postImage").getValue().toString());
                    post.setTime(ds.child("time").getValue().toString());
                    pl.add(post);
//                    }
                }
            }
            adapter = new ProfileAdapter(pl, getActivity());
            rv.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
//            notifyUser("Database error: " + databaseError.toException());
            Log.d(TAG, "onCancelled: " + databaseError);
        }


    };

    private void setUserDetail() {
        DisplayName.setText(sp.pref.getString(KEY_NAME, "Hello User"));
        Glide.with(this)
                .load(sp.pref.getString(IMAGE_URL, ""))
//               .apply(RequestOptions.circleCropTransform())
                .into(profilePic);

        if(!sp.pref.getString("DOB","DD-MM-YYYY").isEmpty()){
            dob.setText(sp.pref.getString("DOB","DD-MM-YYYY"));
        }

        if(!sp.pref.getString("DOM","DD-MM-YYYY").isEmpty()){
            dom.setText(sp.pref.getString("DOM","DD-MM-YYYY"));
        }

        if(!sp.pref.getString("place","place").isEmpty()){
            place.setText(sp.pref.getString("place","place"));
        }
//           place.setText(sp.pref.getString("place","Place"));
    }

    private void findViewById(View view) {
        profilePic = view.findViewById(R.id.userImg);
        DisplayName = view.findViewById(R.id.und);
        dob = view.findViewById(R.id.TextViewDB);
        dob.setOnClickListener(this);
        dom = view.findViewById(R.id.textViewMD);
        dom.setOnClickListener(this);
        place = view.findViewById(R.id.textViewPlace);
        place.setOnClickListener(this);
        editTextPlace = view.findViewById(R.id.editTextPlace);
        editTextPlace.setOnClickListener(this);
        add = view.findViewById(R.id.add);
          save = view.findViewById(R.id.save); save.setOnClickListener(this);
        add.setOnClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.TextViewDB:
                flag = 0;
                openDatePicker(0);
                break;
            case R.id.textViewMD:
                openDatePicker(1);
                break;
            case R.id.textViewPlace:
                sp.pref.edit().putString("place",editTextPlace.getText().toString()).apply();
                break;

            case R.id.add:
                    dob.setEnabled(true);
                    dom.setEnabled(true);
                    place.setVisibility(View.GONE);
                    editTextPlace.setVisibility(View.VISIBLE);
                    editTextPlace.setFocusable(true);
                   add.setVisibility(View.GONE);
                save.setVisibility(View.VISIBLE);
                break;

            case R.id.save:
//                    sp.pref.edit().putString("place",editTextPlace.getText().toString()).apply();
                     place.setText(editTextPlace.getText().toString());
                     place.setVisibility(View.VISIBLE);
                     add.setVisibility(View.GONE);
                     editTextPlace.setVisibility(View.GONE);
                    SaveUserDetail();
                      break;




        }
    }

    public void openDatePicker(final int flag) {
        // Process to get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog dpd = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Display Selected date in textbox
                        if (flag == 0) {
                            sp.pref.edit().putString("DOB",dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year).apply();
                            dob.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);
                        }
                        if (flag == 1) {

                            sp.pref.edit().putString("DOM",dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year).apply();
                            dom.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);
                        }

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
        dpd.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(Color.WHITE);
        dpd.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(Color.WHITE);


    }

   public void SaveUserDetail() {

        userData.setName(sp.pref.getString(KEY_NAME,"Anonymous User"));
        userData.setImgUrl(sp.pref.getString(IMAGE_URL,"UserImg"));
        userData.setUid(currentUser.getUid());
        userData.setDob(sp.pref.getString("DOB","DD-MM-YYYY"));
        userData.setDom(sp.pref.getString("DOM","DD-MM-YYYY"));
        userData.setPlace(sp.pref.getString("place","Delhi"));


       String key = dbRefUserdetail.child(userData.getName())
                .child(currentUser.getUid()).push().getKey();
        UserData post = new UserData( );
        post.UserDataDetail(userData.getName() , userData.getImgUrl(), userData.getDob(),userData.getDom(),userData.getPlace(),userData.getUid());
        Map<String, Object> postValues = post.toMappProfile();

        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put("/UserDetails/"+userData.getName()+"/")
//        childUpdates.put("/posts/" + key, postValues);
        childUpdates.put("/UserDetails/" + userData.getName() + "/" + key, postValues);
        dbRefUserdetail.updateChildren(childUpdates);
        flag =1;

    }


}

