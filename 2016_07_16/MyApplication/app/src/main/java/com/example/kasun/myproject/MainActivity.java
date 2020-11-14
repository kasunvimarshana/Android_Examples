package com.example.kasun.myproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast toast = Toast.makeText(this, "onStart", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast toast = Toast.makeText(this, "onResume", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast toast = Toast.makeText(this, "onPause", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast toast = Toast.makeText(this, "onStop", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast toast = Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast toast = Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void startSecound(View v){
        //how to start activity
        //activity , services , broadcast receivers open karanne intent object 1k thulini

        //Intent intent = new Intent(getApplicationContext(), SecoundActivity.class); // 1.first method

        /*Intent intent = new Intent();
        intent.setClass(getApplicationContext(), SecoundActivity.class);*/ // 2.second method

        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.industrialmaster.com")); // 3.third method

        //startActivity(intent);

        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), SecoundActivity.class);
        EditText et = (EditText) findViewById(R.id.et1);
        String name = et.getText().toString();
        intent.putExtra("name", name);
        startActivity(intent);

    }

    public void startExtra(View v){
        //Intent intent = new Intent(Intent.ACTION_DIAL);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+94713525253"));
        startActivity(intent);

        //we cannot use with default action
        //intent.addCategory(Intent.CATEGORY_LAUNCHER);

    }

    public void openGeoLocation(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=190,+Pagoda+Road,+Nugegoda"));
        startActivity(intent);
    }

}
