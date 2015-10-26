package com.example.shanto.bddoctors;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;





public class HospitalDetails extends Activity {
    TextView txtName,txtEmail,txtPhone,txtInfo,txtfield,txtAddress,txtlocation,txtlatitude,txtlongitude,txtPlace;
    private ProgressDialog pDialog;
    String pid;
    JSONParser jsonParser=new JSONParser();

    private static final String url_product_detials = "http://bddoctors.honor.es//hospital_details.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCT = "product";
    private static final String TAG_NAME = "name";
    private static final String TAG_DOCTOR = "doctor";
    private static final String TAG_DID = "id";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PHONE = "phone";
    private static final String TAG_INFO = "info";
    private static final String TAG_FIELD = "specialfield";
    private static final String TAG_ADDRESS = "address";
  // private static final String TAG_LOCATION = "location";
    private static final String TAG_LATITUDE = "latitude";
    private static final String TAG_LONGITUDE = "longitude";
    private static final String TAG_PLACE = "place";

    ArrayList<HashMap<String, String>> doctorList;
    JSONArray doctor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_details);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        // getting product details from intent
        Intent i = getIntent();

        // getting product id (pid) from intent
        pid = i.getStringExtra(TAG_DID);
        doctorList= new ArrayList<HashMap<String, String>>();
        new GetProductDetails().execute();
    }
    class GetProductDetails extends AsyncTask<String,String,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(HospitalDetails.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }


        @Override
        protected String doInBackground(String... params) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    int success;
                    try {
                        List<NameValuePair> params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("id", pid));
                        JSONObject json = jsonParser.makeHttpRequest(
                                url_product_detials, "GET", params);
                        Log.d("Single Product Details", json.toString());
                        success = json.getInt(TAG_SUCCESS);
                        if (success==1){
                            JSONArray productObj = json
                                    .getJSONArray(TAG_PRODUCT);
                            // get first product object from JSON Array
                            JSONObject product = productObj.getJSONObject(0);
                            txtName=(TextView)findViewById(R.id.name);
                            txtEmail=(TextView)findViewById(R.id.email);
                            txtPhone=(TextView)findViewById(R.id.phone);
                           //txtInfo=(TextView)findViewById(R.id.info);

                            txtAddress=(TextView)findViewById(R.id.address);
                           // txtlocation=(TextView)findViewById(R.id.location);
                            txtlatitude=(TextView)findViewById(R.id.latitude);
                            txtlongitude=(TextView)findViewById(R.id.longitude);
//                            txtPlace=(TextView)findViewById(R.id.place);


                            txtName.setText(product.getString(TAG_NAME));
                            txtEmail.setText(product.getString(TAG_EMAIL));
                            txtPhone.setText(product.getString(TAG_PHONE));
                           //txtInfo.setText(product.getString(TAG_INFO));
                            //txtfield.setText(product.getString(TAG_FIELD));
                            txtAddress.setText(product.getString(TAG_ADDRESS));
                            //txtlocation.setText(product.getString(TAG_LOCATION));

                            //txtlatitude.setText(product.getString(TAG_LATITUDE));
                            //txtlongitude.setText(product.getString(TAG_LONGITUDE));
                            //txtPlace.setText(product.getString(TAG_PLACE));

                            final double str_lat=product.getDouble(TAG_LATITUDE);
                            final double str_long=product.getDouble(TAG_LONGITUDE);
                            final String str_name=product.getString(TAG_NAME);

                            final String str_mail=product.getString(TAG_EMAIL);
                            ImageButton btn_email=(ImageButton)findViewById(R.id.btnEmail);
                            ImageButton btn_call=(ImageButton)findViewById(R.id.btnCall);
                            ImageButton btn_location=(ImageButton)findViewById(R.id.btnLocation);
                            btn_location.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(HospitalDetails.this,MapsActivity_Doctor.class);
                                    intent.putExtra("latitude",str_lat);
                                    intent.putExtra("longitude",str_long);
                                    intent.putExtra("doctorName",str_name);
                                    startActivity(intent);
                                }
                            });
                            btn_call.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String number = txtPhone.getText().toString();
                                    Uri call = Uri.parse("tel:" + number);
                                    Intent intent = new Intent(Intent.ACTION_CALL, call);
                                    startActivity(intent);
                                }
                            });
                            btn_email.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(Intent.ACTION_SEND);
                                    intent.setType("text/plain");
                                    String str_email=str_mail;
                                    intent.putExtra(android.content.Intent.EXTRA_EMAIL,str_email);
                                    intent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
                                    intent.putExtra(Intent.EXTRA_TEXT,"I'm email body.");

                                    startActivity(Intent.createChooser(intent,"Send Email"));
                                }
                            });


                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }

                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pDialog.dismiss();
        }
    }
}

