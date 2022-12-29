package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.SearchView;
import androidx.appcompat.widget.SearchView;

public class rechercher extends AppCompatActivity {

    SearchView search;
    ListView li;
    String[] st=new String[]{"Iphone","samsung","Iphone 14","Dell","Hp","Acer","Asus"};
    ArrayAdapter sta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher);
        search=findViewById(R.id.search);
        li=findViewById(R.id.lv);
        sta = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,st);
        li.setAdapter(sta);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                sta.getFilter().filter(s);
                return true;


            }
        });











    }

}
