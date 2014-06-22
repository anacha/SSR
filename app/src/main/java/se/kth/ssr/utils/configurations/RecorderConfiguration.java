package se.kth.ssr.utils.configurations;

public interface RecorderConfiguration{
    public int getAudioSource();
    public int getAudioEncoder();
    public int getOutputFormat();
    public String getBaseHomeDirectory();
}
