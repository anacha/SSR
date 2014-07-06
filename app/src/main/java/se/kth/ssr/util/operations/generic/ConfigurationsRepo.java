package se.kth.ssr.util.operations.generic;

import android.content.Context;

import se.kth.ssr.util.operations.CreatorConfiguration;
import se.kth.ssr.util.operations.DividerConfiguration;
import se.kth.ssr.util.operations.RecorderConfiguration;

/**
 * Holder of all kind of operation configurations
 * Created by argychatzi on 6/24/14.
 */
public class ConfigurationsRepo {

    private DividerConfiguration mDividerConfiguration;
    private CreatorConfiguration mCreatorConfiguration;
    private RecorderConfiguration mRecorderConfiguration;

    public ConfigurationsRepo(Context context) {
        mDividerConfiguration   = new DividerConfiguration(context);
        mCreatorConfiguration   = new CreatorConfiguration(context);
        mRecorderConfiguration  = new RecorderConfiguration(context);
    }

    public DividerConfiguration getDividerConfiguration() {
        return mDividerConfiguration;
    }

    public CreatorConfiguration getCreatorConfiguration() {
        return mCreatorConfiguration;
    }

    public RecorderConfiguration getRecorderConfiguration() {
        return mRecorderConfiguration;
    }
}
