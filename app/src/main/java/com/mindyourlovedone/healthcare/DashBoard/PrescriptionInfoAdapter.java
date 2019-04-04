package com.mindyourlovedone.healthcare.DashBoard;

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
import com.mindyourlovedone.healthcare.Connections.GrabConnectionActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.InsuranceHealthCare.FragmentHospital;
import com.mindyourlovedone.healthcare.InsuranceHealthCare.FragmentPrescriptionInfo;
import com.mindyourlovedone.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedone.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedone.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedone.healthcare.model.Hospital;
import com.mindyourlovedone.healthcare.model.PrescribeImage;
import com.mindyourlovedone.healthcare.model.Prescription;
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

public class PrescriptionInfoAdapter extends RecyclerSwipeAdapter<PrescriptionInfoAdapter.ViewHolder> {
    Context context;
    ArrayList<Prescription> prescriptionList;
    LayoutInflater lf;
    Preferences preferences;
    ImageLoader imageLoaderProfile, imageLoaderCard;
    DisplayImageOptions displayImageOptionsProfile, displayImageOptionsCard;
    FragmentPrescriptionInfo fr;


    public PrescriptionInfoAdapter(Activity activity, ArrayList<Prescription> PrescriptionList, FragmentPrescriptionInfo fragmentPrescriptionInfo) {
        preferences = new Preferences(activity);
        this.context = activity;
        this.prescriptionList = PrescriptionList;
        this.fr  =fragmentPrescriptionInfo;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initImageLoader();
    }

    private void initImageLoader() {
        //Profile
        displayImageOptionsProfile = new DisplayImageOptions.Builder() // resource
                .resetViewBeforeLoading(true) // default
                .cacheInMemory(true) // default
                .cacheOnDisk(true) // default
                .showImageOnLoading(R.drawable.all_profile)
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
    public PrescriptionInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_care_plan_new, parent, false);
        return new PrescriptionInfoAdapter.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return prescriptionList.size();
    }

    @Override
    public void onBindViewHolder(final PrescriptionInfoAdapter.ViewHolder holder, final int position) {

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
                    fr.deletePrescription(prescriptionList.get(position));
                }
            }
        });

        holder.txtDocHeader.setText(prescriptionList.get(position).getMedicine());
        holder.imgDocType.setImageResource(R.drawable.pres_one/*documentList.get(position).getImage()*/);
//        holder.txtDocTime.setText("Last Update : "+documentList.get(position).getDate());
        if (prescriptionList.get(position).getDose().equals("") && prescriptionList.get(position).getFrequency().equals("")) {
            holder.txtDocTime.setVisibility(View.GONE);
        } else {
            holder.txtDocTime.setVisibility(View.VISIBLE);
            String dose = "", freq = "";
            if (prescriptionList.get(position).getFrequency().equals("") && !prescriptionList.get(position).getDose().equals("")) {
                freq = prescriptionList.get(position).getDose();
                holder.txtDocTime.setText(freq);
            }
            if (!prescriptionList.get(position).getFrequency().equals("") && prescriptionList.get(position).getDose().equals("")) {
                freq = prescriptionList.get(position).getFrequency();
                holder.txtDocTime.setText(freq);
            }
            if (!prescriptionList.get(position).getFrequency().equals("") && !prescriptionList.get(position).getDose().equals("")) {
                freq = prescriptionList.get(position).getDose() + "," + prescriptionList.get(position).getFrequency();
                holder.txtDocTime.setText(freq);
            }


        }

        holder.rlFix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddPrescriptionActivity.class);
                intent.putExtra("PrescriptionObject", prescriptionList.get(position));
                intent.putExtra("IsEdit", true);
                context.startActivity(intent);
            }
        });
        holder.imgForword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddPrescriptionActivity.class);
                intent.putExtra("PrescriptionObject", prescriptionList.get(position));
                intent.putExtra("IsEdit", true);
                context.startActivity(intent);
            }
        });

//        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
//            @Override
//            public void onOpen(SwipeLayout layout) {
//                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
//            }
//        });
//
//        holder.lintrash.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (context instanceof PrescriptionActivity) {
//                   fr.deletePrescription(prescriptionList.get(position));
////                }
//            }
//        });
//
//
//        ArrayList<PrescribeImage> PrescriptionImageList;
//          /* if (prescriptionList.get(position).getPrescriptionImageList()!=null) {
//                PrescriptionImageList = prescriptionList.get(position).getPrescriptionImageList();
//                for (int i=0;i<PrescriptionImageList.size();i++)
//                {
//                    LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                    View v = vi.inflate(R.layout.row_img, null);
//                    ImageView imgView = (ImageView) v.findViewById(R.id.img);
//                    byte[] bytea=PrescriptionImageList.get(i).getImage();
//                    Bitmap bmp = BitmapFactory.decodeByteArray(bytea, 0, bytea.length);
//                    imgView.setImageBitmap(bmp);
//                    holder.llImg.addView(v);
//                }
//            }*/
//      /*      if (prescriptionList.get(position).getDosageList()!=null)
//            {
//                ArrayList<Dosage> DosageList = prescriptionList.get(position).getDosageList();
//                for (int i = 0; i<DosageList.size(); i++)
//                {
//                    LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                    View v = vi.inflate(R.layout.row_txt, null);
//
//                    TextView textView = (TextView) v.findViewById(txt);
//                    TextView textViewName = (TextView) v.findViewById(R.id.txtName);
//                    textViewName.setText(DosageList.get(i).getMedicine());
//                    textView.setText(DosageList.get(i).getDose()+", "+DosageList.get(i).getFrequency());
//                    *//*if (i%2==0)
//                    {*//*
//                      *//*  v.setBackgroundResource(R.color.colorLightGray);
//                        textViewName.setBackgroundResource(R.color.colorLightGray);
//                        textView.setBackgroundResource(R.color.colorLightGray);*//*
//                  *//*  }else{
//                        v.setBackgroundResource(R.color.colorWhite);
//                        textViewName.setBackgroundResource(R.color.colorWhite);
//                        textView.setBackgroundResource(R.color.colorWhite);
//                    }*//*
//                    holder.llPrescription.addView(v);
//                }
//            }*/

//        holder.txtDoctor.setText(prescriptionList.get(position).getDoctor());
//        holder.txtDate.setText(prescriptionList.get(position).getDates());
//        if (prescriptionList.get(position).getDose().equals("") && prescriptionList.get(position).getFrequency().equals("")) {
//            holder.txt.setVisibility(View.GONE);
//        } else {
//            holder.txt.setVisibility(View.VISIBLE);
//            String dose = "", freq = "";
//            if (prescriptionList.get(position).getFrequency().equals("") && !prescriptionList.get(position).getDose().equals("")) {
//                freq = prescriptionList.get(position).getDose();
//                holder.txt.setText(freq);
//            }
//            if (!prescriptionList.get(position).getFrequency().equals("") && prescriptionList.get(position).getDose().equals("")) {
//                freq = prescriptionList.get(position).getFrequency();
//                holder.txt.setText(freq);
//            }
//            if (!prescriptionList.get(position).getFrequency().equals("") && !prescriptionList.get(position).getDose().equals("")) {
//                freq = prescriptionList.get(position).getDose() + "," + prescriptionList.get(position).getFrequency();
//                holder.txt.setText(freq);
//            }
//
//
//        }
//
//        holder.txtName.setText(prescriptionList.get(position).getMedicine());
//        /*Shradha  edit added for prescription*/
////        holder.relhead.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(context, AddPrescriptionActivity.class);
////                intent.putExtra("PrescriptionObject", prescriptionList.get(position));
////                intent.putExtra("IsEdit", true);
////                context.startActivity(intent);
////            }
////        });
//
////        holder.imgForward.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent i = new Intent(context, AddPrescriptionActivity.class);
////                //   preferences.putString(PrefConstants.SOURCE, "PrescriptionViewData");
////                Prescription prescription = prescriptionList.get(position);
////                i.putExtra("PrescriptionObject", prescription);
////                i.putExtra("IsView", true);
////                context.startActivity(i);
////            }
////        });
//        /*holder.txtNote.setText(prescriptionList.get(position).getTxtNote());
//        holder.txtDateTime.setText(prescriptionList.get(position).getTxtDate());
//        //holder.imgProfile.setImageResource(student.getImgid());
//       */
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDocHeader, txtDocDate, txtDocTime;
        ImageView imgDocType, imgForword, imgEdit;
        SwipeLayout swipeLayout;
        LinearLayout lintrash;
        RelativeLayout rlFix;

        public ViewHolder(View convertView) {
            super(convertView);
            swipeLayout = itemView.findViewById(R.id.swipe);
            lintrash = itemView.findViewById(R.id.lintrash);
            txtDocHeader = convertView.findViewById(R.id.txtDocHeader);
            txtDocTime = convertView.findViewById(R.id.txtDocTime);
            txtDocDate = convertView.findViewById(R.id.txtDocDate);
            imgDocType = convertView.findViewById(R.id.imgDocType);
            imgForword = convertView.findViewById(R.id.imgNext);
            imgEdit = convertView.findViewById(R.id.imgEdit);
            rlFix = convertView.findViewById(R.id.rlFix);
        }

    }

}

