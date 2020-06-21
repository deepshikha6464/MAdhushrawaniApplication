package com.maithil.madhushravani.view.explore;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.maithil.madhushravani.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AripanFragment extends Fragment {
 String data;
 LinearLayout fullodhi;
 ImageView gauri,bishar,aripan,others;

    public AripanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_aripan, container, false);
        fullodhi = view.findViewById(R.id.fuLodhi);
        gauri = view.findViewById(R.id.gauri);
        bishar = view.findViewById(R.id.bishar);
        aripan = view.findViewById(R.id.aripan);
        others = view.findViewById(R.id.others);


        Bundle b = getArguments();
        if(b!= null) {
            data = b.getString("UNIQUE_KEY");
        }
//        int id = view.getId();
        switch (data) {
            case "fulLodhi":
                fullodhi.setVisibility(View.VISIBLE);
                break;
            case "gauri":
                            gauri.setVisibility(View.VISIBLE);
                            break;
            case "bishar":
                            bishar.setVisibility(View.VISIBLE);
                            break;
            case "aripan":
                aripan.setVisibility(View.VISIBLE);
                break;
              case "others":
                            others.setVisibility(View.VISIBLE);
                            break;

        }
            return view;
    }

}
