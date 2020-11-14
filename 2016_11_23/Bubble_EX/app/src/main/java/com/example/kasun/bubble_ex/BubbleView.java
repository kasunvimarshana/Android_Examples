package com.example.kasun.bubble_ex;

import android.graphics.Bitmap;
import android.graphics.Paint;
import java.util.Random;
import android.content.Context;
import android.view.View;
import android.graphics.Canvas;

/**
 * Created by KASUN on 11/23/2016.
 */
public class BubbleView extends View{

    Bitmap bitmap;
    Paint paint = new Paint();
    Random random = new Random();
    int x = 50;
    int y = 50;


    public BubbleView(Context context, Bitmap bitmap){
        super(context);
        this.bitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
    }

    public boolean move(){
        x += random.nextInt(5);
        y += random.nextInt(5);
        return true;
    }

    @Override
    public void onDraw(Canvas canvas){
        canvas.drawBitmap(bitmap, x, y, paint);
    }

}
