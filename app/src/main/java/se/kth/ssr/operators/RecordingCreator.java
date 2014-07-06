package se.kth.ssr.operators;

import android.media.AudioTrack;
import android.util.Log;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import se.kth.ssr.models.Recording;
import se.kth.ssr.util.operations.CreatorConfiguration;

/**
 * Created by argychatzi on 6/23/14.
 */
public class RecordingCreator extends AbstractRecordingOperator {

    private static final String TAG = "RecordingCreator";

    private CreatorConfiguration mConfiguration;

    public RecordingCreator(CreatorConfiguration configuration) {
        super(configuration.getBasePath());
        mConfiguration = configuration;
    }

    public Recording createFromByteArray(byte[] bytes) throws IOException {

        AudioTrack audioTrack;
        File file = new File(mPath);
        if (file.canRead()) {
            audioTrack = createAudioTrackInFile(file);
        } else {
            audioTrack = null;
        }

        return new Recording(mPath);
    }

    private AudioTrack createAudioTrackInFile(File file) throws IOException {

        AudioTrack audioTrack = prepareAudioTrack(mConfiguration);

        InputStream is = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(is);

        int bytesRead = 0;
        int readerBufferSize = mConfiguration.getAudioTrackBufferSizeInBytes();
        int finalReaderBufferSize = (int) file.length();

        byte[] buffer = new byte[readerBufferSize + 1];

        int offset = 0;
        while (bytesRead > -1 && readerBufferSize + offset < finalReaderBufferSize) {
            bytesRead = dataInputStream.read(buffer, offset, readerBufferSize);
            audioTrack.write(buffer, offset, bytesRead);
            offset = offset + bytesRead;
            Log.d(TAG, "read " + bytesRead + " bytes");
        }
        dataInputStream.close();
        is.close();
        Log.d(TAG, "read " + finalReaderBufferSize + " bytes");

        return audioTrack;
    }

    private AudioTrack prepareAudioTrack(CreatorConfiguration configuration) {
        int streamType = configuration.getStreamType();
        int sampleRateInHz = configuration.getSamplingRateInHz();
        int channelConfig = configuration.getChannelConfig();
        int audioFormat = configuration.getAudioFormat();
        int minBufferSize = configuration.getAudioTrackBufferSizeInBytes();
        int mode = configuration.getAudioTrackMode();
        return new AudioTrack(streamType, sampleRateInHz, channelConfig, minBufferSize, audioFormat, mode);
    }
}
