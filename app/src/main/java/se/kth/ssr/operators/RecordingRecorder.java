package se.kth.ssr.operators;

import android.media.MediaRecorder;
import android.util.Log;

import java.io.IOException;

import se.kth.ssr.models.Recording;
import se.kth.ssr.util.operations.RecorderConf;

/**
 * Created by argychatzi on 7/6/14.
 */
public class RecordingRecorder extends RecordingCreator {

    private static final String TAG = "RecordingRecorder";

    private MediaRecorder mRecorder;
    private RecorderConf mRecordingConfiguration;

    public RecordingRecorder(RecorderConf configuration, String path) {
        super(configuration, path);
        mRecordingConfiguration = configuration;
        mRecorder = initRecorder(mRecording.getRecordingPath());
    }

    private MediaRecorder initRecorder(String outputFile) {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(mRecordingConfiguration.getAudioSource());
        mRecorder.setOutputFormat(mRecordingConfiguration.getOutputFormat());
        mRecorder.setAudioSamplingRate(mRecordingConfiguration.getSamplingRateInHz());
        mRecorder.setOutputFile(outputFile);
        mRecorder.setAudioEncoder(mRecordingConfiguration.getAudioEncoder());

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(TAG, "prepare() failed");
        }
        return mRecorder;
    }

    public Recording stopRecording() {
        if(mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
        Log.d(TAG, "stop recording");
        return mRecording = new Recording(mRecording.getRecordingPath());
    }

    public void release(){
        if(mRecorder!= null){
            mRecorder.release();
            mRecorder = null;
        }
    }

    public void start(){
        if(mRecorder != null){
            mRecorder.start();
        }
        Log.d(TAG, "start recording");
    }
}
