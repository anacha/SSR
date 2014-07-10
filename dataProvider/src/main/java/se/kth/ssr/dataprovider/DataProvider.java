package se.kth.ssr.dataprovider;

import se.kth.ssr.dataprovider.networkprovider.NetworkProvider;
import se.kth.ssr.dataprovider.networkprovider.NetworkConfiguration;

/**
 * Created by argychatzi on 7/11/14.
 */
public class DataProvider {

    private NetworkProvider mNetworkProvider;


    public NetworkProvider getNetworkProvider() {
        return mNetworkProvider;
    }

    public DataProvider(NetworkConfiguration networkConfiguration) {
        mNetworkProvider = new NetworkProvider(networkConfiguration);

    }
}

