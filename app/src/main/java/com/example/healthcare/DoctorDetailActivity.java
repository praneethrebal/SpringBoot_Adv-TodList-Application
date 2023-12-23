package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    TextView DefultText;
    ListView listView;
    String  str1[][]={
            {"doctoe1","500","4.5"},
            {"doctoe2","500","4.00"},
            {"doctoe3","500","3.5"},
    };
    String  str2[][]={
            {"doctoe1","500","4.5"},
            {"doctoe2","500","4.00"},
            {"doctoe3","500","3.5"},
    };
    String  str3[][]={
            {"doctoe1","500","4.5"},
            {"doctoe2","500","4.00"},
            {"doctoe3","500","3.5"},
    };
    String  str4[][]={
            {"doctoe1","500","4.5"},
            {"doctoe2","500","4.00"},
            {"doctoe3","500","3.5"},
    };
    String  str5[][]={
            {"doctoe1","500","4.5"},
            {"doctoe2","500","4.00"},
            {"doctoe3","500","3.5"},
    };
    String[][] str={};
    ArrayList list;
    HashMap<String ,String > item;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        back=(Button) findViewById(R.id.backlab);
        DefultText=(TextView)findViewById(R.id.package_name) ;
        Intent intent=getIntent();
        String name=intent.getStringExtra("title");
        DefultText.setText(name);
        listView=(ListView)findViewById(R.id.ListView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent=new Intent(DoctorDetailActivity.this, FindDoctorActivity.class);
                startActivity(intent);
            }
        });
        list = new ArrayList<>();

        if(name.compareTo("FamilyPhysicians")==0)
        {
            str= str1;
        }
        else if(name.compareTo("Dietician")==0)
        {
            str=str2;
        }
        else if(name.compareTo("Dentist")==0)
        {
            str=str3;
        }
        else if(name.compareTo("Cardiologist")==0)
        {
            str=str4;
        }
        else if(name.compareTo("surgeon")==0)
        {
            str=str5;
        }
        for(int i=0;i<str.length;i++)
        {
            item = new HashMap<>();
            item= new HashMap<String ,String >();
            item.put("Line 1",str[i][0]);
            item.put("Line 2",str[i][1]);
            item.put("Line 3",str[i][2]);

            list.add(item);


        }
        SimpleAdapter sa = new SimpleAdapter(this, list,
                R.layout.activity_design,
                new String[]{"Line 1", "Line 2", "Line 3"},
                new int[]{R.id.doct, R.id.tv1, R.id.tv22});
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(DoctorDetailActivity.this, BookAppomient.class);
                intent.putExtra("text1",str[i][0]);
                intent.putExtra("text2",str[i][1]);
                intent.putExtra("text3",str[i][2]);
                startActivity(intent);
            }
        });
    }
}