package com.mindyourlovedones.healthcare.HomeActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedones.healthcare.Connections.FragmentConnectionNew;
import com.mindyourlovedones.healthcare.DashBoard.AddDocumentActivity;
import com.mindyourlovedones.healthcare.DashBoard.CustomArrayAdapter;
import com.mindyourlovedones.healthcare.DashBoard.DropboxLoginActivity;
import com.mindyourlovedones.healthcare.DashBoard.FragmentDashboard;
import com.mindyourlovedones.healthcare.DashBoard.FragmentNotification;
import com.mindyourlovedones.healthcare.IndexMenu.FragmentOverview;
import com.mindyourlovedones.healthcare.customview.MySpinner;
import com.mindyourlovedones.healthcare.database.DBHelper;
import com.mindyourlovedones.healthcare.database.MyConnectionsQuery;
import com.mindyourlovedones.healthcare.model.RelativeConnection;
import com.mindyourlovedones.healthcare.utility.PrefConstants;
import com.mindyourlovedones.healthcare.utility.Preferences;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CALL_PERMISSION = 600;
    public static FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    Context context = this;
    FragmentDashboard fragmentDashboard = null;
    FragmentResources fragmentResources = null;
    FragmentForm fragmentForm = null;
    FragmentMarketPlace fragmentMarketPlace = null;
    FragmentVideos fragmentVideos = null;
    FragmentBackup fragmentBackup = null;
    FragmentConnectionNew fragmentConnection = null;
    FragmentNotification fragmentNotification = null;
    FragmentOverview fragmentOverview = null;
    ImageView imgDrawer, imgNoti, imgLogout, imgLocationFeed, imgProfile, imgDrawerProfile, imgPdf, imgDoc, imgRight;
    TextView txtTitle, txtName, txtDrawerName, txtFname, txtAdd;
    TextView txtBank, txtForm, txtSenior, txtAdvance;
    DrawerLayout drawerLayout;
    RelativeLayout leftDrawer, container, footer, header;
    RelativeLayout rlLogOutt;
    Preferences preferences;
    TextView txtPrivacyPolicy, txtEULA;
    RelativeLayout rlGuide, rlProfiles, rlHome, rlSupport, rlContact, rlResources, rlPrivacy, rlMarketPlace, rlVideos, rlBackup, rlResourcesDetail, rlMarketDetail, rlPrivacyDetail;
    boolean flagResource = false, flagMarket = false, flagPrivacy = false;

    ImageLoader imageLoader;
    DisplayImageOptions displayImageOptions;
    DBHelper dbHelper;
    boolean external_flag = false;
    String originPath = "";
    String documentPath = "";
    String name = "";

    String From;
    Intent i;
    final CharSequence[] dialog_add = {"Add to Advance Directives", "Add to Other Documents", "Add to Medical Records"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        try {
            //nikita -pdf
            Intent i = getIntent();
            if (i != null) {
                Uri audoUri = i.getParcelableExtra(Intent.EXTRA_STREAM);
                if (audoUri != null) {
                    Log.v("URI", audoUri.toString());
                    preferences = new Preferences(context);
                    if (preferences.getREGISTERED() && preferences.isLogin()) {
                        loadData();
                        extPDF(audoUri + "");
                    } else {
                        Toast.makeText(getApplicationContext(), "You need to login first", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BaseActivity.this, SplashNewActivity.class));
                        finish();
                    }
                } else {
                    loadData();
                }
            } else {
                loadData();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadData() {

//                    FirebaseCrash.report(new Exception("My first Android non-fatal error"));
//                    //I'm also creating a log message, which we'll look at in more detail later//
//                    FirebaseCrash.log("MainActivity started");
        accessPermission();
        //Crashlytics.getInstance().crash(); // Force a crash
        initImageLoader();
        initComponent();
        initUI();
        initListener();
        fragmentData();
        if (fragmentManager.findFragmentByTag("CONNECTION") == null) {
            callFirstFragment("CONNECTION", fragmentConnection);
        }

    }

    List<RelativeConnection> items;//nikita

    public void getData() {//nikita
        DBHelper dbHelper = new DBHelper(this, "MASTER");
        MyConnectionsQuery m = new MyConnectionsQuery(this, dbHelper);
        items = MyConnectionsQuery.fetchAllRecord();
    }

    private void extPDF(final String URI) {//nikita
        getData();
        final Dialog dialogSharePdf = new Dialog(context);
        dialogSharePdf.setCancelable(false);
        dialogSharePdf.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogSharePdf.setContentView(R.layout.dialog_share_storage_pdf);

        TextView txtSelect = dialogSharePdf.findViewById(R.id.txtSelect);
        TextView txtOk = dialogSharePdf.findViewById(R.id.txtOk);
        final MySpinner spinnerPro = dialogSharePdf.findViewById(R.id.spinnerPro);
        CustomArrayAdapter adapter = new CustomArrayAdapter(context,
                android.R.layout.simple_spinner_dropdown_item, items);

        spinnerPro.setAdapter(adapter);
        spinnerPro.setHint("Profile");

        txtOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                preferences.putInt(PrefConstants.CONNECTED_USERID, items.get(spinnerPro.getSelectedItemPosition() - 1).getId());
                dialogSharePdf.dismiss();
                AlertDialog.Builder builders = new AlertDialog.Builder(context);
                builders.setTitle("");
                builders.setCancelable(false);
                builders.setItems(dialog_add, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int itemPos) {
                        switch (itemPos) {
                            case 0: // email
                                Intent in = new Intent(BaseActivity.this, AddDocumentActivity.class);
                                in.putExtra("FROM", "AD");
                                in.putExtra("PDF_EXT", URI);
                                startActivity(in);
                                break;
                            case 1: // email
                                Intent in1 = new Intent(BaseActivity.this, AddDocumentActivity.class);
                                in1.putExtra("FROM", "Other");
                                in1.putExtra("PDF_EXT", URI);
                                startActivity(in1);
                                break;
                            case 2: // Fax
                                Intent in2 = new Intent(BaseActivity.this, AddDocumentActivity.class);
                                in2.putExtra("FROM", "Record");
                                in2.putExtra("PDF_EXT", URI);
                                startActivity(in2);
                                break;
                        }
                    }
                });

                AlertDialog dialog = builders.create();
                builders.show();
            }
        });

        dialogSharePdf.show();

    }

/*
    private void showSharePdfDialog() {
      final   Dialog dialogSharePdf = new Dialog(context);
        dialogSharePdf.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogSharePdf.setContentView(R.layout.dialog_share_storage_pdf);
        TextView txtSelect = dialogSharePdf.findViewById(R.id.txtSelect);
        TextView txtOk = dialogSharePdf.findViewById(R.id.txtOk);
        txtSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dialogSharePdf.dismiss();
            }
        });

        dialogSharePdf.show();
        txtOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSharePdf.dismiss();
                initComponent();

            }
        });

    }
*/


    private void initImageLoader() {
        displayImageOptions = new DisplayImageOptions.Builder() // resource
                .resetViewBeforeLoading(true) // default
                .cacheInMemory(true) // default
                .cacheOnDisk(true) // default
                .showImageOnLoading(R.drawable.ic_profile_defaults)
                .considerExifParams(false) // default
//                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .displayer(new RoundedBitmapDisplayer(150)) // default //for square SimpleBitmapDisplayer()
                .handler(new Handler()) // default
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(displayImageOptions)
                .build();
        ImageLoader.getInstance().init(config);
        imageLoader = ImageLoader.getInstance();
    }
/*
    private void initComponent() {
        preferences = new Preferences(context);
        dbHelper = new DBHelper(context, preferences.getString(PrefConstants.CONNECTED_USERDB));
        DocumentQuery d = new DocumentQuery(context, dbHelper);
        if (preferences == null) {
            preferences = new Preferences(BaseActivity.this);
        }

        if (preferences.getREGISTERED() && preferences.isLogin()) {

        } else {
            Toast.makeText(getApplicationContext(), "You need to login first", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(BaseActivity.this, SplashNewActivity.class));
            finish();
        }

        From = preferences.getString(PrefConstants.FROM);

        i = getIntent();
        Log.v("URI", i.getExtras().toString());
        final Uri audoUri = i.getParcelableExtra(Intent.EXTRA_STREAM);
        if (audoUri != null) {
            Log.v("URI", audoUri.toString());
            AlertDialog.Builder builders = new AlertDialog.Builder(context);
            builders.setTitle("");
            builders.setCancelable(false);
            builders.setItems(dialog_add, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int itemPos) {
                    switch (itemPos) {
                        case 0: // email
                            From = "AD";
                            addfile(audoUri);
                            //initUi();
                            external_flag = true;
                            break;
                     */
/*   case 1: // email
                            From = "Other";
                            addfile(audoUri);
                            initUi();
                            external_flag = true;
                            break;
                        case 2: // Fax
                            From = "Record";
                            addfile(audoUri);
                            initUi();
                            external_flag = true;
                            break;*//*

                    }
                }
            });
            builders.create().show();
        }
    }
*/

/*
    private void addfile(Uri audoUri) {
        originPath = audoUri.toString();

        File f = new File(audoUri.getPath());
        originPath = f.getPath();
        originPath = originPath.replace("/root_path/", "");
        documentPath = f.getName();
        name = f.getName();
        preferences.putInt(PrefConstants.CONNECTED_USERID, 1);
        txtFname.setText(name);
        imgDoc.setClickable(false);
        String text = "You Have selected <b>" + name + "</b> Document";
        Toast.makeText(context, Html.fromHtml(text), Toast.LENGTH_SHORT).show();
        showDialogWindow(text);
        txtAdd.setText("Edit File");
        imgDoc.setImageResource(R.drawable.pdf);
    }
*/

    private void showDialogWindow(String text) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setMessage(Html.fromHtml(text));
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }


    private void initComponent() {
        preferences = new Preferences(context);
    }

    private void initListener() {
        imgDrawer.setOnClickListener(this);
        imgPdf.setOnClickListener(this);
        //   imgNoti.setOnClickListener(this);
        rlLogOutt.setOnClickListener(this);
        imgLocationFeed.setOnClickListener(this);
        rlProfiles.setOnClickListener(this);
        rlHome.setOnClickListener(this);
        rlSupport.setOnClickListener(this);
        rlResources.setOnClickListener(this);
        rlPrivacy.setOnClickListener(this);
        rlMarketPlace.setOnClickListener(this);
        rlVideos.setOnClickListener(this);
        rlBackup.setOnClickListener(this);
        rlContact.setOnClickListener(this);
        rlGuide.setOnClickListener(this);
        txtBank.setOnClickListener(this);
        txtForm.setOnClickListener(this);
        txtSenior.setOnClickListener(this);
        txtAdvance.setOnClickListener(this);
        rlPrivacyDetail.setOnClickListener(this);
        txtPrivacyPolicy.setOnClickListener(this);
        txtEULA.setOnClickListener(this);
    }

    private void initUI() {
        txtFname = findViewById(R.id.txtFName);
        txtAdd = findViewById(R.id.txtAdd);
        imgDrawer = findViewById(R.id.imgDrawer);
        imgNoti = findViewById(R.id.imgNoti);
        imgProfile = findViewById(R.id.imgProfile);
        imgPdf = findViewById(R.id.imgPdf);
        imgPdf.setVisibility(View.GONE);
        imgLocationFeed = findViewById(R.id.imgLocationFeed);

        txtTitle = findViewById(R.id.txtTitle);
        txtName = findViewById(R.id.txtName);


        txtBank = findViewById(R.id.txtBank);
        txtForm = findViewById(R.id.txtForm);
        txtSenior = findViewById(R.id.txtSenior);
        txtAdvance = findViewById(R.id.txtAdvance);


        drawerLayout = findViewById(R.id.drawerLayout);
        leftDrawer = findViewById(R.id.leftDrawer);
        header = findViewById(R.id.header);
        rlLogOutt = findViewById(R.id.rlLogOutt);
        txtDrawerName = leftDrawer.findViewById(R.id.txtDrawerName);
        imgDrawerProfile = leftDrawer.findViewById(R.id.imgDrawerProfile);
        imgRight = leftDrawer.findViewById(R.id.imgRight);
       /* Bitmap bmp = BitmapFactory.decodeByteArray(photo, 0, photo.length);
        imgDrawerProfile.setImageBitmap(bmp);*/
        rlGuide = leftDrawer.findViewById(R.id.rlGuide);
        rlProfiles = leftDrawer.findViewById(R.id.rlProfiles);
        rlHome = leftDrawer.findViewById(R.id.rlHome);
        rlSupport = leftDrawer.findViewById(R.id.rlSupport);
        rlResources = leftDrawer.findViewById(R.id.rlResources);
        rlPrivacy = leftDrawer.findViewById(R.id.rlPrivacy);
        rlMarketPlace = leftDrawer.findViewById(R.id.rlMarketPlace);
        rlVideos = leftDrawer.findViewById(R.id.rlVideos);
        rlBackup = leftDrawer.findViewById(R.id.rlBackup);
        rlMarketDetail = leftDrawer.findViewById(R.id.rlMarketDetail);
        rlResourcesDetail = leftDrawer.findViewById(R.id.rlResourcesDetail);
        rlPrivacyDetail = leftDrawer.findViewById(R.id.rlPrivacyDetail);
        rlContact = leftDrawer.findViewById(R.id.rlContact);
        txtPrivacyPolicy = leftDrawer.findViewById(R.id.txtPrivacyPolicy);
        txtEULA = leftDrawer.findViewById(R.id.txtEULA);
    }

    private void fragmentData() {
        fragmentManager = getFragmentManager();
        fragmentDashboard = new FragmentDashboard();
        fragmentOverview = new FragmentOverview();
        fragmentConnection = new FragmentConnectionNew();
        fragmentNotification = new FragmentNotification();
        fragmentResources = new FragmentResources();
        fragmentForm = new FragmentForm();
        fragmentMarketPlace = new FragmentMarketPlace();
        fragmentVideos = new FragmentVideos();
        fragmentBackup = new FragmentBackup();
    }

    public void callFragment(String fragName, Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragName.equals("DASHBOARD") || fragName.equals("ADVANCE"))
            fragmentTransaction.replace(R.id.fragmentContainer, fragment, fragName).addToBackStack("CONNECTION");
        else
            fragmentTransaction.replace(R.id.fragmentContainer, fragment, fragName);
        fragmentTransaction.commit();
    }

    public void callFirstFragment(String fragName, Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, fragName);
        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgDrawer:
                // Intent intn=new Intent(context, ImageActivity.class);
                // startActivity(intn);
                drawerLayout.openDrawer(leftDrawer);
                // copydb(context);
                break;

            case R.id.rlProfiles:
                //if (fragmentManager.findFragmentByTag("CONNECTION") == null) {
                if (fragmentConnection.isAdded()) {
                    drawerLayout.closeDrawer(leftDrawer);
                    return;
                } else {
                    // callFragment("CONNECTION", fragmentConnection);
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, fragmentConnection, "CONNECTION").addToBackStack("CONNECTION");
                    fragmentTransaction.commit();
                }
                //  }
                drawerLayout.closeDrawer(leftDrawer);
                break;
            case R.id.rlHome:
                Intent intentSplash = new Intent(context, SplashNewActivity.class);
                startActivity(intentSplash);
                break;

            case R.id.rlSupport:

                CopyReadAssetss("FAQ.pdf");
                drawerLayout.closeDrawer(leftDrawer);
               /* Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.myhealthcarewishes.com/support.html"));
                startActivity(intent);*/
                break;

            case R.id.rlContact:
               /* Intent intents = new Intent();
                intents.setAction(Intent.ACTION_VIEW);
                intents.addCategory(Intent.CATEGORY_BROWSABLE);
                intents.setData(Uri.parse("http://www.myhealthcarewishes.com/support.html"));
                startActivity(intents);*/

                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                        new String[]{"customersupport@mindyour-lovedones.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        ""); // subject
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, ""); // Body
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    emailIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    // uri = FileProvider.getUriForFile(context, "com.mindyourelders.healthcare.HomeActivity.fileProvider", f);
                } else {
                    // uri = Uri.fromFile(f);
                }
                emailIntent.setType("application/email");
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                break;

            case R.id.rlResources:
                if (flagResource == false) {
                    rlResourcesDetail.setVisibility(View.VISIBLE);
                    flagResource = true;
                } else if (flagResource == true) {
                    rlResourcesDetail.setVisibility(View.GONE);
                    flagResource = false;
                }

            case R.id.rlPrivacy:
                if (flagPrivacy == false) {
                    rlPrivacyDetail.setVisibility(View.VISIBLE);
                    flagPrivacy = true;
                } else if (flagPrivacy == true) {
                    rlPrivacyDetail.setVisibility(View.GONE);
                    flagPrivacy = false;
                }

                break;

            case R.id.rlMarketPlace:
                if (flagMarket == false) {
                    rlMarketDetail.setVisibility(View.VISIBLE);
                    flagMarket = true;
                } else if (flagMarket == true) {
                    rlMarketDetail.setVisibility(View.GONE);
                    flagMarket = false;
                }
                break;

            case R.id.txtForm:
                if (fragmentManager.findFragmentByTag("FORM") == null) {
                    callFragment("FORM", fragmentForm);
                }
                drawerLayout.closeDrawer(leftDrawer);
                break;

            case R.id.txtAdvance:
                if (fragmentManager.findFragmentByTag("ADVANCE") == null) {
                    callFragment("ADVANCE", fragmentResources);
                }
                drawerLayout.closeDrawer(leftDrawer);
                break;

            case R.id.txtPrivacyPolicy:
                // callFragment("FORM", fragmentResources);
                CopyReadAssetss("Privacy Policy.pdf");
                drawerLayout.closeDrawer(leftDrawer);
                break;

            case R.id.rlGuide:
                // callFragment("FORM", fragmentResources);
                CopyReadAssetss("mylo_users_guide.pdf");
                drawerLayout.closeDrawer(leftDrawer);
                break;

            case R.id.txtEULA:
                // callFragment("FORM", fragmentResources);
                CopyReadAssetss("eula.pdf");
                drawerLayout.closeDrawer(leftDrawer);
                break;


            case R.id.txtBank:
                //shradha
                showBankDialog();
                drawerLayout.closeDrawer(leftDrawer);
                //   if (fragmentManager.findFragmentByTag("MARKET") == null) {
                //  callFragment("MARKET", fragmentMarketPlace);
                //  }
               /* Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://mindyour-lovedones.com/"));
                startActivity(intent);*/
                break;

            case R.id.txtSenior:
                //   if (fragmentManager.findFragmentByTag("MARKET") == null) {
                // callFragment("MARKET", fragmentMarketPlace);
                //  }
               /* Intent intents = new Intent();
                intents.setAction(Intent.ACTION_VIEW);
                intents.addCategory(Intent.CATEGORY_BROWSABLE);
                intents.setData(Uri.parse("http://mindyour-lovedones.com/"));
                startActivity(intents);*/

                //shradha
                showBankDialog();
                drawerLayout.closeDrawer(leftDrawer);
                break;


            case R.id.rlVideos:
                if (fragmentManager.findFragmentByTag("VIDEOS") == null) {
                    callFragment("VIDEOS", fragmentVideos);
                }
                drawerLayout.closeDrawer(leftDrawer);
                break;

            case R.id.rlBackup:
                Intent i = new Intent(BaseActivity.this, DropboxLoginActivity.class);
                i.putExtra("FROM", "Backup");
                i.putExtra("ToDo", "Whole");
                i.putExtra("ToDoWhat", "Profile");
                startActivity(i);
                // if (fragmentManager.findFragmentByTag("VIDEOS") == null) {
                // callFragment("VIDEOS", fragmentBackup);
                //  }
                drawerLayout.closeDrawer(leftDrawer);
                break;

            case R.id.rlLogOutt:
                preferences.clearPreferences();
                finish();
                startActivity(new Intent(BaseActivity.this, LoginActivity.class));
                break;
        }
    }


    //Shradha
    private void showBankDialog() {
        final Dialog dialogBank = new Dialog(context);
        dialogBank.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBank.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        LayoutInflater lf = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogview = lf.inflate(R.layout.dialog_bank, null);
        final TextView txtComming = dialogview.findViewById(R.id.txtComming);
        final TextView txtOk = dialogview.findViewById(R.id.txtOk);

        txtComming.setText("Comming Soon");
        // txtComming.setTextColor(R.color.colorBlue);
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

    @Override
    protected void onResume() {
        super.onResume();
        String image = preferences.getString(PrefConstants.USER_PROFILEIMAGE);
        //byte[] photo = Base64.decode(image, Base64.DEFAULT);
        txtDrawerName.setText(preferences.getString(PrefConstants.USER_NAME));
        if (!image.equals("")) {
            File imgFile = new File(Environment.getExternalStorageDirectory() + "/MYLO/Master/", image);
            if (imgFile.exists()) {
                imageLoader.displayImage(String.valueOf(Uri.fromFile(imgFile)), imgDrawerProfile, displayImageOptions);
               /* Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                imgDrawerProfile.setImageBitmap(myBitmap);*/
            }
        } else {
            imgDrawerProfile.setImageResource(R.drawable.ic_profile_defaults);
        }
    }

    public void CopyReadAssetss(String documentPath) {
        AssetManager assetManager = getAssets();
        File outFile = null;
        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), documentPath);
        try {
            in = assetManager.open(documentPath);
            outFile = new File(getExternalFilesDir(null), documentPath);
            out = new FileOutputStream(outFile);

            copyFiles(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
            /*out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFiles(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;*/
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }
        Uri uri = null;
        // Uri uri= Uri.parse("file://" + getFilesDir() +"/"+documentPath);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //  intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            uri = FileProvider.getUriForFile(context, "com.mindyourlovedones.healthcare.HomeActivity.fileProvider", outFile);
        } else {
            uri = Uri.fromFile(outFile);
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setDataAndType(uri, "application/pdf");
        context.startActivity(intent);

    }

    private void copyFiles(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    private void accessPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                ) {
            requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
            }, REQUEST_CALL_PERMISSION);

        } else {
            // checkForRegistration();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CALL_PERMISSION: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //  checkForRegistration();

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

    @Override
    public void onBackPressed() {

        SplashNewActivity.fromDash = true;

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code

        } else {
            if (getFragmentManager().findFragmentByTag("CONNECTION").isResumed()) {
                finish();
            } else {
                getFragmentManager().popBackStack();
            }
        }

    }
}
