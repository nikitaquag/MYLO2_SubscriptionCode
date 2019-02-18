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
        preferences = new Preferences(context);
        this.context = context;
        this.vitalList = this.vitalList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initImageLoader();
    }

    private void initImageLoader() {
        //Profile
        displayImageOptionsProfile = new DisplayImageOptions.Builder() // resource
                .resetViewBeforeLoading(true) // default
                .cacheInMemory(true) // default
                .cacheOnDisk(true) // default
                .showImageOnLoading(R.drawable.yellow)
                .considerExifParams(false) // default
//                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .displayer(new RoundedBitmapDisplayer(150)) // default //for square SimpleBitmapDisplayer()
                .handler(new Handler()) // default
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(displayImageOptionsProfile)
                .build();
        ImageLoader.getInstance().init(config);
        imageLoaderProfile = ImageLoader.getInstance();

        //Card
        displayImageOptionsCard = new DisplayImageOptions.Builder() // resource
                .resetViewBeforeLoading(true) // default
                .cacheInMemory(true) // default
                .cacheOnDisk(true) // default
                .showImageOnLoading(R.drawable.busi_card)
                .considerExifParams(false) // default
//                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .displayer(new SimpleBitmapDisplayer()) // default //for square SimpleBitmapDisplayer()
                .handler(new Handler()) // default
                .build();
        ImageLoaderConfiguration configs = new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(displayImageOptionsCard)
                .build();
        ImageLoader.getInstance().init(configs);
        imageLoaderCard = ImageLoader.getInstance();
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
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });
        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fr != null) {
                    fr.deleteVital(vitalList.get(position));
                }
            }
        });

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
                VitalSigns hospital = vitalList.get(position);
                i.putExtra("isEdit", true);
                i.putExtra("IsView", true);
                context.startActivity(i);
            }
        });
        holder.imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, GrabConnectionActivity.class);
                preferences.putString(PrefConstants.SOURCE, "HospitalViewData");
                //  Hospital hospital = vitalList.get(position);
                // i.putExtra("HospitalObject", hospital);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAddress, txtPhone, txtType, txtCategory;
        ImageView imgProfile, imgForward, imgEdit;
        ImageView imgNext;

        SwipeLayout swipeLayout;
        LinearLayout lincall, lintrash;
        RelativeLayout rlVital;
        // SwipeRevealLayout swipeLayout;

        public ViewHolder(View convertView) {
            super(convertView);
            lincall = itemView.findViewById(R.id.lincall);
            lintrash = itemView.findViewById(R.id.lintrash);
            rlVital = itemView.findViewById(R.id.rlVital);
            swipeLayout = itemView.findViewById(R.id.swipe);

            txtName = convertView.findViewById(R.id.txtName);
            txtAddress = convertView.findViewById(R.id.txtAddress);
            txtPhone = convertView.findViewById(R.id.txtPhone);
            txtType = convertView.findViewById(R.id.txtType);
            txtCategory = convertView.findViewById(R.id.txtCategory);
            imgProfile = convertView.findViewById(R.id.imgProfile);
            imgForward = convertView.findViewById(R.id.imgForword);
            imgEdit = convertView.findViewById(R.id.imgEdit);
            imgNext = convertView.findViewById(R.id.imgNext);
        }
    }

}

