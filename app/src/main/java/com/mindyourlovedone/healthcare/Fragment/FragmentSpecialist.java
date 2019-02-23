package com.mindyourlovedone.healthcare.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mindyourlovedone.healthcare.HomeActivity.R;

public class FragmentSpecialist extends Fragment {
    View rootView;
    ListView lvSpecialist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_specialist_new, container, false);
        initUi();
        return rootView;
    }

    private void initUi() {
        lvSpecialist = rootView.findViewById(R.id.lvSpecialist);
    }
}

