package rashmi.sampleproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rashmi.sampleproject.R;

/**
 * Created by rashmi.ramesh on 20-05-2017.
 */

public class MilestoneFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.milestone_fragment, container, false);
    }
}
