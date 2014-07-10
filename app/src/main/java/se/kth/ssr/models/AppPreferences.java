package se.kth.ssr.models;

/**
 * Created by argychatzi on 7/11/14.
 */
public class AppPreferences {

    private AppPreferences() {
    }

    public class UserPreferencesBuilder {

        private CAPTURING_OPTIONS mCapturingOptions;

        public UserPreferencesBuilder() {
        }

        public AppPreferences build() {
            if(mCapturingOptions == null){
                throw new IllegalStateException("recording capture mode not set!");
            }
            return new AppPreferences();
        }
    }

    public enum CAPTURING_OPTIONS {
        APP_PREFERENCES_RECORD_CONTINUOUSLY, APP_PREFERENCES_RECORD_CALLS_ONLY;
    }
}
