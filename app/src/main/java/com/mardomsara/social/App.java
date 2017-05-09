package com.mardomsara.social;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.mardomsara.social.activities.MainAppActivity;
import com.mardomsara.social.app.LifeCycle;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Hamid on 1/4/2016.
 */
//public class App extends MultiDexApplication {
public class App {
   public static Context getContext() {
      return context;
   }

   public static EventBus getBus(){
      return EventBus.getDefault();
   }

   public static Context context;
   public static Activity _activity;

   public static FragmentManager mFragmentManager;


   public static void activity(Activity activity){
      _activity = activity;
   }

   public static Activity getActivity(){
     return MainAppActivity.instance;
   }
   public static void init(Context ctx){
      context = ctx;
      LifeCycle.initFromActivity(ctx);

   }

}
