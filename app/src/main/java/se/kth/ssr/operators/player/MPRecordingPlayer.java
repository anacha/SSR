package se.kth.ssr.operators.player;

import android.media.MediaPlayer;

import java.io.IOException;

import se.kth.ssr.operators.RecordingCreator;
import se.kth.ssr.util.operations.player.MPPlayerConf;

/**
 * Created by argychatzi on 7/7/14.
 */
public class MPRecordingPlayer extends RecordingCreator {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnPreparedListener mListener;

    public MPRecordingPlayer(MediaPlayer.OnPreparedListener listener, MPPlayerConf configuration, String recordingPath) {
        super(configuration, recordingPath);
        mListener = listener;
        mediaPlayer = initMediaPlayer(configuration, recordingPath);
    }

    private MediaPlayer initMediaPlayer(MPPlayerConf configuration, String recordingPath) {
        mediaPlayer = new MediaPlayer();

        mediaPlayer.reset();
        int audioStreamType = configuration.getStreamType();

        try {
            mediaPlayer.setAudioStreamType(audioStreamType);
            mediaPlayer.setDataSource(recordingPath);
            mediaPlayer.setOnPreparedListener(mListener);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }

    public void play() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void release() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
