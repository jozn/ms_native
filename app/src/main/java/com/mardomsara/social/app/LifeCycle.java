package com.mardomsara.social.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.mardomsara.social.App;
import com.mardomsara.social.base.Command;
import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.models.NotifyModel;
import com.mardomsara.social.models.Session;
import com.mardomsara.social.service.BackgroundService;
import com.mardomsara.social.service.WSService;
import com.mardomsara.social.ui.BasePresenter;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.Set;

import pl.tajchert.nammu.Nammu;

/**
 * Created by Hamid on 7/2/2016.
 */
public class LifeCycle {

    public static void initFromActivity(Context ctx){

        if(true) {
            Intent i = new Intent(ctx,BackgroundService.class);
            ctx.startService(i);
        }

    }

    public static void initFromBackground(Context ctx){
        initCommon(ctx);
        onAfterAppStartedCommon();
    }

    private static boolean isInitialized = false;
    public static void initCommon(Context ctx) {
        AppUtil._context = ctx;
        App.context = ctx;
        if (isInitialized == false) {
            isInitialized = true;
            //////////////////////////////////////////
            Picasso p = new Picasso.Builder(ctx)
                    .memoryCache(new LruCache(100000000))
                    .build();
            Picasso.setSingletonInstance(p);
//         Picasso.with(AppUtil.getContext()).setIndicatorsEnabled(true);
            Picasso.with(AppUtil.getContext()).setLoggingEnabled(true);
            /////////////////////////////////////////

            Nammu.init(ctx);
            Set<RequestListener> requestListeners = new HashSet<>();
            requestListeners.add(new RequestLoggingListener());
            ImagePipelineConfig config = ImagePipelineConfig.newBuilder(ctx)
                    // other setters
                    .setRequestListeners(requestListeners)
                    .build();
            Fresco.initialize(ctx, config);
            FLog.setMinimumLoggingLevel(FLog.VERBOSE);
//         LeakCanary.install(ctx);
            Hawk.init(ctx)
                    .setEncryptionMethod(HawkBuilder.EncryptionMethod.NO_ENCRYPTION)
                    .build();

            BasePresenter.context = ctx;
            BasePresenter.inflater = LayoutInflater.from(ctx);
            FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
            FlowManager.init(new FlowConfig.Builder(ctx)
                    .openDatabasesOnInit(true).build());

            DB.init();

        }
    }

    public static void onAppActivityStarted(){
//        Sync.syncAllFollowings();
        Sync.checkSyncContacts();
        Sync.syncAllFollowings();

        NotifyModel.getSyncLasts();
    }

    static boolean _afterActivityCalled = false;
    public static void onAfterAppActivityStarted(){
        if(_afterActivityCalled) return;
        onAfterAppStartedCommon();
        _afterActivityCalled = true;
    }

    static boolean _afterCalled = false;
    public static void onAfterAppStartedCommon(){
        if(_afterCalled) return;
        //////////////
        AppFiles.buildAllDirs();
        //////////////
        Command cmd = new Command();
        cmd.Name = "Echo";
        WSService.sendCommand(cmd);
        Session.fetchUserInfoFromServer();
        /////////////
        _afterCalled = true;
    }


    public static void onAppActivityStartedNowHttpConnected(){

    }

    public static void onAppActivityStartedNowWebsocketConnected(){

    }

    public static void onAppBackgroundStarted(){


    }


}
