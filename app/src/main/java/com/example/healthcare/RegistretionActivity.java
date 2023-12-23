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
import android.widget.TextView;
import android.widget.Toast;

public class RegistretionActivity extends AppCompatActivity {
        EditText uname_reg,uemail_reg,upass_reg,upass1_reg;
        Button register;
        TextView al_reg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registretion);
        uname_reg=(EditText) findViewById(R.id.uname_reg);
        uemail_reg=(EditText) findViewById(R.id.uemail_reg);
        upass_reg=(EditText) findViewById(R.id.upass_reg);
        upass1_reg=(EditText) findViewById(R.id.upass1_reg);
        register=(Button) findViewById(R.id.BookTest);
        al_reg=(TextView) findViewById(R.id.al_reg);


        // creating object for datadase

        DataBase db=new DataBase(getApplicationContext(),"healthcare",null,1);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=uname_reg.getText().toString();
                String email=uemail_reg.getText().toString();
                String password=upass_reg.getText().toString();
                String pass=upass_reg.getText().toString();
                String pass1=upass1_reg.getText().toString();
                if((uname_reg.length()==0||uemail_reg.length()==0||upass_reg.length()==0))
                {
                    Toast.makeText(RegistretionActivity.this, "plese fill all details ", Toast.LENGTH_SHORT).show();
                }
                else if(upass1_reg.length()==0||!pass.equals(pass1))
                {
                    Toast.makeText(RegistretionActivity.this, "Check the password", Toast.LENGTH_SHORT).show();
                }
                else {

                    //passing valuse to database query
                    db.register(username,email,password);


                    Toast.makeText(RegistretionActivity.this, "Register sucessfull", Toast.LENGTH_SHORT).show();



                    //shared preference for(key value pair
                    SharedPreferences sharedPreferences=getSharedPreferences("name", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("username",username);
                    editor.apply();



                    Intent intent=new Intent(RegistretionActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
            al_reg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(RegistretionActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });

    }
}