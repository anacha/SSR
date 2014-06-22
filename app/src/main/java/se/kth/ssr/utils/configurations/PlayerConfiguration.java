package se.kth.ssr.utils.configurations;

public interface PlayerConfiguration{
    public int getStreamType();
    public int getChannelConfig();
    public int getAudioFormat();
    public int getAudioTrackMode();
    public int getAudioTrackBufferSizeInBytes();
}
