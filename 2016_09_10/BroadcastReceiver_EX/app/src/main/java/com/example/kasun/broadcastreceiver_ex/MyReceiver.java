package com.example.kasun.broadcastreceiver_ex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by KASUN on 9/10/2016.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "Some One Is Calling", Toast.LENGTH_LONG).show();
    }
}
