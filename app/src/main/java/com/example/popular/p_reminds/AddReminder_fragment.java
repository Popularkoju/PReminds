package com.example.popular.p_reminds;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.zip.Inflater;

public class AddReminder_fragment extends Fragment {
    EditText editReminder;
    TextView mdate, mtime, repeat;

    Button setReminder, cancelReminder, exit;

    Calendar calendar;
    TimePickerDialog timePickerDialog;
    DatePickerDialog datePickerDialog;

    int currentDay;
    int currentMonth;
    int currentYear;

    int currentMinute;
    int currentHour;
    String amPM;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_reminder_layout, null);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editReminder = view.findViewById(R.id.reminder_text);
        mdate = view.findViewById(R.id.etdate);
        mtime = view.findViewById(R.id.ettime);
        repeat = view.findViewById(R.id.etrepeat);

        setReminder = view.findViewById(R.id.btnsetreminder);
        cancelReminder=view.findViewById(R.id.btncancelreminder);
        exit=view.findViewById(R.id.btnexit);

        mtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showtimePicker();
            }
        });

        mdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        setReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info i = new Info();
                i.setReminders(editReminder.getText().toString());
                i.setDate(mdate.getText().toString());
                i.setTime(mtime.getText().toString());
                MainActivity.appDatabase.dbObject().addInfo(i);

                String tdate= mdate.getText().toString();
                String ttime= mtime.getText().toString();
                Toast.makeText(getActivity(), "Reminder set on"+" "+tdate+" " +"at"+" "+ ttime, Toast.LENGTH_SHORT).show();
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame, new DashFragmentActivity()).commit();

            }
        });

        cancelReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame, new DashFragmentActivity()).commit();
            }
        });
// functions.......
    }

    public void showtimePicker() {
        calendar = Calendar.getInstance();
        currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        currentMinute = calendar.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (hourOfDay >= 12) {
                    amPM = "PM";
                } else {
                    amPM = "AM";
                }
                mtime.setText(String.format("%02d:%02d", hourOfDay, minute) + amPM);
            }
        }, currentHour, currentMinute, false);

        timePickerDialog.show();
    }

    public void showDatePicker() {
        calendar = Calendar.getInstance();
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        currentMonth = calendar.get(Calendar.MONTH);
        currentYear = calendar.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                mdate.setText(dayOfMonth + "-" + month + "-" + year);
            }
        }, currentYear, currentMonth, currentDay);
        datePickerDialog.show();
    }
}


