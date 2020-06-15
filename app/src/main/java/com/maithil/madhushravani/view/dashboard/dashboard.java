package com.maithil.madhushravani.view.dashboard;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.model.PostsList;
import com.maithil.madhushravani.model.SharedPref;
import com.maithil.madhushravani.model.UserData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static android.app.Activity.RESULT_OK;
import static com.maithil.madhushravani.model.SharedPref.IMAGE_URL;
import static com.maithil.madhushravani.model.SharedPref.KEY_NAME;

/**
 * A simple {@link Fragment} subclass.
 */
public class dashboard extends Fragment implements View.OnClickListener {
    private static final String TAG = "dashboard";
          MaterialCardView shareCard;
    //Firebase
    FirebaseStorage storage;
    StorageReference storageReference;
    private Uri filePath;
    // request code
    private final int PICK_IMAGE_REQUEST = 22;
    private static final int REQUEST_CODE = 101;
    EditText editText;
    LottieAnimationView  select ,cross;
    private Uri downloadUrl ;

      ImageView seletedImg,userImage=null, imageView;
    TextView userText,upload;
    String formattedDate;
    BottomSheetDialog bottomSheetDialog;
RecyclerView rv;
PostsAdapter adapter;
List<PostsList> pl;
    FirebaseAuth auth;
    private static FirebaseUser currentUser;
    private FirebaseDatabase database;
    private DatabaseReference dbRefUserPosts,dbRef;

    SharedPref sp;
    UserData userData;

    public dashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.dashboard, container, false);
        findViewById(view);
        sp = new SharedPref(getContext());
        userData = new UserData();

        recyclerView(view);
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseStorageReference();
//        displaycards();
        return view;
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.shareExp:
                openShareViewFragment();
                break;

            case R.id.selectImg:
                SelectImage();
                break;

            case R.id.upload:
//                SavePosts();
                uploadImage();
                break;
            case R.id.cross:
                 deleteImage();

                 break;
        }
    }

    public interface OnFragmentInteractionListener {
    }
     public void recyclerView(View v){
        rv = v.findViewById(R.id.recyclerView);
         rv.setHasFixedSize(true);
         RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
         rv.setLayoutManager(mLayoutManager);
         pl=new ArrayList<>();

     }
    public void findViewById(View view){
        shareCard = view.findViewById(R.id.shareExp); shareCard.setOnClickListener(this);
//        imageView = view.findViewById(R.id.imageView);


    }
    public void openShareViewFragment(){
        bottomSheetDialog = new BottomSheetDialog(getContext());

        View view1 = getLayoutInflater().inflate(R.layout.post_exp, null);

        bottomSheetDialog.setContentView(view1);
        editText = view1.findViewById(R.id.editText);
        select = view1.findViewById(R.id.selectImg); select.setOnClickListener(this);
        upload = view1.findViewById(R.id.upload); upload.setOnClickListener(this);
        cross = view1.findViewById(R.id.cross); cross.setOnClickListener(this);
        seletedImg = view1.findViewById(R.id.selectedImg);
        userImage = view1.findViewById(R.id.userImg);
        userText = view1.findViewById(R.id.postUND);
        rv = view1.findViewById(R.id.recyclerView);
        updateUserDetail();


        bottomSheetDialog.show();
    }
    public void updateUserDetail() {
        date();
        Glide.with(this)
                .load(sp.pref.getString(IMAGE_URL, ""))
                .apply(RequestOptions.circleCropTransform())
                .into(userImage);
        userText.setText(sp.pref.getString(KEY_NAME,"Anonymous User"));


    }
    public void date(){
        Date c = Calendar.getInstance().getTime();
//    System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(c);
    }

    public void firebaseStorageReference(){
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        database = FirebaseDatabase.getInstance();
//        rfrence for saving posts
        dbRefUserPosts = database.getReference("/UserPosts");
        dbRef = database.getReference("/UserPosts/posts");

        dbRef.addValueEventListener(changeListener);
         dbRef.addChildEventListener(childEventListener);


    }

    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//            adapter.notifyDataSetChanged();
            Log.d(TAG, "onChildAdded: ");
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    ValueEventListener changeListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                PostsList post = new PostsList();

                  post.setName(datasnapshot.child("name").getValue().toString());
                  post.setText(datasnapshot.child("Text").getValue().toString());
                  post.setImg(datasnapshot.child("profileImage").getValue().toString());
                  post.setPostImg(datasnapshot.child("postImage").getValue().toString());
                  post.setTime(datasnapshot.child("time").getValue().toString());
                pl.add(post);
            }

            adapter = new PostsAdapter(pl,getActivity());
            adapter.notifyDataSetChanged();
            rv.setAdapter(adapter);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
//            notifyUser("Database error: " + databaseError.toException());
            Log.d(TAG, "onCancelled: "+ databaseError);
        }


    };
//    read list from db

    public void SavePosts(Uri downloadUrl) {

        userData.setPost(editText.getText().toString());
        userData.setName(sp.pref.getString(KEY_NAME,"Anonymous User"));
        userData.setImgUrl(sp.pref.getString(IMAGE_URL,"UserImg"));
        userData.setTime(formattedDate);
        userData.setUid(currentUser.getUid());

        if (bottomSheetDialog.isShowing()) {
            bottomSheetDialog.dismiss();
        }


        String key = dbRefUserPosts.child(userData.getName())
                .child(currentUser.getUid()).child(userData.getTime()).push().getKey();

        UserData post = new UserData(userData.getUid(), userData.getName(),userData.getImgUrl(), userData.getPost(), userData.getTime(),downloadUrl.toString());
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);
        childUpdates.put("/user-posts/" + userData.getName() + "/" + key, postValues);

        dbRefUserPosts.updateChildren(childUpdates);
    }


    DatabaseReference.CompletionListener completionListener =
            new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError,
                                       DatabaseReference databaseReference) {
                    if (databaseError == null) {
                        Log.i("Poll", "onComplete: SUCCESS");
                    } else {
                        Log.w("Poll", "onComplete: ", databaseError.toException());
                    }
                }
            };
    // Select Image method
    private void SelectImage()
    {

        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
        cross.setVisibility(View.VISIBLE);
    }
    private void deleteImage(){
                   seletedImg.setImageDrawable(null);
                   cross.setVisibility(View.GONE);
    }
    private void uploadImage() {

        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            final StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
//                            Toast.makeText(getActivity(), "Uploaded", Toast.LENGTH_SHORT).show();

                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    downloadUrl = uri;
                                    //Do what you want with the url
                                    SavePosts(downloadUrl);
                                    Toast.makeText(getActivity(), "Upload Done", Toast.LENGTH_LONG).show();
                                    adapter.notifyDataSetChanged();

                                }});
                            if (bottomSheetDialog.isShowing()) {
                                bottomSheetDialog.dismiss();
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity(), "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }

    // Override onActivityResult method
    @Override
    public void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {
                Glide.with(this).load(filePath).into(seletedImg);
            }
            catch (Exception e) {

            }

        }
    }


}
