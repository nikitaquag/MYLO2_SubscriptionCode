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
import com.mindyourlovedones.healthcare.model.Form;

import java.util.ArrayList;

/**
 * Created by varsha on 8/23/2017. Changes done by nikita on 20/6/18
 */

public class DocumentsAdapter extends RecyclerSwipeAdapter<DocumentsAdapter.ViewHolder> {
    Context context;
    ArrayList<Form> documentList;
    LayoutInflater lf;

    FragementForm fr;

    public DocumentsAdapter(Context context, ArrayList<Form> documentList) {
        this.context = context;
        this.documentList = documentList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public DocumentsAdapter(Context context, ArrayList<Form> documentList, FragementForm fr) {
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
    public DocumentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_care_plan_new, parent, false);
        return new DocumentsAdapter.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return documentList.size();
    }

    @Override
    public void onBindViewHolder(final DocumentsAdapter.ViewHolder holder, final int position) {
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
        holder.imgDocType.setImageResource(documentList.get(position).getImage());
        holder.txtDocTime.setVisibility(View.GONE);
        holder.imgForword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddInsuranceFormActivity.class);
                i.putExtra("GoTo", "View");
                /*if (position>3)
                {
                    i.putExtra("Path","Yes");
                }
                else
                {
                    i.putExtra("Path","No");
                }*/
                i.putExtra("FormObject", documentList.get(position));
                context.startActivity(i);
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddInsuranceFormActivity.class);
                i.putExtra("GoTo", "Edit");
                i.putExtra("Path", "Yes");
               /* if (position>3)
                {

                }
                else
                {
                    i.putExtra("Path","No");
                }*/
                i.putExtra("FormObject", documentList.get(position));
                context.startActivity(i);
            }
        });

     /*convertView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


    }
      });*/


    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDocHeader, txtDocDate, txtDocTime;
        ImageView imgDocType, imgForword, imgEdit;
        SwipeLayout swipeLayout;
        LinearLayout lintrash;

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
        }
    }
}
