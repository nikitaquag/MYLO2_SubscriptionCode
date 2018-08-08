package com.mindyourlovedones.healthcare.DashBoard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mindyourlovedones.healthcare.HomeActivity.R;
import com.mindyourlovedones.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedones.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedones.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedones.healthcare.model.PrescribeImage;
import com.mindyourlovedones.healthcare.model.Prescription;
import com.mindyourlovedones.healthcare.utility.Preferences;

import java.util.ArrayList;

/**
 * Created by welcome on 9/18/2017. Changes done by nikita on 18/6/18
 */

class PrescriptionAdapter extends RecyclerSwipeAdapter<PrescriptionAdapter.Holder> {
    Context context;
    ArrayList<Prescription> prescriptionList;
    LayoutInflater lf;
    Preferences preferences;

    public PrescriptionAdapter(Context context, ArrayList prescriptionList) {
        this.context = context;
        this.prescriptionList = prescriptionList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public PrescriptionAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_prescription, parent, false);
        return new PrescriptionAdapter.Holder(view);
    }

    @Override
    public int getItemCount() {
        return prescriptionList.size();
    }

    @Override
    public void onBindViewHolder(final PrescriptionAdapter.Holder holder, final int position) {
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });

        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof PrescriptionActivity) {
                    ((PrescriptionActivity) context).deletePrescription(prescriptionList.get(position));
                }
            }
        });


        ArrayList<PrescribeImage> PrescriptionImageList;
          /* if (prescriptionList.get(position).getPrescriptionImageList()!=null) {
                PrescriptionImageList = prescriptionList.get(position).getPrescriptionImageList();
                for (int i=0;i<PrescriptionImageList.size();i++)
                {
                    LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View v = vi.inflate(R.layout.row_img, null);
                    ImageView imgView = (ImageView) v.findViewById(R.id.img);
                    byte[] bytea=PrescriptionImageList.get(i).getImage();
                    Bitmap bmp = BitmapFactory.decodeByteArray(bytea, 0, bytea.length);
                    imgView.setImageBitmap(bmp);
                    holder.llImg.addView(v);
                }
            }*/
      /*      if (prescriptionList.get(position).getDosageList()!=null)
            {
                ArrayList<Dosage> DosageList = prescriptionList.get(position).getDosageList();
                for (int i = 0; i<DosageList.size(); i++)
                {
                    LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View v = vi.inflate(R.layout.row_txt, null);

                    TextView textView = (TextView) v.findViewById(txt);
                    TextView textViewName = (TextView) v.findViewById(R.id.txtName);
                    textViewName.setText(DosageList.get(i).getMedicine());
                    textView.setText(DosageList.get(i).getDose()+", "+DosageList.get(i).getFrequency());
                    *//*if (i%2==0)
                    {*//*
                      *//*  v.setBackgroundResource(R.color.colorLightGray);
                        textViewName.setBackgroundResource(R.color.colorLightGray);
                        textView.setBackgroundResource(R.color.colorLightGray);*//*
                  *//*  }else{
                        v.setBackgroundResource(R.color.colorWhite);
                        textViewName.setBackgroundResource(R.color.colorWhite);
                        textView.setBackgroundResource(R.color.colorWhite);
                    }*//*
                    holder.llPrescription.addView(v);
                }
            }*/

        holder.txtDoctor.setText(prescriptionList.get(position).getDoctor());
        holder.txtDate.setText(prescriptionList.get(position).getDates());
        if (prescriptionList.get(position).getDose().equals("") && prescriptionList.get(position).getFrequency().equals("")) {
            holder.txt.setVisibility(View.GONE);
        } else {
            holder.txt.setVisibility(View.VISIBLE);
            String dose = "", freq = "";
            if (prescriptionList.get(position).getFrequency().equals("") && !prescriptionList.get(position).getDose().equals("")) {
                freq = prescriptionList.get(position).getDose();
                holder.txt.setText(freq);
            }
            if (!prescriptionList.get(position).getFrequency().equals("") && prescriptionList.get(position).getDose().equals("")) {
                freq = prescriptionList.get(position).getFrequency();
                holder.txt.setText(freq);
            }
            if (!prescriptionList.get(position).getFrequency().equals("") && !prescriptionList.get(position).getDose().equals("")) {
                freq = prescriptionList.get(position).getDose() + "," + prescriptionList.get(position).getFrequency();
                holder.txt.setText(freq);
            }


        }

        holder.txtName.setText(prescriptionList.get(position).getMedicine());
        /*Shradha  edit added for prescription*/
        holder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddPrescriptionActivity.class);
                intent.putExtra("PrescriptionObject", prescriptionList.get(position));
                intent.putExtra("IsEdit", true);
                context.startActivity(intent);
            }
        });

        holder.imgForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, AddPrescriptionActivity.class);
             //   preferences.putString(PrefConstants.SOURCE, "PrescriptionViewData");
                Prescription prescription = prescriptionList.get(position);
                i.putExtra("PrescriptionObject", prescription);
                i.putExtra("IsView", true);
                context.startActivity(i);
            }
        });
        /*holder.txtNote.setText(prescriptionList.get(position).getTxtNote());
        holder.txtDateTime.setText(prescriptionList.get(position).getTxtDate());
        //holder.imgProfile.setImageResource(student.getImgid());
       */
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView txtDoctor, txtDate, txtTime, txt, txtName;
        LinearLayout llImg, llPrescription;
        ImageView imgForward;
        SwipeLayout swipeLayout;
        LinearLayout lintrash;
        // SwipeRevealLayout swipeLayout;

        public Holder(View convertView) {
            super(convertView);
            lintrash = itemView.findViewById(R.id.lintrash);
            swipeLayout = itemView.findViewById(R.id.swipe);

            txtDoctor = convertView.findViewById(R.id.txtDoctor);
            txtDate = convertView.findViewById(R.id.txtDate);
            txt = convertView.findViewById(R.id.txt);
            txtName = convertView.findViewById(R.id.txtName);
            llImg = convertView.findViewById(R.id.llImg);
            llPrescription = convertView.findViewById(R.id.llPrescription);
            imgForward = convertView.findViewById(R.id.imgForword);
        }
    }
}