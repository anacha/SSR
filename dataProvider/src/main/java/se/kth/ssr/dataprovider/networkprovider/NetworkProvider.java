package se.kth.ssr.dataprovider.networkprovider;

import java.util.List;

import retrofit.Callback;
import se.kth.ssr.dataprovider.models.Recording;
import se.kth.ssr.dataprovider.models.UserModelResponse;

/**
 * Created by argychatzi on 7/11/14.
 */
public class NetworkProvider {

    public NetworkProvider(NetworkConfiguration networkConfiguration){
        //TODO create an networking endpoint for the rest of the calls to use
    }

    public UserModelResponse getUserResponse(String userId){
        //TODO put the userId as an HTTP get urlParam
        return null;
    }

    public void sendRecordingsToBackend(List<Recording> listOfRecordings){
        //TODO pass the recordigns to the body of an http POST.
    }
}
