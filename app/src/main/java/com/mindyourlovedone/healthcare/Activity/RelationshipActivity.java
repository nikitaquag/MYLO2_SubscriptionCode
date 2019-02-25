package com.mindyourlovedone.healthcare.Activity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.Fragment.FragmentSpecialist;
import com.mindyourlovedone.healthcare.Fragment.FragmentType;
import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.InsuranceHealthCare.TypeAdapter;

/*Created by Shradha 15 Feb 2019*/
public class RelationshipActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack, imgHome;
    TextView txtType, txtSpecialist;
    RelativeLayout rlType, rlSpecialist;
    Context context = this;
    TypeAdapter rd;
    ListView lvType, lvSpecialist;
    String Type[] = {"Blood Work", "Colonsocopy", "CT Scan", "Echocardiogram", "EKG", "Glucose Test", "Hyperthyroid Blood Test", "Hypothyroid Blood Test", "Mammogram", "MRI", "Prostate Specific Antigen (PSA)", "Sonogram", "Thyroid Scan"};
    String Specialist[] = {"Acupuncturist", "Allergist (Immunologist)", "Anesthesiologist", "Audiologist", "Cardiologist", "Cardiothoracic Surgeon", "Chiropractor", "Colorectal Surgeon", "Cosmetic Surgeon", "Critical Care Medicine", "Dentist", "Dermatologist", "Dietitian/Nutritionist", "Diabetes & Metabolism", "Ear, Nose & Throat Doctor (ENT, Otolaryngologist)", "Emergency Medicine", "Endocrinologist (incl. Diabetes Specialists)", "Endodontics", "Endovascular Medicine", "Eye Doctor", "Family Medicine", "Gastroenterologist", "Geriatrician", "Gynecologist", "Hearing Specialist", "Hematologist (Blood Specialist)", "Hospice", "Infectious Disease Specialist", "Infertility Specialist", "Internal Medicine", "Midwife", "Naturopathic Doctor", "Nephrologist (Kidney Specialist)", "Neurologist (Inc. Headache Specialist)", "Neurosurgeon", "OB-GYN (Obstetrician-Gynecologist)", "Occupational Therapist", "Oncologist", "Ophthalmologist", "Optometrist", "Oral Surgeon", "Orthodontist", "Orthopedic Surgeon (Orthopedist)", "Osteopath", "Otolaryngologist", "Pain Management Specialist", "Palliative Care Specialist", "Pediatric Dentist", "Pediatrician", "Periodontist", "Physician Assistant", "Physiatrist (Physical Medicine)", "Physical Therapist", "Plastic & Reconstructive Surgeon", "Podiatrist (Foot and Ankle Specialist)", "Primary Care Doctor (PCP)", "Prosthodontist", "Psychiatrist", "Psychologist", "Psychotherapist", "Pulmonologist (Lung Doctor)", "Radiologist", "Rheumatologist", "Sleep Medicine Specialist", "Speech Therapist", "Sports Medicine Specialist", "Surgeon - General", "Therapist / Counselor", "Thoracic & Cardiac Surgery", "Urgent Care Specialist", "Urological Surgeon", "Urologist", "Vascular Surgeon", "Other"};
    String category = "";
    private static int RESULT_TYPE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relationship);

       /* Intent intent = getIntent();
        if (intent.getExtras() != null) {
            String category = intent.getExtras().getString("Category");
            if (category.equalsIgnoreCase("TypeAppointment")) {
                rd = new TypeAdapter(context, Type);
                lvType = findViewById(R.id.lvType);
                lvType.setAdapter(rd);

                txtType.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "In Type..!!", Toast.LENGTH_SHORT).show();
                        initUi();
                        rlType.setVisibility(View.VISIBLE);
                        rlSpecialist.setVisibility(View.GONE);
                        TypeAdapter rd = new TypeAdapter(context, Type);
                        lvType.setAdapter(rd);
                    }
                });
            }
        }*/
        initUi();
        initListener();
    }


    private void initUi() {
        imgBack = findViewById(R.id.imgBack);
        imgHome = findViewById(R.id.imgHome);

        rlType = findViewById(R.id.rlType);
        rlSpecialist = findViewById(R.id.rlSpecialist);

        lvType = findViewById(R.id.lvType);
        rd = new TypeAdapter(context, Type);
        lvType.setAdapter(rd);

        lvSpecialist = findViewById(R.id.lvSpecialist);

        txtType = findViewById(R.id.txtType);
       /* txtType.setBackgroundColor(getResources().getColor(R.color.colorNewHereBlue));
        txtType.setTextColor(getResources().getColor(R.color.colorWhite));
        txtType.setBackground(getResources().getDrawable(R.drawable.border_type));*/

        txtSpecialist = findViewById(R.id.txtSpecialist);
       /* txtSpecialist.setBackgroundColor(getResources().getColor(R.color.colorOnesGray));
        txtSpecialist.setTextColor(getResources().getColor(R.color.colorWhite));
        txtSpecialist.setBackground(getResources().getDrawable(R.drawable.border_specialist));*/

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            final String category = intent.getExtras().getString("Category");
            if (category != null) {
                switch (category) {
                    case "TypeAppointment":
                        rd = new TypeAdapter(context, Type);
                        lvType.setAdapter(rd);


                        break;
                    case "TypeSpecialist":
                        rd = new TypeAdapter(context, Specialist);
                        lvSpecialist.setAdapter(rd);
                        break;
                }
            }
            txtSpecialist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 //  if (category.equalsIgnoreCase("TypeSpecialist")) {
                        Toast.makeText(context, "In Specialist..!!", Toast.LENGTH_SHORT).show();
                        rlType.setVisibility(View.GONE);
                        rlSpecialist.setVisibility(View.VISIBLE);
                        rd = new TypeAdapter(context, Specialist);
                        lvSpecialist.setAdapter(rd);
                 //   }
                }
            });

            txtType.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // if (category.equalsIgnoreCase("TypeAppointment")) {
                        Toast.makeText(context, "In Type..!!", Toast.LENGTH_SHORT).show();
                        rlType.setVisibility(View.VISIBLE);
                        rlSpecialist.setVisibility(View.GONE);
                        rd = new TypeAdapter(context, Type);
                        lvType.setAdapter(rd);
                    }
               // }
            });

            lvType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView txtType = view.findViewById(R.id.txtType);
                    Intent i1 = new Intent();
                    if (category.equalsIgnoreCase("TypeAppointment")) {
                        i1.putExtra("TypeAppointment", txtType.getText().toString());
                        setResult(RESULT_TYPE, i1);
                    }
                    finish();
                }
            });

            lvSpecialist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView txtType = view.findViewById(R.id.txtType);
                    Intent i1 = new Intent();
                    if (category.equalsIgnoreCase("TypeAppointment")) {
                        i1.putExtra("TypeAppointment", txtType.getText().toString());
                        setResult(RESULT_TYPE, i1);
                    }
                    finish();
                }
            });



             /* Bundle bundle = new Bundle();
                bundle.putString("Category", "TypeAppointment");
                FragmentType fragmentType = new FragmentType();
                fragmentType.setArguments(bundle);
                // callFragment(new FragmentType());*/
        }
    }

    private void initListener() {
        imgBack.setOnClickListener(this);
        imgHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgHome:
                Intent intentHome = new Intent(context, BaseActivity.class);
                intentHome.putExtra("c", 1);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentHome);
                break;
            case R.id.imgBack:
                finish();
                break;
          /*  case R.id.txtType:
                rlType.setVisibility(View.VISIBLE);
                rlSpecialist.setVisibility(View.GONE);
                initUi();
               *//* //type view changes
                 callFragment(new FragmentType());
                txtType.setBackgroundColor(getResources().getColor(R.color.colorNewHereBlue));
                txtType.setTextColor(getResources().getColor(R.color.colorWhite));
                txtType.setBackground(getResources().getDrawable(R.drawable.border_type));

                //specialist view changes
                txtSpecialist.setBackground(getResources().getDrawable(R.drawable.border_specialist));
                txtSpecialist.setBackgroundColor(getResources().getColor(R.color.colorOnesGray));
                txtSpecialist.setTextColor(getResources().getColor(R.color.colorNewHereBlue));
*//*

                break;*/
          /*  case R.id.txtSpecialist:
                rlType.setVisibility(View.GONE);
                rlSpecialist.setVisibility(View.VISIBLE);
                initUi();
               *//* txtSpecialist.setBackgroundColor(getResources().getColor(R.color.colorNewHereBlue));
                txtSpecialist.setTextColor(getResources().getColor(R.color.colorWhite));
                txtSpecialist.setBackground(getResources().getDrawable(R.drawable.border_specialist));

                txtType.setBackground(getResources().getDrawable(R.drawable.border_type));
                txtType.setBackgroundColor(getResources().getColor(R.color.colorOnesGray));
                txtType.setTextColor(getResources().getColor(R.color.colorNewHereBlue));

                callFragment(new FragmentSpecialist());*//*
                break;*/
        }
    }
}
