package com.mindyourlovedone.healthcare.DashBoard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedone.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedone.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedone.healthcare.model.Note;

import java.util.ArrayList;

/**
 * Created by welcome on 9/18/2017. Changes done by nikita on 20/6/18
 */

public class NoteAdapter extends RecyclerSwipeAdapter<NoteAdapter.Holder> {
    Context context;
    ArrayList<Note> noteList;
    LayoutInflater lf;

    public NoteAdapter(Context context, ArrayList noteList) {
        this.context = context;
        this.noteList = noteList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_note, parent, false);
        return new Holder(view);
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public void onBindViewHolder(final NoteAdapter.Holder holder, final int position) {

        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });

        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof EventNoteActivity) {
                    ((EventNoteActivity) context).deleteNote(noteList.get(position));
                }
            }
        });

        holder.txtNote.setText(noteList.get(position).getTxtNote());
        holder.txtDateTime.setText(noteList.get(position).getTxtDate());

        holder.imgForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (context instanceof EventNoteActivity) {
                    ((EventNoteActivity) context).imgFrowardClick(noteList.get(position));
                }
            }
        });
        holder.txtDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof EventNoteActivity) {
                    ((EventNoteActivity) context).datetimeDialog(noteList.get(position));
                }
            }
        });

    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView txtNote, txtDateTime, txtTime;
        ImageView imgForward, imgDrop;
        LinearLayout lintrash;
        SwipeLayout swipeLayout;

        public Holder(View convertView) {
            super(convertView);
            swipeLayout = itemView.findViewById(R.id.swipe);
            lintrash = itemView.findViewById(R.id.lintrash);
            txtNote = convertView.findViewById(R.id.txtNote);
            txtDateTime = convertView.findViewById(R.id.txtDateTime);
            imgForward = convertView.findViewById(R.id.imgForword);
            imgDrop = convertView.findViewById(R.id.imgDrop);
        }
    }
}