package com.example.mohammedmorse.to_do_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Morse on 22/07/2017.
 */

public class Helper extends SQLiteOpenHelper {
    static String DATABASE_NAME="TODODATA";
    static int VERSION=4;
    public Helper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+Contract.table_name+" ( "+Contract.message_column+" TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+Contract.table_name+" ;");
        onCreate(sqLiteDatabase);
    }
    public void Insert(String txt){
        SQLiteDatabase sql= getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Contract.message_column,txt);
        sql.insert(Contract.table_name,null,cv);
    }
    public void update(String old_data , String new_data){
        SQLiteDatabase sql=getWritableDatabase();
        sql.execSQL("update into "+Contract.table_name+" set "+Contract.message_column+"="+new_data+" where "+Contract.message_column+"="+old_data);
    }
    public void delet(String del_data){
        SQLiteDatabase sql=getWritableDatabase() ;
        sql.execSQL("delete "+Contract.table_name+" where "+Contract.message_column+" = "+del_data);
    }
    public ArrayList<String> select(){
        SQLiteDatabase sql=getReadableDatabase() ;
        ArrayList<String> list=new ArrayList<>();
        Cursor c=sql.query(Contract.table_name,new String[]{Contract.message_column},null,null,null,null,null);
        c.moveToFirst();
        for (int i=0;i<c.getCount();i++){
            list.add(c.getString(0));
            c.moveToNext();
        }
        return list;
      /*  sql.execSQL("select * from "+Contract.table_name);*/
    }
}
