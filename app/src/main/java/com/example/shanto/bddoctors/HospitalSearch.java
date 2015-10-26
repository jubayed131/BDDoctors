package com.example.shanto.bddoctors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanto on 10/5/2015.
 */
public class HospitalSearch extends Activity {
    private Spinner spinner1, spinner2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_search);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        // params.x = -10;
        params.height = 450;
        params.width = 490;
        // params.y = -10;

      //  addCategoryOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }

    //this spinner is about category
//    public void addCategoryOnSpinner2() {
//
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        List list = new ArrayList();
//        list.add("All");
//        list.add("Cardiology");
//        list.add("Orthopedics");
//        list.add("Medicine");
//        list.add("Sergery");
//        list.add("Gyneocology");
//        list.add("Pediatric");
//        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(dataAdapter);
//    }
    //this spinner is about place
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
       // spinner2 = (Spinner) findViewById(R.id.spinner2);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String place = spinner1.getSelectedItem().toString();
               // String specialField = spinner2.getSelectedItem().toString();

                Intent intent = new Intent(HospitalSearch.this, ListHospital.class);
                intent.putExtra("place", place);
                //intent.putExtra("category", specialField);
                startActivity(intent);
            }

        });
    }
}
