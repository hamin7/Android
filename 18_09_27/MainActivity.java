package com.example.hamin.a18_09_20;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button buttonFirst;
    TextView textViewFirst;
    ImageView imageViewFirst;
    boolean isKorean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFirst = (Button) findViewById(R.id.btn_first);
        textViewFirst = (TextView) findViewById(R.id.text_first);
        imageViewFirst = (ImageView) findViewById(R.id.img_ic);


        Glide.with(this).load("https://images-na.ssl-images-amazon.com/images/I/319zVjPQZRL.jpg").into(imageViewFirst);

        /*
        Intent intent;
        intent = new Intent();

        startActivity(intent);
         */

        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openIntent;
                openIntent = new Intent(MainActivity.this, SubActivity.class);

                startActivity(openIntent);

            }
        });
    }

    @Override
    protected  void onStart()
    {
        super.onStart();
    }
}
