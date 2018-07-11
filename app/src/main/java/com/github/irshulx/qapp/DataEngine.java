package com.github.irshulx.qapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by mkallingal on 12/18/2015.
 */
public class DataEngine {
    private final String SharedPreference="QA";
    public Context _Context;
    private Gson gson;
    public String AccessToken;
    public DataEngine(){ }
    public  DataEngine(Context _Context){
        this._Context= _Context;
        gson = new Gson();
        this.AccessToken= GetValue("access_token","");
      //  this.host=getLocalIp();

    }

    public String GetValue(String Key, String defaultVal){
        SharedPreferences _Preferences= _Context.getSharedPreferences(SharedPreference, 0);
        return   _Preferences.getString(Key, defaultVal);

    }


    public void putValue(String Key, String Value){
        SharedPreferences _Preferences = _Context.getSharedPreferences(SharedPreference, 0);
        SharedPreferences.Editor editor = _Preferences.edit();
        editor.putString(Key, Value);
        editor.apply();
    }



   public String GenerateUUID(){
       DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
       String sdt = df.format(new Date(System.currentTimeMillis()));
        UUID x= UUID.randomUUID();
      String[] y= x.toString().split("-");
       return y[y.length-1]+sdt;
    }

}