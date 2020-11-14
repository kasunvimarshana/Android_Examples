package com.example.kasun.orm_tool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;

import java.util.List;

public class Main2Activity extends OrmLiteBaseActivity<DBHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); */

                Intent intent = new Intent(getApplicationContext(), ustomerAddActivity.class);
                startActivity(intent);

            }
        });

        final ListView lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                Customer c = (Customer) lv.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), showCustomer.class);
                intent.putExtra("id", c.getId());
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();

        try{

            Dao<Customer, Integer> cusDao = getHelper().getDao(Customer.class);
            List<Customer> list = cusDao.queryForAll();
            ArrayAdapter<Customer> adapter = new ArrayAdapter<Customer>(Main2Activity.this, android.R.layout.simple_list_item_1,list);
            ListView lv = (ListView) findViewById(R.id.listView);
            lv.setAdapter(adapter);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void filter(View v){

        try{

            EditText etSearch = (EditText) findViewById(R.id.etSearch);

            Dao<Customer, Integer> cusDao = getHelper().getDao(Customer.class);
            QueryBuilder<Customer, Integer> queryBuilder = cusDao.queryBuilder();
            Where<Customer, Integer> where = queryBuilder.where();
            SelectArg selectArg = new SelectArg();
            selectArg.setValue("%"+etSearch.getText().toString()+"%");
            where.like("name", selectArg);

            PreparedQuery<Customer> pq = queryBuilder.prepare();
            List<Customer> list = cusDao.query(pq);

            ArrayAdapter<Customer> adapter = new ArrayAdapter<Customer>(Main2Activity.this, android.R.layout.simple_list_item_1, list);
            ListView lv = (ListView) findViewById(R.id.listView);
            lv.setAdapter(adapter);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
