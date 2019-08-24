package com.mindyourlovedone.healthcare.HomeActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.database.DBHelper;
import com.mindyourlovedone.healthcare.database.MyConnectionsQuery;
import com.mindyourlovedone.healthcare.database.PersonalInfoQuery;
import com.mindyourlovedone.healthcare.database.SubscriptionQuery;
import com.mindyourlovedone.healthcare.model.RelativeConnection;
import com.mindyourlovedone.healthcare.model.SubscrptionData;
import com.mindyourlovedone.healthcare.util.IabHelper;
import com.mindyourlovedone.healthcare.util.IabResult;
import com.mindyourlovedone.healthcare.util.Inventory;
import com.mindyourlovedone.healthcare.util.Purchase;
import com.mindyourlovedone.healthcare.utility.DialogManager;
import com.mindyourlovedone.healthcare.utility.NetworkUtils;
import com.mindyourlovedone.healthcare.utility.PrefConstants;
import com.mindyourlovedone.healthcare.utility.Preferences;
import com.mindyourlovedone.healthcare.webservice.WebService;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ImpAgreementActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack, checkedIcon1, uncheckedIcon1, checkedIcon2, uncheckedIcon2, checkedIcon3, uncheckedIcon3, checkedIcon4, uncheckedIcon4, checkedIcon5, uncheckedIcon5;
    TextView txtSignup;
    Context context = this;
    String name = "", email = "";
    int userid;
    private static final int REQUEST_CALL_PERMISSION = 100;
    Preferences preferences;
    DBHelper dbHelper;

    boolean ck = false, ck2 = false, ck3 = false, Ck4 = false, Ck5 = false;
    String has_card = "NO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_agreement);
        initUi();
        Intent i = getIntent();
        name = i.getStringExtra("Name");
        email = i.getStringExtra("Email");
        userid = i.getIntExtra("userid", 0);
        preferences = new Preferences(context);
        dbHelper = new DBHelper(context, "MASTER");
        // PersonalInfoQuery s=new PersonalInfoQuery(context,dbHelper);
        MyConnectionsQuery m = new MyConnectionsQuery(context, dbHelper);
        //   initComponent();
        initListener();
    }

    private void initComponent() {

        try {
            File f = new File(Environment.getExternalStorageDirectory(), "/MYLO/MASTER/");
            if (!f.exists()) {
                f.mkdirs();
            } else {
                try {
                    File file = new File(Environment.getExternalStorageDirectory(), "/MYLO/");
                    FileUtils.deleteDirectory(file);
                    f.mkdirs();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        preferences = new Preferences(context);
        dbHelper = new DBHelper(context, "MASTER");
        // PersonalInfoQuery s=new PersonalInfoQuery(context,dbHelper);
        MyConnectionsQuery m = new MyConnectionsQuery(context, dbHelper);
    }

    private void initListener() {
        imgBack.setOnClickListener(this);
        txtSignup.setOnClickListener(this);

        checkedIcon1.setOnClickListener(this);
        uncheckedIcon1.setOnClickListener(this);

        checkedIcon2.setOnClickListener(this);
        uncheckedIcon2.setOnClickListener(this);

        checkedIcon3.setOnClickListener(this);
        uncheckedIcon3.setOnClickListener(this);

        checkedIcon4.setOnClickListener(this);
        uncheckedIcon4.setOnClickListener(this);

        checkedIcon5.setOnClickListener(this);
        uncheckedIcon5.setOnClickListener(this);

    }

    private void initUi() {
        imgBack = findViewById(R.id.imgBack);
        txtSignup = findViewById(R.id.txtSignup);
        checkedIcon1 = findViewById(R.id.checkedIcon1);
        uncheckedIcon1 = findViewById(R.id.uncheckedIcon1);

        checkedIcon2 = findViewById(R.id.checkedIcon2);
        uncheckedIcon2 = findViewById(R.id.uncheckedIcon2);
        checkedIcon3 = findViewById(R.id.checkedIcon3);
        uncheckedIcon3 = findViewById(R.id.uncheckedIcon3);
        checkedIcon4 = findViewById(R.id.checkedIcon4);
        uncheckedIcon4 = findViewById(R.id.uncheckedIcon4);
        checkedIcon5 = findViewById(R.id.checkedIcon5);
        uncheckedIcon5 = findViewById(R.id.uncheckedIcon5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;

            case R.id.txtSignup:
                //  if (validate()) {
                //CallWebservice get user profile


                if (validation()) {
//                       // preferences.putInt(PrefConstants.USER_ID, userid);
////                        Intent signupIntent = new Intent(context, BaseActivity.class);
////                        /*preferences.putString(PrefConstants.USER_EMAIL, email);
////                        preferences.putString(PrefConstants.USER_NAME, name);
////                        preferences.setREGISTERED(true);
////                        preferences.setLogin(true);
////                        if(getIntent().hasExtra("PDF_EXT")) {
////                            signupIntent.putExtra("PDF_EXT", getIntent().getStringExtra("PDF_EXT"));
////                        }*/
////                        startActivity(signupIntent);
////                        finish();
////                        //accessPermission();
                    inApp();//calling subscription here
                } else {
                     /*   Toast toast = Toast.makeText(context, Html.fromHtml("<big><b>Click to Accept</b></big>"), Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();*/
                }
                //  }
               /* Intent intentBase = new Intent(context, BaseActivity.class);
                startActivity(intentBase);*/
                break;


            case R.id.checkedIcon1:
                checkedIcon1.setVisibility(View.GONE);
                ck = false;
                uncheckedIcon1.setVisibility(View.VISIBLE);
                break;
            case R.id.uncheckedIcon1:
                uncheckedIcon1.setVisibility(View.GONE);
                ck = true;
                checkedIcon1.setVisibility(View.VISIBLE);
                break;

            case R.id.checkedIcon2:
                checkedIcon2.setVisibility(View.GONE);
                ck2 = false;
                uncheckedIcon2.setVisibility(View.VISIBLE);

                break;
            case R.id.uncheckedIcon2:
                uncheckedIcon2.setVisibility(View.GONE);
                ck2 = true;
                checkedIcon2.setVisibility(View.VISIBLE);
                break;

            case R.id.checkedIcon3:
                checkedIcon3.setVisibility(View.GONE);
                ck3 = false;
                uncheckedIcon3.setVisibility(View.VISIBLE);
                break;
            case R.id.uncheckedIcon3:
                uncheckedIcon3.setVisibility(View.GONE);
                ck3 = true;
                checkedIcon3.setVisibility(View.VISIBLE);
                break;

            case R.id.checkedIcon4:
                checkedIcon4.setVisibility(View.GONE);
                Ck4 = false;
                uncheckedIcon4.setVisibility(View.VISIBLE);
                break;
            case R.id.uncheckedIcon4:
                uncheckedIcon4.setVisibility(View.GONE);
                Ck4 = true;
                checkedIcon4.setVisibility(View.VISIBLE);
                break;

            case R.id.checkedIcon5:
                checkedIcon5.setVisibility(View.GONE);
                Ck5 = false;
                uncheckedIcon5.setVisibility(View.VISIBLE);
                break;
            case R.id.uncheckedIcon5:
                uncheckedIcon5.setVisibility(View.GONE);
                Ck5 = true;
                checkedIcon5.setVisibility(View.VISIBLE);
                break;

        }
    }

    private boolean validation() {
        boolean f = false;

        if (ck == true && ck2 == true && ck3 == true && Ck4 == true && Ck5 == true) {
            f = true;
        } else {
            Toast toast = Toast.makeText(context, Html.fromHtml("<big><b>Click to Accept</b></big>"), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        return f;
    }


    private void accessPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED
                ||
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                ||
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                ||
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_CONTACTS
            }, REQUEST_CALL_PERMISSION);

        } else {

            try {
                File f = new File(Environment.getExternalStorageDirectory(), "/MYLO/MASTER/");
                if (!f.exists()) {
                    f.mkdirs();
                } else {
                    try {
                        File file = new File(Environment.getExternalStorageDirectory(), "/MYLO/");
                        FileUtils.deleteDirectory(file);
                        f.mkdirs();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!NetworkUtils.getConnectivityStatusString(ImpAgreementActivity.this).equals("Not connected to Internet")) {
                CreateUserAsynk asynkTask = new CreateUserAsynk(name, email);
                asynkTask.execute();
            } else {
                DialogManager.showAlert("Network Error, Check your internet connection", ImpAgreementActivity.this);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CALL_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    if (!NetworkUtils.getConnectivityStatusString(ImpAgreementActivity.this).equals("Not connected to Internet")) {
                        CreateUserAsynk asynkTask = new CreateUserAsynk(name, email);
                        asynkTask.execute();
                    } else {
                        DialogManager.showAlert("Network Error, Check your internet connection", ImpAgreementActivity.this);
                    }
                    //  checkForRegistration();
                    try {
                        File f = new File(Environment.getExternalStorageDirectory(), "/MYLO/MASTER/");
                        if (!f.exists()) {
                            f.mkdirs();
                        } else {
                            try {
                                File file = new File(Environment.getExternalStorageDirectory(), "/MYLO/");
                                FileUtils.deleteDirectory(file);
                                f.mkdirs();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    accessPermission();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'switch' lines to check for other
            // permissions this app might request
        }
    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    class CreateUserAsynk extends AsyncTask<Void, Void, String> {
        String name;
        String email;
        ProgressDialog pd;

        private String deviceUdId = "";
        private String deviceType = "Android";

        public CreateUserAsynk(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        protected void onPreExecute() {
            deviceUdId = Settings.Secure.getString(getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            pd = ProgressDialog.show(context, "", "Please Wait..");
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            WebService webService = new WebService();
            Log.e("URL parameter", name + "" + "" + " " + email
                    + " " + "" + " " + deviceUdId + " " + deviceType);
            String result = webService.createProfile(name, "-",
                    "-", email, "-", deviceUdId, deviceType);
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            if (pd != null) {
                if (pd.isShowing()) {
                    pd.dismiss();
                }
            }

            if (!result.equals("")) {
                if (result.equals("Exception")) {
                    // ErrorDialog.errorDialog(context);
                    DialogManager.showAlert("Error", context);
                } else {
                    Log.e("CreateUserAsynk", result);
                    String errorCode = parseResponse(result);
                    if (errorCode.equals("0")) {
                        // DialogManager.showAlert("000", context);
                    } else {
                        //Toast.makeText(context, "Registration Failed, Try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
            super.onPostExecute(result);
        }

        private String parseResponse(String result) {
            Log.e("Response", result);
            JSONObject job = null;
            String errorCode = "";
            try {
                job = new JSONObject(result);
                JSONObject job1 = job.getJSONObject("response");
                errorCode = job1.getString("errorCode");
                String message = "";
                if (errorCode.equals("0")) {
                    message = job1.getString("respMsg");
                    JSONObject job2 = job1.getJSONObject("respData");
                    String userId = job2.getString("user_id");
                    Log.e("SuccessFullRegisterd", "UserId= " + userId);
                    int userid = Integer.parseInt(userId);
                    Toast.makeText(context, "" + message, Toast.LENGTH_LONG).show();

                    //After Success
                    Boolean flag = MyConnectionsQuery.insertMyConnectionsData(userid, name, email, "", "", "", "", "Self", "", "", 1, 2, "", "", has_card);

                    PersonalInfoQuery pi = new PersonalInfoQuery(context, dbHelper);
                    Boolean flagPersonalinfo = PersonalInfoQuery.insertPersonalInfoData(name, email, "", "", "", "", "", "", "", "", "");
                    if (flag == true) {
                        File file = new File(Environment.getExternalStorageDirectory(),
                                "/MYLO/");
                        String path = file.getAbsolutePath();
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        RelativeConnection connection = MyConnectionsQuery.fetchOneRecord("Self");
                        String mail = connection.getEmail();
                        mail = mail.replace(".", "_");
                        mail = mail.replace("@", "_");
                        DBHelper dbHelper = new DBHelper(context, mail);
                        MyConnectionsQuery m = new MyConnectionsQuery(context, dbHelper);
                        Boolean flags = MyConnectionsQuery.insertMyConnectionsData(connection.getId(), name, email, "", "", "", "", "Self", "", "", 1, 2, "", "", has_card);
                        if (flags == true) {
                            // Toast.makeText(context, "You have created db Successfully", Toast.LENGTH_SHORT).show();
                        }
                        //  Toast.makeText(context,"You have added profile Successfully",Toast.LENGTH_SHORT).show();
                        preferences.putInt(PrefConstants.USER_ID, userid);
                        Intent signupIntent = new Intent(context, BaseActivity.class);
                        preferences.putString(PrefConstants.USER_EMAIL, email);
                        preferences.putString(PrefConstants.USER_NAME, name);
                        preferences.setREGISTERED(true);
                        preferences.setLogin(true);
                        if (getIntent().hasExtra("PDF_EXT")) {
                            signupIntent.putExtra("PDF_EXT", getIntent().getStringExtra("PDF_EXT"));
                        }
                        startActivity(signupIntent);
                        finish();
                    } else {
                        Toast.makeText(context, "Error to save in database", Toast.LENGTH_SHORT).show();
                    }

                    return errorCode;
                } else {
                    message = job1.getString("errorMsg");
                    Toast.makeText(context, "" + message, Toast.LENGTH_LONG).show();
                    return errorCode;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return "Exception";
            }

        }

    }
   /* private boolean validate() {
        if (name.equals("")) {
            txtName.setError("Please Enter Name");
            DialogManager.showAlert("Please Enter Name", context);
        } else if (email.equals("")) {
            txtEmail.setError("Please Enter email");
            DialogManager.showAlert("Please Enter email", context);
        } else if (!email.trim().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            txtEmail.setError("Please enter valid email");
            DialogManager.showAlert("Please enter valid email", context);
        }else {
            return true;
//        }
        return false;
    }*/


    // Subscription code starts here - Nikita#Sub

    static final String TAG = "TrivialDrive";
    static final String SKU_INFINITE_GAS = "subscribe_app";   //$4.99
    static final int RC_REQUEST = 10001;
    boolean mSubscribedToInfiniteGas = false;
    IabHelper mHelper;

    void complain(String message) {
        Log.e(TAG, "Error: " + message);
        alert(message);
    }

    void alert(String message) {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setMessage(message);
        bld.setNeutralButton("OK", null);
        Log.d(TAG, "Showing alert dialog: " + message);
        bld.create().show();
    }

    /**
     * Verifies the developer payload of a purchase.
     */
    boolean verifyDeveloperPayload(Purchase p) {
        String payload = p.getDeveloperPayload();
        return true;
    }

    // Callback for when a purchase is finished
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            Log.d(TAG, "Purchase finished: " + result + ", purchase: " + purchase);

            // if we were disposed of in the meantime, quit.
            if (mHelper == null) return;

            if (result.isFailure()) {
                if (!result.getMessage().contains("canceled")) {
                    complain(result.getMessage());
                }

                return;
            }
            if (!verifyDeveloperPayload(purchase)) {
                complain("Error purchasing. Authenticity verification failed.");
                return;
            }

            Log.d(TAG, "Purchase successful.");
            if (purchase.getSku().equals(SKU_INFINITE_GAS)) {
                // bought the infinite gas subscription
                Log.d(TAG, "Mylo app subscription purchased.");
                alert("Thank you for subscribing to Mylo app!");
                mSubscribedToInfiniteGas = true;

                if (!NetworkUtils.getConnectivityStatusString(ImpAgreementActivity.this).equals("Not connected to Internet")) {
                    String startdate = toDateStr(purchase.getPurchaseTime());
                    String enddate = toDateEnd(purchase.getPurchaseTime() + DateUtils.YEAR_IN_MILLIS);
                    Toast.makeText(ImpAgreementActivity.this, "SUB_DATA\nTID : " + purchase.getToken() + "\nSdate : " + startdate + "\nEdate : " + enddate + "\nUID : " + userid, Toast.LENGTH_LONG).show();
                    ImpAgreementActivity.PostSubAsynk asynkTask = new ImpAgreementActivity.PostSubAsynk(userid + "", purchase.getToken(), startdate, enddate);
                    asynkTask.execute();
                } else {
                    DialogManager.showAlert("Network Error, Check your internet connection", ImpAgreementActivity.this);
                }

            } else {
                complain("Kindly subscribe.");
                onInfiniteGasButtonClicked();// re-prompt payment portal
            }
        }
    };

    public static String toDateStr(long milliseconds) {
        Date date = new Date(milliseconds);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return formatter.format(date);
    }

    public static String toDateEnd(long milliseconds) {
        Date date = new Date(milliseconds);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return formatter.format(date);
    }


    class PostSubAsynk extends AsyncTask<Void, Void, String> {
        String userid, transactionId, startDate, endDate;
        ProgressDialog pd;


        public PostSubAsynk(String userid, String transactionId, String startDate, String endDate) {
            this.userid = userid;
            this.transactionId = transactionId;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        @Override
        protected void onPreExecute() {
            pd = ProgressDialog.show(context, "", "Please Wait..");
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            WebService webService = new WebService();
            String result = webService.postSubscriptionData(userid, transactionId, startDate, endDate);
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            if (pd != null) {
                if (pd.isShowing()) {
                    pd.dismiss();
                }
            }

            if (!result.equals("")) {
                if (result.equals("Exception")) {
                    // ErrorDialog.errorDialog(context);
                    DialogManager.showAlert("Error", context);
                } else {
                    Log.e("CreateUserAsynk", result);
                    parseSubscriptionResponse(result);
                }
            }
            super.onPostExecute(result);
        }

        private void parseSubscriptionResponse(String result) {

            Log.e("Response", result);
            JSONObject job = null;
            String errorCode = "";
            try {
                job = new JSONObject(result);
                JSONObject jobB = job.optJSONObject("response");
                errorCode = jobB.optString("errorCode");
                String message = "";

                SubscrptionData sub = new SubscrptionData();
                sub.setSource("Android");
                sub.setEndDate(endDate);
                sub.setStartDate(startDate);
                sub.setTransactionID(transactionId);
                sub.setUserId(Integer.parseInt(userid));
                sub.setEmail(email);

                if (errorCode.equals("0")) {
                    message = jobB.optString("respMsg");
                    Toast.makeText(context, "" + message, Toast.LENGTH_LONG).show();
// Update upload flag in subcription table as 1
                    sub.setUpload(1);
                } else if (errorCode.equals("1")) {
                    message = jobB.optString("errorMsg");
                    Toast.makeText(context, "" + message, Toast.LENGTH_LONG).show();
                    sub.setUpload(0);
                } else {
                    sub.setUpload(0);
                    Toast.makeText(context, "Unexpected error from server.", Toast.LENGTH_LONG).show();
                }


                navigateToApp(sub);
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "Exception detected : " + (e.getCause()), Toast.LENGTH_LONG).show();
            }

        }

    }

    private void navigateToApp(SubscrptionData sub) {
        //Nikita#Sub
        //After Success
        SubscriptionQuery ss = new SubscriptionQuery(context, dbHelper);
        Boolean ssflag = SubscriptionQuery.insertSubscriptionData(userid, sub);

        Boolean flag = MyConnectionsQuery.insertMyConnectionsData(userid, name, email, "", "", "", "", "Self", "", "", 1, 2, "", "", has_card);

        PersonalInfoQuery pi = new PersonalInfoQuery(context, dbHelper);
        Boolean flagPersonalinfo = PersonalInfoQuery.insertPersonalInfoData(name, email, "", "", "", "", "", "", "", "", "");
        if (flag == true) {
            File file = new File(Environment.getExternalStorageDirectory(),
                    "/MYLO/");
            String path = file.getAbsolutePath();
            if (!file.exists()) {
                file.mkdirs();
            }
            RelativeConnection connection = MyConnectionsQuery.fetchOneRecord("Self");
            String mail = connection.getEmail();
            mail = mail.replace(".", "_");
            mail = mail.replace("@", "_");
            DBHelper dbHelper = new DBHelper(context, mail);
            MyConnectionsQuery m = new MyConnectionsQuery(context, dbHelper);
            Boolean flags = MyConnectionsQuery.insertMyConnectionsData(connection.getId(), name, email, "", "", "", "", "Self", "", "", 1, 2, "", "", has_card);
            if (flags == true) {
                // Toast.makeText(context, "You have created db Successfully", Toast.LENGTH_SHORT).show();
            }
            //  Toast.makeText(context,"You have added profile Successfully",Toast.LENGTH_SHORT).show();
            preferences.putInt(PrefConstants.USER_ID, userid);

            preferences.putString(PrefConstants.USER_EMAIL, email);
            preferences.putString(PrefConstants.USER_NAME, name);
            preferences.setREGISTERED(true);
            preferences.setLogin(true);
            Intent signupIntent = new Intent(context, BaseActivity.class);
            if (getIntent().hasExtra("PDF_EXT")) {
                signupIntent.putExtra("PDF_EXT", getIntent().getStringExtra("PDF_EXT"));
            }

            startActivity(signupIntent);
            finish();
        } else {
            Toast.makeText(context, "Error to save in database", Toast.LENGTH_SHORT).show();
        }

    }


    private void inApp() {
        String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq3i1ShkUzBAWxerhJne2R7KYwWVXyERXLxz7Co0kW9wS45C55XnM/kFHNZ0hI62Oz8HWbTO+RisBMQ5If21sHu5DgXLHa+LNYj+2ZPQWlh46jo/jhMgo+V9YJ7EeOLedH70fFRlhy9OT2ZmOWscxN5YJDp22RXvilale2WcoKVOriS+I9fNbeREDcKM4CsB0isJyDEVIagaRaa0Za8MleOVeYUdma5q3ENZDJ8g9W2Dy0h6fioCZ9OIgBCY63qr0jVxHUwD8Jebp91czKWRSRi433suBmSkoE6qkhwtDEdckeG+cx6xErHcoPSrwhaLlvqCC1KngYduRZy5j1jCAywIDAQAB"; //"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt/vQGFXEB+fQ7s5JbO/teKHjmvkZgqSeLSXmicYu4jDC5mBqfZ1/wBES/lhPGEfJAmjmSSQ1Z35XIcoTL74KVASTrUComknH4XiGaiXCjeCe9cFwYCXlWT+B3Y+dkRajRTi9G/iIgUZP6NTyblmKd5KcUn64CQIqgIZ8pD/4GsIR5abUFTEH9XXQEKzFjcdaBKB4uK1m2JLZ+w+FTFeNydzqSYdRL5lY4IHr8RHZwA3BReNMpzPt1Zp7URSkAGjXvbpOkURupUP+hB4VBYQYPfHfx3K4m32XKWl8zP0qwHS2kIIAjAEekzN+l+bDAU9fXdkDKuHIeXA0HLC6i9jRkQIDAQAB";

        // Some sanity checks to see if the developer (that's you!) really followed the
        // instructions to run this sample (don't put these checks on your app!)
        if (base64EncodedPublicKey.contains("CONSTRUCT_YOUR")) {
            throw new RuntimeException("Please put your app's public key in MainActivity.java. See README.");
        }
        if (getPackageName().startsWith("com.example")) {
            throw new RuntimeException("Please change the sample's package name! See README.");
        }

        // Create the helper, passing it our context and the public key to verify signatures with
        Log.d(TAG, "Creating IAB helper.");
        mHelper = new IabHelper(this, base64EncodedPublicKey);

        // enable debug logging (for a production application, you should set this to false).
        mHelper.enableDebugLogging(true);

        // Start setup. This is asynchronous and the specified listener
        // will be called once setup completes.
        Log.d(TAG, "Starting setup.");
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                Log.d(TAG, "Setup finished.");

                if (!result.isSuccess()) {
                    // Oh noes, there was a problem.
                    complain("Problem setting up in-app billing: " + result);
                    return;
                }

                // Have we been disposed of in the meantime? If so, quit.
                if (mHelper == null) return;

                // IAB is fully set up. Now, let's get an inventory of stuff we own.
                Log.d(TAG, "Setup successful. Querying inventory.");
                mHelper.queryInventoryAsync(mGotInventoryListener);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        if (mHelper == null) return;

        // Pass on the activity result to the helper for handling
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
        } else {
            Log.d(TAG, "onActivityResult handled by IABUtil.");
        }
    }

    // Listener that's called when we finish querying the items and subscriptions we own
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {


            Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) return;

            // Is it a failure?
            if (result.isFailure()) {
                complain("Failed to query inventory: " + result);
                return;
            }

            Log.d(TAG, "Query inventory was successful.");

            // Do we have the infinite gas plan?
            Purchase purchase = inventory.getPurchase(SKU_INFINITE_GAS);
            mSubscribedToInfiniteGas = (purchase != null &&
                    verifyDeveloperPayload(purchase));
            Log.d(TAG, "User " + (mSubscribedToInfiniteGas ? "HAS" : "DOES NOT HAVE")
                    + " app subscription.");


            if (mSubscribedToInfiniteGas == true) {

                Log.d(TAG, "" + purchase.getPurchaseTime());
                if (!NetworkUtils.getConnectivityStatusString(ImpAgreementActivity.this).equals("Not connected to Internet")) {
                    String startdate = toDateStr(purchase.getPurchaseTime());
                    String enddate = toDateEnd(purchase.getPurchaseTime() + DateUtils.YEAR_IN_MILLIS);
                    ImpAgreementActivity.PostSubAsynk asynkTask = new ImpAgreementActivity.PostSubAsynk(preferences.getInt(PrefConstants.USER_ID) + "", purchase.getToken(), startdate, enddate);
                    asynkTask.execute();
                } else {
                    DialogManager.showAlert("Network Error, Check your internet connection", ImpAgreementActivity.this);
                }

            } else {
                onInfiniteGasButtonClicked();// re-prompt payment portal
            }

            Log.d(TAG, "Initial inventory query finished; enabling main UI.");
        }
    };


    public void onInfiniteGasButtonClicked() {
        if (mHelper != null) {
            if (!mHelper.subscriptionsSupported()) {
                complain("Subscriptions not supported on your device yet. Sorry!");
                return;
            }
        }
        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";

        Log.d(TAG, "Launching purchase flow for Mylo subscription.");

        if (mHelper != null) {
            try {
                mHelper.launchPurchaseFlow(this,
                        SKU_INFINITE_GAS, IabHelper.ITEM_TYPE_SUBS,
                        RC_REQUEST, mPurchaseFinishedListener, payload);
            } catch (IllegalStateException ex) {
                Toast.makeText(this, "Please retry in a few seconds.", Toast.LENGTH_SHORT).show();
                mHelper.flagEndAsync();
            }
        }
    }
// Subscription code ends here - Nikita#Sub
}
