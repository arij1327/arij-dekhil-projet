package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class telephone extends AppCompatActivity {
    ListView lv;
    String[] t = new String[]{"Dell", "Hp", "Asus", ""};
    ArrayList<String> a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);
        lv = findViewById(R.id.lv1);
        registerForContextMenu(lv);

        Integer val;

        a=new ArrayList<String>();
        ArrayAdapter B=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,a);
        lv.setAdapter(B);
        a.add("iphone");
        a.add("samsung");
        a.add("iphone14");
        Intent k = getIntent();
        a.add(k.getStringExtra("x"));




        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                a.remove(position);

                showMyDialog(position);
            }
        });

    }
    private void showMyDialog(int position) {
        Dialog dialog = new Dialog(telephone.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        TextView réfirence = dialog.findViewById(R.id.mod);
        TextView description = dialog.findViewById(R.id.cred);
        TextView prix = dialog.findViewById(R.id.desc);
        Button b = dialog.findViewById(R.id.ok);
        if (position == 0) {
            réfirence.setText("iphone");
            description.setText("");
            prix.setText("1020");
        } else if (position == 1) {
            réfirence.setText("samsung");
            description.setText("2");
            prix.setText("750");
        } else {
            réfirence.setText("iphone14");
            description.setText("2");
            prix.setText("1400");
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.a1:
                Intent c = new Intent(telephone.this, article1.class);
                startActivity(c);
                break;
            case R.id.a2:
                Intent h = new Intent(telephone.this, rechercher.class);
                startActivity(h);
                break;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_cont,menu);
        return;

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.a1:
                a.remove(item);
                lv.deferNotifyDataSetChanged();
                break;
        }



        return true;
    }
}