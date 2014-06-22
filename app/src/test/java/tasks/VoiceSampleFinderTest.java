package se.kth.ssr.test.java.tasks;

import junit.framework.TestCase;

import se.kth.ssr.operations.defaults.DefaultRecordingsFinder;

/**
 * Created by argychatzi on 3/23/14.
 */
@RunWith(RobolectricTestRunner.class)
public class VoiceSampleFinderTest extends TestCase {

    private static final String TEST_SAMPLE_PATH = "/correct/path";
    private static final String PATH_WITH_NO_SAMPLE_FILES = "/correct/path";
    private DefaultRecordingsFinder mDefaultDefaultRecordingsFinder;

    @Override
    protected void setUp() throws Exception {
        mDefaultDefaultRecordingsFinder = new DefaultRecordingsFinder("");
        super.setUp();
    }

    public void testSampleFinderThrowsExceptionWhenPathIsNull(){
        mDefaultDefaultRecordingsFinder = new DefaultRecordingsFinder("");
    }

    public void testSampleFinderThrowsExceptionWhenPathIsEmpty(){
        mDefaultDefaultRecordingsFinder = new DefaultRecordingsFinder("");
    }

    public void testSampleFinderReturnsNullWhenPathContainsNoFiles(){
        mDefaultDefaultRecordingsFinder = new DefaultRecordingsFinder(PATH_WITH_NO_SAMPLE_FILES);
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
