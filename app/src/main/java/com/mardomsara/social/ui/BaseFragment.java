package com.mardomsara.social.ui;

//import android.app.Fragment;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mardomsara.social.App;
import com.mardomsara.social.AppAplication;
import com.squareup.leakcanary.RefWatcher;

import java.util.HashMap;
import java.util.Map;

import hugo.weaving.DebugLog;

/**
 * Created by Hamid on 2/1/2016.
 */
@Deprecated
public class BaseFragment extends Fragment {
    public Map<String, Object> params = new HashMap<>();

    String classTag = "";
    public void setClassTag(String classTag) {
        this.classTag = classTag;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(0xFFFFFF);
        logIt(" BaseFragment onViewCreated");
    }

    @DebugLog
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        logIt("onActivityCreated");
        App.init(getActivity());
//        getChildFragmentManager()
    }

    public static void setMargins (View v, int l){//, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, 0, 0, 0);
            v.requestLayout();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        logIt("onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        logIt("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logIt("onCreate");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        logIt("onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        logIt("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        logIt("onResume");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logIt("onSaveInstanceState");
    }

    @Override
    public void onPause() {
        super.onPause();
        logIt("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        logIt("onStop");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        logIt("onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        logIt("onLowMemory");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        logIt("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        logIt("onDestroy");
        RefWatcher refWatcher = AppAplication.getRefWatcher(getActivity());
//        refWatcher.watch(this);
        if(refWatcher != null){
            refWatcher.watch(this, getClass().getSimpleName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        logIt("onDetach");
    }

    protected void logIt(String str){
        String cls = classTag.equals("") ? getClass().getSimpleName() : classTag;
        Log.v("BaseFragment: ", cls + " : "+ str);
    }

}
