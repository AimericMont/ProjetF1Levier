package com.example.projetf1levier;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Run extends AppCompatActivity {

    //private teamList teams;
    teamList teams;

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
            txtTimer.setText(""+mins+":"+String.format("%02d",secs)+":"+String.format("%3d",milliseconds));
            customeHandler.postDelayed(this,0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        Intent intent = getIntent();
        teams = (teamList)intent.getSerializableExtra("teamList");

        btnStart=(Button)findViewById(R.id.start_but);
        btnLap=(Button)findViewById(R.id.results_but);
        txtTimer=(TextView)findViewById(R.id.timerValue);

        //InterfaceTeamRun Team1((TextView)findViewById(R.id.title_team1),(Button)findViewById(R.id.but_team1),(ImageView)findViewById(R.id.step_team1),(ImageView)findViewById(R.id.num_player_team1));


       /* TextView txtValue2 = (TextView) findViewById(R.id.title_team2);
        txtValue2.setText(teams.getListOfTeam().get(0).getPlayerList().get(stepcont).getFirstName());
        ;*/

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime=SystemClock.uptimeMillis();
                customeHandler.postDelayed(updateTimerThread,0);
            }
        });

        btnLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //   View addView =inflater.inflate(R.layout.row,null);
                TextView txtValue = (TextView) findViewById(R.id.title_team1);
                txtValue.setText(txtTimer.getText());
            }
        });
    }










    int stepcont;
    int playercont=0;

    public void processClick(View v, int but_team, int img_player, int img_step)
    {
        Button nextstep=(Button)v;
        nextstep=findViewById(but_team);

        ImageView I = findViewById(img_player);
        ImageView I2 = findViewById(img_step);

        int[] ImageNum={R.drawable.pict1,R.drawable.pict2,R.drawable.pict3};
        int[] ImageStep={R.drawable.sprint1,R.drawable.obstacle1,R.drawable.ravitaillement,R.drawable.sprint2,R.drawable.obstacle2};

        I2.setImageResource(ImageStep[stepcont]);
        I.setImageResource(ImageNum[playercont]);
        if (stepcont==4)
        {
            stepcont=-1;
            playercont++;
        }
        stepcont++;
        if (playercont==3)
        {
            nextstep.setVisibility(View.INVISIBLE);
        }
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_team1 :
                processClick(v,R.id.but_team1,R.id.num_player_team1,R.id.step_team1);
                break;
            case R.id.but_team2 :
                processClick(v,R.id.but_team2,R.id.num_player_team2,R.id.step_team2);
                break;
            case R.id.but_team3 :
                processClick(v,R.id.but_team3,R.id.num_player_team3,R.id.step_team3);
                break;
            case R.id.but_team4 :
                processClick(v,R.id.but_team4,R.id.num_player_team4,R.id.step_team4);
                break;
        }
    }
}