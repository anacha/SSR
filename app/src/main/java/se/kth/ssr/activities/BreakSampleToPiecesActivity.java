package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by argychatzi on 5/18/14.
 */
public class BreakSampleToPiecesActivity extends Activity{


    private static final String FILENAME_BUNDLE_KEY = "FILENAME_BUNDLE_KEY";
    private static final String NUMBER_OF_PIECES_BUNDLE_KEY = "NUMBER_OF_PIECES_BUNDLE_KEY";

    public static Intent getLaunchIntent(Context context, String fileName, int defaultNumOfPieces) {

        Intent intent = new Intent(context, BreakSampleToPiecesActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString(FILENAME_BUNDLE_KEY, fileName);
        bundle.putInt(NUMBER_OF_PIECES_BUNDLE_KEY, defaultNumOfPieces);

        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Will create a new directory, copy the file there and break it into pieces
     *
     * @param fileName to be copied and fragmented
     * @param numberOfPieces to be broken into
     */
    private void breakVoiceSampleInFileInPieces(String fileName, int numberOfPieces) {

    }


}
