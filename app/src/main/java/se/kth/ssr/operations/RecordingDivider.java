package se.kth.ssr.operations;

import java.io.File;
import java.io.IOException;

import se.kth.ssr.models.Recording;

/**
 * Created by argychatzi on 6/21/14.
 */
public interface RecordingDivider {
    public byte[] copyBytesFromRecording(Recording recording, int numberOfBytesToCopy, int offset) throws IOException;
    public Recording createRecordingFromBytes(String recordingName, byte[] buffer) throws IOException;
}
