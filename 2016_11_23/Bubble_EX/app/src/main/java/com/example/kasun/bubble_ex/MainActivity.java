package com.example.kasun.bubble_ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayout);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bubble);
        final BubbleView bView = new BubbleView(this, bitmap);
        //setContentView(bView);
        //rl.addView(bView);

       /* new Thread(new Runnable(){
            @Override
            public void run(){
                while(bView.move()){
                    bView.postInvalidate();// view.postInvalidate method 1ka call kalawita onDraw method 1ka call we
                    try{
                        Thread.sleep(100);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/

        final GameView gameView = new GameView(this);
        rl.addView(gameView);

    }
}
