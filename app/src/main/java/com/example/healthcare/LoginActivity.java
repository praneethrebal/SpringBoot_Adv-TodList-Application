package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user_name,user_password;
    Button login_button;
    TextView Register_new;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       user_name=(EditText) findViewById(R.id.uname_reg);
       user_password=(EditText) findViewById(R.id.upass_reg);
       login_button=(Button) findViewById(R.id.BookTest);
       Register_new=(TextView) findViewById(R.id.al_reg);


       //creting object for database
        DataBase db=new DataBase(getApplicationContext(),"healthcare",null,1);



       login_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name=user_name.getText().toString();
               String pass=user_password.getText().toString();
               if(name.length()==0||pass.length()==0)
               {
                   Toast.makeText(LoginActivity.this, "fill all details", Toast.LENGTH_SHORT).show();
               }
               else {

                   //checking value is present in database or not
                   if(db.login(name,pass)==1)
                   {
                       Toast.makeText(LoginActivity.this, "sucessfull", Toast.LENGTH_SHORT).show();
                       SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                       SharedPreferences.Editor editor=sharedPreferences.edit();
//                       editor.putString("username",);
                       editor.putString("username",name);
                       editor.apply();
                       startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                   }
                   else{
                   Toast.makeText(LoginActivity.this, "Plese check login details", Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });
       Register_new.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              //Intent inte=new Intent(LoginActivity.this,RegistretionActivity.class);
               startActivity(new Intent(LoginActivity.this,RegistretionActivity.class));
           }
       });


    }
}