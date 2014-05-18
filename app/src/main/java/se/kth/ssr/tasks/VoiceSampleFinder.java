package se.kth.ssr.tasks;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import se.kth.ssr.models.VoiceSample;

/**
 * Created by argychatzi on 3/23/14.
 */
public class VoiceSampleFinder extends VoiceSampleOperator {

    private static final String TAG = VoiceSampleFinder.class.getCanonicalName() ;

    public VoiceSampleFinder(String pathToLookForSamples) {
        super(pathToLookForSamples);
    }

    public List<VoiceSample> getSamples() {
        ArrayList<VoiceSample> result = new ArrayList<VoiceSample>();

        File file = new File (mPath);

        File[] list = file.listFiles();

        for(File f: list){
            result.add(new VoiceSample(f));
        }

        return result;
    }
}
