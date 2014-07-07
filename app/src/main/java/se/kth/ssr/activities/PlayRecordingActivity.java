package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import se.kth.ssr.R;
import se.kth.ssr.base.BaseActivity;
import se.kth.ssr.models.Recording;
import se.kth.ssr.operators.player.ATRecordingPlayer;
import se.kth.ssr.operators.player.MPRecordingPlayer;
import se.kth.ssr.util.operations.player.ATPlayerConf;
import se.kth.ssr.util.operations.player.MPPlayerConf;

/**
 * Created by argychatzi on 3/29/14.
 */
public class PlayRecordingActivity extends BaseActivity {

    private static final String VOICE_SAMPLE_BUNDLE_KEY = "VOICE_SAMPLE_BUNDLE_KEY";
    private static final String TAG = "PlayVoiceSampleActivity";

//    private ATRecordingPlayer mPlayer;

    private MPRecordingPlayer mPlayer;

    public static Intent getLaunchIntent(Activity context, Recording sample) {
        Intent intent = new Intent(context, PlayRecordingActivity.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable(VOICE_SAMPLE_BUNDLE_KEY, sample);
        intent.putExtras(bundle);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_sample);

        Recording recording = getIntent().getExtras().getParcelable(VOICE_SAMPLE_BUNDLE_KEY);

        TextView titleTextView = (TextView) findViewById(R.id.play_sample_sample_title);
        titleTextView.setText(recording.getRecordingPath());

//        ATPlayerConf configuration = getATPlayerConfiguration();
//        mPlayer = new ATRecordingPlayer(configuration, recording.getRecordingPath());
        MPPlayerConf configuration = getMPPlayerConfiguration();
        mPlayer = new MPRecordingPlayer(configuration, recording.getRecordingPath());

        mPlayer.play();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mPlayer != null){
            mPlayer.stop();
            mPlayer.release();
        }
    }
}
