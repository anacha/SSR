package se.kth.ssr.tasks;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.AsyncTask;
import android.util.Log;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import se.kth.ssr.models.Recording;

/**
 * Created by argychatzi on 6/22/14.
 */
public class RecordingToAudioTrackConverterTask extends AsyncTask<Recording, Void, AudioTrack> {

    private static final int DEFAULT_AUDIO_TRACK_SAMPLE_RATE = 16000; // 44.1 kHz
    private static final String TAG = "PlayAudioTrackTask";

    private PlayAudioTrackHolder mHolder;

    public RecordingToAudioTrackConverterTask(PlayAudioTrackHolder holder) {
        mHolder = holder;
    }

    @Override
    protected AudioTrack doInBackground(Recording... sample) {
        AudioTrack result = null;
        try {
            Recording recording = sample[0];
            result = convertRecordingToAudioTrack(recording);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(AudioTrack track) {
        mHolder.onAudioTrackConverted(track);
    }

    private AudioTrack convertRecordingToAudioTrack(Recording sample) throws IOException {
        AudioTrack audioTrack = prepareAudioTrack();
        File file = sample.getFile();
        if (file.canRead()) {

            InputStream is = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(is);

            int bytesRead = 0;
            int readerBufferSize = 100000;
            int finalReaderBufferSize = (int)file.length();
            Log.d(TAG, "reading ... ");

            byte[] buffer = new byte[readerBufferSize+1];

            int offset = 0;
            while (bytesRead  > -1 && readerBufferSize + offset < finalReaderBufferSize) {
                bytesRead = dataInputStream.read(buffer, offset, readerBufferSize);
                audioTrack.write(buffer, offset, bytesRead);
                offset = offset + bytesRead;
                Log.d(TAG, "read " + bytesRead + " bytes");
            }
            dataInputStream.close();
            is.close();
            Log.d(TAG, "read " + finalReaderBufferSize + " bytes");

        } else {
            audioTrack = null;
        }

        if (audioTrack == null) {
            mHolder.onConversionFailed();
        }
        return audioTrack;
    }

    private AudioTrack prepareAudioTrack() {
        int minBufferSize = 100000;
        return new AudioTrack(AudioManager.STREAM_MUSIC,    //ok
                DEFAULT_AUDIO_TRACK_SAMPLE_RATE,            //16 kHz should be ok
                AudioFormat.CHANNEL_OUT_STEREO,             //ok
                AudioFormat.ENCODING_PCM_16BIT,             //ok
                minBufferSize,                              //file is big enough!
                AudioTrack.MODE_STREAM);
    }

    public interface PlayAudioTrackHolder {
        public void onAudioTrackConverted(AudioTrack track);

        public void onConversionFailed();
    }
}
