package com.example.projetf1levier;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class teamView extends AppCompatActivity {

    //private teamList teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_view);

        Intent intent = getIntent();


        teamList teams = (teamList)intent.getSerializableExtra("teamList");

        GridView gridView = (GridView)findViewById(R.id.teamGridView);



        TeamAdapter teamAdapter = new TeamAdapter(this,teams);

        gridView.setAdapter(teamAdapter);
    }
}
