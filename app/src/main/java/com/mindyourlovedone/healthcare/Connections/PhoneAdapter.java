package com.mindyourlovedone.healthcare.Connections;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.DashBoard.ProfileActivity;
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
        this.context=context;
        this.phonelist=phonelist;
        lf= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return phonelist.size();
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

           // holder.txtRel=  convertView.findViewById(R.id.txtRel);
            holder.imgdeletePhone=  convertView.findViewById(R.id.imgdeletePhone);
            holder.txtPhoNum=convertView.findViewById(R.id.txtPhoNum);
            holder.txtType=convertView.findViewById(R.id.txtType);

            convertView.setTag(holder);
            view = convertView;
        } else {
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtType.setText(phonelist.get(position).getContactType());
        holder.txtPhoNum.setText(phonelist.get(position).getValue());

        holder.txtPhoNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {

                   // final int position = v.getId();
                    final TextView Caption = (TextView) v;
                    phonelist.get(position).setValue(Caption.getText().toString());

                   /* phonelist.get(position).setContactType(holder.txtType.getText().toString());
                    holder.txtType.setText(phonelist.get(position).getContactType());
                    holder.txtPhoNum.setText(phonelist.get(position).getValue());
                    notifyDataSetChanged();*/
                }
            }
        });

        holder.txtType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(context);
                b.setTitle("Type");
                final String[] types = {"Mobile", "Office", "Home", "Fax","None"};
                b.setItems(types, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (types[which].equalsIgnoreCase("None")) {
                            phonelist.get(position).setValue(phonelist.get(position).getValue());
                            phonelist.get(position).setContactType("");
                            holder.txtType.setText(phonelist.get(position).getContactType());
                            holder.txtPhoNum.setText(phonelist.get(position).getValue());

                        }else{
                            phonelist.get(position).setValue(phonelist.get(position).getValue());
                            phonelist.get(position).setContactType(types[which]);
                            holder.txtType.setText(phonelist.get(position).getContactType());
                            holder.txtPhoNum.setText(phonelist.get(position).getValue());
                        }
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }

                });
                b.show();
            }
        });
        holder.imgdeletePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(context,"CLicked",Toast.LENGTH_SHORT).show();
                if (position==0)
                {
                    ((ProfileActivity)context).addNewPhone();
                }else{
                    ((ProfileActivity)context).deletePhone(position);
                }
            }
        });
       // holder.txtRel.setText(relationship[position]);
        //  holder.txtName.setText(student.getName());
        // holder.txtCity.setText(student.getCity());

        if (position==0)
        {
            holder.imgdeletePhone.setImageResource(R.drawable.add_n);
        }else{
            holder.imgdeletePhone.setImageResource(R.drawable.delete_n);
        }

        return convertView;
    }

    public class ViewHolder {
        TextView txtRel,txtPhoNum,txtType;
        ImageView imgdeletePhone;
    }
}
