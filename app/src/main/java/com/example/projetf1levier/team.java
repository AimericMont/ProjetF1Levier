package com.example.projetf1levier;
import java.util.ArrayList;

/*
*team class
* have list of player
 */
public class team {
    ArrayList<player> m_playerList;

    /*
    *Constructor
     */
    public team()
    {
        m_playerList= new ArrayList<player>();
    }


    public void addPlayer(player p)
    {
        m_playerList.add(p);
    }

    /*
    *getter
     */
    public ArrayList<player> getPlayerList() {
        return m_playerList;
    }
}
