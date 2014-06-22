package se.kth.ssr.activities;

import android.app.Activity;

import se.kth.ssr.utils.Configuration;
import se.kth.ssr.utils.DefaultConfiguration;
import se.kth.ssr.utils.configurations.ConfigurationProvider;

/**
 * Created by argychatzi on 6/22/14.
 */
public class DefaultConfigurationActivity extends Activity implements ConfigurationProvider {
    @Override
    public Configuration getConfiguration() {
        return DefaultConfiguration.getInstance(this);
    }
}
