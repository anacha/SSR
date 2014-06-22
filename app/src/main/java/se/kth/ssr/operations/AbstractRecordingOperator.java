package se.kth.ssr.operations;

/**
 * Created by argychatzi on 3/29/14.
 *
 * Base class all the different kind of operations one can do in a recording.
 *
 */
public abstract class AbstractRecordingOperator {
    protected String mPath;

    public AbstractRecordingOperator(String path) {
        mPath = path;
    }

    public void setSamplerPath(String path){
        mPath = path;
    }

}
