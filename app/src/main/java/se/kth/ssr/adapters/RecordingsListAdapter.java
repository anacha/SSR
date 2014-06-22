package se.kth.ssr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import se.kth.ssr.R;
import se.kth.ssr.models.Recording;

/**
 * Created by argychatzi on 3/29/14.
 */
public class RecordingsListAdapter extends SSRBaseAdapter {

    public RecordingsListAdapter(List<Recording> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Recording recording = (Recording) mData.get(position);

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.voice_sample_list_item, null);
        TextView sampleTitle = (TextView) view.findViewById(R.id.sample_list_item_title);
        sampleTitle.setText(recording.getRecordingName());

        return view;
    }
}
