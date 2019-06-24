package com.example.boundservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import com.example.boundservices.MyService.MyLocalBinder ;


public class MainActivity extends AppCompatActivity {

    MyService buckyService ;
    Boolean isBound = false ;

    public void  showTime(View view){
        String currentTime  = buckyService.getCurrentTime();
        TextView buckyText  = findViewById(R.id.buckyText);
        buckyText.setText(currentTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this,MyService.class);
        bindService(i,buckyConnection , Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection buckyConnection ;

    {
        buckyConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                MyLocalBinder binder = (MyLocalBinder) service;
                buckyService =  binder.getService();
                isBound = true ;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isBound = false;
            }
        };
    }

}
