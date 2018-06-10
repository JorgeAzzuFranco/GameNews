package com.includeazzu.gamenews.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.includeazzu.gamenews.R;


public class CSGOFragment extends Fragment {


    public CSGOFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_csgo, container, false);
    }

    public interface OnNavigationItemSelectedListener {
    }
}
