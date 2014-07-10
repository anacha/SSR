package se.kth.ssr.dataprovider.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;

/**
 * Created by argychatzi on 3/23/14.
 *
 * Represents a recording in the disk. It holds where the recording is
 * and how big it is.
 */
public class Recording implements Parcelable {

    private File mFile;

    public static Creator<Recording> CREATOR = new Creator<Recording>() {
        public Recording createFromParcel(Parcel source) {
            return new Recording(source);
        }

        public Recording[] newArray(int size) {
            return new Recording[size];
        }
    };

    private Recording(Parcel in) {
        this.mFile = (File) in.readSerializable();
    }

    public Recording(String path) {
        mFile = new File(path);
    }

    public long getSizeInBytes(){
        return mFile.length();
    }

    public String getRecordingPath() {
        return mFile.getAbsolutePath();
    }

    public File getFile() {
        return mFile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.mFile);
    }
}
