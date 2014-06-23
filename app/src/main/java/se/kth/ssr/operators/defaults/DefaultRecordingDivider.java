package se.kth.ssr.operators.defaults;

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
import se.kth.ssr.operators.AbstractRecordingOperator;
import se.kth.ssr.operators.RecordingDivider;
import se.kth.ssr.utils.Configuration;

/**
 * Created by argychatzi on 3/29/14.
 */
public class DefaultRecordingDivider extends AbstractRecordingOperator implements RecordingDivider {

    private static final String TAG = "DefaultRecordingDivider";

    public DefaultRecordingDivider(String pathOfOperations) {
        super(pathOfOperations);
    }

    public List<Recording> breakRecordingToPieces(Configuration configuration, Recording originalRecording) {

        int fragmentSize = configuration.getFragmentSizeInBytes();
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

                String fragmentName = originalRecording.getRecordingPath().replace(".3gp", "pt" + i + ".3gp");

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

    private Recording createRecordingFromBytes(String recordingName, byte[] buffer) throws IOException {
        Recording result = null;

        OutputStream outputStream = new FileOutputStream(recordingName);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.write(buffer, 0, buffer.length);

        result = new Recording(recordingName);
        return result;
    }

    private byte[] copyBytesFromRecording(Recording recording, int offset, int numberOfBytesToCopy) throws IOException {


        Log.d(TAG, "recording.getSizeInBytes()" + recording.getSizeInBytes());

        if (numberOfBytesToCopy < 0) {
            throw new IOException("numberOfBytesToCopy must be > 0");
        } else if (offset < 0) {
            throw new IOException("offset must be > 0");
        } else if (recording == null) {
            throw new IOException("recording can't be null!");
        } else {
            byte[] result = new byte[numberOfBytesToCopy];

            InputStream inputStream = new FileInputStream(recording.getRecordingPath());
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            dataInputStream.read(result, offset, numberOfBytesToCopy);
            return result;
        }
    }

    private int calculateNumberOfFragments(Recording originalRecording, int fragmentSize) {
        return (int) Math.ceil(originalRecording.getSizeInBytes() / fragmentSize);
    }
}
