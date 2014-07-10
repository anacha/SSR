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
import se.kth.ssr.base.OperationActivity;
import se.kth.ssr.dataprovider.models.Recording;
import se.kth.ssr.operators.RecordingFinder;

/**
 * Created by argychatzi on 3/23/14.
 */
public class ViewDirectoryActivity extends OperationActivity {

    private static final String VIEW_PATH_BUNDLE_KEY = "VIEW_PATH_BUNDLE_KEY";
    private String mPath;

    public static Intent getLaunchIntent(Activity activityContext, String path) {
        Intent launchIntent = new Intent(activityContext, ViewDirectoryActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(VIEW_PATH_BUNDLE_KEY, path);
        launchIntent.putExtras(bundle);

        return launchIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_voice);
        ListView listView = (ListView) findViewById(R.id.select_voice_sample_list);

        mPath = getIntent().getExtras().getString(VIEW_PATH_BUNDLE_KEY);

        RecordingFinder recordingsFinder = new RecordingFinder(mPath);
        final List<Recording> recordings = recordingsFinder.find();

        RecordingsListAdapter adapter = new RecordingsListAdapter(recordings);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Recording sampleSelected = recordings.get(position);
                Intent playSampleIntent = PlayRecordingActivity.getLaunchIntent(ViewDirectoryActivity.this, sampleSelected);
                startActivity(playSampleIntent);
            }
        });
    }
}
