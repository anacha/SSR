package se.kth.ssr.base;

import android.app.Activity;

import se.kth.ssr.util.operations.DividerConf;
import se.kth.ssr.util.operations.PlayerConf;
import se.kth.ssr.util.operations.RecorderConf;

/**
 * Created by argychatzi on 7/6/14.
 */
public class OperationActivity extends Activity {

    public DividerConf getDividerConfiguration() {
        return SSRApplication.getConfigurationRepo().getDividerConfiguration();
    }

    public PlayerConf getPlayerConfiguration() {
        return SSRApplication.getConfigurationRepo().getCreatorConfiguration();
    }

    public RecorderConf getRecorderConfiguration() {
        return SSRApplication.getConfigurationRepo().getRecorderConfiguration();
    }

}
