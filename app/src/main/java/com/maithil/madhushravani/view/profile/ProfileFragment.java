package com.maithil.madhushravani.view.profile;


import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    RadioGroup radioGroup;
    RadioButton hm,wp;
    InputMethodManager imm;

    //    data
    SharedPref sp;
    List<PostsList> pl;
    ProfileAdapter adapter;
    private int mYear, mMonth, mDay, mHour, mMinute, flag;
    UserData userData;
    int dataAdded =0;
    ProgressBar pb;
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
        getOccupation();
        recyclerView(v);
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseStorageReference();
         getPlace();
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
        dbRefUserdetail = database.getReference("/UserPosts/UserProfileInfo");
        dbRef = database.getReference("/UserPosts/user-posts/"+sp.pref.getString(KEY_NAME, "Hello User"));

        dbRef.addValueEventListener(changeListener);
    }

    ValueEventListener changeListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot ds1) {

//            for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
//                for (DataSnapshot ds1 : datasnapshot.getChildren()) {
                    for (DataSnapshot ds : ds1.getChildren()) {
                    PostsList post = new PostsList();
                    post.setName(ds.child("name").getValue().toString());
                    post.setText(ds.child("Text").getValue().toString());
                    post.setImg(ds.child("profileImage").getValue().toString());
                    if(ds.child("postImage").exists()){
                        post.setPostImg(ds.child("postImage").getValue().toString());}                    post.setTime(ds.child("time").getValue().toString());
                    pl.add(post);
                    }
//                }
//            }
            adapter = new ProfileAdapter(pl, getActivity());
            rv.setAdapter(adapter);
            pb.setVisibility(View.GONE);
            adapter.notifyDataSetChanged();

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
//            notifyUser("Database error: " + databaseError.toException());
            Log.d(TAG, "onCancelled: " + databaseError);
        }


    };


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
        radioGroup =view.findViewById(R.id.group);
        hm =view.findViewById(R.id.hm);
        wp =view.findViewById(R.id.wp);
//        add = view.findViewById(R.id.add);
          save = view.findViewById(R.id.save); save.setOnClickListener(this);
//        add.setOnClickListener(this);

        pb = view.findViewById(R.id.pb1);

    }

    @Override
    public void onResume() {
        super.onResume();
 pb.setVisibility(View.VISIBLE);
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
            case R.id.save:
                    SaveUserDetail();
                    save.setVisibility(View.GONE);
                    break;
            case  R.id.textViewPlace:
                editTextPlace.setVisibility(View.VISIBLE);
                place.setVisibility(View.GONE);
                getPlace();
                break;


        }
    }

    public void openDatePicker(final int flag) {
        // Process to get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        save.setVisibility(View.VISIBLE);

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
                            dataAdded = 1;
                        }
                        if (flag == 1) {

                            sp.pref.edit().putString("DOM",dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year).apply();
                            dom.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);
                            dataAdded = dataAdded+1;
                        }

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
        dpd.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(Color.WHITE);
        dpd.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(Color.WHITE);


    }
    private void setUserDetail() {
        DisplayName.setText(sp.pref.getString(KEY_NAME, "Hello User"));
        Glide.with(this)
                .load(sp.pref.getString(IMAGE_URL, ""))
//               .apply(RequestOptions.circleCropTransform())
                .into(profilePic);

        if(!sp.pref.getString("DOB","dd-mm-yyyy").isEmpty()){
            dob.setText(sp.pref.getString("DOB","dd-mm-yyyy"));
        }else{
            dob.setText("Add Now");
            save.setVisibility(View.VISIBLE);

        }

        if(!sp.pref.getString("DOM","dd-mm-yyyy").isEmpty()){
            dom.setText(sp.pref.getString("DOM","dd-mm-yyyy"));
        }else{
            dom.setText("Add Now");
            save.setVisibility(View.VISIBLE);

        }

        if(sp.pref.getString("OCCUPATION","occ").isEmpty()){
            hm.setChecked(false);
            wp.setChecked(false);
            save.setVisibility(View.VISIBLE);

        }else{
            String occ = sp.pref.getString("OCCUPATION","occ");
            if(occ.equals("House Maker")){
                hm.setChecked(true);
            }else if(occ.equals("Working Professional"))
            {
                wp.setChecked(true);

            }
        }


        if(sp.pref.getString("PLACE","place").isEmpty()){
            place.setText("Add Now");
            save.setVisibility(View.VISIBLE);

        }else{
            place.setText(sp.pref.getString("PLACE","place"));
            editTextPlace.setVisibility(View.GONE);
            place.setVisibility(View.VISIBLE);
        }

    }
public void getOccupation(){
    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {                            save.setVisibility(View.VISIBLE);

            // This will get the radiobutton that has changed in its check state
            RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
            // This puts the value (true/false) into the variable
            boolean isChecked = checkedRadioButton.isChecked();
            // If the radiobutton that has changed in check state is now checked...
            if (isChecked)
            {
                // Changes the textview's text to "Checked: example radiobutton text"
                if(checkedId == (R.id.hm)){
                    sp.pref.edit().putString("OCCUPATION","House Maker").apply();
                    hm.setChecked(true);
                }
                else if (checkedId==(R.id.wp)){
                    sp.pref.edit().putString("OCCUPATION","Working Professional").apply();
                     wp.setChecked(true);
                }
                dataAdded = dataAdded +1;
            }
        }
    });
}
public void getPlace(){
    editTextPlace.setOnEditorActionListener(new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
            if(actionId == EditorInfo.IME_ACTION_DONE)
            {
                //Do Something
                Log.d(TAG, "onEditorAction: ");
                editTextPlace.setVisibility(View.GONE);
                place.setVisibility(View.VISIBLE);
                place.setText(sp.pref.getString("PLACE","place"));
                dataAdded = dataAdded+1;
                imm = (InputMethodManager)getActivity().getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextPlace.getApplicationWindowToken(), 0);
            }

            return false;
        }
    });
        
    editTextPlace.addTextChangedListener(new TextWatcher() {

        @Override
        public void afterTextChanged(Editable s) {
//            Log.d(TAG, "afterTextChanged: "+s);
            sp.pref.edit().putString("PLACE",s.toString()).apply();
            Log.d(TAG, "afterTextChanged: "+ sp.pref.getString("PLACE","place"));
            save.setVisibility(View.VISIBLE);

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start,
                                      int count, int after) {
//            Log.d(TAG, "beforeTextChanged: ");
        }

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
            if(s.length() != 0)
            {
                Log.d(TAG, "onTextChanged: "+s);
            }
        }
    });
}
    public void SaveUserDetail() {

        userData.setName(sp.pref.getString(KEY_NAME,"Anonymous User"));
        userData.setImgUrl(sp.pref.getString(IMAGE_URL,"UserImg"));
        userData.setUid(currentUser.getUid());
        userData.setDob(sp.pref.getString("DOB","DD-MM-YYYY"));
        userData.setDom(sp.pref.getString("DOM","DD-MM-YYYY"));
        userData.setPlace(sp.pref.getString("PLACE","place"));
        userData.setOccupation(sp.pref.getString("OCCUPATION","notSpecified"));
//        rewrite code
        UserData post = new UserData( );
        post.UserDataDetail(userData.getName() , userData.getImgUrl(), userData.getDob(),userData.getDom(),userData.getPlace(),userData.getUid(),userData.getOccupation());
        Map<String, Object> postValues = post.toMappProfile();

        dbRefUserdetail
                .child(userData.getName()).setValue(postValues);

        flag =1;

    }



}

