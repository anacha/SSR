package se.kth.ssr.operators;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import se.kth.ssr.models.Recording;
import se.kth.ssr.util.operations.generic.OperatorConfiguration;

/**
 * Created by argychatzi on 3/23/14.
 */
public class RecordingFinder extends AbstractRecordingOperator {

    private static final String TAG = RecordingFinder.class.getCanonicalName();

    public RecordingFinder(OperatorConfiguration configuration) {
        super(configuration.getBasePath());
    }

    public List<Recording> find() {
        ArrayList<Recording> result = new ArrayList<Recording>();

        File file = new File(mPath);

        File[] list = file.listFiles();

        if (list != null) {
            for (File f : list) {
                result.add(new Recording(f.getAbsolutePath()));
            }
        }
        return result;
    }
}
