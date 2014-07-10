package se.kth.ssr.operators;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import se.kth.ssr.dataprovider.models.Recording;


/**
 * Created by argychatzi on 3/23/14.
 */
public class RecordingFinder extends AbstractRecordingOperator {

    private static final String TAG = RecordingFinder.class.getCanonicalName();

    public RecordingFinder(String path) {
        super(path);
    }

    public List<Recording> find() {
        ArrayList<Recording> result = new ArrayList<Recording>();

        File file = new File(getPathOfOperations());

        File[] list = file.listFiles();

        if (list != null) {
            for (File f : list) {
                result.add(new Recording(f.getAbsolutePath()));
            }
        }
        return result;
    }
}
