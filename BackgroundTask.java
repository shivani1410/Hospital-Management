package com.example.shivanimathur.hospital;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by shivanimathur on 15/04/18.
 */

public class BackgroundTask {
    Context context;
    String json_url="http://192.168.43.179:8888/doctorlist.php";

    ArrayList<list_item> list_items=new ArrayList<>();

    public BackgroundTask(Context context){
        this.context=context;
    }
    public ArrayList<list_item> getList_items(){
        final JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST,json_url,null,
                (new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count=0;
                        while (count<response.length()){
                            try {
                                JSONObject jsonObject=response.getJSONObject(count);

                                list_item list_item=new list_item(jsonObject.getString("Name"));
                                list_items.add(list_item);
                                count++;
                            } catch (JSONException e) {
                                Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                        }
                    }
                }),(new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                }}));
        Singleton.getSingleton(context).addToRequestQueue(jsonArrayRequest);
        return list_items;
        }


    }

