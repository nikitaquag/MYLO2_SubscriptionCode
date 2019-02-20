package com.mindyourlovedone.healthcare.InsuranceHealthCare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mindyourlovedone.healthcare.Activity.AddVitalSignsActivity;
import com.mindyourlovedone.healthcare.Connections.GrabConnectionActivity;
import com.mindyourlovedone.healthcare.DashBoard.AddFormActivity;
import com.mindyourlovedone.healthcare.DashBoard.PrescriptionInfoAdapter;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedone.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedone.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedone.healthcare.model.Hospital;
import com.mindyourlovedone.healthcare.model.VitalSigns;
import com.mindyourlovedone.healthcare.utility.PrefConstants;
import com.mindyourlovedone.healthcare.utility.Preferences;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

import java.io.File;
import java.util.ArrayList;

public class VitalAdpater extends RecyclerSwipeAdapter<VitalAdpater.ViewHolder> {
    Context context;
    ArrayList<VitalSigns> vitalList;
    LayoutInflater lf;
    Preferences preferences;
    ImageLoader imageLoaderProfile, imageLoaderCard;
    DisplayImageOptions displayImageOptionsProfile, displayImageOptionsCard;
    FragmentVitalSigns fr;


    public VitalAdpater(Activity activity, ArrayList<VitalSigns> vitalList, FragmentVitalSigns fragmentVitalSigns) {
        // preferences = new Preferences(context);
        this.context = activity;
        this.vitalList = vitalList;
        this.fr = fragmentVitalSigns;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public VitalAdpater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_vital, parent, false);
        return new VitalAdpater.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return vitalList.size();
    }

    @Override
    public void onBindViewHolder(final VitalAdpater.ViewHolder holder, final int position) {
/*
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });
*/

 /*
        if (vitalList.get(position).getOfficePhone().equals("")) {
            holder.txtPhone.setVisibility(View.GONE);
        } else {
            holder.txtPhone.setVisibility(View.VISIBLE);
        }

        if (vitalList.get(position).getAddress().equals("")) {
            holder.txtAddress.setVisibility(View.GONE);
        } else {
            holder.txtAddress.setVisibility(View.VISIBLE);
        }

       if (vitalList.get(position).getCategory().equals("")) {
            holder.txtCategory.setVisibility(View.GONE);
        } else {
            holder.txtCategory.setVisibility(View.VISIBLE);
        }
        holder.txtName.setText(vitalList.get(position).getName());
        holder.txtAddress.setText(vitalList.get(position).getAddress());
        holder.txtPhone.setText(vitalList.get(position).getOfficePhone());
        holder.txtType.setText(vitalList.get(position).getName());
        if (vitalList.get(position).getCategory().equals("Other")) {
            holder.txtCategory.setText(vitalList.get(position).getCategory() + " - " + vitalList.get(position).getOtherCategory());
        } else {
            holder.txtCategory.setText(vitalList.get(position).getCategory());
        }*/
        //holder.imgProfile.setImageResource(FinanceList.get(position).getImage());


        holder.rlVital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddVitalSignsActivity.class);
                // VitalSigns hospital = vitalList.get(position);
               // i.putExtra("isEdit", true);
                i.putExtra("isEdit","IsEDIT");
                i.putExtra("Date", "Date");
                i.putExtra("Time", "Time");
                // i.putExtra("IsView", true);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtBP, txtBPValue, txtHR, txtHRValue, txtTemp, txtTempValue, txtDate, txtTime;
        ImageView imgDropDown;

        SwipeLayout swipeLayout;
        RelativeLayout rlVital;

        public ViewHolder(View convertView) {
            super(convertView);
            txtBP = convertView.findViewById(R.id.txtBP);
            txtBPValue = convertView.findViewById(R.id.txtBpValue);
            txtHR = convertView.findViewById(R.id.txtHR);
            txtHRValue = convertView.findViewById(R.id.txtHRValue);
            txtTemp = convertView.findViewById(R.id.txtTemp);
            txtTempValue = convertView.findViewById(R.id.txtTempValue);
            txtDate = convertView.findViewById(R.id.txtDate);
            txtTime = convertView.findViewById(R.id.txtTime);
            rlVital = convertView.findViewById(R.id.rlVital);

            imgDropDown = convertView.findViewById(R.id.imgDropDown);
        }
    }

}

