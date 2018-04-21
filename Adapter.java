package com.example.shivanimathur.hospital;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.start;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.shivanimathur.hospital.R.id.age;
import static com.example.shivanimathur.hospital.R.id.med;
import static com.example.shivanimathur.hospital.R.id.test;

/**
 * Created by shivanimathur on 15/04/18.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<list_item> list_items=new ArrayList<>();



    public Adapter(ArrayList<list_item> list_items, Context ctx){
        this.list_items=list_items;
        this.context=ctx;


    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false);
       // view=LayoutInflater.from(parent.getContext()).inflate(R.layout.patientview,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.Name.setText(list_items.get(position).getName());
       holder.listView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context,patientview.class);
               context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return list_items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView Name;
        LinearLayout listView;
        public ViewHolder(View itemView) {
            super(itemView);
            Name=(TextView)itemView.findViewById(R.id.name);
            listView=(LinearLayout)itemView.findViewById(R.id.listView);


        }
    }
}
