package com.mindyourlovedone.healthcare.DashBoard;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.database.DBHelper;
import com.mindyourlovedone.healthcare.database.PetQuery;
import com.mindyourlovedone.healthcare.model.Pet;
import com.mindyourlovedone.healthcare.utility.PrefConstants;
import com.mindyourlovedone.healthcare.utility.Preferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddPetActivity extends AppCompatActivity {
    public static final int REQUEST_PET = 400;
    Context context = this;
    TextView txtTitle, txtAdd,txtSave;
    TextView txtDelete;
    TextView txtName, txtBreed, txtColor, txtChip, txtVeterian, txtCare, txtPetBirthDate, txtPetNotes;
    String name = "", breed = "", color = "", veterain = "", care = "", chip = "", bdate = "", notes = "",veterain_add="",veterain_ph="",care_add="",care_ph="";
    ImageView imgBack, imgDone,imgHome;
    boolean isUpdate = false;
    RelativeLayout llAddConn;
    Preferences preferences;
    DBHelper dbHelper;
    Pet p;
    Pet pet;
   TextView txtVeteranAd,txtVeteranPh,txtCareAd,txtCarePh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);
        initUi();
        initListener();
    }

    private void initListener() {

    }

    private void initUi() {
        preferences = new Preferences(context);
        dbHelper = new DBHelper(context, preferences.getString(PrefConstants.CONNECTED_USERDB));
        PetQuery a = new PetQuery(context, dbHelper);
        txtDelete=findViewById(R.id.txtDelete);
        imgBack = findViewById(R.id.imgBack);
        imgHome=findViewById(R.id.imgHome);
        imgDone = findViewById(R.id.imgDone);
        llAddConn = findViewById(R.id.llAddConn);
        txtSave = findViewById(R.id.txtSave);
        txtTitle = findViewById(R.id.txtTitle);
        txtAdd = findViewById(R.id.txtAdd);
        txtName = findViewById(R.id.txtName);
        txtBreed = findViewById(R.id.txtBreed);
        txtColor = findViewById(R.id.txtColor);
        txtChip = findViewById(R.id.txtChip);
        txtVeterian = findViewById(R.id.txtVeteran);
        txtVeteranAd = findViewById(R.id.txtVeteranAd);
        txtVeteranPh = findViewById(R.id.txtVeteranPh);
        txtCare = findViewById(R.id.txtCare);
        txtCareAd = findViewById(R.id.txtCareAd);
        txtCarePh = findViewById(R.id.txtCarePh);
        txtPetBirthDate = findViewById(R.id.txtPetBirthDate);
        txtPetNotes = findViewById(R.id.txtPetNote);

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(context, BaseActivity.class);
                intentHome.putExtra("c", 1);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentHome);
            }
        });


        Intent i = getIntent();
        if (i.getExtras() != null) {
            if (i.getExtras().get("FROM").equals("Update")) {
                isUpdate = true;
                txtDelete.setVisibility(View.VISIBLE);
                txtAdd.setText("Update Pet");
                txtTitle.setText("Update Pet");
                p = (Pet) i.getExtras().getSerializable("PetObject");
                pet = p;
                if (p.getName() != null) {
                    txtName.setText(p.getName());
                }
                if (p.getBreed() != null) {
                    txtBreed.setText(p.getBreed());
                }
                if (p.getColor() != null) {
                    txtColor.setText(p.getColor());
                }
                if (p.getVeterian() != null) {
                    txtVeterian.setText(p.getVeterian());
                }
                if (p.getVeterian_add() != null) {
                    txtVeteranAd.setText(p.getVeterian());
                }
                if (p.getVeterian_ph() != null) {
                    txtVeteranPh.setText(p.getVeterian());
                }
                if (p.getChip() != null) {
                    txtChip.setText(p.getChip());
                }
                if (p.getGuard() != null) {
                    txtCare.setText(p.getGuard());
                }
                if (p.getCare_add() != null) {
                    txtCareAd.setText(p.getGuard());
                }
                if (p.getCare_ph() != null) {
                    txtCarePh.setText(p.getGuard());
                }
                if (p.getBdate() != null) {
                    txtPetBirthDate.setText(p.getBdate());
                }
                if (p.getNotes() != null) {
                    txtPetNotes.setText(p.getNotes());
                }
            } else {
                isUpdate = false;
                txtDelete.setVisibility(View.GONE);
                txtAdd.setText("Add Pet");
                txtTitle.setText("Add Pet");
            }

        }
txtDelete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        boolean flag = PetQuery.deleteRecord(p.getId());
        if (flag == true) {
            Toast.makeText(context, "Deleted Pet Record", Toast.LENGTH_SHORT).show();
           // setPetData();
          //  ListPet.requestFocus();
            finish();
        }
    }
});
  txtPetBirthDate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          final Calendar calendar = Calendar.getInstance();
          int year = calendar.get(Calendar.YEAR);
          int month = calendar.get(Calendar.MONTH);
          int day = calendar.get(Calendar.DAY_OF_MONTH);
          DatePickerDialog dpd = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
              @Override
              public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                  Calendar newDate = Calendar.getInstance();
                  newDate.set(year, month, dayOfMonth);
                  long selectedMilli = newDate.getTimeInMillis();

                  Date datePickerDate = new Date(selectedMilli);
                  String reportDate = new SimpleDateFormat("d-MMM-yyyy").format(datePickerDate);

                  DateClass d = new DateClass();
                  d.setDate(reportDate);
                  if (datePickerDate.after(calendar.getTime())) {
                      Toast.makeText(context, "Birthdate should be greater than today's date", Toast.LENGTH_SHORT).show();
                  } else {
                      txtPetBirthDate.setText(reportDate);
                  }
              }
          }, year, month, day);
          dpd.show();
      }
  });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtName.getText().toString();
                breed = txtBreed.getText().toString();
                color = txtColor.getText().toString();
                chip = txtChip.getText().toString();
                veterain = txtVeterian.getText().toString();
                veterain_add = txtVeteranAd.getText().toString();
                veterain_ph = txtVeteranPh.getText().toString();
                care = txtCare.getText().toString();
                care_add = txtCareAd.getText().toString();
                care_ph = txtCarePh.getText().toString();
                bdate = txtPetBirthDate.getText().toString();
                notes = txtPetNotes.getText().toString();
                if (isUpdate == false) {
                    Boolean flag = PetQuery.insertPetData(preferences.getInt(PrefConstants.CONNECTED_USERID), name, breed, color, chip, veterain, care, bdate, notes,veterain_add,veterain_ph,care_add,care_ph);
                    if (flag == true) {
                        Toast.makeText(context, "Pet Added Succesfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }
                } else if (isUpdate == true) {
                    Boolean flag = PetQuery.updatePetData(pet.getId(), name, breed, color, chip, veterain, care, bdate, notes,veterain_add,veterain_ph,care_add,care_ph);
                    if (flag == true) {
                        Toast.makeText(context, "Pet updated Succesfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }

                }

                Intent intentAllergy = new Intent();
                           /* intentAllergy.putExtra("Value", value);
                            intentAllergy.putExtra("Reaction", reaction);
                            intentAllergy.putExtra("Treatment", treatment);*/
                setResult(AddInfoActivity.RESULT_ALLERGY, intentAllergy);
                finish();

            }
        });
    }
}
