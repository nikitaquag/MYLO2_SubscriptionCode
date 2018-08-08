package com.mindyourlovedones.healthcare.DashBoard;

import android.content.Context;
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
import com.mindyourlovedones.healthcare.HomeActivity.R;
import com.mindyourlovedones.healthcare.SwipeCode.RecyclerSwipeAdapter;
import com.mindyourlovedones.healthcare.SwipeCode.SimpleSwipeListener;
import com.mindyourlovedones.healthcare.SwipeCode.SwipeLayout;
import com.mindyourlovedones.healthcare.model.Appoint;

import java.util.ArrayList;

/**
 * Created by welcome on 10/12/2017. Changes done by nikita on 18/6/18
 */

public class AppointAdapter extends RecyclerSwipeAdapter<AppointAdapter.Holder> {
    Context context;
    ArrayList<Appoint> noteList;
    LayoutInflater lf;
    boolean flag;
    boolean flagd = false;

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


        if (noteList.get(position).getDoctor().equals("")) {
            holder.txtDoctor.setVisibility(View.GONE);
        } else {
            holder.txtDoctor.setVisibility(View.VISIBLE);
            holder.txtDoctor.setText(noteList.get(position).getDoctor());
        }

        holder.rlMain.setOnClickListener(new View.OnClickListener() {
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


                        holder.llDate.addView(helperview);
                        TextView datetime = helperview.findViewById(R.id.txtDateTime);

                        if (i == dates.size()) {

                          /*  final SwipeLayout swipeDate;
                            swipeDate=helperview.findViewById(R.id.swipeDate);
                            swipeDate.setBottomSwipeEnabled(false);*/

                            datetime.setText("Add +");
                            datetime.setTextColor(context.getResources().getColor(R.color.colorBlue));
                            datetime.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (context instanceof MedicalAppointActivity) {
                                        ((MedicalAppointActivity) context).SetDate(noteList.get(position), position);
                                    }
                                }
                            });
                        } else {
                            final LinearLayout lltrash;

                            lltrash = helperview.findViewById(R.id.lltrashinner);

//                        lltrash.setTag(i + "");

                            lltrash.setTag(dates.get(i));

                            lltrash.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if (context instanceof MedicalAppointActivity) {
                                        DateClass dd = (DateClass) lltrash.getTag();
                                        if (dd != null) {
//                                        int pos = Integer.getInteger(lltrash.getTag().toString());
//                                        ((MedicalAppointActivity) context).deleteDateNote(dates.get(pos));
                                            ((MedicalAppointActivity) context).deleteDateNote(dd);
                                        } else {
                                            Toast.makeText(context, "Null DATA", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            });

                            datetime.setText("Completion Date:  " + dates.get(i).getDate());
                            if (i % 2 == 0) {
                                datetime.setBackgroundColor(context.getResources().getColor(R.color.colorSkyBlue));
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

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Appoint a = noteList.get(position);
                Intent intent = new Intent(context, AddAppointmentActivity.class);
                intent.putExtra("FROM", "View");
                intent.putExtra("AppointObject", a);
                context.startActivity(intent);
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
        //    holder.txtFrequency.setText(noteList.get(position).getFrequency());
        if (noteList.get(position).getType().equals("Other")) {
            holder.txtType.setText(noteList.get(position).getOtherDoctor());
        } else {
            holder.txtType.setText(noteList.get(position).getType());
        }

        if (noteList.get(position).getFrequency().equals("")) {
            holder.txtFrequency.setVisibility(View.GONE);
        } else if (noteList.get(position).getFrequency().equals("Other")) {
            holder.txtFrequency.setVisibility(View.VISIBLE);
            holder.txtFrequency.setText(noteList.get(position).getOtherFrequency());
        } else {
            holder.txtFrequency.setVisibility(View.VISIBLE);
            holder.txtFrequency.setText(noteList.get(position).getFrequency());
        }




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
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Appoint a=noteList.get(position);
                Intent intent=new Intent(context,AddAppointmentActivity.class);
                intent.putExtra("FROM","View");
                intent.putExtra("AppointObject",a);
                context.startActivity(intent);
            }
        });*/
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

    public class Holder extends RecyclerView.ViewHolder {
        TextView txtDoctor, txtDateTime, txtFrequency, txtType, txtDate;
        RelativeLayout rlMain;
        LinearLayout llDate;
        ImageView imgForward, imgEdit;
        SwipeLayout swipeLayout;
        LinearLayout lintrash;
        // SwipeRevealLayout swipeLayout;

        public Holder(View convertView) {
            super(convertView);

//            imgtrash = convertView.findViewById(R.id.imgtrash);

            lintrash = convertView.findViewById(R.id.lintrash);
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

        }
    }

}
