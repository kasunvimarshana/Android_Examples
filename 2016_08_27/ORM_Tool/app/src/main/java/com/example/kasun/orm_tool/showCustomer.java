package com.example.kasun.orm_tool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

public class showCustomer extends OrmLiteBaseActivity<DBHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_customer);
        Intent intent = getIntent();
        int id = (Integer)intent.getExtras().get("id");
        Toast.makeText(getApplicationContext(), ""+id, Toast.LENGTH_SHORT).show();
        TextView tv = (TextView) findViewById(R.id.tv);

        try{
            Dao<Customer, Integer> cusDao = getHelper().getDao(Customer.class);
            Customer customer = cusDao.queryForId(id);
            tv.setText(id+ " - " +customer.getName());

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
