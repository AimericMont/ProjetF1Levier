package com.example.projetf1levier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Results extends AppCompatActivity {

    teamList teams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        teams = (teamList)intent.getSerializableExtra("teamList");

        Spinner spinner1=(Spinner) findViewById(R.id.spinner2);
        Spinner spinner2=(Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.entityValues, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.stepValues, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

    }


    public void biteclick(View v)
    {
        ArrayList<String> a=getTimeBystep(1);


        int b=1;
    }

    public ArrayList<String> getTimeBystep(int step)
    {
        ArrayList<String> StringTimeByStep=new ArrayList<String>();

        ArrayList<Pair> listTimeByStep=new ArrayList<Pair>();
        long time=0;

        for (int team=0;team<teams.getNbTeam();team++)
        {
            for (int player=0;player<3;player++)
            {
                time=teams.getTimeForPlayer(team,player,step);
                player p=teams.getListOfTeam().get(team).getPlayerList().get(player);
                Pair timeForPlayer=new Pair(time,p.getFullName());

                listTimeByStep.add(timeForPlayer);
            }

        }


        Collections.sort(listTimeByStep, new Comparator<Pair> () {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.first.compareTo(p2.first);
            }
        });

        for (int taille=0;taille<listTimeByStep.size();taille++)
        {
            StringTimeByStep.add(listTimeByStep.get(taille).getSecond()+String.valueOf(listTimeByStep.get(taille).getFirst()));
        }


        //test bie
        return StringTimeByStep;
    }


    private static class Pair
    {
        private Long first;
        private String second;

        public Pair(Long _first,String _second)
        {
            first=_first;
            second=_second;
        }

        public Long getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }
    }


}