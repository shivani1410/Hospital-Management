package com.example.shivanimathur.hospital;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.shivanimathur.hospital.R.id.bed;

import static com.example.shivanimathur.hospital.R.id.test;

/**
 * Created by shivanimathur on 15/04/18.
 */

public class patientview extends AppCompatActivity{
    TextView name1,age,med,test,bed;
    String json_url="http://192.168.43.179:8888/patientview.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientview);
        name1=(TextView)findViewById(R.id.name1);
        age=(TextView)findViewById(R.id.age);
        med=(TextView)findViewById(R.id.med);
        test=(TextView)findViewById(R.id.test);
        bed=(TextView)findViewById(R.id.bed);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST,json_url,null,
                (new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            name1.setText(response.getString("pat_name"));
                            age.setText(response.getString("pat_age"));
                            med.setText(response.getString("pat_med"));
                            test.setText(response.getString("pet_test"));
                            bed.setText(response.getString("ward_bed"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }),(new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })); Singleton.getSingleton(patientview.this).addToRequestQueue(jsonObjectRequest);

    }
}
