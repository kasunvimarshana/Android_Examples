package com.example.kasun.cal_ex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et = (EditText) findViewById(R.id.editText);
        registerForContextMenu(et);

        /*ImageView icon1 = new ImageView(this);
        icon1.setImageResource(android.R.drawable.ic_input_add);
        ImageView icon2 = new ImageView(this);
        icon2.setImageResource(android.R.drawable.ic_delete);
        ImageView icon3 = new ImageView(this);
        icon2.setImageResource(android.R.drawable.ic_menu_zoom);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        SubActionButton button1 = itemBuilder.setContentView(icon1).build();
        SubActionButton button2 = itemBuilder.setContentView(icon2).build();
        SubActionButton button3 = itemBuilder.setContentView(icon3).build();

        FloatingActionMenu.Builder actionMenu = new FloatingActionMenu.Builder(this);
        actionMenu.addSubActionView(button1);
        actionMenu.addSubActionView(button2);
        actionMenu.addSubActionView(button3);

        actionMenu.build();*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == R.id.action_close){
            //finish();
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.action_help){
            Toast.makeText(MainActivity.this, "Help Here...", Toast.LENGTH_SHORT);
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem menuItem) {

        switch(menuItem.getItemId()) {

            case R.id.action_copy :
                Toast.makeText(MainActivity.this, "COPY", Toast.LENGTH_SHORT);
                break;
            case R.id.action_past :
                Toast.makeText(MainActivity.this, "PAST", Toast.LENGTH_SHORT);
                break;
            default:
                return super.onContextItemSelected(menuItem);
        }
        return super.onContextItemSelected(menuItem);
    }

}
