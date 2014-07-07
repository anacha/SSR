package se.kth.ssr.operators.player;

import android.media.AudioTrack;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import se.kth.ssr.operators.AbstractRecordingOperator;
import se.kth.ssr.util.operations.player.ATPlayerConf;

/**
 * Created by argychatzi on 7/6/14.
 */
public class ATRecordingPlayer extends AbstractRecordingOperator {

    private static final String TAG = "RecordingPlayer";
    private final ATPlayerConf mConfiguration;
    private AudioTrack mAudioTrack;

    public ATRecordingPlayer(ATPlayerConf configuration, String path) {
        super(path);
        mConfiguration = configuration;
        File f = new File(path);
        mAudioTrack = convertFileToAudioTrack(f);
    }

    private AudioTrack convertFileToAudioTrack(File file) {
        AudioTrack resultTrack = initAudioTrack(mConfiguration);

        try {
            InputStream is = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(is);

            int bytesReadInThisRound = 0;
            int bytesReadSoFar = 0;

            int temporaryBufferSize = mConfiguration.getMaxAudioTrackBufferSizeInBytes();
            int bytesToBeRead = (int) file.length() + 1;

            if (bytesToBeRead < temporaryBufferSize) {
                temporaryBufferSize = bytesToBeRead;
            }

            byte[] temporaryBuffer = new byte[temporaryBufferSize];

            while (hasNotReachedEndOfStream(bytesReadInThisRound) && hasNotReadAllContent(temporaryBufferSize, bytesReadSoFar, bytesToBeRead)) {
                bytesReadInThisRound = dataInputStream.read(temporaryBuffer, bytesReadSoFar, temporaryBufferSize);
                resultTrack.write(temporaryBuffer, bytesReadSoFar, bytesReadInThisRound);
                bytesReadSoFar = bytesReadSoFar + bytesReadInThisRound;
            }
            dataInputStream.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultTrack;
    }

    private boolean hasNotReadAllContent(int temporaryBufferSize, int bytesReadSoFar, int bytesToBeRead) {
        return temporaryBufferSize + bytesReadSoFar <= bytesToBeRead;
    }

    private boolean hasNotReachedEndOfStream(int bytesRead) {
        return bytesRead > -1;
    }

    private AudioTrack initAudioTrack(ATPlayerConf configuration) {
        int streamType = configuration.getStreamType();
        int sampleRateInHz = configuration.getSamplingRateInHz();
        int channelConfig = configuration.getChannelConfig();
        int audioFormat = configuration.getAudioFormat();
        int minBufferSize = configuration.getMaxAudioTrackBufferSizeInBytes();
        int mode = configuration.getAudioTrackMode();

        return new AudioTrack(streamType, sampleRateInHz, channelConfig, audioFormat, minBufferSize, mode);
    }


    public void play() {
        if(mAudioTrack != null) {
            mAudioTrack.play();
        }
    }

    public void stop() {
        if(mAudioTrack != null){
            mAudioTrack.stop();
        }
    }

    public void release() {
        if(mAudioTrack != null){
            mAudioTrack.release();
            mAudioTrack = null;
        }
    }
}
