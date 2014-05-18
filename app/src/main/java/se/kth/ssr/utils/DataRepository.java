package se.kth.ssr.utils;

import android.content.Context;

/**
 * Created by argychatzi on 5/17/14.
 */
public final class DataRepository {

    private static DataRepository sDataRepository;

    private String mBaseHomeDirectory;

    private DataRepository(Context context) {
        mBaseHomeDirectory = context.getExternalFilesDir(null).toString();

    }

    public static DataRepository getInstance(Context context) {
        if (sDataRepository == null) {
            sDataRepository = new DataRepository(context);
        }
        return sDataRepository;
    }

    public String getBaseHomeDirectory() {
        return mBaseHomeDirectory;
    }
}
