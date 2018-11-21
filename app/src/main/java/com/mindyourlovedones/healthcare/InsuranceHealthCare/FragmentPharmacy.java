package com.mindyourlovedones.healthcare.InsuranceHealthCare;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.mindyourlovedones.healthcare.Connections.GrabConnectionActivity;
import com.mindyourlovedones.healthcare.DashBoard.InstructionActivity;
import com.mindyourlovedones.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedones.healthcare.HomeActivity.R;
import com.mindyourlovedones.healthcare.SwipeCode.DividerItemDecoration;
import com.mindyourlovedones.healthcare.SwipeCode.VerticalSpaceItemDecoration;
import com.mindyourlovedones.healthcare.database.DBHelper;
import com.mindyourlovedones.healthcare.database.PharmacyQuery;
import com.mindyourlovedones.healthcare.model.Pharmacy;
import com.mindyourlovedones.healthcare.pdfCreation.MessageString;
import com.mindyourlovedones.healthcare.pdfCreation.PDFDocumentProcess;
import com.mindyourlovedones.healthcare.pdfdesign.Header;
import com.mindyourlovedones.healthcare.pdfdesign.Specialty;
import com.mindyourlovedones.healthcare.utility.CallDialog;
import com.mindyourlovedones.healthcare.utility.PrefConstants;
import com.mindyourlovedones.healthcare.utility.Preferences;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by varsha on 8/28/2017.
 */

public class FragmentPharmacy extends Fragment implements View.OnClickListener {
    final String dialog_items[] = {"View", "Email", "User Instructions"};
    ImageView imgRight;
    View rootview;
    RecyclerView lvPharmacy;
    ArrayList<Pharmacy> PharmacyList;
    RelativeLayout llAddPharmacy;
    Preferences preferences;
    RelativeLayout rlGuide;
    DBHelper dbHelper;
    TextView txtMsg, txtFTU;
    FloatingActionButton floatProfile;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_pharmacy, null);
        initComponent();
        getData();
        initUI();
        initListener();

        return rootview;
    }

    private void initComponent() {
        preferences = new Preferences(getActivity());
        dbHelper = new DBHelper(getActivity(), preferences.getString(PrefConstants.CONNECTED_USERDB));
        PharmacyQuery p = new PharmacyQuery(getActivity(), dbHelper);
    }

    private void setListData() {
        if (PharmacyList.size() != 0) {
            PharmacyAdapter pharmacyAdapter = new PharmacyAdapter(getActivity(), PharmacyList, FragmentPharmacy.this);
            lvPharmacy.setAdapter(pharmacyAdapter);
            lvPharmacy.setVisibility(View.VISIBLE);
            rlGuide.setVisibility(View.GONE);
        } else {
            lvPharmacy.setVisibility(View.GONE);
            rlGuide.setVisibility(View.VISIBLE);
        }
    }

    private void initListener() {
        llAddPharmacy.setOnClickListener(this);
        imgRight.setOnClickListener(this);
        floatProfile.setOnClickListener(this);

    }

    private void initUI() {
        //shradha
        floatProfile = rootview.findViewById(R.id.floatProfile);

        final RelativeLayout relMsg = rootview.findViewById(R.id.relMsg);
        TextView txt61 = rootview.findViewById(R.id.txtPolicy61);
        TextView txt62 = rootview.findViewById(R.id.txtPolicy62);
        TextView txt63 = rootview.findViewById(R.id.txtPolicy63);
        TextView txt64 = rootview.findViewById(R.id.txtPolicy64);
        TextView txt65 = rootview.findViewById(R.id.txtPolicy65);
        TextView txt66 = rootview.findViewById(R.id.txtPolicy66);

        //shradha
        txt61.setText(Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the entity is in your <b>Contacts</b> click the gray bar on the top right side of your screen to load data.\n\n"));
        txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
        txt63.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n"));
        txt64.setText(Html.fromHtml("To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n "));
        txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n"));
        txt66.setText(Html.fromHtml("To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n"));

       /* rlMsg=rootview.findViewById(R.id.rlMsg);
        txtStep1=rootview.findViewById(R.id.txtStep1);
        txtStep2=rootview.findViewById(R.id.txtStep2);
        txtStep3=rootview.findViewById(R.id.txtStep3);
        txtStep4=rootview.findViewById(R.id.txtStep4);
        txtStep5=rootview.findViewById(R.id.txtStep5);
        txtStep6=rootview.findViewById(R.id.txtStep6);

        txtStep1.setText(Html.fromHtml("Step 1.To <b>add</b> information click the green bar at the bottom of the screen.If the person is in your <b>Contacts</b> click the gray bar on the top right side of your screen."));
        txtStep2.setText(Html.fromHtml("Step 2.To <b>save</b> information click the green bar at the bottom of the screen."));
        txtStep3.setText(Html.fromHtml("Step 3.To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits click the <b>green bar</b> at the bottom of the screen."));
        txtStep4.setText(Html.fromHtml("Step 4.To <b>make an automated phone call</b> or <b>delete</b> the entry <b>swipe right to left</b> arrow symbol."));
        txtStep5.setText(Html.fromHtml("Step 5.To <b>view a report</b> or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the top right side of the screen."));
        txtStep6.setText(Html.fromHtml("Step 6.To <b>add a picture</b> click the picture of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again.Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card"));
*/

        // txtMsg = rootview.findViewById(R.id.txtMsg);
        String msg = "To <b>add</b> information click the green bar at the bottom of the screen.If the person is in your <b>Contacts</b> click the gray  bar on the top right side of your screen." +
                "<br><br>" +
                "To <b>save</b> information click the green bar at the bottom of the screen." +
                "<br><br>" +
                "To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits click the <b>green bar</b> at the bottom of the screen." +
                "<br><br>" +
                "To <b>make an automated phone call</b> or <b>delete</b> the entry <b>swipe right to left</b> arrow symbol." +
                "<br><br>" +
                "To <b>view a report</b> or to <b>email</b> or <b>fax</b> the data in each section click the three dots on the top right side of the screen." +
                "<br><br>" +
                "To <b>add a picture</b> click the picture of the <b>pencil</b> and" +
                "either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again.Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card";
        // txtMsg.setText(Html.fromHtml(msg));
        txtFTU = rootview.findViewById(R.id.txtFTU);
        txtFTU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relMsg.setVisibility(View.VISIBLE);
            }
        });
        imgRight = getActivity().findViewById(R.id.imgRight);
        rlGuide = rootview.findViewById(R.id.rlGuide);
        // imgADMTick= (ImageView) rootview.findViewById(imgADMTick);
        llAddPharmacy = rootview.findViewById(R.id.llAddPharmacy);
        lvPharmacy = rootview.findViewById(R.id.lvPharmacy);

        //Changes done by nikita on 18/6/18
        lvPharmacy = rootview.findViewById(R.id.lvPharmacy);
        // Layout Managers:
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        lvPharmacy.setLayoutManager(linearLayoutManager);

        //add ItemDecoration
        lvPharmacy.addItemDecoration(new VerticalSpaceItemDecoration(48));

        //or
        lvPharmacy.addItemDecoration(
                new DividerItemDecoration(getActivity(), R.drawable.divider));
        //...
        if (PharmacyList.size() != 0) {
            setListData();
        }
    }

    public void callUser(Pharmacy item) {
        String mobile = item.getPhone();
        String hphone = "";
        String wPhone = "";

        if (mobile.length() != 0 || hphone.length() != 0 || wPhone.length() != 0) {
            CallDialog c = new CallDialog();
            c.showCallDialog(getActivity(), mobile, hphone, wPhone);
        } else {
            Toast.makeText(getActivity(), "You have not added phone number for call", Toast.LENGTH_SHORT).show();
        }
    }

    public void deletePharmacy(final Pharmacy item) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Delete");
        alert.setMessage("Do you want to Delete this record?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean flag = PharmacyQuery.deleteRecord(item.getId());
                if (flag == true) {
                    Toast.makeText(getActivity(), "Deleted", Toast.LENGTH_SHORT).show();
                    getData();
                    setListData();
                }
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

    private void getData() {
        PharmacyList = PharmacyQuery.fetchAllPharmacyRecord(preferences.getInt(PrefConstants.CONNECTED_USERID));
     /*   PharmacyList=new ArrayList<>();

        Pharmacy P1=new Pharmacy();
        P1.setName("Health Care Medico");
        P1.setNote("Emily Holms");
        P1.setImage(R.drawable.pharmacy);
        P1.setPhone("789-456-2135");
        P1.setAddress("799 E DRAGRAM SUITE 5A,TUCSON AZ 85705, USA");

        Pharmacy P2=new Pharmacy();
        P2.setName("City Medico");
        P2.setNote("Emily Holms");
        P2.setImage(R.drawable.pharmacys);
        P2.setPhone("985-456-2135");
        P2.setAddress("300 BOYLSTON AVE E, SEATTLE WA 98102, USA");


        PharmacyList.add(P1);
        PharmacyList.add(P2);*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatProfile:
                Intent intentDashboard = new Intent(getActivity(), BaseActivity.class);
                intentDashboard.putExtra("c", 1);//Profile Data
                intentDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intentDashboard.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentDashboard);
                break;
            case R.id.llAddPharmacy:
                preferences.putString(PrefConstants.SOURCE, "Pharmacy");
                Intent i = new Intent(getActivity(), GrabConnectionActivity.class);
                startActivity(i);
                break;
            case R.id.imgRight:
                final String RESULT = Environment.getExternalStorageDirectory()
                        + "/mylopdf/";
                File dirfile = new File(RESULT);
                dirfile.mkdirs();
                File file = new File(dirfile, "Pharmacy.pdf");
                if (file.exists()) {
                    file.delete();
                }

                new Header().createPdfHeader(file.getAbsolutePath(),
                        "" + preferences.getString(PrefConstants.CONNECTED_NAME));
                preferences.copyFile("ic_launcher.png", getActivity());
                Header.addImage("/sdcard/MYLO/images/" + "ic_launcher.png");
                Header.addEmptyLine(1);
                Header.addusereNameChank("Pharmacies and home medical equipment");//preferences.getString(PrefConstants.CONNECTED_NAME));
                Header.addEmptyLine(1);
                Header.addChank("MindYour-LovedOnes.com");//preferences.getString(PrefConstants.CONNECTED_NAME));

                Paragraph p = new Paragraph(" ");
                LineSeparator line = new LineSeparator();
                line.setOffset(-4);
                line.setLineColor(BaseColor.LIGHT_GRAY);
                p.add(line);
                try {
                    Header.document.add(p);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                Header.addEmptyLine(1);
                /*new Header().createPdfHeader(file.getAbsolutePath(),
                        "Pharmacies and home medical equipment");

                Header.addusereNameChank(preferences.getString(PrefConstants.CONNECTED_NAME));
                Header.addEmptyLine(2);*/

                ArrayList<Pharmacy> PharmacyList = PharmacyQuery.fetchAllPharmacyRecord(preferences.getInt(PrefConstants.CONNECTED_USERID));
                new Specialty(PharmacyList);
                Header.document.close();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("");

                builder.setItems(dialog_items, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int itemPos) {
                        String path = Environment.getExternalStorageDirectory()
                                + "/mylopdf/"
                                + "/Pharmacy.pdf";
                        switch (itemPos) {
                            case 0: // view
                                StringBuffer result = new StringBuffer();
                                result.append(new MessageString().getDoctorsInfo());
                                result.append(new MessageString().getHospitalInfo());
                                result.append(new MessageString().getPharmacyInfo());
                                result.append(new MessageString().getAideInfo());
                                result.append(new MessageString().getFinanceInfo());

                                new PDFDocumentProcess(Environment.getExternalStorageDirectory()
                                        + "/mylopdf/"
                                        + "/Pharmacy.pdf",
                                        getActivity(), result);

                                System.out.println("\n" + result + "\n");
                                break;
                            case 1://Email
                                File f = new File(path);
                                preferences.emailAttachement(f, getActivity(), "Pharmacies And Home Medical Equipment");
                                break;
                            case 2://FTU
                                Intent i = new Intent(getActivity(), InstructionActivity.class);
                                i.putExtra("From", "PharmacyInstruction");
                                startActivity(i);
                                break;
                           /* case 2://fax
                                new FaxCustomDialog(getActivity(), path).show();
                                break;*/
                        }
                    }

                });
                builder.create().show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
        setListData();
    }
}
