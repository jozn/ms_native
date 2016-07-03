package com.mardomsara.social.helpers;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

/**
 * Created by Hamid on 5/9/2016.
 */
public class GpsUtil {
    static LocationManager locationManager;
    static boolean isNetworkEnabled = false, isGPSEnabled = false;
    static Location location;
    static double latitude, longitude;
    public static Location getCurrentLocation(Context context) {
        try {
            locationManager = (LocationManager) context
                    .getSystemService(context.LOCATION_SERVICE);

            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
            System.out.println("gps band chhe" + isGPSEnabled);
            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
//                Common.showGPSDisabledAlert("Please enable your location or tryConnect to cellular network.", context);
            } else {
                ///BY ME:
//                if (isNetworkEnabled) {
//                    Log.d("Network", "Network");
//                    if (locationManager != null) {
//                        location = locationManager
//                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                        if (location != null) {
//                            latitude = location.getLatitude();
//                            longitude = location.getLongitude();
//                        }
//                    }
//                }
//                // if GPS Enabled get lat/long using GPS Services
//                if (isGPSEnabled) {
//                    if (location == null) {
//                        Log.d("GPS Enabled", "GPS Enabled");
//                        if (locationManager != null) {
//                            location = locationManager
//                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
//                            if (location != null) {
//                                latitude = location.getLatitude();
//                                longitude = location.getLongitude();
//                            }
//                        }
//                    }
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

}
