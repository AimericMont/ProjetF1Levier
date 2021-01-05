package com.example.projetf1levier;
import java.io.Serializable;
import java.util.ArrayList;

/*
*team class
* have list of player
 */
public class team implements Serializable {
    ArrayList<player> m_playerList;
    int m_numberPlayerRun=0;
    int m_numberStepRun;
    long m_chronoTeam;

    /*
    *Constructor
     */
    public team()
    {
        m_playerList= new ArrayList<player>(3);
        m_numberPlayerRun =0;
    }

    public void addPlayer(player p)
    {
        m_playerList.add(p);
    }
    public void nextStepRun(player p)
    {
        if (m_numberStepRun==4)
        {
            m_numberPlayerRun++;
            m_numberStepRun=0;
        }
        else
        {
            m_numberStepRun++;
        }
    }

    /*
    *getter
     */
    public ArrayList<player> getPlayerList() {return m_playerList;}
    public int getNumberPlayerRun(){return  m_numberPlayerRun;}
    public int getNumberStepRun(){return  m_numberStepRun;}
    public long getChronoTeam(){return m_chronoTeam;}
}
