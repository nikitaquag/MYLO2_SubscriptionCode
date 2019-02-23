package com.mindyourlovedone.healthcare.Connections;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mindyourlovedone.healthcare.HomeActivity.R;

public class RelationActivity extends AppCompatActivity {
    ListView listRelation;
    Context context = this;
    ImageView imgBack;
    String category = "";
    private static int RESULT_RELATION = 10;
    private static int RESULT_PRIORITY = 12;
    private static int RESULT_SPECIALTY = 13;
    private static int RESULT_CATEGORY = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation);
        initUi();
    }

    private void initUi() {
        listRelation = findViewById(R.id.listRelation);
        imgBack = findViewById(R.id.imgBack);
        Intent i = getIntent();
        if (i.getExtras() != null) {
            category = i.getStringExtra("Category");
            if (category.equalsIgnoreCase("Relation")) {
                String Relationship[] = {"Aunt", "Brother", "Brother-in-law", "Client", "Cousin", "Dad", "Daughter", "Father-in-law", "Friend", "GrandDaughter", "GrandMother", "GrandFather", "GrandSon", "Husband", "Mom", "Mother-in-law", "Neighbor", "Nephew", "Niece", "Patient", "Roommate", "Significant Other", "Sister", "Sister-in-law", "Son", "Uncle", "Wife", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, Relationship);
                listRelation.setAdapter(rd);
            } else if (category.equalsIgnoreCase("Priority")) {
                String[] priorityType = {"Primary - Emergency Contact", "Primary - Health Care Proxy Agent", "Secondary - Emergency Contact", "Secondary - Health Care Proxy Agent"};
                RelationsAdapter rd = new RelationsAdapter(context, priorityType);
                listRelation.setAdapter(rd);
            } else if (category.equalsIgnoreCase("Specialty")) {
                String[] healthSpeciality = {"Acupuncturist", "Allergist (Immunologist)", "Anesthesiologist", "Audiologist", "Cardiologist", "Cardiothoracic Surgeon", "Chiropractor", "Colorectal Surgeon", "Cosmetic Surgeon", "Critical Care Medicine", "Dentist", "Dermatologist", "Dietitian/Nutritionist", "Diabetes & Metabolism", "Ear, Nose & Throat Doctor (ENT, Otolaryngologist)", "Emergency Medicine", "Endocrinologist (incl. Diabetes Specialists)", "Endodontics", "Endovascular Medicine", "Eye Doctor", "Family Medicine", "Gastroenterologist", "Geriatrician", "Gynecologist", "Hearing Specialist", "Hematologist (Blood Specialist)", "Hospice", "Infectious Disease Specialist", "Infertility Specialist", "Internal Medicine", "Midwife", "Naturopathic Doctor", "Nephrologist (Kidney Specialist)", "Neurologist (Inc. Headache Specialist)", "Neurosurgeon", "OB-GYN (Obstetrician-Gynecologist)", "Occupational Therapist", "Oncologist", "Ophthalmologist", "Optometrist", "Oral Surgeon", "Orthodontist", "Orthopedic Surgeon (Orthopedist)", "Osteopath", "Otolaryngologist", "Pain Management Specialist", "Palliative Care Specialist", "Pediatric Dentist", "Pediatrician", "Periodontist", "Physician Assistant", "Physiatrist (Physical Medicine)", "Physical Therapist", "Plastic & Reconstructive Surgeon", "Podiatrist (Foot and Ankle Specialist)", "Primary Care Doctor (PCP)", "Prosthodontist", "Psychiatrist", "Psychologist", "Psychotherapist", "Pulmonologist (Lung Doctor)", "Radiologist", "Rheumatologist", "Sleep Medicine Specialist", "Speech Therapist", "Sports Medicine Specialist", "Surgeon - General", "Therapist / Counselor", "Thoracic & Cardiac Surgery", "Urgent Care Specialist", "Urological Surgeon", "Urologist", "Vascular Surgeon", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, healthSpeciality);
                listRelation.setAdapter(rd);
            } else if (category.equalsIgnoreCase("Category")) {
                String[] HospitalType = {"Hospital", "Rehabilitation Center", "Home Health Care Agency", "Home Health Care Aide", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, HospitalType);
                listRelation.setAdapter(rd);
            }
        }

        // RelationsAdapter rd = new RelationsAdapter(context, Relationship);
        //listRelation.setAdapter(rd);


        listRelation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtRel = view.findViewById(R.id.txtRel);
                Intent i = new Intent();
                if (category.equalsIgnoreCase("Relation")) {
                    i.putExtra("Relation", txtRel.getText().toString());
                    setResult(RESULT_RELATION, i);
                } else if (category.equalsIgnoreCase("Priority")) {
                    i.putExtra("Priority", txtRel.getText().toString());
                    setResult(RESULT_PRIORITY, i);
                } else if (category.equalsIgnoreCase("Specialty")) {
                    i.putExtra("Specialty", txtRel.getText().toString());
                    setResult(RESULT_SPECIALTY, i);
                } else if (category.equalsIgnoreCase("Category")) {
                    i.putExtra("Category", txtRel.getText().toString());
                    setResult(RESULT_CATEGORY, i);
                }
                finish();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
