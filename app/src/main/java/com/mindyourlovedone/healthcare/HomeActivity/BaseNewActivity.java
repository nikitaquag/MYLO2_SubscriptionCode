package com.mindyourlovedone.healthcare.HomeActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mindyourlovedone.healthcare.Fragment.FragmentContactUs;
import com.mindyourlovedone.healthcare.Fragment.FragmentDashboardNew;
import com.mindyourlovedone.healthcare.Fragment.FragmentResourcesNew;
import com.mindyourlovedone.healthcare.Fragment.FragmentSetting;
import com.mindyourlovedone.healthcare.Fragment.FragmentSponsor;
import com.mindyourlovedone.healthcare.Fragment.Fragment_Conn_New;

public class BaseNewActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgDrawer, imgHelp;
    DrawerLayout drawerLayout;
    RelativeLayout leftDrawer, container;
    RelativeLayout rlSettings, rlWebsite, rlGuide, rlProfiles, rlHome, rlSupport, rlContactUs, rlSponsor, rlResources, rlPrivacy, rlMarketPlace, rlVideos, rlBackup, rlResourcesDetail, rlMarketDetail, rlPrivacyDetail;
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
                } else if (p == 2) {
                    callFragment(new FragmentResourcesNew());
                } else if (p == 3) {
                    callFragment(new FragmentSetting());
                } else if (p == 4) {
                    callFragment(new FragmentContactUs());
                } else if (p == 5) {
                    callFragment(new FragmentResources());
                } else if (p == 6) {
                    callFragment(new FragmentSponsor());
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
        imgHelp.setOnClickListener(this);
        imgDrawer.setOnClickListener(this);
        rlHome.setOnClickListener(this);
        rlProfiles.setOnClickListener(this);
        rlResources.setOnClickListener(this);
        rlSponsor.setOnClickListener(this);
        rlSettings.setOnClickListener(this);
        rlContactUs.setOnClickListener(this);
        rlMarketPlace.setOnClickListener(this);
        rlVideos.setOnClickListener(this);
    }

    private void initUi() {
        imgHelp = findViewById(R.id.imgHelp);
        imgDrawer = findViewById(R.id.imgDrawer);
        drawerLayout = findViewById(R.id.drawerLayout);
        leftDrawer = findViewById(R.id.leftDrawer);
        container = findViewById(R.id.fragmentContainer);
        rlHome = findViewById(R.id.rlHome);
        rlProfiles = findViewById(R.id.rlProfiles);
        rlResources = findViewById(R.id.rlResources);
        rlSponsor = findViewById(R.id.rlSponsor);
        rlSettings = findViewById(R.id.rlSettings);
        rlContactUs = findViewById(R.id.rlContactUs);
        rlMarketPlace = findViewById(R.id.rlMarketPlace);
        rlVideos = findViewById(R.id.rlVideos);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgDrawer:
                drawerLayout.openDrawer(leftDrawer);
                break;
            case R.id.rlHome:
                Intent intentHome = new Intent(context, SplashNewActivity.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentHome);
                drawerLayout.closeDrawer(leftDrawer);
                break;
            case R.id.rlProfiles:
                Intent intentProfile = new Intent(context, BaseNewActivity.class);
                intentProfile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentProfile.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentProfile);
                drawerLayout.closeDrawer(leftDrawer);
                break;
            case R.id.rlResources:
                Intent intentResources = new Intent(context, BaseNewActivity.class);
                intentResources.putExtra("Home", 2);
                intentResources.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentResources.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentResources);
                drawerLayout.closeDrawer(leftDrawer);
                break;
            case R.id.rlSponsor:
                Intent intentSponsor = new Intent(context, BaseNewActivity.class);
                intentSponsor.putExtra("Home", 6);
                intentSponsor.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentSponsor.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentSponsor);
                drawerLayout.closeDrawer(leftDrawer);
                break;
            case R.id.rlSettings:
                Intent intentSettings = new Intent(context, BaseNewActivity.class);
                intentSettings.putExtra("Home", 3);
                intentSettings.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentSettings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentSettings);
                drawerLayout.closeDrawer(leftDrawer);
                break;
            case R.id.rlContactUs:
                Intent intentContactUs = new Intent(context, BaseNewActivity.class);
                intentContactUs.putExtra("Home", 4);
                intentContactUs.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentContactUs.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentContactUs);
                drawerLayout.closeDrawer(leftDrawer);
                break;
            case R.id.rlMarketPlace:
                drawerLayout.closeDrawer(leftDrawer);
                dialogCommingSoon();
                break;
            case R.id.rlVideos:
                drawerLayout.closeDrawer(leftDrawer);
                dialogCommingSoon();
                break;
        }
    }

    private void dialogCommingSoon() {
        final Dialog dialogBank = new Dialog(context);
        dialogBank.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBank.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        LayoutInflater lf = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogview = lf.inflate(R.layout.dialog_bank, null);
        final TextView txtComming = dialogview.findViewById(R.id.txtComming);
        final TextView txtOk = dialogview.findViewById(R.id.txtOk);

        dialogBank.setContentView(dialogview);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogBank.getWindow().getAttributes());
        int width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.70);
        lp.width = width;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogBank.getWindow().setAttributes(lp);
        dialogBank.show();

        txtOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBank.dismiss();
            }
        });
    }

}
