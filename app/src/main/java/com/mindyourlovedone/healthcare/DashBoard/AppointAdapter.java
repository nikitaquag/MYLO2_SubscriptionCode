package com.mindyourlovedone.healthcare.DashBoard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mindyourlovedone.healthcare.HomeActivity.R;
import com.mindyourlovedone.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedone.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedone.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedone.healthcare.database.DateQuery;
import com.mindyourlovedone.healthcare.model.Appoint;

import java.util.ArrayList;

/**
 * Created by welcome on 10/12/2017. Changes done by shradha on 18/6/18
 */

public class AppointAdapter extends RecyclerSwipeAdapter<AppointAdapter.Holder> {
    Context context;
    ArrayList<Appoint> noteList;
    LayoutInflater lf;
    boolean flag;
    boolean flagd = false;
    boolean flagDrop = false;
    DateClass d;

    public AppointAdapter(Context context, ArrayList noteList) {
        this.context = context;
        this.noteList = noteList;
        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public AppointAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_appoint, parent, false);
        return new AppointAdapter.Holder(view);
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    @Override
    public void onBindViewHolder(final AppointAdapter.Holder holder, final int position) {
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });

        holder.lintrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof MedicalAppointActivity) {
                    ((MedicalAppointActivity) context).deleteNote(noteList.get(position));
                }
            }
        });


/*
        holder.lltrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof MedicalAppointActivity) {
                    ((MedicalAppointActivity) context).deleteNote(noteList.get(position));
                }
            }
        });
*/


        Appoint a = noteList.get(position);
        final ArrayList<DateClass> dates = a.getDateList();

//Commented for adding static values for checking
        if (noteList.get(position).getDoctor().equals("")) {
            holder.txtDoctor.setVisibility(View.GONE);
        } else {
            holder.txtDoctor.setVisibility(View.VISIBLE);
            holder.txtDoctor.setText(noteList.get(position).getDoctor());
        }

        if (noteList.get(position).getNote().equals("")) {
            holder.txtNoteData.setVisibility(View.GONE);
        } else {
            holder.txtNoteData.setVisibility(View.VISIBLE);
            holder.txtNoteData.setText(noteList.get(position).getNote());
        }
        holder.llSubApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Appoint a = noteList.get(position);
                final ArrayList<DateClass> dates = a.getDateList();
                holder.llDate.requestFocus();

                if (flagd == false) {
                    flagd = true;
                    LayoutInflater lf;
                    for (int i = 0; i < dates.size() + 1; i++) {
                        lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View helperview = lf.inflate(R.layout.date_row, null);

                           final SwipeLayout swipeDate = helperview.findViewById(R.id.swipeDate);

                        holder.llDate.addView(helperview);
                        TextView datetime = helperview.findViewById(R.id.txtDateTime);

                        if (i == dates.size()) {

                             swipeDate.setSwipeEnabled(false);

                            //  datetime.setText("Add +");
                            //datetime.setTextColor(context.getResources().getColor(R.color.colorBlue));

                            holder.txtDate.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (context instanceof MedicalAppointActivity) {
                                        ((MedicalAppointActivity) context).SetDate(noteList.get(position), position);
                                    }
                                }
                            });
                        } else {
                            swipeDate.setSwipeEnabled(true);//shradha
                            final LinearLayout lltrash;
                            lltrash = helperview.findViewById(R.id.lltrashinner);//shradha
                            lltrash.setTag(dates.get(i));//shradha

                            datetime.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if (context instanceof MedicalAppointActivity) {
                                        DateClass dd = (DateClass) lltrash.getTag();//shradha
                                        if (dd != null) {
                                            ((MedicalAppointActivity) context).deleteDateNote(dd);
                                        } else {
                                            Toast.makeText(context, "Null DATA", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            });

                            if (dates.get(position).getDate().equals("08/09/2017  14:00") && dates.get(position).getDate().equals("")) {
                                datetime.setVisibility(View.GONE);
                            } else {
                                datetime.setVisibility(View.VISIBLE);
                                datetime.setText(/*"Completion Date:  " + */dates.get(i).getDate());
                            }

                            if (dates.get(position).getDate().equals("")) {
                                datetime.setVisibility(View.GONE);
                            } else {
                                datetime.setVisibility(View.VISIBLE);
                            }
                            datetime.setText(/*"Completion Date:  " + */dates.get(i).getDate());
                            if (i % 2 == 0) {
                                datetime.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                            } else {
                                datetime.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                            }
                        }
                    }

                } else if (flagd == true) {
                    holder.llDate.removeAllViews();
                    flagd = false;
                }
            }
        });

        holder.txtEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Appoint a = noteList.get(position);
                Intent intent = new Intent(context, AddAppointmentActivity.class);
                intent.putExtra("FROM", "View");
                intent.putExtra("AppointObject", a);
                context.startActivity(intent);
            }
        });
        holder.rlMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagDrop == false) {
                    holder.llSubApp.setVisibility(View.VISIBLE);
                    holder.imgEdit.setImageResource(R.drawable.dropup);
                    holder.txtEdit.setVisibility(View.VISIBLE);
                    holder.view1.setVisibility(View.VISIBLE);
                    holder.view2.setVisibility(View.GONE);
                    flagDrop = true;
                } else if (flagDrop == true) {
                    holder.llSubApp.setVisibility(View.GONE);
                    holder.imgEdit.setImageResource(R.drawable.drop_down);
                    holder.txtEdit.setVisibility(View.GONE);
                    holder.view1.setVisibility(View.GONE);
                    holder.view2.setVisibility(View.VISIBLE);
                    flagDrop = false;
                }
            }
        });
        /*if (noteList.get(position).getDate().equals(""))
        {
            holder.txtDateTime.setVisibility(View.GONE);
        }
        else{
            holder.txtDateTime.setVisibility(View.VISIBLE);
            holder.txtDateTime.setText(noteList.get(position).getDate());
        }*/

        //holder.txtDateTime.setText(noteList.get(position).getDate());
        // LinearLayout llDate= (LinearLayout) convertView.findViewById(R.id.llDate);
       /* for (int i=0;i<dates.size()+1;i++) {

            View helperview = lf.inflate(R.layout.date_row, null);
            holder.llDate.addView(helperview);
            TextView datetime = (TextView) helperview.findViewById(R.id.txtDateTime);

            if (i == dates.size()) {
                datetime.setText("Add +");
                datetime.setTextColor(context.getResources().getColor(R.color.colorBlue));
                datetime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((MedicalAppointActivity) context).SetDate(noteList.get(position), position);
                    }
                });
            } else {
                datetime.setText("Completion Date:  " + dates.get(i).getDate());
                if (i % 2 == 0) {
                    datetime.setBackgroundColor(context.getResources().getColor(R.color.colorSkyBlue));
                } else {
                    datetime.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
                }
            }
        }*/

        //Commented for adding static values for checking

        holder.txtFrequency.setText(noteList.get(position).getFrequency());
        if (noteList.get(position).getType().equals("Other")) {
            holder.txtType.setText(noteList.get(position).getOtherDoctor());
        } else {
            holder.txtType.setText(noteList.get(position).getType());
        }

        if (noteList.get(position).getFrequency().equals("")) {
            holder.txtFrequency.setVisibility(View.GONE);
        } else {
            holder.txtFrequency.setVisibility(View.VISIBLE);
            holder.txtFrequency.setText(noteList.get(position).getFrequency());
        }
        if (noteList.get(position).getFrequency().equals("Other")) {
            holder.txtFrequency.setVisibility(View.VISIBLE);
            holder.txtFrequency.setText(noteList.get(position).getOtherFrequency());
        } else {
            holder.txtFrequency.setVisibility(View.VISIBLE);
            holder.txtFrequency.setText(noteList.get(position).getFrequency());
        }
        /*Comment ends here*/


      /*  ArrayList<Date> datesliST=new ArrayList<>();
        {
            for (int i=0;i<dates.size();i++) {
                String dtStart = "2010-10-15T09:27:37Z";
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                try {
                    Date date = (Date) format.parse(dtStart);
                    datesliST.add(date);
                    System.out.println(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        Collections.sort(datesliST, new Comparator<Date>(){
            public int compare(Date date1, Date date2){
                return date1.after(date2);
            }
        });*/

        //holder.imgProfile.setImageResource(student.getImgid());
       /* final View finalConvertView = convertView;
        holder.txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout ll= (LinearLayout) finalConvertView.findViewById(R.id.llDate);

              *//*  if ( ll.getVisibility() == View.GONE)
                {
                    //expandedChildList.set(arg2, true);
                    ll.setVisibility(View.VISIBLE);
                }
                else
                {
                    //expandedChildList.set(arg2, false);
                    ll.setVisibility(View.GONE);
                }*//*
            }
        });
       */
       /* holder.txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        holder.txtDateTime.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                dpd.show();
            }
        });*/

    }

    public void deleteDateNote(final DateClass items) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Delete");
        alert.setMessage("Do you want to Delete this record?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                boolean flag = DateQuery.deleteDateRecord(items.getPreid(), items.getDate());
                boolean flag = DateQuery.deleteRecords(items.getId());
                if (flag == true) {
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                    ((MedicalAppointActivity) context).deleteDateNote(d);
                    ((MedicalAppointActivity) context).deleteDateNote(d);
                }
                dialog.dismiss();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        alert.show();
    }


    public class Holder extends RecyclerView.ViewHolder {
        TextView txtNoteData, txtEdit, txtDoctor, txtDateTime, txtFrequency, txtType, txtDate;
        RelativeLayout rlMain;
        LinearLayout llDate, llSubApp;
        ImageView imgForward, imgEdit;
        SwipeLayout swipeLayout;
        LinearLayout lintrash;
        View view1, view2;
        // SwipeRevealLayout swipeLayout;

        public Holder(View convertView) {
            super(convertView);

//            imgtrash = convertView.findViewById(R.id.imgtrash);

            lintrash = convertView.findViewById(R.id.lintrash);
            llSubApp = convertView.findViewById(R.id.llSubApp);
            swipeLayout = convertView.findViewById(R.id.swipe);
            rlMain = convertView.findViewById(R.id.rlMain);
            txtDoctor = convertView.findViewById(R.id.txtDoctor);
            txtDateTime = convertView.findViewById(R.id.txtDateTime);
            txtFrequency = convertView.findViewById(R.id.txtFrequency);
            txtType = convertView.findViewById(R.id.txtType);
            txtDate = convertView.findViewById(R.id.txtDate);
            imgForward = convertView.findViewById(R.id.imgForword);
            llDate = convertView.findViewById(R.id.llDate);
            imgEdit = convertView.findViewById(R.id.imgEdit);
            txtEdit = convertView.findViewById(R.id.txtEdit);
            view1 = convertView.findViewById(R.id.view1);
            view2 = convertView.findViewById(R.id.view2);
            txtNoteData = convertView.findViewById(R.id.txtNoteData);
            txtDate = convertView.findViewById(R.id.txtDate);

        }
    }

}
