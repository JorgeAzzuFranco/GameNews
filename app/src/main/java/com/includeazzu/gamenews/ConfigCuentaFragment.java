package com.includeazzu.gamenews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.includeazzu.gamenews.R;


public class ConfigCuentaFragment extends Fragment {


    public ConfigCuentaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_config_cuenta, container, false);
    }

    public interface OnNavigationItemSelectedListener {
    }
}
