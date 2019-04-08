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

    TextView  txtStep1, txtStep2, txtStep22, txtStep222, txtStep3, txtStep4, txtStep5, txtStep55, txtStep555, txtStep6, txtStep7, txtStep8,txtHeader;
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
        RelativeLayout relStep222 = findViewById(R.id.rlStep222);
        RelativeLayout relStep22 = findViewById(R.id.rlStep22);
        RelativeLayout relStep55 = findViewById(R.id.rlStep55);
        RelativeLayout relStep555 = findViewById(R.id.rlStep555);
        Intent i = getIntent();
        if (i.getExtras() != null) {
            From = i.getExtras().getString("From");
        }
if (From.equalsIgnoreCase("Profile")) {
    txtHeader.setText(R.string.prof_inst);
    txtStep1.setText(Html.fromHtml("To exit the User Instructions and go back to the profile screen click the arrow back button on the top left side of the screen.  To go directly to your dashboard click the picture of the house on the top left side of the screen. If you want to send these instructions click the share button on the top right side of the screen.  \n\n"));
    txtStep2.setText(Html.fromHtml("<b>This is the Profiles screen.</b> This is where you will manage your information and set up separate profiles for your loved ones. \n\n"));
    txtStep3.setText(Html.fromHtml("<b>If you click on your name</b> (or anywhere on the bar) you will be brought to the “Dashboard”.  There are 6 main section within MYLO and each section has sub-sections. Add as much or as little information as you want into each section.  Each profile has its own dashboard. If you are on the dashboard and want to return to the Profile screen click the Menu bar on the top left of the screen, and then click “All Profiles”. \n\n"));
    txtStep4.setText(Html.fromHtml("<b>Instructions.</b> Each section and sub-section has<b> first time user instructions. </b> If you get stuck you can always access the instructions by clicking the little <b>question mark</b> found on the top right side of the screen. <b>A User Guide and How to Videos</b> are also available and can be accessed by clicking the Menu button on the top left side of the profile and dashboard screens \n\n"));
    txtStep5.setText(Html.fromHtml("<b>Adding Profiles.</b>  Click the plus button on the bottom right side of the profile screen. You will be asked if you want to \n" +
            "create a new profile or import a profile from Dropbox.  <b> To begin – click “create a new profile”.</b>   The other option will be dealt with later after we explain how to save your data and how to share your profiles with other loved ones.  \n\n"));
    txtStep6.setText(Html.fromHtml("<b>There are three required elements to create a Profile:</b>  (1) a name; (2) a relationship; and (3) an email address. You can type in the new profile or add some of the information from your contacts. Once you fill in that data click <b>SAVE</b> on the top right side of the screen.  You will automatically be brought to the Profiles Screen.).\n\n"));
    txtStep7.setText(Html.fromHtml("<b>Deleting Profiles.</b>  To delete a profile, long press on the profile box. A screen will pop up asking if you want to Delete the Profile or Backup/Share the profile.   Instructions for the backup/share function will be provided in another set of instructions titled <b>Backup, Restore, and Sharing a Profile.</b>\n\n"));
    txtStep8.setText(Html.fromHtml("<b>LET’S GET STARTED</b> – GO TO YOUR PROFILE AND CLICK ON YOUR NAME OR THE LITTLE FILE FOLDER ON THE RIGH SIDE OF THE BAR. YOU WILL BE BROUGH TO THE DASHBOARD.  TO LEARN MORE ABOUT THE DASHBOARD CLICK THE QUESTION MARK ON THE TOP RIGHT OF THE SCREEN\n\n"));

    relStep222.setVisibility(View.GONE);
    relStep22.setVisibility(View.GONE);
    relStep55.setVisibility(View.GONE);
    relStep555.setVisibility(View.GONE);

    //   UI = Html.fromHtml("<b>Welcome to MYLO</b> –  This App allows you to maintain a digital library of critical documents and medical information for you and your loved ones. There are 6 main sections. The App provides unlimited profiles, pdf reports, email and fax functionality, and the ability to share profiles and eliminate the need to re-enter data. \n\n <b>Getting Started</b> - Before you begin we would like to explain the data entry process. Except for this Profiles page, each screen has a top bar which includes the name of the screen, an arrow back button on the top left, three dots on the top right (which allows you to view or email the data), and a save button on data entry screens. \n\n\n\nFirst time Users will see First Time User Instructions directly on the screen. After adding information. the User can access User Instructions by clicking on the three buttons. A User Guide is also available from the dropdown Menu located on the top left of the Profiles page. \n\n <b>A reminder to all Users</b> - MYLO is a native to your phone. This means that we do not have access to your information. If you forget the name and email address used for this app then the data will be lost. It’s important that you  remember this information and to periodically back up the and or send yourself the pdf reports. Backup instructions are included on the Menu page.\n\n <b>MYLO Would Like to Access Your Contacts and MYLO Would Like to Access Your Camera</b> - This message does NOT mean that the company has access to your information, it simply allows the APP to utilise the functions of your phone and provide the USER with a better experience. \n\n <b>Adding a Profile</b> - click the plus box. You will see two options. Create New and Import from Dropbox. \n\n <b>Option 1</b> : Create New. You will be brought to the Add Profile  Screen. You can type in the new profile or if the person is in your Contacts then click the gray bar on the top right side of your screen to load information. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).\n\n <b>Option 2</b> : Import from Dropbox. Using this feature you can upload a profile from Dropbox. If you click that option, you will be provided additional instructions. Once completed click either Save (top right of screen) or Add Profile (bottom of screen). \n\n There are <b>three</b> required elements to create a Profile –  <b>name, relationship</b>, and an <b>email</b> address.\n\n <b>To Share a Profile –</b> Long press on the Profile Box and you will be able to upload the Profile to your Dropbox account.\n\n <b>To Delete a Profile –</b> Long Press on the Profile Box.\n\nThanks & Regards").toString();
    UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To exit the User Instructions and go back to the profile screen click the arrow back button on the top left side of the screen.  To go directly to your dashboard click the picture of the house on the top left side of the screen. If you want to send these instructions click the share button on the top right side of the screen.  <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp;<b>This is the Profiles screen.</b> This is where you will manage your information and set up separate profiles for your loved ones. <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp; If you click on your name (or anywhere on the bar) you will be brought to the “Dashboard”.  There are 6 main section within MYLO and each section has sub-sections. Add as much or as little information as you want into each section.  Each profile has its own dashboard. If you are on the dashboard and want to return to the Profile screen click the Menu bar on the top left of the screen, and then click “All Profiles”. <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp; Instructions. Each section and sub-section has first time user instructions.  If you get stuck you can always access the instructions by clicking the little question mark found on the top right side of the screen. A User Guide and How to Videos are also available and can be accessed by clicking the Menu button on the top left side of the profile and dashboard screens.<br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp; <b>Adding Profiles.</b> Click the plus button on the bottom right side of the profile screen. You will be asked if you want to \n" +
            "create a new profile or import a profile from Dropbox. To begin – click “create a new profile”.  The other option will be dealt with later after we explain how to save your data and how to share your profiles with other loved ones.    \n.<br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp;There are three required elements to create a Profile:  (1) a name; (2) a relationship; and (3) an email address. You can type in the new profile or add some of the information from your contacts. Once you fill in that data click SAVE on the top right side of the screen.  You will automatically be brought to the Profiles Screen. \n<br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp;Deleting Profiles.  To delete a profile, long press on the profile box. A screen will pop up asking if you want to Delete the Profile or Backup/Share the profile.   Instructions for the backup/share function will be provided in another set of instructions titled Backup, Restore, and Sharing a Profile. \n<br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp;LET’S GET STARTED – GO TO YOUR PROFILE AND CLICK ON YOUR NAME OR THE LITTLE FILE FOLDER ON THE RIGH SIDE OF THE BAR. YOU WILL BE BROUGH TO THE DASHBOARD.  TO LEARN MORE ABOUT THE DASHBOARD CLICK THE QUESTION MARK ON THE TOP RIGHT OF THE SCREEN.\n<br>").toString();

}else if (From.equalsIgnoreCase("Dashboard")){
    txtHeader.setText("Understanding the Dashboard");
    txtStep1.setText(Html.fromHtml("<b>MYLO is intuitive and very easy to use.</b>  Each box represents a section of information that is most often needed during a medical event or crisis. MYLO allows Users to organize this information  in a nice easy fashion.  Within each box are sub-sections. Use as much or as little of the App as you want or need.  Come back to a section to add or edit information.  \n\n"));
    txtStep2.setText(Html.fromHtml("<b>PDF Reports, Email, Faxing, Printing.</b>  We created reports for each section that can be viewed, emailed or printed. Sub-sections can also be viewed,  emailed or printed and in some cased faxed.  Faxing should only be used in a medical emergency and only for HIPAA purposes.  \n\n"));
    txtStep3.setText(Html.fromHtml("<b>Let’s Practice - Click on any box.</b>   Within each section are 3 or 4 subsections. Each section generally works the same way.   As you fill in the information remember to click SAVE on the top right side of the screen.  We added  quite a few dropdown menus to make data entry more simple.   \n\n"));
    txtStep4.setText(Html.fromHtml("<b>The little green circle with the three dots</b> is on every screen toward the bottom of the screen.  Click it and you will see that it allows you to view, email or fax a Report.   \n\n"));
    txtStep5.setText(Html.fromHtml("<b>Instructions.</b>  Many of the sub-screens have first time user instructions.  If you click on the instructions you can send them to yourself by clicking <b>the share button</b> on the top right side of the screen.   <b>To exit the screen</b> click the <b>arrow back button</b> on the top left side of the screen.   If you <b>click the house</b> – you will be brought back to the dashboard of the person’s profile. \n\n"));
    txtStep6.setText(Html.fromHtml("<b>The MENU bar.</b>  On the top left side of the dashboard screen are three parallel lines. This is the Menu bar.  If you click it  - you will see a dropdown menu.  There is lots of good information in this section.  I already explained how to use “All Profiles”.   For example “Resources” contains Advance Care Directives Information, Helpful MYLO Forms and Templates and interesting Podcasts and Videos. You should have a look in each of the topics. <b>To Return to the Menu bar</b> click the MENU bar. \n\n"));
    txtStep7.setText(Html.fromHtml("<b>LET’S GET STARTED.</b>   I like to populate a profile by starting with the Personal and Medical section, then Specialty, then Notes and Routine Appointments, then Advance Care Directives, then Insurance and lastly Prescriptions.   But that’s me – you should do it however you feel most comfortable.   Make me happy…. Click the green box – Personal & Medical  Profile & Emergency Contacts. \n\n"));
    txtStep8.setText(Html.fromHtml("Remember you can always find the instructions for the section by clicking the question mark on the top right side of the screen. \n\n"));

    relStep222.setVisibility(View.GONE);
    relStep22.setVisibility(View.GONE);
    relStep55.setVisibility(View.GONE);
    relStep555.setVisibility(View.GONE);

    //   UI = Html.fromHtml("<b>Welcome to MYLO</b> –  This App allows you to maintain a digital library of critical documents and medical information for you and your loved ones. There are 6 main sections. The App provides unlimited profiles, pdf reports, email and fax functionality, and the ability to share profiles and eliminate the need to re-enter data. \n\n <b>Getting Started</b> - Before you begin we would like to explain the data entry process. Except for this Profiles page, each screen has a top bar which includes the name of the screen, an arrow back button on the top left, three dots on the top right (which allows you to view or email the data), and a save button on data entry screens. \n\n\n\nFirst time Users will see First Time User Instructions directly on the screen. After adding information. the User can access User Instructions by clicking on the three buttons. A User Guide is also available from the dropdown Menu located on the top left of the Profiles page. \n\n <b>A reminder to all Users</b> - MYLO is a native to your phone. This means that we do not have access to your information. If you forget the name and email address used for this app then the data will be lost. It’s important that you  remember this information and to periodically back up the and or send yourself the pdf reports. Backup instructions are included on the Menu page.\n\n <b>MYLO Would Like to Access Your Contacts and MYLO Would Like to Access Your Camera</b> - This message does NOT mean that the company has access to your information, it simply allows the APP to utilise the functions of your phone and provide the USER with a better experience. \n\n <b>Adding a Profile</b> - click the plus box. You will see two options. Create New and Import from Dropbox. \n\n <b>Option 1</b> : Create New. You will be brought to the Add Profile  Screen. You can type in the new profile or if the person is in your Contacts then click the gray bar on the top right side of your screen to load information. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).\n\n <b>Option 2</b> : Import from Dropbox. Using this feature you can upload a profile from Dropbox. If you click that option, you will be provided additional instructions. Once completed click either Save (top right of screen) or Add Profile (bottom of screen). \n\n There are <b>three</b> required elements to create a Profile –  <b>name, relationship</b>, and an <b>email</b> address.\n\n <b>To Share a Profile –</b> Long press on the Profile Box and you will be able to upload the Profile to your Dropbox account.\n\n <b>To Delete a Profile –</b> Long Press on the Profile Box.\n\nThanks & Regards").toString();
    UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;MYLO is intuitive and very easy to use.  Each box represents a section of information that is most often needed during a medical event or crisis. MYLO allows Users to organize this information  in a nice easy fashion.  Within each box are sub-sections. Use as much or as little of the App as you want or need.  Come back to a section to add or edit information.  <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp;PDF Reports, Email, Faxing, Printing.  We created reports for each section that can be viewed, emailed or printed. Sub-sections can also be viewed,  emailed or printed and in some cased faxed.  Faxing should only be used in a medical emergency and only for HIPAA purposes.  <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp; Let’s Practice - Click on any box.   Within each section are 3 or 4 subsections. Each section generally works the same way.   As you fill in the information remember to click SAVE on the top right side of the screen.  We added  quite a few dropdown menus to make data entry more simple.   <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp;The little green circle with the three dots is on every screen toward the bottom of the screen.  Click it and you will see that it allows you to view, email or fax a Report. <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp; Instructions.  Many of the sub-screens have first time user instructions.  If you click on the instructions you can send them to yourself by clicking the share button on the top right side of the screen.   To exit the screen click the arrow back button on the top left side of the screen.   If you click the house – you will be brought back to the dashboard of the person’s profile. <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp;The MENU bar.  On the top left side of the dashboard screen are three parallel lines. This is the Menu bar.  If you click it  - you will see a dropdown menu.  There is lots of good information in this section.  I already explained how to use “All Profiles”.   For example “Resources” contains Advance Care Directives Information, Helpful MYLO Forms and Templates and interesting Podcasts and Videos. You should have a look in each of the topics. To Return to the Menu bar click the MENU bar. <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp; LET’S GET STARTED.   I like to populate a profile by starting with the Personal and Medical section, then Specialty, then Notes and Routine Appointments, then Advance Care Directives, then Insurance and lastly Prescriptions.   But that’s me – you should do it however you feel most comfortable.   Make me happy…. Click the green box – Personal & Medical  Profile & Emergency Contacts. <br>" +
            "<br>&nbsp;&nbsp;&nbsp;&nbsp; Remember you can always find the instructions for the section by clicking the question mark on the top right side of the screen. <br>").toString();

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
                    showEmailDialog("Getting Started");
                }else if (From.equalsIgnoreCase("Dashboard")) {
                    showEmailDialog("Understanding the Dashboard");
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
