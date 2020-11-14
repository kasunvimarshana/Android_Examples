package com.example.kasun.threadex;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    Handler handler;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tv = (TextView) findViewById(R.id.textView);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                //tv.setText("counting = "+(x+1));
                tv.setText((String)msg.getData().get("text"));
            }
        };
        Runnable r = new Runnable(){
          @Override
            public void run() {
              for (int i = 0; i < 10; i++) {
                  try {
                      Thread.sleep(1000);
                      x = i;
                      //handler.sendEmptyMessage(0);

                      Message msg = new Message();
                      Bundle b = new Bundle();
                      b.putString("text", "COUNT DOWN = "+i);
                      msg.setData(b);
                      handler.sendMessage(msg);

                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              }
          }
        };
        Thread t = new Thread(r);
        t.start();

        /*Runnable r = new Runnable(){//anonymous inner class (implement with Runnable)
          @Override
            public void run(){
              for(int i = 0; i < 10; i++){
                  try{
                      Thread.sleep(1000);
                      tv.setText("count = "+i);
                  }catch(Exception e){
                      e.printStackTrace();
                  }
              }
          }
        };

        Thread t1 = new Thread(r);
        t1.start();*/ //step 1

        /*Runnable r = new Runnable(){//anonymous inner class (implement with Runnable)
          @Override
            public void run(){
              for(int i = 0; i < 10; i++){
                  try{
                      Thread.sleep(1000);
                      tv.setText("count = "+i);
                  }catch(Exception e){
                      e.printStackTrace();
                  }
              }
          }
        };

        runOnUiThread(r);*/ //step 2

        /*Runnable r = new Runnable(){//anonymous inner class (implement with Runnable)
          @Override
            public void run(){
              for(int i = 0; i < 10; i++){
                  try{
                      Thread.sleep(1000);
                      final int x = i;
                      Runnable r2 = new Runnable(){
                          @Override
                          public void run(){
                              tv.setText("count = "+x);
                          }
                      };
                      runOnUiThread(r2);//meya aththe activity class 1eya
                      //tv.post(r2); // activity nowana class 1kaka idala ui thred 1e run karaweemata (View.post(Runnable))method 1ka bavitha kere
                  }catch(Exception e){
                      e.printStackTrace();
                  }
              }
          }
        };
        Thread t1 = new Thread(r);
        t1.start();*///step 3

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
