package com.mindyourlovedones.healthcare.DashBoard;

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
import com.mindyourlovedones.healthcare.Connections.GrabConnectionActivity;
import com.mindyourlovedones.healthcare.HomeActivity.R;
import com.mindyourlovedones.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedones.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedones.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedones.healthcare.model.Proxy;
import com.mindyourlovedones.healthcare.utility.PrefConstants;
import com.mindyourlovedones.healthcare.utility.Preferences;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by varsha on 8/23/2017. Changes done by nikita on 18/6/18
 */

public class ProxyAdapter extends RecyclerSwipeAdapter<ProxyAdapter.ViewHolder> {
    Context context;
    ArrayList<Proxy> proxyList;
    LayoutInflater lf;

    Preferences preferences;
    FragmentProxy fr;

    public ProxyAdapter(Context context, ArrayList<Proxy> proxyList) {
        this.context = context;
        this.proxyList = proxyList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        preferences = new Preferences(context);
    }

    public ProxyAdapter(Context context, ArrayList<Proxy> proxyList, FragmentProxy fr) {
        this.fr = fr;
        this.context = context;
        this.proxyList = proxyList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        preferences = new Preferences(context);
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
    public ProxyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_proxy, parent, false);
        return new ProxyAdapter.ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return proxyList.size();
    }

    @Override
    public void onBindViewHolder(final ProxyAdapter.ViewHolder holder, final int position) {
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
                    fr.callUser(proxyList.get(position));
                }
            }
        });
        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fr != null) {
                    fr.deleteProxy(proxyList.get(position));
                }
            }
        });

        if (proxyList.get(position).getMobile().equals("")) {
            holder.txtPhone.setVisibility(View.GONE);
        } else {
            holder.txtPhone.setVisibility(View.VISIBLE);
        }
        if (proxyList.get(position).getWorkPhone().equals("")) {
            holder.txtTelePhone.setVisibility(View.GONE);
        } else {
            holder.txtTelePhone.setVisibility(View.VISIBLE);
        }
        /*if(proxyList.get(position).getRelationType().equals(""))
        {
            holder.txtType.setVisibility(View.GONE);
        }
        else
        {
            holder.txtType.setVisibility(View.VISIBLE);
        }*/
        holder.txtName.setText(proxyList.get(position).getName());
        holder.txtOfficePhone.setText(proxyList.get(position).getWorkPhone());
        holder.txtPhone.setText(proxyList.get(position).getMobile());
        if (proxyList.get(position).getIsPrimary() == 0) {
            holder.txtType.setText("Primary - Health Care Proxy Agent");
        } else if (proxyList.get(position).getIsPrimary() == 1) {
            holder.txtType.setText("Successor - Health Care Proxy Agent");
        }


        holder.txtTelePhone.setText(proxyList.get(position).getWorkPhone());
        File imgFile = new File(proxyList.get(position).getPhoto());
        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            holder.imgProfile.setImageBitmap(myBitmap);
        }
       /* byte[] photo=proxyList.get(position).getPhoto();
        Bitmap bmp = BitmapFactory.decodeByteArray(photo, 0, photo.length);
        holder.imgProfile.setImageBitmap(bmp);*/

        if (proxyList.get(position).getPhotoCard() != null) {
            File imgFile1 = new File(proxyList.get(position).getPhotoCard());
            if (imgFile1.exists()) {
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile1.getAbsolutePath());
                holder.imgForword.setImageBitmap(myBitmap);
            }
           /* byte[] photoCard = proxyList.get(position).getPhotoCard();
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
                i.putExtra("Image", proxyList.get(position).getPhotoCard());
                context.startActivity(i);
            }
        });


        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.putString(PrefConstants.SOURCE, "ProxyUpdate");
                Intent i = new Intent(context, GrabConnectionActivity.class);
                i.putExtra("ProxyObject", proxyList.get(position));
                context.startActivity(i);
            }
        });

        holder.imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.putString(PrefConstants.SOURCE, "ProxyUpdateView");
                Intent i = new Intent(context, GrabConnectionActivity.class);
                i.putExtra("ProxyObject", proxyList.get(position));
                context.startActivity(i);
            }
        });

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAddress, txtPhone, txtType, txtTelePhone, txtOfficePhone;
        ImageView imgProfile, imgEdit, imgForword;
        ImageView imgNext;
        SwipeLayout swipeLayout;
        LinearLayout lincall, lintrash;

        //   SwipeRevealLayout swipeLayout;
        public ViewHolder(View convertView) {
            super(convertView);
            lincall = itemView.findViewById(R.id.lincall);
            lintrash = itemView.findViewById(R.id.lintrash);
            swipeLayout = itemView.findViewById(R.id.swipe);
            txtName = convertView.findViewById(R.id.txtName);
            txtAddress = convertView.findViewById(R.id.txtAddress);
            txtOfficePhone = convertView.findViewById(R.id.txtOfficePhone);
            txtPhone = convertView.findViewById(R.id.txtPhone);
            txtTelePhone = convertView.findViewById(R.id.txtTelePhone);
            txtType = convertView.findViewById(R.id.txtType);
            imgProfile = convertView.findViewById(R.id.imgProfile);
            imgEdit = convertView.findViewById(R.id.imgEdit);
            imgForword = convertView.findViewById(R.id.imgForword);
            imgNext = convertView.findViewById(R.id.imgNext);
        }
    }
}
