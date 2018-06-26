package com.mindyourlovedones.healthcare.Connections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedones.healthcare.DashBoard.FragmentMedicalInfo;
import com.mindyourlovedones.healthcare.HomeActivity.R;

import java.util.ArrayList;

/**
 * Created by Nikita on 26/6/2018.
 */

public class MedAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> medArraylist;
    LayoutInflater lf;
    Holder holder;
    String Type;
    FragmentMedicalInfo fr;

    public MedAdapter(Context context, ArrayList<String> medArraylist, String Type, FragmentMedicalInfo fr) {
        this.fr = fr;
        this.context = context;
        this.medArraylist = medArraylist;
        this.Type = Type;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return medArraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return medArraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = lf.inflate(R.layout.row_medicalinfo, parent, false);
            holder = new Holder();
            holder.txtInfo = convertView.findViewById(R.id.txtInfo);
            holder.imgEdit = convertView.findViewById(R.id.imgEdit);
            holder.imgDelete = convertView.findViewById(R.id.imgDelete);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.txtInfo.setText(medArraylist.get(position));

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fr != null) {
                    if (Type.equalsIgnoreCase("vaccine")) {
                        fr.vaccineEditDelete(position, 1);
                    } else if (Type.equalsIgnoreCase("allergy")) {
                        fr.allergyEditDelete(position, 1);
                    } else if (Type.equalsIgnoreCase("hospital")) {
                        fr.hospitalEditDelete(position, 1);
                    } else if (Type.equalsIgnoreCase("history")) {
                        fr.historyEditDelete(position, 1);
                    } else if (Type.equalsIgnoreCase("condition")) {
                        fr.conditionEditDelete(position, 1);
                    } else if (Type.equalsIgnoreCase("implants")) {
                        fr.implantsEditDelete(position, 1);
                    }
                }
            }
        });

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fr != null) {
                    if (Type.equalsIgnoreCase("vaccine")) {
                        fr.vaccineEditDelete(position, 0);
                    } else if (Type.equalsIgnoreCase("allergy")) {
                        fr.allergyEditDelete(position, 0);
                    } else if (Type.equalsIgnoreCase("hospital")) {
                        fr.hospitalEditDelete(position, 0);
                    } else if (Type.equalsIgnoreCase("history")) {
                        fr.historyEditDelete(position, 0);
                    } else if (Type.equalsIgnoreCase("condition")) {
                        fr.conditionEditDelete(position, 0);
                    } else if (Type.equalsIgnoreCase("implants")) {
                        fr.implantsEditDelete(position, 0);
                    }
                }
            }
        });

        return convertView;
    }

    private class Holder {
        TextView txtInfo;
        ImageView imgEdit, imgDelete;
    }

}
