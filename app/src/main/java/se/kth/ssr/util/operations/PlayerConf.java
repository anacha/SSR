package se.kth.ssr.util.operations;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

import se.kth.ssr.util.operations.generic.SamplingConf;

/**
 * Class contains all the settings around the creating of a recording
 * Created by argychatzi on 6/24/14.
 */
public class PlayerConf extends SamplingConf {

    private static final int STREAM_TYPE = AudioManager.STREAM_MUSIC;
    private static final int CHANNEL_CONFIG = AudioFormat.CHANNEL_OUT_STEREO;
    private static final int AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT;
    private static final int AUDIO_TRACK_MODE = AudioTrack.MODE_STREAM;
    private static final int AUDIO_TRACK_BUFFER_SIZE = 100000;

    public static int getStreamType() {
        return STREAM_TYPE;
    }

    public static int getChannelConfig() {
        return CHANNEL_CONFIG;
    }

    public static int getAudioFormat() {
        return AUDIO_FORMAT;
    }

    public static int getAudioTrackMode() {
        return AUDIO_TRACK_MODE;
    }

    public static int getMaxAudioTrackBufferSizeInBytes() {
        return AUDIO_TRACK_BUFFER_SIZE;
    }
}
