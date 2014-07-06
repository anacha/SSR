package se.kth.ssr.util.operations.generic;

import android.content.Context;

import se.kth.ssr.util.operations.DividerConf;
import se.kth.ssr.util.operations.PlayerConf;
import se.kth.ssr.util.operations.RecorderConf;

/**
 * Holder of all kind of operation configurations
 * Created by argychatzi on 6/24/14.
 */
public class ConfigurationsRepo {

    private DividerConf mDividerConf;
    private RecorderConf mRecorderConfiguration;
    private PlayerConf mPlayerConfiguration;

    public ConfigurationsRepo(Context context) {

        String path = context.getExternalFilesDir(null).getAbsolutePath();

        mDividerConf = new DividerConf();
        mPlayerConfiguration = new PlayerConf();
        mRecorderConfiguration = new RecorderConf();
    }

    public DividerConf getDividerConfiguration() {
        return mDividerConf;
    }

    public PlayerConf getCreatorConfiguration() {
        return mPlayerConfiguration;
    }

    public RecorderConf getRecorderConfiguration() {
        return mRecorderConfiguration;
    }
}
