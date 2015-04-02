package com.profyte.profyte;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by israe_000 on 3/6/2015.
 */
public class ShortProfileActivity extends Activity {
    Context ctx;
    SessionManager session;
    Button finish;

    DatePicker birthday;
    Calendar calendar;
    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_profile);
        ctx = getApplicationContext();
        session = new SessionManager(ctx);

        finish = (Button)findViewById(R.id.button_signup_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Send user data to the DB
                startActivity(new Intent(ctx, MainActivity.class));
            }
        });

        //Get All the calender data here to initialize the datePicker
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        birthday = (DatePicker)findViewById(R.id.datePicker);
        birthday.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Do something when the user changes the date here
            }
        });

    }

}
