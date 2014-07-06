package se.kth.ssr.operators;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import se.kth.ssr.models.Recording;
import se.kth.ssr.util.operations.DividerConf;

/**
 * Created by argychatzi on 3/29/14.
 */
public class RecordingDivider extends RecordingCreator {

    private static final String TAG = "DefaultRecordingDivider";
    private final DividerConf mDividerConf;

    public RecordingDivider(DividerConf configuration, String path) {
        super(configuration, path);
        mDividerConf = configuration;
    }

    public List<Recording> divide(Recording originalRecording) {

        int fragmentSize = mDividerConf.getFragmentSizeInBytes();
        int numberOfFragments = calculateNumberOfFragments(originalRecording, fragmentSize);
        int offset = 0;

        ArrayList<Recording> pieces = new ArrayList<Recording>();
        try {

            InputStream inputStream = new FileInputStream(originalRecording.getRecordingPath());
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            for (int i = 0; i < numberOfFragments; i++) {

                offset = offset + i * fragmentSize;
                byte[] bytes = new byte[fragmentSize];
                dataInputStream.read(bytes, 0, fragmentSize);

                String fragmentName = originalRecording.getRecordingPath().replace(".3gp", "_pt" + i + ".3gp");

                OutputStream outputStream = new FileOutputStream(fragmentName);
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.write(bytes, 0, bytes.length);

                pieces.add(new Recording(fragmentName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pieces;
    }

    private int calculateNumberOfFragments(Recording originalRecording, int fragmentSize) {
        return (int) Math.ceil(originalRecording.getSizeInBytes() / fragmentSize);
    }
}
