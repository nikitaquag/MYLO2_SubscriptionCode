package com.mindyourlovedone.healthcare.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.DashBoard.AddPrescriptionActivity;
import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.database.DBHelper;
import com.mindyourlovedone.healthcare.database.DosageQuery;
import com.mindyourlovedone.healthcare.database.PrescribeImageQuery;
import com.mindyourlovedone.healthcare.database.PrescriptionQuery;
import com.mindyourlovedone.healthcare.database.VitalQuery;
import com.mindyourlovedone.healthcare.model.Prescription;
import com.mindyourlovedone.healthcare.model.VitalSigns;
import com.mindyourlovedone.healthcare.utility.DialogManager;
import com.mindyourlovedone.healthcare.utility.PrefConstants;
import com.mindyourlovedone.healthcare.utility.Preferences;

public class AddVitalSignsActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout tilLocation;
    TextView txtTitle, txtLocation, txtDate, txtTime, txtBP, txtHeart, txtTemperature, txtPulseRate, txtRespRate, txtNote, txtSave;
    ImageView imgHome, imgBack;
    Context context = this;
    boolean isEdit, isView;
    String location = "", Date = "", time = "", bp = "", heart = "", temperature = "", pulse = "", respiratory = "", note = "";
    Preferences preferences;
    DBHelper dbHelper;
    int id, colid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vital_signs);
        initComponent();
        initUi();
        initListener();
    }

    private void initComponent() {
        preferences = new Preferences(context);
        dbHelper = new DBHelper(context, preferences.getString(PrefConstants.CONNECTED_USERDB));
        VitalQuery p = new VitalQuery(context, dbHelper);
    }

    private void initListener() {
        imgHome.setOnClickListener(this);
        imgBack.setOnClickListener(this);
        txtSave.setOnClickListener(this);
    }

    private void initUi() {
        imgBack = findViewById(R.id.imgBack);
        imgHome = findViewById(R.id.imgHome);
        tilLocation = findViewById(R.id.tilLocation);
        txtLocation = findViewById(R.id.txtLocation);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);
        txtBP = findViewById(R.id.txtBP);
        txtHeart = findViewById(R.id.txtHeart);
        txtTemperature = findViewById(R.id.txtTemperature);
        txtPulseRate = findViewById(R.id.txtPulseRate);
        txtRespRate = findViewById(R.id.txtRespRate);
        txtNote = findViewById(R.id.txtNote);

        txtSave = findViewById(R.id.txtSave);
        txtTitle = findViewById(R.id.txtTitle);

        tilLocation.setHintEnabled(false);
        txtLocation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tilLocation.setHintEnabled(true);
                txtLocation.setFocusable(true);

                return false;
            }
        });


        Intent i = getIntent();
        if (i.getExtras() != null) {

            VitalSigns p = (VitalSigns) i.getExtras().getSerializable("VitalObject");

            isView = i.getExtras().getBoolean("IsView");//Shradha
            if (isView == true)//Shradha
            {
                //Shradha
                txtTitle.setText("View Vital Signs");//Shradha
                txtSave.setVisibility(View.GONE);//Shradha

                colid = p.getId();//Shradha
                txtLocation.setText(p.getLocation());//Shradha
                txtDate.setText(p.getDate());//Shradha
                txtTime.setText(p.getTime());//Shradha
                txtBP.setText(p.getBp());//Shradha
                txtHeart.setText(p.getHeartRate());//Shradha
                txtTemperature.setText(p.getTemperature());//Shradha
                txtPulseRate.setText(p.getPulseRate());//Shradha
                txtRespRate.setText(p.getRespRate());//Shradha
                txtNote.setText(p.getNote());//Shradha
            }/*else {
                Toast.makeText(context, "Done changes in Prescription for View", Toast.LENGTH_SHORT).show();
            }*/


            isEdit = i.getExtras().getBoolean("IsEdit");
            if (isEdit == true) {
                txtTitle.setText("Update Vital Signs");

                txtSave.setVisibility(View.VISIBLE);//Shradha

                colid = p.getId();//Shradha
                txtLocation.setText(p.getLocation());//Shradha
                txtDate.setText(p.getDate());//Shradha
                txtTime.setText(p.getTime());//Shradha
                txtBP.setText(p.getBp());//Shradha
                txtHeart.setText(p.getHeartRate());//Shradha
                txtTemperature.setText(p.getTemperature());//Shradha
                txtPulseRate.setText(p.getPulseRate());//Shradha
                txtRespRate.setText(p.getRespRate());//Shradha
                txtNote.setText(p.getNote());//Shradha
            } /*else {
                txtTitle.setText("Add Prescription");
            }*/
        }


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
            case R.id.txtSave:
                location = txtLocation.getText().toString().trim();
                Date = txtDate.getText().toString().trim();
                time = txtTime.getText().toString().trim();
                bp = txtBP.getText().toString().trim();
                heart = txtHeart.getText().toString().trim();
                temperature = txtTemperature.getText().toString().trim();
                pulse = txtPulseRate.getText().toString().trim();
                respiratory = txtRespRate.getText().toString().trim();
                note = txtNote.getText().toString().trim();
                if (location.equals("")) {
                    Toast.makeText(context, "Please Enter Location", Toast.LENGTH_SHORT).show();
                    txtLocation.setError("Please Enter Location");
                } else {
                    if (isEdit == false) {

                        Boolean flag = VitalQuery.insertVitalData(preferences.getInt(PrefConstants.CONNECTED_USERID), location, Date, time, bp, heart, temperature, pulse, respiratory, note);
                        if (flag == true) {
                            Toast.makeText(context, "Vital Signs Added Succesfully", Toast.LENGTH_SHORT).show();
                            DialogManager.closeKeyboard(AddVitalSignsActivity.this);
                        } else {
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Boolean flag = VitalQuery.updateVitalData(colid, location, Date, time, bp, heart, temperature, pulse, respiratory, note);
                        if (flag == true) {
                            Toast.makeText(context, "Vital Signs Updated Succesfully", Toast.LENGTH_SHORT).show();
                            DialogManager.closeKeyboard(AddVitalSignsActivity.this);
                        } else {
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
        }


    }
}

