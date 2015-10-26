package com.example.shanto.bddoctors;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;





public class ListAmbulance extends ListActivity {

    private ProgressDialog pDialog;
    JSONParser jParser = new JSONParser();


    // URL to get contacts JSON

    private static String url_all_doctors = "http://bddoctors.honor.es//get_all_ambulance.php";


    // JSON Node names
    private static final String TAG_SUCCESS = "success";

    private static final String TAG_DOCTOR = "ambulance";
    private static final String TAG_DID = "ID";
    private static final String TAG_NAME = "name";
    private static final String TAG_PLACE="place";
    private static final String TAG_FIELD="specialfield";


    // contacts JSONArray
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_ambulance);





        contactList = new ArrayList<HashMap<String, String>>();
        // new GetContacts().execute();

        ListView lv = getListView();

        // Listview on item click listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String pid = ((TextView) view.findViewById(R.id.pid)).getText()
                        .toString();
                Intent in = new Intent(getApplicationContext(),
                        AmbulanceDetails.class);
                // sending pid to next activity
                in.putExtra(TAG_DID, pid);
                startActivityForResult(in, 100);
                // startActivity(in);


            }
        });

        //Calling async task to get json
        new GetContacts().execute();
    }

    // Response from Edit Product Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if result code 100
        if (resultCode == 100) {
            // if result code 100 is received
            // means user edited/deleted product
            // reload this screen again
            Intent intent = getIntent();
            finish();


            startActivity(intent);
        }
    }

    /**
     * Async task class to get json by making HTTP call
     */
    class GetContacts extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(ListAmbulance.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... arg0) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            JSONObject json = jParser.makeHttpRequest(url_all_doctors, "GET", params);
            // Check your log cat for JSON reponse
            Intent intent=getIntent();
            String str_place=intent.getExtras().getString("place");
           // String str_field=intent.getExtras().getString("specialfield");


            Log.d("All Products: ", json.toString());
            try {
                int success = json.getInt(TAG_SUCCESS);
                if (success==1) {
                    // Getting Array of Products
                    contacts = json.getJSONArray(TAG_DOCTOR);
                    // looping through All Products
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        // Storing each json item in variable
                        String id = c.getString(TAG_DID);
                        String name = c.getString(TAG_NAME);
                        String place=c.getString(TAG_PLACE);
                        String field=c.getString(TAG_FIELD);
                        String str_all="All";

                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        if(place.equals(str_place)){
                            map.put(TAG_DID, id);
                            map.put(TAG_NAME, name);

                            // adding HashList to ArrayList
                            contactList.add(map);
                        }
                        else if(str_all.equals(str_place)){
                            map.put(TAG_DID, id);
                            map.put(TAG_NAME, name);

                            // adding HashList to ArrayList
                            contactList.add(map);
                        }

                    }
                }
                //   else {
//                    Intent i = new Intent(getApplicationContext(),
//                            NewPr.class);
//                    // Closing all previous activities
//                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(i);
//                }
            }catch (JSONException e){
                e.printStackTrace();
            }








            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            // Dismiss the progress dialog

            pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    ListAmbulance.this, contactList,
                    R.layout.list_item_ambulance, new String[]{TAG_DID,TAG_NAME
            }, new int[]{R.id.pid,R.id.name
            });


            if(adapter.getCount()!=0){
                setListAdapter(adapter);
            }else{
                showAlertDialog(ListAmbulance.this, "Sorry", "No data is available now");
            }

        }
    }
    public void showAlertDialog(Context context,String title,String message){
        AlertDialog alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon(R.mipmap.folder_alert_icon);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.show();
    }
}

