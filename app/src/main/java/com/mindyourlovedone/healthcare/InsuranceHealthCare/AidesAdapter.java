package com.mindyourlovedone.healthcare.InsuranceHealthCare;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.mindyourlovedone.healthcare.model.Aides;
import com.mindyourlovedone.healthcare.utility.PrefConstants;
import com.mindyourlovedone.healthcare.utility.Preferences;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by varsha on 8/28/2017. Changes done by nikita on 18/6/18
 */

public class AidesAdapter extends RecyclerSwipeAdapter<AidesAdapter.ViewHolder> {
    Context context;
    ArrayList<Aides> AidesList;
    LayoutInflater lf;
    Preferences preferences;
    FragmentAids fr;

    public AidesAdapter(Context context, ArrayList<Aides> AidesList) {
        preferences = new Preferences(context);
        this.context = context;
        this.AidesList = AidesList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public AidesAdapter(Context context, ArrayList<Aides> AidesList, FragmentAids fr) {
        this.fr = fr;
        preferences = new Preferences(context);
        this.context = context;
        this.AidesList = AidesList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public AidesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_aides, parent, false);
        return new AidesAdapter.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return AidesList.size();
    }

    @Override
    public void onBindViewHolder(final AidesAdapter.ViewHolder holder, final int position) {
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
                    fr.callUser(AidesList.get(position));
                }
            }
        });
        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fr != null) {
                    fr.deleteAides(AidesList.get(position));
                }
            }
        });

        if (AidesList.get(position).getOfficePhone().equals("")) {
            holder.txtPhone.setVisibility(View.GONE);
        } else {
            holder.txtPhone.setVisibility(View.VISIBLE);
        }

        if (AidesList.get(position).getAddress().equals("")) {
            holder.txtAddress.setVisibility(View.GONE);
        } else {
            holder.txtAddress.setVisibility(View.VISIBLE);
        }
        holder.txtName.setText(AidesList.get(position).getAidName());
        holder.txtAddress.setText(AidesList.get(position).getAddress());
        holder.txtPhone.setText(AidesList.get(position).getOfficePhone());
        // holder.imgProfile.setImageResource(AidesList.get(position).getImage());
        /*byte[] photo=AidesList.get(position).getPhoto();
        Bitmap bmp = BitmapFactory.decodeByteArray(photo, 0, photo.length);
        holder.imgProfile.setImageBitmap(bmp);*/

        File imgFile = new File(AidesList.get(position).getPhoto());
        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            holder.imgProfile.setImageBitmap(myBitmap);
        }

        if (AidesList.get(position).getPhotoCard() != null) {
            File imgFile1 = new File(AidesList.get(position).getPhotoCard());
            if (imgFile1.exists()) {
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile1.getAbsolutePath());
                holder.imgForword.setImageBitmap(myBitmap);
            }
            /*byte[] photoCard = AidesList.get(position).getPhotoCard();
            Bitmap bmpCard = BitmapFactory.decodeByteArray(photoCard, 0, photoCard.length);
            holder.imgForword.setImageBitmap(bmpCard);*/
            holder.imgForword.setVisibility(View.VISIBLE);
        } else {
            holder.imgForword.setVisibility(View.GONE);
        }


        holder.imgForword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddFormActivity.class);
                i.putExtra("Image", AidesList.get(position).getPhotoCard());
                context.startActivity(i);
            }
        });


        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GrabConnectionActivity.class);
                preferences.putString(PrefConstants.SOURCE, "AidesData");
                Aides aides = AidesList.get(position);
                i.putExtra("AideObject", aides);
                context.startActivity(i);
            }
        });
        holder.imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GrabConnectionActivity.class);
                preferences.putString(PrefConstants.SOURCE, "AidesViewData");
                Aides aides = AidesList.get(position);
                i.putExtra("AideObject", aides);
                context.startActivity(i);
            }
        });

    }


    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAddress, txtPhone, txtType;
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
            txtAddress = convertView.findViewById(R.id.txtAddress);
            txtPhone = convertView.findViewById(R.id.txtPhone);
            txtType = convertView.findViewById(R.id.txtType);
            imgProfile = convertView.findViewById(R.id.imgProfile);
            imgForword = convertView.findViewById(R.id.imgForword);
            imgEdit = convertView.findViewById(R.id.imgEdit);
            imgNext = convertView.findViewById(R.id.imgNext);
        }
    }
}