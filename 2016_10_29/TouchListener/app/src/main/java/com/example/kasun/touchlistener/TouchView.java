package com.example.kasun.touchlistener;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by KASUN on 10/29/2016.
 */
public class TouchView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();

    public TouchView (Context context){
        super(context);
        //paint object 1kata adala daththa assign karaganeema
        paint.setAntiAlias(true);//line curve true or false
        paint.setStrokeWidth(6f);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        invalidate();
        //Handle Your Touch Here
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN :
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE :
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP :
                break;
            default :
                return false;

        }

        return true;
    }


}
