package se.kth.ssr.operators.defaults;

import se.kth.ssr.models.Recording;
import se.kth.ssr.operators.RecordingCreator;

/**
 * Created by argychatzi on 6/23/14.
 */
public class DefaultRecordingCreator implements RecordingCreator {
    @Override
    public Recording createRecordingFromByteArray(byte[] bytes) {
        Recording result = new Recording("");
        //TODO implement correctly a class that creates a recording (with respect to the encoding, etc)
        //hint: use the AudioTrack class and the Configuration file.
        return result;
    }
}
