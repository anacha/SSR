package se.kth.ssr.operations.defaults;

import se.kth.ssr.models.Recording;
import se.kth.ssr.operations.RecordingCreator;
import se.kth.ssr.operations.AbstractRecordingOperator;

/**
 * Created by argychatzi on 3/29/14.
 */
public class DefaultRecordingCreator extends AbstractRecordingOperator implements RecordingCreator {

    public DefaultRecordingCreator(String pathOfOperations) {
        super(pathOfOperations);
    }

    @Override
    public Recording copyRecordingToDirectory(Recording recording, String dir) {
        Recording result = null;
        //TODO not yet implemented

        return result;
    }
}
