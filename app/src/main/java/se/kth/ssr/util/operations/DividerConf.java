package se.kth.ssr.util.operations;

/**
 * Class contains all information around the operation of Dividing a recording
 * to pieces
 * <p/>
 * Created by argychatzi on 6/24/14.
 */
public class DividerConf extends PlayerConf {
    private static final int FRAGMENT_SIZE_IN_BYTES = 4*1024;

    public int getFragmentSizeInBytes() {
        return FRAGMENT_SIZE_IN_BYTES;
    }
}
