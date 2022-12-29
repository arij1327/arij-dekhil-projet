package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.PrecomputedTextCompat;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.PrecomputedText;
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

public class liste extends AppCompatActivity {
    ListView lv;
    String[] t = new String[]{"Dell", "Hp", "Asus", ""};
    ArrayList<String>a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        lv = findViewById(R.id.lv1);
        registerForContextMenu(lv);

Integer val;

        a=new ArrayList<String>();
        ArrayAdapter B=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,a);
        lv.setAdapter(B);
        a.add("Dell");
        a.add("hp");
        a.add("asus");
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
        Dialog dialog = new Dialog(liste.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        TextView réfirence = dialog.findViewById(R.id.mod);
        TextView description = dialog.findViewById(R.id.cred);
        TextView prix = dialog.findViewById(R.id.desc);
        Button b = dialog.findViewById(R.id.ok);
        if (position == 0) {
            réfirence.setText("Dell");
            description.setText("");
            prix.setText("1350");
        } else if (position == 1) {
            réfirence.setText("Hp");
            description.setText("2");
            prix.setText("1275");
        } else {
            réfirence.setText("Asus");
            description.setText("2");
            prix.setText("1700");
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
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.a1:
                Intent c = new Intent(liste.this, article.class);
                startActivity(c);
                break;
            case R.id.a3:
                Intent h = new Intent(liste.this, rechercher.class);
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
    }}