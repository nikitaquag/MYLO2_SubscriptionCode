package com.mindyourlovedone.healthcare.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.InsuranceHealthCare.SettingAdapter;
import com.mindyourlovedone.healthcare.model.Setting;

import java.util.ArrayList;

public class FragmentSetting extends Fragment {
    View rootView;
    ArrayList<Setting> settingList;
    ListView lvSetting;
    ImageView imgHelp;
    TextView txtTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        initUi();
        getData();
        setData();

        return rootView;
    }

    private void setData() {
        SettingAdapter sd = new SettingAdapter(getActivity(), settingList);
        lvSetting.setAdapter(sd);
    }

    private void getData() {
        settingList = new ArrayList<Setting>();

        Setting s1 = new Setting();
        s1.setName("Backup, Restore, Share");
        s1.setResImage(R.drawable.medical_one);

        Setting s2 = new Setting();
        s2.setName("Change Password");
        s2.setResImage(R.drawable.insu_one);

        Setting s3 = new Setting();
        s3.setName("User Guide");
        s3.setResImage(R.drawable.drawer_videos);

        Setting s4 = new Setting();
        s4.setName("Privacy Policy");
        s4.setResImage(R.drawable.drawer_videos);

        Setting s5 = new Setting();
        s5.setName("End User License Agreement");
        s5.setResImage(R.drawable.drawer_videos);

        settingList.add(s1);
        settingList.add(s2);
        settingList.add(s3);
        settingList.add(s4);
        settingList.add(s5);
    }

    private void initUi() {
        txtTitle = getActivity().findViewById(R.id.txtTitle);
        txtTitle.setText("Settings");
        lvSetting = rootView.findViewById(R.id.lvSetting);
        imgHelp = getActivity().findViewById(R.id.imgRight);
        imgHelp.setVisibility(View.GONE);
    }
}

