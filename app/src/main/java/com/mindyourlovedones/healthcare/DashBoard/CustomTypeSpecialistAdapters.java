package com.mindyourlovedones.healthcare.DashBoard;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

import com.mindyourlovedones.healthcare.HomeActivity.R;
import com.mindyourlovedones.healthcare.model.TypeSpecialist;

import java.util.ArrayList;

/**
 * Created by Niki on 11-07-2018.
 */

public class CustomTypeSpecialistAdapters extends ArrayAdapter<TypeSpecialist> {

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final ArrayList<TypeSpecialist> items;
    private final int mResource;

    public CustomTypeSpecialistAdapters(@NonNull Context context, @LayoutRes int resource,
                                        @NonNull ArrayList<TypeSpecialist> objects) {
        super(context, resource, 0, objects);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        items = objects;
    }

     @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }



    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        final View view = mInflater.inflate(mResource, parent, false);

        CheckedTextView offTypeTv = (CheckedTextView) view.findViewById(android.R.id.text1);

        offTypeTv.setText(items.get(position).getType());
        if (items.get(position).getDiff() == 1) {
            offTypeTv.setTextColor(mContext.getResources().getColor(R.color.colorBlue));
        } else {
            offTypeTv.setTextColor(mContext.getResources().getColor(R.color.colorDarkGreen));
        }

        //shradha
        if (items.get(position).getDiff() == 2) {
            offTypeTv.setTextColor(mContext.getResources().getColor(R.color.colorFour));
        }

        return view;
    }
}