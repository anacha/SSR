package se.kth.ssr.utils;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaRecorder;

/**
 * Created by argychatzi on 5/17/14.
 */
public final class DefaultConfiguration implements Configuration{

    private static final int SAMPLE_RATE = 16000;
    private static final int FRAGMENT_DURATION_IN_BYTES = 1000;
    private static final int AUDIO_TRACK_BUFFER_SIZE = 100000;

    /*Player properties*/
    private static final int STREAM_TYPE = AudioManager.STREAM_MUSIC;
    private static final int CHANNEL_CONFIG = AudioFormat.CHANNEL_OUT_STEREO;
    private static final int AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT;
    private static final int AUDIO_TRACK_MODE = AudioTrack.MODE_STREAM;

    /*Recorder properties*/
    private static final int AUDIO_ENCODER = MediaRecorder.AudioEncoder.AMR_WB;
    private static final int AUDIO_SOURCE = MediaRecorder.AudioSource.MIC;
    private static final int OUTPUT_FORMAT = MediaRecorder.OutputFormat.THREE_GPP;

    private static final String TAG = "DefaultConfiguration";
    private static DefaultConfiguration sDefaultConfiguration;

    private String mBaseDirectory;

    private DefaultConfiguration(Context context) {
        mBaseDirectory = context.getExternalFilesDir(null).getAbsolutePath();
    }

    public static DefaultConfiguration getInstance(Context context) {
        if (sDefaultConfiguration == null) {
            sDefaultConfiguration = new DefaultConfiguration(context);
        }
        return sDefaultConfiguration;
    }

    public String getBaseHomeDirectory() {
        return mBaseDirectory;
    }

    @Override
    public int getFragmentSizeInBytes() {
        return FRAGMENT_DURATION_IN_BYTES;
    }

    @Override
    public int getSamplingRateInHz() {
        return SAMPLE_RATE;
    }

    @Override
    public int getStreamType() {
        return STREAM_TYPE;
    }

    @Override
    public int getChannelConfig() {
        return CHANNEL_CONFIG;
    }

    @Override
    public int getAudioFormat() {
        return AUDIO_FORMAT;
    }

    @Override
    public int getAudioTrackMode() {
        return AUDIO_TRACK_MODE;
    }

    @Override
    public int getAudioTrackBufferSizeInBytes() {
        return AUDIO_TRACK_BUFFER_SIZE;
    }

    @Override
    public int getAudioSource() {
        return AUDIO_SOURCE;
    }

    @Override
    public int getAudioEncoder() {
        return AUDIO_ENCODER;
    }

    @Override
    public int getOutputFormat() {
        return OUTPUT_FORMAT;
    }
}
