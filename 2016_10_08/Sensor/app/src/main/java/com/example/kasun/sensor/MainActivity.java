package com.example.kasun.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor sensor;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ALL);//sensor list 1k labaganeemata

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);//thani sensor 1k labaganeemata

    }

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);//sensor 1ka register kireema
    }

    @Override
    protected void onPause(){
       super.onPause();
       sensorManager.unregisterListener(this);//sensor 1ka unregister kireema
    }

    @Override
    public void onSensorChanged(SensorEvent event){

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[3];

        textView.setText(" x = "+x+" y = "+y+" z = "+z);
    }

    @Override
    public void onAccuracyChanged(Sensor censor, int accuracy){

    }

}
