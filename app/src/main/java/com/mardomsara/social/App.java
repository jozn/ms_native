package com.mardomsara.social;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.ui.BasePresenter;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.HashSet;
import java.util.Set;

import pl.tajchert.nammu.Nammu;

//import com.facebook.stetho.Stetho;

//import android.app.FragmentManager;
//import com.mardomsara.social.base.WSBase;

/**
 * Created by Hamid on 1/4/2016.
 */
public class App extends Application {
   public static Context getContext() {
      return context;
   }

   //   private static WSBase ws;
   public static Context context;
   public static Activity _activity;
   private static boolean isInintiolized = false;
//   public static ReactInstanceManager mReactInstanceManager;
//   public static ReactRootView mReactRootView;
   public static FragmentManager mFragmentManager;

   @Override
   public void onCreate() {
      super.onCreate();
     /* CalligraphyConfig*//*.initDefault(new CalligraphyConfig.Builder()
                      .setDefaultFontPath("fonts/Roboto-Light.ttf")
                      .setFontAttrId(R.attr.fontPath)
                      .build()
     );*/
      //....
   }

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
     return _activity;
   }
   public static void init(Context ctx){
      context = ctx;
      AppUtil._context = ctx;
//      AppUtil._context = ctx;

      if(isInintiolized == false){
         Nammu.init(ctx);
         Set<RequestListener> requestListeners = new HashSet<>();
         requestListeners.add(new RequestLoggingListener());
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
//         mFragmentManager
      }
//      context =(Context) context;
   }

   public static void runStetho(Context ctx){
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

}
