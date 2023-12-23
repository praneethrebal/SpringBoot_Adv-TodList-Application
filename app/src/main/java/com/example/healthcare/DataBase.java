

package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.LinkedHashMap;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "healthcare";
    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qur2 = "create table cart(username text,product text,price float,otype text)";
        String qur1="create table user(username text,email text,password text)";
        sqLiteDatabase.execSQL(qur2);
        sqLiteDatabase.execSQL(qur1);
        String  qur3="create table orderplace(username text,fullname text,addres text,contact text,pincode int,date text,time text,amount float,otype text)";
        sqLiteDatabase.execSQL(qur3);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void register(String username,String email,String password)
    {
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("user",null,cv);
        db.close();
    }
    public int login(String username,String password)
    {
        int result=0;
        String str[] =new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db=getReadableDatabase();

        Cursor c=db.rawQuery("select * from user where username=? and password=?",str);
        if(c.moveToFirst())
        {
            result=1;
        }
        return result;
    }
    public void addcart(String username,String product,float price,String otype )
    {
        Log.d("addcart", "Adding to cart - Username: " + username + ", Product: " + product + ", Price: " + price + ", Order Type: " + otype);
        ContentValues cv1=new ContentValues();

        cv1.put("username",username);
        cv1.put("product",product);
        cv1.put("price",price);
        cv1.put("otype",otype);
        SQLiteDatabase db=getWritableDatabase();
        long result=db.insert("cart",null,cv1);
        db.close();
        if (result == -1) {
            Log.e("addcart", "Error adding data to cart.");
        } else {
            Log.d("addcart", "Data added successfully to cart.");
        }
    }

    public int checkcart(String username,String product)
    {
        int result = 0;
        try {

            String str[] = new String[2];
            str[0] = username;
            str[1] = product;
            SQLiteDatabase db = getReadableDatabase();
            Cursor c = db.rawQuery("Select * from cart where username=? and product=?", str);
            if (c.moveToFirst()) {
                result = 1;
            }
            db.close();

        }
        catch(Exception e)
        {
            Log.getStackTraceString(e);
        }
        return result;
    }


    public void removecart(String username,String otype)
    {

        String str[]=new String[2];
        str[0]=username;
        str[1]=otype;
        SQLiteDatabase db=getWritableDatabase();
        db.delete("cart","username=? and otype=?",str);
        db.close();
    }


//    public ArrayList getCartData(String username,String otype)
//    {
//        ArrayList<String > arr=new ArrayList<>();
//
//        SQLiteDatabase db=getReadableDatabase();
//        try{
//        String str[]=new String[2];
//        str[0]=username;
//        str[1]=otype;
//
//        Cursor c=db.rawQuery("select * from cart where username=? and otype=?",str);
//
//            Log.d("dbget","get"+username);
//           Log.d("dbget","get"+c.getCount());
////           Log.i("query",executquery("select * from cart ",));
//            if(c.moveToFirst())
//        {
//            Log.d("dbget1","get"+username);
//            do
//                {
//                    Log.d("dbget","get"+otype);
//                    String  product=c.getString(2);
//                    String price= String.valueOf(c.getFloat(3));
//                    arr.add(product);
//                    arr.add(price);
//                    Log.d("dbget","get"+otype);
//                        Log.d("dbget","arr value"+arr);
//                }while (c.moveToNext());
//
//        }
//        db.close();
//        }
//        catch (Exception e)
//        {
//            Log.e("Fatal Exception", "Error details: " + Log.getStackTraceString(e));
//        }
//        return arr;
//    }

    public LinkedHashMap<String, Float> getCartData(String username, String otype) {


//        ArrayList<String> arr = new ArrayList<>();
        LinkedHashMap<String , Float> arr1=new LinkedHashMap<String, Float>();
        float totalprice=0;
        SQLiteDatabase db = getReadableDatabase();
        try {
            String[] str = new String[2];
            str[0] = username;
            str[1] = otype;
            Cursor c = db.rawQuery("select * from cart where username=? and otype=?", str);

            if (c.moveToFirst()) {
                Log.d("dbget1", "get" + username);
                do {
                    Log.d("dbget", "get" + otype);
                    String product = c.getString(c.getColumnIndex("product"));
                    float price = c.getFloat(c.getColumnIndex("price"));
                    String productPriceString = "Product: " + product + ", Price: " + price;
//                    arr.add(productPriceString);
                    arr1.put(product,price);
                    totalprice+=price;
                } while (c.moveToNext());
            }
            db.close();
        } catch (Exception e) {
            Log.e("Fatal Exception", "Error details: " + Log.getStackTraceString(e));
        }
        return arr1;
    }


    public void addOrder (String username, String fullname, String address, String contact, int pincode,String date ,String time,float price ,String otype){
        ContentValues cv = new ContentValues();
            cv.put("username", username);
        cv.put("fullname", fullname);
        cv.put("address", address);
        cv.put("contactno", contact);
        cv.put("pincode", pincode);
        cv.put("date", date);
        cv.put("time", time);
       cv .put("amount", price);
        cv.put("otype", otype);
    SQLiteDatabase db = getWritableDatabase();
db.insert(  "orderplace",  null, cv);
        db.close();}




}
