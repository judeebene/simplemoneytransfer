package com.shareqube.judeben.mmt;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.CollapsingToolbarLayout;





public class MainActivityFragment extends Fragment {

    public static String TAG =   MainActivityFragment.class.getSimpleName();

    View rootView ;
    CollapsingToolbarLayout mcolapsingtoolbar ;
    Toolbar mToolBar ;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);




        return  rootView ;
    }
}
