package com.example.kasun.draw_ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
        ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
        ImageView iv3 = (ImageView) findViewById(R.id.imageView3);

        Drawable d1 = getResources().getDrawable(R.drawable.bubble);
        ShapeDrawable d2 = new ShapeDrawable(new OvalShape());
        d2.getPaint().setColor(Color.MAGENTA);
        ColorDrawable d3 = new ColorDrawable(0xFFFF0000);

        iv1.setImageDrawable(d1);
        iv2.setImageDrawable(d2);
        iv3.setImageDrawable(d3);

    }
}
