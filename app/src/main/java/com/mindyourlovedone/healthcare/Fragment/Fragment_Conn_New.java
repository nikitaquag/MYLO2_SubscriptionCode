package com.mindyourlovedone.healthcare.Fragment;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mindyourlovedone.healthcare.ConnectionNew.Conn;
import com.mindyourlovedone.healthcare.ConnectionNew.ConnAdapter;
import com.mindyourlovedone.healthcare.DashBoard.ProfileActivity;
import com.mindyourlovedone.healthcare.DashBoard.UserInsActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;

import java.util.ArrayList;

public class Fragment_Conn_New extends Fragment implements View.OnClickListener {
    View rootView;
    ArrayList<Conn> connList;
    ListView lvSelf;
   // FloatingActionButton floatAdd;
    ImageView floatAdd;
    LinearLayout llSelf;
    ImageView imgSelfFolder, imgHelp, imgProfile;
    TextView txtSelf, txtName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_conn, container, false);
        initUi();
        initListener();
        getData();
        setData();
        return rootView;
    }

    private void setData() {
        ConnAdapter connAdapter = new ConnAdapter(getActivity(), connList);
        lvSelf.setAdapter(connAdapter);
    }

    private void getData() {
        connList = new ArrayList<>();
        Conn c1 = new Conn();
        c1.setSelfName("Sarah Ortiz");
        c1.setSelf("Wife");
        c1.setSelfProfile(R.drawable.six);
        c1.setSelfProfFolder(R.drawable.pro_folder);

        Conn c2 = new Conn();
        c2.setSelfName("Franklin Gutierrez");
        c2.setSelf("Brother");
        c2.setSelfProfile(R.drawable.three);
        c2.setSelfProfFolder(R.drawable.pro_folder);

        Conn c3 = new Conn();
        c3.setSelfName("Andrew Wommack");
        c3.setSelf("Cousin");
        c3.setSelfProfile(R.drawable.two);
        c3.setSelfProfFolder(R.drawable.pro_folder);

        Conn c4 = new Conn();
        c4.setSelfName("Joseph Prince");
        c4.setSelf("Husband");
        c4.setSelfProfile(R.drawable.doct);
        c4.setSelfProfFolder(R.drawable.pro_folder);

        connList.add(c1);
        connList.add(c2);
        connList.add(c3);
        connList.add(c4);
    }

    private void initListener() {
        floatAdd.setOnClickListener(this);
        llSelf.setOnClickListener(this);
        imgSelfFolder.setOnClickListener(this);
        imgHelp.setOnClickListener(this);
    }

    private void initUi() {
        imgHelp = getActivity().findViewById(R.id.imgHelp);
        imgHelp.setVisibility(View.VISIBLE);
        imgProfile = getActivity().findViewById(R.id.imgProfile);
        imgProfile.setVisibility(View.GONE);
        txtSelf = getActivity().findViewById(R.id.txtSelf);
        txtSelf.setVisibility(View.GONE);
        txtName = getActivity().findViewById(R.id.txtName);
        txtName.setVisibility(View.VISIBLE);
        txtName.setGravity(View.TEXT_ALIGNMENT_CENTER);

        lvSelf = rootView.findViewById(R.id.lvSelf);
        floatAdd = rootView.findViewById(R.id.floatAdd);
        llSelf = rootView.findViewById(R.id.llSelf);
        imgSelfFolder = rootView.findViewById(R.id.imgSelfFolder);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgHelp:
                Intent intentUserIns = new Intent(getActivity(), UserInsActivity.class);
                startActivity(intentUserIns);
//                showInstructionDialog();
                break;
            case R.id.floatAdd:
                showContactDialog();
                break;
            case R.id.llSelf:
                Intent intentProfile = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intentProfile);
                break;
            case R.id.imgSelfFolder:
                callFragment(new FragmentDashboardNew());
                break;

        }
    }

    @SuppressLint("ResourceAsColor")
    private void showInstructionDialog() {
        final Dialog dialogInstruction = new Dialog(getActivity());
        dialogInstruction.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogInstruction.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        LayoutInflater lf = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogview = lf.inflate(R.layout.instruction_dialog, null);
        final TextView textOption1 = dialogview.findViewById(R.id.txtInstruction);
        final TextView textOption2 = dialogview.findViewById(R.id.txtCancel);
        final View viewIns = dialogview.findViewById(R.id.viewIns);

        textOption1.setText("User Instructions");
        textOption2.setText("Cancel");


        dialogInstruction.setContentView(dialogview);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogInstruction.getWindow().getAttributes());
        int width = (int) (getActivity().getResources().getDisplayMetrics().widthPixels * 0.95);
        lp.width = width;
        RelativeLayout.LayoutParams buttonLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        // buttonLayoutParams.setMargins(0, 0, 0, 10);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER_VERTICAL | Gravity.BOTTOM;
        dialogInstruction.getWindow().setAttributes(lp);
        dialogInstruction.setCanceledOnTouchOutside(false);
        dialogInstruction.show();


        textOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUserIns = new Intent(getActivity(), UserInsActivity.class);
                startActivity(intentUserIns);
                dialogInstruction.dismiss();
            }
        });


        textOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogInstruction.dismiss();
            }
        });
    }

    private void callFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.commit();
    }

    private void showContactDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        LayoutInflater lf = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogview = lf.inflate(R.layout.dialog_add_contacts, null);

        final TextView textOption1 = dialogview.findViewById(R.id.txtOption1);
        final TextView textOption2 = dialogview.findViewById(R.id.txtOption2);
        TextView textCancel = dialogview.findViewById(R.id.txtCancel);

        textOption1.setText("Create New");
        textOption2.setText("Import From Dropbox");

        dialog.setContentView(dialogview);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        int width = (int) (getActivity().getResources().getDisplayMetrics().widthPixels * 0.95);
        lp.width = width;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        dialog.getWindow().setAttributes(lp);
        dialog.show();

        textOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFloatDialog();
               /* Intent intent = new Intent(getActivity(), TransparentActivity.class);
                startActivity(intent);*/
                dialog.dismiss();
            }
        });

        textOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }

        });

        textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }


        });


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
        final FloatingActionButton floatNew = dialogview.findViewById(R.id.floatNew);

        dialog.setContentView(dialogview);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        // int width = (int) (getActivity().getResources().getDisplayMetrics().widthPixels * 0.95);
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
                dialog.dismiss();
            }

        });

        floatContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }


        });


    }
}
