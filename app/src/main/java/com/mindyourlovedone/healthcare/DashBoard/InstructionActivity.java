package com.mindyourlovedone.healthcare.DashBoard;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.utility.UIEmails;

public class InstructionActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout header;
    ImageView imgBack, imgPicture,txtEmail;
    TextView txtHeader, txtTitle, txtMsg;
    String From;
    ImageView imgDot;
    Context context = this;
    String UI = "";
    UIEmails ui = new UIEmails();
    FloatingActionButton floatProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);


        initUI();
        initListener();
    }

    private void initListener() {
        txtEmail.setOnClickListener(this);
        floatProfile.setOnClickListener(this);
    }

    private void initUI() {
        //shradha
        floatProfile = findViewById(R.id.floatProfile);
        final RelativeLayout relMsg = findViewById(R.id.relMsg);
        TextView txt61 = findViewById(R.id.txtPolicy61);
        TextView txt62 = findViewById(R.id.txtPolicy62);
        TextView txt622 = findViewById(R.id.txtPolicy622);
        TextView txt63 = findViewById(R.id.txtPolicy63);
        TextView txt64 = findViewById(R.id.txtPolicy64);
        TextView txt65 = findViewById(R.id.txtPolicy65);
        TextView txt66 = findViewById(R.id.txtPolicy66);
        TextView txt67 = findViewById(R.id.txtPolicy67);
        TextView txt68 = findViewById(R.id.txtPolicy68);

        ImageView img61 = findViewById(R.id.img61);
        ImageView img62 = findViewById(R.id.img62);
        ImageView img622 = findViewById(R.id.img622);
        ImageView img63 = findViewById(R.id.img63);
        ImageView img64 = findViewById(R.id.img64);
        ImageView img65 = findViewById(R.id.img65);
        ImageView img66 = findViewById(R.id.img66);
        ImageView img67 = findViewById(R.id.img67);
        ImageView img68 = findViewById(R.id.img68);

        RelativeLayout rel622 = findViewById(R.id.rel622);

        header = findViewById(R.id.header);
        imgBack = findViewById(R.id.imgBack);
        imgPicture = findViewById(R.id.imgPicture);
        txtHeader = findViewById(R.id.txtHeader);
        txtTitle = findViewById(R.id.txtTitle);
        txtEmail = findViewById(R.id.txtEmail);
        txtMsg = findViewById(R.id.txtMsg);
        imgDot = findViewById(R.id.imgDot);
        Intent i = getIntent();
        if (i.getExtras() != null) {
            From = i.getExtras().getString("From");
        }
        switch (From) {

            case "Dropbox":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.VISIBLE);

                //nikita
                String msgg = "<b>Guidelines:</b>" +
                        "<br><br>" +
                        "<b>1) Login: </b>" +
                        "<br>" +
                        "Click on <b>\"Login With DropBox\" </b>button, It will redirect you to dropbox site. Now you can login with your personal dropbox account." +
                        "<br>" +
                        "After logging in, To allow the access to the files and folders from your dropbox, Click the <b>'Allow'</b>  Button.So now you can Access your files." +
                        "<br><br>" +
                        "<b>2) Backup: </b>" +
                        "<br>" +
                        "If you have logged in to dropbox from application, It will show you Backup Options." +
                        "<br>" +
                        "On clicking  <b>'BACKUP'</b> button, you need to Click on <b>'Backup your Data'</b> button to store your profile." +
                        "<br><br>" +
                        "<b>3) Restore: </b>" +
                        "<br>" +
                        "If you have logged in to dropbox from application, It will show you Restore Options. It will help to restore profiles." +
                        "<br>" +
                        "On clicking  <b>'RESTORE'</b>  button, you will get list of zip files for download. On clicking any of the zip file, It will be downloaded and you will get a popup message  to unzip and restore file." +
                        "<br><br>" +
                        "<b>4) Get Files: </b>" +
                        "<br>" +
                        "If you have logged in to dropbox from application, It will show you View Files Options. It will help you to get the documents in Advance Directive section  from dropbox storage." +
                        "<br>" +
                        "On clicking <b>'VIEW FILES'</b> button, you will get list of documents files for download. On clicking any of the document  file, It will be downloaded ." +
                        "<br>" +
                        "Now you can add this document  to your application by clicking on <b>'ADD FILES'</b> button.";
                //nikita
                txt61.setText(Html.fromHtml("This is a method for personal cloud storage. It is commonly referred to as a method to backup one's files online. In addition to store the files, one can also share them with colleagues and friends, all using Dropbox. To store, retrieve and manage your files, one can use a Dropbox application."));
                txt62.setText(Html.fromHtml("You need to login with your dropbox account. If you don't  have dropbox account, You need to have one. "));
                txt63.setText(Html.fromHtml(msgg));

                //nikita
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                txt64.setVisibility(View.GONE);
                txt65.setVisibility(View.GONE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //nikita
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                img64.setVisibility(View.GONE);
                img65.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);

                txtHeader.setText("Dropbox");
                break;

            case "PrescriptionInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorPrescriptionGray));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the grey bar at the bottom of the screen Add Prescription.\n\n"));
                txt62.setText(Html.fromHtml("To save  information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the arrow symbol on the right side of the screen and make changes.Save by clicking the <b>SAVE</b> again.\n\n"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry, left swipe the arrow symbol on the right side of the screen.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data click the three dots on the top right side of the screen.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the grey bar at the bottom of the screen Add Prescription.\n\n To save  information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information click the arrow symbol on the right side of the screen and make changes.Save by clicking the <b>SAVE</b> again.\n\n To <b>delete</b> the entry, left swipe the arrow symbol on the right side of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data click the three dots on the top right side of the screen.\n\n Thanks & Regards").toString();

                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);


                txtTitle.setText("User Instructions");
                txtHeader.setText("Create Prescription Tracker");
                break;

            case "VitalInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorEventPink));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the grey bar at the bottom of the screen Add Prescription.\n\n"));
                txt62.setText(Html.fromHtml("To save  information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the arrow symbol on the right side of the screen and make changes.Save by clicking the <b>SAVE</b> again.\n\n"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry, left swipe the arrow symbol on the right side of the screen.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data click the three dots on the top right side of the screen.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the grey bar at the bottom of the screen Add Prescription.\n\n To save  information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information click the arrow symbol on the right side of the screen and make changes.Save by clicking the <b>SAVE</b> again.\n\n To <b>delete</b> the entry, left swipe the arrow symbol on the right side of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data click the three dots on the top right side of the screen.\n\n Thanks & Regards").toString();

                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);


                txtTitle.setText("User Instructions");
                txtHeader.setText("Vital Signs");
                break;

            case "FormInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the bar at the bottom of the screen. Click the add sign to Select the File.\n\n"));
                txt62.setText(Html.fromHtml("The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.\n\n"));
                txt63.setText(Html.fromHtml("If Dropbox click on the file, then click the <b>save</b> on upper right side of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>load an email attachment</b>, open attachment from your email, and click the forward button on upper right side of the screen.Scroll through the Apps until you find MYLO. Click MYLO - then click the Profile you wish to attach the document to, then click the subsection the document pertains to and click OK. Enter additional data, then  click <b>Save</b>\n\n"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits click the <b>SAVE</b> again.\n\n"));
                txt66.setText(Html.fromHtml("To <b>delete</b> the entry swipe the arrow symbol on the <b>right side</b> of the screen.\n\n"));
                txt67.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the upper right side of the screen\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the bar at the bottom of the screen. Click the add sign to Select the File.\n\n The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.\n\n If Dropbox click on the file, then click the <b>save</b> on upper right side of the screen.\n\n To <b>load an email attachment</b>, open attachment from your email, and click the forward button on upper right side of the screen.Scroll through the Apps until you find MYLO. Click MYLO - then click the Profile you wish to attach the document to, then click the subsection the document pertains to and click OK. Enter additional data, then  click <b>Save</b>\n\n To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits click the <b>SAVE</b> again.\n\n To <b>delete</b> the entry swipe the arrow symbol on the <b>right side</b> of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the upper right side of the screen\n\n Thanks & Regards").toString();

                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.VISIBLE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Insurance Form");
                break;
            case "CardInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>get started</b> click the bar at the bottom of the screen Add Insurance Card.\n\n"));
                txt62.setText(Html.fromHtml("To <b>add</b> information add the Provider name and Type of Insurance and click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>take a picture</b> of your insurance card (front and back). Click the <b>add box</b>. It is recommended that you hold your phone horizontal when taking a picture of the card.\n\n"));
                txt64.setText(Html.fromHtml("To <b>save</b> your information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits click the <b>SAVE</b> again.\n\n"));
                txt66.setText(Html.fromHtml("To <b>delete</b> the entry swipe the arrow symbol on the <b>right side</b> of the screen.\n\n"));
                txt67.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the upper right side of the screen\n\n"));

                UI = Html.fromHtml("To <b>get started</b> click the bar at the bottom of the screen Add Insurance Card.\n\n To <b>add</b> information add the Provider name and Type of Insurance and click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>take a picture</b> of your insurance card (front and back). Click the <b>add box</b>. It is recommended that you hold your phone horizontal when taking a picture of the card.\n\n To <b>save</b> your information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits click the <b>SAVE</b> again.\n\n To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits click the <b>SAVE</b> again.\n\n To <b>delete</b> the entry swipe the arrow symbol on the <b>right side</b> of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the upper right side of the screen\n\n Thanks & Regards").toString();

                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.VISIBLE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Insurance Card");
                break;

            case "InsuranceInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the SAVE on the top right side of the screen. If the Person or company is in your <b>Contacts</b> click the gray bar on the top right side of your screen.\n\n"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the <b>picture</b> of the <b>pencil</b>. To save your edits click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on <b>right side</b> of the screen.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the upper right side of the screen.\n\n"));
                txt66.setText(Html.fromHtml("To <b>add a picture</b> click on the <b>picture</b> of the <b>pencil</b> and either take a photo or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the SAVE on the top right side of the screen. If the Person or company is in your <b>Contacts</b> click the gray bar on the top right side of your screen.\n\n To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information click the <b>picture</b> of the <b>pencil</b>. To save your edits click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on <b>right side</b> of the screen.\n\n To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the upper right side of the screen.\n\n To <b>add a picture</b> click on the <b>picture</b> of the <b>pencil</b> and either take a photo or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Insurance Information");
                break;

            case "AdvanceInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorDirectiveRed));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> a document click the red bar at the bottom of the screen. Click the <b>plus</b> symbol to select the file.\n\n"));
                txt62.setText(Html.fromHtml("The file is either sitting in your File Manager or Dropbox or in your email as an attachment.\n\n"));
                txt63.setText(Html.fromHtml("If Dropbox click on file, then complete screen. When completed click <b>save</b> on the upper right of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>load an email attachment</b>,open attachment from your email, and click the forward button on the upper right side of the screen. Scroll through the Apps until you find MYLO. Click MYLO - then click the Profile you wish to attach the document to, then click the subsection the document pertains to and click OK.Enter additional data,then click <b>Save</b>.\n\n"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click the picture of the pencil. When finished making your changes click <b>save</b>\n\n"));
                txt66.setText(Html.fromHtml("To <b>delete</b> the entry swipe the green arrow from right to left.\n\n"));
                txt67.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or to fax the data in each section click on the three dots on the upper right side of the screen.\n\n"));

                UI = Html.fromHtml("To <b>add</b> a document click the red bar at the bottom of the screen. Click the <b>plus</b> symbol to select the file.\n\n The file is either sitting in your File Manager or Dropbox or in your email as an attachment.\n\n If Dropbox click on file, then complete screen. When completed click <b>save</b> on the upper right of the screen.\n\n To <b>load an email attachment</b>,open attachment from your email, and click the forward button on the upper right side of the screen. Scroll through the Apps until you find MYLO. Click MYLO - then click the Profile you wish to attach the document to, then click the subsection the document pertains to and click OK.Enter additional data,then click <b>Save</b>.\n\n To <b>edit</b> information click the picture of the pencil. When finished making your changes click <b>save</b>\n\n To <b>delete</b> the entry swipe the green arrow from right to left.\n\n To <b>view</b>a report or to <b>email</b> or to fax the data in each section click on the three dots on the upper right side of the screen.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Advance Directives");
                break;

            case "OtherInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorDirectiveRed));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> a document click the red bar at the bottom of the screen. Click the <b>plus</b> symbol to select the file.\n\n"));
                txt62.setText(Html.fromHtml("The file is either sitting in your File Manager or Dropbox or in your email as an attachment.\n\n"));
                txt63.setText(Html.fromHtml("If Dropbox click on file, then complete screen. When completed click <b>save</b> on the upper right of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>load an email attachment</b>,open attachment from your email, and click the forward button on the upper right side of the screen. Scroll through the Apps until you find MYLO. Click MYLO - then click the Profile you wish to attach the document to, then click the subsection the document pertains to and click OK.Enter additional data,then click <b>Save</b>.\n\n"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click the picture of the pencil. When finished making your changes click <b>save</b>\n\n"));
                txt66.setText(Html.fromHtml("To <b>delete</b> the entry swipe the green arrow from right to left.\n\n"));
                txt67.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or to fax the data in each section click on the three dots on the upper right side of the screen.\n\n"));

                UI = Html.fromHtml("To <b>add</b> a document click the red bar at the bottom of the screen. Click the <b>plus</b> symbol to select the file.\n\n The file is either sitting in your File Manager or Dropbox or in your email as an attachment.\n\n If Dropbox click on file, then complete screen. When completed click <b>save</b> on the upper right of the screen.\n\n To <b>load an email attachment</b>,open attachment from your email, and click the forward button on the upper right side of the screen. Scroll through the Apps until you find MYLO. Click MYLO - then click the Profile you wish to attach the document to, then click the subsection the document pertains to and click OK.Enter additional data,then click <b>Save</b>.\n\n To <b>edit</b> information click the picture of the pencil. When finished making your changes click <b>save</b>\n\n To <b>delete</b> the entry swipe the green arrow from right to left.\n\n To <b>view</b>a report or to <b>email</b> or to fax the data in each section click on the three dots on the upper right side of the screen.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.VISIBLE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Other Documents");

                break;

            case "MedicalInfoInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorDirectiveRed));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> a document click the red bar at the bottom of the screen. Click the <b>plus</b> symbol to select the file.\n\n"));
                txt62.setText(Html.fromHtml("The file is either sitting in your File Manager or Dropbox or in your email as an attachment.\n\n"));
                txt63.setText(Html.fromHtml("If Dropbox click on file, then complete screen. When completed click <b>save</b> on the upper right of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>load an email attachment</b>,open attachment from your email, and click the forward button on the upper right side of the screen. Scroll through the Apps until you find MYLO. Click MYLO - then click the Profile you wish to attach the document to, then click the subsection the document pertains to and click OK.Enter additional data,then click <b>Save</b>.\n\n"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click the picture of the pencil. When finished making your changes click <b>save</b>\n\n"));
                txt66.setText(Html.fromHtml("To <b>delete</b> the entry swipe the green arrow from right to left.\n\n"));
                txt67.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or to fax the data in each section click on the three dots on the upper right side of the screen.\n\n"));

                UI = Html.fromHtml("To <b>add</b> a document click the red bar at the bottom of the screen. Click the <b>plus</b> symbol to select the file.\n\n The file is either sitting in your File Manager or Dropbox or in your email as an attachment.\n\n If Dropbox click on file, then complete screen. When completed click <b>save</b> on the upper right of the screen.\n\n To <b>load an email attachment</b>,open attachment from your email, and click the forward button on the upper right side of the screen. Scroll through the Apps until you find MYLO. Click MYLO - then click the Profile you wish to attach the document to, then click the subsection the document pertains to and click OK.Enter additional data,then click <b>Save</b>.\n\n To <b>edit</b> information click the picture of the pencil. When finished making your changes click <b>save</b>\n\n To <b>delete</b> the entry swipe the green arrow from right to left.\n\n To <b>view</b>a report or to <b>email</b> or to fax the data in each section click on the three dots on the upper right side of the screen.\n\n Thanks & Regards").toString();

                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.VISIBLE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Medical Information");

                break;
            case "LivingInstruction":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt62.setText(Html.fromHtml("To <b>edit</b> information simply change the data and then your edits by clicking on the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>view</b> or <b>email</b> the data in each section click on the three dots on the top right side of the screen.\n\n"));

                UI = Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information simply change the data and then your edits by clicking on the <b>SAVE</b> on the top right side of the screen.\n\n To <b>view</b> or <b>email</b> the data in each section click on the three dots on the top right side of the screen.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.GONE);
                txt65.setVisibility(View.GONE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.GONE);
                img65.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Activities of Daily Living");
                break;

            case "CheckListInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorEventPink));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("This <b>section</b> allows the User to create a master list of annual or reoccurring appointments. The purpose is to ensure appointments are made and not overlooked.\n\n"));
                txt62.setText(Html.fromHtml("To <b>add</b> an Appointment click on add button at the top right of the screen. Choose a Specialist or Type of Test, add the name of your doctor and frequency of appointment. Once completed <b>click SAVE</b> on the top right corner of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> the Appointment click the picture of the pencil to the right of the screen. To save your edits click the green bar marked Update Appointment. To <b>delete</b> the appointment swipe right to left and click the garbage can.\n\n"));
                txt64.setText(Html.fromHtml("To <b>add</b> the completed date(s) click Set Completion Date and click Add. \n\n"));
                txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data, in each section click the three dots on the upper right side of the screen.\n\n"));

                UI = Html.fromHtml("This <b>section</b> allows the User to create a master list of annual or reoccurring appointments. The purpose is to ensure appointments are made and not overlooked.\n\n To <b>add</b> an Appointment click on add button at the top right of the screen. Choose a Specialist or Type of Test, add the name of your doctor and frequency of appointment. Once completed <b>click SAVE</b> on the top right corner of the screen.\n\n To <b>edit</b> the Appointment click the picture of the pencil to the right of the screen. To save your edits click the green bar marked Update Appointment. To <b>delete</b> the appointment swipe right to left and click the garbage can.\n\n To <b>add</b> the completed date(s) click Set Completion Date and click Add. \n\n To <b>view a report</b> or to <b>email</b> the data, in each section click the three dots on the upper right side of the screen.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Maintain an Appointment Checklist");
                break;
            case "EventNotesInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorEventPink));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To add a note click on add button at the top right of the screen. Once completed click Add. The note is automatically saved.\n\n"));
                txt62.setText(Html.fromHtml("To <b>edit</b> the note click the picture of the pencil to the right of the screen. To save your edits click the <b>SAVE</b> at the top right of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>delete</b> the note click the garbage can at the bottom of the screen or <b>delete</b> the entry , left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data, click the three dots on the upper right side of the summary screen.\n\n"));

                UI = Html.fromHtml("To add a note click on add button at the top right of the screen. Once completed click Add. The note is automatically saved.\n\n To <b>edit</b> the note click the picture of the pencil to the right of the screen. To save your edits click the <b>SAVE</b> at the top right of the screen.\n\n To <b>delete</b> the note click the garbage can at the bottom of the screen or <b>delete</b> the entry , left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data, click the three dots on the upper right side of the summary screen.\n\n To <b>view a report</b> or to <b>email</b> the data, click the three dots on the upper right side of the summary screen.\n\n Thanks & Regards").toString();

                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.GONE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Event Note");
                break;
            case "PharmacyInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the entity is in your <b>Contacts</b> click the gray bar on the top right side of your screen to load data.\n\n"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n"));
                txt66.setText(Html.fromHtml("To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the entity is in your <b>Contacts</b> click the gray bar on the top right side of your screen to load data.\n\n To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n Thanks & Regards").toString();

                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Pharmacies and Home Medical Equipment");
                break;

            case "FinanceInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the person is in your <b>Contacts</b> click the gray bar on the top right side of your screen.\n\n"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n"));
                txt66.setText(Html.fromHtml("To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the person is in your <b>Contacts</b> click the gray bar on the top right side of your screen.\n\n To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Finance, Legal, Other");
                break;
            case "HospitalInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the entity is in your <b>Contacts</b> click the gray bar on the top right side of your screen to load the data.\n\n"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n"));
                txt66.setText(Html.fromHtml("To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the entity is in your <b>Contacts</b> click the gray bar on the top right side of your screen to load the data.\n\n To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Hospitals, Rehabilitation Centers, and Home Health Care Agencies");
                break;

            case "DoctorInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the person is in your <b>Contacts</b> click the gray bar on the top right side of your screen.\n\n"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n"));
                txt66.setText(Html.fromHtml("To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the person is in your <b>Contacts</b> click the gray bar on the top right side of your screen.\n\n To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n  To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Doctors & Other Health Care Professionals");
                break;

            case "PhysicianInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorRegisteredGreen));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the green bar at the bottom of the screen. If the entity is in your <b>Contacts</b> click the gray bar on the top right side of your screen to load data.\n\n"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To save your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n"));
                txt66.setText(Html.fromHtml("To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the green bar at the bottom of the screen. If the entity is in your <b>Contacts</b> click the gray bar on the top right side of your screen to load data.\n\n To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information click the picture of the <b>pencil</b>. To save your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Primary Physician");
                break;
            case "EmergencyInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorRegisteredGreen));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the green bar at the bottom of the screen. If the person is in your <b>Contacts</b> click the gray bar on the top right side of your screen.\n\n"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To save your edits click the <b>SAVE</b> on the top right side of the screen.\n\n"));
                txt64.setText(Html.fromHtml("To <b>make an automated phone call</b> or <b>delete</b> the entry left <b>swipe right to left</b> the arrow symbol on the right side.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click the green bar at the bottom of the screen. If the person is in your <b>Contacts</b> click the gray bar on the top right side of your screen.\n\n To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>edit</b> information click the picture of the <b>pencil</b>. To save your edits click the <b>SAVE</b> on the top right side of the screen.\n\n To <b>make an automated phone call</b> or <b>delete</b> the entry left <b>swipe right to left</b> the arrow symbol on the right side.\n\n To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Emergency Contacts and Health Care Proxy Agent");
                break;
            case "ConnectionInstuction":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);
                //shradha
                txt61.setText(Html.fromHtml("<b>Welcome to MYLO -</b> This App allows you to maintain a digital library of critical documents and medical information for you and your loved ones. There are 6 main sections. The App provides unlimited profiles, pdf reports, email and fax functionality, and the ability to share profiles and eliminate the need to re-enter data.\n\n"));
                txt62.setText(Html.fromHtml("<b>Getting Started -</b> Before you begin we would like to explain the data entry process. Except for this Profiles page, each screen has a top bar which includes the name of the screen, an arrow back button on the top left, three dots on the top right (which allows you to view or email the data), and a save button on data entry screens.\nFirst time Users will see First Time User Instructions directly on the screen. After adding information. the User can access User Instructions by clicking on the three buttons. A User Guide is also available from the dropdown Menu located on the top left of the Profiles page.\n\n"));
                txt622.setText(Html.fromHtml("\n\n"));
                txt63.setText(Html.fromHtml("\n\n<b>A reminder to all Users -</b> MYLO is a native to your phone. This means that we do not have access to your information. If you forget the name and email address used for this app then the data will be lost. It’s important that you  remember this information and to periodically back up the and or send yourself the pdf reports. Backup instructions are included on the Menu page.\n\n"));
                txt64.setText(Html.fromHtml("<b>MYLO Would Like to Access Your Contacts and MYLO Would Like to Access Your Camera -</b>This message does NOT mean that the company has access to your information, it simply allows the APP to utilise the functions of your phone and provide the USER with a better experience.\n\n"));
                txt65.setText(Html.fromHtml("<b>Adding a Profile - </b>click the plus box. You will see two options. Create New and Import from Dropbox." + "\n\n <b>Option 1 : Create New.</b> You will be brought to the Add Profile  Screen. You can type in the new profile or if the person is in your Contacts then click the gray bar on the top right side of your screen to load information. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).\n\n <b>Option 2 : Import from Dropbox.</b> Using this feature you can upload a profile from Dropbox. If you click that option, you will be provided additional instructions. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).\n\n"));
                txt66.setText(Html.fromHtml("There are <b>three</b> required elements to create a Profile –  <b>name, relationship</b>, and an <b>email</b> address.\n\n"));
                txt67.setText(Html.fromHtml("<b>To Share a Profile –</b> Long press on the Profile Box and you will be able to upload the Profile to your Dropbox account.\n\n"));
                txt68.setText(Html.fromHtml("<b>To Delete a Profile –</b> Long Press on the Profile Box.\n\nThanks & Regards"));

                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img622.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.VISIBLE);
                img68.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                // txtEmail.setText("Email");
                txtTitle.setText("User Instructions");
                txtHeader.setText("Profile");
                break;
            case "Personal":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);
//                String msgs = "To <b>add</b> information type responses.<br>" +
//                        "To <b>save</b> information click the check mark" +
//                        " on the <b>top right</b> side of the screen.<br><br>" +
//                        "To <b>edit</b> or <b>delete</b> information simply work on the screen and then save your edits by clicking on the <b>check mark</b> on the <b>top right</b> side of the screen." +
//                        "<br><br>" +
//                        "To <b>view a report</b> or to <b>email</b> or <b>fax</b> the data in each section click the <b>three dots</b> on the top right side of the screen.";
//
//                txtMsg.setText(Html.fromHtml(msgs));

                //nikita
                txt61.setText(Html.fromHtml("To <b>add</b> information - type responses or use dropdown"));
                txt62.setText(Html.fromHtml("To <b>save</b> information - click the check mark on the <b>top right</b> side of the screen."));
                txt63.setText(Html.fromHtml("To <b>edit</b> or <b>delete</b> information - make changes then save your edits by clicking <b>SAVE</b> on the <b>top right</b> of the screen."));
                txt64.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> - click the <b>three dots</b> on the top right side of the screen."));

                UI = Html.fromHtml("To <b>add</b> information - type responses or use dropdown.\n\n To <b>save</b> information - click the check mark on the <b>top right</b> side of the screen.\n\n To <b>edit</b> or <b>delete</b> information - make changes then save your edits by clicking <b>SAVE</b> on the <b>top right</b> of the screen.\n\n To <b>view a report</b> or to <b>email</b> - click the <b>three dots</b> on the top right side of the screen.\n\n Thanks & Regards").toString();


                //nikita
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                txt65.setVisibility(View.GONE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //nikita
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Personal Profile");
                break;


            //shradha
            case "SharePdf":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("You can<b>add</b> the pdf documents from storage."));
                txt62.setText(Html.fromHtml("To <b>use</b> pdf from the email attachments, you need to <b>download</b>it from the email then you can<b>add</b> it from storage's download folder."));

                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.GONE);
                txt64.setVisibility(View.GONE);
                txt65.setVisibility(View.GONE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);


                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.GONE);
                img64.setVisibility(View.GONE);
                img65.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);


                txtHeader.setText("Share Pdf Instructions");
                break;

            case "Medical":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);
//                String msgd = "To <b>add</b> information click the <b>plus box</b> for each section " +
//                        "and then click the green bar." +
//                        "<br><br>" +
//                        "To <b>save</b> information click the <b>check mark</b>" +
//                        " on the top right side of the screen." +
//                        "<br><br>" +
//                        "To <b>edit</b> information in a particular section click the picture of the <b>pencil</b>. To save your edits click the green bar at the lower half of the screen." +
//                        "<br><br>" +
//                        "To <b>delete</b> information in a particular section click the <b>garbage can</b>. For sections without the garbage can, simply delete the data." +
//                        "<br><br>" +
//                        "To <b>view a report</b> or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the top right side of the screen.";
//
//                txtMsg.setText(Html.fromHtml(msgd));

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click <b>add</b> for each section.\n\n"));
                txt62.setText(Html.fromHtml("To <b>store</b> information click <b>save</b> on top right.\n\n"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information in a particular section click the picture of the pencil, click <b>save</b> to store your changes.\n\n"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the information in a particular section click the <b>garbage can</b>. For sections without the garbage can, simple delete the information.\n\n"));
                txt65.setText(Html.fromHtml("To <b>view or to email a report</b>, click the three dots on the top right side of the screen.\n\n"));

                UI = Html.fromHtml("To <b>add</b> information click <b>add</b> for each section.\n\n To <b>store</b> information click <b>save</b> on top right.\n\n To <b>edit</b> information in a particular section click the picture of the pencil, click <b>save</b> to store your changes.\n\n To <b>delete</b> the information in a particular section click the <b>garbage can</b>. For sections without the garbage can, simple delete the information.\n\n To <b>view or to email a report</b>, click the three dots on the top right side of the screen.\n\n Thanks & Regards").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);


                //nikita
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);


                txtTitle.setText("User Instructions");
                txtHeader.setText("Medical Profile");
                break;

            case "Living":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);
//                String msgl = "To <b>save</b> information click the check mark" +
//                        " on the top right side of the screen." +
//                        "<br><br>" +
//                        "To <b>edit</b> information simply change the data and then save your edits by clicking on the check mark on the top right side of the screen." +
//                        "<br><br>" +
//                        "To <b>view</b>, <b>email</b>, or <b>fax</b> the data in each section click on the three dots on the top right side of the screen.";
//
//                txtMsg.setText(Html.fromHtml(msgl));

                //nikita
                txt61.setText(Html.fromHtml("To <b>save</b> information click the check mark on the top right side of the screen."));
                txt62.setText(Html.fromHtml("To <b>edit</b> information simply change the data and then save your edits by clicking on the check mark on the top right side of the screen."));
                txt63.setText(Html.fromHtml("To <b>view</b>, <b>email</b>, or <b>fax</b> the data in each section click on the three dots on the top right side of the screen."));

                //nikita
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.GONE);
                txt65.setVisibility(View.GONE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //nikita
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.GONE);
                img65.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtHeader.setText("Living Activity Instructions");
                break;

            case "Card":
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);
                String msgc = "You can <b>add</b> the card from both the sides i.e <b>front and back</b>." +
                        "<br><br>" +
                        "For adding front and back card, You need to click on the <b>plus</b> icon. Now you can add picture of card either from <b>Camera or Gallery</b>." +
                        "<br><br>" +
                        "For adding card through <b>camera</b>, It is <b>recommended</b> that you hold your phone <b>horizontal</b> while taking a picture of a card." +
                        "<br><br>" +
                        "To <b>view</b> the card <b>click</b> on the <b>card</b>, So you can <b>view</b> card and see by <b>zooming</b> it. To <b>share card</b> to your loved ones click the <b>share</b> icon on the top right side of the screen.";

                txtMsg.setText(Html.fromHtml(msgc));

                //nikita
                txt61.setText(Html.fromHtml("You can <b>add</b> the card from both the sides i.e <b>front and back</b>."));
                txt62.setText(Html.fromHtml("For adding front and back card, You need to click on the <b>plus</b> icon. Now you can add picture of card either from <b>Camera or Gallery</b>."));
                txt63.setText(Html.fromHtml("For adding card through <b>camera</b>, It is <b>recommended</b> that you hold your phone <b>horizontal</b> while taking a picture of a card."));
                txt64.setText(Html.fromHtml("To <b>view</b> the card <b>click</b> on the <b>card</b>, So you can <b>view</b> card and see by <b>zooming</b> it. To <b>share card</b> to your loved ones click the <b>share</b> icon on the top right side of the screen."));

                //nikita
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.GONE);
                txt66.setVisibility(View.GONE);
                txt67.setVisibility(View.GONE);
                txt68.setVisibility(View.GONE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);

                //nikita
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtHeader.setText("Insurance Card GuideLines");
                break;

        }
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(InstructionActivity.this);
                alert.setTitle("Email ?");
                alert.setMessage("Do you want to email dropbox instructions ?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String msg = "This is a method for personal cloud storage. It is commonly referred to as a method to backup one's files online. In addition to store the files, one can also share them with colleagues and friends, all using Dropbox. To store, retrieve and manage your files, one can use a Dropbox application." +
                                "<br><br>" +
                                "You need to login with your dropbox account. If you don't  have dropbox account, You need to have one. " +
                                "<br><br>" +
                                "<b>Guidelines:</b>" +
                                "<br><br>" +
                                "<b>1) Login: </b>" +
                                "<br>" +
                                "Click on <b>\"Login With DropBox\" </b>button, It will redirect you to dropbox site. Now you can login with your personal dropbox account." +
                                "<br>" +
                                "After logging in, To allow the access to the files and folders from your dropbox, Click the <b>'Allow'</b>  Button.So now you can Access your files." +
                                "<br><br>" +
                                "<b>2) Backup: </b>" +
                                "<br>" +
                                "If you have logged in to dropbox from application, It will show you Backup Options." +
                                "<br>" +
                                "On clicking  <b>'BACKUP'</b> button, you need to Click on <b>'Backup your Data'</b> button to store your profile." +
                                "<br><br>" +
                                "<b>3) Restore: </b>" +
                                "<br>" +
                                "If you have logged in to dropbox from application, It will show you Restore Options. It will help to restore profiles." +
                                "<br>" +
                                "On clicking  <b>'RESTORE'</b>  button, you will get list of zip files for download. On clicking any of the zip file, It will be downloaded and you will get a popup message  to unzip and restore file." +
                                "<br><br>" +
                                "<b>4) Get Files: </b>" +
                                "<br>" +
                                "If you have logged in to dropbox from application, It will show you View Files Options. It will help you to get the documents in Advance Directive section  from dropbox storage." +
                                "<br>" +
                                "On clicking <b>'VIEW FILES'</b> button, you will get list of documents files for download. On clicking any of the document  file, It will be downloaded ." +
                                "<br>" +
                                "Now you can add this document  to your application by clicking on <b>'ADD FILES'</b> button.";


                        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                        emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                                new String[]{""});
                        // String name= getString(PrefConstants.CONNECTED_NAME);
                        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                                "DropBox Instructions"); // subject
                        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(msg)); // Body
                        emailIntent.setType("application/email");
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                        dialog.dismiss();
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
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtEmail:
                showEmailDialog();
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

    private void showEmailDialog() {
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
                if (From.equals("PrescriptionInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("EventNotesInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("CheckListInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("LivingInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("InsuranceInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("CardInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("FormInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("DoctorInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("HospitalInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("PharmacyInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("FinanceInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("Personal")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("Medical")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("PhysicianInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("EmergencyInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("OtherInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("MedicalInfoInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else if (From.equals("AdvanceInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
                } else {
                    Toast.makeText(context, "Some thing went wrong Dude...!!", Toast.LENGTH_SHORT).show();
                }
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

/*
    private void showEmailDialog() {

    }
*/
}
