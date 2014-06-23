package se.kth.ssr.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import java.util.List;

import se.kth.ssr.models.Recording;
import se.kth.ssr.operators.RecordingDivider;
import se.kth.ssr.operators.defaults.DefaultRecordingDivider;
import se.kth.ssr.utils.Configuration;

/**
 * Created by argychatzi on 5/18/14.
 */
public class BreakRecordingToPiecesActivity extends DefaultConfigurationActivity {

    private static final String RECORDING_BUNDLE_KEY = "RECORDING_BUNDLE_KEY";

    AsyncTask<Recording, Void, List<Recording>> mTask = null;

    public static Intent getLaunchIntent(Context context, Recording recording) {
        Intent intent = new Intent(context, BreakRecordingToPiecesActivity.class);
        Bundle bundle = new Bundle();

        bundle.putParcelable(RECORDING_BUNDLE_KEY, recording);

        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Recording recording = (Recording) getIntent().getExtras().get(RECORDING_BUNDLE_KEY);

        if(mTask == null){
            mTask = new AsyncTask<Recording, Void, List<Recording>>() {
                @Override
                protected List<Recording> doInBackground(Recording[] params) {
                    Recording recording = params[0];
                    RecordingDivider divider = new DefaultRecordingDivider(recording.getRecordingPath());
                    Configuration configuration = getConfiguration();
                    divider.breakRecordingToPieces(configuration, recording);
                    return divider.breakRecordingToPieces(configuration, recording);
                }
            };

            mTask.execute(recording);
        }
    }
}
