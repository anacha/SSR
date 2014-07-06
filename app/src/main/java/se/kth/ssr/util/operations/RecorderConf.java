package se.kth.ssr.util.operations;

import android.media.MediaRecorder;

/**
 * Created by argychatzi on 6/24/14.
 */
public final class RecorderConf extends PlayerConf {

    private static final int AUDIO_ENCODER = MediaRecorder.AudioEncoder.AMR_WB;
    private static final int AUDIO_SOURCE = MediaRecorder.AudioSource.MIC;
    private static final int OUTPUT_FORMAT = MediaRecorder.OutputFormat.THREE_GPP;

    public static int getAudioSource() {
        return AUDIO_SOURCE;
    }

    public static int getAudioEncoder() {
        return AUDIO_ENCODER;
    }

    public static int getOutputFormat() {
        return OUTPUT_FORMAT;
    }

}
