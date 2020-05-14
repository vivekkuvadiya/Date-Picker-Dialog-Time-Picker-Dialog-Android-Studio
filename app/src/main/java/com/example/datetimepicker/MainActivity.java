package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private Button mTimeDialog , mDateDialog;
    private TextView mSetTime , mSetDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeDialog = findViewById(R.id.time_dialog);
        mSetTime = findViewById(R.id.set_time);

        mDateDialog = findViewById(R.id.date_dialog);
        mSetDate = findViewById(R.id.set_date);


        mTimeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment(MainActivity.this);
                timePickerDialogFragment.show(getSupportFragmentManager(),"timepicker");

            }
        });

        mDateDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment(MainActivity.this);
                datePickerDialogFragment.show(getSupportFragmentManager(),"datepicker");

            }
        });

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        String time = "Time : "+hourOfDay+" :  Minute : "+minute;
        mSetTime.setText(time);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String date = "Day : "+dayOfMonth+" / Month : "+month+" / Year : "+year;
        mSetDate.setText(date);

    }
}
