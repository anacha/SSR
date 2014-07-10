package se.kth.ssr.base;

import android.app.Application;
import android.content.Context;

import se.kth.ssr.dataprovider.DataProvider;
import se.kth.ssr.dataprovider.networkprovider.NetworkConfiguration;
import se.kth.ssr.util.operations.generic.ConfigurationsRepo;

/**
 * Created by argychatzi on 6/30/14.
 */
public class SSRApplication extends Application {

    private static ConfigurationsRepo mConfigurationRepo;
    private DataProvider mDataProvider;

    @Override
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        mConfigurationRepo = new ConfigurationsRepo(applicationContext);

        initDataProvider();
    }

    private void initDataProvider() {
        String baseUrl = "https://www.dropbox.com";
        NetworkConfiguration networkConfiguration = new NetworkConfiguration(baseUrl);
        mDataProvider = new DataProvider(networkConfiguration);
    }

    public static ConfigurationsRepo getConfigurationRepo() {
        return mConfigurationRepo;
    }
}
