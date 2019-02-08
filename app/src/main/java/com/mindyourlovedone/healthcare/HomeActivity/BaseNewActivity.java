package com.mindyourlovedone.healthcare.HomeActivity;

import android.content.Context;
import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mindyourlovedone.healthcare.Connections.FragmentConnectionNew;
import com.mindyourlovedone.healthcare.DashBoard.FragmentDashboard;
import com.mindyourlovedone.healthcare.Fragment.FragmentDashboardNew;
import com.mindyourlovedone.healthcare.Fragment.Fragment_Conn_New;

public class BaseNewActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgDrawer;
    DrawerLayout drawerLayout;
    RelativeLayout leftDrawer, container;
    RelativeLayout rlSettings, rlWebsite, rlGuide, rlProfiles, rlHome, rlSupport, rlContact, rlSponsor, rlResources, rlPrivacy, rlMarketPlace, rlVideos, rlBackup, rlResourcesDetail, rlMarketDetail, rlPrivacyDetail;
    Context context = this;
    int p = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_new);
        callFragment(new Fragment_Conn_New());
        initUi();
        initListener();

        try {
            Intent intent = getIntent();
            if (intent != null) {
                p = intent.getExtras().getInt("Home");
                if (p == 1) {
                    callFragment(new FragmentDashboardNew());
                    p = 1;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void callFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.commit();
    }

    private void initListener() {
        imgDrawer.setOnClickListener(this);

    }

    private void initUi() {
        imgDrawer = findViewById(R.id.imgDrawer);
        drawerLayout = findViewById(R.id.drawerLayout);
        leftDrawer = findViewById(R.id.leftDrawer);
        container = findViewById(R.id.fragmentContainer);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgDrawer:
                drawerLayout.openDrawer(leftDrawer);
                break;

        }
    }
}
