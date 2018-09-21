package com.example.hamin.a18_09_20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonFirst;
    TextView textViewFirst;
    boolean isKorean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFirst = (Button) findViewById(R.id.btn_first);
        textViewFirst = (TextView) findViewById(R.id.text_first);

        buttonFirst.setOnClickListener((v) ->){

            if(isKorean){
                textViewFirst.setText("Japan");
            }else{
                textViewFirst.setText("Korean");
            }
            isKorean = !isKorean;
        };
    }

    @Override
    protected  void onStart()
    {
        super.onStart();
    }
}
