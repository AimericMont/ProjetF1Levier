package com.example.projetf1levier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        ImageView I = findViewById(R.id.imageView);
        int[] Image={R.drawable.pict1,R.drawable.pict2,R.drawable.pict3};
        I.setImageResource(Image[i]);
        i++;
    }
}

