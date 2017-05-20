package rashmi.sampleproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import rashmi.sampleproject.R;
import rashmi.sampleproject.adapter.RecyclerViewAdapter;
import rashmi.sampleproject.model.VideoModel;

/**
 * Created by rashmi.ramesh on 20-05-2017.
 */

public class VideosFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment, container, false);

        VideoModel videoModel1 = new VideoModel();
        videoModel1.setIcon(getResources().getDrawable(R.drawable.slider1));
        videoModel1.setTitle(getString(R.string.title_text_1));
        videoModel1.setSubText(getString(R.string.sub_text_1));
        videoModel1.setDescription(getString(R.string.description_text));

        VideoModel videoModel2 = new VideoModel();
        videoModel2.setIcon(getResources().getDrawable(R.drawable.slider2));
        videoModel2.setTitle(getString(R.string.title_text_2));
        videoModel2.setSubText(getString(R.string.sub_text_2));
        videoModel2.setDescription(getString(R.string.description_text));

        VideoModel videoModel3 = new VideoModel();
        videoModel3.setIcon(getResources().getDrawable(R.drawable.slider3));
        videoModel3.setTitle(getString(R.string.title_text_3));
        videoModel3.setSubText(getString(R.string.sub_text_3));
        videoModel3.setDescription(getString(R.string.description_text));

        VideoModel videoModel4 = new VideoModel();
        videoModel4.setIcon(getResources().getDrawable(R.drawable.slider4));
        videoModel4.setTitle(getString(R.string.title_text_4));
        videoModel4.setSubText(getString(R.string.sub_text_4));
        videoModel4.setDescription(getString(R.string.description_text));

        VideoModel videoModel5 = new VideoModel();
        videoModel5.setIcon(getResources().getDrawable(R.drawable.slider5));
        videoModel5.setTitle(getString(R.string.title_text_5));
        videoModel5.setSubText(getString(R.string.sub_text_5));
        videoModel5.setDescription(getString(R.string.description_text));

        ArrayList<VideoModel> videoModelArrayList = new ArrayList<>();//ArrayList of Model
        videoModelArrayList.add(videoModel1);
        videoModelArrayList.add(videoModel2);
        videoModelArrayList.add(videoModel3);
        videoModelArrayList.add(videoModel4);
        videoModelArrayList.add(videoModel5);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_listview);
//    Creating a adapter and passing ArrayList and context as parameters
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(videoModelArrayList, getContext());
        //setting an adapter for the Recycle view
        recyclerView.setAdapter(adapter);
        // If you are sure that the size of the RecyclerView won't be changing,  do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        return view;
    }
}
