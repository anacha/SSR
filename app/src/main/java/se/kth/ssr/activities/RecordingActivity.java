package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import se.kth.ssr.R;
import se.kth.ssr.base.BaseActivity;
import se.kth.ssr.models.Recording;
import se.kth.ssr.operators.RecordingRecorder;
import se.kth.ssr.util.operations.RecorderConf;

/**
 * Created by argychatzi on 4/6/14.
 */
public class RecordingActivity extends BaseActivity {

    private static final String TAG = "RecordingActivity";
    private static final String PATH_BUNDLE_KEY = "PATH_BUNDLE_KEY";
    private RecordingRecorder mRecorder;

    private boolean mIsRecording = false;
    private String mPathToRecording;
    private Recording mRecordingResult;

    public static Intent getLaunchIntent(Activity activity, String pathToRecording) {
        Intent intent = new Intent(activity, RecordingActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(PATH_BUNDLE_KEY, pathToRecording);
        intent.putExtras(bundle);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        mPathToRecording = getIntent().getExtras().getString(PATH_BUNDLE_KEY);

        Button recordButton = (Button) findViewById(R.id.record_btn);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsRecording) {
                    if (mRecorder == null) {
                        RecorderConf configuration = getRecorderConfiguration();
                        mRecorder = new RecordingRecorder(configuration, mPathToRecording);
                    }
                    mRecorder.start();
                } else {
                    mRecordingResult = mRecorder.stopRecording();
                    launchBreakRecordingToPiecesActivity(RecordingActivity.this, mRecordingResult);
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
        }
    }

    private void launchBreakRecordingToPiecesActivity(Context context, Recording recording) {
        Intent intent = DivideRecordingsActivity.getLaunchIntent(context, recording);
        startActivity(intent);
    }
}
