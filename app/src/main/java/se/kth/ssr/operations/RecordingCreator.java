package se.kth.ssr.operations;

import java.io.File;

import se.kth.ssr.models.Recording;

/**
 * Created by argychatzi on 6/21/14.
 */
public interface RecordingCreator {
    public Recording copyRecordingToDirectory(Recording recording, String dir);
}
