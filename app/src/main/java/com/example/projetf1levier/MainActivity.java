package com.example.projetf1levier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //commentaire test branch tim
    }

    /** Called when the user taps the Send button */
    public void playerSreen(View view) {
        // Do something in response to button

        Intent intent = new Intent(this, PlayerSreen.class);
        startActivity(intent);
    }



}