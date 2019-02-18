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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mindyourlovedone.healthcare.Connections.GrabConnectionActivity;
import com.mindyourlovedone.healthcare.DashBoard.AddFormActivity;
import com.mindyourlovedone.healthcare.DashBoard.FragmentPhysician;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedone.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedone.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedone.healthcare.model.Specialist;
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

public class SpecialistAdapter extends RecyclerSwipeAdapter<SpecialistAdapter.ViewHolder> {
    Context context;
    ArrayList<Specialist> specialistList;
    LayoutInflater lf;
    Preferences preferences;
    ImageLoader imageLoaderProfile, imageLoaderCard;
    DisplayImageOptions displayImageOptionsProfile, displayImageOptionsCard;
    FragmentPhysician fr;
    FragmentSpecialist frs;
    boolean specialist = true;
    boolean physician = true;


    public SpecialistAdapter(Context context, ArrayList<Specialist> specialistList) {
        preferences = new Preferences(context);
        this.context = context;
        this.specialistList = specialistList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initImageLoader();
    }

    public SpecialistAdapter(Context context, ArrayList<Specialist> specialistList, FragmentPhysician fr) {
        this.fr = fr;
        preferences = new Preferences(context);
        this.context = context;
        this.specialistList = specialistList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initImageLoader();
    }

    public SpecialistAdapter(Context context, ArrayList<Specialist> specialistList, FragmentSpecialist frs, boolean specialist) {
        this.frs = frs;
        preferences = new Preferences(context);
        this.context = context;
        this.specialistList = specialistList;
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
    public SpecialistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_doctor, parent, false);
        return new SpecialistAdapter.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return specialistList.size();
    }

    @Override
    public void onBindViewHolder(final SpecialistAdapter.ViewHolder holder, final int position) {
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });
        holder.imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (specialist) {
                    if (frs != null) {
                        frs.callUser(specialistList.get(position));
                    } else if (physician) {
                        if (fr != null) {
                            fr.callUser(specialistList.get(position));
                        }
                    }
                }
            }
        });
        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (specialist) {
                    if (frs != null) {
                        frs.deleteSpecialist(specialistList.get(position));
                    } else if (physician == true) {
                        if (fr != null) {
                            fr.deleteSpecialist(specialistList.get(position));
                        }
                    }
                }
            }
        });

//Shradha-physician and doctor color change for profile
        File imgFile = new File(preferences.getString(PrefConstants.CONNECTED_PATH), specialistList.get(position).getPhoto());
        holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));

/*
        if (imgFile.exists() ) {
            if (viewHolder.imgProfile.getDrawable() == null)
                viewHolder.imgProfile.setImageResource(R.drawable.green);
            else
                viewHolder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));
            // imageLoaderProfile.displayImage(String.valueOf(Uri.fromFile(imgFile)), viewHolder.imgProfile, displayImageOptionsProfile);
        }
*/

        if (imgFile.exists()) {
            // imageLoaderProfile.displayImage(String.valueOf(Uri.fromFile(imgFile)), holder.imgProfile, displayImageOptionsProfile);
            holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));

            if (specialist) {
                if (frs != null) {
                    if (holder.imgProfile.getDrawable() == null) {
                        holder.imgProfile.setImageResource(R.drawable.yellow);
                    } else {
                        holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));
                    }
                }
            }
            if (physician) {
                if (fr != null) {
                    if (holder.imgProfile.getDrawable() == null) {
                        holder.imgProfile.setImageResource(R.drawable.green);
                    } else {
                        holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));
                    }
                }
            }



/*
            if (specialist||physician) {  // Rahul
                if (frs != null) {
                    holder.imgProfile.setImageResource(R.drawable.yellow);
                }
                else
                    holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));

                if (physician) {
                    if (fr != null) {
                        holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));

                        //  holder.imgProfile.setImageResource(R.drawable.green);
                    }
                    else
                        holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));

                    // holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));

                }
            }
*/
        }
        //shradha- new change for distinguishing images for doctor and physician if image does not exists
        else {
            if (physician) {
                if (fr != null) {
                    if (holder.imgProfile.getDrawable() == null) {
                        holder.imgProfile.setImageResource(R.drawable.green);
                    } else {
                        Toast.makeText(context, "Not Physician", Toast.LENGTH_SHORT).show();

                        // holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));
                    }
                }
            }
            if (specialist) {
                if (frs != null) {
                    if (holder.imgProfile.getDrawable() == null) {
                        holder.imgProfile.setImageResource(R.drawable.yellow);
                    } else {
                        Toast.makeText(context, "Not Doctor", Toast.LENGTH_SHORT).show();
                        //  holder.imgProfile.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));
                    }
                }
            }
          //  holder.imgProfile.setImageResource(R.drawable.ic_profile_defaults);
        }


        if (specialistList.get(position).getOfficePhone().equals("")) {
            holder.txtPhone.setVisibility(View.GONE);
        }
        //Commented as to match screen as invision-shradha
        /*else {
            holder.txtPhone.setVisibility(View.VISIBLE);
        }*/
        if (specialistList.get(position).getAddress().equals("")) {
            holder.txtAddress.setVisibility(View.GONE);
        }
        //Commented as to match screen as invision-shradha
        /* else {
            holder.txtAddress.setVisibility(View.VISIBLE);
        }*/
        if (specialistList.get(position).getType().equals("")) {
            holder.txtType.setVisibility(View.GONE);
        } else {
            holder.txtType.setVisibility(View.VISIBLE);
        }

        holder.txtName.setText(specialistList.get(position).getName());
        holder.txtOfficePhone.setText(specialistList.get(position).getOtherPhone());
        //Commented as to match screen as invision-shradha
      //  holder.txtPhone.setText(specialistList.get(position).getOfficePhone());
        if (specialistList.get(position).getType().equals("Other")) {
            holder.txtType.setText(specialistList.get(position).getType() + " - " + specialistList.get(position).getOtherType());
        } else {
            holder.txtType.setText(specialistList.get(position).getType());
        }
        // holder.txtType.setText(specialistList.get(position).getType());
        holder.txtTelePhone.setText(specialistList.get(position).getOtherPhone());
        //Commented as to match screen as invision-shradha
       // holder.txtAddress.setText(specialistList.get(position).getAddress());
        //  holder.imgProfile.setImageResource(specialistList.get(position).getImage());

//  Card code for Speciality Adapter
        if (!specialistList.get(position).getPhotoCard().equals("")) {
            File imgFile1 = new File(preferences.getString(PrefConstants.CONNECTED_PATH), specialistList.get(position).getPhotoCard());
            if (imgFile1.exists()) {
                // holder.imgForword.setImageURI(Uri.parse(String.valueOf(Uri.fromFile(imgFile))));

                imageLoaderCard.displayImage(String.valueOf(Uri.fromFile(imgFile1)), holder.imgForword, displayImageOptionsCard);
            }
            //Commented as to match screen as invision-shradha
           // holder.imgForword.setVisibility(View.VISIBLE);
        } else {
            holder.imgForword.setVisibility(View.GONE);
        }

        holder.imgForword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddFormActivity.class);
                i.putExtra("Image", specialistList.get(position).getPhotoCard());
                context.startActivity(i);
            }
        });
        holder.rlDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GrabConnectionActivity.class);
                Specialist insurance = specialistList.get(position);
                if (insurance.getIsPhysician() == 1) {
                    preferences.putString(PrefConstants.SOURCE, "PhysicianData");
                } else if (insurance.getIsPhysician() == 2) {
                    preferences.putString(PrefConstants.SOURCE, "SpecialistData");
                }
               /* i.putExtra("Name", insurance.getName());
                i.putExtra("Type", insurance.getType());
                i.putExtra("Address", insurance.getAddress());
                i.putExtra("Phone", insurance.getOfficePhone());
                i.putExtra("Photo", insurance.getImage());*/
                i.putExtra("SpecialistObject", insurance);
                i.putExtra("IsPhysician", insurance.getIsPhysician());
                context.startActivity(i);
            }
        });
      /*  holder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GrabConnectionActivity.class);
                Specialist insurance = specialistList.get(position);
                if (insurance.getIsPhysician() == 1) {
                    preferences.putString(PrefConstants.SOURCE, "PhysicianData");
                } else if (insurance.getIsPhysician() == 2) {
                    preferences.putString(PrefConstants.SOURCE, "SpecialistData");
                }
               *//* i.putExtra("Name", insurance.getName());
                i.putExtra("Type", insurance.getType());
                i.putExtra("Address", insurance.getAddress());
                i.putExtra("Phone", insurance.getOfficePhone());
                i.putExtra("Photo", insurance.getImage());*//*
                i.putExtra("SpecialistObject", insurance);
                i.putExtra("IsPhysician", insurance.getIsPhysician());
                context.startActivity(i);
            }
        });*/

       /* holder.imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GrabConnectionActivity.class);
                Specialist insurance = specialistList.get(position);
                if (insurance.getIsPhysician() == 1) {
                    preferences.putString(PrefConstants.SOURCE, "PhysicianViewData");
                } else if (insurance.getIsPhysician() == 2) {
                    preferences.putString(PrefConstants.SOURCE, "SpecialistViewData");
                }
                i.putExtra("SpecialistObject", insurance);
                i.putExtra("IsPhysician", insurance.getIsPhysician());
                context.startActivity(i);
            }
        });*/
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAddress, txtPhone, txtType, txtTelePhone, txtOfficePhone;
        ImageView imgProfile, imgForword, imgEdit, imgNext;
        RelativeLayout rlMain, rlDoctor;
        SwipeLayout swipeLayout;
        LinearLayout lincall, lintrash;

        public ViewHolder(View convertView) {
            super(convertView);
            lincall = convertView.findViewById(R.id.lincall);
            lintrash = convertView.findViewById(R.id.lintrash);
            swipeLayout = convertView.findViewById(R.id.swipe);
            txtName = convertView.findViewById(R.id.txtName);
            rlDoctor = convertView.findViewById(R.id.rlDoctor);
            txtAddress = convertView.findViewById(R.id.txtAddress);
            txtPhone = convertView.findViewById(R.id.txtPhone);
            txtOfficePhone = convertView.findViewById(R.id.txtOfficePhone);
            txtTelePhone = convertView.findViewById(R.id.txtTelePhone);
            txtType = convertView.findViewById(R.id.txtType);
            imgProfile = convertView.findViewById(R.id.imgProfile);
            //  holder.swipeLayout = (SwipeRevealLayout) convertView.findViewById(R.id.swipe_layout);
            imgForword = convertView.findViewById(R.id.imgForword);
            imgEdit = convertView.findViewById(R.id.imgEdit);
            imgNext = convertView.findViewById(R.id.imgNext);
        }
    }
}