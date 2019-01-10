package com.mindyourlovedone.healthcare.InsuranceHealthCare;

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
import com.mindyourlovedone.healthcare.DashBoard.AddFormActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedone.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedone.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedone.healthcare.model.Insurance;
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

/**
 * Created by varsha on 8/28/2017. Changes done by nikita on 18/6/18
 */

public class InsuranceAdapter extends RecyclerSwipeAdapter<InsuranceAdapter.ViewHolder> {
    Context context;
    //SwipeMenuListView lvInsurance;
    ArrayList<Insurance> insuranceList;
    LayoutInflater lf;
    Preferences preferences;

    ImageLoader imageLoaderProfile, imageLoaderCard;
    DisplayImageOptions displayImageOptionsProfile, displayImageOptionsCard;
    FragmentInsurance fr;

    public InsuranceAdapter(Context context, ArrayList<Insurance> insuranceList) {
        preferences = new Preferences(context);
        this.context = context;
        this.insuranceList = insuranceList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initImageLoader();
    }

    public InsuranceAdapter(Context context, ArrayList<Insurance> insuranceList, FragmentInsurance fr) {
        this.fr = fr;
        preferences = new Preferences(context);
        this.context = context;
        this.insuranceList = insuranceList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initImageLoader();
    }

    private void initImageLoader() {

        //Profile
        displayImageOptionsProfile = new DisplayImageOptions.Builder() // resource
                .resetViewBeforeLoading(true) // default
                .cacheInMemory(true) // default
                .cacheOnDisk(true) // default
                .showImageOnLoading(R.drawable.ic_profile_defaults)
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
    public InsuranceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_insurance, parent, false);
        return new InsuranceAdapter.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return insuranceList.size();
    }

    @Override
    public void onBindViewHolder(final InsuranceAdapter.ViewHolder holder, final int position) {
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
                    fr.callUser(insuranceList.get(position));
                }
            }
        });
        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fr != null) {
                    fr.deleteInsurance(insuranceList.get(position));
                }
            }
        });

        String name = insuranceList.get(position).getName();
        String type = insuranceList.get(position).getType();
        if (!type.equals("")) {
            if (type.equals("Other")) {
                holder.txtName.setText(name + " - " + insuranceList.get(position).getOtherInsurance());
            } else {
                holder.txtName.setText(name + " - " + type);
            }
        } else {
            holder.txtName.setText(name);
        }

        if (insuranceList.get(position).getPhone().equals("")) {
            holder.txtPhone.setVisibility(View.GONE);
        } else {
            holder.txtPhone.setVisibility(View.VISIBLE);
        }
        holder.txtPhone.setText(insuranceList.get(position).getPhone());
        //  holder.imgProfile.setImageResource(insuranceList.get(position).getImage());

        File imgFile = new File(preferences.getString(PrefConstants.CONNECTED_PATH), insuranceList.get(position).getPhoto());
        holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));

        if (imgFile.exists() ) {
            if (holder.imgProfile.getDrawable() == null)
                holder.imgProfile.setImageResource(R.drawable.lightblue);
            else
                holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));
            // imageLoaderProfile.displayImage(String.valueOf(Uri.fromFile(imgFile)), viewHolder.imgProfile, displayImageOptionsProfile);
        }


        if (!insuranceList.get(position).getPhotoCard().equals("")) {
            File imgFile1 = new File(preferences.getString(PrefConstants.CONNECTED_PATH), insuranceList.get(position).getPhotoCard());
            if (imgFile1.exists()) {
               /* Bitmap myBitmap = BitmapFactory.decodeFile(imgFile1.getAbsolutePath());
                holder.imgForword.setImageBitmap(myBitmap);*/
                imageLoaderCard.displayImage(String.valueOf(Uri.fromFile(imgFile1)), holder.imgForword, displayImageOptionsCard);
            }
          /*  byte[] photoCard = insuranceList.get(position).getPhotoCard();
            Bitmap bmpCard = BitmapFactory.decodeByteArray(photoCard, 0, photoCard.length);*/
            // holder.imgForword.setImageBitmap(bmpCard);
            holder.imgForword.setVisibility(View.VISIBLE);
        } else {
            holder.imgForword.setVisibility(View.GONE);
        }


        holder.imgForword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddFormActivity.class);
                i.putExtra("Image", insuranceList.get(position).getPhotoCard());
                context.startActivity(i);
            }
        });


        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GrabConnectionActivity.class);
                preferences.putString(PrefConstants.SOURCE, "InsuranceData");
                Insurance insurance = insuranceList.get(position);
                i.putExtra("InsuranceObject", insurance);
                context.startActivity(i);
            }
        });
        holder.imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GrabConnectionActivity.class);
                preferences.putString(PrefConstants.SOURCE, "InsuranceViewData");
                Insurance insurance = insuranceList.get(position);
                i.putExtra("InsuranceObject", insurance);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtId, txtPhone, txtGroup, txtType;
        ImageView imgProfile, imgForword, imgEdit;
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

            txtPhone = convertView.findViewById(R.id.txtPhone);
            imgForword = convertView.findViewById(R.id.imgForword);
            imgProfile = convertView.findViewById(R.id.imgProfile);
            // holder.swipeLayout= (SwipeRevealLayout) convertView.findViewById(R.id.swipe_layout);
            imgEdit = convertView.findViewById(R.id.imgEdit);
            imgNext = convertView.findViewById(R.id.imgNext);
        }
    }
}