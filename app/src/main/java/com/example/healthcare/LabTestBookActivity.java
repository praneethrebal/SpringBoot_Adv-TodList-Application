package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {
    EditText FullName,Addres,Ph,PinCode;
    Button BookTest;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
        FullName=findViewById(R.id.FullName);
        Addres=findViewById(R.id.Adderse);
        Ph=findViewById(R.id.Ph);
        PinCode=findViewById(R.id.PinCode);
        BookTest=findViewById(R.id.BookTest);
        Intent intent=getIntent();
        String  price=intent.getStringExtra("price");
        String  date=intent.getStringExtra("date");
        String time=intent.getStringExtra("Time");

        BookTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                DataBase db=new DataBase(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,FullName.getText().toString(),Addres.getText().toString(),Ph.getText().toString(),Integer.parseInt(PinCode.getText().toString()),date.toString(),time.toString(),Float.parseFloat(price.toString()),"lab");
                Toast.makeText(LabTestBookActivity.this, "orderSucessfull", Toast.LENGTH_SHORT).show();
                db.removecart(username,"lab");
                startActivity(new Intent(LabTestBookActivity.this,HomeActivity.class));


            }
        });


    }
}