package com.example.kasun.broadcastreceiver_ex;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by KASUN on 9/10/2016.
 */
public class MyService extends IntentService {

    static String name = "MyService";
    public MyService(){
        super(name);
    }

    @Override
    public void onHandleIntent(Intent intent){

        for(int i = 0; i < 10; i++){
            try{
                Thread.sleep(1000);
                System.out.println("service"+i);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
