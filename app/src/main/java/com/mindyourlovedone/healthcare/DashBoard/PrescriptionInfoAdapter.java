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
    ArrayList<Hospital> hospitalList;
    LayoutInflater lf;
    Preferences preferences;
    ImageLoader imageLoaderProfile, imageLoaderCard;
    DisplayImageOptions displayImageOptionsProfile, displayImageOptionsCard;
    FragmentHospital fr;


    public PrescriptionInfoAdapter(Activity activity, ArrayList<Hospital> hospitalList, FragmentPrescriptionInfo fragmentPrescriptionInfo) {
        preferences = new Preferences(context);
        this.context = context;
        this.hospitalList = this.hospitalList;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pres_info, parent, false);
        return new PrescriptionInfoAdapter.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    @Override
    public void onBindViewHolder(final PrescriptionInfoAdapter.ViewHolder holder, final int position) {
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });
        holder.lincall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fr != null) {
                    fr.callUser(hospitalList.get(position));
                }
            }
        });
        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fr != null) {
                    fr.deleteHospital(hospitalList.get(position));
                }
            }
        });


        if (hospitalList.get(position).getOfficePhone().equals("")) {
            holder.txtPhone.setVisibility(View.GONE);
        } else {
            holder.txtPhone.setVisibility(View.VISIBLE);
        }

        if (hospitalList.get(position).getAddress().equals("")) {
            holder.txtAddress.setVisibility(View.GONE);
        } else {
            holder.txtAddress.setVisibility(View.VISIBLE);
        }

        if (hospitalList.get(position).getCategory().equals("")) {
            holder.txtCategory.setVisibility(View.GONE);
        } else {
            holder.txtCategory.setVisibility(View.VISIBLE);
        }
        holder.txtName.setText(hospitalList.get(position).getName());
        holder.txtAddress.setText(hospitalList.get(position).getAddress());
        holder.txtPhone.setText(hospitalList.get(position).getOfficePhone());
        holder.txtType.setText(hospitalList.get(position).getName());
        if (hospitalList.get(position).getCategory().equals("Other")) {
            holder.txtCategory.setText(hospitalList.get(position).getCategory() + " - " + hospitalList.get(position).getOtherCategory());
        } else {
            holder.txtCategory.setText(hospitalList.get(position).getCategory());
        }
        //holder.imgProfile.setImageResource(FinanceList.get(position).getImage());
        File imgFile = new File(preferences.getString(PrefConstants.CONNECTED_PATH), hospitalList.get(position).getPhoto());
        holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));

        if (imgFile.exists()) {
            if (holder.imgProfile.getDrawable() == null)
                holder.imgProfile.setImageResource(R.drawable.all_profile);
            else
                holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));
            // imageLoaderProfile.displayImage(String.valueOf(Uri.fromFile(imgFile)), viewHolder.imgProfile, displayImageOptionsProfile);
        }

       /* if (imgFile.exists()) {
           // imageLoaderProfile.displayImage(String.valueOf(Uri.fromFile(imgFile)), holder.imgProfile, displayImageOptionsProfile);
            holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));
          //  holder.imgProfile.setImageResource(R.drawable.yellow);
        }else {
            holder.imgProfile.setImageResource(R.drawable.yellow);
        }*/

        if (!hospitalList.get(position).getPhotoCard().equals("")) {
            File imgFile1 = new File(preferences.getString(PrefConstants.CONNECTED_PATH), hospitalList.get(position).getPhotoCard());
            if (imgFile1.exists()) {
               /* Bitmap myBitmap = BitmapFactory.decodeFile(imgFile1.getAbsolutePath());
                holder.imgForward.setImageBitmap(myBitmap);*/
                imageLoaderCard.displayImage(String.valueOf(Uri.fromFile(imgFile1)), holder.imgForward, displayImageOptionsCard);
            }
          /*  byte[] photoCard = hospitalList.get(position).getPhotoCard();
            Bitmap bmpCard = BitmapFactory.decodeByteArray(photoCard, 0, photoCard.length);
            holder.imgForward.setImageBitmap(bmpCard);*/
            holder.imgForward.setVisibility(View.VISIBLE);
        } else {
            holder.imgForward.setVisibility(View.GONE);
        }


        holder.imgForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddFormActivity.class);
                i.putExtra("Image", hospitalList.get(position).getPhotoCard());
                context.startActivity(i);
            }
        });


        holder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GrabConnectionActivity.class);
                preferences.putString(PrefConstants.SOURCE, "HospitalData");
                Hospital hospital = hospitalList.get(position);
                i.putExtra("HospitalObject", hospital);
                context.startActivity(i);
            }
        });
        holder.imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, GrabConnectionActivity.class);
                preferences.putString(PrefConstants.SOURCE, "HospitalViewData");
                Hospital hospital = hospitalList.get(position);
                i.putExtra("HospitalObject", hospital);
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
        // SwipeRevealLayout swipeLayout;

        public ViewHolder(View convertView) {
            super(convertView);
            lincall = itemView.findViewById(R.id.lincall);
            lintrash = itemView.findViewById(R.id.lintrash);
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

