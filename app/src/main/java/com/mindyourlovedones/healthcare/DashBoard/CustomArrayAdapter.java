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
import android.widget.TextView;

import com.mindyourlovedones.healthcare.HomeActivity.R;
import com.mindyourlovedones.healthcare.model.RelativeConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 11-07-2018.
 */

public class CustomArrayAdapter extends ArrayAdapter<RelativeConnection> {

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<RelativeConnection> items;
    private final int mResource;

    public CustomArrayAdapter(@NonNull Context context, @LayoutRes int resource,
                              @NonNull List<RelativeConnection> objects) {
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
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        final View view = mInflater.inflate(mResource, parent, false);

        CheckedTextView offTypeTv = (CheckedTextView) view.findViewById(android.R.id.text1);

        offTypeTv.setText(items.get(position).getName());

        return view;
    }
}