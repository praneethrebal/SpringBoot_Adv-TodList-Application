package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LabTestDetailActivity extends AppCompatActivity {
    TextView package_name,total;
    EditText editText;
    Button backlab,cart1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);
        package_name = findViewById(R.id.package_name);
        total = findViewById(R.id.total);
        editText = findViewById(R.id.editText);
        editText.setKeyListener(null);
        Intent intent = getIntent();
        package_name.setText(intent.getStringExtra("text1"));

        editText.setText(intent.getStringExtra("text2"));
        total.setText(intent.getStringExtra("text3"));
        Log.d("tot",".."+total);

        cart1=findViewById(R.id.cart1);
        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = package_name.getText().toString();
                String prices = intent.getStringExtra("text3");
                float price=Float.parseFloat(prices);
                Log.d("price",".."+price);
               DataBase db=new DataBase(getApplicationContext(),"healthcare",null,1);
                if(db.checkcart(username,product)==1)
                {
                    Toast.makeText(getApplicationContext(),"present",Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addcart(username,product,price,"lab");

                    Toast.makeText(getApplicationContext(),"added",Toast.LENGTH_SHORT).show();
                }

            }
        });

        backlab = findViewById(R.id.backlab);
        backlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LabTestDetailActivity.this, LabTestActivity.class));
            }
        });

    }
}