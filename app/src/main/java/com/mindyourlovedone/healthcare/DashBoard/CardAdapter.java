package com.mindyourlovedone.healthcare.DashBoard;

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
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedone.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedone.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedone.healthcare.model.Card;
import com.mindyourlovedone.healthcare.utility.PrefConstants;
import com.mindyourlovedone.healthcare.utility.Preferences;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by welcome on 9/20/2017. Changes done by nikita on 18/6/18
 */

class CardAdapter extends RecyclerSwipeAdapter<CardAdapter.Holder> {
    Context context;
    ArrayList<Card> cardList;
    LayoutInflater lf;
    ImageLoader imageLoader;
    DisplayImageOptions displayImageOptions;
    Preferences preferences;
    FragementInsuarnceCard fr;

    public CardAdapter(Context context, ArrayList<Card> cardList) {
        preferences = new Preferences(context);
        this.context = context;
        this.cardList = cardList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initImageLoader();
    }

    public CardAdapter(Context context, ArrayList<Card> cardList, FragementInsuarnceCard fr) {
        this.fr = fr;
        preferences = new Preferences(context);
        this.context = context;
        this.cardList = cardList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initImageLoader();
    }

    private void initImageLoader() {
        displayImageOptions = new DisplayImageOptions.Builder() // resource
                .resetViewBeforeLoading(true) // default
                .cacheInMemory(true) // default
                .cacheOnDisk(true) // default
                .showImageOnLoading(R.drawable.ins_card)
                .considerExifParams(false) // default
//                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .displayer(new SimpleBitmapDisplayer()) // default //for square SimpleBitmapDisplayer()
                .handler(new Handler()) // default
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(displayImageOptions)
                .build();
        ImageLoader.getInstance().init(config);
        imageLoader = ImageLoader.getInstance();
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
    public CardAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_card, parent, false);
        return new CardAdapter.Holder(view);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void onBindViewHolder(final CardAdapter.Holder holder, final int position) {
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
                    fr.deleteInsuranceCard(cardList.get(position));
                }
            }
        });
        
       /* File imgFile = new File(preferences.getString(PrefConstants.CONNECTED_PATH), cardList.get(position).getImgFront());
        if (imgFile.exists()) {

            imageLoader.displayImage(String.valueOf(Uri.fromFile(imgFile)), holder.imgCard, displayImageOptions);

        } else {
            holder.imgCard.setImageResource(R.drawable.ins_card);
        }*/
        holder.txtProvider.setText(cardList.get(position).getName());
        holder.txtType.setText(cardList.get(position).getType());

        holder.rlCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ViewCardActivity.class);
                i.putExtra("CardObject", cardList.get(position));
                i.putExtra("IsEdit", true);
                context.startActivity(i);

            }
        });
        /*holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddCardActivity.class);
                i.putExtra("CardObject", cardList.get(position));
                i.putExtra("IsEdit", true);
                context.startActivity(i);
            }
        });*/
/*
        holder.imgFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                           */
/* byte[] photo = CardList.get(position).getImgFront();
                            Bitmap bmp = BitmapFactory.decodeByteArray(photo, 0, photo.length);
                            imgCard.setImageBitmap(bmp);*//*

                File imgFile = new File(preferences.getString(PrefConstants.CONNECTED_PATH), cardList.get(position).getImgFront());
                if (imgFile.exists()) {
                    imageLoader.displayImage(String.valueOf(Uri.fromFile(imgFile)), holder.imgCard, displayImageOptions);
                            */
/* Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            holder.imgProfile.setImageBitmap(myBitmap);*//*

                } else {
                    holder.imgCard.setImageResource(R.drawable.ins_card);
                }
                //  imageLoader.displayImage(String.valueOf(CardList.get(position).getImgFront()),imgCard,displayImageOptions);
                holder.imgBack.setImageResource(R.drawable.white_dot);
                //holder.imgFront.setImageResource(R.drawable.blue_dot);
            }
        });
*/
/*
        holder.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               */
/* File imgFile = new File(preferences.getString(PrefConstants.CONNECTED_PATH), cardList.get(position).getImgBack());
                if (imgFile.exists()) {
                    imageLoader.displayImage(String.valueOf(Uri.fromFile(imgFile)), holder.imgCard, displayImageOptions);
                } else {
                    holder.imgCard.setImageResource(R.drawable.ins_card);
                }*//*

                // imageLoader.displayImage(String.valueOf(CardList.get(position).getImgBack()),imgCard,displayImageOptions);

                //holder.imgBack.setImageResource(R.drawable.blue_dot);
              //  holder.imgFront.setImageResource(R.drawable.white_dot);
            }
        });
*/

       /* holder.imgForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ViewCardActivity.class);
                i.putExtra("Card", cardList.get(position));
                context.startActivity(i);
            }
        });*/

//        return convertView;
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imgCard, imgCardBack, imgBack, imgNext, imgEdit, imgFront, imgForward;
        TextView txtProvider, txtType;
        SwipeLayout swipeLayout;
        LinearLayout lintrash;
        RelativeLayout rlCard;

        public Holder(View convertView) {
            super(convertView);
            imgForward = itemView.findViewById(R.id.imgForword);
            imgBack = itemView.findViewById(R.id.imgBack);
          //  imgFront = itemView.findViewById(R.id.imgFront);
            swipeLayout = itemView.findViewById(R.id.swipe);
            lintrash = itemView.findViewById(R.id.lintrash);
           // imgCard = convertView.findViewById(R.id.imgCard);
            txtProvider = convertView.findViewById(R.id.txtProviderValue);
            txtType = convertView.findViewById(R.id.txtTypeValue);
           // imgEdit = convertView.findViewById(R.id.imgEdit);
            rlCard = convertView.findViewById(R.id.rlCard);
        }
    }

}
