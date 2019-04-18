package com.mindyourlovedone.healthcare.DashBoard;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.utility.UIEmails;

public class UserInsActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack,txtEmail;

    TextView  txtStep1, txtStep2, txtStep22, txtStep222, txtStep3, txtStep4, txtStep5, txtStep55, txtStep555, txtStep6, txtStep7, txtStep8,txtStep9,txtHeader;
    Context context = this;
    FloatingActionButton floatProfile;

    String UI = "",From = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ins);
        initUi();
        initListener();
    }

    private void initListener() {
        imgBack.setOnClickListener(this);
        txtEmail.setOnClickListener(this);
      //  floatProfile.setOnClickListener(this);
    }

    private void initUi() {
        floatProfile = findViewById(R.id.floatProfile);
        txtHeader = findViewById(R.id.txtHeader);
        imgBack = findViewById(R.id.imgBack);
        txtEmail = findViewById(R.id.txtEmail);
        txtStep1 = findViewById(R.id.txtStep1);
        txtStep2 = findViewById(R.id.txtStep2);
        txtStep22 = findViewById(R.id.txtStep22);
        txtStep222 = findViewById(R.id.txtStep222);
        txtStep3 = findViewById(R.id.txtStep3);
        txtStep4 = findViewById(R.id.txtStep4);
        txtStep5 = findViewById(R.id.txtStep5);
        txtStep55 = findViewById(R.id.txtStep55);
        txtStep555 = findViewById(R.id.txtStep555);
        txtStep6 = findViewById(R.id.txtStep6);
        txtStep7 = findViewById(R.id.txtStep7);
        txtStep8 = findViewById(R.id.txtStep8);
        txtStep9 = findViewById(R.id.txtStep9);
        RelativeLayout relStep222 = findViewById(R.id.rlStep222);
        RelativeLayout relStep22 = findViewById(R.id.rlStep22);
        RelativeLayout relStep55 = findViewById(R.id.rlStep55);
        RelativeLayout relStep555 = findViewById(R.id.rlStep555);
        RelativeLayout relStep4 = findViewById(R.id.rlStep4);
        RelativeLayout relStep5 = findViewById(R.id.rlStep5);
        RelativeLayout relStep6 = findViewById(R.id.rlStep6);
        RelativeLayout relStep7 = findViewById(R.id.rlStep7);
        RelativeLayout relStep8 = findViewById(R.id.rlStep8);
        RelativeLayout relStep9 = findViewById(R.id.rlStep9);
        Intent i = getIntent();
        if (i.getExtras() != null) {
            From = i.getExtras().getString("From");
        }
if (From.equalsIgnoreCase("Profile")) {
    txtHeader.setText(R.string.prof_inst);
    txtStep1.setText(Html.fromHtml("<b>User Instructions.</b> Each section and sub-section have first time user instructions. Instructions are also always available by clicking the question mark on the top right corner of the screen. To exit the user instructions, click the arrow back button on the top right corner of the screen. To forward instructions click the up arrow on the right top corner of the screen."));
    txtStep2.setText(Html.fromHtml("<b>This is the Profiles screen.</b>  A User’s profile was automatically created when they registered.  Click anywhere on the cell (except on the photo circle), to open the Dashboard.  The file folder represents the Dashboard. \n"));
    txtStep3.setText(Html.fromHtml("<b>The Dashboard.</b>  The Dashboard is where Users will input and store information and documents. There are 6 sections on the Dashboard and within each section are sub-sections. The main sections are (1) Personal, Medical and Emergency Contacts; (2) Specialty Contacts; (3) Notes and Appointments; (4) Advance Directives and Other Documents; (5) Insurance; and (6) Prescriptions."));
    txtStep4.setText(Html.fromHtml("<b>Create a Profile for a Loved One.</b>  From the Profiles Screen, click the green PLUS button on the bottom right of the screen. Users will be given a choice to “Create New or Import from Dropbox”.  Create New allows Users to initiate a new profile. Users can automatically add data from their contacts, or type in new information.  The minimum amount of information you need to create a profile is the person’s name, the User’s relationship to the person, and email address. "));
    txtStep5.setText(Html.fromHtml("<b>Import from Dropbox</b> is used if the User is restoring a profile or uploading a profile that was shared by another person. Further instructions can be found in the Menu Bar. "));
   txtStep6.setText(Html.fromHtml("<b>Delete a Profile.</b>  To delete a profile, long press on the profile bar.  Users will see two choices, “delete or backup/share the profile”. "));
    txtStep7.setText(Html.fromHtml("<b>Backup or Share a Profile.</b>  To backup or share a profile, long press on the profile bar.  Click on backup/share a profile and the User will be provided further instructions. "));
    txtStep8.setText(Html.fromHtml("<b>Reports.</b> Reports are included for each section and sub-section. Users can view the report or email it. Fax capability is available for the sections most often sent to medical professionals and is required for HIPAA purposes.  To access reports, click the green circle (with three white dots) on the bottom of the screen. "));
    txtStep9.setText(Html.fromHtml("<b>The Menu Bar.</b> The menu bar is available from the Profiles page and the Dashboard. It’s located on the top left corner (the three horizontal lines). The menu bar is chockful of important information. Please take a look at the Resource section – it includes information about advance care directives, MYLO forms and templates, and interesting podcasts and videos. If in the Menu bar click All Profiles to return to the Profiles screen. "));


    relStep222.setVisibility(View.GONE);
    relStep22.setVisibility(View.GONE);
    relStep55.setVisibility(View.GONE);
    relStep555.setVisibility(View.GONE);

    //   UI = Html.fromHtml("<b>Welcome to MYLO</b> –  This App allows you to maintain a digital library of critical documents and medical information for you and your loved ones. There are 6 main sections. The App provides unlimited profiles, pdf reports, email and fax functionality, and the ability to share profiles and eliminate the need to re-enter data. \n\n <b>Getting Started</b> - Before you begin we would like to explain the data entry process. Except for this Profiles page, each screen has a top bar which includes the name of the screen, an arrow back button on the top left, three dots on the top right (which allows you to view or email the data), and a save button on data entry screens. \n\n\n\nFirst time Users will see First Time User Instructions directly on the screen. After adding information. the User can access User Instructions by clicking on the three buttons. A User Guide is also available from the dropdown Menu located on the top left of the Profiles page. \n\n <b>A reminder to all Users</b> - MYLO is a native to your phone. This means that we do not have access to your information. If you forget the name and email address used for this app then the data will be lost. It’s important that you  remember this information and to periodically back up the and or send yourself the pdf reports. Backup instructions are included on the Menu page.\n\n <b>MYLO Would Like to Access Your Contacts and MYLO Would Like to Access Your Camera</b> - This message does NOT mean that the company has access to your information, it simply allows the APP to utilise the functions of your phone and provide the USER with a better experience. \n\n <b>Adding a Profile</b> - click the plus box. You will see two options. Create New and Import from Dropbox. \n\n <b>Option 1</b> : Create New. You will be brought to the Add Profile  Screen. You can type in the new profile or if the person is in your Contacts then click the gray bar on the top right side of your screen to load information. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).\n\n <b>Option 2</b> : Import from Dropbox. Using this feature you can upload a profile from Dropbox. If you click that option, you will be provided additional instructions. Once completed click either Save (top right of screen) or Add Profile (bottom of screen). \n\n There are <b>three</b> required elements to create a Profile –  <b>name, relationship</b>, and an <b>email</b> address.\n\n <b>To Share a Profile –</b> Long press on the Profile Box and you will be able to upload the Profile to your Dropbox account.\n\n <b>To Delete a Profile –</b> Long Press on the Profile Box.\n\nThanks & Regards").toString();
    UI = Html.fromHtml(""+ txtStep1.getText().toString()+" <br>" +
            "<br>"+ txtStep2.getText().toString()+" <br>" +
            "<br>"+ txtStep3.getText().toString()+" <br>" +
            "<br> "+ txtStep4.getText().toString()+" <br>" +
            "<br> "+ txtStep5.getText().toString()+" <br>" +
             "<br>"+ txtStep6.getText().toString()+" <br>" +
           "<br>"+ txtStep7.getText().toString()+" <br>" +
            "<br>"+ txtStep8.getText().toString()+" <br>" +
            "<br>"+ txtStep9.getText().toString()+"<br>").toString();

}else if (From.equalsIgnoreCase("Dashboard")){
    txtHeader.setText("Understanding the Dashboard");
    txtStep1.setText(Html.fromHtml("The Dashboard contains 6 critical sections. To open a section click anywhere on the box. Each section\n" +
            "includes 3-4 subsections. Within each section users will enter data via text boxes, dropdowns, cards,\n" +
            "documents, and pictures."));
    txtStep2.setText(Html.fromHtml("Returning to the dashboard from a sub-section. To return to the dashboard users can arrow back or click the\n" +
            "little house on the top left corner of the screen. \n\n"));
    txtStep3.setText(Html.fromHtml("Returning to the Profiles screen from the dashboard. Click the Menu bar and then click All Profiles"));
   // txtStep4.setText(Html.fromHtml("<b>The little green circle with the three dots</b> is on every screen toward the bottom of the screen.  Click it and you will see that it allows you to view, email or fax a Report.   \n\n"));
   // txtStep5.setText(Html.fromHtml("<b>Instructions.</b>  Many of the sub-screens have first time user instructions.  If you click on the instructions you can send them to yourself by clicking <b>the share button</b> on the top right side of the screen.   <b>To exit the screen</b> click the <b>arrow back button</b> on the top left side of the screen.   If you <b>click the house</b> – you will be brought back to the dashboard of the person’s profile. \n\n"));
   // txtStep6.setText(Html.fromHtml("<b>The MENU bar.</b>  On the top left side of the dashboard screen are three parallel lines. This is the Menu bar.  If you click it  - you will see a dropdown menu.  There is lots of good information in this section.  I already explained how to use “All Profiles”.   For example “Resources” contains Advance Care Directives Information, Helpful MYLO Forms and Templates and interesting Podcasts and Videos. You should have a look in each of the topics. <b>To Return to the Menu bar</b> click the MENU bar. \n\n"));
   // txtStep7.setText(Html.fromHtml("<b>LET’S GET STARTED.</b>   I like to populate a profile by starting with the Personal and Medical section, then Specialty, then Notes and Routine Appointments, then Advance Care Directives, then Insurance and lastly Prescriptions.   But that’s me – you should do it however you feel most comfortable.   Make me happy…. Click the green box – Personal & Medical  Profile & Emergency Contacts. \n\n"));
   // txtStep8.setText(Html.fromHtml("Remember you can always find the instructions for the section by clicking the question mark on the top right side of the screen. \n\n"));
    relStep4.setVisibility(View.GONE);
    relStep5.setVisibility(View.GONE);
    relStep6.setVisibility(View.GONE);
    relStep7.setVisibility(View.GONE);
    relStep8.setVisibility(View.GONE);
    relStep9.setVisibility(View.GONE);
    relStep222.setVisibility(View.GONE);
    relStep22.setVisibility(View.GONE);
    relStep55.setVisibility(View.GONE);
    relStep555.setVisibility(View.GONE);

    //   UI = Html.fromHtml("<b>Welcome to MYLO</b> –  This App allows you to maintain a digital library of critical documents and medical information for you and your loved ones. There are 6 main sections. The App provides unlimited profiles, pdf reports, email and fax functionality, and the ability to share profiles and eliminate the need to re-enter data. \n\n <b>Getting Started</b> - Before you begin we would like to explain the data entry process. Except for this Profiles page, each screen has a top bar which includes the name of the screen, an arrow back button on the top left, three dots on the top right (which allows you to view or email the data), and a save button on data entry screens. \n\n\n\nFirst time Users will see First Time User Instructions directly on the screen. After adding information. the User can access User Instructions by clicking on the three buttons. A User Guide is also available from the dropdown Menu located on the top left of the Profiles page. \n\n <b>A reminder to all Users</b> - MYLO is a native to your phone. This means that we do not have access to your information. If you forget the name and email address used for this app then the data will be lost. It’s important that you  remember this information and to periodically back up the and or send yourself the pdf reports. Backup instructions are included on the Menu page.\n\n <b>MYLO Would Like to Access Your Contacts and MYLO Would Like to Access Your Camera</b> - This message does NOT mean that the company has access to your information, it simply allows the APP to utilise the functions of your phone and provide the USER with a better experience. \n\n <b>Adding a Profile</b> - click the plus box. You will see two options. Create New and Import from Dropbox. \n\n <b>Option 1</b> : Create New. You will be brought to the Add Profile  Screen. You can type in the new profile or if the person is in your Contacts then click the gray bar on the top right side of your screen to load information. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).\n\n <b>Option 2</b> : Import from Dropbox. Using this feature you can upload a profile from Dropbox. If you click that option, you will be provided additional instructions. Once completed click either Save (top right of screen) or Add Profile (bottom of screen). \n\n There are <b>three</b> required elements to create a Profile –  <b>name, relationship</b>, and an <b>email</b> address.\n\n <b>To Share a Profile –</b> Long press on the Profile Box and you will be able to upload the Profile to your Dropbox account.\n\n <b>To Delete a Profile –</b> Long Press on the Profile Box.\n\nThanks & Regards").toString();
    UI = Html.fromHtml(""+ txtStep1.getText().toString()+" <br>" +
            "<br>"+ txtStep2.getText().toString()+" <br>" +
          //  "<br>"+ txtStep3.getText().toString()+" <br>" +
          //  "<br> "+ txtStep4.getText().toString()+" <br>" +
            // "<br> "+ txtStep1.getText().toString()+" <br>" +
            //  "<br>"+ txtStep1.getText().toString()+" <br>" +
            //   "<br>"+ txtStep1.getText().toString()+" <br>" +
            "<br>"+ txtStep3.getText().toString()+"<br>").toString();
}
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.txtEmail:
                if (From.equalsIgnoreCase("Profile")) {
                    showEmailDialog("Getting Started Instructions");
                }else if (From.equalsIgnoreCase("Dashboard")) {
                    showEmailDialog("Understanding the Dashboard Instructions");
                }
                break;
            case R.id.floatProfile:
                Intent intentDashboard = new Intent(context, BaseActivity.class);
                intentDashboard.putExtra("c", 1);//Profile Data
                //  intentDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //  intentDashboard.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentDashboard);
                break;
        }
    }

    private void showEmailDialog(final String sub) {
        final Dialog dialogEmailIns = new Dialog(context);
        dialogEmailIns.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEmailIns.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        LayoutInflater lf = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogview = lf.inflate(R.layout.dialog_email_ins, null);
        final TextView txtYes = dialogview.findViewById(R.id.txtYes);
        final TextView txtNo = dialogview.findViewById(R.id.txtNo);

        dialogEmailIns.setContentView(dialogview);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogEmailIns.getWindow().getAttributes());
        int width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.95);
        lp.width = width;
        RelativeLayout.LayoutParams buttonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonLayoutParams.setMargins(0, 0, 0, 10);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogEmailIns.getWindow().setAttributes(lp);
        dialogEmailIns.setCanceledOnTouchOutside(false);
        dialogEmailIns.show();


        txtYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIEmails ui = new UIEmails();
                ui.emailAttachement(UserInsActivity.this, sub, UI);
//                Toast.makeText(context, "Still in progress please wait..!!", Toast.LENGTH_SHORT).show();
                dialogEmailIns.dismiss();
            }
        });

        txtNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEmailIns.dismiss();
            }
        });


    }
}
