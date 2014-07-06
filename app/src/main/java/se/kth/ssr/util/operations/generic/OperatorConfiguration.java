package se.kth.ssr.util.operations.generic;

import android.content.Context;

/**
 * Created by argychatzi on 5/17/14.
 */
public class OperatorConfiguration extends SamplingConfiguration {

    private static final String TAG = "DefaultConfiguration";

    protected String mBasePath;

    public OperatorConfiguration(Context context) {
        mBasePath = context.getExternalFilesDir(null).getAbsolutePath();
    }

    public String getBasePath() {
        return mBasePath;
    }

}
