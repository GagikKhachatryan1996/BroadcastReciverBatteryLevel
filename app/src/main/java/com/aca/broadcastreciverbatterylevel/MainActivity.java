package com.aca.broadcastreciverbatterylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BatteryReciver batteryReciver=new BatteryReciver();
    private IntentFilter intentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");

        getSupportActionBar().hide();
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(batteryReciver,intentFilter);


    }


    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(batteryReciver);


    }
}
