//package com.example.healthcare;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.AlertDialog;
//import android.app.DatePickerDialog;
//import android.app.TimePickerDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.DatePicker;
//import android.widget.EditText;
//import android.widget.TimePicker;
//import android.widget.DatePicker;
//import java.util.Calendar;
//
//public class BookAppomient extends AppCompatActivity {
//
//    EditText name_doct,amount,rateing;
//    Button timeButton,dateButton,Back;
//    private DatePicker datePickerDialog;
//    private TimePicker timePickerDialog;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_book_appomient);
//        name_doct=(EditText) findViewById(R.id.namedoct);
//        amount=(EditText) findViewById(R.id.amount);
//        rateing=(EditText) findViewById(R.id.rateing);
//        timeButton=(Button) findViewById(R.id.time_btn);
//        dateButton=(Button) findViewById(R.id.date_btn);
//        Back=(Button)findViewById(R.id.B_back);
//        name_doct.setKeyListener(null);
//        amount.setKeyListener(null);
//        rateing.setKeyListener(null);
//
//        Intent intent=getIntent();
//        String name=intent.getStringExtra("text1");
//        String amo=intent.getStringExtra("text2");
//        String rat=intent.getStringExtra("text3");
//        name_doct.setText(name);
//        amount.setText(amo);
//        rateing.setText(rat);
//
//        //datepicker
//        initDatePicker();
//        dateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//          datePickerDialog.show();
//            }
//        });
//        //timepicker
//        initTimePicker();
//        timeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timePickerDialog.show();
//            }
//        });
//        Back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//                startActivity(new Intent(BookAppomient.this, DoctorDetailActivity.class));
//            }
//        });
//    }
//    private void initDatePicker(){
//        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                month=month+1;
//                dateButton.setText(dayOfMonth+"/"+month+"/"+year);
//            }
//        };
//        Calendar cal=Calendar.getInstance();
//        int year=cal.get(Calendar.YEAR);
//        int month=cal.get(Calendar.MONTH);
//        int day=cal.get(Calendar.DAY_OF_MONTH);
//        int style=AlertDialog.THEME_HOLO_DARK;
//        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
//        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
//        //datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day).getDatePicker().setMinDate(cal.getTimeInMillis() + 864000000);
//
//    }
//    private void initTimePicker()
//    {
//        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                timeButton.setText(hourOfDay+":"+minute);
//            }
//        };
//        Calendar cal=Calendar.getInstance();
//        int hrs=cal.get(Calendar.HOUR_OF_DAY);
//        int min=cal.get(Calendar.MINUTE);
//
//        int style=AlertDialog.THEME_HOLO_DARK;
//        timePickerDialog= new TimePickerDialog(this,style,timeSetListener,hrs,min,true);
//
//
//}
//
//}

//-----------------------------------------
package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppomient extends AppCompatActivity {
    EditText name_doct, amount, rateing;
    Button timeButton, dateButton, Back;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appomient);
        name_doct = findViewById(R.id.uname_reg);
        amount = findViewById(R.id.uemail_reg);
        rateing = findViewById(R.id.upass_reg);
        timeButton = findViewById(R.id.time_btn);
        dateButton = findViewById(R.id.date_btn);
        Back = findViewById(R.id.B_back);
        name_doct.setKeyListener(null);
        amount.setKeyListener(null);
        rateing.setKeyListener(null);

        Intent intent = getIntent();
        String name = intent.getStringExtra("text1");
        String amo = intent.getStringExtra("text2");
        String rat = intent.getStringExtra("text3");
        name_doct.setText(name);
        amount.setText(amo);
        rateing.setText(rat);

        //datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        //timepicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(BookAppomient.this, DoctorDetailActivity.class));
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                dateButton.setText(dayOfMonth + "/" + month + "/" + year);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeButton.setText(hourOfDay + ":" + minute);
            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, min, true);
    }
}

