package com.mindyourlovedone.healthcare.DashBoard;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.Activity.RelationshipActivity;
import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.customview.MySpinner;
import com.mindyourlovedone.healthcare.database.AppointmentQuery;
import com.mindyourlovedone.healthcare.database.DBHelper;
import com.mindyourlovedone.healthcare.database.DateQuery;
import com.mindyourlovedone.healthcare.model.Appoint;
import com.mindyourlovedone.healthcare.model.TypeSpecialist;
import com.mindyourlovedone.healthcare.utility.DialogManager;
import com.mindyourlovedone.healthcare.utility.PrefConstants;
import com.mindyourlovedone.healthcare.utility.Preferences;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;


public class AddAppointmentActivity extends AppCompatActivity implements View.OnClickListener {
    Context context = this;
    TextView txtName, txtNote, txtDate, txtOtherSpecialist, txtOtherFrequency, txtAdd, txtSave;
    Preferences preferences;
    MySpinner spinnerType, spinnerFrequency;
    DBHelper dbHelper;
    ArrayList<DateClass> dateList = null;
    ImageView imgBack, imgHome;
    RelativeLayout llAddConn, rlDelete;
    TextInputLayout tilName, tilOtherFrequency, tilOtherSpecialist;
    RadioGroup rgCompleted;
    RadioButton rbYes, rbNo;
    String otherFrequency = "";
    String otherType = "";
    String status = "No";
    boolean isUpdate = false;
    Appoint p;
    private static int RESULT_TYPE = 10;


    //    String[] Type = {"CT Scan", "Colonoscopy", "Glucose Test", "Hypothyroid Blood test", "Mammogram", "Thyroid Scan", "Other", "",
//            "Acupunture", "Allergy & Immunology", "Anesthesiology", "Audiology", "Cardiology", "Chiropractor", "Cosmetic and Laser Surgeon ", "Critical Care Medicine ", "Dentist ", "Dermatology", "Diabetes & Metabolism", "Emergency Medicine", "Endocrinology", "Endodontics", "Endovascular Medicine", "Family Medicine", "Foot and Ankle Surgeon", "Gastroenterology", "Geriatric Medicine", "Gynecology", "Hospice & Palliative Medicine	", "Infectious Disease", "Internal Medicine", "Internist", "Massage Therapy", "Medical Genetics", "Nephrology", "Neurology", "Obstetrics & Gynecology", "Oncology ", "Ophthalmology", "Optometrist", "Orthodontics", "Orthopadeic ", "Orthopadeic Surgeon", "Otolaryngology", "Pain Medicine", "Pathology", "Pediatrics", "Periodontics", "Physical Therapist", "Plastic & Reconstructive Surgeon", "Podiatrist ", "Psychiatry", "Pulmonology", "Radiology", "Rheumatology", "Speech Therapist", "Sports Medicine", "Surgeon - General ", "Thoracic & Cardiac Surgeon", "Urology", "Vascular Medicine", "Other"
//    };
    String[] Type3 = {"", "Type of Test", "Blood Work", "Colonsocopy", "CT Scan", "Echocardiogram", "EKG", "Glucose Test"};

    String[] Type1 = {"Hyperthyroid Blood Test", "Hypothyroid Blood Test", "Mammogram", "MRI", "Prostate Specific Antigen (PSA)", "Sonogram", "Thyroid Scan", "",

    };
    String[] Type2 = {"Specialist",
            "Acupuncturist", "Allergist (Immunologist)", "Anesthesiologist", "Audiologist", "Cardiologist", "Cardiothoracic Surgeon", "Chiropractor", "Colorectal Surgeon", "Cosmetic Surgeon", "Critical Care Medicine", "Dentist", "Dermatologist", "Dietitian/Nutritionist", "Diabetes & Metabolism", "Ear, Nose & Throat Doctor (ENT, Otolaryngologist)", "Emergency Medicine", "Endocrinologist (incl. Diabetes Specialists)", "Endodontics", "Endovascular Medicine", "Eye Doctor", "Family Medicine", "Gastroenterologist", "Geriatrician", "Gynecologist", "Hearing Specialist", "Hematologist (Blood Specialist)", "Hospice", "Infectious Disease Specialist", "Infertility Specialist", "Internal Medicine", "Midwife", "Naturopathic Doctor", "Nephrologist (Kidney Specialist)", "Neurologist (Inc. Headache Specialist)", "Neurosurgeon", "OB-GYN (Obstetrician-Gynecologist)", "Occupational Therapist", "Oncologist", "Ophthalmologist", "Optometrist", "Oral Surgeon", "Orthodontist", "Orthopedic Surgeon (Orthopedist)", "Osteopath", "Otolaryngologist", "Pain Management Specialist", "Palliative Care Specialist", "Pediatric Dentist", "Pediatrician", "Periodontist", "Physician Assistant", "Physiatrist (Physical Medicine)", "Physical Therapist", "Plastic & Reconstructive Surgeon", "Podiatrist (Foot and Ankle Specialist)", "Primary Care Doctor (PCP)", "Prosthodontist", "Psychiatrist", "Psychologist", "Psychotherapist", "Pulmonologist (Lung Doctor)", "Radiologist", "Rheumatologist", "Sleep Medicine Specialist", "Speech Therapist", "Sports Medicine Specialist", "Surgeon - General", "Therapist / Counselor", "Thoracic & Cardiac Surgery", "Urgent Care Specialist", "Urological Surgeon", "Urologist", "Vascular Surgeon", "Other"
    };

    String[] Frequency = {"Annual", "Daily", "Every 5 Years", "Monthly", "Quarterly", "Semi-Annual", "Weekly", "Other"};

    private ArrayList<TypeSpecialist> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        initComponent();
        initUi();
        initListener();

    }

    private void initComponent() {
        preferences = new Preferences(context);
        dbHelper = new DBHelper(context, preferences.getString(PrefConstants.CONNECTED_USERDB));
        AppointmentQuery a = new AppointmentQuery(context, dbHelper);
        DateQuery d = new DateQuery(context, dbHelper);
    }

    private void initListener() {

        rlDelete.setOnClickListener(this);
        imgBack.setOnClickListener(this);
        imgHome.setOnClickListener(this);
        llAddConn.setOnClickListener(this);
        txtSave.setOnClickListener(this);
        txtDate.setOnClickListener(this);
        txtNote.setOnClickListener(this);

    }

    private void initUi() {
        txtSave = findViewById(R.id.txtSave);
        txtName = findViewById(R.id.txtName);
        tilName = findViewById(R.id.tilName);
        txtDate = findViewById(R.id.txtDate);
        txtNote = findViewById(R.id.txtNote);
        txtOtherFrequency = findViewById(R.id.txtOtherFrequency);
        txtOtherSpecialist = findViewById(R.id.txtOtherType);
        tilOtherFrequency = findViewById(R.id.tilOtherFrequency);
        tilOtherSpecialist = findViewById(R.id.tilOtherType);
        tilOtherSpecialist.setHint("Other Specialist or Test");
        spinnerType = findViewById(R.id.spinnerType);
        spinnerFrequency = findViewById(R.id.spinnerFrequency);
        imgBack = findViewById(R.id.imgBack);
        rlDelete = findViewById(R.id.rlDelete);
        imgHome = findViewById(R.id.imgHome);
        llAddConn = findViewById(R.id.llAddConn);
        txtAdd = findViewById(R.id.txtAdd);

        rgCompleted = findViewById(R.id.rgCompleted);
        rbYes = findViewById(R.id.rbYes);
        rbNo = findViewById(R.id.rbNo);

//        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, Type);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerType.setAdapter(adapter);

        items = new ArrayList<TypeSpecialist>();


        //shradha
        for (int i = 0; i < Type3.length; i++) {

            TypeSpecialist ts = new TypeSpecialist();
            ts.setType(Type3[i]);
            if (i == 1) {
                ts.setDiff(99);
            } else {
                ts.setDiff(0);
            }
            items.add(ts);
        }

        for (int i = 0; i < Type1.length; i++) {
            TypeSpecialist ts = new TypeSpecialist();
            ts.setType(Type1[i]);
            ts.setDiff(0);
            items.add(ts);
        }


        for (int i = 0; i < Type2.length; i++) {
//            spinnerType.setPrompt("Specialist");//shradha
            TypeSpecialist ts = new TypeSpecialist();
            //    ts.setHint("Specialist"+"\n");
            ts.setType(Type2[i]);
            ts.setDiff(1);
            if (i == 0) {
                ts.setDiff(99);
            } else {
                ts.setDiff(1);
            }
            items.add(ts);
        }


        CustomTypeSpecialistAdapters adapter = new CustomTypeSpecialistAdapters(context, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerType.setAdapter(adapter);
        spinnerType.setHint("Type of Test or Specialist");



/*
//shradha
        final ArrayAdapter<TypeSpecialist> cityAdapter = new ArrayAdapter<TypeSpecialist>(getContext(), android.R.layout.simple_spinner_item, typeList) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = null;

                // If this is the initial dummy entry, make it hidden
                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    v = tv;
                } else {
                    // Pass convertView as null to prevent reuse of special case views
                    v = super.getDropDownView(position, null, parent);
                }

                // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                //parent.setVerticalScrollBarEnabled(false);
                return v;
            }
        };
*/

        ArrayAdapter adapter1 = new ArrayAdapter(context, android.R.layout.simple_spinner_item, Frequency);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrequency.setAdapter(adapter1);
        spinnerFrequency.setHint("Frequency");

        spinnerFrequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("Other")) {
                    tilOtherFrequency.setVisibility(View.VISIBLE);
                } else {
                    tilOtherFrequency.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (items != null && !items.isEmpty() && position != -1) {
                    if (items.get(position).getType().toString().equals("Specialist") || items.get(position).getType().toString().equals("Type of Test")) {
                        spinnerType.setSelection(0);
                    } else {
                        if (items.get(position).getType().toString().equals("Other")) {
                            tilOtherSpecialist.setVisibility(View.VISIBLE);
                        } else {
                            tilOtherSpecialist.setVisibility(View.GONE);
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /*txtName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tilName.setHintEnabled(true);
                txtName.setFocusable(true);
                return false;
            }
        });*/

        rgCompleted.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.rbYes) {
                    txtDate.setVisibility(View.VISIBLE);
                    status = "Yes";
                } else if (checkedId == R.id.rbNo) {
                    txtDate.setVisibility(View.GONE);
                    status = "No";
                }
            }
        });

        Intent i = getIntent();
        if (i.getExtras() != null) {
            if (i.getExtras().get("FROM").equals("View")) {
                rlDelete.setVisibility(View.VISIBLE);
                txtAdd.setText("Update Appointment");
                isUpdate = true;
                Appoint a = (Appoint) i.getExtras().getSerializable("AppointObject");
                p = (Appoint) i.getExtras().getSerializable("AppointObject");
                if (a.getDoctor() != null) {
                    txtName.setText(a.getDoctor());
                }
                if (a.getNote() != null) {
                    txtNote.setText(a.getNote());
                }
                if (a.getFrequency() != null) {
                    int index = 0;
                    for (int j = 0; j < Frequency.length; j++) {
                        if (a.getFrequency().equals(Frequency[j])) {
                            index = j;
                        }
                    }
                    spinnerFrequency.setSelection(index + 1);
                }
                if (a.getFrequency().equals("Other")) {
                    txtOtherFrequency.setText(a.getOtherFrequency());
                }
                if (a.getType().equals("Other")) {
                    txtOtherSpecialist.setText(a.getOtherDoctor());
                }
                if (a.getType() != null) {
                    int index = 0;
                    for (int j = 0; j < items.size(); j++) {
                        if (a.getType().equals(items.get(j).getType())) {
                            index = j;
                        }
                    }
                    spinnerType.setSelection(index + 1);
                }
            } else if (i.getExtras().get("FROM").equals("Add")) {
                txtAdd.setText("Add Appointment");
                isUpdate = false;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /* else if (requestCode == RESULT_RELATION && data != null) {
            relation = data.getStringExtra("Relation");
            txtRelation.setText(relation);
            if (relation.equals("Other")) {
                tilOtherRelation.setVisibility(View.VISIBLE);
                txtOtherRelation.setVisibility(View.VISIBLE);
            } else {
                tilOtherRelation.setVisibility(View.GONE);
                txtOtherRelation.setVisibility(View.GONE);
            }*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                hideSoftKeyboard();
                finish();
                break;
            //Shradha
            case R.id.rlDelete:
                deleteAppointment(p);
                break;

            case R.id.imgHome:
                Intent intentHome = new Intent(context, BaseActivity.class);
                intentHome.putExtra("c", 1);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentHome);
                break;

            case R.id.txtDate:
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                dpd.show();
                break;
            case R.id.txtNote:
                Intent intentType = new Intent(context, RelationshipActivity.class);
                intentType.putExtra("Category", "TypeAppointment");
                intentType.putExtra("Category", "TypeSpecialist");
                startActivity(intentType);
                break;
            case R.id.txtSave:
                hideSoftKeyboard();
                int unique = generateRandom();
                String name = txtName.getText().toString().trim();
                String date = txtDate.getText().toString().trim();
                String note = txtNote.getText().toString().trim();
                otherType = txtOtherSpecialist.getText().toString();
                otherFrequency = txtOtherFrequency.getText().toString();
                int indexValuex = spinnerType.getSelectedItemPosition();

                String type = "";
                String frequency = "";
                if (indexValuex != 0) {
                    type = items.get(indexValuex - 1).getType();
                }

                int indexValue = spinnerFrequency.getSelectedItemPosition();
                if (indexValue != 0) {
                    frequency = Frequency[indexValue - 1];
                }

                if (type.equals("")) {
                    spinnerType.setError("Please Select Specialist or Test");
                    DialogManager.showAlert("Please Select Specialist or Test", AddAppointmentActivity.this);
                } else {
                    if (isUpdate == false) {
                        Boolean flag = AppointmentQuery.insertAppointmentData(preferences.getInt(PrefConstants.CONNECTED_USERID), name, date, note, type, frequency, otherType, otherFrequency, dateList, unique);
                        if (flag == true) {
                            hideSoftKeyboard();
                            Toast.makeText(context, "Appointment added succesfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else if (isUpdate == true) {
                        Boolean flag = AppointmentQuery.updateAppointmentData(p.getId(), name, date, note, type, frequency, otherType, otherFrequency, dateList, p.getUnique());
                        if (flag == true) {
                            hideSoftKeyboard();
                            Toast.makeText(context, "Appointment updated succesfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                /* Appoint appoint=new Appoint();
                appoint.setDoctor(name);
                appoint.setDate(date);
                appoint.setFrequency(frequency);
                appoint.setType(type);
                Intent i=new Intent();
                i.putExtra("AppointObject",appoint);

                setResult(100,i);*/
                break;
        }
    }

    //Shradha
    private void deleteAppointment(final Appoint p) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Delete");
        alert.setMessage("Do you want to Delete this record?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean flag = AppointmentQuery.deleteRecord(p.getUnique());
                if (flag == true) {
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();

                    if (context instanceof MedicalAppointActivity) {
                        ((MedicalAppointActivity) context).getData();
                        ((MedicalAppointActivity) context).setNoteData();
                    }
                }
                dialog.dismiss();
                finish();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        alert.show();
    }

    private int generateRandom() {
        Random r = new Random();
        int randomNumber = r.nextInt(500);

        return randomNumber;
    }

    public void hideSoftKeyboard() {
        InputMethodManager inm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}
