package com.example.imgtextenc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Second extends AppCompatActivity {
    ImageView img,txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img = findViewById(R.id.imgbt);
        txt = findViewById(R.id.txtbt);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Second.this,img.class);
                startActivity(intent);
               // finish(Second);

            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Second.this,txt.class);
                startActivity(intent);
               //finish(Second);


            }
        });
    }
}