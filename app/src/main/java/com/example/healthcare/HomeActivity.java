package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    CardView Logoutcv,Labtestcv,Buymecidencv,Finddoctorcv,Helpdoctorcv,Orderdetailscv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Labtestcv=(CardView) findViewById(R.id.cardLabtest);
        Buymecidencv=(CardView)findViewById(R.id.cardBuyMecdien) ;
        Finddoctorcv=(CardView)findViewById(R.id.cardFindDoctor) ;
        Helpdoctorcv=(CardView)findViewById(R.id.cardHelpDoctor);
        Orderdetailscv=(CardView)findViewById(R.id.cardOrderDetails);
        Logoutcv=(CardView) findViewById(R.id.cardLogout) ;


Finddoctorcv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(HomeActivity.this, FindDoctorActivity.class);
        startActivity(intent);
    }
});
Helpdoctorcv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(HomeActivity.this, "Comming soon...", Toast.LENGTH_SHORT).show();
    }
});
        Orderdetailscv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Comming soon...", Toast.LENGTH_SHORT).show();
            }
        });
        Labtestcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this, LabTestActivity.class);
                startActivity(intent);
            }
        });
        Labtestcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,LabTestActivity.class));
            }
        });

        Logoutcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent=new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Buymecidencv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Comming soon...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}