package com.example.projetf1levier;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RunActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.run_screen);
    }

    private static int i=1;
    public void onClick(View v) {
        ImageView I = findViewById(R.id.num_player_team1);
        int[] Image={R.drawable.pict1,R.drawable.pict2,R.drawable.pict3};
        I.setImageResource(Image[i++]);
    }
}





