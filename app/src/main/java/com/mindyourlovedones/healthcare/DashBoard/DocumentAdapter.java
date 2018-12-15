package com.mindyourlovedones.healthcare.DashBoard;

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
import com.mindyourlovedones.healthcare.HomeActivity.R;
import com.mindyourlovedones.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedones.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedones.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedones.healthcare.model.Document;

import java.util.ArrayList;

/**
 * Created by varsha on 8/23/2017. Changes done by nikita on 20/6/18
 */

public class DocumentAdapter extends RecyclerSwipeAdapter<DocumentAdapter.ViewHolder> {
    Context context;
    ArrayList<Document> documentList;
    LayoutInflater lf;

    public DocumentAdapter(Context context, ArrayList<Document> documentList) {
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_care_plan_new, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return documentList.size();
    }

    public void onBindViewHolder(final DocumentAdapter.ViewHolder holder, final int position) {
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });

        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof CarePlanListActivity) {
                    ((CarePlanListActivity) context).deleteDocument(documentList.get(position));
                }
            }
        });

        holder.txtDocDate.setVisibility(View.VISIBLE);


        if (documentList.get(position).getType().equals("Other")) {
            holder.txtDocHeader.setText(documentList.get(position).getType() + " - " + documentList.get(position).getOtherDoc());
        } else {
            holder.txtDocHeader.setText(documentList.get(position).getType());
        }
        if (documentList.get(position).getPerson().equals("")) {
            holder.txtDocTime.setVisibility(View.GONE);
        } else {
            holder.txtDocTime.setVisibility(View.VISIBLE);
            holder.txtDocTime.setText(documentList.get(position).getPerson());
        }
        if (documentList.get(position).getDate().equals("")) {
            holder.txtDocDate.setVisibility(View.GONE);
        } else {
            holder.txtDocDate.setVisibility(View.VISIBLE);
            holder.txtDocDate.setText(documentList.get(position).getDate());
        }

        holder.imgDocType.setImageResource(R.drawable.pdf);//documentList.get(position).getImage()

        holder.rlFix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddDocumentActivity.class);
                i.putExtra("GoTo", "View");
                i.putExtra("Path", "Yes");
               /* if (position>3)
                {

                }
                else
                {
                    i.putExtra("Path","No");
                }*/
                i.putExtra("DocumentObject", documentList.get(position));
                context.startActivity(i);
            }
        });

        holder.imgForword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddDocumentActivity.class);
                i.putExtra("GoTo", "View");
                i.putExtra("Path", "Yes");
               /* if (position>3)
                {

                }
                else
                {
                    i.putExtra("Path","No");
                }*/
                i.putExtra("DocumentObject", documentList.get(position));
                context.startActivity(i);
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddDocumentActivity.class);
                i.putExtra("GoTo", "Edit");
                i.putExtra("Path", "Yes");
               /* if (position>3)
                {

                }
                else
                {
                    i.putExtra("Path","No");
                }*/
                i.putExtra("DocumentObject", documentList.get(position));
                context.startActivity(i);
            }
        });


     /*convertView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


    }
      });*/
//        return convertView;


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
