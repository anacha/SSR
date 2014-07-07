package se.kth.ssr.util.operations.generic;

import android.content.Context;

import se.kth.ssr.util.operations.player.ATPlayerConf;
import se.kth.ssr.util.operations.DividerConf;
import se.kth.ssr.util.operations.RecorderConf;
import se.kth.ssr.util.operations.player.MPPlayerConf;

/**
 * Holder of all kind of operation configurations
 * Created by argychatzi on 6/24/14.
 */
public class ConfigurationsRepo {

    private DividerConf mDividerConf;
    private RecorderConf mRecorderConfiguration;
    private ATPlayerConf mATPlayerConfiguration;
    private MPPlayerConf mMPPlayerConfiguration;

    public ConfigurationsRepo(Context context) {

        String path = context.getExternalFilesDir(null).getAbsolutePath();

        mDividerConf = new DividerConf();
        mRecorderConfiguration = new RecorderConf();
        mATPlayerConfiguration = new ATPlayerConf();
        mMPPlayerConfiguration = new MPPlayerConf();
    }

    public MPPlayerConf getMPPlayerConfiguration() {
        return mMPPlayerConfiguration;
    }

    public ATPlayerConf getATPlayerConfiguration() {
        return mATPlayerConfiguration;
    }

    public DividerConf getDividerConfiguration() {
        return mDividerConf;
    }

    public RecorderConf getRecorderConfiguration() {
        return mRecorderConfiguration;
    }
}
