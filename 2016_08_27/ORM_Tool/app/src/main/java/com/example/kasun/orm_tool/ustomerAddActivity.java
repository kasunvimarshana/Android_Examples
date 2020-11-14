package com.example.kasun.orm_tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

public class ustomerAddActivity extends OrmLiteBaseActivity<DBHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustomer_add);
    }

    public void save(View v){

        //1. pack data to model
        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etAddress = (EditText) findViewById(R.id.etAddress);
        EditText etTp = (EditText) findViewById(R.id.etTp);
        EditText etMobile = (EditText) findViewById(R.id.etMobile);
        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etBirthday = (EditText) findViewById(R.id.etBirthday);

        Customer customer = new Customer();

        customer.setName(etName.getText().toString());
        customer.setAddress(etAddress.getText().toString());
        customer.setTp(etTp.getText().toString());
        customer.setMobile(etMobile.getText().toString());
        customer.setEmail(etEmail.getText().toString());
        customer.setBirthDay(etBirthday.getText().toString());

        //2. parse model to the ORM

        try{

           Dao<Customer, Integer> cusDao = getHelper().getDao(Customer.class);
            cusDao.create(customer);

        }catch(Exception e){
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "SAVE", Toast.LENGTH_SHORT).show();

    }

}
