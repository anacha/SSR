package se.kth.ssr.operators;

import java.io.File;

import se.kth.ssr.models.Recording;
import se.kth.ssr.util.operations.PlayerConf;

/**
 * Created by argychatzi on 6/23/14.
 */
public class RecordingCreator extends AbstractRecordingOperator {

    private static final String TAG = "RecordingCreator";

    private PlayerConf mConfiguration;
    protected Recording mRecording;

    public RecordingCreator(PlayerConf configuration, String recordingPath) {
        super(recordingPath);
        mConfiguration = configuration;
        mRecording = new Recording(recordingPath);
    }


//    public Recording createFromByteArray(byte[] bytes) throws IOException {
//
//        AudioTrack audioTrack;
//        File file = new File(mPath);
//        if (file.canRead()) {
//            audioTrack = createAudioTrackInFile(file);
//        } else {
//            audioTrack = null;
//        }
//
//        return new Recording(mPath);
//    }
//    private AudioTrack createAudioTrackInFile(File file) throws IOException {
//
//        AudioTrack audioTrack = createEmptyAudioTrack(mConfiguration);
//
//        InputStream is = new FileInputStream(file);
//        DataInputStream dataInputStream = new DataInputStream(is);
//
//        int bytesRead = 0;
//        int readerBufferSize = mConfiguration.getMaxAudioTrackBufferSizeInBytes();
//        int finalReaderBufferSize = (int) file.length();
//
//        byte[] buffer = new byte[readerBufferSize + 1];
//
//        int offset = 0;
//        while (bytesRead > -1 && readerBufferSize + offset < finalReaderBufferSize) {
//            bytesRead = dataInputStream.read(buffer, offset, readerBufferSize);
//            audioTrack.write(buffer, offset, bytesRead);
//            offset = offset + bytesRead;
//            Log.d(TAG, "read " + bytesRead + " bytes");
//        }
//        dataInputStream.close();
//        is.close();
//        Log.d(TAG, "read " + finalReaderBufferSize + " bytes");
//
//        return audioTrack;
//    }

}
