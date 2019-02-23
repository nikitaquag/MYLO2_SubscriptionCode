package com.mindyourlovedone.healthcare.Connections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindyourlovedone.healthcare.HomeActivity.R;

class RelationsAdapter extends BaseAdapter {

    Context context;
    String[] relationship;
    LayoutInflater lf;
    ViewHolder holder;

    public RelationsAdapter(Context context, String[] relationship) {
        this.context=context;

        this.relationship=relationship;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return relationship.length;
    }

    @Override
    public Object getItem(int position) {
        return relationship[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            convertView = lf.inflate(R.layout.row_relations, parent, false);
            holder = new ViewHolder();

            holder.txtRel=  convertView.findViewById(R.id.txtRel);
            holder.imgCheck=  convertView.findViewById(R.id.imgCheck);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtRel.setText(relationship[position]);
      //  holder.txtName.setText(student.getName());
       // holder.txtCity.setText(student.getCity());
        return convertView;
    }

    public class ViewHolder {
        TextView txtRel;
        ImageView imgCheck;
    }
}
