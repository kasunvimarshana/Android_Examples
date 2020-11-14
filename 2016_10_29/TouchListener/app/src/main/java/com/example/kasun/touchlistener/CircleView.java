package com.example.kasun.touchlistener;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by KASUN on 10/29/2016.
 */
public class CircleView extends View {

    float x = 0, y = 0;
    private Paint paint = new Paint();
    private Path path = new Path();
    List<Point> pointList = new ArrayList<Point>();

    public CircleView(Context context){
        super(context);

        paint.setAntiAlias(true);//line curve true or false
        paint.setStrokeWidth(6f);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    protected void onDraw(Canvas canvas){
        for(int c = 0; c < pointList.size(); c++){
            canvas.drawCircle(pointList.get(c).x, pointList.get(c).y, (float)Math.random()*100, paint);
            //canvas.drawBitmap();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){

         Point point = new Point();

         point.x = motionEvent.getX();
         point.y = motionEvent.getY();

        pointList.add(point);

        return true;
    }

    public void setPaintColor(int c){
        paint.setColor(c);
    }

    class Point{
        float x;
        float y;
    }

}
