package com.mindyourlovedone.healthcare.Connections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.model.ContactData;
import com.mindyourlovedone.healthcare.model.Phone;
import com.mindyourlovedone.healthcare.utility.AppConstants;

import java.util.ArrayList;

public class PhoneAdapter extends BaseAdapter {
    Context context;
    ArrayList<ContactData> phonelist;
    LayoutInflater lf;
    int count;
    View previousView;
    ViewHolder holder;
int val;



    public PhoneAdapter(Context context, ArrayList<ContactData> phonelist) {
        if (phonelist.size()==0)
        {
            val=1;
        }else{
            val=(phonelist.size());
        }
        this.context=context;
        this.phonelist=phonelist;
        lf= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return val;
    }

    @Override
    public Object getItem(int position) {
        return phonelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            convertView = lf.inflate(R.layout.row_phone, parent, false);
            holder = new ViewHolder();

            holder.txtRel=  convertView.findViewById(R.id.txtRel);
            holder.imgdeletePhone=  convertView.findViewById(R.id.imgdeletePhone);
            if (position==0)
            {
                holder.imgdeletePhone.setImageResource(R.drawable.add_n);
            }else{
                holder.imgdeletePhone.setImageResource(R.drawable.delete_n);
            }


            convertView.setTag(holder);
            view = convertView;
        } else {
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        }

        /*holder.imgdeletePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"CLicked",Toast.LENGTH_SHORT).show();
                if (position==0)
                {
                   ContactData c=new ContactData();

                   phonelist.add(c);
                   notifyDataSetChanged();
                }else{

                }
            }
        });*/
       // holder.txtRel.setText(relationship[position]);
        //  holder.txtName.setText(student.getName());
        // holder.txtCity.setText(student.getCity());
        return convertView;
    }

    public class ViewHolder {
        TextView txtRel;
        ImageView imgdeletePhone;
    }
}
