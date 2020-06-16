package com.maithil.madhushravani.view.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.maithil.madhushravani.R;
import com.maithil.madhushravani.model.PostsList;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {
        List<PostsList> list;
        Context context;

public ProfileAdapter(List<PostsList> list,Context ctx) {
        this.list = list;
        this.context = ctx;
        }

@NonNull
@Override
public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_dashboard,parent,false);
        return new ProfileViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        PostsList pl = list.get(position);
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
        }

@Override
public int getItemCount() {
        return list.size();
        }



public class ProfileViewHolder extends RecyclerView.ViewHolder {

        ImageView userImg,postedImg;
        TextView name,post,time;
        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            userImg = itemView.findViewById(R.id.userImg);
            postedImg = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.cloudUND);
            post = itemView.findViewById(R.id.headline);
            time = itemView.findViewById(R.id.usertime);


        }
    }
}
