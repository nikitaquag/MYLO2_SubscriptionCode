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
                txt61.setText(Html.fromHtml("To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry swipe right to left the cell of the document.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"
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


                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> a Prescription click on Plus button at the bottom right of the screen. Once completed click SAVE at the top right corner of the screen.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen..<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your Prescription. This would bring up the delete button.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"
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
                txt61.setText(Html.fromHtml("To add a note click on Plus button at the bottom right of the screen. Once completed click SAVE at the top right corner of the screen.<br>"));
                txt62.setText(Html.fromHtml("To edit the Vital Signs click the the <b>green down arrow</b> on right of the entry. This will show the edit button, which can be clicked to edit the vital sign. To save your edits click the SAVE at the top right of the screen.<br>"));
                txt63.setText(Html.fromHtml("To <b>delete</b> the entry left swipe right to left the cell of your appointment. This would bring up the delete button.<br>"));
                txt64.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To add a note click on Plus button at the bottom right of the screen. Once completed click SAVE at the top right corner of the screen.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To edit the Vital Signs click the the <b>green down arrow</b> on right of the entry. This will show the edit button, which can be clicked to edit the vital sign. To save your edits click the SAVE at the top right of the screen.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your appointment. This would bring up the delete button.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"
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
                txtHeader.setText("Instructions for Vital Signs");
                break;

            case "FormInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry swipe right to left the cell of the document.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"
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

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To get started click the <b>Plus</b> button at the bottom right corner of the screen.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information add the <b>Provider name</b> and <b>Type of Insurance</b> and click the <b>SAVE</b> on the top right side of the screen.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To take a picture of your insurance card (front and back). Click the <b>ADD CARD</b> button. It is recommended that you hold your phone horizontal when taking a picture of the card.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> your information click the <b>SAVE</b> on the top right side of the screen.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b/> information click cell of the added card. To <b>save</b> your edits click the <b>SAVE</b> again.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry swipe right to left the cell of the card.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"

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
                txt67.setText(Html.fromHtml("To <b>add</b> a picture click on the <b>PROFILE PHOTO</b> button and either take a photo or grab one from your gallery. To edit or delete the picture click the pencil. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> a picture click on the <b>PROFILE PHOTO</b> button and either take a photo or grab one from your gallery. To edit or delete the picture click the pencil. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.<br>"

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
                img67.setVisibility(View.VISIBLE);
                img68.setVisibility(View.GONE);

                txtTitle.setText("User Instructions");
                txtHeader.setText("Instructions for Insurance Information");
                break;

            case "AdvanceInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorDirectiveRed));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry swipe right to left the cell of the document.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"
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
                txtHeader.setText("Instructions for Advance Directives");
                break;

            case "OtherInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorDirectiveRed));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry swipe right to left the cell of the document.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"
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
                txtHeader.setText("Instructions for Other Documents");

                break;

            case "MedicalInfoInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorDirectiveRed));
                imgPicture.setVisibility(View.GONE);
                imgDot.setVisibility(View.GONE);
                imgPicture.setImageResource(R.drawable.v_user);

                //shradha
                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"));
                txt62.setText(Html.fromHtml("The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"));
                txt63.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the entry swipe right to left the cell of the document.<br>"));
                txt65.setText(Html.fromHtml("To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. Click the <b>ATTACH FILE</b> button to Select the File.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;The file is either sitting on your phone or in your Dropbox. Choose the location and click Add.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> button on the upper right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry swipe right to left the cell of the document.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click on the <b>cell</b> of the document. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the bottom right side of the screen.<br>"
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
                txt61.setText(Html.fromHtml("This <b>section</b> allows the User to create a master list of annual or reoccurring appointments. The purpose is to ensure appointments are made and not overlooked.<br>"));
                txt62.setText(Html.fromHtml("To <b>add</b> an Appointment click on <b>Plus</b> button at the bottom right of the screen. Choose a Specialist or Type of Test, add the name of your doctor and frequency of appointment. Once completed click <b>SAVE</b> button at the top right corner of the screen..<br>"));
                txt63.setText(Html.fromHtml("To <b>edit</b> the Appointment click the the <b>green down arrow</b> on right of the appointment. This will show the edit button, which can be clicked to edit the appointment. Once completed click <b>SAVE</b> button at the top right corner of the screen. To <b>delete</b> the appointment swipe right to left and click the garbage can.<br>"));
                txt64.setText(Html.fromHtml("To add the completed date(s) click the the <b>green down arrow</b> on right of the appointment and click <b>ADD NEW</b>.<br>"));
                txt65.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;This <b>section</b> allows the User to create a master list of annual or reoccurring appointments. The purpose is to ensure appointments are made and not overlooked.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> an Appointment click on <b>Plus</b> button at the bottom right of the screen. Choose a Specialist or Type of Test, add the name of your doctor and frequency of appointment. Once completed click <b>SAVE</b> button at the top right corner of the screen..<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> the Appointment click the the <b>green down arrow</b> on right of the appointment. This will show the edit button, which can be clicked to edit the appointment. Once completed click <b>SAVE</b> button at the top right corner of the screen. To <b>delete</b> the appointment swipe right to left and click the garbage can.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To add the completed date(s) click the the <b>green down arrow</b> on right of the appointment and click <b>ADD NEW</b>.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"
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
                txt61.setText(Html.fromHtml("To <b>add</b> a note click on <b>Plus</b> button at the bottom right of the screen. Once completed click <b>SAVE</b>. The note is automatically saved.<br>"));
                txt62.setText(Html.fromHtml("To edit the note click the the <b>green down arrow</b> on right of the note. This will show the edit button, which can be clicked to edit the note. To save your edits click the SAVE at the top right of the screen.<br>"));
                txt63.setText(Html.fromHtml("To <b>delete</b> the entry left swipe right to left the cell of your note. This would bring up the delete button.<br>"));
                txt64.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> a note click on <b>Plus</b> button at the bottom right of the screen. Once completed click <b>SAVE</b>. The note is automatically saved.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To edit the note click the the <b>green down arrow</b> on right of the note. This will show the edit button, which can be clicked to edit the note. To save your edits click the SAVE at the top right of the screen.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your note. This would bring up the delete button.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the bottom left side of the screen.<br>"
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

                //shradha
                txt61.setText(Html.fromHtml("To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"));
                txt65.setText(Html.fromHtml("To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"
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
                txtHeader.setText("Instructions for Pharmacies & Home Medical Equipment");
                break;

            case "FinanceInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
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

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"
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
                txtHeader.setText("Instructions for Finance, Legal, Other");
                break;
            case "HospitalInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
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

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"
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
                txtHeader.setText( "Instructions for Hospitals, Rehab, Home Care");
                break;

            case "DoctorInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorSpecialityYellow));
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

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"
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
                txtHeader.setText("Instructions for Doctors And Health Care Professionals");
                break;

            case "PhysicianInstruction":
                header.setBackgroundColor(getResources().getColor(R.color.colorRegisteredGreen));
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

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"
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
                txt61.setText(Html.fromHtml("To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"));
                txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"));
                txt64.setText(Html.fromHtml("To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"));
                txt65.setText(Html.fromHtml("To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"));
                txt66.setText(Html.fromHtml("To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the <b>Plus</b> button at the bottom right corner of the screen. If the person is in your Contacts click the <b>Add from Contact</b> option.<br>"+
                                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.<br>"+
                                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information click the cell of the added contact. To <b>save</b> your edits click the <b>SAVE</b> on the top right side of the screen.<br>"+
                                "&nbsp;&nbsp;&nbsp;&nbsp;To make an <b>automated phone call</b> click the phone button on the cell of your contact. <br>"+
                                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the entry left swipe right to left the cell of your contact on the right side.<br>"+
                                "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> a report or to <b>email</b> the data in each section click the three dots on the Botton left of the screen.<br>"
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

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Welcome to MYLO -</b> This App allows you to maintain a digital library of critical documents and medical information for you and your loved ones. There are 6 main sections. The App provides unlimited profiles, pdf reports, email and fax functionality, and the ability to share profiles and eliminate the need to re-enter data.<br>"+
              "&nbsp;&nbsp;&nbsp;&nbsp;<b>Getting Started -</b> Before you begin we would like to explain the data entry process. Except for this Profiles page, each screen has a top bar which includes the name of the screen, an arrow back button on the top left, three dots on the top right (which allows you to view or email the data), and a save button on data entry screens.<br>First time Users will see First Time User Instructions directly on the screen. After adding information. the User can access User Instructions by clicking on the three buttons. A User Guide is also available from the dropdown Menu located on the top left of the Profiles page.<br>"+
                "<br>" +
               "<br>&nbsp;&nbsp;&nbsp;&nbsp;<b>A reminder to all Users -</b> MYLO is a native to your phone. This means that we do not have access to your information. If you forget the name and email address used for this app then the data will be lost. It’s important that you  remember this information and to periodically back up the and or send yourself the pdf reports. Backup instructions are included on the Menu page.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;<b>MYLO Would Like to Access Your Contacts and MYLO Would Like to Access Your Camera -</b>This message does NOT mean that the company has access to your information, it simply allows the APP to utilise the functions of your phone and provide the USER with a better experience.<br>"+
               "&nbsp;&nbsp;&nbsp;&nbsp;<b>Adding a Profile - </b>click the plus box. You will see two options. Create New and Import from Dropbox." + "<br> <b>Option 1 : Create New.</b> You will be brought to the Add Profile  Screen. You can type in the new profile or if the person is in your Contacts then click the gray bar on the top right side of your screen to load information. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).<br> <b>Option 2 : Import from Dropbox.</b> Using this feature you can upload a profile from Dropbox. If you click that option, you will be provided additional instructions. Once completed click either Save (top right of screen) or Add Profile (bottom of screen).<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;There are <b>three</b> required elements to create a Profile –  <b>name, relationship</b>, and an <b>email</b> address.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;<b>To Share a Profile –</b> Long press on the Profile Box and you will be able to upload the Profile to your Dropbox account.<br>"+
                "&nbsp;&nbsp;&nbsp;&nbsp;<b>To Delete a Profile –</b> Long Press on the Profile Box.<br>").toString();

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
                txt61.setText(Html.fromHtml("To <b>add</b> information - type responses or use dropdown"));
                txt62.setText(Html.fromHtml("To <b>save</b> information - click the check mark on the <b>top right</b> side of the screen."));
                txt63.setText(Html.fromHtml("To <b>edit</b> or <b>delete</b> information - make changes then save your edits by clicking <b>SAVE</b> on the <b>top right</b> of the screen."));
                txt64.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> - click the <b>three dots</b> on the top right side of the screen."));

                UI = Html.fromHtml("To <b>add</b> information - type responses or use dropdown.<br> To <b>save</b> information - click the check mark on the <b>top right</b> side of the screen.<br> To <b>edit</b> or <b>delete</b> information - make changes then save your edits by clicking <b>SAVE</b> on the <b>top right</b> of the screen.<br> To <b>view a report</b> or to <b>email</b> - click the <b>three dots</b> on the top right side of the screen.<br> Thanks & Regards").toString();


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
                txt61.setText(Html.fromHtml("To <b>add</b> information click the green <b>down arrow</b> button for each section. This would bring up the <b>Plus</b> button. Click the <b>Plus</b> button to start adding information for that section. <br>"));
                txt62.setText(Html.fromHtml("To store information click <b>save</b> on top right.<br>"));
                txt63.setText(Html.fromHtml("To <b>edit</b> information in a particular section click the picture of the <b>pencil</b>, click <b>save</b> to store your changes.<br>"));
                txt64.setText(Html.fromHtml("To <b>delete</b> the information in a particular section click the garbage can. For sections without the garbage can, simple <b>delete</b> the information.<br>"));
                txt65.setText(Html.fromHtml("To <b>view</b> or to <b>email</b> a report, click the three dots on the bottom right side of the screen.<br>"));

                UI = Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;To <b>add</b> information click the green <b>down arrow</b> button for each section. This would bring up the <b>Plus</b> button. Click the <b>Plus</b> button to start adding information for that section. <br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To store information click <b>save</b> on top right.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>edit</b> information in a particular section click the picture of the <b>pencil</b>, click <b>save</b> to store your changes.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>delete</b> the information in a particular section click the garbage can. For sections without the garbage can, simple delete the information.<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;To <b>view</b> or to <b>email</b> a report, click the three dots on the bottom right side of the screen.<br>"
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
                header.setBackgroundColor(getResources().getColor(R.color.colorInsuaranceSkyBlue));
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
                }
                else if (From.equals("EventNotesInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Event Notes", UI);
                } else if (From.equals("CheckListInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Appointment Checklist", UI);
                }else if (From.equals("VitalInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Vital Signs", UI);
                }  else if (From.equals("LivingInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Activity of daily living", UI);
                } else if (From.equals("InsuranceInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Insurance Information", UI);
                } else if (From.equals("CardInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Insurance Cards", UI);
                } else if (From.equals("FormInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Insurance Forms", UI);
                } else if (From.equals("DoctorInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Doctors And Health Care Professionals", UI);
                } else if (From.equals("HospitalInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Hospitals, Rehab, Home Care", UI);
                } else if (From.equals("PharmacyInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Pharmacies & Home Medical Equipment", UI);
                } else if (From.equals("FinanceInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Finance, Legal, Other ", UI);
                } else if (From.equals("Personal")) {
                    ui.emailAttachement(InstructionActivity.this, "MYLO User Instructions", UI);
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
                } else if (From.equals("AdvanceInstruction")) {
                    ui.emailAttachement(InstructionActivity.this, "Instructions for Advance Directives", UI);
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
