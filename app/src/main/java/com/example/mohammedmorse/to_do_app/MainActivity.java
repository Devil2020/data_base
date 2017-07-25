package com.example.mohammedmorse.to_do_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ArrayList<String> data;
    Helper help;
    EditText edit_txt;
    RecyclerView rca;
    RecyclerView.LayoutManager llm;
    Recycleviewadapter adapt;
    String object;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_txt=(EditText)findViewById(R.id.edittextmain);
        rca=(RecyclerView)findViewById(R.id.a);
        llm=new LinearLayoutManager(MainActivity.this);
        rca.setLayoutManager(llm);
         data=new ArrayList<String>();
        help=new Helper(this);
        data=help.select();
        adapt=new Recycleviewadapter(data,MainActivity.this);
    rca.setAdapter(adapt);
    }
     public void Click(View v){
         object=new String();
         object=edit_txt.getText().toString();
         data.add(object);
         adapt.notifyDataSetChanged();
         help.Insert(object);
     }


}
