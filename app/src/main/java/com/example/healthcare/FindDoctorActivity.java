package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {
    CardView Back,FamilyPhysicians,Dietician,Dentist,Cardiologist,surgeon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        FamilyPhysicians=(CardView) findViewById(R.id.FamilyPhysicians);
        Dietician=(CardView)findViewById(R.id.Dietician) ;
        Dentist=(CardView)findViewById(R.id.Dentist) ;
        Cardiologist=(CardView)findViewById(R.id.Cardiologist);
        surgeon=(CardView)findViewById(R.id.surgeon);
        FamilyPhysicians.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title","FamilyPhysicians");
                startActivity(intent);

            }
        });
        Dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title","Dietician");
                startActivity(intent);
            }
        });
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title","Dentist");
                startActivity(intent);
            }
        });
        Cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title","Cardiologist");
                startActivity(intent);
            }
        });
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title","surgeon");
                startActivity(intent);
            }
        });
        Back=(CardView) findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent=new Intent(FindDoctorActivity.this, BookAppomient.class);
                startActivity(intent);
            }
        });

    }
}