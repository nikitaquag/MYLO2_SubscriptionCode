package com.mindyourlovedone.healthcare.InsuranceHealthCare;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.InsuranceHealthCare.ResourceAdapter;
import com.mindyourlovedone.healthcare.model.ResourcesNew;
import com.mindyourlovedone.healthcare.model.Setting;

import java.util.ArrayList;

public class SettingAdapter extends BaseAdapter {
    ArrayList<Setting> settingList;
    Holders holder;
    LayoutInflater lf;
    Context context;

    public SettingAdapter(Activity activity, ArrayList<Setting> settingList) {
        this.context = activity;
        this.settingList = settingList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return settingList.size();
    }

    @Override
    public Object getItem(int position) {
        return settingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = lf.inflate(R.layout.row_resources_new, parent, false);
            holder = new Holders();
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.imgResources = convertView.findViewById(R.id.imgResources);
            holder.imgForword = convertView.findViewById(R.id.imgForword);

            convertView.setTag(holder);
        } else {
            holder = (Holders) convertView.getTag();
        }
        Setting rn = settingList.get(position);
        holder.txtName.setText(rn.getName());
        holder.imgResources.setImageResource(rn.getResImage());
        return convertView;
    }

    private class Holders {
        TextView txtName;
        ImageView imgResources, imgForword;
    }
}
