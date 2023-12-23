package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    Button back,Gocart;
    ListView ListView;
    String[][] test={{"test1","250","good"},
                     {"test2","253","good"},
                     {"test3","1000","good"}
                    };

    private String[] package_details = {

            "Blood Glucose Fasting\n" +
                    "Complete Hemogram\n" +
                    "HbA1c\n"+
                    "Iron Studies\n" +
            "Kidney Function Test\n" +
            "LDH Lactate Dehydrogenase, Serum\n" +
            "Lipid Profile\n" +
            "Liver Function Test",

            "Blood Glucose Fasting",

            "COVID-19 Antibody - IgG"

};
    ArrayList list;
    HashMap<String,String> hmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        back=(Button) findViewById(R.id.backlab);
        ListView=(ListView)findViewById(R.id.ListView);
        list=new ArrayList<>();
        for(int i=0;i<test.length;i++)
        {
            hmap=new HashMap<>();
            hmap=new HashMap<String,String>();
            hmap.put("line1",test[i][0]);
            hmap.put("line2",test[i][1]);
            hmap.put("line3",test[i][2]);
            list.add(hmap);
        }
        SimpleAdapter sa=new SimpleAdapter(this,list,R.layout.activity_design,new String[]{"line1","line2","line3"},new int[]{R.id.doct,R.id.tv1,R.id.tv22});
        ListView.setAdapter(sa);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(LabTestActivity.this, "You selected : "+test[position][0], Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(LabTestActivity.this,LabTestDetailActivity.class);
                intent.putExtra("text1",test[position][0]);

                intent.putExtra("text2",package_details[position]);

                intent.putExtra("text3",test[position][1]);

                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        Gocart=findViewById(R.id.Gocart);
        Gocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,CardLadActivity.class));
            }
        });


    }
}