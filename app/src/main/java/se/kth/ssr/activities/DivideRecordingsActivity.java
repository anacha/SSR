package se.kth.ssr.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import java.util.List;

import se.kth.ssr.base.OperationActivity;
import se.kth.ssr.models.Recording;
import se.kth.ssr.operators.RecordingDivider;
import se.kth.ssr.util.operations.DividerConf;

/**
 * Created by argychatzi on 5/18/14.
 */
public class DivideRecordingsActivity extends OperationActivity {

    private static final String RECORDING_PATH_BUNDLE_KEY = "RECORDING_PATH_BUNDLE_KEY";

    AsyncTask<Recording, Void, List<Recording>> mTask = null;

    public static Intent getLaunchIntent(Context context, Recording recording) {
        Intent intent = new Intent(context, DivideRecordingsActivity.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable(RECORDING_PATH_BUNDLE_KEY, recording);
        intent.putExtras(bundle);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Recording recording = (Recording) getIntent().getExtras().get(RECORDING_PATH_BUNDLE_KEY);

        if(mTask == null){
            mTask = new AsyncTask<Recording, Void, List<Recording>>() {
                @Override
                protected List<Recording> doInBackground(Recording[] params) {
                    Recording recording = params[0];

                    DividerConf dividerConf = getDividerConfiguration();
                    RecordingDivider divider = new RecordingDivider(dividerConf, recording.getRecordingPath());

                    return divider.divide(recording);
                }
            };
            mTask.execute(recording);
        }
    }
}
