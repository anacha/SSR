package se.kth.ssr.operators;

import se.kth.ssr.models.Recording;

/**
 * Created by argychatzi on 6/23/14.
 */
public interface RecordingCreator {
    public Recording createRecordingFromByteArray(byte[] bytes);
}
