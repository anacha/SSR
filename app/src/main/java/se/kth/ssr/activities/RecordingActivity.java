package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import se.kth.ssr.R;
import se.kth.ssr.utils.DataRepository;

/**
 * Created by argychatzi on 4/6/14.
 */
public class RecordingActivity extends Activity {

    public static final String DIRECTORY_OF_RECORDINGS_KEY = "DIRECTORY_OF_RECORDINGS_KEY";
    private static final String TAG = "RecordingActivity";
    private MediaRecorder mRecorder = null;
    private boolean mIsRecording = false;
    private String mDirectoryOfRecordings;

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
                    startRecording(mDirectoryOfRecordings);
                } else {
                    stopRecording();
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


    private void startRecording(String recordDirName) {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

        mRecorder.setOutputFile(recordDirName + "/recording.3gp");
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(TAG, "prepare() failed");
        }

        mRecorder.start();
    }


    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }
}
