package com.example.kasun.cal_ex;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        ImageView icon1 = new ImageView(this);
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
        actionMenu.attachTo(fab);
        final FloatingActionMenu action = actionMenu.build();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                action.close(true);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setMessage(R.string.dialog_message);
                builder.setTitle(R.string.dialog_title);
                builder.setNegativeButton("cansel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                action.close(true);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(Main2Activity.this);
                mBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
                mBuilder.setContentTitle("content title = you foget to call");
                mBuilder.setContentText("content Text = call to your girl");

                Intent resultIntent = new Intent(Main2Activity.this, MainActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(Main2Activity.this);

                stackBuilder.addParentStack(MainActivity.class);//clicl kalama yana page 1ka

                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(1001, mBuilder.build());

                action.close(true);

            }
        });

    }

}
