package com.example.student.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by student on 2/3/18.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String DbName="MyDb";
    String Table_name="Java";
    String col_id="Id";
    String col_name="Name";
    String col_age="Age";


    public DbHelper(Context context) {
        super(context,DbName ,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Java(Id integer Primary key Autoincrement,"+"Name VarChar(15) Not Null,Age Text Not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
   sqLiteDatabase.execSQL("Drop table if exists Java");
    }
    public boolean myinsert(String name,String age){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_name,name);
        contentValues.put(col_age,age);
        long i=sqLiteDatabase.insert(Table_name,null,contentValues);
        if (i==-1){
            return  false;
        }else {
            return true;
        }

    }public Cursor getDate(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from Java",null);
        return cursor;
    }

}
