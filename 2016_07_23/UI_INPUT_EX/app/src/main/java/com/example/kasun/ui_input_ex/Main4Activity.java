package com.example.kasun.ui_input_ex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Spinner sp1 = (Spinner) findViewById(R.id.spinner);
        String[] nationalities = getResources().getStringArray(R.array.nationalities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nationalities);
        sp1.setAdapter(adapter);

    }

    public void next(View v){
        Spinner sp1 = (Spinner) findViewById(R.id.spinner);
        String selectedCountry = sp1.getSelectedItem().toString();
        Toast.makeText(this, selectedCountry, Toast.LENGTH_SHORT).show();

        DatePicker dp1 = (DatePicker) findViewById(R.id.datePicker);
        String date = dp1.getYear()+"-"+(dp1.getMonth()+1)+"-"+dp1.getDayOfMonth();
        Toast.makeText(this, date, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), Main5Activity.class);
        startActivity(intent);

    }

}
