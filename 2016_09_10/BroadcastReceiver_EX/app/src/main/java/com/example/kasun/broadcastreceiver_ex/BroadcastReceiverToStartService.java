package com.example.kasun.broadcastreceiver_ex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by KASUN on 9/10/2016.
 */
public class BroadcastReceiverToStartService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Intent intent1 = new Intent(context, MyService.class);
        context.startService(intent1);
    }
}
