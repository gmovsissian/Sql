package com.example.student.sql;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textview;
    Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textview=findViewById(R.id.textview);
        read=findViewById(R.id.read);
       final DbHelper dbHelper=new DbHelper(this);
       read.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Cursor cursor=dbHelper.getDate();
               StringBuilder stringBuilder=new StringBuilder();
               while (cursor.moveToNext()){
                   stringBuilder.append("Id "+cursor.getString(0)+"\n");
                   stringBuilder.append("Name "+cursor.getString(1)+"\n");
                   stringBuilder.append("Age "+cursor.getString(2)+"\n");
               }
               textview.setText(stringBuilder);
           }
       });
    }
}
