package com.mindyourlovedone.healthcare.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mindyourlovedone.healthcare.DashBoard.CarePlanActivity;
import com.mindyourlovedone.healthcare.DashBoard.PrescriptionActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.InsuranceHealthCare.SpecialistsActivity;

public class FragmentDashboardNew extends Fragment implements View.OnClickListener {
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    private static final int REQUEST_WRITE_PERMISSION = 200;
    private static final int REQUEST_CALL_PERMISSION = 300;
    View rootView;
    RelativeLayout rlEmergencyContact, rlSpecialist, rlInsuranceCard, rlEmergencyEvent, rlPrescription, rlCarePlan;
    ImageView imgHelp, imgProfile;
    TextView txtSelf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dashboard_news, container, false);
        accessPermission();
        initUi();
        initListener();
        return rootView;
    }

    private void accessPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                ) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, REQUEST_CALL_PERMISSION);

        } else {
            // checkForRegistration();
        }
    }


    private void initListener() {
        rlCarePlan.setOnClickListener(this);
        rlEmergencyContact.setOnClickListener(this);
        rlSpecialist.setOnClickListener(this);
        rlInsuranceCard.setOnClickListener(this);
        rlEmergencyEvent.setOnClickListener(this);
        rlPrescription.setOnClickListener(this);

    }

    private void initUi() {
       /// imgHelp = getActivity().findViewById(R.id.imgHelp);

        imgProfile = getActivity().findViewById(R.id.imgProfile);
        imgProfile.setVisibility(View.VISIBLE);

        rlCarePlan = rootView.findViewById(R.id.rlCarePlan);
        rlEmergencyContact = rootView.findViewById(R.id.rlEmergencyContact);
        rlSpecialist = rootView.findViewById(R.id.rlSpecialist);
        rlInsuranceCard = rootView.findViewById(R.id.rlInsuranceCard);
        rlEmergencyEvent = rootView.findViewById(R.id.rlEmergencyEvent);
        rlPrescription = rootView.findViewById(R.id.rlPrescription);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlEmergencyContact:
                Intent intentOverview = new Intent(getActivity(), SpecialistsActivity.class);
                intentOverview.putExtra("FROM", "Emergency");
                startActivity(intentOverview);
                break;

            case R.id.rlEmergencyEvent:
                Intent intentContact = new Intent(getActivity(), SpecialistsActivity.class);
                intentContact.putExtra("FROM", "Event");
                startActivity(intentContact);
                break;

            case R.id.rlPrescription:
                Intent intentPrescription = new Intent(getActivity(), SpecialistsActivity.class);
                intentPrescription.putExtra("FROM", "Prescription");
                startActivity(intentPrescription);
                break;

            case R.id.rlCarePlan:
                Intent intentCarePlan = new Intent(getActivity(), CarePlanActivity.class);
                startActivity(intentCarePlan);
                break;

            case R.id.rlSpecialist:
                Intent intentInsurance = new Intent(getActivity(), SpecialistsActivity.class);
                intentInsurance.putExtra("FROM", "Speciality");
                startActivity(intentInsurance);
                break;

            case R.id.rlInsuranceCard:
                Intent intentInsuarnc3e = new Intent(getActivity(), SpecialistsActivity.class);
                intentInsuarnc3e.putExtra("FROM", "Insurance");
                startActivity(intentInsuarnc3e);
                /*Intent intentEmergency = new Intent(getActivity(), InsuranceCardActivity.class);
                intentEmergency.putExtra("Flag", "NoMap");
                startActivity(intentEmergency);*/
                break;

        }
    }
}
