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
    private static int RESULT_FINANCECAT = 15;
    private static final int RESULT_INSURANCE = 16;
    private static final int RESULT_ADVANCE = 20;
    private static final int RESULT_OTHER = 30;
    private static final int RESULT_FREQUENCY = 110;
    private static final int RESULT_BLOOD = 1;

    public static final int REQUEST_RELATIONP = 21;
    public static final int REQUEST_MARITAL = 22;
    public static final int REQUEST_EYES = 23;
    public static final int REQUEST_LANGUAGE= 24;

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
            } else if (category.equalsIgnoreCase("Insurance")) {
                String[] insuaranceType = {"Apartment", "Auto", "Dental", "Disability", "Home", "Life (Wholelife or Term)", "Long Term Care", "Medicaid", "Medical", "Medicare", "Medicare Supplemental (Medigap)", "Supplemental", "Umbrella", "Vision", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, insuaranceType);
                listRelation.setAdapter(rd);
            } else if (category.equalsIgnoreCase("finance")) {
                String[] financeType = {"Accountant", "Attorney", "Broker", "Financial Adviser", "Financial Planner", "Notary", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, financeType);
                listRelation.setAdapter(rd);
            } else if (category.equalsIgnoreCase("Advance")) {
                String[] ADList = {"HIPAA Authorization", "Health Care Proxy", "Living Will", "Living Will/Health Care Proxy", "MOLST", "Non-Hospital DNR Order", "POLST", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, ADList);
                listRelation.setAdapter(rd);
            } else if (category.equalsIgnoreCase("Other")) {
                String[] OtherList = {"Financial", "Insurance", "Legal", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, OtherList);
                listRelation.setAdapter(rd);
            } else if (category.equalsIgnoreCase("TypeFrequency")) {
                String[] Frequency = {"Annual", "Daily", "Every 5 Years", "Monthly", "Quarterly", "Semi-Annual", "Weekly", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, Frequency);
                listRelation.setAdapter(rd);
            } else if (category.equalsIgnoreCase("Blood")) {
                String[] BloodList = {"A - negative", "A - positive", "AB - negative", "AB - positive", "B - negative", "B - positive", "O - negative", "O - positive", "I don't know"};
                RelationsAdapter rd = new RelationsAdapter(context, BloodList);
                listRelation.setAdapter(rd);
            }
            else if (category.equalsIgnoreCase("Relationp")) {
                String[] Relationships = {"Aunt", "Brother", "Brother-in-law", "Client", "Cousin", "Dad", "Daughter", "Father-in-law", "Friend", "GrandDaughter", "GrandMother", "GrandFather", "GrandSon", "Husband", "Mom", "Mother-in-law", "Neighbor", "Nephew", "Niece", "Patient", "Roommate", "Significant Other", "Sister", "Sister-in-law", "Son", "Uncle", "Wife", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, Relationships);
                listRelation.setAdapter(rd);
            }
            else if (category.equalsIgnoreCase("Marital")) {
                String[] MaritalList = {"Divorced", "Domestic Partner", "Married", "Separated", "Single", "Widowed"};
                RelationsAdapter rd = new RelationsAdapter(context, MaritalList);
                listRelation.setAdapter(rd);
            }
            else if (category.equalsIgnoreCase("language")) {
                String[] LangList = {"Arabic", "Chinese", "English", "French", "German", "Greek", "Hebrew", "Hindi", "Italian", "Japanese", "Korean", "Russian", "Spanish", "Other"};
                RelationsAdapter rd = new RelationsAdapter(context, LangList);
                listRelation.setAdapter(rd);
            }
            else if (category.equalsIgnoreCase("eyes")) {
                String[] EyesList = {"Blue", "Green", "Hazel", "Brown"};
                RelationsAdapter rd = new RelationsAdapter(context, EyesList);
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
                } else if (category.equalsIgnoreCase("finance")) {
                    i.putExtra("Category", txtRel.getText().toString());
                    setResult(RESULT_FINANCECAT, i);
                } else if (category.equalsIgnoreCase("Insurance")) {
                    i.putExtra("Category", txtRel.getText().toString());
                    setResult(RESULT_INSURANCE, i);
                } else if (category.equalsIgnoreCase("Advance")) {
                    i.putExtra("Category", txtRel.getText().toString());
                    setResult(RESULT_ADVANCE, i);
                } else if (category.equalsIgnoreCase("Other")) {
                    i.putExtra("Category", txtRel.getText().toString());
                    setResult(RESULT_OTHER, i);
                } else if (category.equalsIgnoreCase("TypeFrequency")) {
                    i.putExtra("Category", txtRel.getText().toString());
                    setResult(RESULT_FREQUENCY, i);
                } else if (category.equalsIgnoreCase("Blood")) {
                    i.putExtra("Blood", txtRel.getText().toString());
                    setResult(RESULT_BLOOD, i);
                }
                else if (category.equalsIgnoreCase("Relationp")) {
                    String rel=txtRel.getText().toString();
                    i.putExtra("Category", rel);
                    setResult(REQUEST_RELATIONP, i);
                }
                else if (category.equalsIgnoreCase("Marital")) {
                    i.putExtra("Category", txtRel.getText().toString());
                    setResult(REQUEST_MARITAL, i);
                }
                else if (category.equalsIgnoreCase("language")) {
                    i.putExtra("Category", txtRel.getText().toString());
                    setResult(REQUEST_LANGUAGE, i);
                }
                else if (category.equalsIgnoreCase("eyes")) {
                    i.putExtra("Category", txtRel.getText().toString());
                    setResult(REQUEST_EYES, i);
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
