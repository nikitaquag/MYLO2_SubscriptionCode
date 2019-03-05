package com.mindyourlovedone.healthcare.Connections;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.DashBoard.ProfileActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.model.ContactData;

import java.util.ArrayList;

public class SpecialPhoneAdapter extends BaseAdapter {
    Context context;
    ArrayList<ContactData> phonelist;
    LayoutInflater lf;
    int count;
    View previousView;
    ViewHolder holder;
   int val;



    public SpecialPhoneAdapter(Context context, ArrayList<ContactData> phonelist) {
        this.context=context;
        this.phonelist=phonelist;
        lf= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void addNewPhone(Context context) {
        ContactData c=new ContactData();
        phonelist.add(c);
        notifyDataSetChanged();
      /*  pd= new SpecialPhoneAdapter(context, phonelist);
        listPrPhone.setAdapter(pd);*/
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
            //    Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show();
              //  FragmentNewContact f=new FragmentNewContact();
                if (position==0)
                {
                    addNewPhone(context);
                }else{
                    deletePhone(position);
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
    public void deletePhone(int position) {
        phonelist.remove(phonelist.get(position));
        notifyDataSetChanged();
    }
    public class ViewHolder {
        TextView txtRel,txtPhoNum,txtType;
        ImageView imgdeletePhone;
    }
}
