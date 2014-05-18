package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import se.kth.ssr.R;
import se.kth.ssr.adapters.SampleListAdapter;
import se.kth.ssr.models.VoiceSample;
import se.kth.ssr.tasks.VoiceSampleFinder;

/**
 * Shows the files stored under the SSR directory in the external storage§
 * Created by argychatzi on 3/23/14.
 */
public class SelectVoiceActivity extends Activity {
    public static final String PATH = Environment.getExternalStorageDirectory().toString()+"/SSR/";

    public static Intent getLaunchIntent(Activity activityContext) {
        Intent launchIntent = new Intent(activityContext, SelectVoiceActivity.class);
        return  launchIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_voice);
        ListView listView = (ListView) findViewById(R.id.select_voice_sample_list);

        VoiceSampleFinder voiceSampleFinder = new VoiceSampleFinder(PATH);
        final List<VoiceSample> samples = voiceSampleFinder.getSamples();

        SampleListAdapter adapter = new SampleListAdapter(samples);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VoiceSample sampleSelected = samples.get(position);
//                Intent voiceTokenizerIntent = VoiceTokenizerActivity.getLaunchIntent(SelectVoiceActivity.this, sampleSelected);
//                startActivity(voiceTokenizerIntent);
                Intent playSampleIntent = PlayVoiceSampleActivity.getLaunchIntent(SelectVoiceActivity.this, sampleSelected);
                startActivity(playSampleIntent);
            }
        });
    }
}
