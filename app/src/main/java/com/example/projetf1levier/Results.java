package com.example.projetf1levier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Results extends AppCompatActivity {
    ArrayList<String> listItems=new ArrayList<String>();
    private teamList teams;

    ArrayAdapter<String> adapter;
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



        ListView listView = (ListView)findViewById(R.id.results_view);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
    }

    public void validateclic(View view)
    {
        Spinner spinnerEntity=(Spinner) findViewById(R.id.spinner2);
        Spinner spinnerStep=(Spinner) findViewById(R.id.spinner4);
        if (spinnerEntity.getSelectedItemPosition()==0)
        {
            listItems.add("Team:     Temps:");
            adapter.notifyDataSetChanged();
        }
        else
        {
            ArrayList<String> affichageResult=null;
            listItems.clear();
            switch (spinnerStep.getSelectedItemPosition()){
                case 0 : //all course

                    break;
                case 1 : //sprint1
                    affichageResult=getTimeBystep(0);
                    break;
                case 2 : //obstacle1
                    affichageResult=getTimeBystep(1);
                    break;
                case 3 : //ravitaillement
                    affichageResult=getTimeBystep(2);

                    break;
                case 4 : //sprint2
                    affichageResult=getTimeBystep(3);

                    break;
                case 5 : //obstacle2
                    affichageResult=getTimeBystep(4);

                    break;
                case 6 : //tour1 (s1+o1)

                    break;
                case 7 : //tour1 (s2+o2)

                    break;
            }
            for (int i=0;i<affichageResult.size();i++)
            {
                listItems.add(affichageResult.get(i));
            }

            adapter.notifyDataSetChanged();
        }




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


        Collections.sort(listTimeByStep, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.first.compareTo(p2.first);
            }
        });

        for (int taille=0;taille<listTimeByStep.size();taille++)
        {
            StringTimeByStep.add(listTimeByStep.get(taille).getSecond()+listTimeByStep.get(taille).getFirst());
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