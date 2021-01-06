package com.example.projetf1levier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class run2 extends AppCompatActivity {


    RunAdapter m_runAdapter;

    //private teamList teams;
    teamList teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run2);


        Intent intent = getIntent();

        teams = (teamList)intent.getSerializableExtra("teamList");

        GridView gridView = (GridView)findViewById(R.id.runGridView);



        m_runAdapter= new RunAdapter(this, teams);



        gridView.setAdapter(m_runAdapter);
    }

    public void nextClick(View v) {
        teams.getListOfTeam().get(0).nextStepRun();
        m_runAdapter.notifyDataSetChanged();
    }

}