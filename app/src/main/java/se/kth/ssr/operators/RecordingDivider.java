package se.kth.ssr.operators;

import java.util.List;

import se.kth.ssr.models.Recording;
import se.kth.ssr.utils.Configuration;

/**
 * Created by argychatzi on 6/21/14.
 */
public interface RecordingDivider {
    public List<Recording> breakRecordingToPieces(Configuration configuration, Recording originalRecording);
}
