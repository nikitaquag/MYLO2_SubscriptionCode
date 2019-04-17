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

import com.google.android.gms.plus.Plus;
import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.utility.UIEmails;

public class InstructionActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout header;
    ImageView imgBack, imgPicture, txtEmail;
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

        RelativeLayout rel69 = findViewById(R.id.rel69);
        RelativeLayout rel71 = findViewById(R.id.rel71);
        RelativeLayout rel72 = findViewById(R.id.rel72);
        RelativeLayout rel73 = findViewById(R.id.rel73);

        TextView txtPolicy69 = findViewById(R.id.txtPolicy69);
        TextView txtPolicy71 = findViewById(R.id.txtPolicy71);
        TextView txtPolicy72 = findViewById(R.id.txtPolicy72);
        TextView txtPolicy73 = findViewById(R.id.txtPolicy73);

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
                        "<br>" +
                        "<b>1) Login: </b>" +
                        "<br>" +
                        "Click on <b>\"Login With DropBox\" </b>button, It will redirect you to dropbox site. Now you can login with your personal dropbox account." +
                        "<br>" +
                        "After logging in, To allow the access to the files and folders from your dropbox, Click the <b>'Allow'</b>  Button.So now you can Access your files." +
                        "<br>" +
                        "<b>2) Backup: </b>" +
                        "<br>" +
                        "If you have logged in to dropbox from application, It will show you Backup Options." +
                        "<br>" +
                        "On clicking  <b>'BACKUP'</b> button, you need to Click on <b>'Backup your Data'</b> button to store your profile." +
                        "<br>" +
                        "<b>3) Restore: </b>" +
                        "<br>" +
                        "If you have logged in to dropbox from application, It will show you Restore Options. It will help to restore profiles." +
                        "<br>" +
                        "On clicking  <b>'RESTORE'</b>  button, you will get list of zip files for download. On clicking any of the zip file, It will be downloaded and you will get a popup message  to unzip and restore file." +
                        "<br>" +
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
            case "PrescriptionUploadInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> a prescription click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The form is either sitting in your email, on your phone, or in your Dropbox account. Choose the location and click Add.\n" + "<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"));

                UI = Html.fromHtml("<br>To <b>add</b> a prescription click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>" +
                        "<br>:   The form is either sitting in your email, on your phone, or in your Dropbox account. Choose the location and click Add." + " <br>" +
                        "<br>To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>" +
                        "<br>To <b>delete</b> the entry swipe right to left the cell of the document.<br>" +
                        "<br>To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>" +
                        "<br>To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"
                ).toString();

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
                txtHeader.setText("Instructions for Prescription Upload");
                break;
            case "PrescriptionInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorPrescriptionGray));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> a Prescription click on Plus button at the bottom right of the screen. Once completed click SAVE at the top right corner of the screen.<br>"));
                txt62.setText(Html.fromHtml("To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen..<br>"));
                txt63.setText(Html.fromHtml("To <b>delete</b> the entry left swipe right to left the cell of your Prescription. This would bring up the delete button.<br>"));
                txt64.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"));


                UI = Html.fromHtml("<br>To <b>add</b> a Prescription click on Plus button at the bottom right of the screen. Once completed click SAVE at the top right corner of the screen.<br>" +
                        "<br>To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen..<br>" +
                        "<br>To <b>delete</b> the entry left swipe right to left the cell of your Prescription. This would bring up the delete button.<br>" +
                        "<br>To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"
                ).toString();
                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.GONE);
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
                img65.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);
                img66.setVisibility(View.GONE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);


                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Prescription Information");
                break;

            case "VitalInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorEventPink));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("This section allows Users to keep a running record of their vital signs.  Users choose which vital signs they want to store.  The summary page indicates the most popular BP, HR, and TEMP. <br>"));
                txt62.setText(Html.fromHtml("To add a vital sign click on the Plus button on the bottom right side of the screen. <br>"));
                txt63.setText(Html.fromHtml("To edit the Vital Signs click the the <b>green down arrow</b> on right of the entry. This will show the edit button, which can be clicked to edit the vital sign. To save your edits click the SAVE at the top right of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry left swipe right to left the cell of your appointment. This would bring up the delete button.<br>"));
                txt65.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"));

                UI = Html.fromHtml("<br>This section allows Users to keep a running record of their vital signs.  Users choose which vital signs they want to store.  The summary page indicates the most popular BP, HR, and TEMP. <br>" +
                        "<br>To add a vital sign click on the Plus button on the bottom right side of the screen.<br>" +
                        "<br>To edit the Vital Signs click the the <b>green down arrow</b> on right of the entry. This will show the edit button, which can be clicked to edit the vital sign. To save your edits click the SAVE at the top right of the screen.<br>" +
                        "<br>To <b>delete</b> the entry left swipe right to left the cell of your appointment. This would bring up the delete button.<br>" +
                        "<br>To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"
                ).toString();
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
                txtHeader.setText("Instructions for Vital Signs");
                break;

            case "FormInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> an insurance form click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The file is sitting in either your phone, Dropbox or as an email attachment.  Choose the location. If email attachment following the instructions. \n<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"));

                UI = Html.fromHtml("<br>To <b>add</b> an insurance form click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>" +
                        "<br>The file is sitting in either your phone, Dropbox or as an email attachment.  Choose the location. If email attachment following the instructions. \n<br>" +
                        "<br>To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>" +
                        "<br>To <b>delete</b> the entry swipe right to left the cell of the document.<br>" +
                        "<br>To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>" +
                        "<br>To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"
                ).toString();

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
                txtHeader.setText("Instructions for Insurance Forms");
                break;
            case "CardInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To get started click the <b>Plus</b> button at the bottom right corner of the screen.<br>"));
                txt62.setText(Html.fromHtml("To <b>add</b> information add the <b>Provider name</b> and <b>Type of Insurance</b> and click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt63.setText(Html.fromHtml("To take a picture of your insurance card (front and back). Click the <b>ADD CARD</b> button. It is recommended that you hold your phone horizontal when taking a picture of the card.<br>"));
                txt64.setText(Html.fromHtml("To <b>save</b> your information click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b/> information click cell of the added card. To <b>save</b> your edits click the <b>SAVE</b> again.<br>"));
                txt66.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the card.<br>"));
                txt67.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"));

                UI = Html.fromHtml("<br>To get started click the <b>Plus</b> button at the bottom right corner of the screen.<br>" +
                        "<br>To <b>add</b> information add the <b>Provider name</b> and <b>Type of Insurance</b> and click the <b>SAVE</b> on the top right side of the screen.<br>" +
                        "<br>To take a picture of your insurance card (front and back). Click the <b>ADD CARD</b> button. It is recommended that you hold your phone horizontal when taking a picture of the card.<br>" +
                        "<br>To <b>save</b> your information click the <b>SAVE</b> on the top right side of the screen.<br>" +
                        "<br>To <b>edit</b/> information click cell of the added card. To <b>save</b> your edits click the <b>SAVE</b> again.<br>" +
                        "<br>To <b>delete</b> the entry swipe right to left the cell of the card.<br>" +
                        "<br>To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"

                ).toString();

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
                txtHeader.setText("Instructions for Insurance Cards");
                break;

            case "InsuranceInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"));
                txt65.setText(Html.fromHtml("To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"));
                txt67.setText(Html.fromHtml("To <b>add</b> a picture click on the <b>PROFILE PHOTO</b> button and either take a photo or grab one from your gallery. To edit or delete the picture click the pencil.<br>"));
                txt68.setText(Html.fromHtml("Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.<br>"));

                UI = Html.fromHtml("<br>To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>" +
                        "<br>To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>" +
                        "<br>To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>" +
                        "<br>To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>" +
                        "<br>To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>" +
                        "<br>To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>" +
                        "<br>To <b>add</b> a picture click on the <b>PROFILE PHOTO</b> button and either take a photo or grab one from your gallery. To edit or delete the picture click the pencil. <br>"+
                        "<br>Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.<br>"

                ).toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.VISIBLE);
                rel622.setVisibility(View.GONE);

                //shradha
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                img67.setVisibility(View.VISIBLE);
                img68.setVisibility(View.VISIBLE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Insurance Information");
                break;

            case "AdvanceInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorDirectiveRed));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);


                txt61.setText(Html.fromHtml("To <b>add</b> a document click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The document is either sitting in your email, on your phone, or your Dropbox account.<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To view the document or to email or fax it, click the three dots on the bottom right side of the screen.<br>"));
                txt67.setText(Html.fromHtml("Currently the only documents that can be uploaded are pdf’s.  We are working on other formats such as excel, word, txt, jpg, video.\n<br>"));
                UI = Html.fromHtml("<br>To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>" +
                        "<br>The document is either sitting in your email, on your phone, or your Dropbox account. <br>" +
                        "<br>To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>" +
                        "<br>To <b>delete</b> the entry swipe right to left the cell of the document.<br>" +
                        "<br>To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>" +
                        "<br>To view the document or to email or fax it, click the three dots on the bottom right side of the screen.<br>"+
                        "<br>Currently the only documents that can be uploaded are pdf’s.  We are working on other formats such as excel, word, txt, jpg, video.<br>"

                ).toString();


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
                txtHeader.setText("Instructions for Advance Directives");
                break;

            case "OtherInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorDirectiveRed));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("To <b>add</b> a document click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"));
                txt67.setText(Html.fromHtml("Currently the only documents that can be uploaded are pdf’s.  We are working on other formats such as excel, word, txt, jpg, video.\n<br>"));
                UI = Html.fromHtml("<br>To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>" +
                        "<br>The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>" +
                        "<br>To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>" +
                        "<br>To <b>delete</b> the entry swipe right to left the cell of the document.<br>" +
                        "<br>To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>" +
                        "<br>To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"+
                        "<br>Currently the only documents that can be uploaded are pdf’s.  We are working on other formats such as excel, word, txt, jpg, video.<br>"

                ).toString();


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
                txtHeader.setText("Instructions for Other Documents");

                break;

            case "MedicalInfoInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorDirectiveRed));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("To <b>add</b> a document click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"));
                txt67.setText(Html.fromHtml("Currently the only documents that can be uploaded are pdf’s.  We are working on other formats such as excel, word, txt, jpg, video.\n<br>"));
                UI = Html.fromHtml("<br>To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>" +
                        "<br>The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>" +
                        "<br>To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>" +
                        "<br>To <b>delete</b> the entry swipe right to left the cell of the document.<br>" +
                        "<br>To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>" +
                        "<br>To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"+
                        "<br>Currently the only documents that can be uploaded are pdf’s.  We are working on other formats such as excel, word, txt, jpg, video.<br>"

                ).toString();


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
                txtHeader.setText("Instructions for Medical Records");

                break;
            case "LivingInstruction":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt62.setText(Html.fromHtml("To <b>edit</b> information simply change the data and then your edits by clicking on the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt63.setText(Html.fromHtml("To <b>view</b> or <b>email</b> the data in each section click on the three dots on the top right side of the screen.<br>"));

                UI = Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br> To <b>edit</b> information simply change the data and then your edits by clicking on the <b>SAVE</b> on the top right side of the screen.<br> To <b>view</b> or <b>email</b> the data in each section click on the three dots on the top right side of the screen.<br> Thanks & Regards").toString();


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
                txt61.setText(Html.fromHtml("This section allows Users to create a master list of routine appointments and jot down when each appointment took place. Users can keep a history of their appointments. What’s also nice is that the summary page will show you the last time you saw the doctor or had a particular medical test.   <br>"));
                txt62.setText(Html.fromHtml("To <b>add</b> an Appointment click on <b>Plus</b> button at the bottom right of the screen. Choose a Specialist or Test, add the name of your doctor and frequency of appointment. Once completed click the <b>SAVE</b> button at the top right corner of the screen..<br>"));
                txt63.setText(Html.fromHtml("To <b>edit</b> the Appointment click the the <b>green down arrow</b> on right of the appointment. This will show the edit button, which can be clicked to edit the appointment. Once completed click the <b>SAVE</b> button at the top right corner of the screen. To <b>delete</b> the appointment swipe right to left and click the garbage can.<br>"));
                txt64.setText(Html.fromHtml("To add the completed date(s) click the the <b>green down arrow</b> on right of the appointment and click <b>ADD NEW</b>.The information will automatically be saved.  Click the up arrow to close the cell. <br>"));
                txt65.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"));

                UI = Html.fromHtml("<br>This section allows Users to create a master list of routine appointments and jot down when each appointment took place. Users can keep a history of their appointments. What’s also nice is that the summary page will show you the last time you saw the doctor or had a particular medical test.   <br>" +
                        "<br>To <b>add</b> an Appointment click on <b>Plus</b> button at the bottom right of the screen. Choose a Specialist or Test, add the name of your doctor and frequency of appointment. Once completed click the <b>SAVE</b> button at the top right corner of the screen..<br>" +
                        "<br>To <b>edit</b> the Appointment click the the <b>green down arrow</b> on right of the appointment. This will show the edit button, which can be clicked to edit the appointment. Once completed click the <b>SAVE</b> button at the top right corner of the screen. To <b>delete</b> the appointment swipe right to left and click the garbage can.<br>" +
                        "<br>To add the completed date(s) click the the <b>green down arrow</b> on right of the appointment and click <b>ADD NEW</b>.The information will automatically be saved.  Click the up arrow to close the cell. <br>" +
                        "<br>To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"
                ).toString();

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
                txtHeader.setText("Instructions for Appointment Checklist");
                break;
            case "EventNotesInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorEventPink));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> a note click on <b>Plus</b> button at the bottom right of the screen. Start typing your note. The date and time of the note will automatically be saved. Once completed click <b>SAVE</b>. The note is automatically saved.<br>"));
                txt62.setText(Html.fromHtml("To <b>edit</b> the note click the <b>green down arrow</b> on the right of the note." +
                        "You will see the ”EDIT NOTE” function.  Click ”EDIT NOTE” and type your changes." +
                        " To save your edits click SAVE at the top right of the screen.<br>"));
                txt63.setText(Html.fromHtml("To <b>delete</b> the entry left swipe right to left the cell of your note.  You will see the delete symbol – click it.  You will be asked if you are sure you want to delete the record. <br>"));
                txt64.setText(Html.fromHtml("To <b>view</b> a report or email the section <b>click the three dots</b> on the bottom left side of the screen. <br>"));

                UI = Html.fromHtml("<br>To <b>add</b> a note click on <b>Plus</b> button at the bottom right of the screen. Start typing your note. The date and time of the note will automatically be saved. Once completed click <b>SAVE</b>. The note is automatically saved.<br>" +
                        "<br>To <b>edit</b> the note click the <b>green down arrow</b> on the right of the note." +
                        "You will see the ”EDIT NOTE” function.  Click ”EDIT NOTE” and type your changes." +
                        " To save your edits click SAVE at the top right of the screen.<br>" +
                        "<br>To <b>delete</b> the entry left swipe right to left the cell of your note.  You will see the delete symbol – click it.  You will be asked if you are sure you want to delete the record. <br>" +
                        "<br>To <b>view</b> a report or email the section <b>click the three dots</b> on the bottom left side of the screen. <br>"
                ).toString();
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
                txtHeader.setText("Instructions for Event Notes");
                break;
            case "PharmacyInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("First time user instructions are available when you first click into the section and are also available by clicking the <b>question mark</b> on the top right side of the screen. \n<br>"));
                txt62.setText(Html.fromHtml("<b>To add information</b> click the <b>Plus button</b> on the bottom right corner of the screen.  If the doctor or health care professional is in your contacts click the <b>Add from Contacts</b> option.\n<br>"));
                txt63.setText(Html.fromHtml("<b>To save information in this section</b> you need to include the name and phone number.  Don’t forget to add the type of number (fax, home, mobile, office). <br>"));
                txt64.setText(Html.fromHtml("Some of the questions are free text and <b>some have dropdown menus</b>. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>"));
                txt65.setText(Html.fromHtml("<b>Profile Photo:</b> If you want <b>to add a “profile photo”</b> click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  <b>To delete or edit a photo</b> click the little pencil and follow the instructions. \n<br>"));
                txt66.setText(Html.fromHtml("<b>Adding a Card and sharing it:</b>   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo <b>click Use Photo</b>.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>"));
                txt67.setText(Html.fromHtml("<b>To save information</b> click SAVE on the top right side of the screen. You will be brought to the <b>Summary Page</b>.  \n<br>"));
                txt68.setText(Html.fromHtml("<b>To edit information</b> click the cell of the added contact. Make changes and then <b>click SAVE</b> on the top right side of the screen. \n<br>"));
                txtPolicy69.setText(Html.fromHtml("<b>To make an automated phone call</b> click the <b>phone button</b> on the cell of your contact. \n<br>"));
                txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>First time user instructions are available when you first click into the section and are also available by clicking the question mark on the top right side of the screen. \n<br>" +
                        "<br>To add information click the Plus button on the bottom right corner of the screen.  If the doctor or health care professional is in your contacts click the Add from Contacts option.\n<br>" +
                        "<br>To save information in this section you need to include the name and phone number.  Don’t forget to add the type of number (fax, home, mobile, office). <br>" +
                        "<br>Some of the questions are free text and some have dropdown menus. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>" +
                        "<br>Profile Photo: If you want to add a “profile photo” click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  To delete or edit a photo click the little pencil and follow the instructions. \n<br>" +
                        "<br>Adding a Card and sharing it:   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo click Use Photo.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>" +
                        "<br>To save information click SAVE on the top right side of the screen. You will be brought to the Summary Page.  \n<br>" +
                        "<br>To edit information click the cell of the added contact. Make changes and then click SAVE on the top right side of the screen. \n<br>" +
                        "<br>To make an automated phone call click the phone button on the cell of your contact. \n<br>" +
                        "<br>To delete the entire entry left swipe right to left the cell of your contact start from the right side of the cell. \n<br>" +
                        "<br>To view a report or to email the data click the green circle with the three dots located on the left side of the screen. \n<br>"+
                        "<br> To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard. \n<br>").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.VISIBLE);
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
                img68.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                rel69.setVisibility(View.VISIBLE);
                rel71.setVisibility(View.VISIBLE);
                rel72.setVisibility(View.VISIBLE);
                rel73.setVisibility(View.VISIBLE);


                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Pharmacies & Home Medical Equipment");
                break;

            case "FinanceInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("First time user instructions are available when you first click into the section and are also available by clicking the <b>question mark</b> on the top right side of the screen. \n<br>"));
                txt62.setText(Html.fromHtml("<b>To add information</b> click the <b>Plus button</b> on the bottom right corner of the screen.  If the doctor or health care professional is in your contacts click the <b>Add from Contacts</b> option.\n<br>"));
                txt63.setText(Html.fromHtml("<b>To save information in this section</b> you need to include the include category, firm name and phone number.  Don’t forget to add the type of number (fax, home, mobile, office). <br>"));
                txt64.setText(Html.fromHtml("Some of the questions are free text and <b>some have dropdown menus</b>. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>"));
                txt65.setText(Html.fromHtml("<b>Profile Photo:</b> If you want <b>to add a “profile photo”</b> click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  <b>To delete or edit a photo</b> click the little pencil and follow the instructions. \n<br>"));
                txt66.setText(Html.fromHtml("<b>Adding a Card and sharing it:</b>   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo <b>click Use Photo</b>.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>"));
                txt67.setText(Html.fromHtml("<b>To save information</b> click SAVE on the top right side of the screen. You will be brought to the <b>Summary Page</b>.  \n<br>"));
                txt68.setText(Html.fromHtml("<b>To edit information</b> click the cell of the added contact. Make changes and then <b>click SAVE</b> on the top right side of the screen. \n<br>"));
                txtPolicy69.setText(Html.fromHtml("<b>To make an automated phone call</b> click the <b>phone button</b> on the cell of your contact. \n<br>"));
                txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>First time user instructions are available when you first click into the section and are also available by clicking the question mark on the top right side of the screen. \n<br>" +
                        "<br>To add information click the Plus button on the bottom right corner of the screen.  If the doctor or health care professional is in your contacts click the Add from Contacts option.\n<br>" +
                        "<br>To save information in this section you need to include the include category, firm name and phone number.  Don’t forget to add the type of number (fax, home, mobile, office). <br>" +
                        "<br>Some of the questions are free text and some have dropdown menus. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>" +
                        "<br>Profile Photo: If you want to add a “profile photo” click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  To delete or edit a photo click the little pencil and follow the instructions. \n<br>" +
                        "<br>Adding a Card and sharing it:   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo click Use Photo.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>" +
                        "<br>To save information click SAVE on the top right side of the screen. You will be brought to the Summary Page.  \n<br>" +
                        "<br>To edit information click the cell of the added contact. Make changes and then click SAVE on the top right side of the screen. \n<br>" +
                        "<br>To make an automated phone call click the phone button on the cell of your contact. \n<br>" +
                        "<br>To delete the entire entry left swipe right to left the cell of your contact start from the right side of the cell. \n<br>" +
                        "<br>To view a report or to email the data click the green circle with the three dots located on the left side of the screen. \n<br>"+
                        "<br> To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard. \n<br>").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.VISIBLE);
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
                img68.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                rel69.setVisibility(View.VISIBLE);
                rel71.setVisibility(View.VISIBLE);
                rel72.setVisibility(View.VISIBLE);
                rel73.setVisibility(View.VISIBLE);
                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Finance, Legal, Other");
                break;
            case "HospitalInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("First time user instructions are available when you first click into the section and are also available by clicking the <b>question mark</b> on the top right side of the screen. \n<br>"));
                txt62.setText(Html.fromHtml("<b>To add information</b> click the <b>Plus button</b> on the bottom right corner of the screen.  If the hospital, rehab or home care agency is in your contacts click the <b>Add from Contacts</b> option.\n<br>"));
                txt63.setText(Html.fromHtml("<b>The minimum amount of information</b> you need to complete this section is the hospital, rehab or home care agency’s  name, specialty, and phone number. Don’t forget to add the <b>type of number</b> (fax, home, mobile, office).   \n<br>"));
                txt64.setText(Html.fromHtml("Some of the questions are free text and <b>some have dropdown menus</b>. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>"));
                txt65.setText(Html.fromHtml("<b>Profile Photo:</b> If you want <b>to add a “profile photo”</b> click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  <b>To delete or edit a photo</b> click the little pencil and follow the instructions. \n<br>"));
                txt66.setText(Html.fromHtml("<b>Adding a Card and sharing it:</b>   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo <b>click Use Photo</b>.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>"));
                txt67.setText(Html.fromHtml("<b>To save information</b> click SAVE on the top right side of the screen. You will be brought to the <b>Summary Page</b>.  \n<br>"));
                txt68.setText(Html.fromHtml("<b>To edit information</b> click the cell of the added contact. Make changes and then <b>click SAVE</b> on the top right side of the screen. \n<br>"));
                txtPolicy69.setText(Html.fromHtml("<b>To make an automated phone call</b> click the <b>phone button</b> on the cell of your contact. \n<br>"));
                txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>First time user instructions are available when you first click into the section and are also available by clicking the question mark on the top right side of the screen. \n<br>" +
                        "<br>To add information click the Plus button on the bottom right corner of the screen.  If the doctor or health care professional is in your contacts click the Add from Contacts option.\n<br>" +
                        "<br>The minimum amount of information you need to complete this section is the hospital, rehab or home care agency’s name, specialty, and phone number. Don’t forget to add the type of number (fax, home, mobile, office).  \n<br>" +
                        "<br>Some of the questions are free text and some have dropdown menus. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>" +
                        "<br>Profile Photo: If you want to add a “profile photo” click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  To delete or edit a photo click the little pencil and follow the instructions. \n<br>" +
                        "<br>Adding a Card and sharing it:   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo click Use Photo.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>" +
                        "<br>To save information click SAVE on the top right side of the screen. You will be brought to the Summary Page.  \n<br>" +
                        "<br>To edit information click the cell of the added contact. Make changes and then click SAVE on the top right side of the screen. \n<br>" +
                        "<br>To make an automated phone call click the phone button on the cell of your contact. \n<br>" +
                        "<br>To delete the entire entry left swipe right to left the cell of your contact start from the right side of the cell. \n<br>" +
                        "<br>To view a report or to email the data click the green circle with the three dots located on the left side of the screen. \n<br>"+
                        "<br> To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard. \n<br>").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.VISIBLE);
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
                img68.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                rel69.setVisibility(View.VISIBLE);
                rel71.setVisibility(View.VISIBLE);
                rel72.setVisibility(View.VISIBLE);
                rel73.setVisibility(View.VISIBLE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Hospitals, Rehab \n and Home Care");
                break;

            case "DoctorInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("First time user instructions are available when you first click into the section and are also available by clicking the <b>question mark</b> on the top right side of the screen. \n<br>"));
                txt62.setText(Html.fromHtml("<b>To add information</b> click the <b>Plus button</b> on the bottom right corner of the screen.  If the doctor or health care professional is in your contacts click the <b>Add from Contacts</b> option.\n<br>"));
                txt63.setText(Html.fromHtml("<b>The minimum amount of information</b> you need to complete this section is the physician’s name, specialty, and phone number. Don’t forget to add the <b>type of number</b> (fax, home, mobile, office).   \n<br>"));
                txt64.setText(Html.fromHtml("Some of the questions are free text and <b>some have dropdown menus</b>. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>"));
                txt65.setText(Html.fromHtml("<b>Profile Photo:</b> If you want <b>to add a “profile photo”</b> click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  <b>To delete or edit a photo</b> click the little pencil and follow the instructions. \n<br>"));
                txt66.setText(Html.fromHtml("<b>Adding a Card and sharing it:</b>   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo <b>click Use Photo</b>.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>"));
                txt67.setText(Html.fromHtml("<b>To save information</b> click SAVE on the top right side of the screen. You will be brought to the <b>Summary Page</b>.  \n<br>"));
                txt68.setText(Html.fromHtml("<b>To edit information</b> click the cell of the added contact. Make changes and then <b>click SAVE</b> on the top right side of the screen. \n<br>"));
                txtPolicy69.setText(Html.fromHtml("<b>To make an automated phone call</b> click the <b>phone button</b> on the cell of your contact. \n<br>"));
                txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>First time user instructions are available when you first click into the section and are also available by clicking the question mark on the top right side of the screen. \n<br>" +
                        "<br>To add information click the Plus button on the bottom right corner of the screen.  If the doctor or health care professional is in your contacts click the Add from Contacts option.\n<br>" +
                        "<br>The minimum amount of information you need to complete this section is the physician’s name, specialty, and phone number. Don’t forget to add the type of number (fax, home, mobile, office).  \n<br>" +
                        "<br>Some of the questions are free text and some have dropdown menus. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>" +
                        "<br>Profile Photo: If you want to add a “profile photo” click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  To delete or edit a photo click the little pencil and follow the instructions. \n<br>" +
                        "<br>Adding a Card and sharing it:   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo click Use Photo.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>" +
                        "<br>To save information click SAVE on the top right side of the screen. You will be brought to the Summary Page.  \n<br>" +
                        "<br>To edit information click the cell of the added contact. Make changes and then click SAVE on the top right side of the screen. \n<br>" +
                        "<br>To make an automated phone call click the phone button on the cell of your contact. \n<br>" +
                        "<br>To delete the entire entry left swipe right to left the cell of your contact start from the right side of the cell. \n<br>" +
                        "<br>To view a report or to email the data click the green circle with the three dots located on the left side of the screen. \n<br>"+
                        "<br> To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard. \n<br>").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.VISIBLE);
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
                img68.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                rel69.setVisibility(View.VISIBLE);
                rel71.setVisibility(View.VISIBLE);
                rel72.setVisibility(View.VISIBLE);
                rel73.setVisibility(View.VISIBLE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Doctors & Other Health Care Professional");
                break;

            case "PhysicianInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorRegisteredGreen));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("First time user instructions are available when you first click into the section and are also available by clicking the <b>question mark</b> on the top right side of the screen. \n<br>"));
                txt62.setText(Html.fromHtml("<b>To add information</b> click the <b>Plus button</b> on the bottom right corner of the screen.  If the person is in your contacts click the <b>Add from Contacts</b> option.\n<br>"));
                txt63.setText(Html.fromHtml("<b>The minimum amount of information</b> you need to complete this section is the physician’s name, specialty, and phone number.  \n<br>"));
                txt64.setText(Html.fromHtml("Some of the questions are free text and <b>some have dropdown menus</b>. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>"));
                txt65.setText(Html.fromHtml("<b>Profile Photo:</b> If you want <b>to add a “profile photo”</b> click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  <b>To delete or edit a photo</b> click the little pencil and follow the instructions. \n<br>"));
                txt66.setText(Html.fromHtml("<b>Adding a Card and sharing it:</b>   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo <b>click Use Photo</b>.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>"));
                txt67.setText(Html.fromHtml("<b>To save information</b> click SAVE on the top right side of the screen. You will be brought to the <b>Summary Page</b>.  \n<br>"));
                txt68.setText(Html.fromHtml("<b>To edit information</b> click the cell of the added contact. Make changes and then <b>click SAVE</b> on the top right side of the screen. \n<br>"));
                txtPolicy69.setText(Html.fromHtml("<b>To make an automated phone call</b> click the <b>phone button</b> on the cell of your contact. \n<br>"));
                txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>First time user instructions are available when you first click into the section and are also available by clicking the question mark on the top right side of the screen. \n<br>" +
                        "<br>To add information click the Plus button on the bottom right corner of the screen.  If the person is in your contacts click the Add from Contacts option.\n<br>" +
                        "<br>The minimum amount of information you need to complete this section is the physician’s name, specialty, and phone number.  \n<br>" +
                        "<br>Some of the questions are free text and some have dropdown menus. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>" +
                        "<br>Profile Photo: If you want to add a “profile photo” click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  To delete or edit a photo click the little pencil and follow the instructions. \n<br>" +
                        "<br>Adding a Card and sharing it:   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo click Use Photo.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>" +
                        "<br>To save information click SAVE on the top right side of the screen. You will be brought to the Summary Page.  \n<br>" +
                        "<br>To edit information click the cell of the added contact. Make changes and then click SAVE on the top right side of the screen. \n<br>" +
                        "<br>To make an automated phone call click the phone button on the cell of your contact. \n<br>" +
                        "<br>To delete the entire entry left swipe right to left the cell of your contact start from the right side of the cell. \n<br>" +
                        "<br>To view a report or to email the data click the green circle with the three dots located on the left side of the screen. \n<br>"+
                        "<br> To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard. \n<br>").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.VISIBLE);
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
                img68.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                rel69.setVisibility(View.VISIBLE);
                rel71.setVisibility(View.VISIBLE);
                rel72.setVisibility(View.VISIBLE);
                rel73.setVisibility(View.VISIBLE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Primary Physician");
                break;
            case "EmergencyInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorRegisteredGreen));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
               /* txt61.setText(Html.fromHtml("To <b>add</b> information click the green <b>down arrow</b> button for each section. This would bring up the <b>Plus</b> button. Click the <b>Plus</b> button to start adding information for that section. <br>"));
                txt62.setText(Html.fromHtml("To store information click save on top right.<br>"));
                txt63.setText(Html.fromHtml("To edit information in a particular section click the picture of the pencil, click save to store your changes.<br>"));
                txt64.setText(Html.fromHtml("To delete the information in a particular section click the garbage can. For sections without the garbage can, simple delete the information.<br>"));
                txt65.setText(Html.fromHtml("To view or to email a report, click the three dots on the bottom right side of the screen.<br>"));
*/
                txt61.setText(Html.fromHtml("First time user instructions are available when you first click into the section and are also available by clicking the <b>question mark</b> on the top right side of the screen. \n<br>"));
                txt62.setText(Html.fromHtml("<b>To add information</b> click the <b>Plus button</b> on the bottom right corner of the screen.  If the person is in your contacts click the <b>Add from Contacts</b> option.\n<br>"));
                txt63.setText(Html.fromHtml("<b>The minimum amount of information</b> you need to complete this section is the person’s name, the relationship to the person, the priority and a phone number. \n<br>"));
                txt64.setText(Html.fromHtml("Some of the questions are free text and <b>some have dropdown menus</b>. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>"));
                txt65.setText(Html.fromHtml("<b>Profile Photo:</b> If you want <b>to add a “profile photo”</b> click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  <b>To delete or edit a photo</b> click the little pencil and follow the instructions. \n<br>"));
                txt66.setText(Html.fromHtml("<b>Adding a Card and sharing it:</b>   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo <b>click Use Photo</b>.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>"));
                txt67.setText(Html.fromHtml("<b>To save information</b> click SAVE on the top right side of the screen. You will be brought to the <b>Summary Page</b>.  \n<br>"));
                txt68.setText(Html.fromHtml("<b>To edit information</b> click the cell of the added contact. Make changes and then <b>click SAVE</b> on the top right side of the screen. \n<br>"));
                txtPolicy69.setText(Html.fromHtml("<b>To make an automated phone call</b> click the <b>phone button</b> on the cell of your contact. \n<br>"));
                txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>First time user instructions are available when you first click into the section and are also available by clicking the question mark on the top right side of the screen. \n<br>" +
                        "<br>To add information click the Plus button on the bottom right corner of the screen.  If the person is in your contacts click the Add from Contacts option.\n<br>" +
                        "<br>The minimum amount of information you need to complete this section is the person’s name, the relationship to the person, the priority and a phone number. \n<br>" +
                        "<br>Some of the questions are free text and some have dropdown menus. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>" +
                        "<br>Profile Photo: If you want to add a “profile photo” click the photo of the camera in the little circle, a message will appear – “Take Picture or Gallery”.  If you choose gallery your photos will pop up, pick a picture you like and click choose.   If you want to take a picture you camera will open up – take the picture and click use photo.  To delete or edit a photo click the little pencil and follow the instructions. \n<br>" +
                        "<br>Adding a Card and sharing it:   You can easily add a business card if you want to include additional information. Click the pencil and take a picture of the card. If you like the photo click Use Photo.  If you  click on the  picture another screen appears and allows you to share the card in a number of ways.  To edit the card click the pencil and follow the directions on the screen.\n<br>" +
                        "<br>To save information click SAVE on the top right side of the screen. You will be brought to the Summary Page.  \n<br>" +
                        "<br>To edit information click the cell of the added contact. Make changes and then click SAVE on the top right side of the screen. \n<br>" +
                        "<br>To make an automated phone call click the phone button on the cell of your contact. \n<br>" +
                        "<br>To delete the entire entry left swipe right to left the cell of your contact start from the right side of the cell. \n<br>" +
                        "<br>To view a report or to email the data click the green circle with the three dots located on the left side of the screen. \n<br>"+
                        "<br> To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard. \n<br>").toString();


                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.VISIBLE);
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
                img68.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);
                rel69.setVisibility(View.VISIBLE);
                rel71.setVisibility(View.VISIBLE);
                rel72.setVisibility(View.VISIBLE);
                rel73.setVisibility(View.VISIBLE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Emergency Contacts and Health Care Proxy Agent");
                break;
            case "ConnectionInstuction":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);
                //shradha
                txt61.setText(Html.fromHtml("<b>Welcome to MYLO -</b> This App allows you to maintain a digital library of critical documents and medical information for you and your loved ones. There are 6 main sections. The App provides unlimited profiles, pdf reports, email and fax functionality, and the ability to share profiles and eliminate the need to re-enter data.<br>"));
                txt62.setText(Html.fromHtml("<b>Getting Started -</b> Before you begin we would like to explain the data entry process. Except for this Profiles page, each screen has a top bar which includes the name of the screen, an arrow back button on the top left, three dots on the top right (which allows you to view or email the data), and a save button on data entry screens.<br>First time Users will see First Time User Instructions directly on the screen. After adding information. the User can access User Instructions by clicking on the three buttons. A User Guide is also available from the dropdown Menu located on the top left of the Profiles page.<br>"));
                txt622.setText(Html.fromHtml("<br>"));
                txt63.setText(Html.fromHtml("<br><b>A reminder to all Users -</b> MYLO is a native to your phone. This means that we do not have access to your information. If you forget the name and email address used for this app then the data will be lost. It’s important that you  remember this information and to periodically back up the and or send yourself the pdf reports. Backup instructions are included on the Menu page.<br>"));
                txt64.setText(Html.fromHtml("<b>MYLO Would Like to Access Your Contacts and MYLO Would Like to Access Your Camera -</b>This message does NOT mean that the company has access to your information, it simply allows the APP to utilise the functions of your phone and provide the USER with a better experience.<br>"));
                txt65.setText(Html.fromHtml("<b>Adding a Profile - </b>click the plus box. You will see two options. Create New and Import from Dropbox." + "<br> <b>Option 1 : Create New.</b> You will be brought to the Add Profile  Screen. You can type in the new profile or if the person is in your Contacts then click the gray bar on the top right side of your screen to load information. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).<br> <b>Option 2 : Import from Dropbox.</b> Using this feature you can upload a profile from Dropbox. If you click that option, you will be provided additional instructions. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).<br>"));
                txt66.setText(Html.fromHtml("There are <b>three</b> required elements to create a Profile –  <b>name, relationship</b>, and an <b>email</b> address.<br>"));
                txt67.setText(Html.fromHtml("<b>To Share a Profile –</b> Long press on the Profile Box and you will be able to upload the Profile to your Dropbox account.<br>"));
                txt68.setText(Html.fromHtml("<b>To Delete a Profile –</b> Long Press on the Profile Box.<br>Thanks & Regards"));

                UI = Html.fromHtml("<br><b>Welcome to MYLO -</b> This App allows you to maintain a digital library of critical documents and medical information for you and your loved ones. There are 6 main sections. The App provides unlimited profiles, pdf reports, email and fax functionality, and the ability to share profiles and eliminate the need to re-enter data.<br>" +
                        "<br><b>Getting Started -</b> Before you begin we would like to explain the data entry process. Except for this Profiles page, each screen has a top bar which includes the name of the screen, an arrow back button on the top left, three dots on the top right (which allows you to view or email the data), and a save button on data entry screens.<br>First time Users will see First Time User Instructions directly on the screen. After adding information. the User can access User Instructions by clicking on the three buttons. A User Guide is also available from the dropdown Menu located on the top left of the Profiles page.<br>" +
                        "<br>" +
                        "<br><br><b>A reminder to all Users -</b> MYLO is a native to your phone. This means that we do not have access to your information. If you forget the name and email address used for this app then the data will be lost. It’s important that you  remember this information and to periodically back up the and or send yourself the pdf reports. Backup instructions are included on the Menu page.<br>" +
                        "<br><b>MYLO Would Like to Access Your Contacts and MYLO Would Like to Access Your Camera -</b>This message does NOT mean that the company has access to your information, it simply allows the APP to utilise the functions of your phone and provide the USER with a better experience.<br>" +
                        "<br><b>Adding a Profile - </b>click the plus box. You will see two options. Create New and Import from Dropbox." + "<br> <b>Option 1 : Create New.</b> You will be brought to the Add Profile  Screen. You can type in the new profile or if the person is in your Contacts then click the gray bar on the top right side of your screen to load information. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).<br> <b>Option 2 : Import from Dropbox.</b> Using this feature you can upload a profile from Dropbox. If you click that option, you will be provided additional instructions. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).<br>" +
                        "<br>There are <b>three</b> required elements to create a Profile –  <b>name, relationship</b>, and an <b>email</b> address.<br>" +
                        "<br><b>To Share a Profile –</b> Long press on the Profile Box and you will be able to upload the Profile to your Dropbox account.<br>" +
                        "<br><b>To Delete a Profile –</b> Long Press on the Profile Box.<br>").toString();

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
                txtHeader.setText("Instructions for Profile");
                break;
            case "Personal":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);
//                String msgs = "To <b>add</b> information type responses.<br>" +
//                        "To <b>save</b> information click the check mark" +
//                        " on the <b>top right</b> side of the screen.<br>" +
//                        "To <b>edit</b> or <b>delete</b> information simply work on the screen and then save your edits by clicking on the <b>check mark</b> on the <b>top right</b> side of the screen." +
//                        "<br>" +
//                        "To <b>view a report</b> or to <b>email</b> or <b>fax</b> the data in each section click the <b>three dots</b> on the top right side of the screen.";
//
//                txtMsg.setText(Html.fromHtml(msgs));

                //nikita
                txt61.setText(Html.fromHtml("Minimum Info Needed. Name, Relationship, Email. <br>"));
                txt62.setText(Html.fromHtml("Free Text and Dropdown Menus. Dropdown menus are identified\n" +
                        "by the little grey arrow to the right of the line. Click anywhere on\n" +
                        "the line and the dropdown menu will open.<br>"));
                txt63.setText(Html.fromHtml("Save. Click the SAVE button on the top right corner of the screen.\n" +
                        "Users should click save after every few entries. <br>"));
                txt64.setText(Html.fromHtml("Profile Photo. To add a Photo click anywhere in the circle and\n" +
                        "choose ”take picture” or “gallery” then click SAVE. To edit or\n" +
                        "delete the photo click the pencil. <br>"));
                txt65.setText(Html.fromHtml("Reports. Users can view and email reports containing the data input by clicking the green circle with 3 white dots found on the bottom of the screen.  Fax capability has been included for certain sections and is only to be used to meet HIPAA requirements.\n<br>"));
                txt66.setText(Html.fromHtml("Exiting the subsection. To return to the prior screen click the\n" +
                        "back arrow button on the top left corner of the screen. To return\n" +
                        "to the dashboard click the picture of the house on the top left\n" +
                        "corner of the screen.<br>"));

                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                                "<br>"+txt63.getText().toString()+"<br>" +
                                "<br>"+txt64.getText().toString()+"<br>" +
                                "<br>"+txt65.getText().toString()+"<br>" +
                                "<br>"+txt66.getText().toString()+"<br>"
                        ).toString();

                //nikita
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
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
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.GONE);
                img68.setVisibility(View.GONE);
                img622.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Personal Profile");
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
//                        "<br>" +
//                        "To <b>save</b> information click the <b>check mark</b>" +
//                        " on the top right side of the screen." +
//                        "<br>" +
//                        "To <b>edit</b> information in a particular section click the picture of the <b>pencil</b>. To save your edits click the green bar at the lower half of the screen." +
//                        "<br>" +
//                        "To <b>delete</b> information in a particular section click the <b>garbage can</b>. For sections without the garbage can, simply delete the data." +
//                        "<br>" +
//                        "To <b>view a report</b> or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the top right side of the screen.";
//
//                txtMsg.setText(Html.fromHtml(msgd));

                //shradha
                txt61.setText(Html.fromHtml("This section consists of a series of questions most often asked by a physician or an emergency room about a particular person.\n <br>"));
                txt62.setText(Html.fromHtml("<b>Accessing each Section:</b>   Click the <b>green down arrow</b>; then click the <b>+ sign.</b>\n" +
                        "Some of the questions are free text and <b>some have dropdown menus.</b> If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>"));
                txt63.setText(Html.fromHtml("<b>Save:</b>   Click the <b>SAVE</b> button on the top right side after you complete each section. \n<br>"));
                txt64.setText(Html.fromHtml("<b>To add more information</b> in a particular section <b>click the +sign.</b>\n<br>"));
                txt65.setText(Html.fromHtml("<b>To edit or delete information</b> click the picture of the <b>pencil or garbage can.</b>\n<br>"));
                txt66.setText(Html.fromHtml("<b>To close the section</b> click the <b>green up arrow</b> on the right side of the section. \n<br>"));
                txt67.setText(Html.fromHtml("<b>To View a Report or Email the report</b> click the <b>green circle</b> on the bottom right of the screen. \n<br>"));
                txt68.setText(Html.fromHtml("<b>To Exit the Sub-Section</b> click the arrow back button on the top left side of the screen.</b> If you click the picture of the house you will be brought back to the Dashboard. \n<br>"));

                UI = Html.fromHtml("<br>This section consists of a series of questions most often asked by a physician or an emergency room about a particular person.\n<br>" +
                        "<br>Accessing each Section:   Click the green down arrow; then click the + sign.\n" +
                        "Some of the questions are free text and some have dropdown menus. If you see a little grey mark on the right side of the screen – then there is a dropdown menu. Click anywhere on that line to open the dropdown menu. We have included an “other” as the last option on the menu – if you click “other” a text box will open and you can fill in the information you need. \n<br>" +
                        "<br>Save:   Click the SAVE button on the top right side after you complete each section. \n<br>" +
                        "<br>To add more information in a particular section click the +sign.\n<br>" +
                        "<br>To edit or delete information click the picture of the pencil or garbage can.\n<br>" +
                        "<br>To close the section click the green up arrow on the right side of the section. \n<br>" +
                        "<br>To View a Report or Email the report click the green circle on the bottom right of the screen. \n<br>" +
                        "<br>To Exit the Sub-Section click the arrow back button on the top left side of the screen. If you click the picture of the house you will be brought back to the Dashboard. \n<br>"
                ).toString();
                //shradha
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
                txt68.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                rel622.setVisibility(View.GONE);


                //nikita
                img61.setVisibility(View.VISIBLE);
                img62.setVisibility(View.VISIBLE);
                img63.setVisibility(View.VISIBLE);
                img64.setVisibility(View.VISIBLE);
                img65.setVisibility(View.VISIBLE);
                img66.setVisibility(View.VISIBLE);
                img67.setVisibility(View.VISIBLE);
                img68.setVisibility(View.VISIBLE);
                img622.setVisibility(View.GONE);


                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Medical Profile");
                break;

            case "Living":
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);
//                String msgl = "To <b>save</b> information click the check mark" +
//                        " on the top right side of the screen." +
//                        "<br>" +
//                        "To <b>edit</b> information simply change the data and then save your edits by clicking on the check mark on the top right side of the screen." +
//                        "<br>" +
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
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("You can <b>add</b> the card from both the sides i.e <b>front and back</b>."));
                txt62.setText(Html.fromHtml("For adding front and back card, You need to click on the <b>plus</b> icon. Now you can add picture of card either from <b>Camera or Gallery</b>."));
                txt63.setText(Html.fromHtml("For adding card through <b>camera</b>, It is <b>recommended</b> that you hold your phone <b>horizontal</b> while taking a picture of a card."));
                txt64.setText(Html.fromHtml("To <b>view</b> the card <b>click</b> on the <b>card</b>, So you can <b>view</b> card and see by <b>zooming</b> it. To <b>share card</b> to your loved ones click the <b>share</b> icon on the top right side of the screen."));


                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>"

                ).toString();

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
                txtHeader.setText("Instructions for Insurance Card GuideLines");
                /*header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);
                String msgc = "You can <b>add</b> the card from both the sides i.e <b>front and back</b>." +
                        "<br>" +
                        "For adding front and back card, You need to click on the <b>plus</b> icon. Now you can add picture of card either from <b>Camera or Gallery</b>." +
                        "<br>" +
                        "For adding card through <b>camera</b>, It is <b>recommended</b> that you hold your phone <b>horizontal</b> while taking a picture of a card." +
                        "<br>" +
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

                txtHeader.setText("Insurance Card GuideLines");*/
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
                alert.setTitle("Share ?");
                alert.setMessage("Do you want to share dropbox instructions ?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String msg = "This is a method for personal cloud storage. It is commonly referred to as a method to backup one's files online. In addition to store the files, one can also share them with colleagues and friends, all using Dropbox. To store, retrieve and manage your files, one can use a Dropbox application." +
                                "<br>" +
                                "You need to login with your dropbox account. If you don't  have dropbox account, You need to have one. " +
                                "<br>" +
                                "<b>Guidelines:</b>" +
                                "<br>" +
                                "<b>1) Login: </b>" +
                                "<br>" +
                                "Click on <b>\"Login With DropBox\" </b>button, It will redirect you to dropbox site. Now you can login with your personal dropbox account." +
                                "<br>" +
                                "After logging in, To allow the access to the files and folders from your dropbox, Click the <b>'Allow'</b>  Button.So now you can Access your files." +
                                "<br>" +
                                "<b>2) Backup: </b>" +
                                "<br>" +
                                "If you have logged in to dropbox from application, It will show you Backup Options." +
                                "<br>" +
                                "On clicking  <b>'BACKUP'</b> button, you need to Click on <b>'Backup your Data'</b> button to store your profile." +
                                "<br>" +
                                "<b>3) Restore: </b>" +
                                "<br>" +
                                "If you have logged in to dropbox from application, It will show you Restore Options. It will help to restore profiles." +
                                "<br>" +
                                "On clicking  <b>'RESTORE'</b>  button, you will get list of zip files for download. On clicking any of the zip file, It will be downloaded and you will get a popup message  to unzip and restore file." +
                                "<br>" +
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
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Prescription Information", UI);
                } else if (From.equals("PrescriptionUploadInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Prescription Upload", UI);
                } else if (From.equals("EventNotesInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Event Notes", UI);
                } else if (From.equals("CheckListInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Appointment Checklist", UI);
                } else if (From.equals("VitalInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Vital Signs", UI);
                } else if (From.equals("LivingInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Activity of daily living", UI);
                } else if (From.equals("InsuranceInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Insurance Information", UI);
                } else if (From.equals("CardInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Insurance Cards", UI);
                } else if (From.equals("FormInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Insurance Forms", UI);
                } else if (From.equals("DoctorInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Doctors & Other Health Care Professional", UI);
                } else if (From.equals("HospitalInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Hospitals, Rehab and Home Care", UI);
                } else if (From.equals("PharmacyInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Pharmacies & Home Medical Equipment", UI);
                } else if (From.equals("FinanceInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Finance, Legal, Other ", UI);
                } else if (From.equals("Personal")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Personal Profile", UI);
                } else if (From.equals("Medical")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Medical Profile", UI);
                } else if (From.equals("PhysicianInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Primary Physician", UI);
                } else if (From.equals("EmergencyInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Emergency Contacts and Health Care Proxy Agent", UI);
                } else if (From.equals("OtherInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Other Documents", UI);
                } else if (From.equals("MedicalInfoInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Medical Records", UI);
                } else if (From.equals("Card")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Insurance Card GuideLines", UI);
                } else if (From.equals("AdvanceInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Advance Directives", UI);
                }else {
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
