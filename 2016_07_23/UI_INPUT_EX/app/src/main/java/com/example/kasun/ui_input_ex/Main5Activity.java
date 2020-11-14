package com.example.kasun.ui_input_ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void next(View v){
        SeekBar sb1 = (SeekBar) findViewById(R.id.seekBar);
        int level = sb1.getProgress();
        Toast.makeText(this, "SeekBar = "+level, Toast.LENGTH_SHORT).show();

        RatingBar rb1 = (RatingBar) findViewById(R.id.ratingBar);
        int level_1 = rb1.getProgress();
        Toast.makeText(this, "RationBar = "+level_1, Toast.LENGTH_SHORT).show();

        ProgressBar pb1 = (ProgressBar) findViewById(R.id.progressBar);
        int level_2 = pb1.getProgress();
        Toast.makeText(this, "ProgressBar = "+level_2, Toast.LENGTH_SHORT).show();
    }

}
