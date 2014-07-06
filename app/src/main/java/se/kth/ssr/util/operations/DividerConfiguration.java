package se.kth.ssr.util.operations;

import android.content.Context;

/**
 * Class contains all information around the operation of Dividing a recording
 * to pieces
 *
 * Created by argychatzi on 6/24/14.
 */
public class DividerConfiguration extends CreatorConfiguration {
    private static final int FRAGMENT_SIZE_IN_BYTES = 1024;

    public DividerConfiguration(Context context) {
        super(context);
    }

    public int getFragmentSizeInBytes() {
        return FRAGMENT_SIZE_IN_BYTES;
    }
}
