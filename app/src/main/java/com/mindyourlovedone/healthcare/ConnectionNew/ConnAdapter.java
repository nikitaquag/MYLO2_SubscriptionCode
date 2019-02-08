package com.mindyourlovedone.healthcare.ConnectionNew;

import android.app.Activity;
import android.content.Context;


import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.mindyourlovedone.healthcare.HomeActivity.R;

import java.util.ArrayList;

public class ConnAdapter extends BaseAdapter {
    Context context;
    ArrayList<Conn> connList;
    HolderNew holder;
    LayoutInflater lf;

    public ConnAdapter(Activity context, ArrayList<Conn> connList) {
        this.context = context;
        this.connList = connList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return connList.size();
    }

    @Override
    public Object getItem(int position) {
        return connList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = lf.inflate(R.layout.row_conn, parent, false);
            holder = new HolderNew();
            holder.imgSelf = convertView.findViewById(R.id.imgSelf);
            holder.imgSelfFolder = convertView.findViewById(R.id.imgSelfFolder);
            holder.txtSelfName = convertView.findViewById(R.id.txtSelfName);
            holder.txtSelf = convertView.findViewById(R.id.txtSelf);
            convertView.setTag(holder);

            Conn conn = connList.get(position);
            holder.imgSelf.setImageResource(conn.getSelfProfile());
            holder.imgSelfFolder.setImageResource(conn.getSelfProfFolder());
            holder.txtSelfName.setText(conn.getSelfName());
            holder.txtSelf.setText(conn.getSelf());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Onclicked:" + connList.get(position).getSelfName(), Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            holder = (HolderNew) convertView.getTag();
        }
        return convertView;
    }

    private class HolderNew {
        ImageView imgSelf, imgSelfFolder;
        TextView txtSelfName, txtSelf;
    }
}
