package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Date;

import se.kth.ssr.R;
import se.kth.ssr.models.Recording;
import se.kth.ssr.utils.DefaultConfiguration;

/**
 * Created by argychatzi on 4/6/14.
 */
public class RecordingActivity extends Activity {

    public static final String DIRECTORY_OF_RECORDINGS_KEY = "DIRECTORY_OF_RECORDINGS_KEY";

    private static final String TAG = "RecordingActivity";
    private static final String FILE_NAME = "/recording";
    private static final String FILE_POST_FIX = "";

    private String mRecordingName = FILE_NAME + String.valueOf(new Date().getTime()) + FILE_POST_FIX;
    private MediaRecorder mRecorder = null;
    private boolean mIsRecording = false;
    private String mDirectoryOfRecordings;
    private Recording mRecordingResult;

    public static Intent getLaunchIntent(Activity activity, String directoryOfRecordings) {
        Intent intent = new Intent(activity, RecordingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(DIRECTORY_OF_RECORDINGS_KEY, directoryOfRecordings);
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        Bundle extras = getIntent().getExtras();
        mDirectoryOfRecordings = extras.getString(DIRECTORY_OF_RECORDINGS_KEY);

        Button recordButton = (Button) findViewById(R.id.record_btn);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsRecording) {
                    if(mRecorder == null){
                        mRecorder = initRecorder(mDirectoryOfRecordings);
                    }
                    mRecorder.start();
                } else {
                    mRecordingResult = stopRecording();
                    breakRecordingToFragments(RecordingActivity.this, mRecordingResult);
                }
                mIsRecording = !mIsRecording;
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }
    }

    private MediaRecorder initRecorder(String recordDirName){
        MediaRecorder recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioSamplingRate(DefaultConfiguration.getInstance(this).getSamplingRate());

        String recordingAbsolutePath = recordDirName + mRecordingName;
        Log.d(TAG, "recordingAbsolutePath " +  recordingAbsolutePath);
        recorder.setOutputFile(recordingAbsolutePath);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);

        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e(TAG, "prepare() failed");
        }
        return recorder;
    }

    private Recording stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
        return new Recording(mRecordingName);
    }

    private void breakRecordingToFragments(Context context, Recording recording) {
        Intent intent = BreakRecordingToPiecesActivity.getLaunchIntent(context, recording);
        startActivity(intent);
    }
}
