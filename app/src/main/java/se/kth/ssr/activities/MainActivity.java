package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.joda.time.LocalTime;

import se.kth.ssr.R;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String VIEW_RECORDINGS_PATH = getExternalFilesDir(null).getAbsolutePath();
        final String CAPTURE_RECORDING_PATH = VIEW_RECORDINGS_PATH + "/Rec" + LocalTime.now().toString() + ".3gp";


        Button viewRecordingsButton = (Button) findViewById(R.id.fragment_main_go_to_directory);
        viewRecordingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewRecordingsDirectoryIntent = ViewDirectoryActivity.getLaunchIntent(MainActivity.this, VIEW_RECORDINGS_PATH);
                startActivity(viewRecordingsDirectoryIntent);
            }
        });

        Button launchRecordingButton = (Button) findViewById(R.id.fragment_main_go_to_record);
        launchRecordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startRecordingIntent = RecordingActivity.getLaunchIntent(MainActivity.this, CAPTURE_RECORDING_PATH);
                startActivity(startRecordingIntent);
            }
        });
    }
}
