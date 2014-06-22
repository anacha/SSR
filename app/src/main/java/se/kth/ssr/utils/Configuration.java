package se.kth.ssr.utils;

import se.kth.ssr.utils.configurations.PlayerConfiguration;
import se.kth.ssr.utils.configurations.RecorderConfiguration;

/**
 * Created by argychatzi on 6/21/14.
 */
public interface Configuration extends PlayerConfiguration, RecorderConfiguration {
    public int getFragmentSizeInBytes();
    public int getSamplingRateInHz();
}