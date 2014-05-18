package se.kth.ssr.utils;

import android.content.Context;

import se.kth.ssr.R;

/**
 * Created by argychatzi on 5/17/14.
 */
public final class Configuration {

    private static Configuration sConfiguration;

    private String mBaseDirectory;

    private Configuration(Context context) {
        mBaseDirectory = context.getExternalFilesDir(null).toString() + context.getResources().getString(R.string.default_path);

    }

    public static Configuration getInstance(Context context) {
        if (sConfiguration == null) {
            sConfiguration = new Configuration(context);
        }
        return sConfiguration;
    }

    public String getBaseHomeDirectory() {
        return mBaseDirectory;
    }
}
