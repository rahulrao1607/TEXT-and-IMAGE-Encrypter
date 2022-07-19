package com.example.imgtextenc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

import static com.scottyab.aescrypt.AESCrypt.encrypt;

public class txt extends AppCompatActivity {

    Button enc,dec;
    EditText key,message;
    TextView ans;
    ClipboardManager cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt);

        enc = findViewById(R.id.encbtn);
        dec = findViewById(R.id.decbtn);
        message = findViewById(R.id.enctxt);
        key= findViewById(R.id.password);
        ans=findViewById(R.id.txtans);




        enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String encrypted = AESCrypt.encrypt(key.getText().toString(),message.getText().toString());
                    cpb = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                    ClipData temp= ClipData.newPlainText("label",encrypted);
                    cpb.setPrimaryClip(temp);
                    //Toast.makeText(this,"Copied",Toast.LENGTH_SHORT).show();
                    key.setText("");
                    message.setText("");
                    ans.setText(encrypted);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }


            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String encrypted = AESCrypt.decrypt(key.getText().toString(),message.getText().toString());
                     key.setText("");
                    message.setText("");
                    ans.setText(encrypted);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }


            }
        });



    }

}