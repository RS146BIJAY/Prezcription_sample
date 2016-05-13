package com.example.rishavz_sagar.application;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;


public class Reminder extends Fragment {

    int hour=0,minute=0,day,month,year;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Context context=getActivity();

        Calendar c=Calendar.getInstance();
        View v=inflater.inflate(R.layout.fragment_reminder, container, false);
        final EditText message= (EditText) v.findViewById(R.id.message);

        day=c.get(Calendar.DAY_OF_MONTH);
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);

        Button picker= (Button) v.findViewById(R.id.picker);
        picker.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar calendar = Calendar.getInstance();
                        DatePickerDialog dialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                setDate(dayOfMonth, monthOfYear, year);
                            }
                        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                        dialog.show();
                    }
                }
        );

        Button reminder= (Button) v.findViewById(R.id.reminder);
        reminder.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in=new Intent(context,Scheduled.class);
                        in.putExtra("message",message.getText().toString());
                        PendingIntent pintent=PendingIntent.getActivity(context,0,in,0);
                        AlarmManager manager= (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
                        Calendar c=Calendar.getInstance();
                        c.clear();
                        c.set(Calendar.MONTH, month);
                        c.set(Calendar.YEAR,year);
                        c.set(Calendar.DAY_OF_MONTH,day);
                        c.set(Calendar.HOUR_OF_DAY,hour);
                        c.set(Calendar.MINUTE,minute);
                        c.set(Calendar.SECOND,0);
                        long ti=c.getTimeInMillis();
                        manager.set(AlarmManager.RTC_WAKEUP,ti , pintent);
                        ((MainActivity)context).clo();
                    }
                }
        );


        Button tpi= (Button) v.findViewById(R.id.tpi);
        tpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog pickerDialog=new TimePickerDialog(
                        context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minut) {
                        hour=hourOfDay;
                        minute=minut;
                    }
                },hour,minute,true
                );
                pickerDialog.show();
            }
        });


        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    private void setDate(int dayOfMonth, int monthOfYear, int yearm) {
        day=dayOfMonth;
        month=monthOfYear;
        year=yearm;
    }

}
