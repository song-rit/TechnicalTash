package com.example.awidcha.technicaltask.ui;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.awidcha.technicaltask.R;
import com.example.awidcha.technicaltask.model.UserModel;
import com.example.awidcha.technicaltask.utils.DBHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormActivity extends AppCompatActivity {

    private Button mButtonSubmit;
    private EditText mEditTextFullName;
    private EditText mEditTextNickName;
    private EditText mEditTextDOB;
    private EditText mEditTextAnniversary;
    private DBHelper mHelper;

    private DatePicker mDatePicker;
    private Calendar mCalendar;
    private int year, month, day;


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mHelper = new DBHelper(this);

        infixView();
        addForm();

        myAlarmEdit();


        year = mCalendar.get(Calendar.YEAR);
        month = mCalendar.get(Calendar.MONTH);
        day = mCalendar.get(Calendar.DAY_OF_MONTH);

//        mEditTextDOB.setText(String.valueOf(year) + " " + String.valueOf(month) + " " + String.valueOf(day));
        mEditTextDOB.setEnabled(true);
        mEditTextDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(100);
            }
        });

        mEditTextAnniversary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(101);
            }
        });
    }

    private void infixView() {
        mButtonSubmit = (Button) findViewById(R.id.button_submit);
        mEditTextFullName = (EditText) findViewById(R.id.edit_text_name);
        mEditTextNickName = (EditText) findViewById(R.id.edit_text_nick_name);
        mEditTextAnniversary = (EditText) findViewById(R.id.edit_text_anniversary);
        mEditTextDOB = (EditText) findViewById(R.id.edit_text_dob);
        mCalendar = Calendar.getInstance();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 100) {
            return new DatePickerDialog(this,
                    dobDateListener, year, month, day);
        } else if (id == 101) {
            return new DatePickerDialog(this,
                    anniversaryDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dobDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDateDOB(arg1, arg2 + 1, arg3);
                }
            };

    private DatePickerDialog.OnDateSetListener anniversaryDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDateAnniversary(arg1, arg2 + 1, arg3);
                }
            };

    private void showDateDOB(int year, int month, int day) {
        mEditTextDOB.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private void showDateAnniversary(int year, int month, int day) {
        mEditTextAnniversary.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    private void addForm() {

        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel user = new UserModel();
                user.setFullName(mEditTextFullName.getText().toString());
                user.setNickName(mEditTextNickName.getText().toString());
                mHelper.addUser(user);

//                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
//                finish();


            }
        });

    }

    private void setDate() {
        String dt = "2008-01-01";  // Start date
        dt = mEditTextDOB.getText().toString();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("2017/06/23 06:53:00");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(dt));
            c.add(Calendar.DATE, 1);  // number of days to add
            dt = sdf.format(c.getTime());  // dt is now the new date

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), dt, Toast.LENGTH_SHORT).show();

    }

    private void myAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
        notificationIntent.addCategory("android.intent.category.DEFAULT");

        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 3);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
    }

    private void myAlarmEdit() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
        notificationIntent.addCategory("android.intent.category.DEFAULT");

        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        String dt = "2017-06-23 06:53:20";  // Start date
        dt = mEditTextDOB.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("2017/06/23 06:53:00");
        Calendar c = Calendar.getInstance();
        try {

            c.setTime(sdf.parse(dt));
            c.add(Calendar.DATE, 1);  // number of days to add
            dt = sdf.format(c.getTime());  // dt is now the new date

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), String.valueOf(c.getTime()), Toast.LENGTH_SHORT).show();

//        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), broadcast);
        AlarmManager.AlarmClockInfo info = new AlarmManager.AlarmClockInfo(c.getTimeInMillis(), broadcast);

        alarmManager.setAlarmClock(info, broadcast);

    }

}
