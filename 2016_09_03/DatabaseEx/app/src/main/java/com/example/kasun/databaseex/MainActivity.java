package com.example.kasun.databaseex;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void load(View v){
        DataLoadTask dltask = new DataLoadTask();
        dltask.execute();
    }

    class DataLoadTask extends AsyncTask<String, Integer, List<String>> {

        @Override
        protected List doInBackground(String... strings) {
            String url = "jdbc:mysql://idex.tk:3306/idex_nadun";
            List<String> list = new ArrayList<String>();
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection(url, "idex_nadun", "idex0147");
                PreparedStatement ps = c.prepareStatement("select * from car");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String s = rs.getString("title");
                    list.add(s);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return list;
        }
        @Override
        protected void onPostExecute(List resultset){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, resultset);
            ListView lv = (ListView) findViewById(R.id.listView);
            lv.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
