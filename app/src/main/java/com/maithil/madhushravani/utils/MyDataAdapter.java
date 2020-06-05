package com.maithil.madhushravani.utils;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gtomato.android.ui.widget.CarouselView;
import com.maithil.madhushravani.R;

import java.util.List;

public  class MyDataAdapter extends CarouselView.Adapter<MyDataAdapter.ViewHolder> {
    private static final String TAG = "MyDataAdapter";
    List<Integer> mdaysNumber ;
    public MyDataAdapter(List<Integer> daysNumber) {
        mdaysNumber = daysNumber;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        MyView view = MyView.create(parent.getContext(), VIEW_WIDTH, VIEW_HEIGHT);
//        return new ViewHolder(view);
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.days_cards, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.getView().bind(position + 1);
//        holder.day.setText(mdaysNumber.get(position));
    }

    @Override
    public int getItemCount() {
        return mdaysNumber.size();
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder {
        TextView day;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
        }
    }
}
