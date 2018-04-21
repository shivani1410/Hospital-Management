package com.example.shivanimathur.hospital;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by shivanimathur on 15/04/18.
 */

public class Singleton {
    private static Singleton singleton;
    private RequestQueue requestQueue;
    private static Context ctx;
    private Singleton(Context context){
        ctx=context;
        requestQueue=getRequestQueue();
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(ctx.getApplicationContext());

        }return requestQueue;
    }
    public static synchronized Singleton getSingleton(Context context){
        if(singleton==null){
            singleton=new Singleton(context);
        }return singleton;
    }
    public<T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
