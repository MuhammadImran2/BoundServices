package com.example.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder ;
import java.text.SimpleDateFormat ;
import java.util.Date ;
import java.util.Locale ;



public class MyService extends Service {

    private final IBinder buckyBinder = new MyLocalBinder();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return buckyBinder ;

    }

    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:MM:SS", Locale.US);
        return (df.format(new Date()));
    }

    public class MyLocalBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }

    }
}







