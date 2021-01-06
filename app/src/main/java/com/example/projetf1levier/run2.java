package com.example.projetf1levier;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class run2 extends AppCompatActivity {

    RunAdapter m_runAdapter;

    //private teamList teams;
    teamList teams;
    long pastChrono;
    long ChronoCours;
    int position=0;

    Button btnStart, btnLap;
    TextView txtTimer;
    Handler customeHandler = new Handler();
    long startTime=0L,timeInMilliSeconds=0L,timeSwapBuff=0L,updateTime=0L;

    Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            timeInMilliSeconds = SystemClock.uptimeMillis()-startTime;
            updateTime=timeSwapBuff+timeInMilliSeconds;
            int secs=(int)(updateTime/1000);
            int mins=secs/60;
            secs%=60;
            int milliseconds=(int)(updateTime%1000);
            ChronoCours= updateTime;
            txtTimer.setText(""+mins+":"+String.format("%02d",secs)+":"+String.format("%3d",milliseconds));
            customeHandler.postDelayed(this,0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run2);

        Intent intent = getIntent();
        teams = (teamList)intent.getSerializableExtra("teamList");

        GridView gridView = (GridView)findViewById(R.id.runGridView);
        m_runAdapter= new RunAdapter(this, teams);
        gridView.setAdapter(m_runAdapter);

        btnStart=(Button)findViewById(R.id.start_but);
        btnLap=(Button)findViewById(R.id.results_but);
        txtTimer=(TextView)findViewById(R.id.timerValue2);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime=SystemClock.uptimeMillis();
                customeHandler.postDelayed(updateTimerThread,0);
                btnStart.setVisibility(view.INVISIBLE);
            }
        });

        btnLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //   View addView =inflater.inflate(R.layout.row,null);
                TextView txtValue = (TextView) findViewById(R.id.recupChrono);

                team currentTeam=teams.getListOfTeam().get(0);

                currentTeam.getPlayerList().get(currentTeam.getNumberPlayerRun()).addChrono(ChronoCours-pastChrono);

                //txtValue.setText(txtTimer.getText());
                //txtValue.setText(String.valueOf(ChronoCours-pastChrono));
                pastChrono=ChronoCours;


                teams.getListOfTeam().get(0).nextStepRun();
                m_runAdapter.notifyDataSetChanged();
            }
        });

    }

    public void nextClick(View v) {

    }

    public void resultClick(View view) {
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("teamList", teams);
        startActivity(intent);
    }

}