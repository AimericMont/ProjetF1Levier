package com.example.projetf1levier;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class run2 extends AppCompatActivity {

    RunAdapter m_runAdapter;
    Context c=this;
    //private teamList teams;
    teamList teams;

    long ChronoCours;
    int position=0;

    Button btnStart, btnLap;
    TextView txtTimer;
    Handler customeHandler = new Handler();
    long startTime=0L,timeInMilliSeconds=0L,timeSwapBuff=0L;



    Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            timeInMilliSeconds = SystemClock.uptimeMillis()-startTime;
            ChronoCours=timeSwapBuff+timeInMilliSeconds;
            int secs=(int)(ChronoCours/1000);
            int mins=secs/60;
            secs%=60;
            int milliseconds=(int)(ChronoCours%1000);
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


    }

    public void start(View view)
    {


        m_runAdapter.start();

    }

    public void nextClick(View v) {
        teams.getListOfTeam().get(0).nextStepRun();
        m_runAdapter.notifyDataSetChanged();
    }

    public void runClick(View view) {

    }

    public void resultClick(View view) {
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("teamList", teams);
        startActivity(intent);
    }

    public Button getButtonStart()
    {
        return btnStart;
    }

    public TextView getTextTimmer()
    {
        return txtTimer;
    }

}