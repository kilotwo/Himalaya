package com.wz.himalaya.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wz.himalaya.R;
import com.wz.himalaya.base.BaseFragement;

public class HistoryFragment extends BaseFragement {
    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        View view = layoutInflater.inflate(R.layout.fragment_histiory,container,false);
        return view;
    }
}
