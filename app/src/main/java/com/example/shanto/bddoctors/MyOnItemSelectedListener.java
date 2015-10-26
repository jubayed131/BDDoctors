package com.example.shanto.bddoctors;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by shanto on 10/5/2015.
 */
public class MyOnItemSelectedListener  implements AdapterView.OnItemSelectedListener{
    @Override
    public void onItemSelected(AdapterView parent, View view, int pos, long id) {

        Toast.makeText(parent.getContext(), "Selected District : " +
                parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView parent) {

    }
}
