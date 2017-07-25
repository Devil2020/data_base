package com.example.mohammedmorse.to_do_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mohammed Morse on 22/07/2017.
 */

public class Recycleviewadapter extends RecyclerView.Adapter<Recycleviewadapter.item_holder>{
    ArrayList<String>data;
    Context con;

    public Recycleviewadapter(ArrayList<String >data, Context con){
        this.data= data ;
        this.con=con;
    }
    public item_holder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rec,parent,false);
       item_holder ih=new item_holder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(item_holder holder, int position) {
          holder.txt_Name.setText(data.get(position));
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class item_holder extends  RecyclerView.ViewHolder{
              TextView txt_Name;

        public item_holder(View itemView) {
            super(itemView);
            txt_Name=(TextView)itemView.findViewById(R.id.textView);
        }
    }
}
