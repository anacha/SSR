package se.kth.ssr.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import se.kth.ssr.models.Recording;
import se.kth.ssr.operations.defaults.DefaultRecordingDivider;
import se.kth.ssr.utils.Configuration;

/**
 * Created by argychatzi on 5/18/14.
 */
public class BreakRecordingToPiecesActivityDefault extends DefaultConfigurationActivity {

    private static final String RECORDING_BUNDLE_KEY = "RECORDING_BUNDLE_KEY";

    public static Intent getLaunchIntent(Context context, Recording recording) {
        Intent intent = new Intent(context, BreakRecordingToPiecesActivityDefault.class);
        Bundle bundle = new Bundle();

        bundle.putParcelable(RECORDING_BUNDLE_KEY, recording);

        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Recording recording = (Recording) getIntent().getExtras().get(RECORDING_BUNDLE_KEY);
        Configuration configuration = getConfiguration();

        breakRecordingToPieces(configuration, recording);
    }

    private List<Recording> breakRecordingToPieces(Configuration configuration, Recording originalRecording) {

        DefaultRecordingDivider recordingDivider = new DefaultRecordingDivider(configuration.getBaseHomeDirectory());
        int fragmentSize = configuration.getFragmentSizeInBytes();
        int numberOfFragments = recordingDivider.calculateNumberOfFragments(originalRecording, fragmentSize);
        int offset = 0;

        ArrayList<Recording> pieces = new ArrayList<Recording>();

        for (int i = 0; i < numberOfFragments; i++) {
            try {
                offset = offset + i * fragmentSize;
                byte[] bytes = recordingDivider.copyBytesFromRecording(originalRecording, fragmentSize, offset);
                Recording fragment = recordingDivider.createRecordingFromBytes(originalRecording.getRecordingName() + "pt." + i, bytes);
                pieces.add(fragment);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pieces;
    }
}
