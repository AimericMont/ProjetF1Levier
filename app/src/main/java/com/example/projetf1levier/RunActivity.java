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

    int stepcont=1;
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





