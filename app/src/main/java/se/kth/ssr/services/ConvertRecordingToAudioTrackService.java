package se.kth.ssr.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import se.kth.ssr.operators.RecordingCreator;

/**
 * Created by argychatzi on 3/23/14.
 */
public class ConvertRecordingToAudioTrackService extends Service {

    private RecordingCreator mRecordingCreator;

    public static Intent getLaunchIntent(Context context){
        Intent intent = new Intent(context, ConvertRecordingToAudioTrackService.class);
        return intent;
    }

    @Override
    public IBinder onBind(Intent intent) {

//        mCreator = new RecordingCreator();

        return null;
    }
}
