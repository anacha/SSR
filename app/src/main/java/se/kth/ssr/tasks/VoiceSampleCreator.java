package se.kth.ssr.tasks;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import se.kth.ssr.models.VoiceSample;

/**
 * Created by argychatzi on 3/29/14.
 */
public class VoiceSampleCreator extends VoiceSampleOperator {

    public VoiceSampleCreator(String pathToLookForSamples) {
        super(pathToLookForSamples);
    }

    public VoiceSample createVoiceSample(File f, byte b) {
        VoiceSample result = null;

        try {
            if (f.canWrite()) {
                OutputStream outStream = new FileOutputStream(f);
                DataOutputStream dOutStream = new DataOutputStream(outStream);
                dOutStream.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}
