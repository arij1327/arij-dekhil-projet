package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
GridView g;
String []t=new String[]{"pc bureau","telephone","accessoirs","cables"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g=findViewById(R.id.g);
        ArrayAdapter<String>A=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,t);
        g.setAdapter(A);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position== 0) {
                    Intent l=new Intent(MainActivity.this,liste.class);
                    startActivity(l);
                }
                else if (position==1){
                    Intent p=new Intent(MainActivity.this,telephone.class);
                    startActivity(p);
                }
                else if (position==2){
                    Intent d=new Intent(MainActivity.this,accessoirs.class);
                    startActivity(d);
                }


            }
        });


    }
}