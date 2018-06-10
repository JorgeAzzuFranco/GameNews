package com.includeazzu.gamenews.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.includeazzu.gamenews.R;

public class DOTAFragment extends Fragment {


    public DOTAFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dota, container, false);
    }

    public interface OnNavigationItemSelectedListener {
    }
}
