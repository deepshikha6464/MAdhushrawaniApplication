package com.maithil.madhushravani.view.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.model.PostsList;

import java.util.List;

import static com.maithil.madhushravani.model.SharedPref.IMAGE_URL;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
List<PostsList> list;
//    PostsList pl;
Context context;
    private static ItemClickListener mClickListener;
    FragmentManager fm;

//    ads
// A menu item view type.
private static final int MENU_ITEM_VIEW_TYPE = 0;

    // The unified native ad view type.
    private static final int UNIFIED_NATIVE_AD_VIEW_TYPE = 1;

    public PostsAdapter(List<PostsList> list, Context ctx, FragmentManager fm) {
        this.list = list;
        this.context = ctx;
        this.fm = fm;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_dashboard,parent,false);
        return new PostsViewHolder(view,mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostsViewHolder holder, int position) {
                 final PostsList  pl = list.get(position);
                  holder.name.setText(pl.getName());
                  holder.time.setText(pl.getTime());
                  holder.post.setText(pl.getText());

        Glide.with(context)
                .load(pl.getImg())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.userImg);

        Glide.with(context)
                .load(pl.getPostImg())
                .into(holder.postedImg);

        holder.userImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = pl.getName();
              Bundle  b = new Bundle();
                b.putString("USER_PROFILE", name);
                Fragment myFragment = new UserProfileInfo();
                myFragment.setArguments(b);
                (myFragment).onCreateAnimation(R.animator.anim_in,true,R.animator.anim_out);
             ((UserProfileInfo) myFragment).show(fm, "tag");

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class PostsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView userImg,postedImg;
        TextView name,post,time;
        ItemClickListener itemClickListener;
        LinearLayout userImg1;

        public PostsViewHolder(@NonNull View itemView,ItemClickListener mClickListener) {
            super(itemView);
            userImg = itemView.findViewById(R.id.userImg);
            postedImg = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.cloudUND);
            post = itemView.findViewById(R.id.headline);
            time = itemView.findViewById(R.id.usertime);
            userImg1 = itemView.findViewById(R.id.userImg1);
           this.itemClickListener = mClickListener;
           userImg.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
//open user profile fragment when image is clicked in card view
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

//used for performing click operationfrom calling activity
//    and it will call from here
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
