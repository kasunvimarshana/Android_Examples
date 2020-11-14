package com.example.kasun.test;

import android.app.ActionBar;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView textView;
    TextView textView2;
    SensorManager sensorManager;
    Sensor sensor;
    int w;
    int h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        Display display = getWindowManager().getDefaultDisplay();
        w = display.getWidth();
        h = display.getHeight();

    }

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent){
        /*
          sensor values wenaswana paratharaya
        * X = (+10) - (-10)
        * Y = (+10) - (-10)
        * Z = (+10) - (-10)
        * */
        if(sensorEvent.sensor == sensor){
            /**/
        }
        float x = sensorEvent.values[0] + 10;
        float y = sensorEvent.values[1] + 10;
        float z = sensorEvent.values[2];

        float left = w * (x/20);
        float top = h * (y/20);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins((int)left, (int)top, params.rightMargin, params.bottomMargin);

        textView.setLayoutParams(params);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
        textView2.setText("accuracy = "+accuracy+"%");
    }

}
