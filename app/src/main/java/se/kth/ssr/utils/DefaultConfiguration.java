package se.kth.ssr.utils;

import android.content.Context;
import android.util.Log;

/**
 * Created by argychatzi on 5/17/14.
 */
public final class DefaultConfiguration implements Configuration{

    private static final int SAMPLE_RATE = 16000;
    private static final String SSR_PATH_POST_FIX = "";
    private static final int DURATION_IN_MILIS = 5000;
    private static final String TAG = "DefaultConfiguration";

    private static DefaultConfiguration sDefaultConfiguration;

    private String mBaseDirectory;

    private DefaultConfiguration(Context context) {
        mBaseDirectory = context.getExternalFilesDir(null).getAbsolutePath().toString() + SSR_PATH_POST_FIX;
        Log.d(TAG, "DefaultConfiguration with basedDir =" + mBaseDirectory);
    }

    public static DefaultConfiguration getInstance(Context context) {
        if (sDefaultConfiguration == null) {
            sDefaultConfiguration = new DefaultConfiguration(context);
        }
        return sDefaultConfiguration;
    }

    public String getBaseHomeDirectory() {
        return mBaseDirectory;
    }

    @Override
    public int getFragmentSizeInBytes() {
        return DURATION_IN_MILIS;
    }

    @Override
    public int getSamplingRate() {
        return SAMPLE_RATE;
    }
}
