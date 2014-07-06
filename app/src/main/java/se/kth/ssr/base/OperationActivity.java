package se.kth.ssr.base;

import android.app.Activity;

import se.kth.ssr.util.operations.CreatorConfiguration;
import se.kth.ssr.util.operations.DividerConfiguration;
import se.kth.ssr.util.operations.RecorderConfiguration;

/**
 * Created by argychatzi on 7/6/14.
 */
public class OperationActivity extends Activity {

    public DividerConfiguration getDividerConfiguration() {
        return SSRApplication.getConfiguration().getDividerConfiguration();
    }

    public CreatorConfiguration getCreatorConfiguration() {
        return SSRApplication.getConfiguration().getCreatorConfiguration();
    }

    public RecorderConfiguration getRecordingConfiguration() {
        return SSRApplication.getConfiguration().getRecorderConfiguration();
    }

}
