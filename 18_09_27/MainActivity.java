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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonFirst;
    TextView textViewFirst;
    ImageView imageViewFirst;
    //boolean isKorean = true;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFirst = (Button) findViewById(R.id.btn_first);
        textViewFirst = (TextView) findViewById(R.id.text_first);
        imageViewFirst = (ImageView) findViewById(R.id.img_ic);

        //Glide.with(this).load("https://images-na.ssl-images-amazon.com/images/I/319zVjPQZRL.jpg").into(imageViewFirst);

        /*
        Intent intent;
        intent = new Intent();

        startActivity(intent);
         */

        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent openIntent;
                //openIntent = new Intent(MainActivity.this, SubActivity.class);

                //startActivity(openIntent);
                Random rnd = new Random();
                int num = rnd.nextInt(5);

                i = num;

                if (i == 0){
                    Glide.with(MainActivity.this).load("https://www.upluslte.co.kr/promotion/Images/MarbleKing/result1.png").into(imageViewFirst);
                }
                else if ( i == 1){
                    Glide.with(MainActivity.this).load("https://cdn.xl.thumbs.canstockphoto.co.kr/%EB%B9%A8%EA%B0%95-%EC%A3%BC%EC%82%AC%EC%9C%84-2-%EC%97%90-%EC%A0%95%EC%83%81-%EC%82%AC%EC%A7%84_csp1693451.jpg").into(imageViewFirst);
                }
                else if ( i == 2 ){
                    Glide.with(MainActivity.this).load("https://cdn.xl.thumbs.canstockphoto.co.kr/%EB%B9%A8%EA%B0%95-%EC%A3%BC%EC%82%AC%EC%9C%84-3-%EC%97%90-%EC%A0%95%EC%83%81-%EC%8A%A4%ED%86%A1-%EC%82%AC%EC%A7%84_csp1693452.jpg").into(imageViewFirst);
                }
                else if ( i == 3 ){
                    Glide.with(MainActivity.this).load("https://comps.canstockphoto.co.kr/4-%EC%A3%BC%EC%82%AC%EC%9C%84-%EC%A0%95%EC%83%81-%EB%B9%A8%EA%B0%95-%EC%8A%A4%ED%86%A1-%EC%82%AC%EC%A7%84_csp1693453.jpg").into(imageViewFirst);
                }
                else if ( i == 4 ){
                    Glide.with(MainActivity.this).load("data:image/jpeg;base64,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").into(imageViewFirst);
                }
                else if ( i == 5){
                    Glide.with(MainActivity.this).load("https://comps.canstockphoto.co.kr/%EC%A3%BC%EC%82%AC%EC%9C%84-%EC%A0%95%EC%83%81-6-%EB%B9%A8%EA%B0%95-%EC%8A%A4%ED%86%A1-%EC%9D%B4%EB%AF%B8%EC%A7%80_csp1693456.jpg").into(imageViewFirst);
                }

            }
        });
    }

    @Override
    protected  void onStart()
    {
        super.onStart();
    }
}
