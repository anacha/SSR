package se.kth.ssr.util.operations;

import android.content.Context;
import android.media.MediaRecorder;

import se.kth.ssr.util.operations.generic.OperatorConfiguration;

/**
 * Created by argychatzi on 6/24/14.
 */
public final class RecorderConfiguration extends OperatorConfiguration {

    private static final int AUDIO_ENCODER = MediaRecorder.AudioEncoder.AMR_WB;
    private static final int AUDIO_SOURCE = MediaRecorder.AudioSource.MIC;
    private static final int OUTPUT_FORMAT = MediaRecorder.OutputFormat.THREE_GPP;
    private static final int SAMPLE_RATE = 16000;

    public RecorderConfiguration(Context context) {
        super(context);
    }

    public static int getAudioSource() {
        return AUDIO_SOURCE;
    }

    public static int getAudioEncoder() {
        return AUDIO_ENCODER;
    }

    public static int getOutputFormat() {
        return OUTPUT_FORMAT;
    }

    public int getSamplingRateInHz() {
        return SAMPLE_RATE;
    }

}
