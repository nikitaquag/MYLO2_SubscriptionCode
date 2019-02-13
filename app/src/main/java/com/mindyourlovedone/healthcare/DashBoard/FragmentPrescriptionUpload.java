package com.mindyourlovedone.healthcare.DashBoard;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
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
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.InsuranceHealthCare.FragmentPrescriptionInfo;
import com.mindyourlovedone.healthcare.SwipeCode.DividerItemDecoration;
import com.mindyourlovedone.healthcare.SwipeCode.VerticalSpaceItemDecoration;
import com.mindyourlovedone.healthcare.database.DBHelper;
import com.mindyourlovedone.healthcare.database.HospitalHealthQuery;
import com.mindyourlovedone.healthcare.model.Hospital;
import com.mindyourlovedone.healthcare.pdfCreation.MessageString;
import com.mindyourlovedone.healthcare.pdfCreation.PDFDocumentProcess;
import com.mindyourlovedone.healthcare.pdfdesign.Header;
import com.mindyourlovedone.healthcare.pdfdesign.Specialty;
import com.mindyourlovedone.healthcare.utility.CallDialog;
import com.mindyourlovedone.healthcare.utility.PrefConstants;
import com.mindyourlovedone.healthcare.utility.Preferences;

import java.io.File;
import java.util.ArrayList;

public class FragmentPrescriptionUpload extends Fragment implements View.OnClickListener {
    final String dialog_items[] = {"View", "Email", "User Instructions"};
    ImageView imgRight;
    View rootview;
    RecyclerView lvPrescriptionUpload;
    ArrayList<Hospital> prescriptonUploadList;
    RelativeLayout llAddPrescriptionUpload;
    Preferences preferences;
    DBHelper dbHelper;
    RelativeLayout rlGuide;
    TextView txtMsg, txtFTU;
    FloatingActionButton floatProfile, floatAdd, floatOptions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_pres_upload, null);
        initComponent();
        getData();
        initUI();
        initListener();

        return rootview;
    }

    private void initComponent() {
        preferences = new Preferences(getActivity());
        dbHelper = new DBHelper(getActivity(), preferences.getString(PrefConstants.CONNECTED_USERDB));
        //  HospitalHealthQuery f = new HospitalHealthQuery(getActivity(), dbHelper);
    }

    private void setListData() {
        if (prescriptonUploadList.size() != 0) {
            PrescriptionUploadAdapter presUploadAdapter = new PrescriptionUploadAdapter(getActivity(), prescriptonUploadList, FragmentPrescriptionUpload.this);
            lvPrescriptionUpload.setAdapter(presUploadAdapter);
            lvPrescriptionUpload.setVisibility(View.VISIBLE);
            rlGuide.setVisibility(View.GONE);
        } else {
            lvPrescriptionUpload.setVisibility(View.GONE);
            rlGuide.setVisibility(View.VISIBLE);
        }
    }


    private void initListener() {
        llAddPrescriptionUpload.setOnClickListener(this);
        imgRight.setOnClickListener(this);
        floatProfile.setOnClickListener(this);
        floatAdd.setOnClickListener(this);

    }

    private void initUI() {
        //shradha
        floatProfile = rootview.findViewById(R.id.floatProfile);
        floatAdd = rootview.findViewById(R.id.floatAdd);

        final RelativeLayout relMsg = rootview.findViewById(R.id.relMsg);
        TextView txt61 = rootview.findViewById(R.id.txtPolicy61);
        TextView txt62 = rootview.findViewById(R.id.txtPolicy62);
        TextView txt63 = rootview.findViewById(R.id.txtPolicy63);
        TextView txt64 = rootview.findViewById(R.id.txtPolicy64);
        TextView txt65 = rootview.findViewById(R.id.txtPolicy65);
        TextView txt66 = rootview.findViewById(R.id.txtPolicy66);
        TextView txt67 = rootview.findViewById(R.id.txtPolicy67);
        TextView txt68 = rootview.findViewById(R.id.txtPolicy68);
        ImageView img67 = rootview.findViewById(R.id.img67);
        ImageView img68 = rootview.findViewById(R.id.img68);

        //shradha
        txt61.setText(Html.fromHtml("To <b>add</b> information click the orange bar at the bottom of the screen. If the entity is in your <b>Contacts</b> click the gray bar on the top right side of your screen to load the data.\n\n"));
        txt62.setText(Html.fromHtml("To <b>save</b> information click the <b>SAVE</b> on the top right side of the screen.\n\n"));
        txt63.setText(Html.fromHtml("To <b>edit</b> information click the picture of the <b>pencil</b>. To <b>save</b> your edits <b>click</b> the <b>SAVE</b> on the top right side of the screen.\n\n"));
        txt64.setText(Html.fromHtml("To <b>make an automated phone call</b> or <b>delete</b> the entry, left swipe the arrow symbol on the <b>right side</b> of the screen.\n\n "));
        txt65.setText(Html.fromHtml("To <b>view a report</b> or to <b>email</b> the data in each section click the three dots on the top right side of the screen.\n\n"));
        txt66.setText(Html.fromHtml("To <b>add a picture</b> click the <b>picture</b> of the <b>pencil</b> and either <b>take a photo</b> or grab one from your <b>gallery</b>. To edit or delete the picture click the pencil again. Use the same process to add a business card. It is recommended that you hold your phone horizontal when taking a picture of the business card.\n\n"));
        txt67.setText(Html.fromHtml("\n\n"));
       /* txt68.setText(Html.fromHtml("\n\n"));
        img67.setVisibility(View.GONE);
        img68.setVisibility(View.GONE);
*/

        // txtMsg = rootview.findViewById(R.id.txtMsg);
        String msg = "To <b>add</b> information click the green bar at the bottom of the screen. If the entity is in your <b>Contacts</b> click the gray bar on the top right side of your screen to load data." +
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
                Intent intentEmerInstruc = new Intent(getActivity(), InstructionActivity.class);
                intentEmerInstruc.putExtra("From", "PrescriptionInstruction");
                startActivity(intentEmerInstruc);
                // relMsg.setVisibility(View.VISIBLE);
            }
        });
        imgRight = getActivity().findViewById(R.id.imgRight);
        // imgADMTick= (ImageView) rootview.findViewById(imgADMTick);
        rlGuide = rootview.findViewById(R.id.rlGuide);
        llAddPrescriptionUpload = rootview.findViewById(R.id.llAddPrescriptionUpload);
        lvPrescriptionUpload = rootview.findViewById(R.id.lvPrescriptionUpload);
        // setListData();

        // Layout Managers:
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        lvPrescriptionUpload.setLayoutManager(linearLayoutManager);

        //add ItemDecoration
        lvPrescriptionUpload.addItemDecoration(new VerticalSpaceItemDecoration(48));

        //or
        lvPrescriptionUpload.addItemDecoration(
                new DividerItemDecoration(getActivity(), R.drawable.divider));
        //...
    }

    public void callUser(Hospital item) {
        String mobile = item.getOfficePhone();
        String hphone = item.getMobile();
        String wPhone = item.getOtherPhone();

        if (mobile.length() != 0 || hphone.length() != 0 || wPhone.length() != 0) {
            CallDialog c = new CallDialog();
            c.showCallDialog(getActivity(), mobile, hphone, wPhone);
        } else {
            Toast.makeText(getActivity(), "You have not added phone number for call", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteHospital(final Hospital item) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Delete");
        alert.setMessage("Do you want to Delete this record?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean flag = HospitalHealthQuery.deleteRecord(item.getId());
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
        // prescriptonUploadList = HospitalHealthQuery.fetchAllHospitalhealthRecord(preferences.getInt(PrefConstants.CONNECTED_USERID));
       /* FinanceList=new ArrayList<>();

        Finance P1=new Finance();
        P1.setFirm("Grand Capital");
        P1.setName("James Holms");
        P1.setCategory("Accountant");
        P1.setAddress("799 E DRAGRAM SUITE 5A,TUCSON AZ 85705, USA");
        P1.setImage(R.drawable.insis);
        P1.setPhone("589-789-5236");


        Finance P2=new Finance();
        P2.setFirm("Latham & Watkins");
        P2.setCategory("Attorney");
        P2.setName("Jack Watson");
        P2.setAddress("300 BOYLSTON AVE E, SEATTLE WA 98102, USA");
        P2.setImage(R.drawable.insir);
        P2.setPhone("366-789-5236");

        Finance P3=new Finance();
        P3.setFirm("American Advisory Group");
        P3.setName("John Sheridon");
        P3.setCategory("Financial Planner");
        P3.setAddress("200 E MAIN ST, PHOENIX AZ 85123, USA");
        P3.setImage(R.drawable.insurs);
        P3.setPhone("986-789-5236");


        FinanceList.add(P1);
        FinanceList.add(P2);
        FinanceList.add(P3);*/


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatProfile:
                Intent intentDashboard = new Intent(getActivity(), BaseActivity.class);
                intentDashboard.putExtra("c", 1);//Profile Data
                //  intentDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //   intentDashboard.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentDashboard);
                break;
            case R.id.floatAdd:
                showFloatDialog();
                break;
           /* case R.id.llAddHospital:
                preferences.putString(PrefConstants.SOURCE, "Hospital");
                Intent i = new Intent(getActivity(), GrabConnectionActivity.class);
                startActivity(i);
                break;*/
            case R.id.imgRight:
                final String RESULT = Environment.getExternalStorageDirectory()
                        + "/mylopdf/";
                File dirfile = new File(RESULT);
                dirfile.mkdirs();
                File file = new File(dirfile, "Hospital.pdf");
                if (file.exists()) {
                    file.delete();
                }
                new Header().createPdfHeader(file.getAbsolutePath(),
                        "" + preferences.getString(PrefConstants.CONNECTED_NAME));
                preferences.copyFile("ic_launcher.png", getActivity());
                Header.addImage("/sdcard/MYLO/images/" + "ic_launcher.png");
                Header.addEmptyLine(1);
                Header.addusereNameChank("Hospitals and other health professionals");//preferences.getString(PrefConstants.CONNECTED_NAME));
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

              /*  new Header().createPdfHeader(file.getAbsolutePath(),
                        "Hospitals and other health professionals");

                Header.addusereNameChank(preferences.getString(PrefConstants.CONNECTED_NAME));
                Header.addEmptyLine(2);*/

                ArrayList<Hospital> HospitalList = HospitalHealthQuery.fetchAllHospitalhealthRecord(preferences.getInt(PrefConstants.CONNECTED_USERID));
                new Specialty("Hospital", HospitalList);
                Header.document.close();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("");

                builder.setItems(dialog_items, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int itemPos) {
                        String path = Environment.getExternalStorageDirectory()
                                + "/mylopdf/"
                                + "/Hospital.pdf";
                        switch (itemPos) {

                            case 0: // view
                                StringBuffer result = new StringBuffer();
                                result.append(new MessageString().getHospitalInfo());

                                new PDFDocumentProcess(path,
                                        getActivity(), result);

                                System.out.println("\n" + result + "\n");

                                break;
                            case 1://Email
                                File f = new File(path);
                                preferences.emailAttachement(f, getActivity(), "Hospitals And Other Health Preofessional");
                                break;
                            case 2://FTU
                                Intent i = new Intent(getActivity(), InstructionActivity.class);
                                i.putExtra("From", "PrescriptionInstruction");
                                startActivity(i);
                                break;
                           /* case 2://fax
                                new FaxCustomDialog(getActivity(), path).show();
                                break;*/
                        }
                    }

                });
                builder.create().show();
                break;
        }
    }

    private void showFloatDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        LayoutInflater lf = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogview = lf.inflate(R.layout.activity_transparent, null);
        final RelativeLayout rlView = dialogview.findViewById(R.id.rlView);
        final FloatingActionButton floatCancel = dialogview.findViewById(R.id.floatCancel);
        final FloatingActionButton floatContact = dialogview.findViewById(R.id.floatContact);
        //floatContact.setImageResource(R.drawable.closee);
        final FloatingActionButton floatNew = dialogview.findViewById(R.id.floatNew);
        // floatNew.setImageResource(R.drawable.eyee);

        TextView txtNew = dialogview.findViewById(R.id.txtNew);
        txtNew.setText(getResources().getString(R.string.AddNew));

        TextView txtContact = dialogview.findViewById(R.id.txtContact);
        txtContact.setText(getResources().getString(R.string.AddContacts));

        dialog.setContentView(dialogview);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        // int width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.95);
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        //lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);
        dialog.show();

        rlView.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
        floatCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        floatNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Please wait still in progress..!!", Toast.LENGTH_SHORT).show();
                /*preferences.putString(PrefConstants.SOURCE, "PrescriptionInfo");
                Intent i = new Intent(getActivity(), GrabConnectionActivity.class);
                startActivity(i);*/
                dialog.dismiss();
            }
        });

        floatContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Please wait still in progress..!!", Toast.LENGTH_SHORT).show();
               /* preferences.putString(PrefConstants.SOURCE, "PrescriptionInfo");
                Intent i = new Intent(getActivity(), GrabConnectionActivity.class);
                startActivity(i);*/
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
        // setListData();
    }
}
