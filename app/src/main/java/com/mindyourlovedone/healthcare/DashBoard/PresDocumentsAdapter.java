package com.mindyourlovedone.healthcare.DashBoard;

import android.content.Context;
import android.content.Intent;
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
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedone.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedone.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedone.healthcare.model.Form;

import java.util.ArrayList;

/**
 * Created by varsha on 8/23/2017. Changes done by nikita on 20/6/18. Changes done by shradha on 1/2/19
 */

public class PresDocumentsAdapter extends RecyclerSwipeAdapter<PresDocumentsAdapter.ViewHolder> {
    Context context;
    ArrayList<Form> documentList;
    LayoutInflater lf;

    FragmentPrescriptionUpload fr;

    public PresDocumentsAdapter(Context context, ArrayList<Form> documentList) {
        this.context = context;
        this.documentList = documentList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public PresDocumentsAdapter(Context context, ArrayList<Form> documentList, FragmentPrescriptionUpload fr) {
        this.fr = fr;
        this.context = context;
        this.documentList = documentList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public PresDocumentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_care_plan_new, parent, false);
        return new PresDocumentsAdapter.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return documentList.size();
    }

    @Override
    public void onBindViewHolder(final PresDocumentsAdapter.ViewHolder holder, final int position) {
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
                    fr.deleteDocument(documentList.get(position));
                }
            }
        });

        holder.txtDocHeader.setText(documentList.get(position).getName());
        holder.imgDocType.setImageResource(R.drawable.pres_two/*documentList.get(position).getImage()*/);
        holder.txtDocTime.setText("Last Update : "+documentList.get(position).getDate());
     //   holder.txtDocTime.setVisibility(View.GONE);
     /*   holder.imgForword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddInsuranceFormActivity.class);
                i.putExtra("GoTo", "View");
                *//*if (position>3)
                {
                    i.putExtra("Path","Yes");
                }
                else
                {
                    i.putExtra("Path","No");
                }*//*
                i.putExtra("FormObject", documentList.get(position));
                context.startActivity(i);
            }
        });*/
        holder.rlFix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PrescriptionUploadActivity.class);
                i.putExtra("GoTo", "Edit");
                i.putExtra("Path", "Yes");

                i.putExtra("FormObject", documentList.get(position));
                context.startActivity(i);
            }
        });
        holder.imgForword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PrescriptionUploadActivity.class);
                i.putExtra("GoTo", "Edit");
                i.putExtra("Path", "Yes");
                i.putExtra("FormObject", documentList.get(position));
                context.startActivity(i);
            }
        });
       /* holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddInsuranceFormActivity.class);
                i.putExtra("GoTo", "Edit");
                i.putExtra("Path", "Yes");
               *//* if (position>3)
                {

                }
                else
                {
                    i.putExtra("Path","No");
                }*//*
                i.putExtra("FormObject", documentList.get(position));
                context.startActivity(i);
            }
        });*/
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
