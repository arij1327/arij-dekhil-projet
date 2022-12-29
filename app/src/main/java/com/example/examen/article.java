package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class article extends AppCompatActivity {
    EditText e1;
    EditText e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        b1=findViewById(R.id.b1);
      Intent c=getIntent();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nn=e1.getText().toString();
                Intent k=new Intent(article.this,liste.class);
                k.putExtra("x",nn);
                startActivity(k);

            }
        });
    }
}