package com.mardomsara.social;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
//import android.support.multidex.MultiDexApplication;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.mardomsara.social.activities.MainAppActivity;
import com.mardomsara.social.app.LifeCycle;
import com.mardomsara.social.helpers.AppUtil;

import org.greenrobot.eventbus.EventBus;

//import com.mardomsara.social.tables.orma.DB;

//import com.facebook.stetho.Stetho;

//import android.app.FragmentManager;
//import com.mardomsara.social.base.WSBase;

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

   //   private static WSBase ws;
   public static Context context;
   public static Activity _activity;
   private static boolean isInintiolized = false;
//   public static ReactInstanceManager mReactInstanceManager;
//   public static ReactRootView mReactRootView;
   public static FragmentManager mFragmentManager;

   /*@Override
   public void onCreate() {
      super.onCreate();
     *//* CalligraphyConfig*//**//*.initDefault(new CalligraphyConfig.Builder()
                      .setDefaultFontPath("fonts/Roboto-Light.ttf")
                      .setFontAttrId(R.attr.fontPath)
                      .build()
     );*//*
      //....
   }*/

//   public static WSBase getWS(){
//      if(ws == null){
//         ws = new WSBase(URI.create("ws://192.168.0.10:5000/ws"));
//      }
//      return ws;
//   }

   public static void activity(Activity activity){
      _activity = activity;
   }

   public static Activity getActivity(){
     return MainAppActivity.instance;
   }
   public static void init(Context ctx){
      context = ctx;
      LifeCycle.initFromActivity(ctx);
/*      AppUtil._context = ctx;
//      AppUtil._context = ctx;


      if(isInintiolized == false){
         isInintiolized = true;

         //////////////////////////////////////////
         Picasso p = new Picasso.Builder(context)
                 .memoryCache(new LruCache(100000000))
                 .build();
         Picasso.setSingletonInstance(p);
//         Picasso.with(AppUtil.getContext()).setIndicatorsEnabled(true);
         Picasso.with(AppUtil.getContext()).setLoggingEnabled(true);
         /////////////////////////////////////////

         Nammu.init(ctx);
         Set<RequestListener> requestListeners = new HashSet<>();
         requestListeners.addStart(new RequestLoggingListener());
         ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
                 // other setters
                 .setRequestListeners(requestListeners)
                 .build();
         Fresco.initialize(context, config);
         FLog.setMinimumLoggingLevel(FLog.VERBOSE);
//         LeakCanary.install(ctx);
         Hawk.init(context)
                 .setEncryptionMethod(HawkBuilder.EncryptionMethod.NO_ENCRYPTION)
                 .build();

//         Fresco.initialize(ctx);
//         Stetho.initializeWithDefaults(context);
         runStetho(ctx);
         BasePresenter.context = ctx;
         BasePresenter.inflater = LayoutInflater.from(ctx);
         FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
         FlowManager.init(new FlowConfig.Builder(ctx)
                 .openDatabasesOnInit(true).build());

         DB.init();

//         mFragmentManager
//         play();
      }
//      context =(Context) context;
      */
   }

   public static void runStetho(Context ctx){
		View v = new View(ctx);
//	   new Notification.Builder(ctx)

//	   _activity.setRequestedOrientation(ActivityInfo.);
//	   v.setSystemUiVisibility();
//	   R.style.Theme_FullScreenDialog
//	   AppUtil.getContext().getPackageManager().queryIntentActivities().get(0).activityInfo.applicationInfo.packageName;
//	   Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT

//	   FragmentManager
//	   View
//	   AppUtil.getContext().getPackageManager().resolveActivity()
//	   AppUtil.getContext().getAssets().open("").read()
//	   Intent.ACTION_ANSWER;
//	   CursorWrapper
//	   Build.VERSION.SDK_INT
   /*   // Create an InitializerBuilder
      Stetho.InitializerBuilder initializerBuilder =
              Stetho.newInitializerBuilder(ctx);

      // Enable Chrome DevTools
      initializerBuilder.enableWebKitInspector(
              Stetho.defaultInspectorModulesProvider(ctx)
      );

      // Enable command line interface
      initializerBuilder.enableDumpapp(
              Stetho.defaultDumperPluginsProvider(ctx)
      );

      // Use the InitializerBuilder to generate an Initializer
      Stetho.Initializer initializer = initializerBuilder.build();

      // Initialize Stetho with the Initializer
      Stetho.initialize(initializer);*/
   }

/*
   public static void play(){

      DB db = DB.builder(AppUtil.getContext())
              .readOnMainThread(AccessThreadConstraint.WARNING)
              .name("ms1")
              .trace(true)
              .build();

      AndroidUtil.runInBackground(()-> {
                 db.transactionSync(() -> {
                    for (int i = 0; i < 100; i++) {
                       Notifications not = new Notifications();
                       not.Id = (long) i;
                       not.CreatedTime = (int) AppUtil.getTimeSec();
                       not.Load = JsonUtil.toJson(new UserInfoJson());
                       db.insertIntoNotifications(not);
                    }
                 });
              });

//      orma.selectFromTodo().toList().;
//      orma.relationOfTodo().inserter().execute();
//      orma.transactionSync();
   }
*/

}
