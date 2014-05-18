package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.File;

/**
 * Created by argychatzi on 5/18/14.
 */
public class BreakSampleToPiecesActivity extends Activity{

    private static final String FILENAME_BUNDLE_KEY = "FILENAME_BUNDLE_KEY";
    private static final String NUMBER_OF_PIECES_BUNDLE_KEY = "NUMBER_OF_PIECES_BUNDLE_KEY";
    private static final String PATH_BUNDLE_KEY = "PATH_BUNDLE_KEY";

    private String mFileName;

    public static Intent getLaunchIntent(Context context, String fileName, int defaultNumOfPieces) {

        Intent intent = new Intent(context, BreakSampleToPiecesActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString(FILENAME_BUNDLE_KEY, fileName);
        bundle.putString(PATH_BUNDLE_KEY, fileName);
        bundle.putInt(NUMBER_OF_PIECES_BUNDLE_KEY, defaultNumOfPieces);

        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFileName = (String) getIntent().getExtras().get(FILENAME_BUNDLE_KEY);

//        createNewDirectory(path);
//        copyFileToPath(fileName);
    }

    private void breakVoiceSampleInFileInPieces(String fileName, int numberOfPieces) {

    }

    private void createNewDirectory(String path, String name){

    }

    private void copyFileToPath(String file){

    }

}
