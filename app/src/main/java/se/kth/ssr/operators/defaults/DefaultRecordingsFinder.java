package se.kth.ssr.operators.defaults;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import se.kth.ssr.models.Recording;
import se.kth.ssr.operators.AbstractRecordingOperator;
import se.kth.ssr.utils.DefaultConfiguration;

/**
 * Created by argychatzi on 3/23/14.
 */
public class DefaultRecordingsFinder extends AbstractRecordingOperator {

    private static final String TAG = DefaultRecordingsFinder.class.getCanonicalName();

    public DefaultRecordingsFinder(Context context) {
        super(DefaultConfiguration.getInstance(context).getBaseHomeDirectory());
    }

    public List<Recording> getRecordings() {
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
