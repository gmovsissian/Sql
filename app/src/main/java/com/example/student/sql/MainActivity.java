package com.example.student.sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText nametext;
EditText agetext;
Button save;
Button go;
EditText idtext;
Button update;
Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nametext=findViewById(R.id.name);
        agetext=findViewById(R.id.age);
        save=findViewById(R.id.save);
        go=findViewById(R.id.go);
        idtext=findViewById(R.id.id);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        final DbHelper dbHelper=new DbHelper(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nametext.getText().toString();
                String age=agetext.getText().toString();
                if (dbHelper.myinsert(name, age)) {
                    Toast.makeText(MainActivity.this,"Save",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();

                }
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nametext.getText().toString();
                String age=agetext.getText().toString();
                String id=idtext.getText().toString();
                dbHelper.myupdate(id,name,age);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=idtext.getText().toString();
                dbHelper.mydelete(id);
            }
        });
    }
}
