package com.example.shivanimathur.hospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Doctor1 extends AppCompatActivity  {
    private RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    private ArrayList<list_item> list_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor1);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BackgroundTask backgroundTask=new BackgroundTask(Doctor1.this);
        list_items=backgroundTask.getList_items();
         adapter=new Adapter(list_items, this);
        recyclerView.setAdapter(adapter);


    }
}
