package com.example.imgtextenc;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;

public class img extends AppCompatActivity {

    Button encode,decode;
    TextView ans2;
    ImageView img12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);


        encode =findViewById(R.id.enbtn);
        decode=findViewById(R.id.debtn);
        ans2=findViewById(R.id.ans2);
        img12=findViewById(R.id.image2);

        encode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //checking condition
                if(ContextCompat.checkSelfPermission(img.this
                                  ,Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                    //when permission is not granted
                    //request permission
                    ActivityCompat.requestPermissions(img.this
                                ,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}
                                ,100);
                }
                else{
                    //when permission is granted
                    //create method
                    selectImage();
                }



            }
        });






    }



    private void selectImage() {
        //clear previous text
        ans2.setText("");
        img12.setImageBitmap(null);
        //initialize intent
        Intent intent = new Intent(Intent.ACTION_PICK);
        //set type
        intent.setType("image/*");
        //start activity result
        startActivityForResult(Intent.createChooser(intent,"Select Image")
                ,100);




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // check condition
        if(requestCode==100 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            // when permission is granted
            //call method
            selectImage();
        }
        else {
            //when permission denied
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
        }
            
    }
    

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
