package se.kth.ssr.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import se.kth.ssr.R;
import se.kth.ssr.models.VoiceSample;

/**
 * Created by argychatzi on 3/29/14.
 */
public class PlayVoiceSampleActivity extends Activity {

    private static final String VOICE_SAMPLE_BUNDLE_KEY = "VOICE_SAMPLE_BUNDLE_KEY";
    private static final int DEFAULT_AUDIO_TRACK_SAMPLE_RATE = 16000; // 44.1 kHz

    public static final int BUFFER_SIZE = 5120000;

    private static final String TAG = "PlayVoiceSampleActivity";

    private AudioTrack mAudioTrack;
    private PlayAudioTrackTask mPrepareAudioTask;


    public static Intent getLaunchIntent(Activity context, VoiceSample sample) {
        Intent intent = new Intent(context, PlayVoiceSampleActivity.class);

        Bundle bundle = new Bundle();
        bundle.putParcelable(VOICE_SAMPLE_BUNDLE_KEY, sample);

        intent.putExtras(bundle);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_sample);

        VoiceSample sample = getIntent().getExtras().getParcelable(VOICE_SAMPLE_BUNDLE_KEY);

        TextView titleTextView = (TextView) findViewById(R.id.play_sample_sample_title);
        titleTextView.setText(sample.getFileName());

        int minBufferSize = AudioTrack.getMinBufferSize(DEFAULT_AUDIO_TRACK_SAMPLE_RATE, AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT);

        mAudioTrack =
                new AudioTrack(AudioManager.STREAM_MUSIC,       //ok
                        DEFAULT_AUDIO_TRACK_SAMPLE_RATE,        //16 kHz should be ok
                        AudioFormat.CHANNEL_OUT_STEREO,           //ok
                        AudioFormat.ENCODING_PCM_16BIT,         //ok
                        minBufferSize,                          //file is big enough!
                        AudioTrack.MODE_STATIC);                //ok

        mPrepareAudioTask = new PlayAudioTrackTask();
        mPrepareAudioTask.execute(sample);
    }


    @Override
    protected void onPause() {
        //handle playback, perhaps stop?
        mPrepareAudioTask.cancel(true);
        super.onPause();
    }

    private class PlayAudioTrackTask extends AsyncTask<VoiceSample, Void, Void> {

        @Override
        protected Void doInBackground(VoiceSample... sample) {
            try {
                playAudioTrackFromSample(sample[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d(TAG, "onPostExecute ");
            mAudioTrack.play();
            super.onPostExecute(aVoid);
        }

        private void playAudioTrackFromSample(VoiceSample sample) throws IOException {
            AudioTrack result = mAudioTrack;
            File file = sample.getFile();
            if (file.canRead()) {

                InputStream is = new FileInputStream(file);
                DataInputStream dis = new DataInputStream(is);      //  Create a DataInputStream to read the audio data from the saved file

                int i = 0;                                                          //  Read the file into the "music" array
                Log.d(TAG, "reading ... ");

                byte[] s = new byte[(int)file.length()];

                int offset = 0;
                while((i = dis.read(s, 0, s.length)) > -1){
                    mAudioTrack.write(s, offset, i);
                    offset = offset + i;

                    Log.d (TAG, "read " + i + " bytes");
                    Log.d (TAG, "offset = " + offset);
                }

                dis.close();
                is.close();

            } else {
                result = null;
            }

            if(result == null){
                Log.d(TAG, "returning null!");
            }
        }
    }

    private class AndroidAudioDevice {
        AudioTrack track;
        short[] buffer = new short[1024];

        public AndroidAudioDevice() {
            int minSize = AudioTrack.getMinBufferSize(44100, AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT);
            track = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
                    AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT,
                    minSize, AudioTrack.MODE_STREAM);
            track.play();
        }

        public void writeSamples(float[] samples) {
            fillBuffer(samples);
            track.write(buffer, 0, samples.length);
        }

        private void fillBuffer(float[] samples) {
            if (buffer.length < samples.length)
                buffer = new short[samples.length];

            for (int i = 0; i < samples.length; i++)
                buffer[i] = (short) (samples[i] * Short.MAX_VALUE);
        }
    }

}
