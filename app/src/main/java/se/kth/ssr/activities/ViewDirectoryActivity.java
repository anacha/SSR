package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import se.kth.ssr.R;
import se.kth.ssr.adapters.RecordingsListAdapter;
import se.kth.ssr.models.Recording;
import se.kth.ssr.operators.defaults.DefaultRecordingsFinder;

/**
 * Shows the files stored under the SSR directory in the external storage
 * Created by argychatzi on 3/23/14.
 */
public class ViewDirectoryActivity extends Activity {

    public static Intent getLaunchIntent(Activity activityContext) {
        Intent launchIntent = new Intent(activityContext, ViewDirectoryActivity.class);
        return  launchIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_voice);
        ListView listView = (ListView) findViewById(R.id.select_voice_sample_list);

        DefaultRecordingsFinder recordingsFinder = new DefaultRecordingsFinder(this);
        final List<Recording> samples = recordingsFinder.getRecordings();

        RecordingsListAdapter adapter = new RecordingsListAdapter(samples);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Recording sampleSelected = samples.get(position);
                Intent playSampleIntent = PlayRecordingActivityDefault.getLaunchIntent(ViewDirectoryActivity.this, sampleSelected);
                startActivity(playSampleIntent);
            }
        });
    }
}
