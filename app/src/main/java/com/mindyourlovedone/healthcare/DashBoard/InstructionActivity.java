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
                txt61.setText(Html.fromHtml("<b>Sub-section Purpose.</b> Users can keep a running record of their vital signs. Users choose which vital signs they want to store. The summary page includes the most popular BP, HR, and TEMP. "));
                txt62.setText(Html.fromHtml("<b>Data Entry.</b> Add a vital sign by clicking on the PLUS button on the bottom right side of the screen."));
                txt63.setText(Html.fromHtml("<b>Edit Function.</b> Edit the Vital Signs by clicking the green down ARROW on the right of the entry. This will show the edit button, click it to edit the vital sign. To save your edits click the SAVE at the top right of the screen."));
                txt64.setText(Html.fromHtml("<b>Delete Function.</b> To delete the entry left swipe (right to left) the summary cell. This will bring up the delete button."));
                txt65.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen."));

                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>" +
                        "<br>"+txt65.getText().toString()+"<br>"
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
                txt61.setText(Html.fromHtml("<b>Sub-Section Purpose.</b> Users are able to create a master list of routine appointments and the dates of completion.  The summary page contains the type of appointment and the last completion date."));
                txt62.setText(Html.fromHtml("<b>Data Entry.</b>  Add an Appointment by clicking on the PLUS button at the bottom right of the screen. Choose a Specialist or Test, add the name of your doctor and frequency of appointment. Once completed click the SAVE button at the top right corner of the screen."));
                txt63.setText(Html.fromHtml("<b>Completion Dates.</b> Add the Completed Date(s) by clicking the green down ARROW on the right of the appointment then click ADD NEW and enter the date.  The information will automatically be saved. Click the up ARROW to close the cell. "));
                txt64.setText(Html.fromHtml("<b>Edit Function.</b> Edit the Appointment by clicking the green down ARROW on the right of the appointment. You will see the edit button - click and edit the appointment. Once completed click the SAVE button at the top right corner of the screen. "));
                txt65.setText(Html.fromHtml("<b>Delete Function.</b> To delete the entry left swipe (right to left). You will see the delete symbol – click it. You will be asked if you are sure you want to delete the record. "));
                txt66.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen."));

                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>" +
                        "<br>"+txt65.getText().toString()+"<br>"+
                        "<br>"+txt66.getText().toString()+"<br>"
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
                txtHeader.setText("Instructions for Appointment Checklist");
                break;
            case "EventNotesInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorEventPink));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("<b>Data Entry.</b> To add a Note click on the PLUS button at the bottom right of the screen. Start typing your note. The date and time will automatically be created. Once completed click SAVE."));
                txt62.setText(Html.fromHtml("<b>Edit Function.</b> To edit the note click the green down arrow on the right of the note. You will see the ”EDIT NOTE” function. Click ”EDIT NOTE” and type your changes. To save your edits click SAVE at the top right of the screen."));
                txt63.setText(Html.fromHtml("<b>Delete Function.</b> To delete the entry left swipe (right to left) the cell of your note. You will see the delete symbol – click it. You will be asked if you are sure you want to delete the record."));
                txt64.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen."));

                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>"
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

                txt61.setText(Html.fromHtml("<b>User Instructions.</b>  First time user instructions are available when you initially click into the section. User instructions are always available by clicking the QUESTION MARK on the top right side of the screen.  To exit click the arrow back button on the top left side of the screen. To email the instructions click the share button on the top right side of the screen. To return to the dashboard, click the little house on the top left side of the screen."));
                txt62.setText(Html.fromHtml("<b>Data Entry.</b>  Data is entered via free text and dropdown menus. You may be able to use your phone’s microphone to add data verbally.  Dropdown menus are identified by the little grey arrow to the right of the line. Click anywhere on the line and the dropdown menu will open. For each dropdown menu we have included an “other” as the last option on the menu – if you click “other” a text box will open and you can add your information. Business cards can also be added."));
                txt63.setText(Html.fromHtml("<b>To Add Information.</b> Click the PLUS button on the bottom right corner of the screen. If the person is in your contacts click the option - Add from Contacts. The minimum amount of information you need to complete this section is the person’s name, the relationship to the person, the priority, and a phone number/type."));
                txt64.setText(Html.fromHtml("<b>Profile Photo:</b>  To add a Photo click anywhere in the circle, then click ”take picture” or “gallery” choose the photo then click SAVE. To edit or delete the photo click the pencil."));
                txt65.setText(Html.fromHtml("<b>Adding a Business Card.</b> The last entry on the screen allows the User to add a business card. Click ADD CARD or the blue pencil and further instructions will pop-up.  Click SAVE on the top right of the screen when you are done.  To forward the card, click on the card and click the share symbol on the top right of the screen. To edit the card click the pencil and follow the directions on the screen."));
                txt66.setText(Html.fromHtml("<b>Summary Screen.</b> MYLO provides Users with a summary screen.  To edit information click the cell of the contact. Make changes and then click SAVE on the top right side of the screen. When you click SAVE, Users will be brought back to the summary page. "));
                txt67.setText(Html.fromHtml("<b>Automated Phone Calls.</b>  From the summary screen, click the picture of the phone."));
                txt68.setText(Html.fromHtml("<b>To Delete an Entry.</b>  From the summary screen, identify the entry to delete, them left swipe (start from the right side of the cell, and swipe left)."));
                txtPolicy69.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen. Fax capability has been included in certain sections and should only be used to meet HIPAA requirements."));
                // txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                //txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                // txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>" +
                        "<br>"+txt65.getText().toString()+"<br>" +
                        "<br>"+txt66.getText().toString()+"<br>"+
                        "<br>"+txt67.getText().toString()+"<br>"+
                        "<br>"+txt68.getText().toString()+"<br>"+
                        "<br>"+txtPolicy69.getText().toString()+"<br>"
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
                // rel71.setVisibility(View.GONE);
                rel72.setVisibility(View.GONE);
                rel73.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Pharmacies & Home Medical Equipment");
                break;

            case "FinanceInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("<b>User Instructions.</b>  First time user instructions are available when you initially click into the section. User instructions are always available by clicking the QUESTION MARK on the top right side of the screen.  To exit click the arrow back button on the top left side of the screen. To email the instructions click the share button on the top right side of the screen. To return to the dashboard, click the little house on the top left side of the screen."));
                txt62.setText(Html.fromHtml("<b>Data Entry.</b>  Data is entered via free text and dropdown menus. You may be able to use your phone’s microphone to add data verbally.  Dropdown menus are identified by the little grey arrow to the right of the line. Click anywhere on the line and the dropdown menu will open. For each dropdown menu we have included an “other” as the last option on the menu – if you click “other” a text box will open and you can add your information. Business cards can also be added."));
                txt63.setText(Html.fromHtml("<b>To Add Information.</b> Click the PLUS button on the bottom right corner of the screen. If the person is in your contacts click the option - Add from Contacts. The minimum amount of information you need to complete this section is the person’s name, the relationship to the person, the priority, and a phone number/type."));
                txt64.setText(Html.fromHtml("<b>Profile Photo:</b>  To add a Photo click anywhere in the circle, then click ”take picture” or “gallery” choose the photo then click SAVE. To edit or delete the photo click the pencil."));
                txt65.setText(Html.fromHtml("<b>Adding a Business Card.</b> The last entry on the screen allows the User to add a business card. Click ADD CARD or the blue pencil and further instructions will pop-up.  Click SAVE on the top right of the screen when you are done.  To forward the card, click on the card and click the share symbol on the top right of the screen. To edit the card click the pencil and follow the directions on the screen."));
                txt66.setText(Html.fromHtml("<b>Summary Screen.</b> MYLO provides Users with a summary screen.  To edit information click the cell of the contact. Make changes and then click SAVE on the top right side of the screen. When you click SAVE, Users will be brought back to the summary page. "));
                txt67.setText(Html.fromHtml("<b>Automated Phone Calls.</b>  From the summary screen, click the picture of the phone."));
                txt68.setText(Html.fromHtml("<b>To Delete an Entry.</b>  From the summary screen, identify the entry to delete, them left swipe (start from the right side of the cell, and swipe left)."));
                txtPolicy69.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen. Fax capability has been included in certain sections and should only be used to meet HIPAA requirements."));
                // txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                //txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                // txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>" +
                        "<br>"+txt65.getText().toString()+"<br>" +
                        "<br>"+txt66.getText().toString()+"<br>"+
                        "<br>"+txt67.getText().toString()+"<br>"+
                        "<br>"+txt68.getText().toString()+"<br>"+
                        "<br>"+txtPolicy69.getText().toString()+"<br>"
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
                // rel71.setVisibility(View.GONE);
                rel72.setVisibility(View.GONE);
                rel73.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Finance, Legal, Other");
                break;
            case "HospitalInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("<b>User Instructions.</b>  First time user instructions are available when you initially click into the section. User instructions are always available by clicking the QUESTION MARK on the top right side of the screen.  To exit click the arrow back button on the top left side of the screen. To email the instructions click the share button on the top right side of the screen. To return to the dashboard, click the little house on the top left side of the screen."));
                txt62.setText(Html.fromHtml("<b>Data Entry.</b>  Data is entered via free text and dropdown menus. You may be able to use your phone’s microphone to add data verbally.  Dropdown menus are identified by the little grey arrow to the right of the line. Click anywhere on the line and the dropdown menu will open. For each dropdown menu we have included an “other” as the last option on the menu – if you click “other” a text box will open and you can add your information. Business cards can also be added."));
                txt63.setText(Html.fromHtml("<b>To Add Information.</b> Click the PLUS button on the bottom right corner of the screen. If the person is in your contacts click the option - Add from Contacts. The minimum amount of information you need to complete this section is the person’s name, the relationship to the person, the priority, and a phone number/type."));
                txt64.setText(Html.fromHtml("<b>Profile Photo:</b>  To add a Photo click anywhere in the circle, then click ”take picture” or “gallery” choose the photo then click SAVE. To edit or delete the photo click the pencil."));
                txt65.setText(Html.fromHtml("<b>Adding a Business Card.</b> The last entry on the screen allows the User to add a business card. Click ADD CARD or the blue pencil and further instructions will pop-up.  Click SAVE on the top right of the screen when you are done.  To forward the card, click on the card and click the share symbol on the top right of the screen. To edit the card click the pencil and follow the directions on the screen."));
                txt66.setText(Html.fromHtml("<b>Summary Screen.</b> MYLO provides Users with a summary screen.  To edit information click the cell of the contact. Make changes and then click SAVE on the top right side of the screen. When you click SAVE, Users will be brought back to the summary page. "));
                txt67.setText(Html.fromHtml("<b>Automated Phone Calls.</b>  From the summary screen, click the picture of the phone."));
                txt68.setText(Html.fromHtml("<b>To Delete an Entry.</b>  From the summary screen, identify the entry to delete, them left swipe (start from the right side of the cell, and swipe left)."));
                txtPolicy69.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen. Fax capability has been included in certain sections and should only be used to meet HIPAA requirements."));
                // txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                //txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                // txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>" +
                        "<br>"+txt65.getText().toString()+"<br>" +
                        "<br>"+txt66.getText().toString()+"<br>"+
                        "<br>"+txt67.getText().toString()+"<br>"+
                        "<br>"+txt68.getText().toString()+"<br>"+
                        "<br>"+txtPolicy69.getText().toString()+"<br>"
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
                // rel71.setVisibility(View.GONE);
                rel72.setVisibility(View.GONE);
                rel73.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Urgent Care, TeleMed, Hospitals, Rehab, Home Care");
                break;

            case "DoctorInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("<b>User Instructions.</b>  First time user instructions are available when you initially click into the section. User instructions are always available by clicking the QUESTION MARK on the top right side of the screen.  To exit click the arrow back button on the top left side of the screen. To email the instructions click the share button on the top right side of the screen. To return to the dashboard, click the little house on the top left side of the screen."));
                txt62.setText(Html.fromHtml("<b>Data Entry.</b>  Data is entered via free text and dropdown menus. You may be able to use your phone’s microphone to add data verbally.  Dropdown menus are identified by the little grey arrow to the right of the line. Click anywhere on the line and the dropdown menu will open. For each dropdown menu we have included an “other” as the last option on the menu – if you click “other” a text box will open and you can add your information. Business cards can also be added."));
                txt63.setText(Html.fromHtml("<b>To Add Information.</b> Click the PLUS button on the bottom right corner of the screen. If the person is in your contacts click the option - Add from Contacts. The minimum amount of information you need to complete this section is the person’s name, the relationship to the person, the priority, and a phone number/type."));
                txt64.setText(Html.fromHtml("<b>Profile Photo:</b>  To add a Photo click anywhere in the circle, then click ”take picture” or “gallery” choose the photo then click SAVE. To edit or delete the photo click the pencil."));
                txt65.setText(Html.fromHtml("<b>Adding a Business Card.</b> The last entry on the screen allows the User to add a business card. Click ADD CARD or the blue pencil and further instructions will pop-up.  Click SAVE on the top right of the screen when you are done.  To forward the card, click on the card and click the share symbol on the top right of the screen. To edit the card click the pencil and follow the directions on the screen."));
                txt66.setText(Html.fromHtml("<b>Summary Screen.</b> MYLO provides Users with a summary screen.  To edit information click the cell of the contact. Make changes and then click SAVE on the top right side of the screen. When you click SAVE, Users will be brought back to the summary page. "));
                txt67.setText(Html.fromHtml("<b>Automated Phone Calls.</b>  From the summary screen, click the picture of the phone."));
                txt68.setText(Html.fromHtml("<b>To Delete an Entry.</b>  From the summary screen, identify the entry to delete, them left swipe (start from the right side of the cell, and swipe left)."));
                txtPolicy69.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen. Fax capability has been included in certain sections and should only be used to meet HIPAA requirements."));
                // txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                //txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                // txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>" +
                        "<br>"+txt65.getText().toString()+"<br>" +
                        "<br>"+txt66.getText().toString()+"<br>"+
                        "<br>"+txt67.getText().toString()+"<br>"+
                        "<br>"+txt68.getText().toString()+"<br>"+
                        "<br>"+txtPolicy69.getText().toString()+"<br>"
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
                // rel71.setVisibility(View.GONE);
                rel72.setVisibility(View.GONE);
                rel73.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Doctors & Other Health Care Professionals");
                break;

            case "PhysicianInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorRegisteredGreen));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("<b>User Instructions.</b>  First time user instructions are available when you initially click into the section. User instructions are always available by clicking the QUESTION MARK on the top right side of the screen.  To exit click the arrow back button on the top left side of the screen. To email the instructions click the share button on the top right side of the screen. To return to the dashboard, click the little house on the top left side of the screen."));
                txt62.setText(Html.fromHtml("<b>Data Entry.</b>  Data is entered via free text and dropdown menus. You may be able to use your phone’s microphone to add data verbally.  Dropdown menus are identified by the little grey arrow to the right of the line. Click anywhere on the line and the dropdown menu will open. For each dropdown menu we have included an “other” as the last option on the menu – if you click “other” a text box will open and you can add your information. Business cards can also be added."));
                txt63.setText(Html.fromHtml("<b>To Add Information.</b> Click the PLUS button on the bottom right corner of the screen. If the person is in your contacts click the option - Add from Contacts. The minimum amount of information you need to complete this section is the person’s name, the relationship to the person, the priority, and a phone number/type."));
                txt64.setText(Html.fromHtml("<b>Profile Photo:</b>  To add a Photo click anywhere in the circle, then click ”take picture” or “gallery” choose the photo then click SAVE. To edit or delete the photo click the pencil."));
                txt65.setText(Html.fromHtml("<b>Adding a Business Card.</b> The last entry on the screen allows the User to add a business card. Click ADD CARD or the blue pencil and further instructions will pop-up.  Click SAVE on the top right of the screen when you are done.  To forward the card, click on the card and click the share symbol on the top right of the screen. To edit the card click the pencil and follow the directions on the screen."));
                txt66.setText(Html.fromHtml("<b>Summary Screen.</b> MYLO provides Users with a summary screen.  To edit information click the cell of the contact. Make changes and then click SAVE on the top right side of the screen. When you click SAVE, Users will be brought back to the summary page. "));
                txt67.setText(Html.fromHtml("<b>Automated Phone Calls.</b>  From the summary screen, click the picture of the phone."));
                txt68.setText(Html.fromHtml("<b>To Delete an Entry.</b>  From the summary screen, identify the entry to delete, them left swipe (start from the right side of the cell, and swipe left)."));
                txtPolicy69.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen. Fax capability has been included in certain sections and should only be used to meet HIPAA requirements."));
                // txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                //txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
                // txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>" +
                        "<br>"+txt65.getText().toString()+"<br>" +
                        "<br>"+txt66.getText().toString()+"<br>"+
                        "<br>"+txt67.getText().toString()+"<br>"+
                        "<br>"+txt68.getText().toString()+"<br>"+
                        "<br>"+txtPolicy69.getText().toString()+"<br>"
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
                // rel71.setVisibility(View.GONE);
                rel72.setVisibility(View.GONE);
                rel73.setVisibility(View.GONE);


                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Primary Physician");
                break;
            case "EmergencyInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorRegisteredGreen));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                txt61.setText(Html.fromHtml("<b>User Instructions.</b>  First time user instructions are available when you initially click into the section. User instructions are always available by clicking the QUESTION MARK on the top right side of the screen.  To exit click the arrow back button on the top left side of the screen. To email the instructions click the share button on the top right side of the screen. To return to the dashboard, click the little house on the top left side of the screen."));
                txt62.setText(Html.fromHtml("<b>Data Entry.</b>  Data is entered via free text and dropdown menus. You may be able to use your phone’s microphone to add data verbally.  Dropdown menus are identified by the little grey arrow to the right of the line. Click anywhere on the line and the dropdown menu will open. For each dropdown menu we have included an “other” as the last option on the menu – if you click “other” a text box will open and you can add your information. Business cards can also be added."));
                txt63.setText(Html.fromHtml("<b>To Add Information.</b> Click the PLUS button on the bottom right corner of the screen. If the person is in your contacts click the option - Add from Contacts. The minimum amount of information you need to complete this section is the person’s name, the relationship to the person, the priority, and a phone number/type."));
                txt64.setText(Html.fromHtml("<b>Profile Photo:</b>  To add a Photo click anywhere in the circle, then click ”take picture” or “gallery” choose the photo then click SAVE. To edit or delete the photo click the pencil."));
                txt65.setText(Html.fromHtml("<b>Adding a Business Card.</b> The last entry on the screen allows the User to add a business card. Click ADD CARD or the blue pencil and further instructions will pop-up.  Click SAVE on the top right of the screen when you are done.  To forward the card, click on the card and click the share symbol on the top right of the screen. To edit the card click the pencil and follow the directions on the screen."));
                txt66.setText(Html.fromHtml("<b>Summary Screen.</b> MYLO provides Users with a summary screen.  To edit information click the cell of the contact. Make changes and then click SAVE on the top right side of the screen. When you click SAVE, Users will be brought back to the summary page. "));
                txt67.setText(Html.fromHtml("<b>Automated Phone Calls.</b>  From the summary screen, click the picture of the phone."));
                txt68.setText(Html.fromHtml("<b>To Delete an Entry.</b>  From the summary screen, identify the entry to delete, them left swipe (start from the right side of the cell, and swipe left)."));
                txtPolicy69.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen. Fax capability has been included in certain sections and should only be used to meet HIPAA requirements."));
               // txtPolicy71.setText(Html.fromHtml("<b>To delete the entire entry</b> left swipe right to left the cell of your contact start from the right side of the cell. \n<br>"));
                //txtPolicy72.setText(Html.fromHtml("<b>To view a report or to email the data</b> click the green circle with the three dots located on the left side of the screen. \n<br>"));
               // txtPolicy73.setText(Html.fromHtml("To exit the User Instructions and go back to the prior screen click the arrow back button on the top left side of the screen. If you want to send or share these instructions click the share button on the top right side of the screen. Clicking the little house will bring you back to the dashboard.\n<br>"));


                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>" +
                        "<br>"+txt65.getText().toString()+"<br>" +
                        "<br>"+txt66.getText().toString()+"<br>"+
                        "<br>"+txt67.getText().toString()+"<br>"+
                        "<br>"+txt68.getText().toString()+"<br>"+
                        "<br>"+txtPolicy69.getText().toString()+"<br>"
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
               // rel71.setVisibility(View.GONE);
                rel72.setVisibility(View.GONE);
                rel73.setVisibility(View.GONE);

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
                txt61.setText(Html.fromHtml("The Personal Profile allows Users to store data about themselves or their loved ones.  This information is often needed by physicians, emergency medical technicians, and emergency rooms."));
                txt62.setText(Html.fromHtml("<b>User Instructions.</b>  First time user instructions are available when you initially click into the section. User instructions are always available by clicking the QUESTION MARK on the top right side of the screen.  To exit click the arrow back button on the top left side of the screen. To email the instructions click the share button on the top right side of the screen. To return to the dashboard, click the little house on the top left side of the screen.\n"));
                txt63.setText(Html.fromHtml("<b>Data Entry.</b>  Data is entered via free text and dropdown menus.  You may be able to use your phone’s microphone to add data verbally.  Dropdown menus are identified by the little grey arrow to the right of the line. Click anywhere on the line and the dropdown menu will open."));
                txt64.setText(Html.fromHtml("<b>Save.</b> Click the SAVE button on the top right corner of the screen. Users should click SAVE after every few entries. "));
                txt65.setText(Html.fromHtml("<b>Profile Photo.</b> To add a Photo click anywhere in the circle and choose ”take picture” or “gallery” then click SAVE. To edit or delete the photo click the pencil. "));
                txt66.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen. Fax capability has been included in certain sections and should only be used to meet HIPAA requirements. "));
                txt67.setText(Html.fromHtml("<b>Exiting the sub-section.</b> To return to the prior screen click the back arrow button on the top left corner of the screen. To return to the Dashboard click the picture of the house on the top left corner of the screen. "));

                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                                "<br>"+txt63.getText().toString()+"<br>" +
                                "<br>"+txt64.getText().toString()+"<br>" +
                                "<br>"+txt65.getText().toString()+"<br>" +
                                "<br>"+txt66.getText().toString()+"<br>"+
                        "<br>"+txt67.getText().toString()+"<br>"
                        ).toString();

                //nikita
                txt61.setVisibility(View.VISIBLE);
                txt62.setVisibility(View.VISIBLE);
                txt63.setVisibility(View.VISIBLE);
                txt64.setVisibility(View.VISIBLE);
                txt622.setVisibility(View.GONE);
                txt65.setVisibility(View.VISIBLE);
                txt66.setVisibility(View.VISIBLE);
                txt67.setVisibility(View.VISIBLE);
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
                img67.setVisibility(View.VISIBLE);
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
                txt61.setText(Html.fromHtml("The Medical Profile consists of questions most often asked by a physician and/or an emergency room.   There are 15 sections. "));
                txt62.setText(Html.fromHtml("<b>User Instructions.</b>  First time user instructions are available when you initially click into the section. User instructions are always available by clicking the QUESTION MARK on the top right side of the screen.  To exit click the arrow back button on the top left side of the screen. To email the instructions click the share button on the top right side of the screen. To return to the dashboard, click the little house on the top left side of the screen."));
                txt63.setText(Html.fromHtml("<b>To Open a Section.</b> Click the green DOWN ARROW and then click the blue PLUS sign."));
                txt64.setText(Html.fromHtml("<b>Data Entry.</b> Data is entered via free text and dropdown menus.  You may be able to use your phone’s microphone to add data verbally. Dropdown menus are identified by the little grey arrow to the right of the line. Click anywhere on the line and the dropdown menu will open.  For each dropdown menu we have included an “other” as the last option on the menu – if you click “other” a text field will open and you can add your information."));
                txt65.setText(Html.fromHtml("<b>To Save Input.</b> Click the SAVE button on the top right side of the screen.  It’s recommended that you click Save after you complete each section."));
                txt66.setText(Html.fromHtml("<b>Adding Information within a Section.</b>  Open the section by clicking green down arrow, then Click the PLUS sign."));
                txt67.setText(Html.fromHtml("<b>To Edit or Delete Information.</b> Click the picture of the pencil or garbage can."));
                txt68.setText(Html.fromHtml("<b>To Close a Section.</b> Click the green UP ARROW on the right side of the section."));
                txtPolicy69.setText(Html.fromHtml("<b>Reports.</b> Users can view and email reports by clicking the green circle (with 3 white dots) located on the bottom of the screen. Fax capability has been included in certain sections and should only be used to meet HIPAA requirements."));

                UI = Html.fromHtml("<br>"+txt61.getText().toString()+"<br>" +
                        "<br>"+txt62.getText().toString()+"<br>" +
                        "<br>"+txt63.getText().toString()+"<br>" +
                        "<br>"+txt64.getText().toString()+"<br>" +
                        "<br>"+txt65.getText().toString()+"<br>" +
                        "<br>"+txt66.getText().toString()+"<br>"+
                        "<br>"+txt67.getText().toString()+"<br>"+
                        "<br>"+txt68.getText().toString()+"<br>"+
                        "<br>"+txtPolicy69.getText().toString()+"<br>"
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
                rel69.setVisibility(View.VISIBLE);
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
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Doctors & Other Health Care Professionals", UI);
                } else if (From.equals("HospitalInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Urgent Care, TeleMed, Hospitals, Rehab, Home Care", UI);
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
