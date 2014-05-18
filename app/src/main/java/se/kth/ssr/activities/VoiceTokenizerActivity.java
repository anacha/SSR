package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import se.kth.ssr.R;
import se.kth.ssr.models.VoiceSample;

public class VoiceTokenizerActivity extends Activity {

    private static final String VOICE_SAMPLE_BUNDLE_KEY = "se.kth.ssr.activities.VOICE_SAMPLE_BUNDLE_KEY";

    public static Intent getLaunchIntent(Activity context, VoiceSample sample){
        Intent intent = new Intent(context, VoiceTokenizerActivity.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable(VOICE_SAMPLE_BUNDLE_KEY, sample);

        intent.putExtras(bundle);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_tokenizer);
    }

}
