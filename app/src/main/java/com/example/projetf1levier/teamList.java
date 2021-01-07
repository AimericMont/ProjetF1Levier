package com.example.projetf1levier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class teamList implements Serializable {

    ArrayList<team> m_listOfTeam;
    ArrayList<player> m_listOfPlayer;
    int[] m_imageNum={R.drawable.pict1,R.drawable.pict2,R.drawable.pict3};
    int[] m_imageStep={R.drawable.sprint1,R.drawable.obstacle1,R.drawable.ravitaillement,R.drawable.sprint2,R.drawable.obstacle2};


    public long getTimeForPlayer(int team,int player,int step)
    {
        return m_listOfTeam.get(team).getChronoPlayer((player+1)*3+step);
    }


    public teamList(PlayerSreen screen)
    {
        m_listOfTeam= new ArrayList<team>();
        m_listOfPlayer= new ArrayList<player> (30);
    }

    public int getImageNum(int n)
    {
        return m_imageNum[n];
    }

    public int getImageStep(int n)
    {
        return m_imageStep[n];
    }

    public void addPlayer(player _p)
    {
        m_listOfPlayer.add(_p);
    }

    public void addPlayer(String _name, String _firstName, int _level)
    {
        addPlayer(new player(_name,_firstName,_level));
    }

    public void removeplayer(int id)
    {
        m_listOfPlayer.remove(id);
    }

    public int getNbPlayer()
    {
        return m_listOfPlayer.size();
    }



    public void makeTeam()
    {
        int nbPlayer=getNbPlayer();
        int nbTeam= (nbPlayer%3 == 0) ? nbPlayer/3 : nbPlayer/3 +1;

        Collections.sort(m_listOfPlayer);

        for (int i=0;i<nbTeam;i++)
        {
            m_listOfTeam.add(new team(i+1));
        }

        int team =0,i=-1;

        for(int p=0;p<nbPlayer;p++)
        {
            m_listOfTeam.get(team).addPlayer(m_listOfPlayer.get(p));
            team++;
            if(team==nbTeam)
            {
                team=0;
            }
        }
    }

    public ArrayList<team> getListOfTeam() {
        return m_listOfTeam;
    }

    public int getNbTeam()
    {
        return m_listOfTeam.size();
    }



}


