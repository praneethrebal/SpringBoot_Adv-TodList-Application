package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
//import android.util.Log;

import android.view.View;
//import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CardLadActivity extends AppCompatActivity {
    ListView items;
    TextView total1;
    Button backcart,checkout,dateButton,timeButton;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_lad);
       items=findViewById(R.id.items);

       total1=findViewById(R.id.total1);

       backcart=findViewById(R.id.backcart);

       checkout=findViewById(R.id.checkout);

       dateButton=findViewById(R.id.date);

       timeButton=findViewById(R.id.time1);

       //shared preference
       SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);

       String username=sharedPreferences.getString("username","").toString();
       //database
       DataBase db=new DataBase(getApplicationContext(),"healthcare",null,1);
       //reterving from getcartdata
        LinkedHashMap<String ,Float> dbData=db.getCartData(username,"lab");

        ArrayList<String> displayData = new ArrayList<>();
        //converting hashmap to array list

        for (Map.Entry<String, Float> entry : dbData.entrySet()) {

            String productPriceString = "Product: " + entry.getKey() + ", Price: " + entry.getValue();

            displayData.add(productPriceString);
        }
        float sum=0;

        for(float val:dbData.values())
        {
            sum+=val;
        }
        String tsum=String.valueOf(sum);

        total1.setText(tsum);

        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayData);

        items.setAdapter(adp);

//        ArrayList dbData=db.getCartData(username,"lab");

        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();

            }
        });
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        backcart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
               startActivity(new Intent(CardLadActivity.this,LabTestActivity.class));
           }
       });
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CardLadActivity.this,LabTestBookActivity.class);
                intent.putExtra("price",total1.getText());
                intent.putExtra("date",dateButton.getText());
                intent.putExtra("Time",timeButton.getText());
                startActivity(intent);
            }
        });

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
}