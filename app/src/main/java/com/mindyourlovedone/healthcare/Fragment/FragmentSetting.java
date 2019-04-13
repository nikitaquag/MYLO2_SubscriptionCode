package com.mindyourlovedone.healthcare.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.Activity.ChangePasswordActivity;
import com.mindyourlovedone.healthcare.Activity.PrivacyActivity;
import com.mindyourlovedone.healthcare.DashBoard.DropboxLoginActivity;
import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.InsuranceHealthCare.SettingAdapter;
import com.mindyourlovedone.healthcare.model.Setting;

import java.io.File;
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
        s2.setName("MYLO FAQs");
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


        lvSetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://BackUp-Section
                        Intent intentContactUs = new Intent(getActivity(), DropboxLoginActivity.class);
                        getActivity().startActivity(intentContactUs);
                        break;
                    case 1://Change Password-Section
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        intent.setData(Uri.parse("market://details?id=com.adobe.reader"));
                        intent.setType(String.valueOf(Uri.parse("application/pdf")));
                        ((BaseActivity) getActivity()).CopyReadAssetss("FAQ.pdf");
                        // intent.setDataAndType(uri, "application/pdf");
                      /*  try {
                            getActivity().startActivity(intent);

                        } catch (ActivityNotFoundException e) {
                            // No application to view, ask to download one

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("No Application Found");
                            builder.setMessage("Download Office Tool from Google Play ?");
                            builder.setPositiveButton("Yes",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            Intent marketIntent = new Intent(
                                                    Intent.ACTION_VIEW);
                                            marketIntent.setData(Uri
                                                    .parse("market://details?id=com.adobe.reader"));
                                            getActivity().startActivity(marketIntent);
                                        }
                                    });
                            builder.setNegativeButton("No", null);
                            builder.create().show();
                        }*/
                       /* Intent intentChangePass = new Intent(getActivity(), ChangePasswordActivity.class);
                        getActivity().startActivity(intentChangePass);*/
                        break;
                    case 2://User Guide-Section
                        Intent intents = new Intent();
                        intents.setAction(Intent.ACTION_VIEW);
                        intents.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        intents.setData(Uri.parse("market://details?id=com.adobe.reader"));
                        intents.setType(String.valueOf(Uri.parse("application/pdf")));
                        ((BaseActivity) getActivity()).CopyReadAssetss("mylo_users_guide.pdf");
                        /*try {
                            getActivity().startActivity(intents);

                        } catch (ActivityNotFoundException e) {
                            // No application to view, ask to download one

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("No Application Found");
                            builder.setMessage("Download Office Tool from Google Play ?");
                            builder.setPositiveButton("Yes",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                            Intent marketIntent = new Intent(
                                                    Intent.ACTION_VIEW);
                                            marketIntent.setData(Uri
                                                    .parse("market://details?id=com.adobe.reader"));
                                            getActivity().startActivity(marketIntent);
                                        }
                                    });
                            builder.setNegativeButton("No", null);
                            builder.create().show();
                        }*/
                        break;
                    case 3://Privacy Policy-Section
                        Toast.makeText(getActivity(), "Screen not provided...!!", Toast.LENGTH_SHORT).show();
                        // ((BaseActivity) getActivity()).CopyReadAssetss("Privacy Policy.pdf");
                       /* Intent intentPrivacy = new Intent(getActivity(), PrivacyActivity.class);
                        intentPrivacy.putExtra("Privacy","PRIVACY");
                        getActivity().startActivity(intentPrivacy);*/
                        break;
                    case 4://End User License Agreement-Section
                        Toast.makeText(getActivity(), "Screen not provided Yet to come", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }


}

