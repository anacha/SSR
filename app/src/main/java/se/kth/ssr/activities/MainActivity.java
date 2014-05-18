package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import se.kth.ssr.R;
import se.kth.ssr.utils.Configuration;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewRecordingsButton = (Button) findViewById(R.id.fragment_main_go_to_directory);
        viewRecordingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectVoiceIntent = SelectVoiceActivity.getLaunchIntent(MainActivity.this);
                startActivity(selectVoiceIntent);
            }
        });

        Button launchRecordingButton = (Button) findViewById(R.id.fragment_main_go_to_record);
        launchRecordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration repository = Configuration.getInstance(MainActivity.this);
                String path = repository.getBaseHomeDirectory();
                Intent startRecordingIntent = RecordingActivity.getLaunchIntent(MainActivity.this, path);
                startActivity(startRecordingIntent);
            }
        });

    }
}
