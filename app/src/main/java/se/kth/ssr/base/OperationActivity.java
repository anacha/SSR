package se.kth.ssr.base;

import android.app.Activity;

import se.kth.ssr.util.operations.player.ATPlayerConf;
import se.kth.ssr.util.operations.DividerConf;
import se.kth.ssr.util.operations.RecorderConf;
import se.kth.ssr.util.operations.player.MPPlayerConf;

/**
 * Created by argychatzi on 7/6/14.
 */
public class OperationActivity extends Activity {

    public DividerConf getDividerConfiguration() {
        return SSRApplication.getConfigurationRepo().getDividerConfiguration();
    }

    public ATPlayerConf getPlayerConfiguration() {
        return SSRApplication.getConfigurationRepo().getATPlayerConfiguration();
    }

    public MPPlayerConf getMPPlayerConfiguration() {
        return SSRApplication.getConfigurationRepo().getMPPlayerConfiguration();
    }

    public RecorderConf getRecorderConfiguration() {
        return SSRApplication.getConfigurationRepo().getRecorderConfiguration();
    }

}
