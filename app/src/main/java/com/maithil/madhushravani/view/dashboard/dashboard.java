package com.maithil.madhushravani.view.dashboard;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.maithil.madhushravani.model.SharedPref;
import com.maithil.madhushravani.model.UserData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

      ImageView seletedImg,userImage=null, imageView;
    TextView userText,upload;
    String formattedDate;

    FirebaseAuth auth;
    private static FirebaseUser currentUser;
    private FirebaseDatabase database;
    private DatabaseReference dbRef;

    SharedPref sp;
    UserData userData;
    Bitmap bitmap;
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
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseStorageReference();
        displaycards();
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
                uploadImage();
                break;
            case R.id.cross:
                 deleteImage();

                 break;
        }
    }

    public interface OnFragmentInteractionListener {
    }

    public void findViewById(View view){
        shareCard = view.findViewById(R.id.shareExp); shareCard.setOnClickListener(this);
        imageView = view.findViewById(R.id.imageView);


    }
    public void openShareViewFragment(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());

        View view1 = getLayoutInflater().inflate(R.layout.post_exp, null);

        bottomSheetDialog.setContentView(view1);
        editText = view1.findViewById(R.id.editText);
        select = view1.findViewById(R.id.selectImg); select.setOnClickListener(this);
        upload = view1.findViewById(R.id.upload); upload.setOnClickListener(this);
        cross = view1.findViewById(R.id.cross); cross.setOnClickListener(this);
        seletedImg = view1.findViewById(R.id.selectedImg);
        userImage = view1.findViewById(R.id.userImg);
        userText = view1.findViewById(R.id.postUND);
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
        dbRef = database.getReference("/data");
        dbRef.addValueEventListener(changeListener);
    }

    ValueEventListener changeListener = new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            String change = dataSnapshot.child(
                    currentUser.getUid()).child("message")
                    .getValue(String.class);

//            userText.setText(change);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
//            notifyUser("Database error: " + databaseError.toException());
            Log.d(TAG, "onCancelled: "+ databaseError);
        }
    };
    public void saveData() {

        userData.setPost(editText.getText().toString());
        userData.setName(sp.pref.getString(KEY_NAME,"Anonymous User"));
        userData.setImgUrl(sp.pref.getString(IMAGE_URL,"UserImg"));
        userData.setTime(formattedDate);

        dbRef.child(userData.getName())
        .child(currentUser.getUid()).child(userData.getTime()).child("Post")
//                .setValue(userText.getText().toString(), completionListener);
                .setValue(userData, completionListener);

    }

    DatabaseReference.CompletionListener completionListener =
            new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError,
                                       DatabaseReference databaseReference) {

                    if (databaseError != null) {
//                        notifyUser(databaseError.getMessage());
                        Log.d(TAG, "onComplete: "+ databaseError.getMessage() );
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

        saveData();
        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity(), "Uploaded", Toast.LENGTH_SHORT).show();
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
    private static int exifToDegrees(int exifOrientation) {
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) { return 90; }
        else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {  return 180; }
        else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {  return 270; }
        return 0;
    }

    private void displaycards(){
        Glide.with(this).load(R.drawable.tst_img).into(imageView);
    }
}
// bitmap = MediaStore
//         .Images
//         .Media
//         .getBitmap(
//         getActivity().getContentResolver(),
//         filePath);
//         seletedImg.setImageBitmap(bitmap);