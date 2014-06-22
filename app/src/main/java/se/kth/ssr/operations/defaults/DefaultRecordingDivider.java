package se.kth.ssr.operations.defaults;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import se.kth.ssr.models.Recording;
import se.kth.ssr.operations.AbstractRecordingOperator;
import se.kth.ssr.operations.RecordingDivider;

/**
 * Created by argychatzi on 3/29/14.
 */
public class DefaultRecordingDivider extends AbstractRecordingOperator implements RecordingDivider {

    public DefaultRecordingDivider(String pathOfOperations) {
        super(pathOfOperations);
    }

    public Recording createRecordingFromBytes(String recordingName, byte[] buffer) throws IOException {
        Recording result = null;

        OutputStream outputStream = new FileOutputStream(recordingName);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.write(buffer, 0, buffer.length);

        result = new Recording(recordingName);
        return result;
    }


    public byte[] copyBytesFromRecording(Recording recording, int numberOfBytesToCopy, int offset) throws IOException {

        if (numberOfBytesToCopy < 0) {
            throw new IOException("numberOfBytesToCopy must be > 0");
        } else if (offset < 0) {
            throw new IOException("offset must be > 0");
        } else if (recording == null) {
            throw new IOException("recording can't be null!");
        } else {
            byte[] result = new byte[numberOfBytesToCopy];

            InputStream inputStream = new FileInputStream(recording.getRecordingName());
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            dataInputStream.read(result, offset, numberOfBytesToCopy);
            return result;
        }
    }

    public int calculateNumberOfFragments(Recording originalRecording, int fragmentSize) {
        return (int) Math.ceil(originalRecording.getSizeInBytes() / fragmentSize);
    }
}
