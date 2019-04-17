package com.mindyourlovedone.healthcare.DashBoard;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.InsuranceHealthCare.FaxCustomDialog;
import com.mindyourlovedone.healthcare.database.DBHelper;
import com.mindyourlovedone.healthcare.database.LivingQuery;
import com.mindyourlovedone.healthcare.model.Living;
import com.mindyourlovedone.healthcare.pdfCreation.MessageString;
import com.mindyourlovedone.healthcare.pdfCreation.PDFDocumentProcess;
import com.mindyourlovedone.healthcare.pdfdesign.Header;
import com.mindyourlovedone.healthcare.pdfdesign.Individual;
import com.mindyourlovedone.healthcare.utility.PrefConstants;
import com.mindyourlovedone.healthcare.utility.Preferences;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by welcome on 11/24/2017.
 */

public class FragmentLiving extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    final CharSequence[] dialog_items = {"View", "Email", "Fax"};
    View rootview;
    RelativeLayout rlLiving;
    ImageView imgBack, imgDone, imgRight, imgInfo;
    Preferences preferences;
    TextView txtTitle, txtName;
    DBHelper dbHelper;
    ImageView imgInfoF, imgInfoI;
    EditText etOtherFunction, etFunctionalNote, etOtherInstrument, etInstrumentalNote;
    ToggleButton tbFinances, tbPreparing, tbShopping, tbUsing, tbBathing, tbContinence, tbDressing, tbfeed, tbToileting, tbTranfering, tbTransport, tbPets, tbDriving, tbKeeping, tbMedication;
    String finance = "NO", prepare = "NO", shop = "NO", use = "NO", bath = "NO", continence = "NO", dress = "NO", feed = "NO", toileting = "NO", transfer = "NO", transport = "NO", pets = "NO", drive = "NO", keep = "NO", medication = "NO";
    String functionnote = "", fouctionOther = "", instaOther = "", instaNote = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_living, null);
        preferences = new Preferences(getActivity());
        initComponent();
        initUI();
        initListener();
        return rootview;
    }

    private void initListener() {
        imgDone.setOnClickListener(this);
        imgBack.setOnClickListener(this);
        imgInfoF.setOnClickListener(this);
        imgInfoI.setOnClickListener(this);
        imgRight.setOnClickListener(this);
        tbFinances.setOnCheckedChangeListener(this);
        tbPreparing.setOnCheckedChangeListener(this);
        tbShopping.setOnCheckedChangeListener(this);
        tbUsing.setOnCheckedChangeListener(this);
        tbBathing.setOnCheckedChangeListener(this);
        tbContinence.setOnCheckedChangeListener(this);
        tbDressing.setOnCheckedChangeListener(this);
        tbfeed.setOnCheckedChangeListener(this);
        tbToileting.setOnCheckedChangeListener(this);
        tbTranfering.setOnCheckedChangeListener(this);
        tbTransport.setOnCheckedChangeListener(this);
        tbPets.setOnCheckedChangeListener(this);
        tbDriving.setOnCheckedChangeListener(this);
        tbKeeping.setOnCheckedChangeListener(this);
        tbMedication.setOnCheckedChangeListener(this);
    }

    private void initUI() {
        imgInfo = rootview.findViewById(R.id.imgInfo);
        imgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog customDialog;
                customDialog = new Dialog(getActivity());
                customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                customDialog.setContentView(R.layout.dialog_living);
                customDialog.setCancelable(false);
                TextView txtNotes = customDialog.findViewById(R.id.txtNotes);
                String msg = "To save information click the check mark" +
                        " on the upper right side of the screen." +
                        "<br><br>" +
                        "To edit information simply change the data and then save your edits by clicking on the check mark on the upper right side of the screen." +
                        "<br><br>" +
                        "To view, email, or fax the data in each section click on the three dots on the upper right side of the screen.";

                txtNotes.setText(Html.fromHtml(msg));
                TextView txtNoteHeader = customDialog.findViewById(R.id.txtNoteHeader);
                txtNoteHeader.setText("Help");
                TextView btnYes = customDialog.findViewById(R.id.btnYes);
                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
            }
        });
        rlLiving = rootview.findViewById(R.id.rlLiving);
        txtName = rootview.findViewById(R.id.txtName);
        txtName.setText(preferences.getString(PrefConstants.CONNECTED_NAME));
        txtTitle = getActivity().findViewById(R.id.txtTitle);
        txtTitle.setVisibility(View.VISIBLE);
        txtTitle.setText("ACTIVITIES OF DAILY\nLIVING");

        imgBack = getActivity().findViewById(R.id.imgBack);
        imgRight = getActivity().findViewById(R.id.imgRight);
        imgDone = getActivity().findViewById(R.id.imgDone);
        imgDone.setVisibility(View.VISIBLE);

        imgInfoF = rootview.findViewById(R.id.imgInfoF);
        imgInfoI = rootview.findViewById(R.id.imgInfoI);

        etOtherFunction = rootview.findViewById(R.id.etOtherFunction);
        etFunctionalNote = rootview.findViewById(R.id.etFunctionalNote);
        etOtherInstrument = rootview.findViewById(R.id.etOtherInstrument);
        etInstrumentalNote = rootview.findViewById(R.id.etInstrumentalNote);

        tbFinances = rootview.findViewById(R.id.tbFinances);
        tbPreparing = rootview.findViewById(R.id.tbPreparing);
        tbShopping = rootview.findViewById(R.id.tbShopping);
        tbUsing = rootview.findViewById(R.id.tbUsing);
        tbBathing = rootview.findViewById(R.id.tbBathing);
        tbContinence = rootview.findViewById(R.id.tbContinence);
        tbDressing = rootview.findViewById(R.id.tbDressing);
        tbfeed = rootview.findViewById(R.id.tbfeed);
        tbToileting = rootview.findViewById(R.id.tbToileting);
        tbTranfering = rootview.findViewById(R.id.tbTranfering);
        tbTransport = rootview.findViewById(R.id.tbTransport);
        tbPets = rootview.findViewById(R.id.tbPets);
        tbDriving = rootview.findViewById(R.id.tbDriving);
        tbKeeping = rootview.findViewById(R.id.tbKeeping);
        tbMedication = rootview.findViewById(R.id.tbMedication);

        rlLiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
            }
        });

        setLivingInfo();
    }

    private void hideSoftKeyboard() {
        if (getActivity().getCurrentFocus() != null) {
            InputMethodManager inm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }

    private void setLivingInfo() {
        Living medInfo = LivingQuery.fetchOneRecord(preferences.getInt(PrefConstants.CONNECTED_USERID));
        if (medInfo != null) {
            etFunctionalNote.setText(medInfo.getFunctionNote());
            etOtherFunction.setText(medInfo.getFunctionOther());
            etInstrumentalNote.setText(medInfo.getInstNote());
            etOtherInstrument.setText(medInfo.getInstOther());


            if (medInfo.getFinance().equals("YES")) {
                tbFinances.setChecked(true);
                finance = "YES";
            } else if (medInfo.getFinance().equals("NO")) {
                tbFinances.setChecked(false);
                finance = "NO";
            }

            if (medInfo.getPrepare().equals("YES")) {
                tbPreparing.setChecked(true);
                prepare = "YES";
            } else if (medInfo.getPrepare().equals("NO")) {
                tbPreparing.setChecked(false);
                prepare = "NO";
            }

            if (medInfo.getShop().equals("YES")) {
                tbShopping.setChecked(true);
                shop = "YES";
            } else if (medInfo.getShop().equals("NO")) {
                tbShopping.setChecked(false);
                shop = "NO";
            }

            if (medInfo.getUse().equals("YES")) {
                tbUsing.setChecked(true);
                use = "YES";
            } else if (medInfo.getUse().equals("NO")) {
                tbUsing.setChecked(false);
                use = "NO";
            }
            if (medInfo.getBath().equals("YES")) {
                tbBathing.setChecked(true);
                bath = "YES";
            } else if (medInfo.getBath().equals("NO")) {
                tbBathing.setChecked(false);
                bath = "NO";
            }
            if (medInfo.getContinence().equals("YES")) {
                tbContinence.setChecked(true);
                continence = "YES";
            } else if (medInfo.getContinence().equals("NO")) {
                tbContinence.setChecked(false);
                continence = "NO";
            }

            if (medInfo.getDress().equals("YES")) {
                tbDressing.setChecked(true);
                dress = "YES";
            } else if (medInfo.getDress().equals("NO")) {
                tbDressing.setChecked(false);
                dress = "NO";
            }

            if (medInfo.getFeed().equals("YES")) {
                tbfeed.setChecked(true);
                feed = "YES";
            } else if (medInfo.getFeed().equals("NO")) {
                tbfeed.setChecked(false);
                feed = "NO";
            }

            if (medInfo.getToileting().equals("YES")) {
                tbToileting.setChecked(true);
                toileting = "YES";
            } else if (medInfo.getToileting().equals("NO")) {
                tbToileting.setChecked(false);
                toileting = "NO";
            }

            if (medInfo.getTransfer().equals("YES")) {
                tbTranfering.setChecked(true);
                transfer = "YES";
            } else if (medInfo.getTransfer().equals("NO")) {
                tbTranfering.setChecked(false);
                transfer = "NO";
            }

            if (medInfo.getTransport().equals("YES")) {
                tbTransport.setChecked(true);
                transport = "YES";
            } else if (medInfo.getTransport().equals("NO")) {
                tbTransport.setChecked(false);
                transport = "NO";
            }

            if (medInfo.getPets().equals("YES")) {
                tbPets.setChecked(true);
                pets = "YES";
            } else if (medInfo.getPets().equals("NO")) {
                tbPets.setChecked(false);
                pets = "NO";
            }

            if (medInfo.getDrive().equals("YES")) {
                tbDriving.setChecked(true);
                drive = "YES";
            } else if (medInfo.getDrive().equals("NO")) {
                tbDriving.setChecked(false);
                drive = "NO";
            }

            if (medInfo.getKeep().equals("YES")) {
                tbKeeping.setChecked(true);
                keep = "YES";
            } else if (medInfo.getKeep().equals("NO")) {
                tbKeeping.setChecked(false);
                keep = "NO";
            }

            if (medInfo.getMedication().equals("YES")) {
                tbMedication.setChecked(true);
                medication = "YES";
            } else if (medInfo.getMedication().equals("NO")) {
                tbMedication.setChecked(false);
                medication = "NO";
            }
        }
    }

    private void initComponent() {
        preferences = new Preferences(getActivity());
        dbHelper = new DBHelper(getActivity());
        LivingQuery p = new LivingQuery(getActivity(), dbHelper);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgInfoF:
                String msg = "<b>Bathing.</b> <i>The ability to clean oneself and perform grooming activities like shaving and brushing teeth.</i>  <br><br>" +
                        "<b>Dressing.</b> <i> The ability to get dressed by oneself without struggling with buttons and zippers.</i><br><br>" +
                        "<b>Eating.</b> <i> The ability to feed oneself.</i><br><br>" +
                        "<b>Transferring.</b> <i> Being able to either walk or move oneself from a bed to a wheelchair and back again.</i><br><br>" +
                        "<b>Toileting.</b> <i> The ability to get on and off the toilet.</i><br><br>" +
                        "<b>Continence.</b> <i> The ability to control one's bladder and bowel functions.</i>";
                String title = "Activities of Daily Living";
                showViewDialog(getActivity(), msg, title);
                break;
            case R.id.imgRight:

                final String RESULT = Environment.getExternalStorageDirectory()
                        + "/mylopdf/";
                File dirfile = new File(RESULT);
                dirfile.mkdirs();
                File file = new File(dirfile, "ADL-IADLs.pdf");
                if (file.exists()) {
                    file.delete();
                }
                new Header().createPdfHeader(file.getAbsolutePath(),
                        "" + preferences.getString(PrefConstants.CONNECTED_NAME));
                Header.addEmptyLine(1);
                Header.addusereNameChank("Activities of Daily Living");//preferences.getString(PrefConstants.CONNECTED_NAME));
                Header.addEmptyLine(1);
                /*new Header().createPdfHeader(file.getAbsolutePath(),
                        "Activities Of Daily Living");
                Header.addusereNameChank(preferences.getString(PrefConstants.CONNECTED_NAME));
                Header.addEmptyLine(2);*/

                Living Live = LivingQuery.fetchOneRecord(preferences.getInt(PrefConstants.CONNECTED_USERID));
                ArrayList<Living> LivingList = new ArrayList<Living>();
                LivingList.add(Live);
                new Individual(LivingList, 1);

                Header.document.close();


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("");

                builder.setItems(dialog_items, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int itemPos) {
                        String path = Environment.getExternalStorageDirectory()
                                + "/mylopdf/" + "ADL-IADLs.pdf";
                        switch (itemPos) {
                            case 0: //View
                                StringBuffer result = new StringBuffer();
                                result.append(new MessageString().getLivingInfo());
                                new PDFDocumentProcess(path,
                                        getActivity(), result);

                                System.out.println("\n" + result + "\n");
                                break;
                            case 1://Email
                                File f = new File(path);
                                preferences.emailAttachement(f, getActivity(), "Activities of Daily Living");
                                break;
                            case 2://fax
                                new FaxCustomDialog(getActivity(), path).show();
                                break;

                        }
                    }

                });
                builder.create().show();
                break;
            case R.id.imgDone:
                functionnote = etFunctionalNote.getText().toString().trim();
                fouctionOther = etOtherFunction.getText().toString().trim();
                instaOther = etOtherInstrument.getText().toString().trim();
                instaNote = etInstrumentalNote.getText().toString().trim();
                Boolean flag = LivingQuery.insertLivingData(preferences.getInt(PrefConstants.CONNECTED_USERID), finance, prepare, shop, use, bath, continence, dress, feed, toileting, transfer, transport, pets, drive, keep, medication, functionnote, fouctionOther, instaNote, instaOther, "", "", "");
                if (flag == true) {
                    Toast.makeText(getActivity(), "Activity Living Info Saved", Toast.LENGTH_SHORT).show();
                    hideSoftKeyboard();
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.imgBack:
                hideSoftKeyboard();
                getActivity().finish();
                break;
        }
    }

    private void showViewDialog(Context context, String Message, String title) {
        final Dialog customDialog;

        // LayoutInflater inflater = (LayoutInflater) getLayoutInflater();
        //  View customView = inflater.inflate(R.layout.dialog_input, null);
        // Build the dialog
        customDialog = new Dialog(context);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.dialog_living);
        customDialog.setCancelable(false);
        TextView txtNotes = customDialog.findViewById(R.id.txtNotes);
        txtNotes.setText(Html.fromHtml(Message));
        TextView txtNoteHeader = customDialog.findViewById(R.id.txtNoteHeader);
        txtNoteHeader.setText(title);
        TextView btnYes = customDialog.findViewById(R.id.btnYes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.dismiss();
            }
        });
        customDialog.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {
            case R.id.tbFinances:
                if (isChecked == true)
                    finance = "YES";
                else
                    finance = "NO";
                break;

            case R.id.tbPreparing:
                if (isChecked == true)
                    prepare = "YES";
                else
                    prepare = "NO";
                break;

            case R.id.tbShopping:
                if (isChecked == true)
                    shop = "YES";
                else
                    shop = "NO";
                break;

            case R.id.tbUsing:
                if (isChecked == true)
                    use = "YES";
                else
                    use = "NO";
                break;

            case R.id.tbBathing:
                if (isChecked == true)
                    bath = "YES";
                else
                    bath = "NO";
                break;

            case R.id.tbContinence:
                if (isChecked == true)
                    continence = "YES";
                else
                    continence = "NO";
                break;

            case R.id.tbDressing:
                if (isChecked == true)
                    dress = "YES";
                else
                    dress = "NO";
                break;

            case R.id.tbfeed:
                if (isChecked == true)
                    feed = "YES";
                else
                    feed = "NO";
                break;

            case R.id.tbToileting:
                if (isChecked == true)
                    toileting = "YES";
                else
                    toileting = "NO";
                break;

            case R.id.tbTranfering:
                if (isChecked == true)
                    transfer = "YES";
                else
                    transfer = "NO";
                break;

            case R.id.tbTransport:
                if (isChecked == true)
                    transport = "YES";
                else
                    transport = "NO";
                break;

            case R.id.tbMedication:
                if (isChecked == true)
                    medication = "YES";
                else
                    medication = "NO";
                break;

            case R.id.tbKeeping:
                if (isChecked == true)
                    keep = "YES";
                else
                    keep = "NO";
                break;

            case R.id.tbDriving:
                if (isChecked == true)
                    drive = "YES";
                else
                    drive = "NO";
                break;

            case R.id.tbPets:
                if (isChecked == true)
                    pets = "YES";
                else
                    pets = "NO";
                break;

        }
    }
}
