package se.kth.ssr.test.java.tasks;

import junit.framework.TestCase;

/**
 * Created by argychatzi on 3/23/14.
 */
@RunWith(RobolectricTestRunner.class)
public class VoiceSampleFinderTest extends TestCase {

    private static final String TEST_SAMPLE_PATH = "/correct/path";
    private static final String PATH_WITH_NO_SAMPLE_FILES = "/correct/path";
    private RecordingsFinder mDefaultDefaultRecordingsFinder;

    @Override
    protected void setUp() throws Exception {
        mDefaultDefaultRecordingsFinder = new RecordingsFinder("");
        super.setUp();
    }

    public void testSampleFinderThrowsExceptionWhenPathIsNull(){
        mDefaultDefaultRecordingsFinder = new RecordingsFinder("");
    }

    public void testSampleFinderThrowsExceptionWhenPathIsEmpty(){
        mDefaultDefaultRecordingsFinder = new RecordingsFinder("");
    }

    public void testSampleFinderReturnsNullWhenPathContainsNoFiles(){
        mDefaultDefaultRecordingsFinder = new RecordingsFinder(PATH_WITH_NO_SAMPLE_FILES);
    }

    /*
    @Test
    public void testSampleFinderThrowsExceptionWhenPathContainsNoFiles(){
        mVoiceSampleFinder = new VoiceSampleFinder(PATH_WITH_NO_SAMPLE_FILES);
    }
    */


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
