package com.example.projetf1levier;
import java.io.Serializable;
import java.util.ArrayList;

/*
*team class
* have list of player
 */
public class team implements Serializable {
    ArrayList<player> m_playerList;

    /*
    *Constructor
     */
    public team()
    {
        m_playerList= new ArrayList<player>(3);
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
