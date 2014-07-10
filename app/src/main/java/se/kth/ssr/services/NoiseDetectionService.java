package se.kth.ssr.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by argychatzi on 7/11/14.
 */
public class NoiseDetectionService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
