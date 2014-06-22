package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import se.kth.ssr.models.Recording;

/**
 * Created by argychatzi on 5/18/14.
 */
public class BreakRecordingToPiecesActivity extends Activity{

    private static final String RECORDING_BUNDLE_KEY = "RECORDING_BUNDLE_KEY";

    private Recording mRecording;


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

        mRecording = (Recording) getIntent().getExtras().get(RECORDING_BUNDLE_KEY);

//        createNewDirectory(path);
//        copyFileToPath(fileName);
    }

    private void breakRecordingToPieces(Recording recording, int numberOfPieces) {

    }

    private void createNewDirectory(String path, String name){

    }

    private void copyFileToPath(String file){

    }

}
