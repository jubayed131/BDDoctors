package com.example.shanto.bddoctors;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] gridTitle={"Doctor","Hospital","Ambulance","BMI","Health Tips","Mail"};
    Integer[] gridImage={R.mipmap.doctor,R.mipmap.hospital,R.mipmap.ambulance,
          R.mipmap.bmi,R.mipmap.health_tips,R.mipmap.email_homecsreen};


    Boolean isInternetPresent=false;
    ConnectionDetector cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // getActionBar().show();




        cd=new ConnectionDetector(getApplicationContext());
        isInternetPresent=cd.isConnectingToInternet();


        if(isInternetPresent){
            GridView gridview = (GridView) findViewById(R.id.gridView1);
           gridview.setAdapter(new CustomAdapter(getApplicationContext(), gridTitle, gridImage));

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    // Send intent to SingleViewActivity
                    switch (position) {
                        case 0:
                            Intent i = new Intent(getApplicationContext(), DoctorSearch.class);
                            //i.putExtra("doctor", position);
                            startActivity(i);
                            break;

                        case 1:
                            Intent i1 = new Intent(getApplicationContext(), HospitalSearch.class);
                            //i1.putExtra("hospital", position);
                            startActivity(i1);
                            break;

                        case 2:
                            Intent i2 = new Intent(getApplicationContext(), AmbulanceSearch.class);
                           //i2.putExtra("ambulance", position);
                            startActivity(i2);
                            break;

                        case 3:
                            Intent i3 = new Intent(getApplicationContext(), BmiCalculator.class);
                            //i3.putExtra("bmi", position);
                            startActivity(i3);
                            break;

                        case 4:
                         Intent i4 = new Intent(getApplicationContext(), ExpandableActivity.class);
                       //i4.putExtra("health_tips", position);
                         startActivity(i4);
                         break;

                        case 5:

                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.setType("text/plain");

                            intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[]{"bddoctors.developers@gmail.com"});
                            intent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject");
                            intent.putExtra(android.content.Intent.EXTRA_TEXT,"");

                            startActivity(Intent.createChooser(intent,"Send Email"));
                         break;
                    }
                }
            });
        }
        else{
            showAlertDialog(MainActivity.this,"No Internet Connection","Please,Connect the Internet");
        }
    }


    public void showAlertDialog(Context context,String title,String message){
        AlertDialog alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon(R.mipmap.alert);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
