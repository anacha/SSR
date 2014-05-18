package se.kth.ssr.test.java.tasks;

import junit.framework.TestCase;

import se.kth.ssr.tasks.VoiceSampleFinder;

/**
 * Created by argychatzi on 3/23/14.
 */
public class VoiceSampleFinderTest extends TestCase {

    private static final String TEST_SAMPLE_PATH = "/correct/path";
    private static final String PATH_WITH_NO_SAMPLE_FILES = "/correct/path";
    private VoiceSampleFinder mVoiceSampleFinder;

    @Override
    protected void setUp() throws Exception {
        mVoiceSampleFinder = new VoiceSampleFinder("");
        super.setUp();
    }

    public void testSampleFinderThrowsExceptionWhenPathIsNull(){
        mVoiceSampleFinder = new VoiceSampleFinder("");
        assertEquals(true, false);
    }

    public void testSampleFinderThrowsExceptionWhenPathIsEmpty(){
        mVoiceSampleFinder = new VoiceSampleFinder("");
    }

    public void testSampleFinderReturnsNullWhenPathContainsNoFiles(){
        mVoiceSampleFinder = new VoiceSampleFinder(PATH_WITH_NO_SAMPLE_FILES);
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
