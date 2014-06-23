package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioTrack;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import se.kth.ssr.R;
import se.kth.ssr.models.Recording;
import se.kth.ssr.tasks.RecordingToAudioTrackConverterTask;

/**
 * Created by argychatzi on 3/29/14.
 */
public class PlayRecordingActivityDefault extends DefaultConfigurationActivity implements RecordingToAudioTrackConverterTask.PlayAudioTrackHolder{

    private static final String VOICE_SAMPLE_BUNDLE_KEY = "VOICE_SAMPLE_BUNDLE_KEY";
    private static final String TAG = "PlayVoiceSampleActivity";

    private RecordingToAudioTrackConverterTask mPrepareAudioTask;

    public static Intent getLaunchIntent(Activity context, Recording sample) {
        Intent intent = new Intent(context, PlayRecordingActivityDefault.class);

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

        mPrepareAudioTask = new RecordingToAudioTrackConverterTask(this);
        mPrepareAudioTask.execute(recording); //TODO on an executor
    }

    @Override
    protected void onPause() {
        mPrepareAudioTask.cancel(true);
        super.onPause();
    }

    @Override
    public void onAudioTrackConverted(AudioTrack track) {
        if(track != null){
            track.play();
        }
    }

    @Override
    public void onConversionFailed() {
        Log.e(TAG, "conversion failed, cannot play file!");
    }
}
