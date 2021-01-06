package com.example.projetf1levier;

import java.io.Serializable;
import java.util.ArrayList;

/*
*Class player
* have name, firstName and level
 */
public class player implements Comparable , Serializable {
    String m_name;
    String m_firstName;
    int m_level;
    ArrayList<Long> m_chronoPlayer;

    /*
    *Constructor
    * take name firstName and level of the player
     */
    public player(String _name, String _firstName, int _level)
    {
        m_name=_name;
        m_firstName=_firstName;
        m_level=_level;
        m_chronoPlayer=null;
    }

    /*
    *getter
     */
    public int getLevel() {
        return m_level;
    }
    public String getName() {
        return m_name;
    }


    public String getFullName()
    {
        return getName() + " - " + getFirstName() ;
    }

    public String getFirstName() {
        return m_firstName;
    }

    public void addChrono (long _chrono)
    {
        m_chronoPlayer.add(_chrono);
    }

    public long getChronoPlayer(int _step){return m_chronoPlayer.get(_step);}

    @Override
    public int compareTo(Object p) {
        int comparLevel=((player)p).getLevel();
        /* For Ascending order*/
        return this.m_level-comparLevel;
    }
}
