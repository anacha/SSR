package se.kth.ssr.base;

import android.app.Application;
import android.content.Context;

import se.kth.ssr.util.operations.generic.ConfigurationsRepo;

/**
 * Created by argychatzi on 6/30/14.
 */
public class SSRApplication extends Application {

    private static ConfigurationsRepo mConfigurationRepo;

    @Override
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        mConfigurationRepo = new ConfigurationsRepo(applicationContext);
    }

    public static ConfigurationsRepo getConfigurationRepo() {
        return mConfigurationRepo;
    }
}
